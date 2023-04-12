# 11724번, 연결 요소의 개수

import sys
input_line = sys.stdin.readline


def dfs(ver):  # vertex 정점
    visited[ver] = True
    for node in graph[ver]:
        if not visited[node]:
            dfs(node)


n, m = map(int, input_line().rstrip().split())
graph = [[] for _ in range(n+1)]
visited = [False] * (n+1)
count = 1

for _ in range(m):  # graph 양방향 연결
    u, v = map(int, input_line().rstrip().split())
    graph[u].append(v)
    graph[v].append(u)

dfs(1)

for i in range(1, n+1):
    if not visited[i]:
        dfs(i)
        count += 1

print(count)
