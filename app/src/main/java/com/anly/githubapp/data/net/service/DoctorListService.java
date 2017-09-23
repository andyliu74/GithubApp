package com.anly.githubapp.data.net.service;

import com.anly.githubapp.data.model.Doctor;
import java.util.ArrayList;
import rx.Observable;
import retrofit2.http.GET;

/***
 * Created by 000 on 2017/9/22.
 */

public interface DoctorListService {

    @GET("/v2/index_doctor")
    Observable<ArrayList<Doctor>> getDoctorList();
}
