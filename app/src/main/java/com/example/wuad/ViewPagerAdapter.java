package com.example.wuad;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import Fragments.genera_debate;
import Fragments.perfil_user;

public class ViewPagerAdapter extends FragmentStateAdapter {
    public ViewPagerAdapter(@NonNull MainActivity fragment) {
        super(fragment);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position){
            case 0:
                return new perfil_user();
            case 1:
                return new genera_debate();
            default:
                return null;

        }
    }

    @Override
    public int getItemCount() {
        return 2;
    }
}
