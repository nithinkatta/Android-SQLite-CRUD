package com.example.sqlite.Fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.sqlite.DatabaseHelper;
import com.example.sqlite.R;

public class Update extends Fragment {

    private OnFragmentInteractionListener mListener;
    private DatabaseHelper dbHelper;
    EditText table ;
    EditText name ;
    EditText age ;
    public interface OnFragmentInteractionListener {
        void onFragmentDButtonClicked();
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString() + " must implement OnFragmentInteractionListener");
        }
        dbHelper = new DatabaseHelper(getActivity());
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_update, container, false);

        EditText table = view.findViewById(R.id.table);
        EditText name = view.findViewById(R.id.name);
        EditText age = view.findViewById(R.id.age);

        Button button = view.findViewById(R.id.button4);
        button.setOnClickListener(v -> {

            System.out.println(table.getText().toString());
            System.out.println(name.getText().toString());
            System.out.println(age.getText().toString());

            String t = table.getText().toString();
            String n = name.getText().toString();
            int a = Integer.parseInt(age.getText().toString());

            dbHelper.insertRecord(t,n,a);
//            dbHelper.getAllRecords(R.layout.activity_main);
            Toast.makeText(getActivity(), "Record Updated", Toast.LENGTH_SHORT).show();

            
        });

        return view;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }
}