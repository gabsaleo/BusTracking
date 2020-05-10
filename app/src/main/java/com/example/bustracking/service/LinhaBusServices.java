package com.example.bustracking.service;

import com.example.bustracking.model.LinhaBus;
import com.example.bustracking.model.ParadaOnibusMock;


import java.sql.Array;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface LinhaBusServices {
    @POST("Login/Autenticar")
    Call<String> getLogin(@Query("token") String token);

    @GET("Linha/Buscar")
    Call<List<LinhaBus>> getPrevisao(@Query("termosBusca") String nrolinha,
                                   @Header("cookie") String cookie);

    @GET("Previsao/Parada")
    Call<ParadaOnibusMock> getHora(@Query("codigoParada") int codigoParada,
                                        @Header("cookie") String cookie);

}


