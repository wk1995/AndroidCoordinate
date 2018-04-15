package com.wk.coordinate

import android.app.DialogFragment
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button

/**
 * <pre>
 *      author : wk
 *      e-mail : 122642603@qq.com
 *      time   : 2018/04/11
 *      desc   :
 *      GitHub : https://github.com/wk1995
 *      CSDN   : http://blog.csdn.net/qq_33882671
 * </pre>
 */
class MyDialogFragment:DialogFragment() {
    private val TAG=this.javaClass.simpleName
    companion object {
        fun getInstance():MyDialogFragment{
            val myDialogFragment=MyDialogFragment()
            return myDialogFragment
        }
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val v=inflater!!.inflate(R.layout.dialog_fragment,container,false)
        val dialog_btn=v.findViewById<Button>(R.id.dialog_btn)
        dialog_btn.setOnClickListener {
            val int2=IntArray(2)
            dialog_btn.getLocationOnScreen(int2)
            Log.i(TAG, "btn onTouchEvent OnScreen[0]: " + int2[0])
            Log.i(TAG, "btn onTouchEvent OnScreen[1]: " + int2[1])
            val int3=IntArray(2)
            dialog_btn.getLocationInWindow(int3)
            Log.i(TAG, "btn onTouchEvent Window[0]: " + int3[0])
            Log.i(TAG, "btn onTouchEvent Window[1]: " + int3[1])
        }
        return v
    }
}