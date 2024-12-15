package leetcode;

public class TwoNumbers {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode head = null;
        ListNode tail = null;

        while (l1 != null || l2 != null) {
            int sum = ((l1 != null) ? l1.val : 0) + ((l2 != null) ? l2.val : 0) + carry;
            carry = sum / 10;
            ListNode newNode = new ListNode(sum % 10);

            if (head == null) head = newNode;
            if (tail == null) tail = newNode;
            else {
                tail.next = newNode;
                tail = newNode;
            }

            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }

        if (carry > 0) tail.next = new ListNode(carry);

        return head;
    }

    public static void main(String[] args) {
        TwoNumbers problem = new TwoNumbers();
    }

}
