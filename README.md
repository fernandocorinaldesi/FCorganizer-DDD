# FCorganizer-DDD
<a href="http://www.unpaz.edu.ar"><img src="https://www.unpaz.edu.ar/sites/default/files/unpaz_0.png" title="FVCproductions" alt="UNPAZ"></a>

# Empezando con TP integrador para laboratorio de software

## Tabla de contenidos
- [Empezando](#Empezando)
  - [Requerimientos](#Requerimientos)
  - [Dependencias](#Dependencias)
  - [Diseño](#Diseño)  
  - [Despliegue](#Despliegue)
  - [Screenshot](#Screenshot)
  - [Contacto](#Contacto)
  - [Licencia](#Licencia)
 

### Empezando
La idea de este repo es que sea una primera practica en DDD, para ello se desarrollo una simple aplicacion que guarda contraseñas, con datos de usuario,password y sitio, similar al que utiliza chrome, con la capacidad de crear multiples usuarios.

Funciones disponibles :
* Operaciones crud

Detalles generales y de diseño de la App:  
* Se utilizo swing para programar la capa de presentación junto con algunas clases custom para lograr ciertos efectos como hover
* Para la base de datos se utilizo hyper-sql en modo portable, es decir esta integrada en este repositorio
* Tiene la funcionalidad de maximizarse a pantalla completa
* Tiene la funcionalidad de minimización al tray
* Se implemento un repositorio en memoria, para facilitar los tests
* Se implemento specification
* Capacidad para multiusuarios con ventana de login



### Requerimientos 

 - JavaSE  (8 o superior) instalado

### Dependencias 

 - Swingx
 - Hyper-sql

### Diseño   

Layer     | Type   | Descripcion
--------------------- | -------------------- | ---------------------  
Presentacion | Main layer | Esta capa representa la vista de la aplicacion. Contiene tambien los controladores que la manejan.
Aplicacion | Main layer | Esta capa se encarga de las tareas de fontaneria, es como un orquestar que interactua con el dominio y los repositorios.
Dominio | Main layer | Es la capa principal y el corazon de la aplicación. En esta capa residen las reglas de negocio, asi como tambien las entidades del dominio.
Infraestructura de persistencia| Main layer | Es la capa encarga de implementar la persistencia de nuestro modelo de dominio
Infraestructura transversal| Main layer | Esta capa se encarga de los aspectos transversales: authenticación, autorización, validación, logging, configuración, y de contener ciertos componentes reusables.

#### Diagramas de clases  
Algunos diagramas importantes : 

Repositorios  
![screenshoot](https://i.ibb.co/BcvSrQd/repository-spec-inmem.jpg)
Controladores de la capa de presentación  
![screenshoot](https://i.ibb.co/7QG5Szp/presentationjpg.jpg)  
Validador de la presentacion
![screenshoot](https://i.ibb.co/z6ZvqgJ/front-validator.jpg) 

### Despliegue
A continuacion se enumeraran y explicaran los pasos para desplegar la aplicacion, para esto se debe generar desde el codigo fuente un archivo.jar ejecutable

#### 1- Descargar el codigo fuente de este repositorio  
Desde la consola ejecutar el comando git clone https://github.com/fernandocorinaldesi/FCorganizer-DDD.git  
![screenshoot](https://i.ibb.co/VNPLVjy/consoleclone.jpg) 

#### 2- Importar el repositorio a eclipse  
Ejecutar eclipse  y en la pestaña file elegir import,luego en la siguiente ventana seleccionar el directorio donde fue descargado el codigo fuente y apretar finish  
![screenshoot](https://i.ibb.co/wQS59tR/paso2.jpg)


#### 3- Generar el jar ejecutable  
Posicionado en el proyecto hacer click con el boton derecho del mouse y elegir export. En la ventana siguiente seleccionar Runnable JAR file y la ruta donde sera generado
![screenshoot](https://i.ibb.co/kmczCkk/runjar.jpg)

#### 4- Ejecutar el jar  
Posicionarse sobre la ruta destino elegida y ejecutar el jar generado como cualquier archivo ejecutable  

#### 5- Login
Ahora solo hay que logearse con las siguientes credenciales usuario: admin contraseña:admin 

#### 6- Creacion de usuario
Crea un nuevo usuario con tus datos,nombre de usuario y contraseña 

#### 7- Login con tu nuevo usuario
Ahora debes logearte con el usuario y la contraseña del usuario que creaste y podras acceder al módulo para guardar contraseñas.  

### Screenshot
![screenshoot](https://i.ibb.co/rdZvCzq/fc.jpg)  

### Contacto

Puedes enviar un mail a alguna de las siguientes direcciones : 

- fcorinaldesi@unpaz.edu.ar
- fernandocorinaldesi@hotmail.com

### Licencia

[![License](http://img.shields.io/:license-mit-blue.svg?style=flat-square)](http://badges.mit-license.org)

- **[MIT license](http://opensource.org/licenses/mit-license.php)**
