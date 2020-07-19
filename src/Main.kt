import engine.Application
import game.Home

class Main : Application() {
    private val home: Home = Home(this)

    init {
        addScreen(home)
    }
}

fun main() {
    Main().start()
}