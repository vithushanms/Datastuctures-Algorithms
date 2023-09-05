class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None


def hasCycle(head: Optional[ListNode]) -> bool:
    slow, fast = head, head

    while (fast != None and fast.next != None):
        fast = fast.next.next
        slow = slow.next
        if(slow == fast):
            return True

    return False

if __name__ == "__main__":
    print(hasCycle([-1, 0, 1, 2, -1, -4]))
