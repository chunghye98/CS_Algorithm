# 1713번, 후보 추천하기
import sys
from collections import defaultdict

inp = sys.stdin.readline
N = int(inp().rstrip())  # 틀 개수
total_num = int(inp().rstrip())  # 총 추천 횟수
candidates = list(map(int, inp().rstrip().split()))  # 후보들

frame = []
diction = defaultdict(int)
vote_min_key = 0
vote_min_value = 1001


def min_key():  # 최소 득표 수를 가진 후보를 구한다.
    m_v = diction[frame[0]]
    m_k = frame[0]
    for c in frame:
        if diction[c] < m_v:
            m_v = diction[c]  # 최소 득표 수 저장
            m_k = c  # 최소 득표를 가진 후보 저장
    return m_k


for candidate in candidates:
    if len(frame) == N and candidate not in frame:  # 틀이 다 차 있고, 후보가 틀에 있지 않다면
        frame.remove(vote_min_key)  # 최소 득표 수를 가진 후보 내리기
        diction.pop(vote_min_key)
    if candidate not in frame:  # 틀이 다 차지 않았으면
        frame.append(candidate)
    diction[candidate] += 1  # 후보의 득표 수를 올린다.
    vote_min_key = min_key()  # 최소 득표를 가진 후보 구하기

frame.sort()  # 증가하는 순서대로 출력하기
for c in frame:
    print(c, end=" ")
