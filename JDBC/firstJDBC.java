import java.sql.*;
class FirstJDBC
{
    public static void main(String[] args) {
        try{
            //load driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            //created connection 
            String url = "jdbc:mysql://localhost:3306/sagar";
            String username = "root";
            String password = "9402";
            Connection con = DriverManager.getConnection(url,username,password);

            if(con.isClosed()){
                System.out.println("Connection is cloased");
            }
            else{
                System.out.println("Connection is created ...");
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}