package com.pinkycindy.emas_tutor.modul.main;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.pinkycindy.emas_tutor.Base.BaseFragment;
import com.pinkycindy.emas_tutor.R;

/**
 * Created by Pinky Cindy
 */
public class HomeFragment extends BaseFragment{

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        return view;
    }
}