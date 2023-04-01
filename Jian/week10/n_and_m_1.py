# 15649번 n과 m (1)
# 조금 찾아 봤는데도 잘 모르겠어서 dp 배울 때 처럼 그냥 블로그 보고 이해했음.
# 재귀를 쓸 수 있고, dfs()의 동작 원리와 비슷하지만 맞지 않으면 그 부분 이상은 탐색하지 않는다.
# m이 n보다 클 일은 없으니 그 경우는 제외.


def dfs():
    if len(result) == m:
        print(' '.join(map(str, result)))
        return
    for i in range(1, n + 1):
        if i not in result:
            result.append(i)
            dfs()
            result.pop()


n, m = list(map(int, input().split()))
result = []

dfs()
