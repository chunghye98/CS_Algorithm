# 4358번 생태학
import sys
from collections import defaultdict
inp = sys.stdin.readline
trees = defaultdict(int)  # value에 int를 넣을 것이다
treeN = 0

while True:
    tree = inp().rstrip()
    if not tree:
        break
    trees[tree] += 1  # 종류 추가
    treeN += 1

trees = dict(sorted(trees.items()))
for t in trees:
    print(t, round((trees[t] / treeN) * 100, 4))

