package com.example.ciclovidafragment;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class CicloFragment extends Fragment {


    public CicloFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        Log.i("Ciclo", "Fragment: Metodo onAttach()");
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i("Ciclo","Fragment: Metodo onCreate()" );
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        Log.i("Ciclo", "Fragment: Metodo onCreateView()");
        return inflater.inflate(R.layout.fragment_ciclo, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.i("Ciclo", "Fragment: Metodo onActivityCreated()");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.i("Ciclo", "Fragment: Metodo onStart()");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.i("Ciclo", "Fragment: Metodo onResume()");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.i("Ciclo", "Fragment: Metodo onPause()");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.i("Ciclo", "Fragment: Metodo onStop()");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.i("Ciclo", "Fragment: Metodo onDestroyView()");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i("Ciclo", "Fragment: Metodo onDestroy()");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.i("Ciclo", "Fragment: Metodo onDetach()");
    }

}
