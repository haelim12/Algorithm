# 직사각형 네 개의 합집합의 면적 구하기
matrix = [[0] * 100 for _ in range(100)]

cnt = 0
for _ in range(4):
    x1, y1, x2, y2 = list(map(int, input().split()))
    for i in range(x1, x2):
        for j in range(y1, y2):
            if matrix[i][j] == 0:
                matrix[i][j] = 1
                cnt += 1
                
            else:
                pass

print(cnt)