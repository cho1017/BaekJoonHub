fun main(){
    var num = readLine()!!.toInt()
    var cnt : Int = 0
    var temp : Int

    if (num<10){
        num *=10
    }
    var n2 : Int = num%10
    var n1 : Int = num/10

    while (true){
        temp = n2
        n2 = (n1+n2)%10
        n1 = temp
        cnt +=1
        if (num==n1*10 + n2) break
    }
    println(cnt)
}