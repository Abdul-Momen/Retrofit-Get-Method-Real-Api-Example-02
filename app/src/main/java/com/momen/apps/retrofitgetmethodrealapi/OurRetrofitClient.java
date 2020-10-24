package com.momen.apps.retrofitgetmethodrealapi;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface OurRetrofitClient {

        @GET("users/{id}")
        Call<SpcificObjectDataClass> getData(@Path("id") int id);
/*
    @GET("teams/{id}")
    Call<TeamClass> getData(@Path ("id") int id, @Query("api_token") String token);
    @GET("players")
    Call<ArrayDesignClass> getPlayerData(@Query("api_token") String token
            , @Query("country_id") int cid
    );*/
}
