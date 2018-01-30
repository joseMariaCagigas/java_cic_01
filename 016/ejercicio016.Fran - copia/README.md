
# GESTOR DE TAQUILLA DE UN CINE


## Casos de uso

Versión preliminar v0.1:
1. Vender entradas ($n$ entradas)
2. Obtener recaudación sala (para un día)
3. Obtener recaudación total (para un día)
4. Guardar en fichero
5. Leer de fichero

v0.2:
1. Cierre (bloquea los mecanismos que introduzcan cambios: ventas, devoluciones...)
1.1. Cerrar sesión
1.2. Abrir sesión
1.3. Cerrar cine completo
1.4. Abrir cine completo
2. Cambiar venta
2.1. Devolver venta
2.2. Vender entradas (caso v0.1:1)
3. Devolver venta (caso v0.2:2.1)
4. Realizar descuento por grupo (a partir de 5 personas, descuento de 10% al total ---4 entradas: 20€, 5 entradas: 22.5€---)-


## Interfaz de las clases

**Sesion**, implementa *Serializable*:

+ Sesion(capacidad : entero)
+ capacidad() : entero
+ estaDisponible(indice : entero) : booleano -- *gestión de localidades numeradas*
+ cambiaDisponibilidad(indice : entero, disponibilidad : booleano) -- *gestión de localidades numeradas*
+ desocupaUnaLocalidad() -- *gestión de localidades NO numeradas*
+ localidadesDisponibles() : entero
+ localidadesOcupadas() : entero
+ ocupaLocalidadDisponible() -- *gestión de localidades NO numeradas*

**Sala**, implementa *Serializable*:

+ Sala(capacidad : entero)
+ agregaSesion()
+ capacidad() : entero
+ desocupaLocalidad(idSesion : entero, idLocalidad : entero) -- *gestión de localidades numeradas*
+ desocupaLocalidad(idSesion : entero) -- *gestión de localidades NO numeradas*
+ estaDisponible(idSesion : entero, idLocalidad : entero) -- *gestión de localidades numeradas*
+ limpiaSesiones()
+ localidadesDisponibles(idSesion : entero) : entero
+ localidadesOcupadas(idSesion : entero) : entero
+ numeroSesiones() : entero
+ entradasVendidas() : entero
+ ocupaLocalidad(idSesion : entero, idLocalidad : entero) -- *gestión de localidades numeradas*
+ ocupaLocalidad(idSesion : entero) -- *gestión de localidades NO numeradas*

**GestionTaquilla**:

+ __GestionTaquilla.carga(nombreFichero : String) : GestionTaquilla__
+ GestionTaquilla(salas : conjunto de Sala)
+ localidadesDisponibles(idSala : entero, idSesion : entero) : entero
+ obtenRecaudacion(idSala : entero) : double
+ obtenRecaudacion() : double
+ vendeEntrada(idSala : entero, idSesion : entero, idLocalidad : entero) -- *gestión de localidades numeradas*
+ vendeEntrada(idSala : entero, idSesion : entero) -- *gestión de localidades NO numeradas*
+ vendeEntradas(idSala : entero, idSesion : entero, nEntradas : entero) -- *gestión de localidades NO numeradas*
