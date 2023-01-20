T = int(input())

for i in range(T):
    word = list(input())
    mirror = []

    for j in range(len(word)):
        if word[j] == 'b':
            mirror.append('d')
        elif word[j] == 'd':
            mirror.append('b')
        elif word[j] == 'p':
            mirror.append('q')
        elif word[j] == 'q':
            mirror.append('p')
    
    mirror.reverse()
    print(f'#{i+1} ', *mirror, sep='')
    mirror = []