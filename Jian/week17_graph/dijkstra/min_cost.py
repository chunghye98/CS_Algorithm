# 1916번, 최소비용 구하기
import sys
import heapq
input = sys.stdin.readline

n = int(input())  # 도시 개수
m = int(input())  # 버스 개수
graph = [[] for _ in range(n+1)]
INF = int(1e9)
distance = [INF] * (n+1)

for _ in range(m):  # 도시 연결하기
    x, y, cost = map(int, input().rstrip().split())
    graph[x].append((y, cost))

start_city, end_city = map(int, input().rstrip().split())

def dijkstra(start):
    q = []
    heapq.heappush(q, (0, start))
    distance[start] = 0
    while q:
        dist, now_city = heapq.heappop(q)
        if distance[now_city] < dist:  # 먼저 넣었어도 최단 거리에 따라 정렬 되므로, 이미 최단 거리 값이 계산되었을 수 있다.
            continue
        for next_city, cost in graph[now_city]:
            total_cost = dist + cost
            if distance[next_city] > total_cost:
                distance[next_city] = total_cost
                heapq.heappush(q, (total_cost, next_city))


dijkstra(start_city)
print(distance[end_city])
