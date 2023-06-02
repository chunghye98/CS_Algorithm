# 4485번, 녹색 옷 입은 애가 젤다지?
import sys
from collections import deque
input = sys.stdin.readline
INF = int(1e9)
dx = [-1, 1, 0, 0]
dy = [0, 0, 1, -1]
tc = 1

while True:
    n = int(input().rstrip())
    if n == 0:  # 테스트 케이스 끝
        break
    graph = [list(map(int, input().rstrip().split())) for _ in range(n)]
    distance = [[INF] * n for _ in range(n)]

    def bfs(a, b):
        q = deque()
        q.append((a, b))
        if a == 0 and b == 0:  # 최초 한번만 돌게 해준다.
            distance[0][0] = graph[0][0]

        while q:
            x, y = q.popleft()
            for i in range(4):
                nx = x + dx[i]
                ny = y + dy[i]
                if nx < 0 or nx >= n or ny < 0 or ny >= n:  # 범위 초과
                    continue
                cost = graph[nx][ny] + distance[x][y]
                if distance[nx][ny] > cost:  # 최소 거리 갱신해야 한다면
                    distance[nx][ny] = cost
                    q.append((nx, ny))


    for i in range(n):
        for j in range(n):
            if distance[i][j] == INF:
                bfs(i, j)

    print(f"Problem {tc}: {distance[n-1][n-1]}")
    tc += 1
