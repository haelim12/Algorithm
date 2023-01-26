T = int(input())

for i in range(T):
    vps_or_not = input()

    if len(vps_or_not) % 2 == 1:
        print('NO')

    else:
        while True:
            if('()' in vps_or_not):
                vps_or_not = vps_or_not.replace('()', '')

            else:
                if (vps_or_not == ''):
                    print('YES')
                    break

                else:
                    print('NO')
                    break