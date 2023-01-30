package com.example.cvecaraprojekat.project.Activity.Adaptor;


import android.annotation.SuppressLint;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.cvecaraprojekat.R;
import com.example.cvecaraprojekat.project.Activity.Activities.PrikazDetaljaActivity;
import com.example.cvecaraprojekat.project.Activity.Domain.FlowerDomain;

import java.util.ArrayList;
import java.util.Objects;

public class PopularAdaptor extends RecyclerView.Adapter<PopularAdaptor.ViewHolder> {

    ArrayList<FlowerDomain>categoryFlower;
    public PopularAdaptor(ArrayList<FlowerDomain> categoryDomains){
     this.categoryFlower=categoryDomains;
    }


    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate= LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_popular,parent,false);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {
    holder.title.setText(categoryFlower.get(position).getTitle());
    holder.fee.setText(String.valueOf(categoryFlower.get(position).getFee()));

    int drawableResourceId=holder.itemView.getContext().getResources().getIdentifier(categoryFlower.get(position).getPic(),"drawable"
    ,holder.itemView.getContext().getPackageName());

    Glide.with(holder.itemView.getContext())
            .load(drawableResourceId)
            .into(holder.pic);

    holder.addBtn.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent=new Intent(holder.itemView.getContext(), PrikazDetaljaActivity.class);
            intent.putExtra("object", categoryFlower.get(position));
            holder.itemView.getContext().startActivity(intent);
        }
    });
    }

    @Override
    public int getItemCount() {
        return categoryFlower.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
    TextView title, fee;
    ImageView pic;
    TextView addBtn;

        public ViewHolder(@NonNull View itemView){
        super(Objects.requireNonNull(itemView));
        title=itemView.findViewById(R.id.title);
        fee=itemView.findViewById(R.id.fee);
        pic=itemView.findViewById(R.id.pic);
        addBtn=itemView.findViewById(R.id.addBtn);

    }
    }
}
