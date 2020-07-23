package engine

import java.awt.Graphics

interface IGameLoop {
    fun render(g: Graphics) {}
    fun update() {}
}