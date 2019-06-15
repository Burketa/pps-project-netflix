package com.teamfive.trailerflix.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.teamfive.trailerflix.R;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void abrirTelaCadastro(View view)
    {
        Intent intent = new Intent(getBaseContext(), CadastroAcitivity.class);
        startActivity(intent);
    }

    public void abrirTelaPrincipal(View view)
    {
        Intent intent = new Intent(getBaseContext(), MainActivity.class);
        startActivity(intent);
    }
}
