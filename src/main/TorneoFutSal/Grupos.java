package TorneoFutSal;

import RedSocial.Main;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Grupos {
    public static void gestionarGrupos() throws SQLException {
        Scanner sc=new Scanner(System.in);
        int opcion=0;
        while (opcion!=-1){
            System.out.println("Que vols vore?");
            System.out.print("1-Vore Grupo ");
            System.out.print("2-Insertar grupo");
            opcion=sc.nextInt();
            if(opcion== 1){
            }else if(opcion== 2){
            }
        }
    }
    public static void insertarGrupo() throws SQLException{
        java.sql.Connection con = Main.connection;
        Scanner sc=new Scanner(System.in);
        String letra;
        System.out.println("Posali la lletra");
        letra=sc.nextLine();
        String sql = "INSERT INTO grupos(letra) VALUES(?)";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, letra);
    }
    public static void estadisticas() throws SQLException{
        java.sql.Connection con = Main.connection;
        Scanner sc=new Scanner(System.in);
        String letra;
        System.out.println("Dime la lletra del grupo");
        letra=sc.nextLine();
        PreparedStatement ps = con.prepareStatement("SELECT e.nombre,e.puntos from equipos e inner join grupos g on e.id_g=g.id where g.letra=? order by e.puntos desc");
        ps.setString(1, letra);
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            System.out.println("Nombre");
        }
    }
}
