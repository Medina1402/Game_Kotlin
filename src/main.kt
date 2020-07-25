import engine.Display
import engine.Display.Companion.ClearScreen
import engine.IGameLoop
import engine.controller.Keyboard
import engine.math.geometry.Rectangle
import engine.scene.Stage
import java.awt.Color.blue
import java.awt.Color.green
import java.awt.Graphics

class Main(game: Display) : IGameLoop {
    var stage = Stage()
    var rectangle = Rectangle(0, 0, 40, 40)

    init {
        game.addKeyListener(Keyboard())
        stage.add(rectangle)
    }

    override fun update() {
        if(Keyboard.IsPressed(Keyboard.A) && rectangle.vector.x >= 0 ) rectangle.vector.x -= 5
        if(Keyboard.IsPressed(Keyboard.D) && Display.Width > rectangle.vector.x + rectangle.vector.width) rectangle.vector.x += 5
        if(Keyboard.IsPressed(Keyboard.W) && rectangle.vector.y >= 0) rectangle.vector.y -= 5
        if(Keyboard.IsPressed(Keyboard.S) && Display.Height > rectangle.vector.y + rectangle.vector.height) rectangle.vector.y += 5
    }

    override fun render(g: Graphics) {
        ClearScreen(g, green)

        g.color = blue
        stage.draw(g)
    }
}


fun main() {
    val game = Display()
    game.addScreen(Main(game))
    game.start()
}