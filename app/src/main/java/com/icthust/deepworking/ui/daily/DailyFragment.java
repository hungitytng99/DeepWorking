package com.icthust.deepworking.ui.daily;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.icthust.deepworking.R;

public class DailyFragment extends Fragment {

    private DailyViewModel dailyViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        dailyViewModel =
                ViewModelProviders.of(this).get(DailyViewModel.class);
        View root = inflater.inflate(R.layout.fragment_daily, container, false);
        return root;
    }
}