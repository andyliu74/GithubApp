package com.anly.githubapp.data.net.service;

import com.anly.githubapp.data.model.User;
import com.anly.githubapp.data.model.ElmUser;
import com.anly.githubapp.data.net.request.CreateAuthorization;
import com.anly.githubapp.data.net.response.AuthorizationResp;

import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by mingjun on 16/7/27.
 */
public interface AccountService {

    @POST("/authorizations")
    Observable<AuthorizationResp> createAuthorization(
            @Body CreateAuthorization createAuthorization);

    @GET("/user")
    Observable<User> getUserInfo(@Query("access_token") String accessToken);

    @FormUrlEncoded
    @POST("/v2/login")
    Observable<ElmUser> login(@Field("username") String username, @Field("password") String password);
}
