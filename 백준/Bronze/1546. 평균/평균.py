N = int(input())
scores = list(map(int, input().split()))

new_score = []
for score in scores:
    new_score.append(score/max(scores)*100)

print(sum(new_score)/N)