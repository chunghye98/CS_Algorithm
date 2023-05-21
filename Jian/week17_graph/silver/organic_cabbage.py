# 1012번, 유기농 배추
import sys
from collections import deque
readl = sys.stdin.readline

dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]
result = []
def bfs(a, b, graph):
    queue = deque()
    queue.append((a, b))
    graph[a][b] = 0  # 방문 표시
    while queue:
        x, y = queue.popleft()
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if nx < 0 or nx >= N or ny < 0 or ny >= M:  # 범위 초과
                continue
            if graph[nx][ny] == 1:  # 배추가 심어져 있으면서 방문한 적이 없으면
                graph[nx][ny] = 0  # 방문 표시
                queue.append((nx, ny))  # 유효한 범위 추가

t = int(readl().rstrip())
for _ in range(t):
    M, N, K = map(int, readl().rstrip().split())
    graph = [[0] * M for _ in range(N)]  # 방문 표시와 배추 표시를 한번에 한다.
    insects = 0

    for _ in range(K):  # 배추 심기
        y, x = map(int, readl().rstrip().split())
        graph[x][y] = 1

    for i in range(N):
        for j in range(M):
            if graph[i][j] == 1:  # 배추가 심어져 있으면
                bfs(i, j, graph)
                insects += 1

    result.append(insects)

for r in result:
    print(r)
