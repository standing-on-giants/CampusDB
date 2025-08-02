insert into Student(rollNo, studentName)
Values(1, 'Shashank');

insert into Student(rollNo, studentName)
VALUES(2, 'Koushik');


insert into course(courseCode, courseName)
VALUES(51, 'SPIT');

insert into course(courseCode, courseName)
VALUES(52, 'DBS');


insert into ENROLLMENT(enrollmentID, studentRollNo, courseCode, enrollmentDate)
VALUES(1, 1, 51, '11-11-1111');

insert into ENROLLMENT(enrollmentID, studentRollNo, courseCode, enrollmentDate)
VALUES(2, 2, 51, '21-11-1111');


insert into GRADE(gradeID, studentRollNo, courseCode, grade)
Values(1, 1, 51, 4);

insert into GRADE(gradeID, studentRollNo, courseCode, grade)
Values(2, 2, 51, 3);


insert into Rooms(roomNo, capacity)
Values(101, 10);

insert into Rooms(roomNo, capacity)
Values(102, 9);


insert into reservation(reservationID, roomNo, reservationDate, reservationDurationInMonths)
Values(501, 101, '22-11-1111', 9);

insert into reservation(reservationID, roomNo, reservationDate, reservationDurationInMonths)
Values(502, 101, '30-11-1111', 8);
