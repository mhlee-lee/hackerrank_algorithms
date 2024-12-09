import kotlin.collections.*
import kotlin.io.*
import kotlin.math.max
import kotlin.text.*

/*
 * Complete the 'minimumNumber' function below.
 *
 * The function is expected to return an INTEGER.
 * The function accepts following parameters:
 *  1. INTEGER n
 *  2. STRING password
 */
val oneConditions = '0'.code..'9'.code
val twoConditions = 'a'.code..'z'.code
val threeConditions = 'A'.code..'Z'.code
val fourConditions = "!@#\$%^&*()-+"

fun minimumNumber(n: Int, password: String): Int {
    // Return the minimum number of characters to make the password strong
    var requiredNumber = 0
    if (n < 6) requiredNumber = 6 - n
    val required = mutableListOf(false, false, false, false)
    password.forEach {
        if (it.code in oneConditions) required[0] = true
        if (it.code in twoConditions) required[1] = true
        if (it.code in threeConditions) required[2] = true
        if (it in fourConditions) required[3] = true
    }

    return max(required.count { !it }, requiredNumber)
}

fun main(args: Array<String>) {
    val n = readLine()!!.trim().toInt()

    val password = readLine()!!

    val answer = minimumNumber(n, password)

    println(answer)
}
