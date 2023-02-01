# 점수 집계

T = int(input())

score = []
for _ in range(T):
    case = list(map(int, input().split()))
    case = sorted(case)
    for i in range(1,4):
        score.append(case[i])
    
    if max(score) - min(score) >= 4:
        print('KIN')
        score = []
    
    else:
        print(sum(score))
        score = []