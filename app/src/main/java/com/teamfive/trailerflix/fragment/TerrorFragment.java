package com.teamfive.trailerflix.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Toast;

import com.teamfive.trailerflix.R;
import com.teamfive.trailerflix.activities.PlayerActivity;
import com.teamfive.trailerflix.adapter.TrailerAdapter;
import com.teamfive.trailerflix.helper.RecyclerItemClickListener;
import com.teamfive.trailerflix.model.Trailer;
import com.teamfive.trailerflix.utils.Data;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class TerrorFragment extends Fragment {

    private RecyclerView recyclerView;
    private TrailerAdapter adapter;
    private ArrayList<Trailer> trailerList = new ArrayList<>();

    public TerrorFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_list, container, false);

        //Configurações iniciais
        recyclerView = view.findViewById(R.id.recycler_view);

        //Popular lista de trailers estatica
        if (trailerList.size() == 0)
            popularListaTrailers();

        //configurar adapter
        adapter = new TrailerAdapter(trailerList, getContext());
        adapter.setMyListener(new TrailerAdapter.MyListener() {
            @Override
            public void onClick(int position) {
                Trailer trailer = trailerList.get(position);

                Intent i = new Intent(getActivity(), PlayerActivity.class);
                i.putExtra("trailer", trailer);
                startActivityForResult(i, 0);
            }

            @Override
            public void onFavoriteClick(int position) {
                Trailer trailer = trailerList.get(position);

                if (!trailer.isFavorite()) {
                    Toast.makeText(getContext(), trailer.getTitle() + " Favoritado",
                            Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getContext(), trailer.getTitle() + " Desfavoritado",
                            Toast.LENGTH_SHORT).show();
                }

                trailer.setFavorite(!trailer.isFavorite());

                Data.trailerList.set(Data.trailerList.indexOf(trailer), trailer);
                Data.updateFavorites();
                popularListaTrailers();
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onFeedbackPositiveClick(View v, int position) {
                Trailer t = trailerList.get(position);
                t.setFeedback(Trailer.POSITIVE);
                Data.updateFeedback(t, Trailer.POSITIVE);
                Toast.makeText(getContext(), t.getTitle() + ": Like", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFeedbackNegativeClick(View v, int position) {
                Trailer t = trailerList.get(position);
                t.setFeedback(Trailer.NEGATVIE);
                Data.updateFeedback(t, Trailer.NEGATVIE);
                Toast.makeText(getContext(), t.getTitle() + ": Dislike", Toast.LENGTH_SHORT).show();
            }
        });

        //configurar recyclerview
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapter);
        return view;
    }

    private void popularListaTrailers() {
        trailerList.clear();

        for (Trailer t : Data.trailerList) {
            if (t.getCategory() == Trailer.TERROR)
                trailerList.add(t);
        }

        if (trailerList != null)
            Collections.sort(trailerList);

        List<Trailer> aux = trailerList;
        List<Trailer> favorites = new ArrayList<>();
        List<Trailer> notFavorites = new ArrayList<>();
        for (Trailer t : aux) {
            if (t.isFavorite())
                favorites.add(t);
            else
                notFavorites.add(t);
        }
        trailerList.clear();
        trailerList.addAll(favorites);
        trailerList.addAll(notFavorites);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }
}
