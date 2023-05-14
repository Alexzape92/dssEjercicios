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
