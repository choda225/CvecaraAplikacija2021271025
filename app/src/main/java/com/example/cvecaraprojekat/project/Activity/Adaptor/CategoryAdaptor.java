package com.example.cvecaraprojekat.project.Activity.Adaptor;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.cvecaraprojekat.R;
import com.example.cvecaraprojekat.project.Activity.Domain.CategoryDomain;

import java.util.ArrayList;
import java.util.Objects;

public class CategoryAdaptor extends RecyclerView.Adapter<CategoryAdaptor.ViewHolder> {

    ArrayList<CategoryDomain>categoryDomains;
    public CategoryAdaptor(ArrayList<CategoryDomain> categoryDomains){
     this.categoryDomains=categoryDomains;
    }


    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate= LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_category,parent,false);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
    holder.categoryName.setText(categoryDomains.get(position).getNaslov());
    String picUrl="";
    switch (position){
        case 0:{
            picUrl="cvet1";
            holder.mainLayout.setBackground(ContextCompat.getDrawable(holder.itemView.getContext(),R.drawable.cvet_background));
            break;
        }
        case 1:{
            picUrl="cvet2";
            holder.mainLayout.setBackground(ContextCompat.getDrawable(holder.itemView.getContext(), R.drawable.cvet_background2));
            break;
        }
        case 2:{
            picUrl="cvet3";
            holder.mainLayout.setBackground(ContextCompat.getDrawable(holder.itemView.getContext(), R.drawable.cvet_background3));
            break;
        }
        case 3:{
            picUrl="cvet4";
            holder.mainLayout.setBackground(ContextCompat.getDrawable(holder.itemView.getContext(), R.drawable.cvet_background4));
            break;}
        case 4:{
            picUrl="cvet5";
            holder.mainLayout.setBackground(ContextCompat.getDrawable(holder.itemView.getContext(), R.drawable.cvet_background5));
            break;}
    }
    int drawableResourceId=holder.itemView.getContext().getResources().getIdentifier(picUrl,"drawable"
    ,holder.itemView.getContext().getPackageName());

    Glide.with(holder.itemView.getContext())
            .load(drawableResourceId)
            .into(holder.categoryPic);

    }

    @Override
    public int getItemCount() {
        return categoryDomains.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
    TextView categoryName;
    ImageView categoryPic;
    ConstraintLayout mainLayout;

    public ViewHolder(@NonNull View itemView){
        super(Objects.requireNonNull(itemView));
        categoryName=itemView.findViewById(R.id.categoryName);
        categoryPic=itemView.findViewById(R.id.categoryPic);

    }
    }
}
