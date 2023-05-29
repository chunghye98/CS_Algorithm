# 1339번, 단어 수학
# 틀린 이유: 제일 앞에 오는 단어부터 큰 숫자를 부여했기 때문.
# 수정: 각 알파벳의 등장 횟수에 따른 합산 금액(?)에 따라 큰 숫자 부여

import sys
inp = sys.stdin.readline

n = int(inp().rstrip())
inputs = [list(inp().rstrip()) for _ in range(n)]
dic = {}
result = 0
max_num = 9

for words in inputs:
    for i in range(len(words)):
        al = words[i]
        if al in dic:
            dic[al] += 10 ** (len(words)-i-1)
        else:
            dic[al] = 10 ** (len(words)-i-1)

numbers = sorted(dic.values(), reverse=True)  # 내림차순 정렬

for n in numbers:
    result += n * max_num
    max_num -= 1

print(result)
