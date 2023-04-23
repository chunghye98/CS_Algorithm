# 16234번, 인구 이동
import sys
from collections import deque

input_line = sys.stdin.readline


def gate_open(county, x, y):
    row = [0, 0, -1, 1]  # 상 하 좌 우
    column = [1, -1, 0, 0]
    flag = False  # default 는 연합 불가능한 나라라고 가정.
    for i in range(4):
        check_x = x + row[i]
        check_y = y + column[i]
        if 0 <= check_x < N and 0 <= check_y < N:  # 비교 할 나라가 index가 범위 내에 있고
            population = county[x][y] - county[check_x][check_y]  # 인구 차이가
            if L <= population <= R or -R <= population <= -L:  # (20 < 인구 차이 < 50) 혹은 (-50 < 인구 차이 < -20) 이라면
                graph[x][y].append([check_x, check_y])  # 쌍방향 연결을 하고
                graph[check_x][check_y].append([x, y])
                flag = True  # 국경이 열릴 수 있는, 연합 가능한 나라다. (인구 이동 가능)
    return flag


def bfs(start):
    queue = deque(graph[start])
    tmp = 0
    connect_country = 0
    while queue:
        x, y = queue.popleft()
        for another_node in graph[node]:  # graph[1] 부터 연결된 좌표 탐색
            x, y = another_node
            if not visited[x][y]:  # 방문 했는지 판별 (같은 국가의 인구 수를 또 넣을 수도 있으니까)
                visited[x][y] = True  # 방문 표시
                tmp += country[x][y]  # 인구 수 더하기
                connect_country += 1  # 연합 한 국가의 수 세기


N, L, R = map(int, input_line().rstrip().split())
country = [list(map(int, input_line().rstrip().split())) for _ in range(N)]
graph = [[] * N for _ in range(N)]
day = 0

while True:  # 연합 할 나라가 없으면 종료
    close_cnt = 0
    for i in range(N):
        for j in range(N):
            if not gate_open(country, i, j):  # 국경 선을 열 수 있는 나라면 (인구 이동 가능) 쌍방향 연결까지.
                close_cnt += 1  # 국경 선을 못연다면 카운트

    if close_cnt == N * N:  # 연합 할 나라가 없으면 종료
        break

    visited = [[False] * N for _ in range(N)]
    for i in range(N):
        bfs(i)
    day += 1  # 인구 이동 며칠 했는지 count

print(day)
