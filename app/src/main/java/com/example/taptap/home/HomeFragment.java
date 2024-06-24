package com.example.taptap.home;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSnapHelper;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.taptap.databinding.FragmentHomeBinding;


public class HomeFragment extends Fragment {
    FragmentHomeBinding mBinding;
    LinearSnapHelper snapHelper;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mBinding = FragmentHomeBinding.inflate(inflater, container, false);
        mBinding.recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mBinding.recyclerView.setAdapter(new ContentAdapter());

        snapHelper = new LinearSnapHelper();
        snapHelper.attachToRecyclerView(mBinding.recyclerView);
        return mBinding.getRoot();
    }
}