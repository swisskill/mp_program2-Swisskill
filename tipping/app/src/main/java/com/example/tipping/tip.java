package com.example.tipping;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class tip extends Fragment {

    private TipViewModel mViewModel;

    public static tip newInstance() {
        return new tip();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View myView = inflater.inflate(R.layout.fragment_tip, container, false);
        mViewModel = new ViewModelProvider(requireActivity()).get(TipViewModel.class);

        return myView;
    }


    }
