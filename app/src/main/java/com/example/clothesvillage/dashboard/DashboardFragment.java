package com.example.clothesvillage.dashboard;

import android.content.Intent;

import com.example.clothesvillage.L;
import com.example.clothesvillage.R;
import com.example.clothesvillage.base.BaseFragment;
import com.example.clothesvillage.dashboard.cody.CodyRegisterActivity;
import com.example.clothesvillage.databinding.FragmentDashboardBinding;

public class DashboardFragment extends BaseFragment<FragmentDashboardBinding> {



    @Override
    protected int layoutRes() {
        return R.layout.fragment_dashboard;
    }

    @Override
    protected void onViewCreated() {
        L.i("::::DashboardFragment");
        binding.ivAdd.setOnClickListener(view -> startActivity(new Intent(getActivity(), CodyRegisterActivity.class)));
    }

}
