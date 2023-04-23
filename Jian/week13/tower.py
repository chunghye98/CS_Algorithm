# 2493번, 탑
from collections import deque

N = int(input())
tower = deque(list(map(int, input().split())))  # stack으로 사용
stack = deque()
result = deque()

for _ in range(N):
    while stack:  # stack == 0, tower == 0
        if tower[-1] > stack[-1]:  # 오른쪽 타워보다 왼쪽 타워가 더 높으면
            result.append(len(tower))  # 결과에 왼쪽 타워의 index를 넣는다.
            stack.pop()  # stack에서 제거
        else:  # stack과 비교 중단.
            break  # while stack: 탈출
    stack.append(tower.pop())

for _ in stack:  # stack에 타워가 남아있으면
    result.append(0)  # 비교할 타워가 없으므로 0을 넣어준다.

for _ in range(len(result)):
    print(result.pop(), end=" ")


