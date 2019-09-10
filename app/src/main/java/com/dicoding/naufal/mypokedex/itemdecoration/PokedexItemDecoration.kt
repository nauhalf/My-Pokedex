package com.dicoding.naufal.mypokedex.itemdecoration

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView

class PokedexItemDecoration(val padding: Int) : RecyclerView.ItemDecoration() {
    override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State) {
        if(parent.getChildAdapterPosition(view) > 1){
            outRect.top = padding
        }

        if((parent.getChildAdapterPosition(view)+1) % 2 == 0){
            outRect.left = padding
        }
    }
}