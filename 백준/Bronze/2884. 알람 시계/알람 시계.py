h, m = map(int,input().split())

if m >= 45:
    print(h, m - 45)
elif h == 0 and m < 45:
    print('23', 60 - (45 - m))
else:
    print(h - 1, 60 - (45 - m))