package com.example.cvecaraprojekat.project.Activity.Adaptor;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.cvecaraprojekat.R;
import com.example.cvecaraprojekat.project.Activity.Domain.FlowerDomain;
import com.example.cvecaraprojekat.project.Activity.Helper.ManagmentCart;
import com.example.cvecaraprojekat.project.Activity.Interface.ChangeNumberListener;

import java.util.ArrayList;

public class CartListaAda extends RecyclerView.Adapter<CartListaAda.ViewHolder> {
    private ArrayList<FlowerDomain> flowerDomains;
    private ManagmentCart managmentCart;
    private ChangeNumberListener changeNumberListener;

    public CartListaAda(ArrayList<FlowerDomain> flowerDomains, Context context, ChangeNumberListener changeNumberListener) {
        this.flowerDomains = flowerDomains;
        this.managmentCart = new ManagmentCart(context);
        this.changeNumberListener = changeNumberListener;
    }

    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate= LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_cart,parent,false);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.title.setText(flowerDomains.get(position).getTitle());
        holder.feeEachItem.setText(String.valueOf(flowerDomains.get(position).getFee()));
        holder.totalEachItem.setText(String.valueOf(Math.round((flowerDomains.get(position).getNumberInCart() * flowerDomains.get(position).getFee())*100)/100));
        holder.number.setText(String.valueOf(flowerDomains.get(position).getNumberInCart()));


        int drawableReourceId=holder.itemView.getContext().getResources().getIdentifier(flowerDomains.get(position).getPic()
        , "drawable",holder.itemView.getContext().getPackageName());
        Glide.with(holder.itemView.getContext())
                .load(drawableReourceId)
                .into(holder.pic);

        holder.plusItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                managmentCart.plusNumberFlower(flowerDomains, position, new ChangeNumberListener() {
                    @Override
                    public void changed() {
                        notifyDataSetChanged();
                        changeNumberListener.changed();
                    }
                });
            }
        });
        holder.minusItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                managmentCart.minusNumberFlower(flowerDomains, position, new ChangeNumberListener() {
                    @Override
                    public void changed() {
                        notifyDataSetChanged();
                        changeNumberListener.changed();
                    }
                });
            }
        });
    }



    @Override
    public int getItemCount() {
        return flowerDomains.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView title, feeEachItem;
        ImageView pic, plusItem, minusItem;
        TextView totalEachItem, number;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title=itemView.findViewById(R.id.textView9);
            feeEachItem=itemView.findViewById(R.id.textView15);
            pic=itemView.findViewById(R.id.imageView4);
            plusItem= itemView.findViewById(R.id.imageView9);
            minusItem=itemView.findViewById(R.id.imageView5);
            totalEachItem=itemView.findViewById(R.id.textView19);
            number=itemView.findViewById(R.id.textView13);


        }
//    public ViewHolder(@NonNull ViewHolder itemView){
//        super(itemView);
//        title=itemView
//    }
    }
}
