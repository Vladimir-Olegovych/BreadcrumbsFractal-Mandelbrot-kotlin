package gigcreator.fractal.math

import gigcreator.fractal.models.Complex
import kotlin.math.sqrt
import kotlin.random.Random

class FractalMath {

    private var iterations = 200
    private var zoom = 200F

    private var positionX = 0F
    private var positionY = 0F

    private var scale = 1F
    fun setX(position: Float){
        positionX = position * scale
    }
    fun setY(position: Float){
        positionY = position * scale
    }
    fun upZoom(){
        scale /= 0.95F
        zoom /= 0.95F
    }
    fun downZoom(){
        scale *= 0.95F
        zoom *= 0.95F
    }

    fun addIterations(){
        iterations += 50
    }

    fun getFractal(action: (color: Float, x: Int, y: Int) -> Unit){
        for (y in (-WIDTH/2).toInt() until (WIDTH / 2).toInt()){
            for (x in (-HEIGHT/2).toInt() until (HEIGHT / 2).toInt()){
                var z = Complex(0.0, 0.0)
                var i = 0.0
                while (i < iterations && abs(z) < 2){
                    z = sqr(z) + Complex(1.0 * (x - positionX) / zoom, 1.0 * (y - positionY) / zoom)
                    ++i
                }
                if (abs(z) >= 2)
                {

                    val col = ((50.0 - i) / 50.0).toFloat()
                    action(col, x, y)
                }
            }
        }
    }
    private fun abs(v: Complex): Double {
        return sqrt(v.re * v.re + v.im * v.im)
    }

    private fun sqr(v: Complex): Complex {
        return Complex(v.re * v.re - v.im * v.im, 2 * v.re * v.im)
    }

    companion object {
        const val WIDTH = 800F
        const val HEIGHT = 800F
    }
}