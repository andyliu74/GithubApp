package com.anly.githubapp.di.module;

import com.anly.githubapp.data.api.DoctorApi;
import com.anly.githubapp.data.net.DoctorListDataSource;

import dagger.Module;
import dagger.Provides;


@Module
public class DoctorListModule {
    @Provides
    DoctorApi provideDoctorApi(DoctorListDataSource dataSource) {
        return dataSource;
    }
}
