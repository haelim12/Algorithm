# 점수계산

N = int(input())
Test = list(map(int, input().split()))

sum = 0
score = 0

for i in range(N):
    if Test[i] == 1:
        sum += 1
        score += sum
    elif Test[i] == 0:
        sum = 0
print(score)