import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;
import java.util.Scanner;

public class GestionPost {
    public static void gestionMenu() throws SQLException {
        Scanner sc = new Scanner(System.in);
        String usuario;
        int opcion = 0;
        while (opcion!=-1) {
            System.out.print("1-Crear post ");
            System.out.println("-1-Salir");
            opcion = sc.nextInt();
            if (opcion == 1) {
                nuevopost();
            }
        }
    }
    public static void nuevopost() throws SQLException {
        if(Main.id_usuario==-1){
            System.out.println("Tens que iniciar sesió si vols vore o publicar una historia");
            GestionUsuarios.gestionMenu();
        }
        java.sql.Connection con = Main.connection;
        Scanner sc = new Scanner(System.in);
        String texto;
        java.sql.Date fecha = new java.sql.Date(new Date().getTime());
        System.out.println("Que vols publicar?");
        texto = sc.nextLine();
        PreparedStatement st=con.prepareStatement("INSERT INTO posts(texto,likes,fecha,id_usuario) VALUES (?,0,?,?)");
        st.setString(1, texto);
        st.setDate(2,fecha);
        st.setInt(3,Main.id_usuario);
        st.executeUpdate();
    }
}