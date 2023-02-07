# 막대기

import sys

N = int(sys.stdin.readline())

stick = []

can_see = 1

for _ in range(N):
    stick.append(int(sys.stdin.readline()))

# print(stick)
max = stick[N-1]

for i in range(N-1,-1,-1):
    # print(stick[i])
    if stick[i] > max:
        can_see += 1
        max = stick[i]

print(can_see)