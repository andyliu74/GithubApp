package com.anly.githubapp.data.api;

import com.anly.githubapp.data.model.ElmUser;

import rx.Observable;

/**
 * Created by mingjun on 16/7/27.
 */
public interface AccountApi {

    Observable<ElmUser> login(String username, String password);
}
