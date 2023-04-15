# 1253번, 좋다
import sys
input_l = sys.stdin.readline

n = int(input_l().rstrip())
arr = list(map(int, input_l().rstrip().split()))
arr.sort()
result = 0

for i in range(n):
    target = arr[i]
    tmp = arr[:i] + arr[i+1:]  # arr[i]를 제외한 나머지 요소들이 들어있는 배열. 동일한 숫자가 나올 수 있으므로 정렬되어 있더라도 타켓 index 이후의 요소도 배열에 추가한다.
    left, right = 0, len(tmp)-1
    while left < right:
        if target == (tmp[left] + tmp[right]):  # 타켓이 두 수의 합과 동일하다면
            result += 1
            break

        if target > (tmp[left] + tmp[right]):  # 두 수의 합이 타켓보다 작다면
            left += 1
        else:  # 두 수의 합이 타켓보다 크다면
            right -= 1

print(result)
