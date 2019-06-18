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
import com.teamfive.trailerflix.adapter.TrailerCardAdapter;
import com.teamfive.trailerflix.helper.RecyclerItemClickListener;
import com.teamfive.trailerflix.model.Trailer;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class AcaoFragment extends Fragment {

    private RecyclerView recyclerView;
    private TrailerCardAdapter adapter;
    private ArrayList<Trailer> trailerList = new ArrayList<>();

    public AcaoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_comedia, container, false);

        //Configurações iniciais
        recyclerView = view.findViewById(R.id.recyclerViewListaContatos);

        //Popular lista de contatos estatica
        trailerList.add(new Trailer(0, null, "Acao 1", "Uau 1", 2000, true));
        trailerList.add(new Trailer(0, null, "Acao 2", "Uau 2", 2001, false));
        trailerList.add(new Trailer(0, null, "Acao 3", "Uau 3", 2002, true));
        trailerList.add(new Trailer(0, null, "Acao 4", "Uau 4", 2003, false));

        //configurar adapter
        adapter = new TrailerCardAdapter(trailerList);

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
}
