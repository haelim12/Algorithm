# 오르막길

N = int(input())

way = list(map(int, input().split()))
up = []
up_list = [0]

for i in range(N-1):
    if way[i] < way[i+1]:
        up.append(way[i])
        up.append(way[i+1])
        up = list(set(up))
        # print(up)
    elif way[i] >= way[i+1]:
        if up == []:
            pass
        else:
            up_list.append(max(up)-min(up))
            up = []
            # print(up_list)

if up != []:
    up_list.append(max(up)-min(up))
    up = []

print(max(up_list))
    