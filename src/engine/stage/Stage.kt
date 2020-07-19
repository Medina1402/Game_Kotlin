package engine.stage

import java.awt.Color
import java.awt.Graphics

class Stage : Actor {
    private val actors: ArrayList<Actor> = ArrayList()

    fun addActor(actor: Actor) {
        actors.add(actor)
    }

    override fun draw(g: Graphics, color: Color) {
        actors.forEach { actor -> actor.draw(g, color) }
    }

    override fun draw(g: Graphics) {
        actors.forEach { actor -> actor.draw(g) }
    }
}