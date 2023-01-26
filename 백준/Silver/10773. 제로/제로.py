K = int(input())

number_list = []
result = []
for j in range(K):
    number = int(input())
    number_list.append(number)

for i in range(len(number_list)):
    if number_list[i] != 0:
        result.append(number_list[i])
    elif number_list[i] == 0:
        result.pop()

print(sum(result))