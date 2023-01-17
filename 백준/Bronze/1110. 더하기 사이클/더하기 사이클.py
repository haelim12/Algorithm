N = int(input())
number = N
count = 0

while True:
    n1 = number // 10
    n2 = number % 10
    n3 = (n1 + n2) % 10
    number = (n2 * 10) + n3 # 왜 new_number 로 잡으면 안 되는지

    count += 1

    if number == N: 
        break

print(count)