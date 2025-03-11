package TorneoFutSal;

import RedSocial.Main;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Equipos {
    public static void gestionarEquipos() throws SQLException {
        Scanner sc=new Scanner(System.in);
        int opcion=0;
        while (opcion!=-1){
            System.out.println("Que vols vore?");
            System.out.print("1-Insertar equipo");
            System.out.println("2-Insertar estadistiques");
            opcion=sc.nextInt();
            if(opcion== 1){
                insertarEquipo();
            }else if(opcion== 2){
                insertarEstadisticas();
            }
        }
    }
    public static void insertarEquipo() throws SQLException {
        java.sql.Connection con = Main.connection;
        Scanner sc=new Scanner(System.in);
        String nombreEquipo;
        int idGrupo;
        System.out.println("Ingrese nombre del equipo");
        nombreEquipo=sc.nextLine();
        System.out.println("A quin grup vols posarlo");
        idGrupo=sc.nextInt();
        String sql = "INSERT INTO equipos(nombre,puntos,id) VALUES(?,0,?)";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, nombreEquipo);
        ps.setInt(2, idGrupo);
    }
    public static void insertarEstadisticas() throws SQLException {
        java.sql.Connection con = Main.connection;
        Scanner sc=new Scanner(System.in);
        String nombreEquipo;
        int puntos;
        System.out.println("Ingrese nombre del equipo");
        nombreEquipo=sc.nextLine();
        System.out.println("Quants punts vols posarli al equipo");
        puntos=sc.nextInt();
        String sql="UPDATE jugadores SET puntos=? WHERE nombre=?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, puntos);
        ps.setString(2, nombreEquipo);
    }

}
