def primeList(n):
    list = [True] * n
    max = int(n ** 0.5)
    list[1] = False

    for i in range(2, max):
        if list[i] == True:
            for j in range(i + i, n, i):
                list[j] = False

    return list


m, n = list(map(int, input().split()))

list = primeList(n)

for i in range(m, n):
    if list[i] == True:
        print(i)
