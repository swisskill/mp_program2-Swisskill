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
import android.widget.TextView;
import android.widget.Toast;

public class tip extends Fragment {

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
        Button submit = myView.findViewById(R.id.button3);
        Button rTot = myView.findViewById(R.id.button);
        Button rTip = myView.findViewById(R.id.button2);
        Button nRod = myView.findViewById(R.id.button4);
        EditText preTot = myView.findViewById(R.id.editTextNumberDecimal);
        EditText preTip = myView.findViewById(R.id.editTextNumberDecimal2);
        TextView viewTot = myView.findViewById(R.id.textView);
        TextView viewTip = myView.findViewById(R.id.textView2);

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

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                    float fTotal;
                    float fTip;
                    if (preTot.getText().toString().isEmpty()){
                        fTotal=10;
                    }else{
                        fTotal = Float.parseFloat(preTot.getText().toString());
                    }
                    if (preTip.getText().toString().isEmpty()){
                        fTip=15;
                    }else{
                        fTip = Float.parseFloat(preTip.getText().toString());
                    }
                    if (fTip > 100){Toast.makeText(requireContext(),"Someone's feeling mighty generous. . .", Toast.LENGTH_SHORT).show();}
                    float nFTip = fTip/100;
                    double gTip = fTotal*nFTip;
                if (rtotB) {
                    double gTotal = Math.ceil((gTip)+fTotal); // where g total stands for grand total
                    gTip = Math.round(gTip*100);
                    gTip = gTip/100;
                    viewTot.setText("Total: $"+ (Double.toString(gTotal))+"0");
                    viewTip.setText("Tip: $" + (Double.toString(gTip)));
                    //Toast.makeText(requireContext(),Double.toString(gTotal)+"0", Toast.LENGTH_SHORT).show();
                } else if (rtipB){
                    double gTotal = (Math.ceil(gTip))+fTotal; // where g total stands for grand total
                    gTotal = Math.round(gTotal*100);
                    gTotal = gTotal/100;

                    gTip = Math.round(gTip*100);
                    gTip = Math.ceil(gTip/100);
                    viewTot.setText("Total: $"+ (Double.toString(gTotal)));
                    viewTip.setText("Tip: $" + (Double.toString(gTip))+"0");
                } else if (nRodB) {
                    double gTotal = gTip+fTotal; // where g total stands for grand total
                    gTotal = Math.round(gTotal*100);
                    gTotal = gTotal/100;

                    gTip = Math.round(gTip*100);
                    gTip = gTip/100;
                    viewTot.setText("Total: $"+ (Double.toString(gTotal)));
                    viewTip.setText("Tip: $" + (Double.toString(gTip)));
                }
                //Yes. I know that a lot of this can be broken up into other methods. I am running
                //short on time. I don't like it either

            }
        });

        return myView;
    }


    }
