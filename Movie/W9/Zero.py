import sys

caseNumber = int(sys.stdin.readline())
stack = []
for i in range(caseNumber):
    n = int(sys.stdin.readline())
    if n != 0:
        stack.append(n)
    else:
        stack.pop()

print(sum(stack[:]))



