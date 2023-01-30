package com.example.cvecaraprojekat.project.Activity.Helper;

import android.content.Context;
import android.widget.Toast;

import com.example.cvecaraprojekat.project.Activity.Domain.FlowerDomain;
import com.example.cvecaraprojekat.project.Activity.Interface.ChangeNumberListener;

import java.util.ArrayList;

public class ManagmentCart {
    private Context context;
    private DB tinyDB;


    public ManagmentCart(Context context) {
        this.context = context;
        this.tinyDB = new DB(context);
    }

    public void insertFlower(FlowerDomain item) {
        ArrayList<FlowerDomain> listFlower = getListCart();
        boolean existAlready = false;
        int n = 0;
        for (int i =0; i <listFlower.size();i++){
            if(listFlower.get(i).getTitle().equals(item.getTitle())){
                existAlready=true;
                n=i;
                break;
            }
        }

        if(existAlready){
            listFlower.get(n).setNumberInCart(item.getNumberInCart());
        }
        else {
            listFlower.add(item);
        }
        tinyDB.putListObject("CardList", listFlower);
        Toast.makeText(context, "Dodaj u korpu", Toast.LENGTH_SHORT).show();
    }


    public ArrayList<FlowerDomain> getListCart() {
        return tinyDB.getListObject("KorpaLista");
    }

    public void plusNumberFlower(ArrayList<FlowerDomain> listFlower, int position, ChangeNumberListener changeNumberListener){
        listFlower.get(position).setNumberInCart(listFlower.get(position).getNumberInCart()+1);
        tinyDB.putListObject("KorpaLista",listFlower);
        changeNumberListener.changed();
    }

    public void minusNumberFlower(ArrayList<FlowerDomain> listFlower, int position, ChangeNumberListener changeNumberListener){
        if(listFlower.get(position).getNumberInCart()==1){
            listFlower.remove(position);
        }
        else {
            listFlower.get(position).setNumberInCart(listFlower.get(position).getNumberInCart()-1);
        }
        tinyDB.putListObject("KorpaLista",listFlower);
        changeNumberListener.changed();
    }

    public Double getTotalFree(){
        ArrayList<FlowerDomain>listFlower=getListCart();
        double fee=0;
        for(int i=0; i<listFlower.size();i++){
            fee=fee+(listFlower.get(i).getFee()*listFlower.get(i).getNumberInCart());
        }
        return fee;
    }

}

