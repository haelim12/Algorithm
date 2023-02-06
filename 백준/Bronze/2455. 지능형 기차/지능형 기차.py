# 지능형 기차

train = 0
train_list = []

out_1, in_1 = map(int, input().split())
train = in_1
train_list.append(train)

out_2, in_2 = map(int, input().split())
train = train - out_2 + in_2
train_list.append(train)

out_3, in_3 = map(int, input().split())
train = train - out_3 + in_3
train_list.append(train)

out_4, in_4 = map(int, input().split())
train = train - out_4
train_list.append(train)

print(max(train_list))
