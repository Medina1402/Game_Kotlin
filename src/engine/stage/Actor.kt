package engine.stage

import java.awt.Color
import java.awt.Graphics

interface Actor {
    fun draw(g: Graphics, green: Color)
    fun draw(g: Graphics) {}
}