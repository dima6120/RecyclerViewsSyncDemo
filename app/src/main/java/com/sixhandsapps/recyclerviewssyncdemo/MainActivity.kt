package com.sixhandsapps.recyclerviewssyncdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MotionEvent
import androidx.recyclerview.widget.RecyclerView
import com.sixhandsapps.recyclerviewssyncdemo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var touchedRVTag = -1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        val rvs = arrayListOf(binding.rv0, binding.rv1, binding.rv2)

        val scrollListener = object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                val currentRVTag = recyclerView.tag as Int

                if (currentRVTag == touchedRVTag) {
                    for (rvTag in 0 until rvs.size) {
                        if (rvTag != currentRVTag) {
                            rvs[rvTag].scrollBy(dx, 0)
                        }
                    }
                }
            }
        }

        val itemTouchListener = object : RecyclerView.OnItemTouchListener {
            override fun onTouchEvent(rv: RecyclerView, e: MotionEvent) {}

            override fun onInterceptTouchEvent(rv: RecyclerView, e: MotionEvent): Boolean {
                val rvTag = rv.tag as Int

                if (touchedRVTag != -1 && touchedRVTag != rvTag) {
                    rvs[touchedRVTag].stopScroll()
                }

                touchedRVTag = rvTag

                return false
            }

            override fun onRequestDisallowInterceptTouchEvent(disallowIntercept: Boolean) {}
        }

        val numbers = intArrayOf(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13)

        for (i in 0 until rvs.size) {
            val rv = rvs[i]

            rv.tag = i
            rv.addOnScrollListener(scrollListener)
            rv.addOnItemTouchListener(itemTouchListener)
            rv.adapter = ItemAdapter(numbers)
        }
    }
}