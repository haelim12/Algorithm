for j in range(1, 11):
    N = int(input())
    case = list(input())
    check = []
    result = 1

    for i in range(N):
        if case[i] == ')':
            if '(' in check:
                check.pop(check.index('('))
            else:
                result = 0
                break
        
        elif case[i] == ']':
            if '[' in check:
                check.pop(check.index('['))
            else : 
                result = 0
                break        
        
        elif case[i] == '}':
            if "{" in check:
                check.pop(check.index('{'))
            else : 
                result = 0
                break

        elif case[i] == '>':
            if '<' in check:
                check.pop(check.index('<'))
            else : 
                result = 0
                break

        else:
            check.append(case[i])

    print(f'#{j} {result}')