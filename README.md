# CampusDB: MySQL-based Database Application

A comprehensive Java-based database management system designed originally for universities, but can be easily extended to any organization. Built using JDBC and MySQL, this application provides a terminal-based interface for managing students, courses, rooms, enrollments, grades, and reservations.

## Features

### Core Functionalities
- **Student Management**: Add, remove, and edit student information
- **Course Management**: Create and modify course details
- **Room Management**: Add rooms and update capacity
- **Grade Tracking**: Record and retrieve student grades
- **Enrollment System**: Manage student course enrollments
- **Room Reservations**: Handle room booking and scheduling

### Database Operations
- Complete CRUD (Create, Read, Update, Delete) operations
- Transaction management with rollback support
- Foreign key constraints for data integrity
- Interactive menu-driven interface

## Database Schema

The system includes the following entities:

- **STUDENT**: Student information (rollNo, studentName)
- **COURSE**: Course details (courseCode, courseName)
- **GRADE**: Student grades (gradeID, studentRollNo, courseCode, grade)
- **ENROLLMENT**: Course enrollments (enrollmentID, studentRollNo, courseCode, enrollmentDate)
- **ROOMS**: Room information (roomNo, capacity)
- **RESERVATION**: Room reservations (reservationID, roomNo, reservationDate, reservationDurationInMonths)

## Prerequisites

- Java Development Kit (JDK) 8 or higher
- MySQL Server 5.7 or higher
- MySQL Connector/J (JDBC Driver)

## Installation & Setup

### 1. Database Setup
```sql
-- Create the database
CREATE DATABASE studentDB4;

-- Run the table creation script
mysql -u root -p studentDB4 < sql/JDBCProject_create.sql

-- Add foreign key constraints
mysql -u root -p studentDB4 < sql/JDBCProject_alter.sql

-- Insert sample data (optional)
mysql -u root -p studentDB4 < sql/JDBCProject_insert.sql
```

### 2. Configure Database Connection
Edit the database credentials in `JdbcDemo.java`:

```java
static final String DB_URL = "jdbc:mysql://localhost:3306/studentDB4";
static final String USER = "your_username";
static final String PASSWORD = "your_password";
```

### 3. Compile and Run
```bash
# Compile the Java file
javac -cp ".:mysql-connector-java-x.x.x.jar" JdbcDemo.java

# Run the application
java -cp ".:mysql-connector-java-x.x.x.jar" JdbcDemo
```

## Usage

The application provides an interactive menu with the following options:

### Student Operations
- **1**: Add a new student
- **7**: Remove a student
- **11**: Edit student name
- **16**: Find student grades

### Course Operations
- **3**: Add a new course
- **13**: Modify course name

### Room Operations
- **2**: Add a new room
- **5**: Reserve a room
- **8**: Remove a room
- **12**: Update room capacity

### Academic Operations
- **4**: Add student grades
- **6**: Enroll student in course

### Exit
- **18**: Exit the application

## Project Structure

```
CampusDB/
├── src/
│   └── JdbcDemo.java           # Main application file
├── sql/
│   ├── JDBCProject_create.sql  # Table creation scripts
│   ├── JDBCProject_alter.sql   # Foreign key constraints
│   ├── JDBCProject_insert.sql  # Sample data insertion
│   └── JDBCProject_menuItems.sql # Additional utilities
├── class/
│   └── JdbcDemo.class         # Compiled Java classes
└── README.md
```

## Key Technical Features

- **Transaction Management**: Automatic commit/rollback for data consistency
- **Error Handling**: Major exceptions handled for database operations
- **Data Validation**: Checks for existing records before operations
- **Foreign Key Constraints**: Maintains referential integrity

## Sample Operations

### Adding a Student
```
Enter student details:
Student roll number: 101
Student firstName: John
```

### Viewing Grades
```
Enter student roll number: 101
Grade of given student in course 51 is 4
```

### Room Reservation
```
Enter reservation details:
ReservationID: 503
Room No: 101
Reservation duration (in months): 6
Reservation date (DD-MM-YYYY): 15-03-2024
```

## Error Handling

The application provides robust error handling including:
- Database connection failures
- Transaction rollback scenarios
- Non-existent records
- Resource cleanup after termination

## Contributing

1. Fork the repository
2. Create a feature branch (`git checkout -b feature/AmazingFeature`)
3. Commit your changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

## Contact

For questions or suggestions, please open an issue in the repository.

---
