from time import time
s = time()
sum_of_two_abundants = set()

def is_abundant(num):
    sum = 1 # every number is divided by 1
    for i in range(2, num // 2 + 1):
        if num % i == 0:
            sum += i

    return sum > num


def is_sum_of_two_abundant(num):
    if num > 28123:
        return True
    return num in sum_of_two_abundants


def load_abundants():
    abundants = []

    for i in range(1, 28123+1):
        if is_abundant(i):
            abundants.append(i)
    
    for x in abundants:
        for y in abundants:
            sum_of_two_abundants.add(x+y)


load_abundants()
sum = 0
for i in range(1, 28123+1):
    if not is_sum_of_two_abundant(i):
        sum += i
e = time()
print(sum)
print(e-s)
