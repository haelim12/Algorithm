# 콘테스트

W_list = []
K_list = []

W_score = 0
K_score = 0

for _ in range(10):
    W_list.append(int(input()))
    W_list = sorted(W_list)

for _ in range(10):
    K_list.append(int(input()))
    K_list = sorted(K_list)

for i in range(9,6,-1):
    W_score += W_list[i]
    K_score += K_list[i]

print(W_score)
print(K_score)