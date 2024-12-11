package leetcode

fun lengthOfLongestSubstring(s: String): Int {
    val seenMap = mutableMapOf<Char,Int>()
    var startIdx = 0
    var maxLength = 0

    s.forEachIndexed { endIdx, c ->
        val exist = seenMap[c]

        if (exist != null && exist >= startIdx) {
            startIdx = exist + 1
        }

        seenMap[c] = endIdx

        maxLength = maxOf(maxLength, endIdx - startIdx + 1)
    }
    return maxLength
}

fun main() {
    println(lengthOfLongestSubstring("aab"))
    println(lengthOfLongestSubstring("abba"))
    println(lengthOfLongestSubstring("abcabcbb"))
    println(lengthOfLongestSubstring("bbbbb"))
    println(lengthOfLongestSubstring("pwwkew"))
    println(lengthOfLongestSubstring(" "))
}
