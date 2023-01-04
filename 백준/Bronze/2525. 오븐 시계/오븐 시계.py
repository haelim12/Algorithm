h, m = map(int,input().split())
t = int(input())

if m + t < 60 :
    print(h, m + t)
elif m + t >= 60:
    h1 = h + ((t + m) // 60)
    if h1 > 23:
        print(h1 - 24, (t + m) - (60 * ((t + m) // 60)))
    else :
        print(h1, (t + m) - (60 * ((t + m) // 60)))