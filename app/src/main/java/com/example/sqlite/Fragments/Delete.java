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

public class Delete extends Fragment {

    DatabaseHelper dbHelper;
    private OnFragmentInteractionListener mListener;

    public interface OnFragmentInteractionListener {
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
        View view = inflater.inflate(R.layout.activity_delete, container, false);

        Button button = view.findViewById(R.id.button2);
        button.setOnClickListener(v -> {
            EditText table = view.findViewById(R.id.table);

            dbHelper.deleteTable(table.getText().toString());
            Toast.makeText(getActivity(), "Table deleted", Toast.LENGTH_SHORT).show();
        });

        return view;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }
}
