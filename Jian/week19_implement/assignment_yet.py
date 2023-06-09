# 5597번, 과제 안 내신 분..?
import heapq
students = []
for _ in range(28):
    heapq.heappush(students, int(input()))

for i in range(1, 31):
    if i not in students:
        print(i)

