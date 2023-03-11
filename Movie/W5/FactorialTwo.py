import sys

N = int(sys.stdin.read())



# result = 1
# for i in range(1, N + 1):
#     result *= i
#


count = 0
five = 2
while five <= N:
    count += int(N/five)
    five *= 2


print(int(count))
