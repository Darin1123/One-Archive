from questionADT import*

class Lecture:
    def __init__(self, s):
        questions=[]
        file=open(s,"r")
        Lines=file.readlines()
        for i in Lines:
            if i=="\n":
                Lines.remove(i)
        print(Lines)
        for i in Lines:
            i.strip()
            qaa=i.split(";")
            q=qaa[0]
            a=[]
            for i in range(1,len(qaa)):
                a+=[qaa[i]]
            q=Question(q, a)
            questions+=[q]
        file.close()
        self.__questions=questions
        self.__index=0

    def getQ(self):
        return "Q"+str(self.__index+1)+".\n"+self.__questions[self.__index].getQuestion()

    def getA(self):
        return self.__questions[self.__index].getAnswer()

    def index(self):
        return self.__index

    def Length(self):
        return len(self.__questions)

    def nextq(self):
        if (self.__index==self.Length()-1):
            return "This is the last one.\n"+self.getQ()
        else:
            self.__index+=1
            return self.getQ()  

    def previousq(self):
        if (self.__index==0):
            return "This is the first one.\n"+self.getQ()
        else:
            self.__index-=1
            return self.getQ()

    def goto(self, i):
        if (i<=0):
            return "Question starts from 1.\n"+self.getQ()
        elif (i>=self.Length()):
            return "Out of index.\n"+self.getQ()
        self.__index=i
        return self.getQ()

    def newl(self, s):
        questions=[]
        file=open(s,"r")
        Lines=file.readlines()
        for i in Lines:
            i.strip()
            qaa=i.split(";")
            q=qaa[0]
            a=[]
            for i in range(1,len(qaa)):
                a+=[qaa[i]]
            q=Question(q, a)
            questions+=[q]
        file.close()
        self.__questions=questions
        self.__index=0

