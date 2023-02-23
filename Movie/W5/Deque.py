import sys
from collections import deque

caseNumber = int(sys.stdin.readline())
d = deque()

for i in range(caseNumber):
    command = sys.stdin.readline().strip().split()
    if command[0] == "push_front":
        d.appendleft(int(command[1]))
    elif command[0] == "push_back":
        d.append(int(command[1]))
    elif command[0] == "pop_front":
        if len(d) == 0:
            print("-1")
        else:
            print(d.popleft())
    elif command[0] == "pop_back":
        if len(d) == 0:
            print("-1")
        else:
            print(d.pop())
    elif command[0] == "size":
        print(len(d))
    elif command[0] == "empty":
        if len(d) == 0:
            print("1")
        else:
            print("0")
    elif command[0] == "front":
        if len(d) == 0:
            print("-1")
        else:
            print(d[0])
    elif command[0] == "back":
        if len(d) == 0:
            print("-1")
        else:
            print(d[-1])
