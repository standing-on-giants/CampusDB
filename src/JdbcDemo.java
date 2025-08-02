// Preparing menu for adding a student

//STEP 1. Import required packages
import java.sql.*;
import java.util.Scanner;

public class JdbcDemo {

   // Set JDBC driver name and database URL
   static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
   static final String DB_URL = "jdbc:mysql://localhost:3306/studentDB4";

   // Database credentials
   static final String USER = "root";// add your user
   static final String PASSWORD = "admin";// add password

   public static void main(String[] args) {
      Connection conn = null;
      Statement stmt = null;


      // STEP 2. Connecting to the Database
      try {
         // STEP 2a: Register JDBC driver
         Class.forName(JDBC_DRIVER);
         // STEP 2b: Open a connection
         System.out.println("Connecting to database...");
         conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
         // STEP 2c: Execute a query
         System.out.println("Creating statement...");
         stmt = conn.createStatement();
         conn.setAutoCommit(false);

            while(true){
               System.out.println("Choose any of the valid options below (1 to 20): ");
               System.out.println("1. Add a student");               System.out.println("2. Add a room");      System.out.println("3. Add a course");
               System.out.println("4. Add a student's grade");       System.out.println("5. Reserve a room");  System.out.println("6. Enroll a student into a course");
   
               System.out.println("7. Remove a student");            System.out.println("8. Remove a room");   
   
               System.out.println("11. Edit a student's name");     System.out.println("12. Upgrade a room's capacity");      System.out.println("13. Modify course name");
   
               System.out.println("16. Find out the grade of a particular student");
               System.out.println("18. Exit");
               System.out.println();
               
               Scanner scan1 = new Scanner(System.in);
               Integer choice = scan1.nextInt();

               if (choice == 18){
                  System.out.println("End of Code");
                  break;
               }
   
   
                  switch (choice) {
                     case 1:
                        System.out.println("Enter below student details: ");
                        System.out.print("Student roll number: ");             Integer rollNo = scan1.nextInt();
                        System.out.print("Student firstName: ");              String firstName = scan1.next();
      
                        //System.out.print(rollNo + " " + firstName + "\n");
                        // String addStudent = "insert into student" +
                        //         "(rollNo, studentName) " +
                        //         "VALUES(" + rollNo + ", '" + firstName + "');";
                        String addStudent = "insert into student(rollNo, studentName) Values(%d, %s);";
                        //System.out.printf(addStudent, rollNo, firstName);
                        String s = String.format("insert into student(rollNo, studentName) Values(%d, '%s');", rollNo, firstName);
                        System.out.println(s);
      
                        int r1 = stmt.executeUpdate(s);
                        //stmt.close();
      
                        System.out.println();
                        System.out.println();
      
                        break;
      
                     case 2:
                        System.out.println("Enter below room details: ");
                        System.out.print("Room number: ");                    Integer roomNumber = scan1.nextInt();
                        System.out.print("Room capacity: ");                  Integer roomCapacity = scan1.nextInt();
      
                        String addRoom = String.format("insert into rooms(roomNo, capacity) Values(%d, %d);", roomNumber, roomCapacity);
      
                        stmt.executeUpdate(addRoom);
                        //stmt.close();
      
                        System.out.println();
                        System.out.println();
      
                        break;
      
                     case 3:
      
                        System.out.println("Enter below course details: ");
                        System.out.print("Course code: ");                    Integer courseCode = scan1.nextInt();
                        System.out.print("Course name: ");                    String courseName = scan1.next();
      
                        String addCourse = String.format("insert into course(courseCode, courseName) Values(%d, '%s');", courseCode, courseName);
                        // System.out.println(addCourse);
      
                        stmt.executeUpdate(addCourse);
                        //stmt.close();
      
                        System.out.println();
                        System.out.println();
      
                        break;
      
                     case 4:
                        System.out.println("Enter below grade details: ");      
                        System.out.print("GradeID: ");                        Integer gradeID4 = scan1.nextInt();
                        System.out.print("Student rollNo: ");                 Integer rollNo4 = scan1.nextInt();
                        System.out.print("course code: ");                    Integer courseCode4 = scan1.nextInt();
                        System.out.print("Grade: ");                          Integer grade4 = scan1.nextInt();
      
      
                        String addGrade = String.format("insert into grade(gradeID, studentRollNo, courseCode, grade) Values(%d, %d, %d, %d);", gradeID4, rollNo4, courseCode4, grade4);
                        // System.out.println(addCourse);
      
                        int r4 = stmt.executeUpdate(addGrade);
                        // System.out.println("r4 = " + r4);
                        // //stmt.close();
                        // if (r4 == 0){
                        //    System.out.println("Rolling back data here");
                        //    conn.rollback();
                        // }
      
                        System.out.println();
                        System.out.println();
      
                        break;

                     case 5:
                        System.out.println("Enter below reservation details: ");      
                        System.out.print("ReservationID: ");                        Integer ReservationID5 = scan1.nextInt();
                        System.out.print("Room No: ");                              Integer roomNo5 = scan1.nextInt();      
                        System.out.print("Reservation duration (in months): ");     Integer duration5 = scan1.nextInt();
                        System.out.print("Reservation date (DD-MM-YYYY): ");        String DateStr = scan1.next();
      
      
                        String addReservation = String.format("insert into reservation(reservationID, roomNo, reservationDate, reservationDurationInMonths) Values(%d, %d, '%s', %d);", ReservationID5, roomNo5, DateStr, duration5);
                        // System.out.println(addCourse);
      
                        stmt.executeUpdate(addReservation);
      
                        System.out.println();
                        System.out.println();
      
                        break;
                     
                     case 6:
                        System.out.println("Enter below enrollment details: ");      
                        System.out.print("enrollmentID: ");                         Integer enrollmentID6 = scan1.nextInt();
                        System.out.print("studentRollNo: ");                        Integer studentRollNo6 = scan1.nextInt();
                        System.out.print("courseCode: ");                           Integer courseCode6 = scan1.nextInt();
                        System.out.print("Enrollment date (DD-MM-YYYY): ");         String enrollmentDate6 = scan1.next();      
      
      
                        String addEnrollment = String.format("insert into enrollment(enrollmentID, studentRollNo, courseCode, enrollmentDate) Values(%d, %d, %d, '%s');", enrollmentID6, studentRollNo6, courseCode6, enrollmentDate6);
                        // System.out.println(addCourse);
      
                        stmt.executeUpdate(addEnrollment);
      
                        System.out.println();
                        System.out.println();
      
                        break;
                        
      
                     case 7:
                        System.out.print("Enter student roll number: ");      Integer rollNumber = scan1.nextInt();
      
                        //Perform a query to check whether the student with that roll number exists
                        String query7 = String.format("SELECT rollNo from student where rollNo = %d;", rollNumber);
                        ResultSet rs7 = stmt.executeQuery(query7);
      
                        int count7 = 0;
      
                        while (rs7.next()) {
                           count7++;
                        }
      
                        //If yes, remove the student
                        if (count7 > 0){
                           String removeStudent = String.format("DELETE FROM Student where rollNo = %d;", rollNumber);
                           //System.out.println(removeStudent);
      
                           stmt.executeUpdate(removeStudent);
      
                           System.out.println();
                           System.out.println();
                        }
                        else{
                           System.out.println("Requested student doesn't exist");
      
                           System.out.println();
                           System.out.println();
                        }
      
                        break;

                     
                     case 8:
                        System.out.print("Enter room number: ");      Integer roomNumber8 = scan1.nextInt();
         
                        //Perform a query to check whether the student with that roll number exists
                        String query8 = String.format("SELECT roomNo from rooms where roomNo = %d;", roomNumber8);
                        ResultSet rs8 = stmt.executeQuery(query8);
      
                        int count8 = 0;      
                        //int caughtRoomNo = rs8.getInt("roomNo");     System.out.printf("caughtRoomNo = %d", caughtRoomNo);
      
                        while (rs8.next()) {
                           count8++;
                        }
      
                        //If yes, remove the student
                        if (count8 > 0){
                           String removeRoom = String.format("DELETE FROM Rooms where roomNo = %d;", roomNumber8);
                           //System.out.println(removeStudent);
      
                           stmt.executeUpdate(removeRoom);
      
                           System.out.println();
                           System.out.println();
                        }
                        else{
                           System.out.println("Requested room doesn't exist");
      
                           System.out.println();
                           System.out.println();
                        }
      
                        break;

                     case 11:
                        System.out.println("Enter below student details: ");
                        System.out.print("Enter student roll number: ");      Integer studentRollNo11 = scan1.nextInt();
                        System.out.print("Enter new name of student: ");      String newStudentName11 = scan1.next();
            
                        //Perform a query to check whether the student with that roll number exists
                        String query11 = String.format("SELECT studentName from student where rollNo = %d;", studentRollNo11);
                        ResultSet rs11 = stmt.executeQuery(query11);
      
                        int count11 = 0;      
      
                        while (rs11.next()) {
                           count11++;
                        }
      
                        //If yes, remove the student
                        if (count11 > 0){
                           String updateName11 = String.format("UPDATE Student SET studentName = '%s' WHERE rollNo = %d;", newStudentName11, studentRollNo11);
      
                           stmt.executeUpdate(updateName11);
      
                           System.out.println();
                           System.out.println();
                        }
                        else{
                           System.out.println("Requested student doesn't exist");
      
                           System.out.println();
                           System.out.println();
                        }
      
                        break;

                     case 12:
                        System.out.println("Enter below room details: ");
                        System.out.print("Enter room number: ");                    Integer roomNo12 = scan1.nextInt();
                        System.out.print("Enter new capacity of the room: ");       Integer newRoomCapacity12 = scan1.nextInt();
            
                        //Perform a query to check whether the student with that roll number exists
                        String query12 = String.format("SELECT roomNo from rooms where roomNo = %d;", roomNo12);
                        ResultSet rs12 = stmt.executeQuery(query12);
      
                        int count12 = 0;      
      
                        while (rs12.next()) {
                           count12++;
                        }
      
                        //If yes, remove the student
                        if (count12 > 0){
                           String updateCapacity12 = String.format("UPDATE rooms SET capacity = %d WHERE roomNo = %d;", newRoomCapacity12, roomNo12);
      
                           stmt.executeUpdate(updateCapacity12);
      
                           System.out.println();
                           System.out.println();
                        }
                        else{
                           System.out.println("Requested room doesn't exist");
      
                           System.out.println();
                           System.out.println();
                        }
      
                        break;

                     case 13:
                        System.out.println("Enter below course details: ");
                        System.out.print("Enter course code: ");                 Integer courseCode13 = scan1.nextInt();
                        System.out.print("Enter new name of the course: ");      String newCourseName13 = scan1.next();
            
                        //Perform a query to check whether the student with that roll number exists
                        String query13 = String.format("SELECT courseCode from course where courseCode = %d;", courseCode13);
                        ResultSet rs13 = stmt.executeQuery(query13);
      
                        int count13 = 0;      
      
                        while (rs13.next()) {
                           count13++;
                        }
      
                        //If yes, remove the student
                        if (count13 > 0){
                           String updateCourseName13 = String.format("UPDATE course SET courseName = '%s' WHERE courseCode = %d;", newCourseName13, courseCode13);
      
                           stmt.executeUpdate(updateCourseName13);
      
                           System.out.println();
                           System.out.println();
                        }
                        else{
                           System.out.println("Requested course doesn't exist");
      
                           System.out.println();
                           System.out.println();
                        }
      
                        break;

                        
                     
                     case 16:
                        System.out.print("Enter student roll number: ");      Integer rollNumber16 = scan1.nextInt();
      
                        //Perform a query to check whether the student with that roll number exists
                        String query16 = String.format("SELECT grade, courseCode from student, grade where rollNo = %d and studentRollNo = rollNo;", rollNumber16);
                        ResultSet rs16 = stmt.executeQuery(query16);
      
                        int count16 = 0;
      
                        while (rs16.next()) {
                           count16++;
                           Integer grade16 = rs16.getInt("grade");      Integer courseCode16 = rs16.getInt("courseCode");
                           System.out.println("Grade of given student in course " +  courseCode16 + " is " + grade16);    System.out.println();      System.out.println();
                        }
      
                        if (count16 == 0){
                           System.out.println("Student doesn't exist");           System.out.println();      System.out.println();
                        }
      
                        break;
                  
                     default:
                        break;
                  }
   
                }
               conn.commit();
               System.out.println("Committed successfully");
            
            
         // INSERT, UPDATE, DELETE
         //stmt.executeUpdate(addStudent);

         // // STEP 3: Query to database
         // String query = "SELECT rollNo from student";
         // ResultSet rs = stmt.executeQuery(query);

         // // STEP 4: Extract data from result set
         // while (rs.next()) {

         // // Retrieve by column name
         // Integer rollNo = rs.getInt("rollNo");
         // // String lname = rs.getString("lname");
         // // Date birthDate = rs.getDate("bdate", null);
         // // Integer dno = rs.getInt("dno");

         // // Display values
         // System.out.print("rollNo: " + rollNo);
         // System.out.println();
         // // System.out.print(", lname: " + lname);
         // // System.out.print(", birth date: " + birthDate.toString());
         // // System.out.println(", department number: " + dno);
         // }

         
         // // STEP 5: Clean-up environment
         // rs.close();
         //conn.close();
         }catch (SQLException se) { // Handle errors for JDBC
         se.printStackTrace();
         try{
            if (conn != null){
               conn.rollback();
               System.out.println("Rolling back data here");
            }
         }
         catch(SQLException se3){}
      } catch (Exception e) { // Handle errors for Class.forName
         e.printStackTrace();
      } finally { // finally block used to close resources regardless of whether an exception was
                  // thrown or not
      }
         try {
            if (stmt != null) stmt.close();
         } catch (SQLException se2) {}
         try {
            if (conn != null) conn.close();
         } catch (SQLException se) {
            se.printStackTrace();
         } // end finally try
          // end try
   } // end main
} // end class

// Note : By default autocommit is on. you can set to false using
// con.setAutoCommit(false)
