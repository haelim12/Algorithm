# 행복한지 슬픈지

message = input()

happy = message.count(':-)')
sad = message.count(':-(')

if happy == 0 and sad == 0:
    print('none')
elif happy > sad:
    print('happy')
elif sad > happy:
    print('sad')
else:
    print('unsure')