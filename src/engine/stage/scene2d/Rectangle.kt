package engine.stage.scene2d

import engine.stage.Actor
import java.awt.Color
import java.awt.Graphics

class Rectangle(var x: Int, var y: Int, val width: Int, val height: Int, val color: Color? = Color.gray) : Actor {
    override fun draw(g: Graphics, color: Color) {
        g.color = color
        g.fillRect(x, y, width, height)
    }

    override fun draw(g: Graphics) {
        g.color = this.color
        g.fillRect(x, y, width, height)
    }
}