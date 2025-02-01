class Student:
    def __init__(self, name,grade, age):
        self.name = name
        self.grade = grade
        self.age = age

    def display(self):
        print("Name:" + self.name + " Grade:" + str(self.grade) + " Age: " + str(self.age))

s = Student("Tom",9.8,30)
# s.display()