package com.example.clothesvillage.closet;

import android.content.Intent;
import android.view.View;

import com.example.clothesvillage.L;
import com.example.clothesvillage.R;
import com.example.clothesvillage.base.BaseFragment;
import com.example.clothesvillage.base.OnItemClickListener;
import com.example.clothesvillage.dashboard.cody.CodyRegisterActivity;
import com.example.clothesvillage.dashboard.cody.CodySelectAdapter;
import com.example.clothesvillage.dashboard.cody.CodyType;
import com.example.clothesvillage.databinding.FragmentClosetBinding;

import java.util.ArrayList;

import io.reactivex.rxjava3.core.Observable;

public class ClosetFragment extends BaseFragment<FragmentClosetBinding> {
    private CodySelectAdapter codySelectAdapter;

    @Override
    protected int layoutRes() {
        return R.layout.fragment_closet;
    }

    @Override
    protected void onViewCreated() {
        initRecyclerView();
        initCodeCategory();

        binding.ivAdd.setOnClickListener(view -> startActivity(new Intent(getActivity(), ClosetRegisterActivity.class)));
    }


    private void initRecyclerView() {
        codySelectAdapter = new CodySelectAdapter(getActivity());
        binding.rvContentCategory.setHasFixedSize(true);
        binding.rvContentCategory.setAdapter(codySelectAdapter);
    }


    private void initCodeCategory() {
        ArrayList<CodyType> dataSet = new ArrayList<>();
        dataSet.add(new CodyType("ALL", true));
        dataSet.add(new CodyType("아우터", false));
        dataSet.add(new CodyType("상의", false));
        dataSet.add(new CodyType("하의", false));
        dataSet.add(new CodyType("신발", false));
        dataSet.add(new CodyType("가방", false));
        dataSet.add(new CodyType("기타", false));

        codySelectAdapter.addItems(dataSet);
        codySelectAdapter.setOnItemClickListener(position -> {
            CodyType selectItem = codySelectAdapter.getItem(position);
            compositeDisposable.add(Observable.fromIterable(codySelectAdapter.getItemList())
                    .map(codyType -> {
                        if (selectItem.getName().equalsIgnoreCase(codyType.getName())) {
                            codyType.setSelected(true);
                        } else {
                            codyType.setSelected(false);
                        }
                        return codyType;
                    })
                    .toList()
                    .subscribe(result -> {
                        codySelectAdapter.updateItems(result);
                    }, error -> {
                        L.e("::::e " + error);
                    }));
        });
    }


}
