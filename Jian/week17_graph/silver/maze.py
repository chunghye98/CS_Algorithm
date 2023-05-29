# 2178번, 미로 찾기
import sys
from collections import deque
readl = sys.stdin.readline

def bfs(a, b):
    queue = deque()
    queue.append([a, b])
    while queue:
        x, y = queue.popleft()
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if nx < 0 or nx >= n or ny < 0 or ny >= m:  # 범위 초과
                continue
            if graph[nx][ny] == 0:
                continue
            if graph[nx][ny] == 1:  # 이동할 수 있고, 방문한 적 없는 경로라면
                graph[nx][ny] = graph[x][y] + 1
                queue.append([nx, ny])
    return graph[n-1][m-1]


# 문제 풀이 로직 시작
n, m = map(int, readl().rstrip().split())
graph = [list(map(int, readl().rstrip())) for _ in range(n)]

dx = [-1, 1, 0, 0]  # 상 하 좌 우
dy = [0, 0, -1, 1]

print(bfs(0, 0))
