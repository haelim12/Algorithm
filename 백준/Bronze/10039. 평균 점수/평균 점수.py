a = int(input())
b = int(input())
c = int(input())
d = int(input())
e = int(input())

N = [a, b, c, d, e]

for i in range(5):
    if N[i] < 40:
        N[i] = 40
    else:
        N[i] = N[i] 

result = 0

for j in range(5):
    result += N[j]
print(result//5)