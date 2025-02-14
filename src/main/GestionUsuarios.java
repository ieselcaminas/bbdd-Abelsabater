import java.util.Scanner;

public class GestionUsuarios {
    public static void gestionMenu(){
        Scanner sc=new Scanner(System.in);
        int opcion=0;
        while (opcion !=-1){
            System.out.println("1 -Usuarios");
            System.out.println("2 -Posts");
            System.out.println("3 -Comentarios");
            if(opcion== 1){
                GestionUsuarios.gestionMenu();
            }
        }
    }
}
