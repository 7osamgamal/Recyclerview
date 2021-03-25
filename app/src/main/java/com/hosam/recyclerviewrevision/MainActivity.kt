package com.hosam.recyclerviewrevision

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    val examplelist= DummyList(20)
    val adapter=RecyclerAdapter(examplelist)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerviewId.adapter=adapter
        recyclerviewId.setHasFixedSize(true)
        recyclerviewId.layoutManager=LinearLayoutManager(this)
    }
    private fun DummyList(size:Int):ArrayList<ItemsModul>
    {
        val list=ArrayList<ItemsModul>()
        for (i in 0 until size) {
            val drwable = when (i % 3) {
                0 -> R.drawable.ic_emoticon
                1 -> R.drawable.ic_headset
                else -> R.drawable.ic_highlight
            }
            val item=ItemsModul(drwable,"text$i","line2")
            list+=item
        }
    return list
    }

    fun InsertItem(view: View) {
        val index=Random.nextInt(10)
        val item=ItemsModul(R.drawable.ic_baseline,"new insert item","baseline")
        examplelist.add(index,item)
        adapter.notifyItemInserted(index)
        Toast.makeText(this,"item inserted in inex$index",Toast.LENGTH_LONG).show()

    }
    fun DeleteItem(view: View) {
        val index=Random.nextInt(10)
        examplelist.removeAt(index)
        adapter.notifyItemRemoved(index)
        Toast.makeText(this,"item deleted in inex$index",Toast.LENGTH_LONG).show()
    }
}