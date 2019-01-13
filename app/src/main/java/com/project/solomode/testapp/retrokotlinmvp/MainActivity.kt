package com.project.solomode.testapp.retrokotlinmvp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import android.widget.Toast
import com.project.solomode.testapp.retrokotlinmvp.Adapter.MainActivityAdapter
import com.project.solomode.testapp.retrokotlinmvp.Model.Instansi
import com.project.solomode.testapp.retrokotlinmvp.Presenter.MainActivityPresenter
import com.project.solomode.testapp.retrokotlinmvp.PresenterImpl.MainActivityPresenterImpl
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), MainActivityPresenter.MainView {

    var mainActivityPresenterImpl: MainActivityPresenterImpl? = null
    var mAdapter: MainActivityAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initLayout();
        fetchData();
    }

    private fun fetchData() {
        mainActivityPresenterImpl = MainActivityPresenterImpl(this)
        mainActivityPresenterImpl!!.onFetchData("lat", "lng")
    }

    private fun initLayout() {
        myRecyclerView.layoutManager = LinearLayoutManager(this)
        myRecyclerView.setHasFixedSize(true)
    }

    override fun showProgressBar() {
        progressBar.visibility = View.VISIBLE
    }

    override fun hideProgressBar() {
        progressBar.visibility = View.GONE
    }

    override fun onSuccessFetchData(instansiList: List<Instansi>) {
        mAdapter = MainActivityAdapter(this, instansiList)
        myRecyclerView.adapter = mAdapter
    }

    override fun onFailedFetchData() {
        Toast.makeText(this, "Gagal mendapatkan data", Toast.LENGTH_SHORT).show()
    }
}
