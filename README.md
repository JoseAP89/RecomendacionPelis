# Sistema de Búsqueda y Recomendación de Películas
## Objetivo del proyecto

Diseñar y desarrollar un sistema de recomendación de películas utilizando el conjunto de
API REST que ofrece la “Open Movie Database” en la siguiente liga:

http://www.omdbapi.com/

## Especificación de requerimientos funcionales

a) Para que un usuario pueda hacer uso del sistema de recomendaciones debe
registrarse y proporcionar los datos sobre sus gustos y preferencias acerca del
género de películas que prefiere, actores y directores. También deberá registrar
una lista de las películas que ha visto y que más le gustaron.
b) El usuario registrado y verificado podrá realizar búsquedas de películas por:
nombre, actor, género o palabras claves.
c) Una vez que el usuario se ha registrado, podrá ejecutar el sistema de
recomendación, el cual le ofrecerá una lista de películas recomendados de
acuerdo a sus preferencias registradas.
Especificación técnica

Como requisitos para la evaluación del curso será necesario cumplir con los siguientes
requerimientos de implementación.

1. Los servicios Web deberán construirse con la plataforma de desarrollo de NetBeans y
el soporte que ofrece a través de JAX-RS Web Services.
2. Para implementar la base de datos de usuarios, se utilizará el manejador de bases de
datos MARIA DB en su versión más reciente. El diseño de la base de datos para el
registro de usuarios deberá considerar los siguientes datos:

a) Usuario y contraseña para ingresar
b) Nombre completo del usuario
c) Edad y género
d) Correo electrónico
e) Género de películas
f) Actores y directores favoritos
g) Listado de los películas favoritas

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
