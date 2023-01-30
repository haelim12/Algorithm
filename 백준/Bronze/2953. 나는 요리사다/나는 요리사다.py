# 나는 요리사다

N = 5 # 행
M = 4 # 열

matrix = [[0]*M] * N
for i in range(N):
    matrix[i] = list(map(int, input().split()))

# print(matrix)

score = []
for i in range(5):
    score.append(sum(matrix[i]))

print(score.index(max(score))+1, max(score))