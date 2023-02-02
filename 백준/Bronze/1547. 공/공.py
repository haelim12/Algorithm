# 공

M = int(input())

cup = ['a', 'b', 'c']

for _ in range(M):
    x, y = map(int, input().split())
    cup[x-1], cup[y-1] = cup[y-1], cup[x-1]

print(cup.index('a')+1)