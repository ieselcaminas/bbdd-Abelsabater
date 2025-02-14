import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConectarSQL {

    static java.sql.Connection connection;

    public static java.sql.Connection getConnection(){
        String host = "jdbc:sqlite:src/main/resources/network.sqlite";
        if (connection == null) {
            try {
                connection = java.sql.DriverManager.getConnection(host);
            }catch (SQLException sql){
                System.out.println(sql.getMessage());
                System.exit(0);
            }
        }
        return connection;
    }

    public static void main(String[] args) throws SQLException {
        java.sql.Connection j = getConnection();
        Statement STM=  j.createStatement();
        ResultSet rs = STM.executeQuery("SELECT * FROM usuarios");
        while (rs.next()) {
            System.out.println(rs.getString(1));
            System.out.println("\t" + rs.getString(2));
            System.out.println("\t" + rs.getString(3));
        }
        STM.close();
    }
}