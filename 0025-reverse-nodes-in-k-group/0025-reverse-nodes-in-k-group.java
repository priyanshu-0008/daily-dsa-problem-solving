class Solution {

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k == 1) return head;

        ListNode temp = head;
        ListNode prevNode = null;

        while (temp != null) {

            // Find kth node
            ListNode kthNode = getKthNode(temp, k);

            // If remaining nodes < k → attach as-is
            if (kthNode == null) {
                if (prevNode != null) {
                    prevNode.next = temp;
                }
                break;
            }

            // Save next group
            ListNode nextNode = kthNode.next;
            kthNode.next = null;

            // Reverse current group
            reverse(temp);

            // Connect with previous part
            if (temp == head) {
                head = kthNode;
            } else {
                prevNode.next = kthNode;
            }

            // Update pointers
            prevNode = temp;
            temp = nextNode;
        }

        return head;
    }

    // Helper: get kth node
    private ListNode getKthNode(ListNode node, int k) {
        while (node != null && k > 1) {
            node = node.next;
            k--;
        }
        return node;
    }

    // Helper: reverse linked list
    private void reverse(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
    }
}
