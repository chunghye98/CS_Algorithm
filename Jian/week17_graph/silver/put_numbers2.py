# 2667번, 단지번호붙이기 (BFS, 큐)
import sys
from collections import deque
readl = sys.stdin.readline

n = int(readl().rstrip())
graph = [list(map(int, list(readl().rstrip()))) for _ in range(n)]
result = []
dx = [-1, 1, 0, 0]  # 상 하 좌 우
dy = [0, 0, -1, 1]

def bfs(a, b):
    queue = deque()
    queue.append((a, b))
    graph[a][b] = 0
    count = 1
    while queue:
        x, y = queue.popleft()
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if nx < 0 or nx >= n or ny < 0 or ny >= n:
                continue
            if graph[nx][ny] == 1: # 첫 방문이라면
                graph[nx][ny] = 0
                count += 1
                queue.append((nx, ny))
    return count


for i in range(n):
    for j in range(n):
        if graph[i][j] == 1:  # 방문한 적 없다면
            result.append(bfs(i, j))

print(len(result))
result.sort()
for r in result:
    print(r)
