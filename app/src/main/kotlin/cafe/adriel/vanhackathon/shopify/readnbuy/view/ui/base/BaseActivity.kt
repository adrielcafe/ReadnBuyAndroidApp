package cafe.adriel.voxrecorder.view.ui.base

import android.content.Context
import android.os.Bundle
import android.support.v4.view.LayoutInflaterCompat
import android.support.v7.app.AppCompatActivity
import com.eightbitlab.rxbus.Bus
import com.mikepenz.iconics.context.IconicsLayoutInflater
import com.tsengvn.typekit.TypekitContextWrapper

abstract class BaseActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        LayoutInflaterCompat.setFactory(layoutInflater, IconicsLayoutInflater(delegate))
        super.onCreate(savedInstanceState)
    }

    override fun attachBaseContext(newBase: Context?) {
        super.attachBaseContext(TypekitContextWrapper.wrap(newBase))
    }

    override fun onDestroy() {
        super.onDestroy()
        Bus.unregister(this)
    }

}