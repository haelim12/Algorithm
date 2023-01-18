no = 'CAMBRIDGE'
word = list(input())

for i in no:
    for j in range(len(word)):
        if i == word[j]:
            word[j] = ''
            
for i in word:
    print(i, end='')