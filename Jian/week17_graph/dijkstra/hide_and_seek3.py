# 13549번, 숨바꼭질 3, 다익스트라
import sys
import heapq
input = sys.stdin.readline

def dijkstra(n):
    q = []
    heapq.heappush(q, (0, n))
    distance[n] = 0
    while q:
        dist, now = heapq.heappop(q)
        if distance[now] < dist:  # 최단거리보다 클 경우
            continue
        for nx in [now-1, now+1, now*2]:
            if nx < 0 or nx >= 100001:  # 범위 초과
                continue
            if nx == now*2 and distance[nx] > dist:
                distance[nx] = dist
                heapq.heappush(q, (dist, nx))
            elif distance[nx] > dist + 1:
                distance[nx] = dist + 1
                heapq.heappush(q, (dist+1, nx))


N, K = map(int, input().rstrip().split())  # 수빈이 위치, 동생 위치
INF = int(1e9)
distance = [INF for _ in range(100001)]

if K <= N: # 수빈이보다 동생이 뒤에 있으면
    print(N-K)
else:
    dijkstra(N)
    print(distance[K])

