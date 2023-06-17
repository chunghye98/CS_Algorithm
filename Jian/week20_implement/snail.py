# 1913번, 달팽이
import math

n = int(input())
target = int(input())
graph = [[0] * (n+1) for _ in range(n+1)]
centerNum = math.ceil(n/2)
graph[centerNum][centerNum] = 1
nowNum = n*n+1
nowX, nowY = 1, 1
commands = ["Down", "Right", "Up", "Left"] # 순서대로 돈다
commandNum = 0
# 최소 위치, 최대 위치 초기 셋
down, right, up, left = n, n, 1, 1

def putNum(x, y, co, nowX, nowY, nowNum):
    if co == "Down":
        for i in range(nowX, x+1):
            nowNum -= 1
            graph[i][y] = nowNum
    if co == "Right":
        for i in range(nowY, y+1):
            nowNum -= 1
            graph[x][i] = nowNum
    if co == "Up":
        for i in range(nowX, x-1, -1):
            nowNum -= 1
            graph[i][y] = nowNum
    if co == "Left":
        for i in range(nowY, y-1, -1):
            nowNum -= 1
            graph[x][i] = nowNum
    return x, y, nowNum

while True:
    if nowX == centerNum and nowY == centerNum:
        break
    nowCo = commands[commandNum]
    if nowCo == "Down":
        nowX, nowY, nowNum = putNum(down, left, nowCo, nowX, nowY, nowNum)
        left += 1
        nowY += 1
    if nowCo == "Right":
        nowX, nowY, nowNum = putNum(down, right, nowCo, nowX, nowY, nowNum)
        down -= 1
        nowX -= 1
    if nowCo == "Up":
        nowX, nowY, nowNum = putNum(up, right, nowCo, nowX, nowY, nowNum)
        right -= 1
        nowY -= 1
    if nowCo == "Left":
        nowX, nowY, nowNum = putNum(up, left, nowCo, nowX, nowY, nowNum)
        up += 1
        nowX += 1
    commandNum = (commandNum+1) % 4

targetX, targetY = 0, 0
for i in range(1, n+1):
    for j in range(1, n+1):
        print(graph[i][j], end=" ")
        if graph[i][j] == target:
            targetX, targetY = i, j
    print()
print(targetX, targetY, sep=" ")
