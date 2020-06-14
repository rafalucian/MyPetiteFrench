package com.example.mypetitefrench.api;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Api {
    @GET("/api/breed/bulldog/french/images/random")
    Call<FrenchResponse> getFrenchRandom();


}
