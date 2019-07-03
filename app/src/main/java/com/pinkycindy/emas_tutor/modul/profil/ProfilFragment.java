package com.pinkycindy.emas_tutor.modul.profil;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.pinkycindy.emas_tutor.Base.BaseFragment;
import com.pinkycindy.emas_tutor.R;
import com.pinkycindy.emas_tutor.data.model.Employee;
import com.pinkycindy.emas_tutor.data.source.local.SessionManager;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Pinky Cindy
 */
public class ProfilFragment extends BaseFragment implements ProfilContract.view {

    private ProfilContract.presenter presenter;
    SessionManager sessionManager;
    private ImageView ivAvatar;
    private TextView tvName, tvEmail, tvUsername;
    private String empId;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        sessionManager = new SessionManager(getContext());
        sessionManager.checkLogin();
        HashMap<String, String> user = sessionManager.getUserDetails();
        empId = user.get(SessionManager.KEY_ID);
        presenter = new ProfilPresenter(this);


    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profil, container, false);

        tvName = view.findViewById(R.id.tv_name);
        tvEmail = view.findViewById(R.id.tv_email);
        ivAvatar = view.findViewById(R.id.iv_avatar);

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        presenter.getProfil(empId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void showProfil(ArrayList<Employee> employees) {
        if(employees.isEmpty()){

            tvName.setText("-");
            tvEmail.setText("-");
        }
        else{
           tvName.setText(employees.get(0).getName());
            tvEmail.setText(employees.get(0).getEmail());
            if(!(employees.get(0).getAvatar().equals(0))) {
                Glide.with(this).load(R.drawable.ic_home).into(ivAvatar);

            }
            else{
                Glide.with(this).load(R.drawable.ic_home).into(ivAvatar);

            }

        }

    }
}