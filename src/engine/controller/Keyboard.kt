package engine.controller

import java.awt.event.KeyEvent
import java.awt.event.KeyListener

open class Keyboard: KeyListener {
    companion object {
        var codes: IntArray = IntArray(255)
        const val A: Int = 65
        const val D: Int = 68
        const val S: Int = 83
        const val W: Int = 87

        fun IsPressed(code: Int): Boolean {
            return codes[code] == 1
        }
    }

    override fun keyTyped(e: KeyEvent?) {
//        println(e)
    }

    override fun keyPressed(e: KeyEvent?) {
        codes[e?.keyCode!!] = 1

    }

    override fun keyReleased(e: KeyEvent?) {
        codes[e?.keyCode!!] = 0
    }
}