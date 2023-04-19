# 2531번, 회전 초밥
import sys
input_line = sys.stdin.readline


N, d, k, c = map(int, input_line().rstrip().split())
sushi = [int(input_line().rstrip()) for _ in range(N)]
result = 0

for i in range(N):  # 연속해서 먹는 가짓 수(k) 판별하기
    eat = []
    for j in range(i, i+k):  # k 개가 들어가게 만든다.
        eat.append(sushi[j % N])  # 배열을 넘어가도 다시 index 0부터 넣어준다.

    if len(eat) == len(set(eat)):
        if c in eat:  # 쿠폰 번호가 현재 배열에 있으면
            result = k
        else:  # 쿠폰 번호가 현재 배열에 없으면
            result = k+1
            break  # 최대값을 찾았으니 바로 종료

print(result)
