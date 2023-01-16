A, B, V = map(int,input().split())

# night = 0
# up = 0

# while up < V:
#     up += A-B
#     night += 1

# print(night-1)

if (V-B)/(A-B) == int((V-B)/(A-B)):
    print(int((V-B)/(A-B)))
else:
    print(int((V-B)/(A-B))+1)