package com.example.deepworking.ui.longterm;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.example.deepworking.R;

public class LongtermFragment extends Fragment {

    private LongtermViewModel longtermViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        longtermViewModel =
                ViewModelProviders.of(this).get(LongtermViewModel.class);
        View root = inflater.inflate(R.layout.fragment_longterm, container, false);
        return root;
    }
}