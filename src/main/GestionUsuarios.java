import java.sql.*;
import java.util.Scanner;

public class GestionUsuarios {
    public static void gestionMenu() throws SQLException {
        Scanner sc=new Scanner(System.in);
        int opcion=0;
        while (opcion !=-1){
            System.out.println("1 -Loguearse");
            System.out.println("2 -Crear usuarios");
            System.out.println("-1 -Salir");
            opcion=sc.nextInt();
            if(opcion== 1){
                boolean logeado=existeUsuario();
                if(logeado){
                    break;
                }
            }else if(opcion==2){
                crearUsuario();
            }
        }
    }
    public static boolean existeUsuario() throws SQLException {
        java.sql.Connection con = Main.connection;
        Scanner sc=new Scanner(System.in);
        System.out.println("Ingrese su usuario");
        String usuario=sc.nextLine();
        System.out.println("Ingrese su password");
        String password=sc.nextLine();
        PreparedStatement st=con.prepareStatement("select * from usuarios where nombre=? and contrasenya=?");
        st.setString(1, usuario);
        st.setString(2, password);
        ResultSet rs = st.executeQuery();
        return rs.next();
    }
    public static String crearUsuario() throws SQLException {
        java.sql.Connection con = Main.connection;
        Scanner sc=new Scanner(System.in);
        System.out.println("Ingrese su usuario");
        String usuari=sc.nextLine();
        System.out.println("Ingrese su apellidos");
        String apellidos=sc.nextLine();
        System.out.println("Ingrese su password");
        String passw=sc.nextLine();
        String sql="INSERT INTO usuarios(nombre,apellidos,contrasenya) VALUES (?,?,?)";
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setString(1, usuari);
        pst.setString(2, apellidos);
        pst.setString(3, passw);
        pst.executeUpdate();
        return usuari;
    }
}