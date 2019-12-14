from time import time
s=time()

class n(object):
    def __init__(self, n):
        self.q = [0,0,0,0,0,0,0,0,0]
        self.n = n
    def add(self, i):
        self.q[i]+=1

    def run(self):
        ps=[1,2,3,5,7,11,13,17,19]
        while not self.n in ps:
            for i in range(len(ps)):
                if self.n%ps[i]==0:
                    self.add(i)
                    self.n//=ps[i]
        for i in range(len(ps)):
            if self.n%ps[i]==0:
                self.add(i)
t = n(2)
th = n(3)
fo = n(4)
fi = n(5)
si = n(6)
se = n(7)
ei = n(8)
ni = n(9)
te = n(10)
el = n(11)
tw = n(12)
tht = n(13)
fot = n(14)
fft = n(15)
sit = n(16)
svt = n(17)
et = n(18)
nt = n(19)
tt = n(20)
ns = [t,th,fo,fi,si,se,ei,ni,te,el,tw,tht,fot,fft,sit,svt,et,nt,tt]
for i in ns:
    i.run()
fi = [t.q,th.q,fo.q,fi.q,si.q,se.q,ei.q,ni.q,te.q,el.q,tw.q,tht.q,fot.q,fft.q,sit.q,svt.q,et.q,nt.q,tt.q]
res = []
for i in range(9):
    m=0
    for j in range(19):
        if fi[j][i]>m:
            m=fi[j][i]
    res += [m]
r=1
primes=[1,2,3,5,7,11,13,17,19]
for i in range(9):
    r *= primes[i]**res[i]
print(r)
e=time()
print(e-s)
 
    
