# 삼각형 외우기

a = int(input())
b = int(input())
c = int(input())

if a == b == c == 60:
    print('Equilateral')
elif a + b + c != 180:
    print('Error')
elif a == b and a !=c:
    print('Isosceles')
elif a == c and a != b:
    print('Isosceles')
elif b == c and b != a:
    print('Isosceles')
elif a != b and a != c and b != c:
    print('Scalene')