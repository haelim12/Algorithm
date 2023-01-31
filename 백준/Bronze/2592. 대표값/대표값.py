# 대표값

n_list = []
for _ in range(10):
    n_list.append(int(input()))

print(sum(n_list)//10)

n_set = list(set(n_list))
# print(y)
n_count = []

for i in range(len(n_set)):
    n_count.append(n_list.count(n_set[i]))
    # print(number_count)

# print(n_count.index(max(n_count)))
print(n_set[n_count.index(max(n_count))])