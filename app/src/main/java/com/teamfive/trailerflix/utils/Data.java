package com.teamfive.trailerflix.utils;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import com.teamfive.trailerflix.activities.LoginActivity;
import com.teamfive.trailerflix.activities.MainActivity;
import com.teamfive.trailerflix.api.IMDBService;
import com.teamfive.trailerflix.model.Trailer;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Data{

    private Context c;
    private int i = 0;

    public static List<Trailer> trailerList = Arrays.asList(
            new Trailer("tt0451279", "bldAkEUANWA", true, false),
            new Trailer("tt4154796", "g6ng8iy-l0U", false, true),

            new Trailer("tt1979376", "wmiIUN-7qhE", false, false),
            new Trailer("tt6139732", "PRyOvcOhtms", true, true),
            new Trailer("tt9853264", "qk7AkLgXK4k", false,
                    true),
            new Trailer("tt1298644", "QxsWq53cV80",false,
                    false),
            new Trailer("tt9214310", "FWFMr44Rmjw",true,
                    false),
            new Trailer("tt2139881", "FQFPrMNcDhA",false, false),
            new Trailer("tt8211942", "AVdjEY4BMxs", false, false),
            new Trailer("tt5814534", "KarvuJWMLjI", false,
                    false),
            new Trailer("tt4139588", "cdAZYIgdh6M",true, false)

    );

    public static List<Trailer> favoriteList = new ArrayList<>();
    public static List<Trailer> jsontrailer = new ArrayList<>();
    public static String json = "";

    public static void updateFavorites()
    {
        favoriteList.clear();

        for(Trailer t : trailerList)
        {
            if(t.isFavorite())
                favoriteList.add(t);
        }
    }



    public void startTask(Context c) {
        this.c = c;
        for(Trailer t : trailerList) {
            //Cria um objeto da task para fazer as tearefas assincronas
            GetIMDBTask task = new GetIMDBTask();

            //Seta a url da api
            String url_api = "http://www.omdbapi" +
                    ".com/?i=" + t.getTrailerIMDBId() + "&apikey=23e0c700";

            //Executa a tarefa assincrona
            task.execute(url_api);
        }
    }

    class GetIMDBTask extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... strings) {

            return getResponseFromURL(strings[0]);

        }

        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);

            System.out.println(result);

            setTrailerData(result);

            Intent intent = new Intent(c, MainActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            c.startActivity(intent);
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
        }
        return api_raw_result.toString();
    }

    private void setTrailerData(String result) {
        try {
            JSONObject obj = new JSONObject(result);
            trailerList.get(i).setTitle(obj.getString("Title"));
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void getMovieData()
    {
        for(final Trailer t : trailerList) {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("http://www.omdbapi" +
                    ".com/?i=" + t.getTrailerIMDBId() + "&apikey=23e0c700")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            IMDBService service = retrofit.create(IMDBService.class);
            Call<Trailer> call = service.recuperarIMDB();

            call.enqueue(new Callback<Trailer>() {
                @Override
                public void onResponse(Call<Trailer> call, Response<Trailer> response) {
                    if(response.isSuccessful()) {
                        Trailer novo = response.body();
                        trailerList.get(trailerList.indexOf(t)).setTitle(novo.getTitle());
                        System.out.println("SUCESSO");
                    }
                }

                @Override
                public void onFailure(Call<Trailer> call, Throwable t) {
                    if (t instanceof IOException) {
                        System.out.println("is an actual network failure :(");
                    }
                    else {
                        System.out.println("conversion error");
                    }
                }
            });
        }
    }
}
