# 1339번, 단어 수학
# 틀린 이유: 제일 앞에 오는 단어부터 큰 숫자를 부여했기 때문.

import sys
inp = sys.stdin.readline

n = int(inp().rstrip())
inputs = [list(reversed(list(inp().rstrip()))) for _ in range(n)]  # 뒤집어서 넣어준다.
alpha = {}
max_len = 0
number = 9
result = 0

for words in inputs:  # 최대 단어 길이 구하기
    if len(words) > max_len:
        max_len = len(words)

while max_len >= 0:
    for words in inputs:
        if max_len <= len(words):  # 최대 길이보다 같거나 큰 요소한테만 적용
            al = words[max_len-1]
            if str(type(al)) == "<class 'str'>":  # al이 str일 때만 - 이미 숫자로 변경 되었다면 숫자가 dict에 저장되고 배열의 요소가 초기화 되어버린다.
                if al not in alpha: # 알파벳이 없으면 key(알파벳), value(숫자)를 생성하고 배열에도 넣어준다.
                    alpha[al] = number
                    number -= 1
                # 알파벳이 있으면 배열에 해당 알파벳 key에 맞는 value를 넣어준다.
                words[max_len-1] = alpha[al]
    max_len -= 1

for words in inputs:  # 숫자 배열 -> 문자열 -> 문자열 다시 뒤집기 -> 문자열 합치기 -> 숫자로 바꾸기
    result += int(''.join(list(reversed(list(map(str, words))))))

print(result)
