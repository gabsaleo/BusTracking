package com.example.bustracking.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.bustracking.R;
import com.example.bustracking.model.LinhaBus;
import com.example.bustracking.service.LinhaBusServices;

import java.util.ArrayList;
import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class MainActivity extends AppCompatActivity {

    TextView textNroLinha, textPartida, textDestino;
    Button button;
    EditText textField;
    private String cookie = "";
    LinhaBusServices service;
    String token = "8ac9820a47c1067e125b25625c2c4c2d653bb7e3306aff7353c00cbf1ec455cb";
    private List<LinhaBus> linhaDosBusao = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textNroLinha = findViewById(R.id.textNroLinha);
        textPartida = findViewById(R.id.textPartida);
        textDestino = findViewById(R.id.textDestino);

        button = findViewById(R.id.button);
        textField = findViewById(R.id.textField);

        initRetrofitOkHttpClient();

        requisicaoToken();

        button.setOnClickListener(v -> requisicaoNroOnibus());
    }

    private void requisicaoToken() {
        Call<String> login = service.getLogin(token);
        login.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                Log.d("deu certo",String.valueOf(response.body()));
                cookie = String.valueOf(response.headers().get("Set-Cookie"));
                Log.d("cookie", cookie);
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                t.getLocalizedMessage();
            }
        });
    }

    private void requisicaoNroOnibus() {
        Call<List<LinhaBus>> previsao = service.getPrevisao(textField.getText().toString(), cookie);

        previsao.enqueue(new Callback<List<LinhaBus>>() {
            @Override
            public void onResponse(Call<List<LinhaBus>> call, Response<List<LinhaBus>> response) {
                if(response.code() == 200) {
                    linhaDosBusao = response.body();
                    for (LinhaBus a : linhaDosBusao) {
                        if (a.getTl() == 10) {
                            textNroLinha.setText("Número da linha: " + a.getNroLinha());
                            textPartida.setText("Terminal de partida: " + a.getDenominacaoTPTS());
                            textDestino.setText("Terminal de destino:" + a.getDenominacaoTSTP());
                        }
                    }
                }if(response.raw().body().contentLength() == 2){
                    Toast.makeText(MainActivity.this, "Não encontramos esse onibus em nossa base de dados", Toast.LENGTH_SHORT).show();
                    textNroLinha.setText("");
                    textPartida.setText("");
                    textDestino.setText("");
                }
            }

            @Override
            public void onFailure(Call<List<LinhaBus>> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Algo deu errado", Toast.LENGTH_SHORT).show();
                Log.d("erro", t.getMessage());
            }
        });

    }
    private void initRetrofitOkHttpClient() {
        //inteceptar o body do http
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        //client
        OkHttpClient client = new OkHttpClient
                .Builder()
                .addInterceptor(interceptor)
                .build();


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://api.olhovivo.sptrans.com.br/v2.1/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();


        service = retrofit.create(LinhaBusServices.class);
    }


}
