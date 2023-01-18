# 단어 뒤집기

T = int(input())
new_line= []

for i in range(T):
    line = list(input().split())

    for j in range(len(line)):
        new_line.append(line[j][::-1])
    print(*new_line)
    new_line = []