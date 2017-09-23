package com.anly.githubapp.data.api;

import com.anly.githubapp.data.model.Doctor;

import java.util.ArrayList;

import rx.Observable;

/***
 * Created by 000 on 2017/9/22.
 */

public interface DoctorApi {
    Observable<ArrayList<Doctor>> getDoctorList();
}
