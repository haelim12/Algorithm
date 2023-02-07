# 덩치

import sys

N = int(sys.stdin.readline())

size = []
for _ in range(N):
    x, y = map(int, input().split())
    size.append((x, y))

for i in size:
    rank = 1
    for j in size:
        if (i[0] != j[0]) and (i[1] != j[1]):
            if (i[0] < j[0]) and (i[1] < j[1]):
                rank += 1
    print(rank, end=" ")