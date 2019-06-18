package com.teamfive.trailerflix.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.teamfive.trailerflix.R;
import com.teamfive.trailerflix.model.Trailer;

import java.util.List;

public class TrailerAdapter extends RecyclerView.Adapter<TrailerAdapter.MyViewHolder>{
    private List<Trailer> trailers;

    public TrailerAdapter(List<Trailer> listaTrailers) {
        this.trailers = listaTrailers;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View itemLista = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.adapter_trailer, parent, false);

        return new MyViewHolder(itemLista);

    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        Trailer trailer = trailers.get( position );

        holder.trailerTitle.setText( trailer.getTitle() );
        holder.trailerDescription.setText( trailer.getDescription() );
        holder.trailerThumbnail.setImageResource( R.drawable.ic_arrow_white_24dp );
        if(trailer.isFavorite())
            holder.trailerFavorite.setChecked(true);
        else
            holder.trailerFavorite.setChecked(false);

    }

    @Override
    public int getItemCount() {
        return trailers.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView trailerTitle;
        private TextView trailerDescription;
        private ImageView trailerThumbnail;
        private CheckBox trailerFavorite;


        public MyViewHolder(View itemView) {
            super(itemView);
            trailerTitle = itemView.findViewById(R.id.trailer_title);
            trailerDescription = itemView.findViewById(R.id.trailer_description);
            trailerThumbnail = itemView.findViewById(R.id.trailer_thumbnail);
            trailerFavorite = itemView.findViewById(R.id.trailer_favorite);
        }
    }

}
