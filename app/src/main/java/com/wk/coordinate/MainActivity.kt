package com.wk.coordinate

import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MotionEvent
import kotlinx.android.synthetic.main.activity_main.*
import android.util.DisplayMetrics
import android.view.View
import android.view.Window
import android.view.WindowManager


class MainActivity : AppCompatActivity() {
    private val TAG = this.javaClass.simpleName
    private var width = 0
    private var height = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        hideTopUIMenu()
        setContentView(R.layout.activity_main)

        val manager = this.windowManager
        val outMetrics = DisplayMetrics()
        manager.defaultDisplay.getMetrics(outMetrics)
        width = outMetrics.widthPixels
        height = outMetrics.heightPixels
        btn2.setOnClickListener {
            MyDialogFragment.getInstance().show(fragmentManager,"MyDialog")
        }
        btn3.setOnClickListener {
            btn.translationX=50f
            btn.translationY=50f
        }
        btn.setOnTouchListener { v, event ->
            if (event.action == MotionEvent.ACTION_DOWN) {
                Log.i(TAG, "width " + width + "  height " + height)
                Log.i(TAG, "btn onTouchEvent event.x: " + event.x)
                Log.i(TAG, "btn onTouchEvent event.rawX: " + event.rawX)
                Log.i(TAG, "btn onTouchEvent event.y: " + event.y)
                Log.i(TAG, "btn onTouchEvent event.rawY: " + event.rawY)
                Log.i(TAG, "btn onTouchEvent v.translationX: " + v.translationX)
                Log.i(TAG, "btn onTouchEvent v.translationX: " + v.translationY)
                Log.i(TAG, "btn onTouchEvent v.x: " + v.x)
                Log.i(TAG, "btn onTouchEvent v.y: " + v.y)
                Log.i(TAG, "btn onTouchEvent v.top: " + v.top)
                Log.i(TAG, "btn onTouchEvent v.bottom: " + v.bottom)
                Log.i(TAG, "btn onTouchEvent v.right: " + v.right)
                Log.i(TAG, "btn onTouchEvent v.left: " + v.left)
                Log.i(TAG, "btn onTouchEvent v.width: " + v.width)
                Log.i(TAG, "btn onTouchEvent v.height: " + v.height)
                val int2=IntArray(2)
                v.getLocationOnScreen(int2)
                Log.i(TAG, "btn onTouchEvent OnScreen[0]: " + int2[0])
                Log.i(TAG, "btn onTouchEvent OnScreen[1]: " + int2[1])
                val int3=IntArray(2)
                v.getLocationInWindow(int3)
                Log.i(TAG, "btn onTouchEvent Window[0]: " + int3[0])
                Log.i(TAG, "btn onTouchEvent Window[1]: " + int3[1])
                val parentView=v.parent as View
                Log.i(TAG, " parentView " + v.parent)
                Log.i(TAG, "btn onTouchEvent parentView.x: " + parentView.x)
                Log.i(TAG, "btn onTouchEvent parentView.y: " + parentView.y)
                Log.i(TAG, "btn onTouchEvent parentView.top: " + parentView.top)
                Log.i(TAG, "btn onTouchEvent parentView.bottom: " + parentView.bottom)
                Log.i(TAG, "btn onTouchEvent parentView.right: " + parentView.right)
                Log.i(TAG, "btn onTouchEvent parentView.left: " + parentView.left)
                Log.i(TAG, "btn onTouchEvent parentView.width: " + parentView.width)
                Log.i(TAG, "btn onTouchEvent parentView.height: " + parentView.height)
            }else if (event.action == MotionEvent.ACTION_MOVE) {
                btn.layout(event.x.toInt(),event.y.toInt(),
                        event.x.toInt()+btn.width,event.y.toInt()+btn.height)
                Log.i(TAG, "btn ACTION_MOVE v.translationX: " + v.translationX)
                Log.i(TAG, "btn ACTION_MOVE v.translationX: " + v.translationY)
                Log.i(TAG, "btn ACTION_MOVE v.x: " + v.x)
                Log.i(TAG, "btn ACTION_MOVE v.y: " + v.y)
                Log.i(TAG, "btn ACTION_MOVE v.top: " + v.top)
                Log.i(TAG, "btn ACTION_MOVE v.bottom: " + v.bottom)
                Log.i(TAG, "btn ACTION_MOVE v.right: " + v.right)
                Log.i(TAG, "btn ACTION_MOVE v.left: " + v.left)
            }

            true
        }
    }

    override fun onStart() {
        super.onStart()
        hideBottomUIMenu()
    }

    /*
           * 隐藏状态栏
           * */
    private fun hideTopUIMenu() {
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        //定义全屏参数
        val flag = WindowManager.LayoutParams.FLAG_FULLSCREEN
        //获得窗口对象
        val myWindow = this.window
        //设置Flag标识
        myWindow.setFlags(flag, flag)
    }

    /**
     * 隐藏虚拟键
     * */
    private fun hideBottomUIMenu() {
        //隐藏虚拟按键，并且全屏
        if (Build.VERSION.SDK_INT in 11..19) { // lower api
            val v = this.window.decorView
            v.systemUiVisibility = View.GONE
        } else if (Build.VERSION.SDK_INT >= 19) {
            //for new api versions.
            val decorView = window.decorView
            val uiOptions = (View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                    or View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY or View.SYSTEM_UI_FLAG_FULLSCREEN)
            decorView.systemUiVisibility = uiOptions

        }
    }
}
