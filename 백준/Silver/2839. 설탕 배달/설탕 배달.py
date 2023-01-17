N = int(input())

if N % 5 ==0: # N이 5로 나누어 떨어질 때
    print(N // 5)

else: # N이 5로 나누어 떨어지지 않을 때
    sugar = 0
    
    while N > 0:
        N -= 3 # 3KG 짜리 설탕
        sugar += 1

        if N % 5 ==0:
            sugar = sugar + (N//5)
            print(sugar)
            break

        elif N == 1 or N == 2: # 3 또는 5로 안 나누어질 경우
            print('-1')
            break

        elif N == 0: # 3으로만 나누어 떨어질 경우
            print(sugar)
            break