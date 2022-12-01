
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author enriq
 */
public class MenuCola {
    private ManejoCola cola;
    
    public MenuCola(){
        this.cola=new ManejoCola();
    }
    
    //Método para mostrar el menu de opciones.
    public void MostrarMenu(){
        Scanner leer=new Scanner(System.in);
        String opcionesMenu="";
        int opcion=0;
        
        //opciones menu
        opcionesMenu+="****Cola Bancaria****\n";
        opcionesMenu+="Escoga una opción:\n";
        opcionesMenu+="1.Ingresar a la cola\n";
        opcionesMenu+="2.Atender\n";
        opcionesMenu+="3.Mostrar cajas.\n";
        opcionesMenu+="4.Salir.\n";
        opcionesMenu+="Digire una opción: ";
        
        //loop
        do {
            System.out.println(opcionesMenu);
            opcion=leer.nextInt();
            switch(opcion){
                case 1:
                    this.cola.Insertar();
                    break;
                case 2:
                    this.cola.Atender();
                    break;
                case 3:
                    this.cola.MostrarCajas();
                    break;
                case 4:
                    break;
            }
        } while (opcion!=4);
                       
    }//Cierre MostrarMenu
}//Cierre clase
