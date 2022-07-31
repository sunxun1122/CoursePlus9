package com.example.core

import android.annotation.SuppressLint
import android.view.View
import android.widget.TextView
import androidx.annotation.IdRes
import androidx.annotation.NonNull
import androidx.annotation.Nullable
import androidx.recyclerview.widget.RecyclerView

abstract class BaseViewHolder : RecyclerView.ViewHolder {
    constructor(@NonNull itemView: View) : super(itemView)

    @SuppressLint("UseSparseArrays")
    private val viewHashMap = HashMap<Int?, View>();

    @SuppressWarnings("unchecked")
    protected fun <T : View> getView(@IdRes id: Int): T {
        var view = viewHashMap[id];
        if (view == null) {
            view = itemView.findViewById(id);
            viewHashMap[id] = view;
        }
        return view as T
    }

    protected fun setText(@IdRes id: Int, @Nullable text: String?) {
        (getView(id) as TextView).text = text;
    }

}