const val num = 1_000_000
const val P = num / 10 * 15
    
fun main() {
    val n = readLine()!!.toLong()
    val fib = IntArray(P)
    fib[0] = 0
    fib[1] = 1

    for (i in 2 until P) {
        fib[i] = (fib[i - 1] + fib[i - 2]) % num
    }

    println(fib[(n % P).toInt()])
}
