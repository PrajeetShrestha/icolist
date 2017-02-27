package com.games.radical.icolist.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.games.radical.icolist.R;
import com.games.radical.icolist.model.IcoModel;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by prajeetshrestha on 2/14/17.
 */

public class ListRecycleViewAdapter extends RecyclerView.Adapter<ListRecycleViewAdapter.ViewHolder> {
    ArrayList<IcoModel> list;

    public ListRecycleViewAdapter(ArrayList<IcoModel> list) {
        this.list = list;
    }

    private ViewGroup prnt;


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        prnt = parent;
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.ico_list_item, parent, false);
        ViewHolder holder = new ViewHolder(v);

        return holder;
    }


    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        IcoModel m = this.list.get(position);
        holder.itemName.setText(m.name);
        holder.openingDate.setText(m.openingDate);
        holder.closingDate.setText(m.closingDate);
        Glide.with(prnt.getContext())
                .load(m.imageUrl)
                .centerCrop()
                .crossFade()
                .into(holder.itemImage)
        ;
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return 1;
        } else {
            return 2;
        }
        //return super.getItemViewType(position);
    }

    @Override
    public int getItemCount() {
        return this.list.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView itemImage;
        private TextView itemName;
        private TextView openingDate;
        private TextView closingDate;

        private ViewHolder(View itemView) {
            super(itemView);
            itemImage = (ImageView) itemView.findViewById(R.id.itemImageView);
            itemName = (TextView) itemView.findViewById(R.id.item_name);
            openingDate = (TextView) itemView.findViewById(R.id.item_opening_date);
            closingDate = (TextView) itemView.findViewById(R.id.item_closing_date);
        }
    }
}
