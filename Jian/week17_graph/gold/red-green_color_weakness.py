# 10026번, 적록색약
import sys
from collections import deque
readl = sys.stdin.readline

dx = [-1, 1, 0, 0]  # 상,하,좌,우
dy = [0, 0, -1, 1]
n = int(readl().rstrip())
graph = [list(readl().rstrip()) for _ in range(n)]  # 색약X
R, G, B = [0, 0, 0]
result = [0, 0]  # 색약X, 색약O

def bfs(a, b, color):
    queue = deque()
    queue.append((a, b))
    while queue:
        x, y = queue.popleft()
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if nx < 0 or nx >= n or ny < 0 or ny >= n:  # 범위 초과
                continue
            if graph[nx][ny] == color:  # 같은 색이면
                graph[nx][ny] = "W"  # White(흰색)로 방문 표시
                queue.append((nx, ny))

# 로직
for i in range(n):
    for j in range(n):
        color = graph[i][j]
        if color == "R":
            R += 1
            bfs(i, j, color)
        if color == "G":
            G += 1
            bfs(i, j, color)
        if color == "B":
            B += 1
            bfs(i, j, color)

result[0] = R + G + B  # 색약X
result[1] = max(R, G) + B  # 색약O

print(f"R:{R}")
print(f"G:{G}")
print(f"B:{B}")
for r in result:
    print(r, end=" ")
