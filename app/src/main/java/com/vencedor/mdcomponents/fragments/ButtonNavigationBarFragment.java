package com.vencedor.mdcomponents.fragments;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.vencedor.mdcomponents.R;
import com.vencedor.mdcomponents.utils.Component;
import com.vencedor.mdcomponents.utils.Constants;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class ButtonNavigationBarFragment extends Fragment {

    public static final String TAG = "Botton Navigation";
    private static Component mInstance;

    Unbinder mUnbinder;
    @BindView(R.id.bottomNavigation)
    BottomNavigationView bottomNavigation;

    public static Component getmInstance() {
        mInstance = new Component();
        mInstance.setName(TAG);
        mInstance.setPhotoRes(R.drawable.img_bottomnav_mobile_portrait);
        mInstance.setType(Constants.STATIC);
        return mInstance;
    }

    public ButtonNavigationBarFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_button_navigation_bar, container, false);
        mUnbinder = ButterKnife.bind(this, view);

        bottomNavigation.getOrCreateBadge(R.id.action_favorites);
        //bottomNavigation.removeBadge(R.id.action_favorites);

        BadgeDrawable favoritesBadge = bottomNavigation.getOrCreateBadge(R.id.action_start);
        favoritesBadge.setNumber(21);

        BadgeDrawable profile = bottomNavigation.getOrCreateBadge(R.id.action_profile);
        profile.setNumber(1000);
        profile.setMaxCharacterCount(3);
        profile.setBackgroundColor(Color.GREEN);
        profile.setBadgeTextColor(Color.WHITE);

        return view;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mUnbinder.unbind();
    }
}
