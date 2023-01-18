# 나무 조각

wood = list(map(int,input().split()))

while wood != [1, 2, 3, 4, 5]:
    for i in range(4):
        if wood[i] > wood[i+1]:
            wood[i], wood[i+1] = wood[i+1], wood[i]
            print(*wood)