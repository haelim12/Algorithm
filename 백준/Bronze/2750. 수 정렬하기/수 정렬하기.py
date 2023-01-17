# 수 정렬하기
N =int(input())

numbers = []
for number in range(N):
    numbers.append(int(input()))
numbers.sort()
print(*numbers)