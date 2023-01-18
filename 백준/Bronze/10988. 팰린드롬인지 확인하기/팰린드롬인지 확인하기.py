word = list(input())

cnt = 0
if len(word) % 2 == 1:
    for j in range((len(word)-1)//2):
        if word[j] == word[len(word)-j-1]:
            cnt += 1
        else:
            cnt += 0

    if cnt == (len(word)-1) // 2:
        print('1')
    else:
        print('0')

else:
    for j in range((len(word))//2):
        if word[j] == word[len(word)-j-1]:
            cnt += 1
        else:
            cnt += 0

    if cnt == (len(word)) // 2:
        print('1')
    else:
        print('0')