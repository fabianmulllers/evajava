# EVALUACION JAVA

Se creo una aplicacion API RESTFUL para la creacion de usuarios GET, POST, PUT, PATCH Y DELETE.

# Proyecto Spring Boot 3.2.3 con Java 17 y Maven

Este README proporciona información sobre un proyecto en Spring Boot 3.2.3 que utiliza Java 17 como versión del lenguaje y Maven como gestor de dependencias. El proyecto ya está programado y listo para ser ejecutado.

## Descripción del Proyecto

El proyecto es una aplicación web basada en Spring Boot que proporciona ciertas funcionalidades específicas. 

## Requisitos Previos

Asegúrate de tener instalados los siguientes elementos en tu entorno de desarrollo:

- JDK 17 o superior
- Maven 3.6.x o superior

## Instrucciones de Uso

```plaintext
Paso 1: Clonar el Repositorio

Clona el repositorio de GitHub en tu máquina local utilizando el siguiente comando:

git clone https://github.com/fabianmulllers/evajava.git


Paso 2: Importar el Proyecto

Abre tu IDE (IntelliJ IDEA, Eclipse, etc.) y importa el proyecto como un proyecto Maven existente.


Paso 3: Configurar la Base de Datos 

Se utilizo como base de datos H2

Paso 4: Ejecutar el Proyecto

Ejecuta el proyecto desde tu IDE o utilizando Maven desde la línea de comandos. 

Desde la línea de comandos, navega hasta el directorio raíz del proyecto y ejecuta el siguiente comando:

mvn spring-boot:run

Esto iniciará la aplicación y estará disponible en la URL predeterminada (http://localhost:9191/evaluacion).

Paso 5: Probar la Aplicación

Una vez que la aplicación esté en funcionamiento, puedes probarla accediendo a los endpoints proporcionados. Puedes utilizar herramientas como Postman o simplemente un navegador web para interactuar con la aplicación.

La aplicacion tiene instalada swagger podras ingresar desde la siguiente URL http://localhost:9191/evaluacion/swagger-ui/index.html

Este README.md tiene todos los pasos dentro de un bloque de código para que puedas copiarlos fácilmente. ¡Espero que te sea útil!


## Endpoint disponibles

Actualizar un usuario
PUT http://localhost:9191/evaluacion/usuarios/update

Guardar un usuario
POST http://localhost:9191/evaluacion/usuarios/save

Desactivar un usuario
PATCH http://localhost:9191/evaluacion/usuarios/desactivar/{id}

Obtener todos los usuarios
GET http://localhost:9191/evaluacion/usuarios/

Eliminar un usuario
DELETE http://localhost:9191/evaluacion/usuarios/eliminar/{id}

Agregar una expresion regular para la validacion de la password
POST http://localhost:9191/evaluacion/password/save


Datos de entrada para agregar usuario

```json

{
    "nombre": "Juan Rodriguez",
    "correo": "juan@rodriguez.org",
    "password": "hunter2",
    "telefonos": [
            {
                "numero": "1234567",
                "codigoCiudad": "1",
                "codigoPais": "57"
            }
        ]
}


Datos de entrada actualizar usuario (El id es el que se obtiene al guardar el usuario)

```json
{
  "id": "289fcb0c-dd63-44c9-9e3e-7b0140f5f08e",
  "nombre": "Juan Rodriguez",
  "correo": "juan@rodriguez.org",
  "password": "hunter2",
  "telefonos": [
    {
      "id": 1,
      "numero": "987654",
      "codigoCiudad": "1",
      "codigoPais": "57"
    }
  ]
}

