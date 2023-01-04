a, b, c = map(int, input().split())

if a == b:
    if b == c:
        print(10000 + (a * 1000))
    if b != c:
        print(1000 + (a * 100))
elif a == c:
    if b == c:
        print(10000 + (a * 1000))
    if b != c:
        print(1000 + (a * 100))
elif b == c:
    if a == c:
        print(10000 + (b * 1000))
    if a != c:
        print(1000 + (b * 100))
else:
    print(max(a, b, c) * 100)