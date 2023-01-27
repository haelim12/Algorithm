# 절대값 힙

import heapq
import sys

N = int(input())
heap = []

for _ in range(N):
    n = int(sys.stdin.readline().rstrip())

    if n != 0:
        heapq.heappush(heap, (abs(n), n))
    else:
        if heap:
            print(heapq.heappop(heap)[1])
        else:
            print(0)