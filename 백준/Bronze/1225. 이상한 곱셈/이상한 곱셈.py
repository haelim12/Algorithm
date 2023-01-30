numbers = list(input().split())

n = len(numbers[0])
m = len(numbers[1])


N = 0
M = 0
for i in range(n):
    N += int(numbers[0][i])
for j in range(m):
    M += int(numbers[1][j])

print(N * M)
