# 1063번 킹
import sys


def position_calculate(position, moves):
    column_index = column.index(position[0]) + move_calculate_column(moves)
    row_index = row.index(position[1]) + move_calculate_row(moves)
    if (0 <= row_index < 8) and (0 <= column_index < 8):  # 체스판 벗어나지 않는다면
        return column[column_index] + row[row_index]
    return position  # 체스판 벗어난다면 원래 위치 그대로 출력


def move_calculate_column(moves):
    if moves == 'R' or moves == 'RT' or moves == 'RB':
        return 1
    elif moves == 'L' or moves == 'LT' or moves == 'LB':
        return -1
    return 0


def move_calculate_row(moves):
    if moves == 'B' or moves == 'RB' or moves == 'LB':
        return -1
    elif moves == 'T' or moves == 'RT' or moves == 'LT':
        return 1
    return 0


row = ['1', '2', '3', '4', '5', '6', '7', '8']
column = ['A', 'B', 'C', 'D', 'E', 'F', 'G', 'H']

king_position, stone_position, n = input().split()

for i in range(0, int(n)):
    move = input()
    if position_calculate(king_position, move) == stone_position:  # 이동한 king의 위치와 stone의 위치가 동일하다면
        if stone_position != position_calculate(stone_position, move):  # move만큼 이동한 돌의 위치가 체스판을 벗어나지 않는다면
            king_position = position_calculate(king_position, move)  # 킹의 위치 move 만큼 이동
            stone_position = position_calculate(stone_position, move)  # 돌의 위치도 move 만큼 이동
    else:
        king_position = position_calculate(king_position, move)  # 킹의 위치 move 만큼 이동

print(king_position)
print(stone_position)
