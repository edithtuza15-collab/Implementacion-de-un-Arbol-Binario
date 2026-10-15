package app;

import java.util.Scanner;
import modelo.Nodo;
import negocio.ArbolBinario;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArbolBinario<String> arbol = new ArbolBinario<>();
        int opcion;

        do {
            mostrarMenu();
            opcion = leerEntero(sc);
            System.out.println();

            switch (opcion) {
                case 1:
                    crearArbolInicial(arbol);
                    System.out.println("Arbol inicial creado.");
                    break;
                case 2:
                    System.out.println("--- ARBOL ---");
                    arbol.mostrarArbol();
                    break;
                case 3:
                    System.out.println("Numero de nodos: " + arbol.contarNodos());
                    break;
                case 4:
                    System.out.println("Numero de hojas: " + arbol.contarHojas());
                    break;
                case 5:
                    System.out.println("Altura (en aristas): " + arbol.altura());
                    break;
                case 6:
                    System.out.print("Ingrese el nombre del nodo: ");
                    String nombreGrado = sc.nextLine().trim().toUpperCase();
                    Nodo<String> n1 = arbol.buscar(nombreGrado);
                    if (n1 == null) System.out.println("Nodo no encontrado.");
                    else System.out.println("Grado de " + nombreGrado + ": " + n1.grado());
                    break;
                case 7:
                    System.out.print("Ingrese el nombre del nodo: ");
                    String nombreHoja = sc.nextLine().trim().toUpperCase();
                    Nodo<String> n2 = arbol.buscar(nombreHoja);
                    if (n2 == null) System.out.println("Nodo no encontrado.");
                    else if (n2.esHoja()) System.out.println(nombreHoja + " SI es hoja.");
                    else System.out.println(nombreHoja + " NO es hoja.");
                    break;
                case 8:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opcion no valida.");
            }
            System.out.println();
        } while (opcion != 8);

        sc.close();
    }

    private static void crearArbolInicial(ArbolBinario<String> arbol) {
        arbol.crearRaiz("UNIVERSIDAD");
        arbol.agregarIzquierdo("UNIVERSIDAD", "FISEI");
        arbol.agregarDerecho("UNIVERSIDAD", "DIDE");
        arbol.agregarIzquierdo("FISEI", "SOFTWARE");
        arbol.agregarDerecho("FISEI", "TI");
        arbol.agregarIzquierdo("DIDE", "INVEST.");
        arbol.agregarDerecho("DIDE", "VINCULACIÓN");
        arbol.agregarIzquierdo("SOFTWARE", "NIVEL1");
        arbol.agregarDerecho("SOFTWARE", "NIVEL3");
    }

    private static void mostrarMenu() {
        System.out.println("===== MENU ARBOL BINARIO =====");
        System.out.println("1. Crear arbol inicial");
        System.out.println("2. Visualizar arbol");
        System.out.println("3. Consultar numero de nodos");
        System.out.println("4. Consultar numero de hojas");
        System.out.println("5. Consultar altura");
        System.out.println("6. Consultar grado de un nodo");
        System.out.println("7. Verificar si un nodo es hoja");
        System.out.println("8. Salir");
        System.out.print("Elija una opcion: ");
    }

    private static int leerEntero(Scanner sc) {
        while (!sc.hasNextInt()) {
            System.out.print("Ingrese un numero valido: ");
            sc.next();
        }
        int n = sc.nextInt();
        sc.nextLine();
        return n;
    }
}