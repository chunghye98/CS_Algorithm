# 3003번, 킹, 퀸, 룩, 비숍, 나이트, 폰

pieces = [1, 1, 2, 2, 2, 8]
input_pieces = list(map(int, input().split()))

for i in range(len(pieces)):
    print(pieces[i] - input_pieces[i], end=" ")
