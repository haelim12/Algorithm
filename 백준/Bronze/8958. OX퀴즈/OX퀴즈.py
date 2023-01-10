T = int(input())

for ox_list in range(T):
    ox_list = list(input())
    score = 0
    sum_score = 0
    
    for ox in ox_list:
        if ox == 'O':
            score +=1  # 'O'가 연속되면 점수가 1점씩 커진다
            sum_score += score
        else:
            score = 0
    print(sum_score)