# 4358번, 생태학
# 틀린 이유 2가지
# 1. 입력 값 제한이 없어서 여러가지로 테스트 해 보았다.
# 2. round(total,4) 에 대한 문제.
# 반올림을 진행하는데 1.2345이면 1.235가 아니라 1.234로 나오는 문제.
# 버그가 아니라 10진 소수는 float로 정확히 표현될 수 없다는 사실로부터 오는 결과이다.

import sys
from collections import defaultdict

inp = sys.stdin.readline
trees = defaultdict(int)  # value에 int를 넣을 것이다
treeN = 0

while True:
    tree = inp().rstrip()
    if not tree:  # 문자가 아닌걸 받았을 때 (공백이나 개행)
        break
    trees[tree] += 1  # 종류 추가
    treeN += 1

tree_list = list(trees.keys())
tree_list.sort()
for tree in tree_list:
    per = (trees[tree] / treeN) * 100
    print("%s %.4f" % (tree, per))
