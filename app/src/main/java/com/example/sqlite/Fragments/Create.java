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

public class Create extends Fragment {

    private DatabaseHelper dbHelper;
    private OnFragmentInteractionListener mListener;
    private EditText db_name; // Make this a class variable

    public interface OnFragmentInteractionListener {
        void onFragmentAButtonClicked();
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString() + " must implement OnFragmentInteractionListener");
        }

        dbHelper = new DatabaseHelper(context);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_create, container, false);

        // Initialize the EditText
        db_name = view.findViewById(R.id.db_name);

        Button button = view.findViewById(R.id.button);
        button.setOnClickListener(v -> {
            String db_name_string = db_name.getText().toString();
            dbHelper.createTable(db_name_string);
            Toast.makeText(getContext(), "Table created successfully", Toast.LENGTH_SHORT).show();
        });

        return view;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }
}
