# 7576 토마토
import sys
from collections import deque

input = sys.stdin.readline


def in_range(x, y, N, M):
    if 0 <= x < N and 0 <= y < M:
        return True
    return False


def is_green_tomato(x, y):
    if tomato_box[x][y] == 0:
        return True
    return False


def dfs(tomato_box, queue, N, M):
    range_row, range_column = [-1, 1, 0, 0], [0, 0, -1, 1]  # 상하좌우 탐색용
    while queue:
        x, y = queue.popleft()
        for i in range(4):  # tomato_box 범위 내에 있고, 안 익은 토마토라면
            if in_range(x + range_row[i], y + range_column[i], N, M) \
                    and is_green_tomato(x + range_row[i], y + range_column[i]):
                tomato_box[x + range_row[i]][y + range_column[i]] = tomato_box[x][y]+1  # 날짜를 세주기
                queue.append([x + range_row[i], y + range_column[i]])  # 좌표 위치를 queue에 넣어주기


M, N = list(map(int, input().rstrip().split()))
tomato_box = [list(map(int, input().rstrip().split())) for _ in range(N)]
queue = deque([])

for i in range(N):
    for j in range(M):
        if tomato_box[i][j] == 1:
            queue.append([i, j])

dfs(tomato_box, queue, N, M)

day = 0
for i in range(N):
    if 0 in tomato_box[i]:  # 0 있으면 -1 출력
        print(-1)
        exit(0)  # 프로그램 종료
    else:
        day = max(day, max(tomato_box[i]))
print(day-1)  # 첫 날 빼주기
