package com.teamfive.trailerflix.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.LinearLayout;

import com.teamfive.trailerflix.R;
import com.teamfive.trailerflix.adapters.AdapterTrailers;
import com.teamfive.trailerflix.model.Trailer;

import java.util.ArrayList;
import java.util.List;

public class TrailersRecyclerViewActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trailers_recycler);

        //Inicializa a lista
        List<Trailer> list = new ArrayList<>();

        //Pega o bundle da Main Activity
        Bundle bundle = getIntent().getExtras();
        list = (List<Trailer>) bundle.getSerializable("list");

        //Se n;ao tiver nenhum item, gera uma lista generica
        if(list.size() == 0) {
            list = createFeedbacklist(list);
        }

        //Referencias
        RecyclerView recyclerView;
        recyclerView = findViewById(R.id.api_view);

        //Adapter
        AdapterTrailers adapter = new AdapterTrailers(list);

        //Layout Manager
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayout.VERTICAL));
        recyclerView.setAdapter(adapter);
    }

    public List<Trailer> createFeedbacklist(List<Trailer> list) {

        list.add(new Trailer("GOSTEI", "Upper", false));
        list.add(new Trailer("nao gostei", "Lower", true));
        list.add(new Trailer("testes1", "Lower", false));
        list.add(new Trailer("Trailer", "Lower", true));
        list.add(new Trailer("ENGRAÇADO !", "Upper", false));

        return list;
    }
}
