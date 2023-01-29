package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.myapplication.fragments.BusinessProfile;
import com.example.myapplication.fragments.CreateBundle;
import com.example.myapplication.fragments.CurrentPack;
import com.example.myapplication.fragments.EditBundles;
import com.example.myapplication.fragments.HomeFragment;
import com.example.myapplication.fragments.ProfileFragment;

public class MyViewPagerAdapter2 extends FragmentStateAdapter {

    public MyViewPagerAdapter2(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }
    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 0:
                return new CreateBundle();
            case 1:
                return new EditBundles();
            case 2:
                return new BusinessProfile();
            default:
                return new CreateBundle();
        }
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}
