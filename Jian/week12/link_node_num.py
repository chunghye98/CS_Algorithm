# 11724번, 연결 요소의 개수

import sys
from collections import deque
input_line = sys.stdin.readline


def bfs(ver):  # vertex 정점
    queue = deque([ver])
    visited[ver] = True
    while queue:
        node = queue.popleft()
        for linked_node in graph[node]:
            if not visited[linked_node]:
                visited[linked_node] = True
                queue.append(linked_node)


n, m = map(int, input_line().rstrip().split())
graph = [[] for _ in range(n+1)]
visited = [False] * (n+1)
count = 1

for _ in range(m):  # graph 양방향 연결
    u, v = map(int, input_line().rstrip().split())
    graph[u].append(v)
    graph[v].append(u)

bfs(1)

for i in range(1, n+1):
    if not visited[i]:
        bfs(i)
        count += 1

print(count)
