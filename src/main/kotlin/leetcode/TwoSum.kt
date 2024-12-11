package leetcode


fun twoSum(nums: IntArray, target: Int): IntArray {
    val numIndexes = mutableMapOf<Int, MutableList<Int>>()
    nums.forEachIndexed { index, num ->
        numIndexes.computeIfAbsent(num) { mutableListOf() }.add(index)
    }

    var result: IntArray = intArrayOf(0, 0)
    for ((num, indexes1) in numIndexes) {
        val remain = (target - num)
        val indexes2 = numIndexes[remain] ?: emptyList()
        if (remain == num) {
            if (indexes1.size > 1) {
                result = intArrayOf(indexes2[0], indexes2[1])
                break
            }
        } else if (indexes2.isNotEmpty()) {
            result = intArrayOf(indexes1[0], indexes2[0])
            break
        }
    }

    return result
}


