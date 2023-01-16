# 0 = not cute / 1 = cute

N = int(input())

cute = 0
not_cute = 0

for i in range(N):
    i = int(input())
    if i == 1:
        cute += 1
    else:
        not_cute += 1

if cute > not_cute:
    print('Junhee is cute!')
else:
    print('Junhee is not cute!')