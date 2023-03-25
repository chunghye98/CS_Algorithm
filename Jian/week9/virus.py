import sys
from collections import deque


# 2606, 바이러스
# 틀린 이유: 양방향 연결이 안되어있었음.

def bfs(graph, start, visit):
    queue = deque([start])
    while (queue):
        v = queue.popleft()
        for i in graph[v]:
            if not visit[i]:
                queue.append(i)
                visit[i] = True


computer_n = int(sys.stdin.readline().rstrip())
link_line = int(sys.stdin.readline().rstrip())
graph = [[] for _ in range(computer_n + 1)]
for _ in range(link_line):
    node, linked_node = list(map(int, sys.stdin.readline().rstrip().split()))
    graph[node] += [linked_node]
    graph[linked_node] += [node]

visit = [False] * (computer_n + 1)
bfs(graph, 1, visit)

print(visit.count(True) - 1)  # 1 자기 자신은 count에서 빼야 한다.
