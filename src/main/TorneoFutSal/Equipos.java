package TorneoFutSal;

import java.sql.SQLException;
import java.util.Scanner;

public class Equipos {
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
    public static void gestionarEquipos() throws SQLException {
        Scanner sc=new Scanner(System.in);
        int opcion=0;
        while (opcion!=-1){
            System.out.println("Que vols vore?");
            System.out.print("1-Estadistiques ");
            System.out.print("2-Insertar equipo");
            System.out.println("3-Insertar estadistiques");
            opcion=sc.nextInt();
            if(opcion== 1){
            }else if(opcion== 2){
            }else if(opcion== 3){
            }
        }
    }
    public static void insertarEquipo() throws SQLException {
        Scanner sc=new Scanner(System.in);

    }
}
