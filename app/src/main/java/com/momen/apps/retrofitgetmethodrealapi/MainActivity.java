package com.momen.apps.retrofitgetmethodrealapi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Retrofit retrofit = new Retrofit
                .Builder()
                .baseUrl("https://reqres.in/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        OurRetrofitClient ourRetrofitClient = retrofit.create(OurRetrofitClient.class);

        Call<SpcificObjectDataClass> call=   ourRetrofitClient.getData(2);

        call.enqueue(new Callback<SpcificObjectDataClass>() {
            @Override
            public void onResponse(Call<SpcificObjectDataClass> call, Response<SpcificObjectDataClass> response) {

                if(response.isSuccessful()){

                    ObjectDataClass objectDataClass=  response.body().getData();


                    Toast.makeText(MainActivity.this, String.valueOf(objectDataClass.getLast_name()), Toast.LENGTH_SHORT).show();
                    Log.d("id", String.valueOf(objectDataClass.getId()));
                    Log.d("email", String.valueOf(objectDataClass.getEmail()));
                    Log.d("first_name", String.valueOf(objectDataClass.getFirst_name()));
                    Log.d("last_name\n", String.valueOf(objectDataClass.getLast_name()));

                }else {
                    Log.d("response","fail");
                }
            }

            @Override
            public void onFailure(Call<SpcificObjectDataClass> call, Throwable t) {

            }
        });

/*
        call.enqueue(new Callback<OurMainDataClass>() {
            @Override
            public void onResponse(Call<OurMainDataClass> call, Response<OurMainDataClass> response) {

                if(response.isSuccessful()){

                    List<ObjectDataClass> list=   response.body().getData();
                    for(ObjectDataClass objectDataClass: list){

                        Toast.makeText(MainActivity.this, String.valueOf(objectDataClass.getLast_name()), Toast.LENGTH_SHORT).show();
                        Log.d("id", String.valueOf(objectDataClass.getId()));
                        Log.d("email", String.valueOf(objectDataClass.getEmail()));
                        Log.d("first_name", String.valueOf(objectDataClass.getFirst_name()));
                        Log.d("last_name\n", String.valueOf(objectDataClass.getLast_name()));
                        
                    }
                }else {
                    Log.d("response","fail");
                }
            }

            @Override
            public void onFailure(Call<OurMainDataClass> call, Throwable t) {

                Log.d("response","fail");
            }
        });
*/

    }
}