package com.teamfive.trailerflix.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import com.teamfive.trailerflix.R;
import com.teamfive.trailerflix.adapter.TrailersAdapter;
import com.teamfive.trailerflix.helper.RecyclerItemClickListener;
import com.teamfive.trailerflix.model.Trailer;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class ComediaFragment extends Fragment {


    private RecyclerView recyclerView;
    private TrailersAdapter adapter;
    private ArrayList<Trailer> trailerList = new ArrayList<>();

    public ComediaFragment() {
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
        trailerList.add(new Trailer(1, null, "Comedia 1", "Engraçado 1", 2000, true));
        trailerList.add(new Trailer(1, null, "Comedia 2", "Engraçado 2", 2001, false));
        trailerList.add(new Trailer(1, null, "Comedia 3", "Engraçado 3", 2002, true));
        trailerList.add(new Trailer(1, null, "Comedia 4", "Engraçado 4", 2003, false));

        //configurar adapter
        adapter = new TrailersAdapter(trailerList, getActivity());

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
                                //Intent i = new Intent(getActivity(), ChatActivity.class);
                                //i.putExtra("chatContato", usuarioSelecionado);
                                // startActivity(i);

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
