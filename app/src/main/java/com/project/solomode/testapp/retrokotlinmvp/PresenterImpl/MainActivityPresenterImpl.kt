package com.project.solomode.testapp.retrokotlinmvp.PresenterImpl

import com.project.solomode.testapp.retrokotlinmvp.Network.ApiClient
import com.project.solomode.testapp.retrokotlinmvp.Network.ApiInterface
import com.project.solomode.testapp.retrokotlinmvp.Presenter.MainActivityPresenter
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.annotations.NonNull
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class MainActivityPresenterImpl(var mainView: MainActivityPresenter.MainView?) : MainActivityPresenter.MainPresenter {

    lateinit var compositeDisposable: CompositeDisposable
    lateinit var jsonApi: ApiInterface

    override fun onFetchData(lat: String, lng: String) {
        mainView!!.showProgressBar()

        compositeDisposable = CompositeDisposable()

        val apiService = ApiClient.getClient
        jsonApi = apiService.create(ApiInterface::class.java)

        compositeDisposable.add(jsonApi.getAllData(lat, lng)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                listInstansi ->
                    mainView!!.hideProgressBar()
                    mainView!!.onSuccessFetchData(listInstansi)
            },{
                error ->
                    mainView!!.hideProgressBar()
                    mainView!!.onFailedFetchData()
            }))
    }

    override fun onStop() {

    }
}