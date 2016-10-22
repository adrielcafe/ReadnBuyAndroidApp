package cafe.adriel.voxrecorder.view.ui.base

import android.content.Context
import android.support.v7.app.AppCompatActivity
import com.eightbitlab.rxbus.Bus
import com.tsengvn.typekit.TypekitContextWrapper

abstract class BaseActivity: AppCompatActivity() {

    override fun attachBaseContext(newBase: Context?) {
        super.attachBaseContext(TypekitContextWrapper.wrap(newBase))
    }

    override fun onDestroy() {
        super.onDestroy()
        Bus.unregister(this)
    }

}