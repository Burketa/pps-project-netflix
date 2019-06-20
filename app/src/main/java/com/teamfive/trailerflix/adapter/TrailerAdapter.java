package com.teamfive.trailerflix.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.teamfive.trailerflix.R;
import com.teamfive.trailerflix.model.Trailer;

import java.util.List;

public class TrailerAdapter extends RecyclerView.Adapter<TrailerAdapter.MyViewHolder> {
    private List<Trailer> trailers;
    private List<Trailer> trailersList;
    private Context context;
    private MyListener listener;

    public interface MyListener {
        void onClick(int position);

        void onFavoriteClick(int position);

        void onFeedbackPositiveClick(View view, int position);

        void onFeedbackNegativeClick(View view, int position);
    }

    public void setMyListener(MyListener listener)
    {
        this.listener = listener;
    }

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

        Trailer trailer = trailers.get(position);

        holder.trailerTitle.setText(trailer.getTitle());
        holder.trailerDescription.setText(trailer.getDescription());

        Glide
                .with(context)
                .load("https://img.youtube.com/vi/" + trailer.getTrailerYoutubeId() + "/0.jpg")
                .centerCrop()
                .placeholder(R.drawable.ic_editar_vermelho_24dp)
                .into(holder.trailerThumbnail);

        if (trailer.isFavorite())
            holder.trailerFavorite.setChecked(true);
        else
            holder.trailerFavorite.setChecked(false);

        if (trailer.getFeedback())
            holder.trailerFeedbackPositive.setChecked(true);
        else
            holder.trailerFeedbackNegative.setChecked(true);

        setListeners(holder, listener, position);

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
        private RadioGroup trailerFeedback;
        private RadioButton trailerFeedbackPositive;
        private RadioButton trailerFeedbackNegative;


        public MyViewHolder(View itemView) {
            super(itemView);
            trailerThumbnail = itemView.findViewById(R.id.trailer_thumbnail);
            trailerTitle = itemView.findViewById(R.id.trailer_title);
            trailerDescription = itemView.findViewById(R.id.trailer_description);

            trailerFeedback = itemView.findViewById(R.id.trailer_feedback);
            trailerFeedbackPositive = itemView.findViewById(R.id.trailer_feedback_positive);;
            trailerFeedbackNegative = itemView.findViewById(R.id.trailer_feedback_negative);;

            trailerFavorite = itemView.findViewById(R.id.trailer_favorite);
        }
    }

    public void setListeners(MyViewHolder holder, final MyListener listener, final int position) {
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null)
                    listener.onClick(position);
            }
        });

        holder.trailerFavorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null)
                    listener.onFavoriteClick(position);
            }

        });

        holder.trailerFeedbackPositive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null)
                    listener.onFeedbackPositiveClick(v, position);
            }
        });

        holder.trailerFeedbackNegative.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null)
                    listener.onFeedbackNegativeClick(v, position);
            }
        });

    }

}
