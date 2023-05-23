# 1931번, 회의실 배정
# 틀린 이유: 끝나는 시간만 정렬했었는데, 시작 시간으로도 정렬을 해야 한다.
# 반례) 2 "\n" 2 2 "\n" 1 2
import sys
readl = sys.stdin.readline

n = int(readl().rstrip())
a = [list(map(int, readl().rstrip().split())) for _ in range(n)]
a.sort(key = lambda x: (x[1], x[0]))  # 끝나는 시간 기준으로 정렬한 뒤, 시작 시간으로 정렬 한다.

result = 1
start_time = 0
end_time = a[0][1]

for i in range(1, n):
    start_time = a[i][0]
    if end_time <= start_time:  # 이전 회의가 끝난 시간 이후에 시작하는 회의라면
        result += 1  # 회의 추가가 가능하다
        end_time = a[i][1]  # 끝나는 시간을 갱신한다.

print(result)
