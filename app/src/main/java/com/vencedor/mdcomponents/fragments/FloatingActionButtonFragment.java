package com.vencedor.mdcomponents.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.vencedor.mdcomponents.R;
import com.vencedor.mdcomponents.utils.Component;
import com.vencedor.mdcomponents.utils.Constants;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
/**
 * A simple {@link Fragment} subclass.
 */
public class FloatingActionButtonFragment extends Fragment {

    public static final String TAG = "Floating Action Button";
    private static Component mInstance;

    Unbinder mUnbinder;
    @BindView(R.id.fabdefault)
    FloatingActionButton fabdefault;
    @BindView(R.id.fablegacy)
    FloatingActionButton fablegacy;
    @BindView(R.id.containerMain)
    ConstraintLayout containerMain;
    @BindView(R.id.tvlegacy)
    TextView tvlegacy;

    public static Component getmInstance() {
        mInstance = new Component();
        mInstance.setName(TAG);
        mInstance.setPhotoRes(R.drawable.img_fab_default);
        mInstance.setType(Constants.STATIC);
        return mInstance;
    }

    public FloatingActionButtonFragment() {
        // Required empty public constructor
    }
    
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_floating_action_button, container, false);
        mUnbinder = ButterKnife.bind(this, view);

        fabdefault.setOnClickListener(view1 -> Toast.makeText(getActivity(), R.string.message_action_success, Toast.LENGTH_SHORT).show());



        fablegacy.setOnClickListener(view1 -> {
            fablegacy.setVisibility(View.GONE);
            tvlegacy.setVisibility(View.GONE);
        });

        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mUnbinder.unbind();
    }

}
