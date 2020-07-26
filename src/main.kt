import engine.Display
import engine.Display.Companion.ClearScreen
import engine.IGameLoop
import engine.controller.Keyboard
import engine.math.geometry.Rectangle
import engine.scene.Stage
import engine.tools.Image
import java.awt.Color.blue
import java.awt.Color.green
import java.awt.Graphics
import java.io.File
import java.net.URL

class Main(game: Display) : IGameLoop {
    var stage = Stage()
    var rectangle = Rectangle(0, 0, 500, 120)
    var image: Image = Image("rayman.jpg")

    init {
        image.vector.width = rectangle.vector.width
        image.vector.height = rectangle.vector.height

        game.addKeyListener(Keyboard())
//        stage.add(rectangle)
    }

    override fun update() {
        if(Keyboard.IsPressed(Keyboard.A) && rectangle.vector.x >= 0 ) rectangle.vector.x -= 5
        if(Keyboard.IsPressed(Keyboard.D) && Display.Width > rectangle.vector.x + rectangle.vector.width) rectangle.vector.x += 5
        if(Keyboard.IsPressed(Keyboard.W) && rectangle.vector.y >= 0) rectangle.vector.y -= 5
        if(Keyboard.IsPressed(Keyboard.S) && Display.Height > rectangle.vector.y + rectangle.vector.height) rectangle.vector.y += 5

        image.vector.x = rectangle.vector.x
        image.vector.y = rectangle.vector.y
    }

    override fun render(g: Graphics) {
        ClearScreen(g, green)

        g.color = blue
        image.render(g)
        stage.draw(g)
    }
}


fun main() {
    val game = Display()
    game.addScreen(Main(game))
    game.start()
}