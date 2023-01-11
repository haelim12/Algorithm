N = int(input())
sum = 0

for i in range(4):
    i = N % 10
    N = int(N/10)
    sum += i
print(sum)