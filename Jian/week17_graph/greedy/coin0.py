# 11047번, 동전 0
# 동전 a[i]이 a[i-1]의 배수 일 때만 가능한 풀이.
# 틀린 이유: index를 0으로 초기화 했기 때문에 코인보다 큰 숫자가 나타나지 않을 경우 무조건 제일 작은 수(a[0] = 1)로 나뉜다.
# 해결: index는 a의 맨 마지막 요소로 초기화.
n, k = map(int, input().split())

a = [int(input()) for _ in range(n)]
index = n-1
result = 0

for i in range(n):  # 최대로 나눠질 수 있는 금액 찾기
    if k < a[i]:
        index = i


while k > 0:  # 혹은 index >= 0. a의 요소를 내림차순으로 나눈 몫을 result에 더하기.
    result += k // a[index]
    k %= a[index]
    index -= 1

print(result)
