# 7569번, 토마토
# 틀린 이유: queue를 전역변수로 두고, 먼저 모든 1을 찾아서 queue에 넣었어야 했다.
import sys
from collections import deque
readl = sys.stdin.readline
dx = [-1, 1, 0, 0, 0, 0]  # 높이
dy = [0, 0, -1, 1, 0, 0]  # 가로
dz = [0, 0, 0, 0, -1, 1]  # 세로


M, N, H = list(map(int, readl().rstrip().split()))
tomatos = [[list(map(int, readl().rstrip().split())) for _ in range(N)] for _ in range(H)]
queue = deque()

for i in range(H):
    for j in range(N):
        for k in range(M):
            if (tomatos[i][j][k] == 1):
                queue.append((i, j, k))
def bfs():
    while queue:
        x, y, z = queue.popleft()
        for i in range(6):
            nx = x + dx[i]
            ny = y + dy[i]
            nz = z + dz[i]
            if nx < 0 or nx >= H or ny < 0 or ny >= N or nz < 0 or nz >= M:  # 범위 초과
                continue
            if tomatos[nx][ny][nz] == 0:  # 익지 않은 토마토가 있다면
                tomatos[nx][ny][nz] = tomatos[x][y][z]+1  # 날짜 +1 해서 넣기
                queue.append((nx, ny, nz))

bfs()
day = 0
for i in range(H):
    for j in range(N):
        for k in range(M):
            if tomatos[i][j][k] == 0: # 익지 않은 토마토가 있다면
                print(-1)
                exit()  # 프로그램 강제 종료
        day = max(day, max(tomatos[i][j]))  # 모두 익는데 걸린 날짜 구하기

print(day-1)
