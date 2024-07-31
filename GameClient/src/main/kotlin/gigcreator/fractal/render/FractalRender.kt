package gigcreator.fractal.render

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.GL20
import com.badlogic.gdx.graphics.OrthographicCamera
import com.badlogic.gdx.graphics.glutils.ShapeRenderer
import gigcreator.fractal.math.FractalMath

class FractalRender(private val fractalMath: FractalMath) {

    private lateinit var shapeRender: ShapeRenderer
    val camera = OrthographicCamera(FractalMath.WIDTH, FractalMath.HEIGHT)

    fun dispose() {
        shapeRender.dispose()
    }

    fun create(){
        shapeRender = ShapeRenderer()
        shapeRender.projectionMatrix = camera.combined
    }
    fun render(){
        update()
        shapeRender.begin(ShapeRenderer.ShapeType.Filled)
        fractalMath.getFractal { color, x, y ->
            shapeRender.setColor(color, color, color, color)
            shapeRender.circle(x.toFloat(), y.toFloat(), 1F)
        }
        shapeRender.end()
    }

    private fun update(){
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT)
        camera.update()
    }
}