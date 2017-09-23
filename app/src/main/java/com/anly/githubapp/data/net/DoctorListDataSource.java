package com.anly.githubapp.data.net;

import com.anly.githubapp.data.api.DoctorApi;
import com.anly.githubapp.data.model.Doctor;
import com.anly.githubapp.data.net.client.SelfDoctorRetrofit;
import com.anly.githubapp.data.net.service.DoctorListService;

import java.util.ArrayList;

import javax.inject.Inject;

import rx.Observable;


public class DoctorListDataSource implements DoctorApi{

    @Inject
    SelfDoctorRetrofit mRetrofit;

    @Inject
    public DoctorListDataSource() {
    }

    @Override
    public Observable<ArrayList<Doctor>> getDoctorList() {
        final DoctorListService doctorListService = mRetrofit.get().create(DoctorListService.class);
        return doctorListService.getDoctorList();
    }
}
