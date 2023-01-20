T = int(input())

for i in range(T):
    a, b, c = map(int,input().split())

    if a == b:
        d = c
    elif a == c:
        d = b
    elif b == c:
        d = a

    print(f'#{i+1} {d}')