# 11399번, ATM

n = int(input())
a = list(map(int, input().split()))
a.sort()
time = [0] * n

time[0] = a[0]
for i in range(1, n):
    time[i] = a[i] + time[i-1]

print(sum(time))
