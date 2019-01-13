package com.project.solomode.testapp.retrokotlinmvp.Presenter

import com.project.solomode.testapp.retrokotlinmvp.Model.Instansi
import retrofit2.Response

interface MainActivityPresenter {

    interface MainView {
        fun showProgressBar();
        fun hideProgressBar();
        fun onSuccessFetchData(instansiList: List<Instansi>);
        fun onFailedFetchData();
    }

    interface MainPresenter {
        fun onFetchData(lat: String, lng: String);
        fun onStop();
    }
}