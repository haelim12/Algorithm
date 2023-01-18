T = int(input())

for i in range(T):
    num, word = input().split()
    new_word = ''

    for j in word:
        new_word += j* int(num)

    print(new_word)