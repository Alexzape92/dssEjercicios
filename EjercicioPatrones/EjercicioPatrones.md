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

