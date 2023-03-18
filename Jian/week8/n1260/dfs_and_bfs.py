# 1260 DFS와 BFS
from collections import deque
import sys


def dfs(v):
    visit_dfs[v] = True
    print(v, end=" ")
    for i in range(n + 1):  # 순서대로 돌기
        # 방문 안했는데 방문해야하는 곳이라면
        if visit_dfs[i] == False and graph[v][i] == True:
            dfs(i)


def bfs(v):
    queue = deque()
    queue.append(v)
    visit_bfs[v] = True
    while queue:
        v = queue.popleft()
        print(v, end=" ")
        for i in range(n + 1): # 정점의 갯수만큼(그래프 생성한 만큼)만 돌면 됨
            if visit_bfs[i] == False and graph[v][i] == True:
                queue.append(i)
                visit_bfs[i] = True


n, m, v = map(int, sys.stdin.readline().split())

graph = [[False] * (n + 1) for _ in range(n + 1)]
# 중복 방문을 제거하기 위해 생성
visit_dfs = [False] * (n + 1)
visit_bfs = [False] * (n + 1)

for _ in range(m): # graph에 입력받은 값을 다 넣어주는 작업 == 간선을 다 이어주는 작업
    a, b = map(int, sys.stdin.readline().split())
    graph[a][b] = graph[b][a] = True

dfs(v)
print()
bfs(v)
