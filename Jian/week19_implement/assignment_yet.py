# 5597번, 과제 안 내신 분..?
students = [i for i in range(1, 31)]  # 1부터 31까지 배열에 넣는다.

for _ in range(28):  # 값 제거
    students.remove(int(input()))

print(min(students)) # 최소 번호 출력
print(max(students)) # 최대 번호 출력

