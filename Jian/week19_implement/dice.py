# 14499번, 주사위 굴리기
import sys
input = sys.stdin.readline

# (지도의)세로, 가로, (주사위의)x, y, 명령어 개수
N, M, x, y, K = map(int, input().rstrip().split())
# 지도
maps = [list(map(int, input().rstrip().split())) for _ in range(N)]
# 명령어
commands = list(map(int, input().rstrip().split())) # 동1 서2 북3 남4
# 지도에서 이동할 좌표
moves = [(0, 0), (0, 1), (0, -1), (-1, 0), (1, 0)]  # none, 동, 서, 북, 남
# 주사위
dice = dict()
dice["top"], dice["bottom"], dice["front"], dice["back"], dice["left"], dice["right"] = 0, 0, 0, 0, 0, 0
# 현재 위치
now = dict()
now["x"], now["y"] = x, y

def change_dice(co):  # 주사위 내부 이동
    top, bottom, front, back, left, right = dice["top"], dice["bottom"], dice["front"], dice["back"], dice["left"], dice["right"]
    if co == 1:  # 동쪽 이동 = front, back 그대로 유지
        dice["top"], dice["bottom"], dice["left"], dice["right"] = left, right, bottom, top
    if co == 2:  # 서쪽 이동 = front, back 그대로 유지
        dice["top"], dice["bottom"], dice["left"], dice["right"] = right, left, top, bottom
    if co == 3:  # 북쪽 이동 = left, right 그대로 유지
        dice["top"], dice["bottom"], dice["front"], dice["back"] = front, back, bottom, top
    if co == 4:  # 남쪽 이동 = left, right 그대로 유지
        dice["top"], dice["bottom"], dice["front"], dice["back"] = back, front, top, bottom


# 1. 지도에서 현재 주사위 위치 이동
# 2. 주사위의 숫자 내부 이동
# 3. 지도의 칸과 주사위 바닥 값 변경
# 4. 주사위 윗 면 출력
for co in commands:
    nx, ny = now["x"]+moves[co][0], now["y"]+moves[co][1] # 현재 위치 계산
    if nx < 0 or N <= nx or ny < 0 or M <= ny:  # 범위 초과
        continue
    # 지도에서 현재 위치 이동 가능하면, 주사위 내부 숫자 바꾸기
    change_dice(co)
    now["x"], now["y"] = nx , ny # 현재 위치 재설정

    if maps[nx][ny] == 0:  # 지도의 바닥이 0이면
        maps[nx][ny] = dice["bottom"]  # 주사위의 바닥면을 현재 지도의 칸에 복사
    else:  # 지도의 바닥이 0이 아니라면
        dice["bottom"] = maps[nx][ny]  # 주사위의 바닥면에 현재 지도의 칸 값을 복사
        maps[nx][ny] = 0  # 현재 지도의 위치(칸)는 0이 된다
    print(dice["top"])  # 주사위의 윗 면 출력
