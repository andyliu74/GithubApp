package com.anly.githubapp.data.net.client;

import com.anly.githubapp.data.net.client.core.ApiEndpoint;
import com.anly.githubapp.data.net.client.core.BaseRetrofit;

import javax.inject.Inject;

import okhttp3.OkHttpClient;

/***
 * Created by 000 on 2017/9/22.
 */

public class SelfDoctorRetrofit extends BaseRetrofit {
    private static final String END_POINT = "http://192.168.48.129:8001/";

    private CacheHttpClient mHttpClient;

    @Inject
    public SelfDoctorRetrofit(CacheHttpClient mHttpClient) {
        this.mHttpClient = mHttpClient;
    }

    @Override
    public ApiEndpoint getApiEndpoint() {
        return new ApiEndpoint() {
            @Override
            public String getEndpoint() {
                return END_POINT;
            }
        };
    }

    @Override
    public OkHttpClient getHttpClient() {
        return mHttpClient.get();
    }
}
