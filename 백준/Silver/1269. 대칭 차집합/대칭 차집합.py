a, b = list(map(int, input().split()))
A = set(map(int, input().split()))
B = set(map(int, input().split()))

AandB = A^B
print(len(AandB))