package TorneoFutSal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Jugadors {
    public static void gestionarJugadores() throws SQLException {
        Scanner sc=new Scanner(System.in);
        int opcion=0;
        while (opcion!=-1){
            System.out.println("Que vols vore?");
            System.out.print("1-Estadistiques ");
            System.out.print("2-Insertar jugador");
            System.out.println("3-Insertar estadistiques");
            opcion=sc.nextInt();
            if(opcion== 1){
                estadistiques();
            }else if(opcion== 2){
                insertarJugadores();
            }else if(opcion== 3){
                insertarEstadisticas();
            }
        }
    }
    public static void estadistiques() throws SQLException {
        java.sql.Connection con = Main.connection;
        Scanner sc=new Scanner(System.in);
        String nombre;
        System.out.println("Ingrese el nombre del jugador");
        nombre=sc.nextLine();
        String sql="Select * from jugadores where nombre=?";
        PreparedStatement pst=con.prepareStatement(sql);
        pst.setString(1,nombre);
    }

    public static void insertarJugadores() throws SQLException {
        java.sql.Connection con = Main.connection;
        Scanner sc=new Scanner(System.in);
        String nombre;
        String apellidos;
        String posicio;
        System.out.println("Posa el nom del jugador ");
        nombre=sc.nextLine();
        System.out.println("Posa el apellido del jugador ");
        apellidos=sc.nextLine();
        System.out.println("Posa la posicio del jugador ");
        posicio=sc.nextLine();
        String sql="INSERT INTO jugadores(nombre,apellidos,posicion,goles,asistencias) VALUES(?,?,?,0,0)";
        PreparedStatement pst=con.prepareStatement(sql);
        pst.setString(1,nombre);
        pst.setString(2,apellidos);
        pst.setString(3,posicio);
        pst.executeUpdate();
    }
    public static void insertarEstadisticas() throws SQLException {
        java.sql.Connection con = Main.connection;
        Scanner sc=new Scanner(System.in);
        String nombre;
        String estadistica;
        System.out.println("Posa el nom del jugador ");
        nombre=sc.nextLine();
        System.out.println("Que vols posarli (GOLES/ASISTENCIAS)");
        estadistica=sc.nextLine();
        if(estadistica.toUpperCase().equals("GOLES")){
            int num;
            String sql="UPDATE jugadores SET goles=? WHERE nombre=?";
            PreparedStatement pst=con.prepareStatement(sql);
            System.out.println("Quants li vols posar");
            num=sc.nextInt();
            pst.setString(1, String.valueOf(num));
            pst.setString(2,nombre);
        }else if(estadistica.toUpperCase().equals("ASISTENCIAS")){
            int num;
            String sql="UPDATE jugadores SET asistencias=? WHERE nombre=?";
            PreparedStatement pst=con.prepareStatement(sql);
            System.out.println("Quants li vols posar");
            num=sc.nextInt();
            pst.setString(1, String.valueOf(num));
            pst.setString(2,nombre);
        }
    }
}
