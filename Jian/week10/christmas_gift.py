import sys
import heapq

input = sys.stdin.readline

# 14235 크리스마스 선물
# 우선순위 큐, 힙 Max-Heapify
# 파이썬에서 heapq 는 min-heap 이다
# 문제에서는 max-heap을 요구했기 때문에 gifts(heap)에 양수인 gift(node) 를 음수로 변환시켜서 넣어줬다.
# heapq.heappush(heap, 요소) 대신 heap.append(요소) 를 하게 되면, heapq.heappop(heap) 이 제대로 수행되지 않는다.

# 실패
# a[0] 이 선물의 개수 인지 몰랐다. 중복 요소인 줄 알고 중복 요소 삭제 하는 코드를 짰었다.

n = int(input().rstrip())
gifts = []

for _ in range(n):
    a = list(map(int, input().rstrip().split()))
    if a[0] == 0:  # 아이를 만나면
        if gifts:  # 선물이 있으면
            print(heapq.heappop(gifts) * -1)  # 음수를 양수로 만들어준다.
        # print(-heapq.heappop(gifts)) 도 가능하지만 직관적이지 않을 것 같아서 위처럼 표시
        else:  # 선물이 없으면
            print(-1)
    else:  # 선물을 저장한다
        for i in range(a[0]):
            heapq.heappush(gifts, -a[i+1])  # 양수를 음수로 만들어서 넣어준다.
