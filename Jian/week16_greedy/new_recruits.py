# 1946번, 신입사원
# 문제를 봤을 때, 한번에 잘 이해하는 것이 필요하다. (테케: 순위!중요)
# 블로그 참고했기 때문에 문제 제출하지는 않았음.
import sys
inp = sys.stdin.readline
tc = int(inp().rstrip())

for _ in range(tc):
    n = int(inp().rstrip())
    ranking = [list(map(int, inp().rstrip().split())) for _ in range(n)]
    ranking.sort()
    result = 1
    top = 0  # index

    for i in range(1, n):
        if ranking[i][1] < ranking[top][1]:
            top = i
            result += 1

    print(result)



