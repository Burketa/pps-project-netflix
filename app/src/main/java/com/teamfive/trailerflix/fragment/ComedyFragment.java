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

import com.teamfive.trailerflix.R;
import com.teamfive.trailerflix.activities.PlayerActivity;
import com.teamfive.trailerflix.adapter.TrailerAdapter;
import com.teamfive.trailerflix.helper.RecyclerItemClickListener;
import com.teamfive.trailerflix.model.Trailer;
import com.teamfive.trailerflix.utils.Data;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class ComedyFragment extends Fragment {


    private RecyclerView recyclerView;
    private TrailerAdapter adapter;
    private ArrayList<Trailer> trailerList = new ArrayList<>();

    public ComedyFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_comedy, container, false);

        //Configurações iniciais
        recyclerView = view.findViewById(R.id.recycler_view);

        //Popular lista de trailers estatica
        popularListaTrailers();

        //configurar adapter
        adapter = new TrailerAdapter(trailerList, getContext());

        //configurar recyclerview
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapter);

        recyclerView.addOnItemTouchListener(
                new RecyclerItemClickListener(
                        getActivity(),
                        recyclerView,
                        new RecyclerItemClickListener.OnItemClickListener() {
                            @Override
                            public void onItemClick(View view, int position) {
                                Trailer trailer = trailerList.get(position);
                                Intent i = new Intent(getActivity(), PlayerActivity.class);
                                i.putExtra("trailer", trailer);
                                startActivity(i);

                            }

                            @Override
                            public void onLongItemClick(View view, int position) {

                            }

                            @Override
                            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                            }
                        }
                )
        );

        return view;
    }

    private void popularListaTrailers() {
        for(Trailer t : Data.trailerList)
        {
            if(t.getCategory() == 1)
                trailerList.add(t);
        }
    }

}
