T = int(input())

for i in range(T):
    h, w, n = map(int,input().split())

    if n % h == 0:
        floor = h
        room = (n // h)
    else:
        floor = (n % h)
        room = (n // h) + 1

    print((floor*100) + room)