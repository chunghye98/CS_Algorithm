# 2531번, 회전 초밥
# 왜 브루트 포스 알고리즘이지? 했는데, 모든 조합의 수를 찾아야되서 그런 것 같았다.

from collections import defaultdict
N, d, k, c = map(int, input().split())
arr = [int(input()) for _ in range(N)]

canEat = defaultdict(int)
cnt = 1
canEat[c] = 1
for i in range(k):  # 처음 k개의 초밥에 중복되는 초밥이 있는지 확인한다.
    if canEat[arr[i]] == 0:
        cnt += 1
    canEat[arr[i]] += 1
answer = cnt  # 현재까지 중복 제외한 cnt를 answer에 넣어준다.
for left in range(N):
    right = (left+k)%N
    canEat[arr[left]] -= 1
    if canEat[arr[left]] == 0:  # 지나간 초밥이 현재 k개의 초밥과 중복 되었다면 cnt를 빼준다.
        cnt -= 1
    if canEat[arr[right]] == 0:  # 새로 온 초밥이 현재 k개의 초밥과 중복되지 않으면 cnt를 올려준다.
        cnt += 1
    canEat[arr[right]] += 1  # 새로 온 초밥을 dictionary에 등록
    answer = max(answer, cnt)
print(answer)
