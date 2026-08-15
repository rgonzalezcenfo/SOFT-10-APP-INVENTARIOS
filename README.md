# SOFT-10 — Aplicación de Gestión de Inventarios

Proyecto final del curso **SOFT-10 Estructuras de Datos**, Universidad CENFOTEC.
Sección SCV6 — Periodo C2-2026.

Aplicación de consola para la gestión de un sistema de ventas de productos en
línea. El inventario, la cola de clientes, los carritos de compra y el mapa de
entregas se manejan con estructuras de datos dinámicas implementadas desde cero.

## Requisitos

- **Java 21** o superior (JDK)
- Opcionalmente IntelliJ IDEA, que ya trae la configuración del proyecto

## Cómo ejecutar

### Desde IntelliJ IDEA

Abrir la carpeta `AppInventarios` como proyecto y ejecutar la clase `Main`.

### Desde la línea de comandos

```bash
cd AppInventarios/src
javac -d ../out $(find . -name "*.java")
java -cp ../out Main
```

En Windows (PowerShell):

```powershell
cd AppInventarios\src
javac -d ..\out (Get-ChildItem -Recurse -Filter *.java).FullName
java -cp ..\out Main
```

## Estructuras de datos utilizadas

| Estructura | Clase | Para qué se usa |
|---|---|---|
| Árbol binario de búsqueda | `Estructuras.ArbolProductos` | Inventario de productos, ordenado e indexado por nombre. Permite insertar, buscar, eliminar y listar en orden alfabético mediante recorrido inorden. |
| Lista enlazada simple | `Estructuras.CarritoUsuario` | Carrito de compras de cada cliente. Cada nodo es un `ItemCarrito`. |
| Cola con prioridad | `Estructuras.ColaUsuarios` | Clientes en espera de ser atendidos. Se ordena por el atributo `prioridad` (1 a 3, mayor primero). |
| Grafo ponderado no dirigido | `Estructuras.Grafo` | Mapa de ubicaciones de entrega, implementado con lista de adyacencia. Los pesos representan la distancia entre ubicaciones. |

El nodo del árbol es la propia clase `Entidades.Producto`, y el nodo de la lista
enlazada es `Entidades.ItemCarrito`.

## Funcionalidad

El menú principal permite:

1. Agregar un producto al inventario
2. Mostrar la lista de productos en orden alfabético
3. Modificar un producto
4. Eliminar un producto
5. Ver el reporte de productos con el valor total del inventario
6. Registrar un nuevo cliente y llenar su carrito
7. Atender al siguiente cliente de la cola
8. Gestionar el grafo de ubicaciones
9. Salir

### Búsqueda de rutas de entrega

Al **atender a un cliente** (opción 7), el programa imprime la factura de su
carrito junto con el camino más corto entre la ubicación del cliente y la de la
tienda, calculado con el **algoritmo de Dijkstra**, y la distancia total de esa
ruta.

La ubicación de un cliente se agrega automáticamente como vértice del grafo en
el momento en que el cliente entra a la cola. Si esa ubicación está desconectada
del resto del mapa, el cliente **no puede ser atendido** y permanece en la cola
hasta que se agregue una conexión que la enlace.

Desde la opción 8 se puede consultar el mapa completo, agregar nuevas
ubicaciones y agregar conexiones con su distancia.

## Mapa inicial

El grafo arranca precargado con el siguiente mapa, de modo que el programa sea
operable desde el primer momento:

```
Tienda   --  8 --  Alajuela
Tienda   -- 18 --  Cartago
Alajuela -- 10 --  Heredia
Alajuela -- 20 --  San Jose
Heredia  -- 15 --  San Jose
San Jose -- 12 --  Cartago
```

## Organización del código

```
AppInventarios/src/
├── Main.java              Punto de entrada
├── Entidades/             Producto, Usuario, Tienda, ItemCarrito
├── Estructuras/           ArbolProductos, CarritoUsuario, ColaUsuarios,
│                          Grafo, Vertice, Arista
├── LogicaDeNegocio/       Administradores de inventario, clientes, cola,
│                          carrito y grafo
├── Excepciones/           Excepciones de negocio
└── Menu/                  Menú principal, menú del grafo y búsqueda de
                           productos
```

## Convención de commits

```
[new]       Se creó un método o recurso que no existía antes
[improved]  Se mejoró la forma en que se hacía algo
[fixed]     Se corrigió un problema
[updated]   Se reemplazó un recurso o código hecho por alguien más
[init]      Inicio del repositorio
```

Ramas: `main` (versiones estables), `feature/*`, `fix/*`, `docs/*`.
