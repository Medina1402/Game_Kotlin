import engine.Display
import engine.Display.Companion.ClearScreen
import engine.IGameLoop
import engine.math.geometry.Rectangle
import engine.scene.Stage
import java.awt.Color.blue
import java.awt.Color.green
import java.awt.Graphics

class Main : IGameLoop {
    var stage = Stage()
    var rectangle = Rectangle(0, 0, 25, 25)

    init {
        stage.add(rectangle)
    }

    override fun update() {
        rectangle.vector.x++
        rectangle.vector.y += 2
    }

    override fun render(g: Graphics) {
        ClearScreen(g, green)

        g.color = blue
        stage.draw(g)
    }
}


fun main() {
    val game = Display()

    game.addScreen(Main())
    game.start()
}