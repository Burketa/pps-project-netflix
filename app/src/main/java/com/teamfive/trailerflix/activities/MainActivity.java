package com.teamfive.trailerflix.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.teamfive.trailerflix.R;
import com.teamfive.trailerflix.activities.TrailersRecyclerViewActivity;
import com.teamfive.trailerflix.model.Trailer;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private TextInputEditText tv_feedback;
    private CheckBox cb_toast;
    private RadioGroup radio_group;

    private List<Trailer> trailers;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*trailers = new ArrayList<>();

        //Referencias
        tv_feedback = findViewById(R.id.tv_feedback);
        cb_toast = findViewById(R.id.cb_toast);
        radio_group = findViewById(R.id.rg_case);*/

    }

    /*  Ao clicar no botao:
        - Checa qual botao do radio group esta ativo
        - Checa se o checkbox para exibir toast esta ativo ou nao
        - Adiciona o feedback na lista
    */
    public void buttonSend(View view) {
        Toast.makeText(this, "Teste", Toast.LENGTH_SHORT).show();
        /*String user_feedback = tv_feedback.getText().toString();

        Trailer current_feedback = new Trailer();

        switch(radio_group.getCheckedRadioButtonId())
        {
            case R.id.rb_upper:
                current_feedback.setFeedback(user_feedback.toUpperCase());
                current_feedback.setString_case("UPPER");
                break;
            default:
            case R.id.rb_lower:
                current_feedback.setFeedback(user_feedback.toLowerCase());
                current_feedback.setString_case("lower");
                break;
        }

        trailers.add(current_feedback);*/
    }

    //Passa os dados para as novas activities
    public void loadFeedbacksRecycleActivity(View view) {
        Intent intent = new Intent(getBaseContext(), TrailersRecyclerViewActivity.class);
        intent.putExtra("list", (Serializable) trailers);
        startActivity(intent);
    }
}
