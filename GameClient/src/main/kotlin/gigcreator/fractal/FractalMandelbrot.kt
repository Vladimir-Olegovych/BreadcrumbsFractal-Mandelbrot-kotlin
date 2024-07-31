package gigcreator.fractal

import com.badlogic.gdx.Game
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.Input
import com.badlogic.gdx.math.Vector3
import gigcreator.fractal.math.FractalMath
import gigcreator.fractal.render.FractalRender


class FractalMandelbrot: Game() {

    private val fractalMath = FractalMath()
    private val fractalRender = FractalRender(fractalMath)

    override fun create() {
        fractalRender.create()
        Gdx.gl.glClearColor(255/255F, 255/255F, 255/255F, 1F)
    }

    override fun render() {
        when {
            Gdx.input.isKeyPressed(Input.Keys.NUMPAD_0) -> fractalMath.addIterations()
            Gdx.input.isKeyPressed(Input.Keys.SPACE) -> fractalMath.upZoom()
            Gdx.input.isButtonPressed(Input.Buttons.LEFT) -> mouseUpdate()
            Gdx.input.isButtonPressed(Input.Buttons.RIGHT) -> {
                mouseUpdate()
                fractalMath.upZoom()
            }
        }
        fractalRender.render()
    }
    private fun mouseUpdate(){
        val mouseX = Gdx.input.x.toFloat()
        val mouseY = Gdx.input.y.toFloat()
        val clickedPoint = fractalRender.camera.unproject(Vector3(mouseX, mouseY, 0f))
        fractalMath.setX(clickedPoint.x)
        fractalMath.setY(clickedPoint.y)
    }

    override fun dispose() {
        fractalRender.dispose()
    }
}