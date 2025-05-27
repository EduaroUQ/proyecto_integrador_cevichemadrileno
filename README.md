# Ceviche Madrileño

## Descripción
El objetivo principal ha sido diseñar y construir una aplicación de gestión de espacios y actividades deportivas, en la que se diferencian claramente dos perfiles de usuarios: alumnos y monitores. Los monitores pueden crear actividades deportivas, así como inscribirse en las actividades de otros monitores, mientras que los alumnos únicamente pueden apuntarse a las actividades disponibles. Los ciclos y salas disponibles están predefinidos en la base de datos, y la aplicación permite gestionar tanto el acceso y registro de los usuarios como la inscripción a las actividades. El desarrollo ha integrado contenidos de las asignaturas de Programación, Bases de Datos y Entornos de Desarrollo. La aplicación ha sido implementada en Java, conectándose a una base de datos MySQL, y se ha utilizado el entorno de desarrollo Eclipse y metodología de trabajo Agile para la gestión del proyecto. 

## Tecnologías utilizadas

+ **Lenguaje de Programación:** Java 
    Se ha utilizado Java como lenguaje principal para la implementación de la lógica de negocio, interfaz gráfica y conexión con la base de datos.
+ **Base de Datos:**  MySQL
    Se ha usado MySQL como sistema de gestión de bases de datos relacional. Se han diseñado las tablas, claves foráneas, índices y relaciones siguiendo un modelo normalizado.
+ **IDE de Desarrollo:** Eclipse 
    Ha sido el entorno principal de programación utilizado para escribir y organizar el código Java, integrar bibliotecas, ejecutar el proyecto y gestionar los errores. Incluye herramientas para depuración, pruebas y documentación.
+ **Control de versiones y repositorio:** Git + GitHub
    Se ha utilizado Git para el control de versiones del proyecto, y GitHub como plataforma colaborativa donde se aloja el repositorio, se documenta el código y se realiza el seguimiento del avance.
+ **Gestión de tareas:** Trello
    Para la organización del trabajo y seguimiento de tareas se ha utilizado Trello, aplicando un enfoque Kanban, con tarjetas organizadas en columnas según su estado: pendiente, en proceso, finalizado.

## Requisitos previos

1. Hardware:
   + Requisitos mínimos:
        - CPU: Procesador de 2 núcleos
        - RAM: 4 GB
        - Almacenamiento: 500 MB
        - Conexión de red: 10 Mbps
        - Gráficos: Tarjeta integrada
    + Requisitos recomendados:
        - CPU: Procesador de 4 núcleos
        - RAM: 8 GB
        - Almacenamiento: 500 MB
        - Conexión de red: 100 Mbps
        - Gráficos: Tarjeta integrada
2. Software:
    + Entorno de desarrollo:
        - JDK de Java
        - clipse IDE
    + Diseño:
        - Software Ideas Modeler o draw.io
    + Bases de Datos:
        - MySQL u Oracle SQL
    + Control de versiones:
        - Git
    + Planificación y trabajo en equipo:
        - Trello
        - Microsoft Office
        - Whatsapp

## Instrucciones de instalación y ejecución

### 1. Clonar el repositorio
Abre una terminal y ejecuta:

```bash
git clone https://github.com/EduaroUQ/proyecto_integrador_cevichemadrileno.git
```

### 2. Importar el proyecto en Eclipse
   1. Abre Eclipse IDE.
   2. Ve a File > Import > Existing Projects into Workspace.
   3. Selecciona la carpeta del proyecto que clonaste o descomprimiste.
   4. Asegúrate de que el JDK esté configurado correctamente (Java 17 o compatible).

### 3. Configurar la base de datos
   1. Instala MySQL (si no lo tienes).
   2. Crea una nueva base de datos con el nombre especificado en el código (por ejemplo: deportes_uem).
   3. Ejecuta el script SQL de creación de tablas (puede estar en la carpeta /sql del repositorio).
   4. Verifica que las credenciales y el nombre de la base de datos en el archivo de conexión (Conexion.java) sean correctas

```
String url = "jdbc:mysql://localhost:3306/ceviche_madrileno";
String usuario = "root";
String contraseña = "tu_contraseña";
``` 

### 4. Compilar y ejecutar la aplicación
   1. Asegúrate de que todas las dependencias estén resueltas.
   2. Haz clic derecho sobre la clase principal (Main.java o App.java).
   3. Selecciona Run As > Java Application.

### 5. ¡Listo!
La aplicación debería iniciarse mostrando la ventana de inicio de sesión. A partir de ahí, podrás usar todas las funcionalidades según el tipo de usuario (usuario o monitor).


## Estructura del Proyecto 
```
proyecto_integrador_cevichemadrileno
│
├── 📂 src
│   ├── 📂 main
│   │   ├── 📂 java
│   │   │   └── 📦 com.ceviche_madrileno
│   │   │       ├── 📁 controlador    → Conectar el modelo con la vista.
│   │   │       ├── 📁 img            → Imágenes utilizadas por la aplicación.
│   │   │       ├── 📁 util           → Librerías adicionales utilizadas por el proyecto.
│   │   │       ├── 📁 main           → Punto de entrada principal de la aplicación.
│   │   │       ├── 📁 modelo         → La parte del programa que guarda y gestiona los datos.
│   │   │       ├── 📁 vista          → Interfaz gráfica de usuario desarrollada con Java Swing (Vista).
│   │   └── 📂 resources              → Recursos como archivos de configuración, textos, etc.
│
├── 📂 test
│   └── 📂 java                       → Pruebas unitarias del proyecto.
│
├── 📂 target                         → Archivos generados tras compilar el proyecto.
│
├── 📄 pom.xml                        → Archivo de configuración de Maven (gestión del proyecto y dependencias).
```

## Ejemplo de uso 
Una vez en Eclipse, darle al botón verde para arrancar el programa, esto debería dar la siguiente pantalla de inicio:
![Logo](https://github.com/EduaroUQ/proyecto_integrador_cevichemadrileno/blob/dev/img/Aplicaci%C3%B3n/Inicio.png?raw=true)
En caso de no tener una cuenta se puede dar en crear usuario: 
![Logo](https://github.com/EduaroUQ/proyecto_integrador_cevichemadrileno/blob/dev/img/Aplicaci%C3%B3n/Crear_Cuenta.png?raw=true)
A los tutores se les creará una cuenta y tendrán la siguiente vista principal:
![Logo](https://github.com/EduaroUQ/proyecto_integrador_cevichemadrileno/blob/dev/img/Aplicaci%C3%B3n/Mis_Actividades.png?raw=true)
Los tutores también se pueden inscribir a una actividad en la ventana de actividades:
![Logo](https://github.com/EduaroUQ/proyecto_integrador_cevichemadrileno/blob/dev/img/Aplicaci%C3%B3n/Inscribir_Actividad.png?raw=true)
También podrá crear y editar las actividades que cree:
![Logo](https://github.com/EduaroUQ/proyecto_integrador_cevichemadrileno/blob/dev/img/Aplicaci%C3%B3n/Crear_Actividad.png?raw=true)
Los usuarios solo podrán inscribirse a una actividad y darse de baja

***
#### Autores
+ Cristhian Andree Chafloque Chafloque 
+ Hugo Rubio Crespo
+ Eduardo Alexander Utrilla Quispe 
#### Tutoras del proyecto
+ Sara Villanueva Rosa
+ Irene Del Rincon Bello
#### Universidad
+ Universidad Europea de Madrid
#### Ciclo
+ Desarrollo de Aplicaciones Web
#### Curso
+ Primero