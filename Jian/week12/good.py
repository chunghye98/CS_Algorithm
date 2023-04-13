# 1253번, 좋다
import sys
input_l = sys.stdin.readline

n = int(input_l().rstrip())
arr = list(map(int, input_l().rstrip().split()))
count = [0] * (n+1)
arr.sort()

for i in range(n-1, 0, -1):  # for (int i = n-1; i > 0; i--)과 동일. 비교할 두 수가 필요하므로 index 기준 1까지만 돈다.
    target = arr[i]
    if (n > i+1) and (target == arr[i+1]):  # 중복 계산 방지. ex) 0, 1, 2, 2 일 때, 앞 순서의 2일 경우 뒷 순서의 2로 GOOD 계산이 이미 되어있다.
        count[i] = count[i+1]
    else:  # 이미 계산한 숫자가 중복 숫자가 아닐 때, GOOD 계산을 시작한다.
        for j in range(i-1, 0, -1):  # 뒤부터 비교한다.
            max_n = arr[j]  # ex) 1, 2, 3, 4 일 때, target = 4, max_n = 3, min_n = 1
            for z in range(j):
                min_n = arr[z]
                if (min_n + max_n) == target:  # ex) 1 + 3 == 4 이면
                    count[i] = 1  # 두 수의 합으로 나타낼 수 있어서 GOOD이므로, 해당 index에 1을 count 해준다.
                    break  # 더 이상 GOOD 인지 확인 할 필요 없으므로 3중 for문 탈출
            if count[i] == 1:  # target이 GOOD인지 확인 했으면
                break  # 2중 for문 탈출

print(sum(count))  # 두 수로 나타낼 수 있는 모든 GOOD을 카운트 한다.

