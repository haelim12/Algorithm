numbers = []
for i in range(9):
    i = int(input())
    numbers.append(i)

print(max(numbers), numbers.index(max(numbers)) + 1)