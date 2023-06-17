# 16918번, 봄버맨
# 힌트 보고 쉽게 짤 수 있다는 것을 깨달음
# 틀린 이유: 경우의 수가 3인줄 알았는데 4였다.
# 1. 현재 graph, 2. 다 폭탄으로 채워진 형태, 3. 현재 graph에서 터진 형태, 4. 현재 graph에서 터진 형태에서 터진 형태

from collections import deque
R, C, N = map(int, input().split())
graph = [list(input()) for _ in range(R)]
q = deque()
dx = [-1, 1, 0, 0]  # 상 하 좌 우
dy = [0, 0, -1, 1]

if N<=1:  # 초기 형태와 동일
    for i in graph:
        print(*i, sep="")
elif N % 2 == 0:  # O로 가득 채워진 graph
    for i in range(R):
        for j in range(C):
            print("O", end="")
        print()
else:  # 초기 graph에서 폭탄이 터진 형태
    bomb1 = [['O']*C for i in range(R)]
    for i in range(R): # 초기 graph에서 폭탄이 터진 형태
        for j in range(C):
            if graph[i][j] == "O":
                bomb1[i][j] = "."
                # 상하좌우
                for z in range(4):
                    nx = i + dx[z]
                    ny = j + dy[z]
                    if 0 <= nx < R and 0 <= ny < C:  # 범위 내에 있으면
                        q.append([nx, ny])
            elif graph[i][j] == ".":
                bomb1[i][j] = "O"
    while q:
        x, y = q.popleft()
        bomb1[x][y] = "."
    bomb2 = [['O']*C for i in range(R)] # 초기 graph에서 폭탄이 터진 형태에서 폭탄이 터진 형태
    for i in range(R): # 초기 graph에서 폭탄이 터진 형태
            for j in range(C):
                if bomb1[i][j] == "O":
                    bomb2[i][j] = "."
                    # 상하좌우
                    for z in range(4):
                        nx = i + dx[z]
                        ny = j + dy[z]
                        if 0 <= nx < R and 0 <= ny < C:  # 범위 내에 있으면
                            q.append([nx, ny])
                elif bomb1[i][j] == ".":
                    bomb2[i][j] = "O"
    while q:
        x, y = q.popleft()
        bomb2[x][y] = "."
    if N % 4 == 3:
        for i in bomb1:
            print(*i, sep="")
    if N % 4 == 1:
        for i in bomb2:
            print(*i, sep="")

