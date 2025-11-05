fun main(args: Array<String>) {
    val colors = mutableListOf<String>()
    val numbers = mutableListOf<Int>()
    var grade : Int = 0

    for (i in 1..5) {
        var input = readLine()!!.split(" ")
        colors.add(input[0])
        numbers.add(input[1].toInt())
    }
    val sort_numbers = numbers.sorted().toMutableList()
    val rem_numbers = numbers.distinct().toMutableList()
    val rem_colors = colors.distinct().toMutableList()
    val countMap = numbers.groupingBy { it }.eachCount()
    //1번 조건
    if(rem_colors.size==1 && sort_numbers[0]+1==sort_numbers[1] && sort_numbers[1]+1==sort_numbers[2] && sort_numbers[2]+1==sort_numbers[3] && sort_numbers[3]+1==sort_numbers[4]){
        grade += sort_numbers[4] + 900

    }
    //2번 조건
    else if (sort_numbers[0]==sort_numbers[1] && sort_numbers[1]==sort_numbers[2] && sort_numbers[2]==sort_numbers[3])
        grade += sort_numbers[0] + 800
    else if (sort_numbers[3]==sort_numbers[4] && sort_numbers[1]==sort_numbers[2] && sort_numbers[2]==sort_numbers[3])
        grade += sort_numbers[1] + 800
    //3번 조건
    else if (rem_numbers.size == 2 && countMap.containsValue(3)) {
        val threeNum = countMap.filterValues { it == 3 }.keys.first()
        val twoNum = countMap.filterValues { it == 2 }.keys.first()
        grade += threeNum * 10 + twoNum + 700
    }
    //4번 조건
    else if (rem_colors.size == 1){
        grade += 600 + sort_numbers[4]
    }
    //5번 조건
    else if (sort_numbers[0]+1==sort_numbers[1] && sort_numbers[1]+1==sort_numbers[2] && sort_numbers[2]+1==sort_numbers[3] && sort_numbers[3]+1==sort_numbers[4]){
        grade += 500 + sort_numbers[4]
    }
    //6번 조건
    else if(rem_numbers.size == 3 && countMap.filterValues { it == 3 }.keys.isNotEmpty()){
        val threeNum = countMap.filterValues { it == 3 }.keys.first()
        grade += threeNum + 400
    }
    //7번 조건
    else if(rem_numbers.size == 3 && countMap.filterValues { it == 2 }.size==2){
        grade += countMap.filterValues { it ==2 }.keys.max()*10 + countMap.filterValues { it ==2 }.keys.min() + 300
    }
    //8번 조건
    else if(rem_numbers.size == 4){
        grade += 200 + countMap.filterValues { it == 2 }.keys.first()
    }
    //9번 조건
    else{
        grade += numbers.max() + 100
    }
    println(grade)
}