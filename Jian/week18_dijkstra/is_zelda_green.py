# 4485번, 녹색 옷 입은 애가 젤다지?
import sys
import heapq
input = sys.stdin.readline
INF = int(1e9)
dx = [-1, 1, 0, 0]
dy = [0, 0, 1, -1]
tc = 1

def dijkstra():
    q = []
    distance[0][0] = graph[0][0]
    # 거리, x좌표, y좌표
    heapq.heappush(q, (distance[0][0], 0, 0))  # 맨 앞의 값(거리)을 기준으로 정렬

    while q:
        dist, x, y = heapq.heappop(q)
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if nx < 0 or nx >= n or ny < 0 or ny >= n:  # 범위 초과
                continue
            cost = dist + graph[nx][ny]
            if distance[nx][ny] > cost:  # 최소 거리 갱신해야 한다면
                distance[nx][ny] = cost
                heapq.heappush(q, (cost, nx, ny))


while True:
    n = int(input().rstrip())
    if n == 0:  # 테스트 케이스 끝
        break
    graph = [list(map(int, input().rstrip().split())) for _ in range(n)]
    distance = [[INF] * n for _ in range(n)]

    dijkstra()
    print(f"Problem {tc}: {distance[n-1][n-1]}")
    tc += 1
