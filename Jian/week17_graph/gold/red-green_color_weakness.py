# 10026번, 적록색약
# 틀린 이유: R, G만 있으면 하나로 인식해야 함.
# 반례: 2 "\n" RG "\n" RG
import sys
import copy
from collections import deque
readl = sys.stdin.readline

def bfs(a, b, color, graph):
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

def color_change(graph):  # 색약X 그래프 -> 색약O 그래프
    graph2 = copy.deepcopy(graph)
    for i in range(n):
        for j in range(n):
            if graph2[i][j] == "G":
                graph2[i][j] = "R"
    return graph2

dx = [-1, 1, 0, 0]  # 상,하,좌,우
dy = [0, 0, -1, 1]
n = int(readl().rstrip())
graph = [list(readl().rstrip()) for _ in range(n)]  # 색약X
graph2 = color_change(graph)  # 색약O
result = [0, 0]  # 색약X, 색약O

# 로직
for i in range(n):
    for j in range(n):
        color = graph[i][j]  # 색약X
        color2 = graph2[i][j]  # 색약O
        if color != "W":  # 색약X
            result[0] += 1
            bfs(i, j, color, graph)
        if color2 != "W":  # 색약O
            result[1] += 1
            bfs(i, j, color2, graph2)

# 출력
for r in result:
    print(r, end=" ")
