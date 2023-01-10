students = [i for i in range(1, 31)]

for t in range(1, 29):
    t = int(input())
    students.remove(t)

print(*students)