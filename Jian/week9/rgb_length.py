import sys
# 1149, RGB 거리

n = int(sys.stdin.readline().rstrip())
dp = [[0]*3 for _ in range(n+1)]

for i in range(1, n+1):
    R_0, G_1, B_2 = list(map(int, sys.stdin.readline().rstrip().split()))
    dp[i][0] = R_0 + min(dp[i-1][1], dp[i-1][2])
    dp[i][1] = G_1 + min(dp[i-1][0], dp[i-1][2])
    dp[i][2] = B_2 + min(dp[i-1][0], dp[i-1][1])

print(min(dp[n]))

