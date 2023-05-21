# 1541 잃어버린 괄호
# 그리디(탐욕): 문제를 푸는 "적절한 방법"을 찾는 것이 포인트.
# 방법: "-" 단위로 끊어준다.

input_numbers = list(input().split("-"));  # "-"를 기준으로 자른다.
numbers = []

for n in input_numbers:  # "+" 먼저 계산
    # "+" 기준으로 끊어서 배열로 만든다 -> 문자를 숫자로 변경 -> 숫자끼리 더하기 -> 더한 값으로 요소를 대체하기
    # "+" 기호가 들어있지 않으면 int로 바뀐다.
    numbers.append(sum(list(map(int, n.split("+")))))

result = numbers[0]
for i in range(1, len(numbers)):  # "-" 계산
    result -= int(numbers[i]);

print(result)
