package cafe.adriel.vanhackathon.shopify.readnbuy.view.ui.view

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.GestureDetector
import android.view.MotionEvent
import android.view.View

class RecyclerItemClickListener(context: Context, val listener: (i : Int) -> Unit) : RecyclerView.OnItemTouchListener {

    private val gestureDetector: GestureDetector
    private var childView: View? = null
    private var childViewPosition: Int = 0

    init {
        this.gestureDetector = GestureDetector(context, GestureListener())
    }

    override fun onInterceptTouchEvent(view: RecyclerView, event: MotionEvent): Boolean {
        childView = view.findChildViewUnder(event.x, event.y)
        childViewPosition = view.getChildAdapterPosition(childView)
        return childView != null && gestureDetector.onTouchEvent(event)
    }

    override fun onTouchEvent(view: RecyclerView, event: MotionEvent) {

    }

    override fun onRequestDisallowInterceptTouchEvent(disallowIntercept: Boolean) {

    }

    private inner class GestureListener : GestureDetector.SimpleOnGestureListener() {

        override fun onSingleTapUp(event: MotionEvent): Boolean {
            if (childView != null) {
                listener(childViewPosition)
            }
            return true
        }

        override fun onDown(event: MotionEvent): Boolean {
            return true
        }

    }

}