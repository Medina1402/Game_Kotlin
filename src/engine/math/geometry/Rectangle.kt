package engine.math.geometry

import engine.math.Vector
import engine.scene.Actor
import java.awt.Graphics

class Rectangle(x: Int, y: Int, width: Int, height: Int) : Actor {
    var vector: Vector<Int> = Vector(x, y, width, height)

    override fun draw(g: Graphics) {
        g.fillRect(vector.x, vector.y, vector.width, vector.height)
    }
}