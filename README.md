# Sistema de Búsqueda y Recomendación de Películas
## Objetivo del proyecto

Diseñar y desarrollar un sistema de recomendación de películas utilizando el conjunto de
API REST que ofrece la “Open Movie Database” en la siguiente liga:

https://developers.themoviedb.org/3/ <br />

## Especificación de requerimientos funcionales

a) Para que un usuario pueda hacer uso del sistema de recomendaciones debe
registrarse y proporcionar los datos sobre sus gustos y preferencias acerca del
género de películas que prefiere, actores y directores. También deberá registrar
una lista de las películas que ha visto y que más le gustaron.<br/>
b) El usuario registrado y verificado podrá realizar búsquedas de películas por:
nombre, actor, género o palabras claves.<br/>
c) Una vez que el usuario se ha registrado, podrá ejecutar el sistema de
recomendación, el cual le ofrecerá una lista de películas recomendados de
acuerdo a sus preferencias registradas.<br/>

## Especificación técnica

Como requisitos para la evaluación del curso será necesario cumplir con los siguientes
requerimientos de implementación.

1. Los servicios Web deberán construirse con la plataforma de desarrollo de NetBeans y
el soporte que ofrece a través de JAX-RS Web Services.
2. Para implementar la base de datos de usuarios, se utilizará el manejador de bases de
datos MARIA DB en su versión más reciente. El diseño de la base de datos para el
registro de usuarios deberá considerar los siguientes datos:

a) Usuario y contraseña para ingresar<br/>
b) Nombre completo del usuario<br/>
c) Edad y género<br/>
d) Correo electrónico<br/>
e) Género de películas<br/>
f) Actores y directores favoritos<br/>
g) Listado de los películas favoritas<br/>

3. Para el diseño y despliegue de los servicios REST con acceso a la base de datos de
usuarios se utilizará un servidor Web Apache Tomcat.
4. Para el registro y gestión de usuarios se debe diseñar y desplegar un conjunto de
clientes a través de los cuales se interactúe con el conjunto de servicios REST.
5. Diseño y despliegue de clientes de servicio REST para realizar búsquedas de
películas en la “Open Movie Database”.
6. Diseño y despliegue de clientes de servicio REST a la “Open Movie Database” para
obtener la lista de películas que se recomiendan para cada usuario de acuerdo a sus
preferencias.

7. Diseño e implementación de una aplicación Web que integre la información del
usuario así como las recomendaciones de películas.
8. La aplicación Web correspondiente al cliente deberá consumir los servicios a través de
la API-REST, para ello se podrán utilizar herramientas de consumo de servicios
específicas de los lenguajes de los clientes.

Para el desarrollo del proyecto se deberá considerar la arquitectura de la Figura 1.

![picture alt](https://github.com/JoseAP89/RecomendacionPelis/blob/main/img/arqui_proj.png "diagrama")

Figura 1. Arquitectura del sistema de recomendación y búsqueda de películas

La arquitectura del sistema de recomendación de películas consistirá de las siguientes
capas:

1. La capa de aplicaciones cliente puede desarrollarse utilizando cualquier lenguaje
de programación y entorno de desarrollo de aplicaciones. Esta aplicación deberá
invocar a los servicios de registro y acceso de usuarios, de búsqueda y
recomendación de películas.

2. La capa de servicios deberá ofrecer las interfaces de programación (APIs REST)
para el registro de usuarios, la búsqueda de películas y la generación de
recomendaciones. Dentro de esta capa de servicios se deberán desarrollar tanto
servicios para acceso y gestión a los datos de los usuarios, así como clientes de
servicios a la base de datos de “Open Movie Database” para realizar búsquedas y
para generar las recomendaciones de películas de acuerdo a las preferencias de
los usuarios. Estos servicios y clientes REST deben estar basados en las APIs de
JAX-RS Web Services de java.

3. La capa de datos consistirá de una base de datos relacional “local” con los
registros de los usuarios, mientras que la base de información de las películas se
obtendrá de la “Open Movie Database”.

## Modelo Entidad-Relación

![picture alt](https://github.com/JoseAP89/RecomendacionPelis/blob/main/docs/Modelo_ER.png "ER")

## Pantalla de Inicio

![picture alt](https://github.com/JoseAP89/RecomendacionPelis/blob/main/img/pantalla_inicio.png "inicio")

## Requisitos
Se deben tener los siguientes requerimientos:
* Node.js
* Maven 3.2+
* JDK 1.8 o superior
* Mysql

## Puesta en marcha del proyecto en local

Una vez clonado el proyecto en tu local se debe seguir los siguientes pasos:
1. Cambiarse al front y ejecutar el comando para instalar las dependencias del proyecto de front y correr el cliente en modo desarrollo.<br/>
  `$ npm install && npm run dev`
3. Se debe crear una base de datos con el nombre peliculas.<br/>
  `$ CREATE DATABASE testdb;`
4. Crear un usuario para la base de datos que se llame 'movie' y tenga el password 'depelicula123'.<br/>
  `$ create user 'movie'@'localhost' identified by 'depelicula123';`
5. Otortgarle los privilegios necesitados al usuario sobre dicha base de datos.<br/>
  `$  grant all privileges on peliculas.* to movie@localhost;` 
6. Cambiarse a la carpeta back y ejecutar el siguiente comando para correr el servidor del back.<br/>
  `$ ./mvnw spring-boot:run`
7. Visitar la dirección localhost:3000 para revisar que la aplicación este funcionando correctamente.<br/>

### Notas

* Limite actual en la api es de 40 solicitudes cada 10 segundos y estan limitadas por dirección IP.
* Métodos importantes: search, discover, movie
