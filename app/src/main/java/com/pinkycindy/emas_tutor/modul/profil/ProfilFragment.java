package com.pinkycindy.emas_tutor.modul.profil;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.pinkycindy.emas_tutor.Base.BaseFragment;
import com.pinkycindy.emas_tutor.R;
import com.pinkycindy.emas_tutor.data.source.local.SessionManager;

import java.util.HashMap;

/**
 * Created by Pinky Cindy
 */
public class ProfilFragment extends BaseFragment {

    SessionManager session;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profil, container, false);
        session = new SessionManager(getContext());
        session.checkLogin();
        HashMap<String, String> user = session.getUserDetails();
        String name = user.get(SessionManager.KEY_NAMA);
        Toast.makeText(getContext(), name, Toast.LENGTH_SHORT).show();

        return view;
    }
}