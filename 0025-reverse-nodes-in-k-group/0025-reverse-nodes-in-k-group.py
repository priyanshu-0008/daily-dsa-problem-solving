# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def reverseKGroup(self, head: Optional[ListNode], k: int) -> Optional[ListNode]:
        if not head or k==1:
            return head
        dummy = ListNode(0)
        dummy.next = head
        prev = dummy
        curr = head

        cnt = 0
        while curr:
            cnt+=1
            curr = curr.next
        
        while cnt>=k:
            curr = prev.next
            nxt = curr.next

            for _ in range(1,k):
                curr.next = nxt.next
                nxt.next = prev.next
                prev.next = nxt
                nxt = curr.next
            prev = curr
            cnt-=k
        return dummy.next
