package com.example.tipping;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class tip extends Fragment {

    private TipViewModel mViewModel;
    boolean rtotB = false; //ATTN: Hey jim is this a good place for these bools? is this good log?
    boolean rtipB = false; //rtot is rtotal boolean and rtip is rtip boolean
    boolean nRodB = true; // stands for no round boolean

    public static tip newInstance() {
        return new tip();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View myView = inflater.inflate(R.layout.fragment_tip, container, false);
        mViewModel = new ViewModelProvider(requireActivity()).get(TipViewModel.class);
        Button submit = myView.findViewById(R.id.button3);
        Button rTot = myView.findViewById(R.id.button);
        Button rTip = myView.findViewById(R.id.button2);
        Button nRod = myView.findViewById(R.id.button4);
        EditText preTot = myView.findViewById(R.id.editTextNumberDecimal);
        EditText preTip = myView.findViewById(R.id.editTextNumberDecimal2);

        rTot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rtotB = true;
                rtipB = false;
                nRodB = false;
                Toast.makeText(requireContext(),"You have selected to round total bill to near dollar", Toast.LENGTH_SHORT).show();
            }
        });
        rTip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rtotB = false;
                rtipB = true;
                nRodB = false;
                Toast.makeText(requireContext(),"You have selected to round the tip to near dollar", Toast.LENGTH_SHORT).show();
            }
        });
        nRod.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rtotB = false;
                rtipB = false;
                nRodB = true;
                Toast.makeText(requireContext(),"You have selected to not round. GUILT! SHAME!", Toast.LENGTH_SHORT).show();
            }
        });
//
//        submit.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v){
////                mViewModel.setItem(preTip); //ah gotta make this take a float not a string
////                mViewModel.setItem(preTot); //same here
//                //we probably need to store the info in a variable to do the calculations
//
//                //if
//
//            }
//        });


        return myView;
    }


    }
