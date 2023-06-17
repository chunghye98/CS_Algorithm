# 18352번, 특정 거리의 도시 찾기
# 틀린 이유: 다익스트라 함수의 처음 부분에, 시작 도시의 거리를 0으로 초기화해주지 않았다.
import sys
import heapq
readl = sys.stdin.readline
INF = int(1e9) # 무한을 의미하는 10억 넣기

N, M, K, X = map(int, readl().rstrip().split())  # 도시의 개수, 도로의 개수, 거리 정보, 출발 도시의 번호
graph = [[] for _ in range(N+1)]
distance = [INF] * (N+1)

for i in range(M):  # 도로의 개수만큼 입력 받기
    A, B = map(int, readl().rstrip().split())  # 연결 된 도시
    graph[A].append(B)  # 단방향 연결

def dijkstra():
    q = []
    heapq.heappush(q, (0, X))
    distance[X] = 0
    while q:
        dist, cityA = heapq.heappop(q)  # 최단 거리 부터 빼준다.
        if distance[cityA] < dist:  # heapq로 min 값 부터 탐색하므로 dist가 더 클 경우, 계산할 필요 없음.
            continue
        for cityB in graph[cityA]:
            cost = dist + 1
            if cost < distance[cityB]:  # cityA를 들렀다가 cityB를 가는게 최소 거리 일 때
                distance[cityB] = cost  # 최단 거리 갱신
                heapq.heappush(q, (cost, cityB))  #

dijkstra()

result = []
for i in range(N+1):
    if distance[i] == K:  # 최단 거리에 맞는 친구가 있으면
        result.append(i)  # city 번호를 넣는다.

if len(result) == 0:  # 비어있으면
    print(-1)
else:
    for i in result:  # 도시 출력
        print(i)
