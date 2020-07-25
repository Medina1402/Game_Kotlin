package engine

import engine.controller.Keyboard
import java.awt.Canvas
import java.awt.Color
import java.awt.Graphics
import java.awt.Toolkit
import java.awt.event.WindowEvent
import java.awt.event.WindowFocusListener
import java.awt.image.BufferStrategy
import javax.swing.JFrame
import javax.swing.JFrame.EXIT_ON_CLOSE

class Display : Canvas(), Runnable, WindowFocusListener {
    companion object {
        var Width: Int = Toolkit.getDefaultToolkit().screenSize.width
        var Height: Int = Toolkit.getDefaultToolkit().screenSize.height

        @Synchronized
        fun ClearScreen(g: Graphics, color: Color = Color.gray) {
            g.color = color
            g.fillRect(0, 0, Width, Height)
        }
    }

    private var running: Boolean = true
    private var loadBuffer = false
    private var index = 0

    private var screens: ArrayList<IGameLoop> = ArrayList()
    private var frame: JFrame = JFrame()
    private lateinit var thread: Thread

    /**
     *
     */
    init {
        setSize(Width, Height)
        loadDefaultJFrame()
    }

    /**
     *
     */
    private fun loadDefaultJFrame() {
        frame.setSize(Width, Height)
        frame.isUndecorated = true
        frame.isVisible = true
        frame.defaultCloseOperation = EXIT_ON_CLOSE
        frame.add(this)
        frame.pack()
        frame.setLocationRelativeTo(null)
        frame.addWindowFocusListener(this)
    }

    /**
     *
     */
    fun addScreen(screen: IGameLoop) {
        screens.add(screen)
    }

    /**
     *
     */
    fun screenRoot(index: Int) {
        this.index = index
    }

    /**
     *
     */
    @Synchronized
    fun start() {
        thread = Thread(this, this::class.simpleName)
        thread.start()
    }

    /**
     *
     */
    override fun run() {
        var lastTime: Long = System.nanoTime()
        var timer: Long = System.currentTimeMillis()
        val ns: Double = 1e9 / 60
        var delta = 0.0
        var frames = 0

        while (running) {
            val now: Long = System.nanoTime()
            delta += (now - lastTime) / ns
            lastTime = now

            while (delta >= 1) {
                screens[index].update()
                delta--
            }
            renderer(delta)
            frames++

            if (System.currentTimeMillis() - timer > 1000) {
                timer += 1000
                frame.title = " title | $frames fps | $delta delta"
                frames = 0
            }
        }
        stop()
    }

    /**
     *
     */
    private fun renderer(delta: Double) {
        if (!loadBuffer) {
            loadBuffer = true
            createBufferStrategy(3)
            return
        }

        val buffer: BufferStrategy = this.bufferStrategy
        val g = buffer.drawGraphics
        screens[index].render(g)
        g.dispose()
        buffer.show()
    }

    /**
     *
     */
    @Synchronized
    fun stop() {
        running = false
        thread.join()
    }

    /**
     *
     */
    override fun windowLostFocus(e: WindowEvent?) {
        Keyboard.codes.forEachIndexed { index, code -> if(code==1) Keyboard.codes[index]=0 }
    }

    /**
     *
     */
    override fun windowGainedFocus(e: WindowEvent?) {}
}