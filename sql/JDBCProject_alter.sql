


alter table Grade
    add constraint fk_grade_StudentRollNo FOREIGN KEY (studentRollNo)
    REFERENCES Student(rollNo);


alter table Grade
    add constraint fk_grade_courseCode FOREIGN KEY (courseCode)
    REFERENCES Course(courseCode);


alter table Enrollment
    add constraint fk_enrollment_studentRollNo FOREIGN KEY (studentRollNo)
    REFERENCES Student(rollNo);


alter table Enrollment
    add constraint fk_enrollment_courseCode FOREIGN KEY (courseCode)
    REFERENCES Course(courseCode);


alter table reservation
    add constraint fk_reservation_roomNo FOREIGN KEY (roomNo)
    REFERENCES Rooms(roomNo);