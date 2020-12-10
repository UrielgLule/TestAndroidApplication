package com.vencedor.mdcomponents.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.buildware.widget.indeterm.IndeterminateCheckBox;
import com.vencedor.mdcomponents.R;
import com.vencedor.mdcomponents.utils.Component;
import com.vencedor.mdcomponents.utils.Constants;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class CheckBoxFragment extends Fragment {

    public static final String TAG = "Check Box";
    private static Component mInstance;

    Unbinder mUnbinder;
    @BindView(R.id.cbE)
    CheckBox cbE;
    @BindView(R.id.cbeinderterminate)
    IndeterminateCheckBox cbeinderterminate;

    public static Component getmInstance() {
        mInstance = new Component();
        mInstance.setName(TAG);
        mInstance.setPhotoRes(R.drawable.img_checkboxes);
        mInstance.setType(Constants.SCROLL);
        return mInstance;
    }

    public CheckBoxFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_check_box, container, false);
        mUnbinder = ButterKnife.bind(this, view);

        cbE.setOnClickListener(view1 -> {
            String status = cbE.isChecked()? "Activo" : "Inactivo";
            Toast.makeText(getActivity(), status, Toast.LENGTH_SHORT).show();

            cbeinderterminate.setIndeterminate(cbE.isChecked());
        });

        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mUnbinder.unbind();
    }
}
