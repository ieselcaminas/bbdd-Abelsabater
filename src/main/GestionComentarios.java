import java.sql.Connection;
import java.sql.SQLException;
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
        if(Main.id_usuario==-1){
            System.out.println("Tens que iniciar sesió si vols vore o publicar una historia");
            GestionUsuarios.gestionMenu();
        }

    }
}
