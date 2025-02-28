package RedSocial;

import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    static java.sql.Connection connection;
    static String usuarioini ="";
    static int id_usuario=-1;
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
        Scanner sc=new Scanner(System.in);
        Main.connection = getConnection();
        int opcion=0;
        while (opcion !=-1){
            if(!usuarioini.isEmpty()){
                System.out.println("Bienvenido");
                System.out.println("\t"+usuarioini);
            }
            System.out.print("1-Usuarios ");
            System.out.print("2-Posts ");
            System.out.print("3-Comentarios ");
            System.out.println("-1-Salir");
            opcion=sc.nextInt();
            if(opcion== 1){
                GestionUsuarios.gestionMenu();
            }else if(opcion== 2){
                GestionPosts.gestionMenu();
            }else if(opcion== 3){
                GestionComentarios.gestionmenu();
            }
        }
    }
}