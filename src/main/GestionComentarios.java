import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;
import java.util.Scanner;

public class GestionComentarios {
    public static void gestionmenu() throws SQLException {
        Scanner sc = new Scanner(System.in);
        int opcion=0;
        while (opcion!=-1){
            System.out.print("1-Crear comentario");
            System.out.print(" 2-Ver comentarios");
            System.out.println(" -1-Salir");
            opcion=sc.nextInt();
            if(opcion==1){
                crearcomentario();
            }else if(opcion==2){

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
        if(Main.id_post==-1){
            System.out.println("No hi ha ningun post d'aquest usuario");
        }else{
            System.out.println("Posa el text que vols");
            String texto=sc.nextLine();
            java.sql.Date fecha = new java.sql.Date(new Date().getTime());
            PreparedStatement st=m.prepareStatement("insert into comentarios(texto,fecha,id_usuario,id_post) values(?,?,?,?)");
            st.setString(1,texto);
            st.setDate(2,fecha);
            st.setInt(3,Main.id_usuario);
            st.setInt(4,Main.id_post);
        }
    }
}