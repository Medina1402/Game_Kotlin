package engine.tools

import java.awt.Image
import java.io.File
import javax.imageio.ImageIO

class File {
    companion object {
        var Path: String = "src/assets/"

        fun LoadImage(path: String): Image {
            return ImageIO.read(File(Path + path).absoluteFile)
        }
    }
}