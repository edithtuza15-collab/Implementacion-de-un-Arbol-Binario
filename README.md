# Implementacion-de-un-Arbol-Binario
**Asignatura:** Estructura de Datos · **Nivel:** Tercero – Ingeniería de Software
**Autor:** _Apellido Nombre_

## 1. Problema
La Universidad necesita representar la organización de sus dependencias académicas con un árbol binario. Cada nodo guarda el nombre de una dependencia y tiene como máximo dos hijos.

## 2. Estructura del árbol
```
UNIVERSIDAD
├── [I] FISEI
│   ├── [I] SOFTWARE
│   │   ├── [I] NIVEL1
│   │   └── [D] NIVEL3
│   └── [D] TI
└── [D] DIDE
    ├── [I] INVEST.
    └── [D] VINCULACIÓN
```
9 nodos · 5 hojas · altura 3 (en aristas).

## 3. Organización del proyecto
```
src/
├── modelo/Nodo.java
├── negocio/ArbolBinario.java
└── app/Main.java
```

## 4. Instrucciones de ejecución
```bash
javac -d out src/modelo/*.java src/negocio/*.java src/app/*.java
java -cp out app.Main
```

## 5. Resultados
_Pegar aquí las capturas del menú, del árbol y de los casos de prueba._

| Caso | Resultado esperado |
|------|--------------------|
| Árbol vacío | 0 nodos, altura -1 |
| Un solo nodo | 1 hoja, altura 0 |
| Árbol inicial | 9 nodos, 5 hojas, altura 3 |
| Posición ocupada | Excepción controlada |
| Grado FISEI / SOFTWARE | 2 / 2 |
