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

import com.example.taptap.databinding.ActivityMainBinding;
import com.example.taptap.home.HomeFragment;
import com.example.taptap.message.MessageFragment;
import com.example.taptap.profile.ProfileFragment;
import com.example.taptap.shop.ShopFragment;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.bottomNavigationView.setBackground(null);

        replaceFragment(new HomeFragment());

        binding.bottomNavigationView.setOnItemSelectedListener(item -> {
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