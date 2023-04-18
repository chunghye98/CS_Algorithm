# 2531번, 회전 초밥
import sys
import itertools
from collections import deque
input_line = sys.stdin.readline


N, d, k, c = map(int, input_line().rstrip().split())
sushi = deque()
result = 0

for _ in range(N):  # 초밥 넣기
    sushi.append(int(input_line().rstrip()))

for _ in range(N):  # 연속해서 먹는 가짓 수(k) 판별하기
    eat = list(itertools.islice(sushi, 0, k))
    if len(eat) == len(set(eat)):
        if c in eat:  # 쿠폰 번호가 현재 배열에 있으면
            result = k
        else:  # 쿠폰 번호가 현재 배열에 없으면
            result = k+1
            break
    sushi.append(sushi.popleft())  # 판별하지 못한 초밥은 계속 뒤에 넣어준다

print(result)
