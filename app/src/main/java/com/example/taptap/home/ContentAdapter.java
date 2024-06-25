package com.example.taptap.home;

import static android.app.PendingIntent.getActivity;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.example.taptap.MainActivity;
import com.example.taptap.R;
import com.example.taptap.data.Content;
import com.example.taptap.data.Repository;
import com.example.taptap.data.User;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.varunest.sparkbutton.SparkButton;

import java.util.List;

public class ContentAdapter extends RecyclerView.Adapter<ContentAdapter.ContentHolder> {
    @NonNull
    @Override
    public ContentHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.content_item, parent, false);
        return new ContentHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ContentHolder holder, int position) {
        if ((position & 1) == 0) {
            holder.mImageView.setImageResource(R.mipmap.bubududu);
        } else {
            holder.mImageView.setImageResource(R.mipmap.richter);
        }
        holder.mCommentButton.setOnClickListener(item->{
            final Dialog dialog = new Dialog(item.getContext());
            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
            dialog.setContentView(R.layout.bottomsheet);
            dialog.setCancelable(true);
            dialog.show();
            dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            dialog.getWindow().getAttributes().windowAnimations = R.style.AnimationBottomSheetDialog;
            dialog.getWindow().setGravity(Gravity.BOTTOM);
        });
        holder.mProfileButton.setOnClickListener(item->{
            Content content = Repository.getInstance().getContentById(position);
            if (content == null) {
                // handle error
            } else {
                User user = content.getContentOwner();
                FragmentManager fragmentManager = ((MainActivity)item.getContext()).getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.add(R.id.frame_layout, UserProfileFragment.newInstance(Integer.toString(user.getId())));
                fragmentTransaction.addToBackStack(null);
                Fragment homeFragment = fragmentManager.findFragmentByTag(HomeFragment.class.getName());
                assert homeFragment != null;
                fragmentTransaction.hide(homeFragment);
                fragmentTransaction.commit();
            }
        });
    }

    @Override
    public int getItemCount() {
        return Repository.getInstance().getContentSize();
    }

    static class ContentHolder extends RecyclerView.ViewHolder {
        ImageView mImageView;
        FloatingActionButton mCommentButton, mShareButton, mProfileButton;
        SparkButton mHeartButton;
        public ContentHolder(@NonNull View itemView) {
            super(itemView);
            mImageView = itemView.findViewById(R.id.image_view);
            mCommentButton = itemView.findViewById(R.id.comment_button);
            mShareButton = itemView.findViewById(R.id.share_button);
            mHeartButton = itemView.findViewById(R.id.heart_button);
            mProfileButton = itemView.findViewById(R.id.profile_button);
        }
    }
}
