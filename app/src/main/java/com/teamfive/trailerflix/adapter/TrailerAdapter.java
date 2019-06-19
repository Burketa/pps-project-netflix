package com.teamfive.trailerflix.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.teamfive.trailerflix.R;
import com.teamfive.trailerflix.model.Trailer;

import java.util.List;

public class TrailerAdapter extends RecyclerView.Adapter<TrailerAdapter.MyViewHolder>{
    private List<Trailer> trailers;
    private List<Trailer> trailersList;
    private Context context;

    public TrailerAdapter(List<Trailer> listaTrailers, Context context) {
        this.trailers = listaTrailers;
        this.context = context;
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
        //holder.trailerThumbnail.setImageResource( R.drawable.ic_arrow_white_24dp );

        Glide
                .with(context)
                .load("https://img.youtube.com/vi/"+ trailer.getTrailerYoutubeId() +"/0.jpg")
                .centerCrop()
                .placeholder(R.drawable.ic_editar_vermelho_24dp)
                .into(holder.trailerThumbnail);

        if(trailer.isFavorite())
            holder.trailerFavorite.setChecked(true);
        else
            holder.trailerFavorite.setChecked(false);

    }

    @Override
    public int getItemCount() {
        return trailers.size();
    }

    /*public Filter getFilter() {
        return new Filter() {

            @Override
            protected FilterResults performFiltering(CharSequence constraint) {
                final FilterResults oReturn = new FilterResults();
                final List<Trailer> results = new ArrayList<>();
                if (trailersList == null)
                    trailersList = trailers;
                if(constraint == null || constraint.length() == 0){
                    oReturn.values = trailersList;
                } else {
                    if (trailersList != null && !trailersList.isEmpty()) {
                        for (final Trailer trailer : trailersList) {
                            if (trailer.getTitle().contains(constraint))
                                results.add(trailer);
                        }
                    }
                    oReturn.values = results;
                }
                return oReturn;
            }

            @SuppressWarnings("unchecked")
            @Override
            protected void publishResults(CharSequence constraint,
                                          FilterResults results) {
                trailers = (ArrayList<Trailer>) results.values;
                notifyDataSetChanged();
                //listener.recebeListaFiltro(listaContratos.isEmpty());
            }
        };
    }*/

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
