package com.anly.githubapp.presenter.main;

import com.anly.githubapp.data.api.DoctorApi;
import com.anly.githubapp.data.model.Doctor;
import com.anly.githubapp.data.rx.ResponseObserver;
import com.anly.githubapp.presenter.base.RxMvpPresenter;
import com.anly.mvp.lce.LceView;

import java.util.ArrayList;

import javax.inject.Inject;

import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action0;
import rx.schedulers.Schedulers;


/**
 * Created by 000 on 2017/9/22.
 */

public class DoctorListPresenter extends RxMvpPresenter<LceView<ArrayList<Doctor>>> {
    private final DoctorApi mDoctorApi;

    @Inject
    public DoctorListPresenter(DoctorApi api) {
        this.mDoctorApi = api;
    }

    public void loadDoctorList() {
        mCompositeSubscription.add(mDoctorApi.getDoctorList()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe(new Action0() {
                    @Override
                    public void call() {
                        getMvpView().showLoading();
                    }
                })
                .doOnTerminate(new Action0() {
                    @Override
                    public void call() {
                        getMvpView().dismissLoading();
                    }
                })
                .subscribe(new ResponseObserver<ArrayList<Doctor>>() {

                    @Override
                    public void onError(Throwable e) {
                        getMvpView().showError(e);
                    }

                    @Override
                    public void onSuccess(ArrayList<Doctor> repos) {
                        getMvpView().showContent(repos);
                    }
                }));
    }

}
