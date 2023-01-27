# 고무오리 디버깅

start = input()
duck = 0

while True:
    a = input()
    if a == '문제':
        duck += 1
    elif a == '고무오리' and duck == 0:
        duck += 2
    elif a == '고무오리' and duck != 0:
        duck -= 1
    elif a == '고무오리 디버깅 끝':
        if duck == 0:
            print('고무오리야 사랑해')
            break
        else:
            print('힝구')
            break