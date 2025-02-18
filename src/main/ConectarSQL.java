import java.sql.PreparedStatement;
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
        java.sql.Connection con = getConnection();
        Statement STM=  con.createStatement();
        ResultSet rs = STM.executeQuery("SELECT * FROM usuarios");
        inseruser();
        inseruserPreparedStatement();
        while (rs.next()) {
            System.out.println(rs.getString(1));
            System.out.println("\t" + rs.getString(2));
            System.out.println("\t" + rs.getString(3));
        }
        STM.close();
    }
    public static void inseruser() throws SQLException {
        Statement st = connection.createStatement();
        st.executeUpdate("INSERT INTO usuarios (nombre, apellidos) VALUES('Juan','Espinosa')");
    }
    public static void inseruserPreparedStatement() throws SQLException {
        PreparedStatement st = null;
        String sql="INSERT INTO usuarios (nombre, apellidos) VALUES(?,?)";
        st=connection.prepareStatement(sql);
        st.setString(1,"Jua");
        st.setString(2,"Alberto");
        st.executeUpdate();
    }
    public static void deleteuser() throws SQLException {
        Statement st = connection.createStatement();
        st.executeUpdate("DELETE FROM usuarios");

    }
}