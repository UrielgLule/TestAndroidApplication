package com.vencedor.mdcomponents;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.vencedor.mdcomponents.adapters.ComponentAdapter;
import com.vencedor.mdcomponents.fragments.ButtonFragment;
import com.vencedor.mdcomponents.fragments.ButtonNavigationBarFragment;
import com.vencedor.mdcomponents.fragments.CheckBoxFragment;
import com.vencedor.mdcomponents.fragments.FloatingActionButtonFragment;
import com.vencedor.mdcomponents.fragments.SnackBarFragment;
import com.vencedor.mdcomponents.fragments.TextFieldFragment;
import com.vencedor.mdcomponents.utils.Component;
import com.vencedor.mdcomponents.utils.Constants;
import com.vencedor.mdcomponents.utils.OnClickListener;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements OnClickListener {

    @BindView(R.id.recyclerview)
    RecyclerView recyclerview;

    private ComponentAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        configAdapter();
        configRecyclerView();
    } ///Fin del onCreate///

    private void configRecyclerView() {

        recyclerview.setAdapter(mAdapter);
    }

    private void configAdapter() {
        mAdapter = new ComponentAdapter(new ArrayList<>(), this);
        mAdapter.add(ButtonFragment.getmInstance());
        mAdapter.add(ButtonNavigationBarFragment.getmInstance());
        mAdapter.add(SnackBarFragment.getmInstance());
        mAdapter.add(TextFieldFragment.getmInstance());
        mAdapter.add(FloatingActionButtonFragment.getmInstance());
        mAdapter.add(CheckBoxFragment.getmInstance());
    }


    /*
    * PROVIENE DE UN OnClickListener
    * */
    @Override
    public void onClick(Component component) {
        Intent intent;
        if (component.getType() == Constants.SCROLL){
            intent = new Intent(this, ScrollingActivity.class);
        } else {
            intent = new Intent(this, StaticActivity.class);
        }

        intent.putExtra(Constants.ARG_NAME, component.getName());
        startActivity(intent);
    }
}
