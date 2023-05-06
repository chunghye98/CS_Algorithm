# 16234번, 인구 이동
import sys
from collections import deque

input_line = sys.stdin.readline

N, L, R = map(int, input_line().rstrip().split())
graph = [list(map(int, input_line().rstrip().split())) for _ in range(N)]
day = 0

dx = [0, 0, 1, -1]
dy = [1, -1, 0, 0]


def bfs(a, b):
    q = deque()
    temp = []
    q.append((a, b))
    temp.append((a, b))
    while q:
        x, y = q.popleft()
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
        if (0 <= nx <= N and 0 <= ny <= N) and (L <= abs(graph[nx][ny]) <= R) and not visited[nx][ny]:
            visited[nx][ny] = True
            q.append([nx, ny])
            temp.append([nx, ny])
    return temp


while True:  # 연합 할 나라가 없으면 종료
    visited = [[False] * (N + 1) for _ in range(N + 1)]
    flag = False
    for i in range(N):
        for j in range(N):
            if not visited[i][j]:
                visited[i][j] = True
                country = bfs(i, j)  # 연합 할 나라의 좌표값이 담겨있다.
                if len(country) > 1:  # 연합 할 나라가 하나 이상이면
                    flag = True
                    number = sum([graph[x][y] for x, y in country]) // len(country)  # 인구 이동이 이루어 진다.
                    for x, y in country:
                        graph[x][y] = number  # 평균 인구를 연합 한 나라에 배분한다.

    if not flag:  # 연합 할 나라가 없으면 국경선을 닫는다.
        break
    day += 1  # 하루가 지난다.

print(day)
