from collections import deque


class Node:
    def __init__(self, n):
        self.value = n
        self.connection = []


def bfs(node_list):
    visited = [False] * 101
    visited[1] = True

    passed_list = deque()
    passed_list.append(node_list[1])

    while passed_list:
        for node in passed_list.popleft().connection:
            if not visited[node.value]:
                passed_list.append(node)
                visited[node.value] = True

    return visited.count(True) - 1


computer_count = int(input())
pair_count = int(input())

node_list = [Node(0)] + [Node(i) for i in range(1, computer_count + 1)]

for i in range(pair_count):
    a, b = map(int, input().split())
    node_list[a].connection.append(node_list[b])
    node_list[b].connection.append(node_list[a])

print(bfs(node_list))
