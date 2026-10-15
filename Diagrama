## Diagrama de Clases

```mermaid
classDiagram
    class Nodo~T~ {
        - dato: T
        - izquierdo: Nodo~T~
        - derecho: Nodo~T~
        + Nodo(dato: T)
        + esHoja() : boolean
        + grado() : int
        + getDato() : T
        + setDato(dato: T) : void
        + getIzquierdo() : Nodo~T~
        + setIzquierdo(izquierdo: Nodo~T~) : void
        + getDerecho() : Nodo~T~
        + setDerecho(derecho: Nodo~T~) : void
    }

    class ArbolBinario~T~ {
        - raiz: Nodo~T~
        + ArbolBinario()
        + getRaiz() : Nodo~T~
        + esVacio() : boolean
        + crearRaiz(dato: T) : void
        + buscar(dato: T) : Nodo~T~
        + agregarIzquierdo(padre: T, dato: T) : boolean
        + agregarDerecho(padre: T, dato: T) : boolean
        + contarNodos() : int
        + contarHojas() : int
        + altura() : int
        + mostrarArbol() : void
    }

    ArbolBinario "1" *-- "0..*" Nodo : contiene
    Nodo "1" *-- "0..1" Nodo : izquierdo
    Nodo "1" *-- "0..1" Nodo : derecho
