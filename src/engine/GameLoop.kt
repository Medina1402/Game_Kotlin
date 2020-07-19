package engine

import java.awt.Graphics

interface GameLoop {
    fun update() {}
    fun render(g: Graphics, delta: Double) {}
}