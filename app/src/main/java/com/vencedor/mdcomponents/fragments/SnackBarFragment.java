package com.vencedor.mdcomponents.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import androidx.fragment.app.Fragment;

import com.google.android.material.snackbar.Snackbar;
import com.vencedor.mdcomponents.R;
import com.vencedor.mdcomponents.utils.Component;
import com.vencedor.mdcomponents.utils.Constants;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class SnackBarFragment extends Fragment {

    public static final String TAG = "SnackBar";
    private static Component mInstance;

    Unbinder mUnbinder;
    @BindView(R.id.containerName)
    FrameLayout containerName;

    public static Component getmInstance() {
        mInstance = new Component();
        mInstance.setName(TAG);
        mInstance.setPhotoRes(R.drawable.img_singleline_action);
        mInstance.setType(Constants.STATIC);
        return mInstance;
    }

    public SnackBarFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_snack_bar, container, false);
        mUnbinder = ButterKnife.bind(this, view);

        Snackbar.make(containerName, R.string.message_action_success, Snackbar.LENGTH_LONG)
                .setAction("Volver", v -> getActivity().finish())
                .show();

        

        return view;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mUnbinder.unbind();
    }
}
