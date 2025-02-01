from Student import Student

class School(Student):
    def __init__(self,name,grade, age, schoolName):
        super().__init__(name,grade, age)
        self.schoolName=schoolName

    def schoolStudentDisplay(self):
        print("SchoolName:" + self.schoolName + " Name:" + self.name + " Grade:" + str(self.grade) + " Age: " + str(self.age))

school = School("Cruise",10,25,"KV School")
school.schoolStudentDisplay()
