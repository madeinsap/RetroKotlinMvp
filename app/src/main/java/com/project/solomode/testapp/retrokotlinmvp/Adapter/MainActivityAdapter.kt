package com.project.solomode.testapp.retrokotlinmvp.Adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.project.solomode.testapp.retrokotlinmvp.Model.Instansi
import com.project.solomode.testapp.retrokotlinmvp.R
import kotlinx.android.synthetic.main.item_instansi.view.*

class MainActivityAdapter(var context: Context, var instansiList: List<Instansi>):
    RecyclerView.Adapter<MainActivityAdapter.MainActivityViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, position: Int): MainActivityViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_instansi, parent, false)

        return MainActivityViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return instansiList.size
    }

    override fun onBindViewHolder(holder: MainActivityViewHolder, position: Int) {
        holder.txtInstansi.text = instansiList[position].instansi
        holder.txtAlamat.text = instansiList[position].alamat
    }

    class MainActivityViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val txtInstansi = itemView.textInstansi
        val txtAlamat = itemView.textAlamatInstansi
    }
}