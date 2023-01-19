# 숫자의 개수
from collections import Counter

A = int(input())
B = int(input()) 
C = int(input())

number = list(str(A * B * C))
count_num = 0

for i in range(0,10):
    count_num = number.count(str(i))
    print(count_num)