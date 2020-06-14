package com.example.mypetitefrench.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

    public class ServiceGenerator {
        private static Retrofit.Builder retrofitBuilder = new Retrofit.Builder()
                .baseUrl("https://dog.ceo")
                .addConverterFactory(GsonConverterFactory.create());

        private static Retrofit retrofit = retrofitBuilder.build();

        private static Api api = retrofit.create(Api.class);

        public static Api getApi() {
            return api;
        }
    }


