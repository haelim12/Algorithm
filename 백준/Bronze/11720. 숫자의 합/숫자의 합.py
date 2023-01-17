N = int(input())
numbers = list(map(int, input()))

result = 0
for i in range(N):
    result += numbers[i]

print(result)