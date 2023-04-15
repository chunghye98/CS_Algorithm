# 13335번 트럭

import sys
# queue 보다 사용 가능한 메서드가 더 많은 deque를 사용했다.
from collections import deque

input_line = sys.stdin.readline

n, w, L = list(map(int, input_line().rstrip().split()))
trucks = deque(list(map(int, input_line().rstrip().split())))
bridge = deque([0] * w)
time = 0

while not (sum(bridge) == 0 and not trucks):  # 다리가 비어 있지 않으면서 트럭 대기열에 트럭이 없을 때 까지
    bridge.popleft()
    time += 1
    if trucks and (trucks[0] + sum(bridge)) <= L:  # 다리에 새로운 truck이 추가 되어도 최대 하중 이하일 때
        bridge.append(trucks.popleft())
    else:
        bridge.append(0)


print(time)
