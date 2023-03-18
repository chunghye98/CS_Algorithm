# 오큰수
## 파이썬에서는 Luke 가 푼 대로 풀면 시간초과가 나더라..
import sys
from collections import deque

n = int(input())
inputArr = list(map(int, sys.stdin.readline().split()))
deque = deque()
answer = [] * 3

for i in range(n-1, -1, -1):
    while len(deque) != 0 and deque[len(deque)-1] <= inputArr[i]:
        deque.pop()
    answer.insert(0, -1 if len(deque) == 0 else deque[len(deque)-1]) # 파이썬 삼항 연산자
    deque.append(inputArr[i])

print(*answer)
