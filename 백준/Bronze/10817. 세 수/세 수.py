# 세 수

numbers = list(map(int, input().split()))

numbers.remove(max(numbers))
numbers.remove(min(numbers))

print(*numbers)