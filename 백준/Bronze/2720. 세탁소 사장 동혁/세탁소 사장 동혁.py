# 세탁소 사장 장동혁

T = int(input())


for _ in range(T):
    C = int(input())
    q = C // 25
    d = (C - 25*q) // 10
    n = (C - 25*q - 10*d) // 5
    p = (C - 25*q - 10*d - 5*n) // 1
    print(q, d, n, p)
