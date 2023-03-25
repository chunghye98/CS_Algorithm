import sys
# 10773, 제로

k = int(sys.stdin.readline().rstrip())
stack = []

for _ in range(k):
    n = int(sys.stdin.readline().rstrip())
    if n == 0:
        stack.pop()
    else:
        stack.append(n)

print(sum(stack))
