import sys


# 1244, 스위치 켜고 끄기
# 맨 마지막에 20개 단위로 끊어서 출력하는걸 못봐서 계속 틀렸음.

def switch_switch(switches, i):
    if switches[i] == 0:
        switches[i] = 1
    elif switches[i] == 1:
        switches[i] = 0


def male_switch_control(switches, receive_n, switch_n):  # 남자 일 경우
    # 배수를 찾고 그 위치의 스위치 바꾸기
    for i in range(switch_n):
        if (i + 1) % receive_n == 0:
            switch_switch(switches, i)


def female_switch_control(switches, receive_i, switch_n):  # 여자 일 경우
    # 대칭되는 수를 파악하고, 스위치 바꾸기.
    i = 1
    switch_switch(switches, receive_i)
    while 0 <= receive_i - i and receive_i + i < switch_n:
        if switches[receive_i - i] == switches[receive_i + i]:
            switch_switch(switches, receive_i - i)
            switch_switch(switches, receive_i + i)
        else:
            break
        i += 1


switch_n = int(sys.stdin.readline())
switches = list(map(int, sys.stdin.readline().rstrip().split()))
student_n = int(sys.stdin.readline())

for _ in range(student_n):
    student_gender, receive_n = list(map(int, sys.stdin.readline().rstrip().split()))
    if student_gender == 1:  # 남자
        male_switch_control(switches, receive_n, switch_n)
    elif student_gender == 2:  # 여자
        female_switch_control(switches, receive_n - 1, switch_n)

# 출력 형식 : 20개씩 출력
for i in range(switch_n):
    print(switches[i], end=" ")
    if (i + 1) % 20 == 0:
        print()
