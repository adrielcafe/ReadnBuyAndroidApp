package cafe.adriel.voxrecorder.view.ui.base

import android.support.v4.app.Fragment
import com.eightbitlab.rxbus.Bus

abstract class BaseFragment: Fragment() {

    override fun onDestroyView() {
        super.onDestroyView()
        Bus.unregister(this)
    }

}