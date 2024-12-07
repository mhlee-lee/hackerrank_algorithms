import kotlin.math.min

/*
 * Complete the 'pageCount' function below.
 *
 * The function is expected to return an INTEGER.
 * The function accepts following parameters:
 *  1. INTEGER n
 *  2. INTEGER p
 */

/*
 * 1페이지 부터 넘길경우
 * p/2 에서 소수점 버린것이 넘길 페이지
 * 끝페이지에서 넘길경우
 * n이 홀수인경우 (n-p)/2 의 값에서 소수점 버린것이 넘길 페이지
 * n이 짝수인경우 (n-p)/2 의 값에서 소수점 올림한것이 넘길 페이지
 * n 이 짝수인경우 +1 해서 홀수로 만들고 버려서 처리함
 */
// 1페이지 부터 넘길경우
// 홀수 페이지인 경우 마지막장은 n-1, n 이 존재
fun pageCount(n: Int, p: Int): Int {
    // Write your code here
    val newN = if (n%2 == 0) n+1 else n
    return min(p/2, (newN - p)/2)
}

fun main(args: Array<String>) {
    val n = readLine()!!.trim().toInt()

    val p = readLine()!!.trim().toInt()

    val result = pageCount(n, p)

    println(result)
}
