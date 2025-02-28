import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.Scanner;
public class GestionPost {
    public static void gestionMenu() throws SQLException {
        Scanner sc = new Scanner(System.in);
        int opcion = 0;
        while (opcion != -1){
            System.out.print(" 1 - Nuevo Post | ");
            System.out.print(" 2 - Todos los posts | ");
            System.out.print(" 3 - Todos mis posts | ");
            System.out.println("-1 para Salir");

            opcion = sc.nextInt();
            if (opcion == 1){
                crearpost();
            }else if(opcion == 2){
                listarTodosLosPostsConComentarios();
            }else if(opcion == 3){
                listarTodosMisPosts();
            }
        }

    }
    public static void listarTodosLosPosts() throws SQLException {
        Connection con = Main.connection;
        PreparedStatement st = con.prepareStatement("SELECT p.id, p.texto, p.likes, p.fecha, u.nombre" +
                " FROM posts as p " +
                " INNER JOIN usuarios as u ON p.id_usuario = u.id");
        ResultSet rs = st.executeQuery();
        while (rs.next()){
            printPost(rs);
        }
    }
    public static void listarTodosLosPostsConComentarios() throws SQLException {
        Connection con = Main.connection;
        PreparedStatement st = con.prepareStatement("SELECT p.id, p.texto, p.likes, p.fecha, u.nombre FROM posts as p " +
                "INNER JOIN usuarios as u ON p.id_usuario = u.id");
        ResultSet rs = st.executeQuery();
        while (rs.next()){
            printPost(rs);
            GestionComentarios.printComentarios(rs.getInt(1));
        }
    }

    public static void listarTodosMisPosts() throws SQLException {
        Connection con = Main.connection;
        PreparedStatement st = con.prepareStatement("SELECT p.id, p.texto, p.likes, p.fecha, u.nombre FROM posts as p " +
                "INNER JOIN usuarios as u ON p.id_usuario = u.id WHERE u.id = ?");
        st.setInt(1, Main.id_usuario);
        ResultSet rs = st.executeQuery();
        while (rs.next()){
            printPost(rs);
            GestionComentarios.printComentarios(rs.getInt(1));

        }
    }
    public static void printPost(ResultSet rs) throws SQLException {
        System.out.println(rs.getInt(1) + " " +
                rs.getString(2) + " likes:" +
                rs.getInt(3) + " " + rs.getDate(4) +
                " " + rs.getString(5));

    }
    public static void crearpost() throws SQLException {
        if(Main.id_usuario == -1) {
            GestionUsuarios.gestionMenu();
            return;
        }
        Connection con = Main.connection;
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce el texto");
        String texto = sc.nextLine();
        java.sql.Date fecha = new java.sql.Date(new Date().getTime());
        PreparedStatement st = con.prepareStatement("INSERT INTO posts (texto, likes, fecha, id_usuario) VALUES (? , ?, ?, ?)");
        st.setString(1, texto);
        st.setInt(2, 0);
        st.setDate(3, fecha);
        st.setInt(4, Main.id_usuario);
        st.executeUpdate();
    }
}
