package com.vencedor.mdcomponents.utils;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.vencedor.mdcomponents.fragments.ButtonFragment;
import com.vencedor.mdcomponents.fragments.ButtonNavigationBarFragment;
import com.vencedor.mdcomponents.fragments.CheckBoxFragment;
import com.vencedor.mdcomponents.fragments.FloatingActionButtonFragment;
import com.vencedor.mdcomponents.fragments.SnackBarFragment;
import com.vencedor.mdcomponents.fragments.TextFieldFragment;


public class CommonUtils {

public static void setFragment(AppCompatActivity activity, String nameFragment, int contentRes){
    Fragment fragment = getFragmentById(nameFragment);
    activity.getSupportFragmentManager().beginTransaction()
            .add(contentRes, fragment)
            .commit();
}

    private static Fragment getFragmentById(String nameFragment) {
        Fragment fragment = null;

        switch (nameFragment){

            //Scroll
            case ButtonFragment.TAG:
                fragment = new ButtonFragment();
            break;

            case TextFieldFragment.TAG:
                fragment = new TextFieldFragment();
            break;

            case CheckBoxFragment.TAG:
            fragment = new CheckBoxFragment();
            break;

            //static
            case ButtonNavigationBarFragment.TAG:
                fragment = new ButtonNavigationBarFragment();
            break;

            case SnackBarFragment.TAG:
                fragment = new SnackBarFragment();
            break;

            case FloatingActionButtonFragment.TAG:
                fragment = new FloatingActionButtonFragment();
            break;

        }

        return fragment;

    }

}
