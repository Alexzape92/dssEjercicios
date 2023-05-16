# Ejercicio de patrones - Distribuidora
## Apartado 1
Se presenta el siguiente diagrama de clases definiendo la estructura de las clases siguiendo el patrón de diseño `command`:

```mermaid
    classDiagram
    class Formulario
    class Proceso{
        +execute()
    }
    class FormularioOri{
        -paramsForm
    }
    class Procesador{
        -proceso
        +setProceso(proceso)
        +executeProceso()
    }
    class ProcesoOri{
        -paramsForm
        -almacen
        +ProcesoOri(paramsForm, almacen)
        +execute()
    }
    class Pedido{
        +Pedido(params)
    }
    class Almacen{
        +addPedido(pedido)
    }
    <<interface>> Formulario
    <<interface>> Proceso

    Formulario <|-- FormularioOri
    Proceso <|-- ProcesoOri

    FormularioOri --> Procesador
    Procesador --> Proceso
    ProcesoOri --> Almacen

    FormularioOri ..> ProcesoOri
    ProcesoOri ..> Pedido
```
Ante la posible aparición de un nuevo tipo de formulario, bastaría con crear otra subclase de `Formulario` que represente al nuevo tipo de formulario, y una nueva subclase de `Proceso`, que recogerá el comportamiento del sistema ante el nuevo formulario.

## Apartado 2
El diagrama de secuencia generado es el siguiente:

```mermaid
sequenceDiagram
System -->>+ formulario(FormularioOri): <<create>>
formulario(FormularioOri) -->> proc(ProcesoOri): new ProcesoOri(paramsForm, alm)
formulario(FormularioOri) ->>+ procesador(Procesador): setProceso(proc)
procesador(Procesador) -->>- formulario(FormularioOri): <<end>>
formulario(FormularioOri) -->>- System: <<end>>

System -->>+ procesador(Procesador): executeProceso()
procesador(Procesador) ->>+ proc(ProcesoOri): execute()
proc(ProcesoOri) -->> ped(Pedido): new Pedido(paramsForm)
proc(ProcesoOri) ->>+ alm(Almacen): addPedido(ped)
alm(Almacen) -->>- proc(ProcesoOri): <<end>>
proc(ProcesoOri) -->>- procesador(Procesador): <<end>>
procesador(Procesador) -->>- System: <<end>>>
```

## Apartado 3
Se puede realizar el diseño propuesto utilizando el patrón de diseño `decorator`. De esta manera, cada posible formulario tendría varios decoradores, en función de si necesitan barra desplazadora, bordes, etc. Un ejemplo de diseño sería el siguiente:

```mermaid
classDiagram
class Componente{
    +mostrar()
}
class Formulario{
    -formParams
    +mostrar()
}
class DecoradorBase{
    -envuelto
    +DecoradorBase(c: Componente)
    +mostrar()
}
class Largo{
    +mostrar()
    +extra()
}
class Borde{
    +mostrar()
    +extra()
}

<<interface>> Componente

Componente <|-- Formulario
Componente <|-- DecoradorBase
DecoradorBase <|-- Largo
DecoradorBase <|-- Borde

DecoradorBase o-- Componente
```
