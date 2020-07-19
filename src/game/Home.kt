package game

import engine.Application
import engine.screen.Screen
import engine.stage.Stage
import engine.stage.scene2d.Rectangle
import java.awt.Color
import java.awt.Graphics

class Home(application: Application) : Screen(application) {
    private val stage: Stage = Stage()
    private val rect = Rectangle(0, 0, Application.WIDTH, Application.HEIGHT / 2, Color.CYAN)

    init {
        stage.addActor(rect)
    }

    override fun update() {
        rect.y += 1
        if(rect.y >= 500) app.isPause = true
    }

    override fun render(g: Graphics, delta: Double) {
        Application.ClearScreen(g, Color.red)
        stage.draw(g)
        g.font = g.font.deriveFont(g.font.size * 5f)
    }
}