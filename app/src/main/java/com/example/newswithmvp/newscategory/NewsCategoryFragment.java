package com.example.newswithmvp.newscategory;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.newswithmvp.Base.BaseFragment;
import com.example.newswithmvp.R;

public class NewsCategoryFragment extends BaseFragment {

    @Override
    public int getRecLayout() {
        return R.layout.fragment_newscategory;
    }

    @Override
    public void setupViews() {
        RecyclerView recyclerView=rootView.findViewById(R.id.rv_cat);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false));
        recyclerView.setAdapter(new NewsCategoryAdapter(getContext()));
    }
}
