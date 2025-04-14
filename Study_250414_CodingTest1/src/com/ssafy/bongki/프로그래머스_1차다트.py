import re

def solution(dartResult):
    pattern = re.compile(r'(\d{1,2})([SDT])([*#]?)')
    darts = pattern.findall(dartResult)
    scores = []

    for i, (num, bonus, option) in enumerate(darts):
        num = int(num)
        if bonus == 'S':
            num **= 1
        elif bonus == 'D':
            num **= 2
        elif bonus == 'T':
            num **= 3

        if option == '*':
            num *= 2
            if i > 0:
                scores[i-1] *= 2
        elif option == '#':
            num *= -1

        scores.append(num)

    return sum(scores)
