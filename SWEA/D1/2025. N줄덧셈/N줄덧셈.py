# N줄 덧셈

N = int(input())
number_list = []

for i in range(N+1):
    number_list.append(i)
print(sum(number_list))