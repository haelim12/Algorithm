# 블랙잭

N, M = map(int,input().split())
card = list(map(int, input().split()))

card_sum = []
for i in range(N-2):
    for j in range(i+1, N-1):
        for k in range(j+1, N):
            if card[i] + card[j] + card[k] <= M:
                card_sum.append(card[i] + card[j] + card[k])

print(max(card_sum))