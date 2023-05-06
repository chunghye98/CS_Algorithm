# 2470번, 두 용액

N = int(input())
liquid = list(map(int, input().split()))
mix_min = 2000000001  # 두 용액을 섞었을 때 최대 값
result = [0, 0]  # left 값, right 값
left, right = 0, N-1

liquid.sort()  # 정렬
while left < right:
    tmp = liquid[left] + liquid[right]
    # 섞었을 때, 최소 값 계산
    if abs(mix_min) > abs(tmp):  # tmp의 절대 값이 더 작을 때, 0에 더 가까우므로
        mix_min = tmp
        result[0] = liquid[left]
        result[1] = liquid[right]
    # 포인터 이동
    if tmp < 0:  # 더한 값이 음수면
        left += 1  # left 오른쪽으로 이동
    elif tmp > 0:  # 더한 값이 양수면
        right -= 1  # right 왼쪽으로 이동
    else:  # 0이면 정답.
        break

print(" ".join(map(str, result)))

