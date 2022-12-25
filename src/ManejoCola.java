
import java.util.Scanner;
import java.io.IOException;
import java.util.Arrays;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author enriq
 */
public class ManejoCola {

    //tamaño de colas
    private static final int maxTam = 3;

    //frente de colas
    private static int frente1;
    private static int frente2;
    private static int frente3;
    private static int frente4;

    //final de colas
    private static int ultimoCaj1;
    private static int ultimoCaj2;
    private static int ultimoCaj3;
    private static int ultimoCaj4;

    //Colas, cajeros
    private String[] cajero1;
    private String[] cajero2;
    private String[] cajero3;
    private String[] cajero4;

    //Inicializar variables
    public ManejoCola() {
        frente1 = 0;
        frente2 = 0;
        frente3 = 0;
        frente4 = 0;
        ultimoCaj1 = -1;
        ultimoCaj2 = -1;
        ultimoCaj3 = -1;
        ultimoCaj4 = -1;
        cajero1 = new String[maxTam];
        cajero2 = new String[maxTam];
        cajero3 = new String[maxTam];
        cajero4 = new String[maxTam];

    }

    //método para agregar a la cola
    public void Insertar() {
        Scanner leer = new Scanner(System.in);
        String client;
        System.out.println("Digite un cliente: ");
        client = leer.nextLine();
        if (ultimoCaj1 <= ultimoCaj2 && ultimoCaj1 <= ultimoCaj3 && ultimoCaj1 <= ultimoCaj4) {
            if (!Caja1Llena()) {
                cajero1[++ultimoCaj1] = client;
            }else{
                System.err.println("La caja 1 está llena");
            }      
        } else if (ultimoCaj2 <= ultimoCaj1 && ultimoCaj2 <= ultimoCaj3 && ultimoCaj2 <= ultimoCaj4) {
            if (!Caja2Llena()) {
                cajero2[++ultimoCaj2] = client;
            } else{
                System.err.println("La caja 2 está llena");
            }       
        } else if (ultimoCaj3 <= ultimoCaj1 && ultimoCaj3 <= ultimoCaj2 && ultimoCaj3 <= ultimoCaj4) {
            if (!Caja3Llena()) {
                cajero3[++ultimoCaj3] = client;
            } else{
                System.err.println("La caja 3 está llena");
            }      
        } else if (ultimoCaj4 <= ultimoCaj1 && ultimoCaj4 <= ultimoCaj2 && ultimoCaj4 <= ultimoCaj3) {
            if (!Caja4Llena()) {
                cajero4[++ultimoCaj4] = client;
            }else{
                System.err.println("La caja 4 está llena");
            }       
        } else {
            cajero1[++ultimoCaj1] = client;
        }
    }

    //Método para atender a clientes de cada caja.
    public void Atender() {//editar y eliminar la caja que tenga más 
        /*Scanner leer = new Scanner(System.in);
        String elegirCaja = "";
        int opcion = 0;

        elegirCaja += "**Digite la caja a atender: \n";
        elegirCaja += "1.Caja 1.\n";
        elegirCaja += "2.Caja 2.\n";
        elegirCaja += "3.Caja 3.\n";
        elegirCaja += "4.Caja 4.\n";
        elegirCaja += "5.Salir.";

        do {//corregir error y agregarlo como en ingresar
            System.out.println(elegirCaja);
            opcion = leer.nextInt();*/
            if ((ultimoCaj1 >= ultimoCaj2 && ultimoCaj1 >= ultimoCaj3 && ultimoCaj1 >= ultimoCaj4)) {
                if (!Caja1Vacia()) {
                    cajero1[frente1] = cajero1[frente1 + 1];
                    cajero1[frente1 + 1] = cajero1[frente1 + 2];
                    cajero1[frente1 + 2] = null;
                    ultimoCaj1--;
                } else {
                    System.err.println("La caja 1 está vacía");
                }

            } else if ((ultimoCaj2 >= ultimoCaj1 && ultimoCaj2 >= ultimoCaj3 && ultimoCaj2 >= ultimoCaj4)) {
                if (!Caja2Vacia()) {
                    cajero2[frente2] = cajero2[frente2 + 1];
                    cajero2[frente2 + 1] = cajero2[frente2 + 2];
                    cajero2[frente2 + 2] = null;
                    ultimoCaj2--;
                } else {
                    System.err.println("La caja 2 está vacía");
                }

            } else if ((ultimoCaj3 >= ultimoCaj1 && ultimoCaj3 >= ultimoCaj2 && ultimoCaj3 >= ultimoCaj4)) {
                if (!Caja3Vacia()) {
                    cajero3[frente3] = cajero3[frente3 + 1];
                    cajero2[frente3 + 1] = cajero3[frente3 + 2];
                    cajero3[frente3 + 2] = null;
                    ultimoCaj3--;
                } else {
                    System.err.println("La caja 3 está vacía");
                }

            } else if ((ultimoCaj4 >= ultimoCaj1 && ultimoCaj4 >= ultimoCaj2 && ultimoCaj4 >= ultimoCaj3)) {
                if (!Caja4Vacia()) {
                    cajero4[frente4] = cajero4[frente4 + 1];
                    cajero4[frente4 + 1] = cajero4[frente4 + 2];
                    cajero4[frente4 + 2] = null;
                    ultimoCaj4--;
                } else {
                    System.err.println("La caja 4 está vacía");
                }
            } else {
            }
        //} while (opcion != 5);
    }//Cierre Atender

    //Método para mostrar cajas
    public void MostrarCajas() {
        System.out.println("***Contenido de cajas.***");
        String contenido1 = "Caja 1: ";
        for (int i = 0; i < cajero1.length; i++) {
            contenido1 += cajero1[i] + ", ";
        }

        String contenido2 = "Caja 2: ";
        for (int i = 0; i < cajero2.length; i++) {
            contenido2 += cajero2[i] + ", ";
        }

        String contenido3 = "Caja 3: ";
        for (int i = 0; i < cajero3.length; i++) {
            contenido3 += cajero3[i] + ", ";
        }

        String contenido4 = "Caja 4: ";
        for (int i = 0; i < cajero4.length; i++) {
            contenido4 += cajero4[i] + ", ";
        }

        System.out.println(contenido1);
        System.out.println(contenido2);
        System.out.println(contenido3);
        System.out.println(contenido4);
    }//Cierre MostrarCajas

    //Métodos para comprobar si las cajas están llenas.
    public boolean Caja1Llena() {
        return ultimoCaj1 == maxTam;
    }

    public boolean Caja2Llena() {
        return ultimoCaj2 == maxTam;
    }

    public boolean Caja3Llena() {
        return ultimoCaj3 == maxTam;
    }

    public boolean Caja4Llena() {
        return ultimoCaj4 == maxTam;
    }//Cierre de métodos para comprobar cajas llenas.

    //Métodos para comprobar si las cajas están vacías.
    public boolean Caja1Vacia() {
        return frente1 > ultimoCaj1;
    }

    public boolean Caja2Vacia() {
        return frente2 > ultimoCaj2;
    }

    public boolean Caja3Vacia() {
        return frente3 > ultimoCaj3;
    }

    public boolean Caja4Vacia() {
        return frente4 > ultimoCaj4;
    }//Cierre métodos para comprobar cajas vacías.
}
