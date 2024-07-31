package gigcreator.fractal.models

class Complex(var re: Double, var im: Double) {
    operator fun plus(v: Complex): Complex {
        return Complex(re + v.re, im + v.im)
    }
}