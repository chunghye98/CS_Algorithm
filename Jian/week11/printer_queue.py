# 1966번, 프린터 큐

import sys
input_line = sys.stdin.readline
# priority queue를 쓰는게 더 좋았을지도..?

def priority(m, queue):
    result = 0  # 몇번째로 프린트 되는지 확인하기 위한 결과
    pointer = m  # 같은 숫자가 대기열에 있을 경우, 타겟의 index를 파악하기 위함

    while queue:
        if queue[0] == max(queue):  # 맨 앞에 있는 요소가 프린트 대기열 중 우선순위가 가장 높으면
            queue.pop(0)  # 프린트 해준다
            result += 1  # 프린트를 카운트 해준다
            if pointer == 0:  # 프린트 한 애가 타겟 요소였다면
                return result  # 몇번째로 출력 되었는지를 반환해준다.
        else:  # 맨 앞의 요소가 우선순위가 가장 높지 않다면
            queue.append(queue.pop(0))  # 대기열의 맨 마지막에 넣어준다.

        pointer -= 1  # 타켓의 현재 index를 당겨준다.
        if pointer == -1:  # 대기열의 가장 뒤로 갔다면
            pointer += len(queue)  # 현재 대기열에 존재하는 요소만큼 더해준다


testcase = int(input_line().rstrip())

while testcase > 0:
    n, m = map(int, input_line().rstrip().split())
    queue = list(map(int, input_line().rstrip().split()))

    print(priority(m, queue))
    testcase -= 1

