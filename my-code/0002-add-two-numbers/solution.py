# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution(object):
    def addTwoNumbers(self, l1, l2):
        """
        :type l1: Optional[ListNode]
        :type l2: Optional[ListNode]
        :rtype: Optional[ListNode]
        """
        head = ListNode(0)
        current = head
        carry = 0
        
        # Keep going as long as there is something to add
        while l1 or l2 or carry:
            # 1. Get the values (use 0 if the list is finished)
            v1 = l1.val if l1 else 0
            v2 = l2.val if l2 else 0
            
            # 2. Add the numbers and the carry
            total = v1 + v2 + carry
            carry = total // 10      # How much to carry over
            digit = total % 10       # The digit to keep
            
            # 3. Add the digit to our new list
            current.next = ListNode(digit)
            current = current.next
            
            # 4. Move to the next nodes
            if l1: l1 = l1.next
            if l2: l2 = l2.next
                
        return head.next
