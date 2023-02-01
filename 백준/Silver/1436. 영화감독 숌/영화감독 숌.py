# 영화 감독 숌

N = int(input())
a = '666'
number = 1
count = 0

while True:
    if a in str(number):
        count += 1
    
    if count == N:
        print(number)
        break
    
    number +=1