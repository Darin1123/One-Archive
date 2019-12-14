from tkinter import*
from lectureADT import*

lec=Lecture("../data/l21.txt")

root=Tk()
root.title("Lecture Questions")
root.maxsize(660, 710)
root.minsize(660, 230)
root.geometry('660x450')

q=StringVar()
q.set(lec.getQ())

a=StringVar()
a.set("\n"+lec.getA())

def l21():
    lec.newl("../data/l21.txt")
    q.set(lec.getQ())
    lecn.set("Lecture 21 - Intro to Specification -")
    a.set("\n"+lec.getA())
    nq.set(str(lec.Length())+" questions")


def l22():
    lec.newl("../data/l22.txt")
    q.set(lec.getQ())
    lecn.set("Lecture 22 - Intro to Specification -")
    a.set("\n"+lec.getA())
    nq.set(str(lec.Length())+" questions")

    
def l23():
    lec.newl("../data/l23.txt")
    q.set(lec.getQ())
    lecn.set("Lecture 23 - Finite State Machines -")
    a.set("\n"+lec.getA())
    nq.set(str(lec.Length())+" questions")

def l24():
    lec.newl("../data/l24.txt")
    q.set(lec.getQ())
    lecn.set("Lecture 24 - Specification Quality -")
    a.set("\n"+lec.getA())
    nq.set(str(lec.Length())+" questions")

def l25():
    lec.newl("../data/l25.txt")
    q.set(lec.getQ())
    lecn.set("Lecture 25 - English To Math -")
    a.set("\n"+lec.getA())
    nq.set(str(lec.Length())+" questions")

def l26():
    lec.newl("../data/l26.txt")
    q.set(lec.getQ())
    lecn.set("Lecture 26 - SpecViaUML -")
    a.set("\n"+lec.getA())
    nq.set(str(lec.Length())+" questions")

def l27():
    lec.newl("../data/l27.txt")
    q.set(lec.getQ())
    lecn.set("Lecture 27 - Design Patterns -")
    a.set("\n"+lec.getA())
    nq.set(str(lec.Length())+" questions")

def l28():
    lec.newl("../data/l28.txt")
    q.set(lec.getQ())
    lecn.set("Lecture 28 - Parnas Tables -")
    a.set("\n"+lec.getA())
    nq.set(str(lec.Length())+" questions")

def l29():
    lec.newl("../data/l29.txt")
    q.set(lec.getQ())
    lecn.set("Lecture 29 - Intro to Verification -")
    a.set("\n"+lec.getA())
    nq.set(str(lec.Length())+" questions")

def l30():
    lec.newl("../data/l30.txt")
    q.set(lec.getQ())
    lecn.set("Lecture 30 - Intro to Verification -")
    a.set("\n"+lec.getA())
    nq.set(str(lec.Length())+" questions")

def l31():
    lec.newl("../data/l31.txt")
    q.set(lec.getQ())
    lecn.set("Lecture 31 - Overview of Testing -")
    a.set("\n"+lec.getA())
    nq.set(str(lec.Length())+" questions")

def l32():
    lec.newl("../data/l32.txt")
    q.set(lec.getQ())
    lecn.set("Lecture 32 - White Box Testing -")
    a.set("\n"+lec.getA())
    nq.set(str(lec.Length())+" questions")

def l33():
    lec.newl("../data/l33.txt")
    q.set(lec.getQ())
    lecn.set("Lecture 33 - White Box Testing -")
    a.set("\n"+lec.getA())
    nq.set(str(lec.Length())+" questions")

def l34():
    lec.newl("../data/l34.txt")
    q.set(lec.getQ())
    lecn.set("Lecture 34 - Black Box Testing -")
    a.set("\n"+lec.getA())
    nq.set(str(lec.Length())+" questions")

def l35():
    lec.newl("../data/l35.txt")
    q.set(lec.getQ())
    lecn.set("Lecture 35 - Analysis -")
    a.set("\n"+lec.getA())
    nq.set(str(lec.Length())+" questions")
    
def l36():
    lec.newl("../data/l36.txt")
    q.set(lec.getQ())
    lecn.set("Lecture 32 - Review for final -")
    a.set("\n"+lec.getA())
    nq.set(str(lec.Length())+" questions")

def Next():
    q.set(lec.nextq())
    a.set("\n"+lec.getA())

def Previous():
    q.set(lec.previousq())
    a.set("\n"+lec.getA())

def Show():
    a.set("\n"+lec.getA())

def Hide():
    a.set("")

def Final():
    q.set(lec.goto(lec.Length()-1))
    a.set("\n"+lec.getA())

def Goto():
    s=index.get()
    try:
        q.set(lec.goto(int(s)-1))
        a.set("\n"+lec.getA())
    except:
        a.set("\n"+lec.getA())
## Frames        
f=Frame(root,width=660, height=5, borderwidth=2)
f.grid(row=0, column=0, sticky='N'+'S')
f1=Frame(root,width=660, height=5, borderwidth=2)
f1.grid(row=1, column=0, sticky='N'+'S')
f2=Frame(root,width=660, height=5, borderwidth=2)
f2.grid(row=2, column=0, sticky='N'+'S')
f3=Frame(root,width=660, height=5, borderwidth=2)
f3.grid(row=3, column=0, sticky='N'+'S')
f4=Frame(root,width=660, height=30,bg='blue', borderwidth=2)
f4.grid(row=4, column=0, sticky='N'+'S')
f5=Frame(root,width=660, height=50, bg='gray',borderwidth=2)
f5.grid(row=5, column=0, sticky='N'+'S')
f6=Frame(root,width=660, height=5,borderwidth=2)
f6.grid(row=6, column=0, sticky='N'+'S')

## Frame 1 Lecture Buttons
L21=Button(f, text="21", command=l21)
L21.grid(row=0, column=0)
L22=Button(f, text="22", command=l22)
L22.grid(row=0, column=1)
L23=Button(f, text="23", command=l23)
L23.grid(row=0, column=2)
L24=Button(f, text="24", command=l24)
L24.grid(row=0, column=3)
L25=Button(f, text="25", command=l25)
L25.grid(row=0, column=4)
L26=Button(f, text="26", command=l26)
L26.grid(row=0, column=5)
L27=Button(f, text="27", command=l27)
L27.grid(row=0, column=6)
L28=Button(f, text="28", command=l28)
L28.grid(row=0, column=7)

## Frame 2 Lecture Buttons
L29=Button(f1, text="29", command=l29)
L29.grid(row=0, column=0)
L30=Button(f1, text="30", command=l30)
L30.grid(row=0, column=1)
L31=Button(f1, text="31", command=l31)
L31.grid(row=0, column=2)
L32=Button(f1, text="32", command=l32)
L32.grid(row=0, column=3)
L33=Button(f1, text="33", command=l33)
L33.grid(row=0, column=4)
L34=Button(f1, text="34", command=l34)
L34.grid(row=0, column=5)
L35=Button(f1, text="35", command=l35)
L35.grid(row=0, column=6)
L36=Button(f1, text="36", command=l36)
L36.grid(row=0, column=7)

## Frame 3 Goto Question #
index=StringVar()
Gol=Label(f2, text="Enter a Question Number:", bg='gray', justify=LEFT).grid(row=0, column=0)
entry = Entry(f2, textvariable=index,justify=LEFT).grid(row=0, column=1)
Go=Button(f2, text="Go", command=Goto, justify=LEFT).grid(row=0, column=2)

## Frame 4 Function Buttons
Show=Button(f3, text="Show", command=Show)
Show.grid(row=0, column=1)
Next=Button(f3, text="Next", width=5, command=Next)
Next.grid(row=0, column=3)
Previous=Button(f3, text="Previous", width=6, command=Previous)
Previous.grid(row=0, column=0)
Hide=Button(f3, text="Hide", command=Hide)
Hide.grid(row=0, column=2)
Final=Button(f3, text="Final", command=Final)
Final.grid(row=0, column=4)

## Frame 5 Lecture Title
nq=StringVar()
nq.set(str(lec.Length())+" questions")
nql=Label(f4, textvariable=nq, fg='white', bg='blue')
nql.grid(row=4, column=1)
lecn=StringVar()
lecn.set("Lecture 21 - Intro to Specification -")
ln=Label(f4, textvariable=lecn, fg='white', bg='blue')
ln.grid(row=4, column=0)

## Frame 6 Question Block
question=Label(root, textvariable=q, bg='gray', wraplength=650, justify=LEFT)
question.grid(row=5, column=0, sticky='N'+'S'+"W")

## Frame 7 Answer Block
answer=Label(root, textvariable=a, wraplength=650, justify=LEFT)
answer.grid(row=6, column=0,columnspan=3, sticky='W')








root.mainloop()

