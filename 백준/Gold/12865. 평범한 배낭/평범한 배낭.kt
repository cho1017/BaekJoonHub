fun main() {
    val (n, max_k) = readLine()!!.split(" ").map { it.toInt() }

    val items = mutableListOf<Pair<Int, Int>>() 
    for (i in 1..n) {
        val (w, v) = readLine()!!.split(" ").map { it.toInt() }
        items.add(Pair(w, v))
    }
    
    val dp = IntArray(max_k + 1)

    for ((weight, value) in items) {

        for (j in max_k downTo weight) {
            dp[j] = maxOf(dp[j], dp[j - weight] + value)
        }
    }
    
    println(dp[max_k])
}