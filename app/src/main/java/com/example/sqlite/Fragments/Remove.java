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

public class Remove extends Fragment {

    DatabaseHelper dbHelper;
    private OnFragmentInteractionListener mListener;

    public interface OnFragmentInteractionListener {
        void onFragmentCButtonClicked();
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
        View view = inflater.inflate(R.layout.activity_remove, container, false);

        Button button = view.findViewById(R.id.button3);
        button.setOnClickListener(v -> {
//            if (mListener != null) {
//                mListener.onFragmentCButtonClicked();
//
//            }
            EditText table = view.findViewById(R.id.table);
            EditText id = view.findViewById(R.id.id);

            dbHelper.deleteRecord(table.getText().toString(),Integer.parseInt(id.getText().toString()));
            Toast.makeText(getContext(),"Record deleted",Toast.LENGTH_SHORT).show();

        });

        return view;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }
}