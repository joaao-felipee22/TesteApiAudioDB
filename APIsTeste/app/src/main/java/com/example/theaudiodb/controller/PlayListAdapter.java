package com.example.theaudiodb.controller;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextClock;
import android.widget.TextView;

import com.example.theaudiodb.R;
import com.example.theaudiodb.model.Pojo;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class PlayListAdapter extends RecyclerView.Adapter<PlayListAdapter.ViewPlaysList> {

    private ArrayList<Pojo> pojoList = new ArrayList<>();

    Context context;

    public PlayListAdapter(ArrayList<Pojo> pojoList, Context context) {
        this.pojoList = pojoList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewPlaysList onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater = LayoutInflater.from(viewGroup.getContext());
        View view = layoutInflater.inflate(R.layout.card_view, viewGroup, false);
        return new PlayListAdapter.ViewPlaysList(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewPlaysList viewPlaysList, int i) {
        Pojo p = pojoList.get(i);
        viewPlaysList.textView.setText(p.getStrPlaylist());
        viewPlaysList.textDescription.setText(p.getStrDescription());
       // Picasso.get().load(p.getStrImage()).into(viewPlaysList.imgView);

    }


    @Override
    public int getItemCount() {
        return pojoList.size();
    }

    public class ViewPlaysList extends RecyclerView.ViewHolder {

        CardView cardView;
        TextView textView;
        TextView textDescription;
        ImageView imgView;

        public ViewPlaysList(@NonNull View itemView) {
            super(itemView);
            cardView = (CardView) itemView.findViewById(R.id.card_view);
            textView = (TextView) itemView.findViewById(R.id.txt_viewCard);
            textDescription = (TextView) itemView.findViewById(R.id.txt_description);
            imgView = (ImageView) itemView.findViewById(R.id.img_card);
        }
    }
}
