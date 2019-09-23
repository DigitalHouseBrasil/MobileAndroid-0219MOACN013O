package com.example.carrosfamosos.view;


import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.carrosfamosos.R;
import com.example.carrosfamosos.model.Carro;

import static com.example.carrosfamosos.view.CarrosActivity.CARRO_KEY;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentCarro extends Fragment {
    private ImageView imgCarro;
    private TextView textCarro;



    public FragmentCarro() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fragment_carro, container, false);
        initView(view);

        if(!getArguments().isEmpty()){

            Carro carro = getArguments().getParcelable(CARRO_KEY);

            if(carro != null){

                Drawable drawable = getResources().getDrawable(carro.getImage());
                imgCarro.setImageDrawable(drawable);
                textCarro.setText(carro.getNome());
            }
        }
        return view;
    }

    public void initView(View view){
        imgCarro = view.findViewById(R.id.img_carro);
        textCarro = view.findViewById(R.id.text_carro);
    }

}
