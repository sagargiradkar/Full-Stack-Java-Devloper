import java.sql.*;
class Test
{
    public static void main(String[] args)
    {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try{
            //step1. Load and register the Driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver loaded succesfylly ...");

            //step2. Establish the Connection with database
            String url = "jdbc:mysql://localhost:3306/ineuron";
            String userName = "root";
            String password = "9402";
            connection = DriverManager.getConnection(url,userName,password);
            
            System.out.println("The implementation class name is :: "+
            connection.getClass().getName());

            //step3. Create statement Object and send the query
            String sqlSelectQuery = "select * from student";
            statement = connection.createStatement();
            System.out.println("The implementation class name is :: "+statement.getClass().getName());

            resultSet = statement.executeQuery(sqlSelectQuery);
            // System.out.println(resultSet);
            System.out.println("The implementation class name is :: "+resultSet.getClass().getName());

            //step4. process the resultSet
            
        }
        catch(ClassNotFoundException  ce)
        {
            ce.printStackTrace();
        }
        catch(SQLException se){
            se.printStackTrace();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}