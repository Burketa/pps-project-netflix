package com.teamfive.trailerflix.activities;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class APIActivity extends AppCompatActivity {


    private StringBuffer api_raw_result;
  
    private List<Feedback> api_result;

    private RecyclerView recyclerView;

    private AdapterFeedbacks adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_api);

        api_result = new ArrayList<>();

        api_raw_result = new StringBuffer();

        //Task
        startTask();
    }

    public void startTask() {
        //Cria um objeto da task para fazer as tearefas assincronas
        GetCurrencyTask task = new GetCurrencyTask();

        //Seta a url da api
        String url_api = "https://blockchain.info/ticker";

        //Executa a tarefa assincrona
        task.execute(url_api);
    }

    class GetCurrencyTask extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... strings) {

            return getResponseFromURL(strings[0]);

        }

        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);

            formatCurrencyJSON(result);

            configAdapter();

        }
    }

    private void configAdapter() {
        //Adapter
        adapter = new AdapterFeedbacks(api_result);

        //Layout Manager
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView = findViewById(R.id.api_view);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        //recyclerView.addItemDecoration(new DividerItemDecoration(getApplicationContext(), LinearLayout.VERTICAL));
        recyclerView.setAdapter(adapter);
    }

    private void formatCurrencyJSON(String result) {
        String currency;
        String buy_price;
        String sell_price;

        try {

            JSONObject issueObj = new JSONObject(result);
            Iterator iterator = issueObj.keys();
            while (iterator.hasNext()) {
                String key = (String) iterator.next();
                JSONObject issue = issueObj.getJSONObject(key);

                //  get id from  issue
                currency = key;
                buy_price = issue.optString("buy");
                sell_price = issue.optString("sell");

                System.out.println("Currency: " + currency);
                System.out.println("Buy: " + buy_price);
                System.out.println("Sell:" + sell_price);

                api_result.add(new Feedback(buy_price.toString(), key, false));
                System.out.println(api_result.toString());
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public String getResponseFromURL(String url_string) {
        String string = url_string;
        HttpURLConnection connection = null;
        InputStream inputStream = null;
        InputStreamReader streamReader = null;
        BufferedReader bufferedReader = null;
        StringBuffer api_raw_result = new StringBuffer();

        try {
            //Seta a url
            URL url = new URL(string);

            //Faz a conexao
            connection = (HttpURLConnection) url.openConnection();

            //Poe a resposta em bytes no input stream
            inputStream = connection.getInputStream();

            //Faz a leitura dos bytes para caracteres
            streamReader = new InputStreamReader(inputStream);

            //Transforma em string
            bufferedReader = new BufferedReader(streamReader);
            String line = "";
            while ((line = bufferedReader.readLine()) != null) {
                api_raw_result.append(line);
            }


        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();

            //TODO: Iterar em cada moeda para colocar os valores em uma lista para colocar no adapter
            try {

                JSONObject issueObj = new JSONObject(result);
                Iterator iterator = issueObj.keys();
                while (iterator.hasNext()) {
                    String key = (String) iterator.next();
                    JSONObject issue = issueObj.getJSONObject(key);

                    //  get id from  issue
                    currency = key;
                    buy_price = issue.optString("buy");
                    sell_price = issue.optString("sell");

                    System.out.println("Currency: " + currency);
                    System.out.println("Buy: " + buy_price);
                    System.out.println("Sell:" + sell_price);

                    api_result.add(new Feedback(buy_price.toString(), key, false));
                    System.out.println(api_result.toString());
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }

            //Adapter
            adapter = new AdapterFeedbacks(api_result);

            //Layout Manager
            RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
            recyclerView = findViewById(R.id.api_view);
            recyclerView.setLayoutManager(layoutManager);
            recyclerView.setHasFixedSize(true);
            //recyclerView.addItemDecoration(new DividerItemDecoration(getParent().getApplicationContext(), LinearLayout.VERTICAL));
            recyclerView.setAdapter(adapter);
          
        }
        return api_raw_result.toString();
    }
}
