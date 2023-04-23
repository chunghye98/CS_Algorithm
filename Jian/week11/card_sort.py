# 1715번, 카드 정렬하기
# 생각 과정
# 1. 일단 정렬
# 2. 최대한 비슷한 크기의 숫자들끼리 더해지게 만든다
# 모르겠어서 알고리즘 분류 확인 -> 반례 확인 -> 블로그 확인 -> 다음날 다시 품
# ** 더해진 숫자를 다시 큐에 넣는 걸 생각 못함. **

import sys
import heapq
input_line = sys.stdin.readline

n = int(input_line().rstrip())
cards = []
result = 0

for _ in range(n):
    heapq.heappush(cards, int(input_line().rstrip()))

if n < 2:  # 두 묶음이 되지 않기 때문에 하나로 만드는 로직을 실행 시킬 수 없다.
    print(0)
else:
    while len(cards) > 1:
        sum = heapq.heappop(cards) + heapq.heappop(cards)
        heapq.heappush(cards, sum)
        result += sum
    print(result)
