package leetcode

fun findMedianSortedArrays(nums1: IntArray, nums2: IntArray): Double {
    val totalLength = nums1.size + nums2.size
    val isOdd = totalLength % 2 == 1
    val searchCount = totalLength/2 + 1

    val a = mutableListOf<Int>()
    var num1Index = 0
    var num2Index = 0
    for (i in 0 until searchCount) {
        val num1 = nums1.getOrNull(num1Index) ?: Int.MAX_VALUE
        val num2 = nums2.getOrNull(num2Index) ?: Int.MAX_VALUE

        if (num1 <= num2) {
            a.add(nums1[num1Index])
            num1Index++
        } else {
            a.add(nums2[num2Index])
            num2Index++
        }

        if (num1Index + num2Index == searchCount) break
    }

    return if (isOdd) a[a.size - 1].toDouble() else (a[a.size-1] + a[a.size -2]).toDouble()/2.0
}

fun main() {
    println(findMedianSortedArrays(intArrayOf(1,3), intArrayOf(2)))
    println(findMedianSortedArrays(intArrayOf(1,2), intArrayOf(3,4)))
}
