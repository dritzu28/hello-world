package adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.itzuvillarce.gittestproject.R;

import java.util.ArrayList;
import java.util.List;

import model.Perro;

/**
 * Created by itzu.villarce on 23/10/16.
 */

public class CardViewAdaper extends RecyclerView.Adapter<CardViewAdaper.ViewHolder> {

    List<Perro> list =  new ArrayList<>();

    public CardViewAdaper(List<Perro> list){
        this.list = list;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view, parent, false);

        return new ViewHolder(itemView);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public Perro getItem(int i){
        return list.get(i);
    }

    @Override
    public void onBindViewHolder(CardViewAdaper.ViewHolder holder, int position) {
        holder.perro = getItem(position);
        holder.cardtitle.setText(list.get(position).getName());
        holder.cardimage.setImageResource(list.get(position).getId());
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        ImageView cardimage;
        TextView cardtitle;
        Perro perro;

        public ViewHolder(View itemView){
            super(itemView);

            cardimage = (ImageView) itemView.findViewById(R.id.img_card_view);
            cardtitle = (TextView) itemView.findViewById(R.id.txt_card_view);

        }
    }

}
