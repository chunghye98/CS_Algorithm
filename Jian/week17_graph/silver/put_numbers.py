# 2667번, 단지번호붙이기 (DFS, 재귀(스택))
import sys
readl = sys.stdin.readline

n = int(readl().rstrip())
graph = [list(map(int, list(readl().rstrip()))) for _ in range(n)]
result = []

def dfs(x, y):
    count = 0
    if x < 0 or x >= n or y < 0 or y >= n:  # 범위 초과
        return 0
    if graph[x][y] == 1:  # 방문 한 적이 없으면
        graph[x][y] = 0  # 방문 표시
        count += 1
        count += dfs(x-1, y)  # 상 하 좌 우 순으로 탐색
        count += dfs(x+1, y)
        count += dfs(x, y-1)
        count += dfs(x, y+1)
        return count
    return count


for i in range(n):
    for j in range(n):
        count = dfs(i, j)
        if count >= 1:  # 단지 수가 1 이상이어야 단지 정의 가능.
            result.append(count)


print(len(result))
result.sort()
for r in result:
    print(r)
