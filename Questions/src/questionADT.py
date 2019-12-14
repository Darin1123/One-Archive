
class Question():
    def __init__(self, question, answers):
        if type(question)==type("str"):
            self.__question=question
        if type(answers)==type(["1"]):
            self.__answers=answers

    def getAnswer(self):
        ans=""
        for i in self.__answers:
            ans += (i+"\n")
        return ans
    
    def getQuestion(self):
        return self.__question        
