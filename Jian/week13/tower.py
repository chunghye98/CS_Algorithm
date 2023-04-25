# 2493번, 탑
from collections import deque

N = int(input())
tower = deque(list(map(int, input().split())))  # stack으로 사용
stack = []  # [높이, index+1] 형태로 넣어준다.
result = [0] * N

for i in range(N-1, -1, -1):
    while stack:  # stack == 0, tower == 0
        if tower[-1] > stack[-1][0]:  # 오른쪽 타워보다 왼쪽 타워가 더 높으면
            result[stack[-1][1]] = (len(tower))  # 결과에 왼쪽 타워의 index를 넣는다.
            stack.pop()  # stack에서 제거
        else:  # stack과 비교 중단.
            break  # while stack: 탈출
    stack.append([tower.pop(), i])

for i in range(len(stack)):  # stack에 타워가 남아있으면
    result[stack[i][1]] = 0  # 비교할 타워가 없으므로 0을 넣어준다.

for i in range(N):
    print(result[i], end=" ")


