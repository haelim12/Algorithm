N = int(input())

for i in range(1, N+1):
    if i < N:
        print(str(' ') * int(N- i -1) , '*' * i)
    else:
        print('*' * N)