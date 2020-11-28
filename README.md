# FCorganizer-DDD
<a href="http://www.unpaz.edu.ar"><img src="https://www.unpaz.edu.ar/sites/default/files/unpaz_0.png" title="FVCproductions" alt="UNPAZ"></a>

# Empezando con Primera practica en DDD para laboratorio de software

## Tabla de contenidos
- [Empezando](#Empezando)
  - [Requerimientos](#Requerimientos)
  - [Dependencias](#Dependencias)
  - [Diseño](#Diseño)  
  - [Screenshot](#Screenshot)
  - [Despliegue](#Despliegue)
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
Presentacion | en construccion | en construccion
Aplicacion | en construccion | en construccion
Dominio | en construccion | en construccion  
Infraestructura | en construccion | en construccion  

Diagramas de clases  

![screenshoot](https://i.ibb.co/BcvSrQd/repository-spec-inmem.jpg)
![screenshoot](https://i.ibb.co/7QG5Szp/presentationjpg.jpg)
![screenshoot](https://i.ibb.co/Gsc9Sbk/Transversal-validator.jpg) 

### Screenshot
![screenshoot](https://i.ibb.co/rdZvCzq/fc.jpg)  

### Despliegue

### Contacto

Puedes enviar un mail a alguna de las siguientes direcciones : 

- fcorinaldesi@unpaz.edu.ar
- fernandocorinaldesi@hotmail.com

### Licencia

[![License](http://img.shields.io/:license-mit-blue.svg?style=flat-square)](http://badges.mit-license.org)

- **[MIT license](http://opensource.org/licenses/mit-license.php)**
