package engine.tools

import engine.math.Vector
import java.awt.Graphics
import java.awt.Image

class Image(path: String) {
    private val image: Image = File.LoadImage(path)
    var vector: Vector<Int>

    init {
        this.vector = Vector(0, 0, image.getWidth(null), image.getHeight(null))
    }

    /**
     *
     */
    fun render(g: Graphics) {
        g.drawImage(image, vector.x, vector.y, vector.width, vector.height, null)
    }
}