X = int(input())

cnt = 0
sum = 0

while X > sum:
    cnt += 1
    sum += cnt

if cnt % 2 == 0:
    print(f'{cnt-(sum-X)}/{sum-X+1}')
else:
    print(f'{sum-X+1}/{cnt-(sum-X)}')
