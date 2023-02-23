import sys


class Node:
    def __init__(self, data=None, next=None, prev=None):
        self.prev = prev
        self.data = data
        self.next = next


def printResult(cursor):
    text = ""
    if cursor.prev is not None:
        current = cursor.prev
        while current is not None:
            text = current.data + text
            current = current.prev

    if cursor.next is not None:
        current = cursor.next
        while current is not None:
            text += current.data
            current = current.next

    print(text)


abc = sys.stdin.readline().rstrip()

nodeHead = Node(abc[0])
current = nodeHead


for i in range(1, len(abc)):
    current.next = Node(abc[i])

    temp = current
    current = current.next

    current.prev = temp


T = int(sys.stdin.readline().rstrip())
cursor = Node(None)
cursor.prev = current
cursor.next = None



for i in range(0, T):
    cmd = sys.stdin.readline().rstrip()
    if cmd == "L" and cursor.prev is not None:
        cursor.next = cursor.prev
        cursor.prev = cursor.prev.prev

    elif cmd == "D" and cursor.next is not None:
        cursor.prev = cursor.next
        cursor.next = cursor.next.next

    elif cmd == "B" and cursor.prev is not None:

        if cursor.next is not None:
            cursor.next.prev = cursor.prev.prev

        if cursor.prev.prev is not None:
            cursor.prev.prev.next = cursor.next

        cursor.prev = cursor.prev.prev

    elif cmd[0] == "P":
        char = cmd[2]
        temp = Node(char)

        if cursor.next is not None:
            cursor.next.prev = temp

        if cursor.prev is not None:
            cursor.prev.next = temp

        temp.prev = cursor.prev
        temp.next = cursor.next
        cursor.prev = temp


if cursor.next is None and cursor.prev is None:
    print("")
else:
    printResult(cursor)


