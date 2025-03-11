package TorneoFutSal;

import RedSocial.GestionComentarios;
import RedSocial.GestionPosts;
import RedSocial.GestionUsuarios;

import java.sql.SQLException;
import java.util.Scanner;

public class Main {
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
        Scanner sc=new Scanner(System.in);
        int opcion=0;
        while (opcion!=-1){
            System.out.println("Que vols vore?");
            System.out.print("1-Jugadors ");
            System.out.print("2-Equipos ");
            System.out.println("3-Fase de grupos");
            opcion=sc.nextInt();
            if(opcion== 1){
                Jugadors.gestionarJugadores();
            }else if(opcion== 2){
                Equipos.gestionarEquipos();
            }else if(opcion== 3){
                Grupos.gestionarGrupos();
            }
        }
    }
}
