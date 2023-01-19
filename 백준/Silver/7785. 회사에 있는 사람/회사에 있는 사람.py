# 회사에 있는 사람

import sys
n = int(input())

login ={}

# 네 번째 시도
for i in range(n):
    name, in_out = sys.stdin.readline().split()
    login[name] = in_out
    if in_out == 'leave':
        login.pop(name)

new_name = sorted(login, reverse = True)

for name in new_name:
    print(name)