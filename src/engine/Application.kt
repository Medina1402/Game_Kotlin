package engine

import engine.screen.ScreenApplication
import java.awt.Color
import java.awt.Graphics
import java.util.*

abstract class Application : ScreenApplication() {
    companion object {
        val WIDTH: Int = java.awt.Toolkit.getDefaultToolkit().screenSize.width
        val HEIGHT: Int = java.awt.Toolkit.getDefaultToolkit().screenSize.height
        var FPS: Int = 30

        fun ClearScreen(g: Graphics, color: Color) {
            g.color = color
            g.fillRect(0, 0, WIDTH, HEIGHT)
        }
    }

    private var screens: ArrayList<GameLoop> = ArrayList()
    private var screenIndex: Int = 0

    /**
     *
     */
    fun addScreen(screen: GameLoop) {
        screens.add(screen)
    }

    /**
     *
     */
    fun changeScreenRoot(screen: GameLoop) {
        screenIndex = screens.indexOf(screen)
    }

    /**
     *
     */
    fun changeScreenRoot(index: Int) {
        screenIndex = index
    }

    /**
     *
     */
    override fun update() {
        screens[screenIndex].update()
    }

    /**
     *
     */
    override fun render(g: Graphics, delta: Double) {
        screens[screenIndex].render(g, delta)
    }
}
