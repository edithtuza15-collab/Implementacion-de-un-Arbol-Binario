package negocio;

import modelo.Nodo;

public class ArbolBinario<T> {
    private Nodo<T> raiz;

    public ArbolBinario() {
        this.raiz = null;
    }

    public Nodo<T> getRaiz() { return raiz; }

    public boolean esVacio() {
        return raiz == null;
    }

    public void crearRaiz(T dato) {
        if (raiz == null) {
            raiz = new Nodo<>(dato);
        } else {
            raiz.setDato(dato);
        }
    }

    // Busca un nodo por su dato
    public Nodo<T> buscar(T dato) {
        return buscar(raiz, dato);
    }

    private Nodo<T> buscar(Nodo<T> actual, T dato) {
        if (actual == null) return null;
        if (actual.getDato().equals(dato)) return actual;
        Nodo<T> izq = buscar(actual.getIzquierdo(), dato);
        if (izq != null) return izq;
        return buscar(actual.getDerecho(), dato);
    }

    public boolean agregarIzquierdo(T padre, T dato) {
        Nodo<T> nodoPadre = buscar(padre);
        if (nodoPadre == null) {
            System.out.println("No existe el padre: " + padre);
            return false;
        }
        if (nodoPadre.getIzquierdo() != null) {
            System.out.println("Error: " + padre + " ya tiene hijo izquierdo ocupado.");
            return false;
        }
        nodoPadre.setIzquierdo(new Nodo<>(dato));
        return true;
    }

    public boolean agregarDerecho(T padre, T dato) {
        Nodo<T> nodoPadre = buscar(padre);
        if (nodoPadre == null) {
            System.out.println("No existe el padre: " + padre);
            return false;
        }
        if (nodoPadre.getDerecho() != null) {
            System.out.println("Error: " + padre + " ya tiene hijo derecho ocupado.");
            return false;
        }
        nodoPadre.setDerecho(new Nodo<>(dato));
        return true;
    }

    public int contarNodos() {
        return contarNodos(raiz);
    }

    private int contarNodos(Nodo<T> actual) {
        if (actual == null) return 0;
        return 1 + contarNodos(actual.getIzquierdo()) + contarNodos(actual.getDerecho());
    }

    public int contarHojas() {
        return contarHojas(raiz);
    }

    private int contarHojas(Nodo<T> actual) {
        if (actual == null) return 0;
        if (actual.esHoja()) return 1;
        return contarHojas(actual.getIzquierdo()) + contarHojas(actual.getDerecho());
    }

    public int altura() {
        return altura(raiz);
    }

    private int altura(Nodo<T> actual) {
        if (actual == null) return -1;
        int altIzq = altura(actual.getIzquierdo());
        int altDer = altura(actual.getDerecho());
        return 1 + Math.max(altIzq, altDer);
    }

    public void mostrarArbol() {
        if (esVacio()) {
            System.out.println("(Arbol vacio)");
            return;
        }
        mostrarArbol(raiz, "", true);
    }

    private void mostrarArbol(Nodo<T> actual, String prefijo, boolean esUltimo) {
        if (actual == null) return;
        System.out.println(prefijo + (esUltimo ? "└── " : "├── ") + actual.getDato());
        String nuevoPrefijo = prefijo + (esUltimo ? "    " : "│   ");
        // Si tiene solo un hijo, mostrarlo como ultimo para que se vea bien
        if (actual.getIzquierdo() != null && actual.getDerecho() != null) {
            mostrarArbol(actual.getIzquierdo(), nuevoPrefijo, false);
            mostrarArbol(actual.getDerecho(), nuevoPrefijo, true);
        } else if (actual.getIzquierdo() != null) {
            mostrarArbol(actual.getIzquierdo(), nuevoPrefijo, true);
        } else if (actual.getDerecho() != null) {
            mostrarArbol(actual.getDerecho(), nuevoPrefijo, true);
        }
    }
}