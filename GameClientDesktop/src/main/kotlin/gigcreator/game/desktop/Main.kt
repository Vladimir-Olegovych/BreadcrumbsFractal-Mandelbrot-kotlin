package gigcreator.game.desktop

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration
import gigcreator.fractal.FractalMandelbrot

fun main() {
    val config = Lwjgl3ApplicationConfiguration()
    config.useVsync(false)
    config.setForegroundFPS(Lwjgl3ApplicationConfiguration.getDisplayMode().refreshRate)
    config.setIdleFPS(30)
    config.setTitle("Fractal Mandelbrot")
    config.setWindowedMode(600, 600)
    Lwjgl3Application(FractalMandelbrot(), config)
}