package com.teamfive.trailerflix.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.teamfive.trailerflix.R;
import com.teamfive.trailerflix.model.Trailer;

import java.util.List;

public class TrailersAdapter extends RecyclerView.Adapter<TrailersAdapter.MyViewHolder> {

    List<Trailer> trailers;
    Context context;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView trailer;
        TextView trailer_category;
        TextView trailer_description;
        //TextView trailer_year;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            trailer = itemView.findViewById(R.id.trailer_title);
            trailer_description = itemView.findViewById(R.id.trailer_description);
            trailer_category = itemView.findViewById(R.id.trailer_category);
        }
    }

    public TrailersAdapter(List<Trailer> trailers, Context context) {
        this.trailers = trailers;
        this.context = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View item_list = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.adapter_trailer, viewGroup, false);
        return new MyViewHolder(item_list);
    }

    //TODO: Aqui é onde eu faria pra marcar os ja selecionados no outro projeto.
    //veria qual da lista foi passado como selecionada ao criar. (Colocar um parametro na criacao)
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        Trailer trailer = trailers.get(i);

        myViewHolder.trailer.setText(trailer.getTitle());
        myViewHolder.trailer_description.setText(trailer.getDescription());

        switch (trailer.getCategory())
        {
            case Trailer.ACAO:
                myViewHolder.trailer_category.setText("Acao");
                break;

            case Trailer.COMEDIA:
                myViewHolder.trailer_category.setText("Comedia");
                break;

            default:
                    break;
        }
    }

    @Override
    public int getItemCount() {
        return trailers.size();
    }


}
