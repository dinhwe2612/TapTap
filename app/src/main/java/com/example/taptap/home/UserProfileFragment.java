package com.example.taptap.home;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.taptap.MainActivity;
import com.example.taptap.R;
import com.example.taptap.data.Repository;
import com.example.taptap.data.User;
import com.example.taptap.databinding.FragmentUserProfileBinding;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link UserProfileFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class UserProfileFragment extends Fragment {
    private static final String ARG_PARAM = "UserID";

    private String mParam;

    FragmentUserProfileBinding mBinding;

    private UserProfileFragment() {
        // Required empty public constructor
    }

    public static UserProfileFragment newInstance(String param) {
        UserProfileFragment fragment = new UserProfileFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM, param);
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mBinding = FragmentUserProfileBinding.inflate(inflater, container, false);
        if (getArguments() != null) {
            mParam = getArguments().getString(ARG_PARAM);
        }
        User user = Repository.getInstance().getUserById(Integer.parseInt(mParam));
        mBinding.useridTextview.setText("User ID: " + Integer.toString(user.getId()));
        mBinding.descriptionTextview.setText(user.getDescription());
        mBinding.nameTextview.setText(user.getNickname());

        mBinding.backButton.setOnClickListener(item->{
            FragmentManager fragmentManager = (getActivity()).getSupportFragmentManager();// must be fragmentmanager of the activity
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.frame_layout, new HomeFragment());
            fragmentTransaction.commit();
        });
        return mBinding.getRoot();
    }
}