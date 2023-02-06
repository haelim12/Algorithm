train = 0
train_list = []

for i in range(4):
    t_out, t_in = map(int, input().split())
    train -= t_out - t_in
    train_list.append(train)

print(max(train_list))