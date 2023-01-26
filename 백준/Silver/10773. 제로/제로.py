K = int(input())

result = []
for j in range(K):
    number = int(input())

    if number != 0:
        result.append(number)
    elif number == 0:
        result.pop()

print(sum(result))
