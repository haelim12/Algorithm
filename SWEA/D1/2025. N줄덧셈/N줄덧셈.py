# N줄 덧셈

N = int(input())
number_list = []

for i in range(1, N+1):
    number_list.append(i)
print(sum(number_list))