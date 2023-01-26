# 피시방 알바

N = int(input())
enter = list(map(int, input().split()))

pc = []
cnt = 0
for i in range(N):
    if enter[i] in pc:
        cnt += 1
    else:
        pc.append(enter[i])
    
print(cnt)