package com.vencedor.mdcomponents.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.vencedor.mdcomponents.R;
import com.vencedor.mdcomponents.utils.Component;
import com.vencedor.mdcomponents.utils.Constants;

import butterknife.Unbinder;


/**
 * A simple {@link Fragment} subclass.
 */
public class ButtonFragment extends Fragment {

    public  static  final String TAG = "Button";
    private static Component mInstance;

    Unbinder mUnbinder;
    public static Component getmInstance(){
        mInstance = new Component();
        mInstance.setName(TAG);
        mInstance.setPhotoRes(R.drawable.img_button);
        mInstance.setType(Constants.SCROLL);
        return mInstance;
    }

    public ButtonFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_button, container, false);
    }
}
