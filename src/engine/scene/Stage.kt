package engine.scene

import java.awt.Graphics

class Stage : Actor {
    private var actors: ArrayList<Actor> = ArrayList()

    fun add(actor: Actor) {
        actors.add(actor)
    }

    override fun draw(g: Graphics) {
        actors.forEach { actor -> actor.draw(g) }
    }
}