package RedSocial;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.Scanner;

public class GestionComentarios {
    public static void gestionmenu() throws SQLException {
        Scanner sc = new Scanner(System.in);
        int opcion=0;
        while (opcion!=-1){
            System.out.print("1-Crear comentario");
            System.out.println(" -1-Salir");
            opcion=sc.nextInt();
            if(opcion==1){
                crearcomentario();
            }
        }
    }
    public static void crearcomentario() throws SQLException {
       Connection m= Main.connection;
       Scanner sc = new Scanner(System.in);
        if(Main.id_usuario==-1){
            System.out.println("Tens que iniciar sesió si vols vore o publicar una historia");
            GestionUsuarios.gestionMenu();
        }
        System.out.println("Selecciona quin post vols comentar");
            int idpost=getPost();
            System.out.println("Posa el text que vols");
            String texto=sc.nextLine();
            java.sql.Date fecha = new java.sql.Date(new Date().getTime());
            PreparedStatement st=m.prepareStatement("insert into comentarios(texto,fecha,id_usuario,id_post) values(?,?,?,?)");
            st.setString(1,texto);
            st.setDate(2,fecha);
            st.setInt(3, Main.id_usuario);
            st.setInt(4,idpost);
            st.executeUpdate();
    }
    public static int getPost() throws SQLException {
        GestionPosts.listarTodosLosPosts();
        Scanner sc = new Scanner(System.in);
        return sc.nextInt();
    }
    public static void printComentarios(int idpost) throws SQLException {
        Connection con= Main.connection;
        PreparedStatement st=con.prepareStatement("SELECT c.id,c.texto,c.fecha,u.nombre from comentarios as c inner join usuarios as u on u.id=c.id_usuario inner join posts as p on c.id_post=p.id WHERE p.id = ?");
        st.setInt(1,idpost);
        ResultSet rs=st.executeQuery();
        while(rs.next()){
            System.out.println("\t\t\t" + rs.getString(2) + " - " + rs.getDate(3 ) + " - " + rs.getString(4));
        }
    }
}
