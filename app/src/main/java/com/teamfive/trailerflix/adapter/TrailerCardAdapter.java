package com.teamfive.trailerflix.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.teamfive.trailerflix.R;
import com.teamfive.trailerflix.model.Trailer;

import java.util.List;

public class TrailerCardAdapter extends RecyclerView.Adapter<TrailerCardAdapter.MyViewHolder>{
    private List<Trailer> trailers;

    public TrailerCardAdapter(List<Trailer> listaTrailers) {
        this.trailers = listaTrailers;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View itemLista = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.adapter_card_trailer, parent, false);

        return new MyViewHolder(itemLista);

    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        Trailer trailer = trailers.get( position );
        holder.textNome.setText( trailer.getTitle() );
        holder.textPostagem.setText( trailer.getDescription() );
        holder.imagePostagem.setImageResource( R.drawable.ic_enviar_branco_24dp );

    }

    @Override
    public int getItemCount() {
        return trailers.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView textNome;
        private TextView textPostagem;
        private ImageView imagePostagem;


        public MyViewHolder(View itemView) {
            super(itemView);
            textNome = itemView.findViewById(R.id.textView3);
            textPostagem = itemView.findViewById(R.id.textView4);
            imagePostagem = itemView.findViewById(R.id.imageView5);
        }
    }

}
