# 2579번 계단 오르기
# 1. 점화식 수정
# 2. 작은 수를 넣었을 때 dp와 stairs 생성이 불가, 런타임 에러가 나서 수정

n = int(input())
dp = [0] * n
# stairs = []
# for i in range(0, n):
#     stairs.append(int(input()))
stairs = [int(input()) for _ in range(n)]

if n <= 2:
    print(sum(stairs))
else:
    dp[0] = stairs[0]
    dp[1] = stairs[1] + stairs[0]
    for i in range(2, n):
        # dp[i] = stairs[i] + max(dp[i - 1], dp[i - 2])
        dp[i] = stairs[i] + max((dp[i-3] + stairs[i-1]), dp[i-2])
    print(dp[-1])
