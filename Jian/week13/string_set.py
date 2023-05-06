# 14425번, 문자열 집합
import sys
from collections import defaultdict

input_line = sys.stdin.readline

n, m = map(int, input_line().rstrip().split())
S = defaultdict()
result = 0

for _ in range(n):  # 집합 S 만들기
    S[input_line().rstrip()] = 1

for string in range(m):  # 문자열을 비교하며 count 하기
    if input_line().rstrip() in S:  # 집합 S에 해당 문자열이 있으면
        result += 1

print(result)
