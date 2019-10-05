package com.example.revisao.views.fragment;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.revisao.R;

import org.w3c.dom.Text;

import static com.example.revisao.views.activity.HomeActivity.BANDA_KEY;

/**
 * A simple {@link Fragment} subclass.
 */
public class FotoBandaFragment extends Fragment {
    private TextView txtNomeBanda;
    private Button btnVoltar;


    public FotoBandaFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_foto_banda, container, false);

        initViews(view);

        if (!getArguments().isEmpty()) {
            String nomeBanda = getArguments().getString(BANDA_KEY);
            txtNomeBanda.setText(nomeBanda);
        }

        btnVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                replaceFragment(new BandaFragment());
            }
        });

        return view;
    }

    private void initViews(View view) {
        txtNomeBanda = view.findViewById(R.id.textViewNomeBanda);
        btnVoltar = view.findViewById(R.id.btnVoltar);
    }

    private void replaceFragment(Fragment fragment) {
        FragmentManager manager = getFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.container, fragment);
        transaction.commit();
    }

}
