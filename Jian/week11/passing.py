# 2002번, 추월
# 내가 만든 예시)
#     입구로 들어간 차의 순서가 1, 2, 3, 4, 5 일 때,
#     출구로 나온 차의 순서가 1, 4, 3, 2, 5 일 경우
# 1️⃣ 3번 차는 추월하지 않았다고 볼 경우(4번만 확실하게 추월하고 3번은 애매)
#     = ❌ 자기가 가진 수가 index 보다 크면 추월 (코드 설계)
# 2️⃣ 3번 차도 추월 했다고 볼 경우(4번이 2, 3번 차를 추월 -> 3번이 2번 차를 추월)
#     = ✅ 본인 앞에 본인보다 높은 수가 등장하지 않으면 추월 (코드 설계)


import sys
input_line = sys.stdin.readline

n = int(input_line().rstrip())
entrance = list(input_line().rstrip() for _ in range(n))
exit = list(input_line().rstrip() for _ in range(n))
exit_i = list([0] * n)
result = 0

for i in range(n):  # entrance
    for j in range(n):  # exit
        if entrance[i] == exit[j]:
            exit_i[j] = i
            break

for i in range(n):
    before_car = list([False] * exit_i[i])
    for j in range(i):
        if exit_i[j] < exit_i[i]:  # 내 앞의 차가 나보다 높은 등수(낮은 숫자) 일 때만 체크
            before_car[exit_i[j]] = True
    if (exit_i[i] != 0) and (False in before_car):  # 0일 경우, before_car가 생성이 안되는 오류가 날 수 있어서 0 제외
        result += 1

print(result)
