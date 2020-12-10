package com.vencedor.mdcomponents.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.recyclerview.widget.RecyclerView;

import com.vencedor.mdcomponents.R;
import com.vencedor.mdcomponents.utils.Component;
import com.vencedor.mdcomponents.utils.OnClickListener;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ComponentAdapter extends RecyclerView.Adapter<ComponentAdapter.ViewHolder>{

    private List<Component> mComponents;
    private OnClickListener mListener;

    public ComponentAdapter(List<Component> mComponents, OnClickListener mListener) {
        this.mComponents = mComponents;
        this.mListener = mListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View  view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_component, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        Component component = mComponents.get(position);
        holder.setClickListener(mListener, component);
        holder.tvName.setText(component.getName());
        holder.imgPhone.setImageResource(component.getPhotoRes());
    }

    @Override
    public int getItemCount() {
        return mComponents.size();
    }

    /*metodo para agregar nuevos elementos*/
    public void add(Component component){
        if (!mComponents.contains(component)){
            mComponents.add(component);
            notifyItemInserted(mComponents.size()-1);
        }
    }


    class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.imgPhone)
        AppCompatImageView imgPhone;
        @BindView(R.id.tvName)
        TextView tvName;

        View view;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.view = itemView;
            ButterKnife.bind(this, itemView);
        }

        void setClickListener(OnClickListener listener, Component component){
            view.setOnClickListener(v -> listener.onClick(component));
        }

    }

}
