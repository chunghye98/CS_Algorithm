# 1966번, 프린터 큐

import sys
input_line = sys.stdin.readline

def priority(m, queue):
    result = 0
    pointer = m

    while queue:
        if queue[0] == max(queue):
            queue.pop(0)
            result += 1
            if pointer == 0:
                return result
        else:
            queue.append(queue.pop(0))

        pointer -= 1
        if pointer == -1:
            pointer += len(queue)


testcase = int(input_line().rstrip())

while testcase > 0:
    n, m = map(int, input_line().rstrip().split())
    queue = list(map(int, input_line().rstrip().split()))

    print(priority(m, queue))
    testcase -= 1

