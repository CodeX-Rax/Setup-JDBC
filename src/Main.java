//this code is used for how to update data in database.
import java.sql.*;

public class Main {
    public static void main(String[] args)throws ClassNotFoundException {

        String url="jdbc:mysql://localhost:3306/mydatabase";
        String username="root";
        String password="Rush@1311";
        String query="UPDATE employees\n"+
                "SET job_title='java developer',salary=1900000.0\n"+
                "WHERE id=1;";

        //used to load connection drivers
        try{
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Driver Loaded Successfully...,  ");
        }
        catch (ClassNotFoundException e){
            System.out.println(e.getMessage());

        }

        //used to connect with database
        try{
            Connection con =DriverManager.getConnection(url,username,password);
            System.out.println("Connection Establish Successfully....,   ");
            Statement stmt=con.createStatement();
            int rowsaffected = stmt.executeUpdate(query);//executeUpdate() used to insert data into DB //rowsaffected is used to check the no of rows data is filled
            if (rowsaffected>0){
                System.out.println("Updation Successfull."+rowsaffected+" row(s) affected. ");
            }else{
                System.out.println("Updation failed !!");
            }



            //We closed all the Instances that we created above
            stmt.close();
            con.close();
            System.out.println();
            System.out.println("Connection closed successfully!! ");
        } catch (SQLException e) {
            System.out.println("Connection Failed !! "+e.getMessage());
        }

    }
}






/*//this code is used for how to delete data in database.
import java.sql.*;

public class Main {
    public static void main(String[] args)throws ClassNotFoundException {

        String url="jdbc:mysql://localhost:3306/mydatabase";
        String username="root";
        String password="Rush@1311";
        String query="DELETE FROM employees WHERE id=3;";

        //used to load connection drivers
        try{
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Driver Loaded Successfully...,  ");
        }
        catch (ClassNotFoundException e){
            System.out.println(e.getMessage());

        }

        //used to connect with database
        try{
            Connection con =DriverManager.getConnection(url,username,password);
            System.out.println("Connection Establish Successfully....,   ");
            Statement stmt=con.createStatement();
            int rowsaffected = stmt.executeUpdate(query);//executeUpdate() used to insert data into DB //rowsaffected is used to check the no of rows data is filled
            if (rowsaffected>0){
                System.out.println("Deletion Successfull."+rowsaffected+" row(s) affected. ");
            }else{
                System.out.println("Deletion failed !!");
            }



            //We closed all the Instances that we created above
            stmt.close();
            con.close();
            System.out.println();
            System.out.println("Connection closed successfully!! ");
        } catch (SQLException e) {
            System.out.println("Connection Failed !! "+e.getMessage());
        }

    }
}*/



/*//this code is used for how to insert data in database.
import java.sql.*;

public class Main {
    public static void main(String[] args)throws ClassNotFoundException {

        String url="jdbc:mysql://localhost:3306/mydatabase";
        String username="root";
        String password="Rush@1311";
        String query="INSERT INTO employees(id,name,job_title,salary)values (3,'Rax','Java Developer',987645);";

        //used to load connection drivers
        try{
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Driver Loaded Successfully...,  ");
        }
        catch (ClassNotFoundException e){
            System.out.println(e.getMessage());

        }

        //used to connect with database
        try{
            Connection con =DriverManager.getConnection(url,username,password);
            System.out.println("Connection Establish Successfully....,   ");
            Statement stmt=con.createStatement();
            int rowsaffected = stmt.executeUpdate(query);//executeUpdate() used to insert data into DB //rowsaffected is used to check the no of rows data is filled
            if (rowsaffected>0){
                System.out.println("Insert Successfull."+rowsaffected+" row(s) affected. ");
            }else{
                System.out.println("Insertion failed !!");
            }



                //We closed all the Instances that we created above
                stmt.close();
                con.close();
                System.out.println();
                System.out.println("Connection closed successfully!! ");
        } catch (SQLException e) {
            System.out.println("Connection Failed !! "+e.getMessage());
        }

    }
}*/









/*
//all this used to take and print data from database to here.
import java.sql.*;

public class Main {
    public static void main(String[] args)throws ClassNotFoundException {

        String url="jdbc:mysql://localhost:3306/mydatabase";
        String username="root";
        String password="Rush@1311";
        String query="select * from employees;";

        //used to load connection drivers
        try{
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Driver Loaded Successfully...,  ");
        }
        catch (ClassNotFoundException e){
            System.out.println(e.getMessage());

        }

        //used to connect with database
        try{
            Connection con =DriverManager.getConnection(url,username,password);
            System.out.println("Connection Establish Successfully....,   ");


            Statement stmt=con.createStatement();
            ResultSet rs=stmt.executeQuery(query);//executeQuery() is used to retrieve data from db
            while (rs.next()){//next to run this loop until all data from database is retrieve
                int id = rs.getInt("id");
                String name=rs.getString("name");
                String job_title=rs.getString("job_title");
                double salary = rs.getDouble("salary");
                System.out.println();
                System.out.println("---------------------------------------");
                System.out.println("ID : "+id);
                System.out.println("Name : "+name);
                System.out.println("Job Title : "+job_title);
                System.out.println("Salary : "+salary);

                //We closed all the Instances that we created above
                rs.close();
                stmt.close();
                con.close();
                System.out.println();
                System.out.println("Connection closed successfully!! ");
            }
        } catch (SQLException e) {
            System.out.println("Connection Failed !! "+e.getMessage());
        }
    }
}*/
