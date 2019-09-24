package com.wts.mvvm.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import com.wts.mvvm.R
import com.wts.mvvm.bean.HomeBean

/**
 * Create by wangtingshun 2019/9/15
 * describe 首页的adapter
 */
class HomeAdapter(private val context:Context,private var data:MutableList<HomeBean>) :RecyclerView.Adapter<RecyclerView.ViewHolder>(){

    private val HEADER = 0
    private val NORMAL = 1
    private val FOOTER = 2

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): RecyclerView.ViewHolder = when (viewType) {
        HEADER -> {
            HeaderViewHolder(LayoutInflater.from(context)?.inflate(R.layout.item_home_header, viewGroup, false)!!)
        }
        FOOTER -> {
            FooterViewHolder(LayoutInflater.from(context)?.inflate(R.layout.item_home_footer, viewGroup, false)!!)
        }
        else -> {
            RecyclerViewHolder(LayoutInflater.from(context)?.inflate(R.layout.item_home_center, viewGroup, false)!!)
        }
    }

    override fun getItemCount(): Int = data.size

    override fun getItemViewType(position: Int): Int = when (position) {
        0 -> {
            HEADER
        }
        itemCount - 1 -> {
            FOOTER
        }
        else -> {
            NORMAL
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
       when (getItemViewType(position)){
           HEADER -> {
               if (holder is HeaderViewHolder) {
                   holder.headerView.text ="I am header"
               }
           }
           FOOTER -> {
               if (holder is FooterViewHolder){
                   holder.footerView.text = "I am footer"
               }
           }
           else ->{
               if (holder is RecyclerViewHolder){
                     holder?.textView?.text = data[position].itemName
                     holder.textView.setOnClickListener {
                       Toast.makeText(context,"click"+data[position].itemName,Toast.LENGTH_LONG).show()
                   }
               }
           }
       }
    }


    inner class RecyclerViewHolder(view: View) :RecyclerView.ViewHolder(view){
        var textView :TextView = view.findViewById(R.id.tv_center)
    }

    inner class HeaderViewHolder(view: View):RecyclerView.ViewHolder(view){
        var headerView :TextView = view.findViewById(R.id.tv_header)
    }

    inner class FooterViewHolder(view: View) :RecyclerView.ViewHolder(view){
        var footerView :TextView = view.findViewById(R.id.tv_footer)
    }
}