import java.math.BigInteger

tailrec fun factorial(n: Int, acc: BigInteger = BigInteger.ONE): BigInteger {
    return if (n <= 1) acc
    else return factorial(n - 1, acc * BigInteger.valueOf(n.toLong()))
}

fun main(){

    val T = readLine()!!.toInt()
    val ans = Array<BigInteger>(T) { BigInteger.ZERO }
    var input: List<Int>
    for (i in 1..T){
        input = readLine()!!.split(" ").map { it.toInt() }
        if(input[0] == input[1]) ans[i-1] = BigInteger.ONE
        else{
        ans[i-1] = factorial(input[1]) / (factorial(input[1] - input[0]) * factorial(input[0]))
        }
    }
    for (i in 1..T){
        println(ans[i-1])
    }

}
