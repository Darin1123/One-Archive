from time import time
s = time()
def divisors(n):
    i=2;total={1}
    while i<=n**0.5:
        if n%i==0:
            total.add(i)
            total.add(n/i)
        i+=1
    return sum(total)

abun=set()
numbers=set(range(28123))
for i in range(1,28123):
    if i<divisors(i):
        abun.add(i)
        for j in abun:
            if (i+j) in numbers:
                numbers.remove(i+j)
e = time()
print("Answer: "+str(sum(numbers)))
print("Time used: "+str(e-s))
