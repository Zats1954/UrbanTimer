package ru.zatsoft.trainingsession

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView


class ListAdapter(private val context: Context, private val dataList: List<Exercise>) :
    ArrayAdapter<Exercise>(context, R.layout.list_item, dataList) {

    override fun getCount(): Int {
        return dataList.size
    }

    override fun getItem(position: Int): Exercise {
        return dataList[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, v: View?, parent: ViewGroup): View {
        val view = v ?: LayoutInflater.from(context).inflate(R.layout.list_item, parent, false)
        val data = getItem(position)
        val tvTitle = view.findViewById<TextView>(R.id.title)
        val tvDuration = view.findViewById<TextView>(R.id.duration)
        tvTitle.text = data.info
        tvDuration.text = data.timerEx.toString()
        return view
    }
}