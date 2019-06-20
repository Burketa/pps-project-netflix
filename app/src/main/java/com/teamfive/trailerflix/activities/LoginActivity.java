package com.teamfive.trailerflix.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.facebook.AccessToken;
import com.facebook.AccessTokenTracker;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.teamfive.trailerflix.R;
import com.teamfive.trailerflix.utils.Data;

import org.json.JSONException;
import org.json.JSONObject;

public class LoginActivity extends AppCompatActivity {

    String userName = "";
    CallbackManager callbackManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        callbackManager = new CallbackManager.Factory().create();
        
        LoginButton button = findViewById(R.id.login_button);
        button.setPermissions("public_profile");
        button.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                abrirTelaPrincipal(null);
            }

            @Override
            public void onCancel() {
                Toast.makeText(LoginActivity.this, "Cancelado", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onError(FacebookException error) {
                Toast.makeText(LoginActivity.this, "Erro", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        callbackManager.onActivityResult(requestCode, resultCode, data);
        super.onActivityResult(requestCode, resultCode, data);
    }

    public void abrirTelaCadastro(View view)
    {
        Intent intent = new Intent(getBaseContext(), CadastroAcitivity.class);
        startActivity(intent);
    }



    public void abrirTelaPrincipal(View view)
    {
        Data data = new Data();
        data.startTask(getBaseContext());
    }

    AccessTokenTracker tokenTracker = new AccessTokenTracker() {
        @Override
        protected void onCurrentAccessTokenChanged(AccessToken oldAccessToken, AccessToken currentAccessToken) {
            if(currentAccessToken == null)
            {

            }
            else
            {
                loadUserName(currentAccessToken);
            }
        }
    };

    private void loadUserName(AccessToken newAccessToken)
    {
        GraphRequest request = GraphRequest.newMeRequest(newAccessToken, new GraphRequest.GraphJSONObjectCallback() {
            @Override
            public void onCompleted(JSONObject object, GraphResponse response) {
                try {
                    userName = object.getString("first_name");
                    Toast.makeText(LoginActivity.this, "Bem vind@, " + userName, Toast.LENGTH_LONG).show();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });

        Bundle parameters = new Bundle();
        parameters.putString("fields", "first_name");
        request.setParameters(parameters);
        request.executeAsync();
    }
}
