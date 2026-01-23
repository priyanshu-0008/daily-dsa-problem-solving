class Solution {

    public static ListNode reverse(ListNode head) {
        ListNode curr = head;
        ListNode prev = null;

        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || left == right) return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        // move ans to (left - 1)
        ListNode ans = dummy;
        for (int i = 1; i < left; i++) {
            ans = ans.next;
        }

        // isolate sublist
        ListNode start = ans.next;
        ListNode end = start;
        for (int i = left; i < right; i++) {
            end = end.next;
        }

        ListNode rest = end.next;
        end.next = null;

        // reverse sublist
        ListNode rev = reverse(start);

        // reconnect
        ans.next = rev;
        start.next = rest;

        return dummy.next;
    }
}
