package com.example.clothesvillage.mypage;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.clothesvillage.LoginActivity;
import com.example.clothesvillage.R;
import com.example.clothesvillage.SignUpActivity;
import com.example.clothesvillage.base.BaseFragment;
import com.example.clothesvillage.databinding.FragmentMypageBinding;
import com.google.firebase.auth.FirebaseAuth;

public class MypageFragment extends BaseFragment<FragmentMypageBinding> implements View.OnClickListener {
    private View view;

    @Override
    protected int layoutRes() {
        return R.layout.fragment_mypage;
    }

    @Override
    protected void onViewCreated() {

    }

    @Override
    public void onClick(View view) {

    }


//    private void startSignUpActivity() {
//        Intent intent = new Intent(getActivity(), LoginActivity.class);
//        startActivity(intent);
//    }

}
