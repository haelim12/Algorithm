N = int(input())

card = [i for i in range(1, N+1)]
out = []

while len(card) > 1:
    out.append(card.pop(0))
    card.append(card.pop(0))

print(*out, card[0])