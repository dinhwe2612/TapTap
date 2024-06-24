package com.example.taptap;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.taptap.data.Content;
import com.example.taptap.data.Repository;
import com.example.taptap.data.User;
import com.example.taptap.databinding.ActivityMainBinding;
import com.example.taptap.home.HomeFragment;
import com.example.taptap.message.MessageFragment;
import com.example.taptap.profile.ProfileFragment;
import com.example.taptap.shop.ShopFragment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding mBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(mBinding.getRoot());
        mBinding.bottomNavigationView.setBackground(null);

        Map<String, String>  nicknames = new HashMap<>();
        nicknames.put("Sparky", "Full of energy and enthusiasm.");
        nicknames.put("Ace", "A skilled and accomplished individual.");
        nicknames.put("Nova", "Bright and shining, like a star.");
        nicknames.put("Shadow", "Mysterious and elusive.");
        nicknames.put("Ghost", "Quiet and stealthy.");
        nicknames.put("Maverick", "Independent and unconventional.");
        nicknames.put("Phoenix", "Rising from adversity, strong and resilient.");
        nicknames.put("Rogue", "Playful and mischievous, with a rebellious streak.");
        nicknames.put("Echo", "A reminder of something or someone from the past.");
        nicknames.put("Whisper", "Softly spoken, secretive and intriguing.");
        for (String nickname : nicknames.keySet()) {
            User user = new User(nickname, nicknames.get(nickname));
            Content content = new Content(user);
            Repository.getInstance().addUser(user);
            Repository.getInstance().addContent(content);
        }

        replaceFragment(new HomeFragment());

        mBinding.bottomNavigationView.setOnItemSelectedListener(item -> {
            int idItem = item.getItemId();
            if (idItem == R.id.home_menu) {
                replaceFragment(new HomeFragment());
            } else if (idItem == R.id.shopping_menu) {
                replaceFragment(new ShopFragment());
            } else if (idItem == R.id.message_menu) {
                replaceFragment(new MessageFragment());
            } else if (idItem == R.id.profile_menu) {
                replaceFragment(new ProfileFragment());
            }
            return true;
        });
    }

    private void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame_layout, fragment);
        fragmentTransaction.commit();
    }
}