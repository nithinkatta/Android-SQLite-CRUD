package com.example.sqlite;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sqlite.Fragments.Create;
import com.example.sqlite.Fragments.Delete;
import com.example.sqlite.Fragments.Remove;
import com.example.sqlite.Fragments.Update;
import com.example.sqlite.RecyclerView.MyAdapter;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity implements Create.OnFragmentInteractionListener, Remove.OnFragmentInteractionListener, Delete.OnFragmentInteractionListener, Update.OnFragmentInteractionListener {
    private DatabaseHelper dbHelper;
    private RecyclerView recyclerView;
    private MyAdapter myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dbHelper = new DatabaseHelper(this);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

//         Insert a record
//        dbHelper.createTable("new");
        long id = dbHelper.insertRecord("new","Naga Nithin", 20);

        // Read all records
        StringBuilder records = new StringBuilder();
        Cursor cursor = dbHelper.getAllRecords();
        if (cursor.moveToFirst()) {
            do {
                int recordId = cursor.getInt(cursor.getColumnIndexOrThrow("id"));
                String name = cursor.getString(cursor.getColumnIndexOrThrow("name"));
                int age = cursor.getInt(cursor.getColumnIndexOrThrow("age"));
                records.append("ID: ").append(recordId).append(", Name: ").append(name).append(", Age: ").append(age).append("\n");
            } while (cursor.moveToNext());
        }
        cursor.close();

        myAdapter = new MyAdapter(Arrays.asList(records.toString().split("\n")));
        recyclerView.setAdapter(myAdapter);
    }

    @Override
    public void onFragmentAButtonClicked() {

    }
    public void createBtn(View view)
    {
        Create fragmentB = new Create();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frameLayout, fragmentB);
        transaction.addToBackStack(null);
        transaction.commit();
    }
    public void updateBtn(View view)
    {
        Update obj = new Update();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frameLayout, obj);
        transaction.addToBackStack(null);
        transaction.commit();
    }
    public void removeBtn(View view)
    {
        Remove obj = new Remove();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frameLayout, obj);
        transaction.addToBackStack(null);
        transaction.commit();
    }
    public void deleteBtn(View view)
    {
        Delete obj = new Delete();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frameLayout, obj);
        transaction.addToBackStack(null);
        transaction.commit();
    }
    @Override
    public void onFragmentBButtonClicked() {

    }

    @Override
    public void onFragmentCButtonClicked() {

    }
    @Override
    public void onFragmentDButtonClicked() {

    }

}
