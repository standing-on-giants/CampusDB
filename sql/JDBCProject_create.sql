
create table STUDENT(
    rollNo int,
    studentName varchar(50),
    constraint pk_student PRIMARY KEY(rollNo)
);


create table COURSE(
    courseCode int,
    courseName varchar(50),
    constraint pk_course PRIMARY KEY(courseCode)
);


create table GRADE(
    gradeID int,
    studentRollNo int,
    courseCode int,
    grade int,
    constraint pk_grade PRIMARY KEY(gradeID)
);


create table ENROLLMENT(
    enrollmentID int,
    studentRollNo int,
    courseCode int,
    enrollmentDate char(10),
    constraint pk_enrollment PRIMARY KEY(enrollmentID)
);


create table RESERVATION(
    reservationID int,
    roomNo int,
    reservationDate char(10),
    reservationDurationInMonths int,
    constraint pk_reservation PRIMARY KEY(reservationID)
);


create table ROOMS(
    roomNo int,
    capacity int,
    constraint pk_rooms PRIMARY KEY(roomNo)
);