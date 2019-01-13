package com.project.solomode.testapp.retrokotlinmvp.PresenterImpl

import com.project.solomode.testapp.retrokotlinmvp.MainActivity
import com.project.solomode.testapp.retrokotlinmvp.Model.Instansi
import com.project.solomode.testapp.retrokotlinmvp.Presenter.MainActivityPresenter
import org.junit.Assert.*
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.mock

class MainActivityPresenterImplTest {

    var view: MainActivityPresenter.MainView? = null
    var mainActivityPresenterImpl: MainActivityPresenterImpl? = null

    @Test
    fun checkData() {
        view = mock(MainActivityPresenter.MainView::class.java)
        val instansi = Instansi("harapan jaya", "jonggol")

        mainActivityPresenterImpl = MainActivityPresenterImpl(view)
        assertEquals(true, mainActivityPresenterImpl!!.checkDataTrue(instansi))
    }
}