# 1475번, 방 번호
# 틀린 이유: 3333666699 3과 6의 개수가 같은 상황이고 이전에 짰던 6과 9의 계산식을 수행하면 정답인 4(3의 개수) 대신 (4+2)/2 = 2가 출력 됨.
import math

numbers = [0 for _ in range(10)]
input_numbers = list(map(int, list(input())))

for n in input_numbers: # index는 숫자, index에 해당하는 값으로 등장 횟수를 넣는다.
    numbers[n] += 1

max1 = max(numbers)
if max1 == numbers[6] or max1 == numbers[9]:  # 6과 9는 서로 대체할 수 있다.
    temp = math.ceil((numbers[6] + numbers[9])/2)
    numbers[6] = temp
    numbers[9] = temp

print(max(numbers))
