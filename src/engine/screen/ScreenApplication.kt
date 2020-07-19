package engine.screen

import engine.Application
import engine.GameLoop
import java.awt.Dimension
import javax.swing.JFrame

abstract class ScreenApplication : JFrame(), Runnable, GameLoop {
    private var time: Double = 0.0
    var isPause: Boolean = false

    init {
        size = Dimension(Application.WIDTH, Application.HEIGHT)
        ignoreRepaint = true
        isUndecorated = true
        isVisible = true
        defaultCloseOperation = EXIT_ON_CLOSE
    }

    fun start() {
        val thread = Thread(this)
        thread.start()
    }

    private fun getTimeNow(): Double {
        if (time == 0.0) {
            time = System.currentTimeMillis().toDouble()
            return 0.0
        }
        val temp = (System.currentTimeMillis().toDouble()) - time
        time += temp
        return temp / 10000
    }

    override fun run() {
        while(!isPause) {
            update()
            render(graphics, getTimeNow())

            Thread.sleep((1000 / Application.FPS).toLong())
        }
    }
}