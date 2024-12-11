package leetcode

/**
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */
class ListNode(var `val`: Int) {
    var next: ListNode? = null
}


fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
    var nextL1 = l1
    var nextL2 = l2
    var result: ListNode? = null
    var currentNode: ListNode? = null

    var carry = 0
    while (nextL1 != null || nextL2 != null) {
        val value = (nextL1?.`val` ?: 0) + (nextL2?.`val` ?: 0) + carry
        carry = value/10
        nextL1 = nextL1?.next
        nextL2 = nextL2?.next

        val newNode = ListNode(value%10)
        if (result == null) result = newNode
        if (currentNode == null) currentNode = newNode
        else {
            currentNode.next = newNode
            currentNode = newNode
        }
    }
    if (carry > 0) {
        currentNode!!.next = ListNode(carry)
    }

    return result
}

