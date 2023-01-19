# 홀수

numbers = []
odd = []

for i in range(7):
    numbers.append(int(input()))
    if numbers[i] % 2 == 1:
        odd.append(numbers[i])

if odd == []:
    print('-1')
else:
    print(sum(odd))
    print(min(odd))