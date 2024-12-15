package leetcode;

// RemoveNthNodeFromEndOfList
public class RemoveNthNodeFromEndOfList {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode resolve(ListNode head, int n) {
        int nodeCount = 0;
        for (ListNode c = head ; c != null ; c = c.next) nodeCount++;
        n = nodeCount - n + 1;

        int currnetN = 1;
        ListNode result = null;
        ListNode prev = null;
        while (head != null) {
            if (currnetN != n) {
                if (result == null) result = head;
                if (prev != null) prev.next = head;
                prev = head;
            }

            head = head.next;
            currnetN++;
        }

        if (prev != null) prev.next = null;

        return result;
    }

    public static void main(String[] args) {
        RemoveNthNodeFromEndOfList problem = new RemoveNthNodeFromEndOfList();
        problem.resolve(new ListNode(1, new ListNode(2)), 1);
    }
}
