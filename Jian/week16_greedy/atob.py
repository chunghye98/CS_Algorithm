# 16953번, A -> B
# 방법: 문제와는 반대로, B 에서 A 로 만들 수 있는지 확인한다.

A, B = map(int, input().split())
count = 1  # 하단의 while 문이 A == B 일 때는 count 해주지 않으므로

while A < B:
    if B % 10 == 1:  # 끝자리가 1이면
        B //= 10  # 나머지를 버린 몫
    else:  # 2로 나눌 수 있다는 뜻이므로
        B /= 2
    count += 1

# A == B가 아니면 A로 B를 만들 수 없다는 뜻이므로 -1을 출력한다.
print(count if A == B else -1)
