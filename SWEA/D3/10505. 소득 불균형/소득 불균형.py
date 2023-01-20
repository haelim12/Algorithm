T = int(input())

for i in range(T):
    people = int(input())
    wage = list(map(int, input().split()))
    avg = sum(wage) / people
    cnt = 0

    for j in range(people):
        if wage[j] <= avg:
            cnt += 1
        else:
            pass

    print(f'#{i+1} {cnt}')
    cnt = 0
