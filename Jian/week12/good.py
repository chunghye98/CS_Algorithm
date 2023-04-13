# 1253번, 좋다
import sys
input_l = sys.stdin.readline

n = int(input_l().rstrip())
arr = list(map(int, input_l().rstrip().split()))
sum = [0] * 1000000001  # 두 수의 모든 합을 기록
count = 0

for i in range(n-1):
    for j in range(i+1, n):
        sum[arr[i] + arr[j]] = 1  # 두 수의 모든 합을 기록

for num in arr:  # input 배열의 요소를 탐색한다.
    if sum[num] == 1:  # 두 수의 모든 합을 기록한 sum에 num의 기록이 있으면
        count += 1  # count 한다.

print(count)
