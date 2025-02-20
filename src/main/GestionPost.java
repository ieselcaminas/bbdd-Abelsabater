import java.sql.SQLException;
import java.util.Date;
import java.util.Scanner;

public class GestionPost {
    public static void gestionMenu() throws SQLException {
        Scanner sc = new Scanner(System.in);
        String usuario;
        int opcion = 0;
        while (opcion != -1) {
            System.out.print("1-Crear post ");
            System.out.println("-1-Salir");
            if (sc.nextInt() == 1) {
                nuevopost();
            }
        }
    }
    public static void nuevopost() throws SQLException {
        Scanner sc = new Scanner(System.in);
        String texto;
        int likes;
        int id_usuario;
        java.sql.Date fecha = new java.sql.Date(new Date().getTime());
        System.out.println("Que vols publicar?");
        texto = sc.nextLine();
    }

}
