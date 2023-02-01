# 가장 큰 금민수

N = int(input())

number_list = []
for i in range(4, N+1):
    if len(str(i)) == str(i).count('4') + str(i).count('7'):
        number_list.append(i)

print(max(number_list))