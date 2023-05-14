# Hello Coding 그림으로 개념을 이해하는 알고리즘 - 다익스트라 알고리즘

def find_lowest_cost_node(costs):
    lowest_cost = float("inf")
    lowest_cost_node = None
    for node in costs:  # 모든 정점 확인
        cost = costs[node]
        # 아직 처리하지 않은 정점 중 더 싼 것이 있으면
        if cost < lowest_cost and node not in processed:
            lowest_cost = cost  # 새로운 최저 정점으로 설정
            lowest_cost_node = node
    return lowest_cost_node

graph = {}  # 그래프
graph["start"] = {}  # 출발 정점
graph["start"]["a"] = 6
graph["start"]["b"] = 2
graph["a"] = {}  # a 정점
graph["a"]["fin"] = 1
graph["b"] = {}  # b 정점
graph["b"]["a"] = 3
graph["b"]["fin"] = 5
graph["fin"] = {}  # 도착 정점

infinity = float("inf")  # 아직 가격을 모르는 정점(도착점)의 가격을 무한대로 놓기 위함.
costs = {}  # 가격
costs["a"] = 6
costs["b"] = 2
costs["fin"] = infinity

parents = {}  # 부모노드
parents["a"] = "start"
parents["b"] = "start"
parents["fin"] = None

processed = []  # 방문 표시

node = find_lowest_cost_node(costs)  # 아직 처리하지 않은 가장 싼 정점을 찾는다.
while node is not None:  # 모든 정점을 처리하면 반복문이 종료된다.
    cost = costs[node]
    neighbors = graph[node]
    for n in neighbors.keys():  # 모든 이웃에 대해 반복한다.
        new_cost = cost + neighbors[n]
        if costs[n] > new_cost:  # 만약 이 정점을 지나는 것이 가격이 더 싸다면
            costs[n] = new_cost  # 정점의 가격을 갱신하고
            parents[n] = node  # 부모를 이 정점으로 새로 설정합니다.
    processed.append(node)  # 정점을 처리한 사실을 기록합니다.
    node = find_lowest_cost_node(costs)  # 다음으로 처리할 정점을 찾아 반복합니다.

print(costs["fin"])

