package com.anly.githubapp.ui.module.account.view;

import com.anly.githubapp.data.model.ElmUser;
import com.anly.mvp.lce.LoadView;

/**
 * Created by mingjun on 16/8/9.
 */
public interface LoginView extends LoadView {

    void loginSuccess(ElmUser user);
}
