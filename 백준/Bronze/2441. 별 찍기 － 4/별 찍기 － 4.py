# 별 찍기 - 4

N = int(input())

for i in range(1, N+1):
    print(' '*int(i-1) + '*'*int(N+1-i))