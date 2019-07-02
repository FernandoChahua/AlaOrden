## A La Orden
Link Trello : https://trello.com/b/FucLH0cG/trabajofinal

### Spring Applicaction
#### Requisitos:
 - Java 1.8 SDK
 - MySQL
#### Instalación:
1. Crear una base de datos "tfinal" en MySQL
2. Iniciar la Aplición
	> cd backend
	> gradlew bootrun
3. Usar el script dentro de "docs/scripts/" para llenar la base de datos

### Api Franquicias
Para su funcionamiento, la aplicacion requier otro servidor REST API, que simula otros servidores, de los cuales se obtendrán los precios correspondiente a cada franquicia
#### Requisitos:
 - .NET Core 2.2
 - Sql Server
#### Instalación:
1. Descomprimir *"ApiInventory.zip"*
2. Crear una base de datos con el nombre "pruebaApi" en SQL o configurar *"appsettings.json"* en la carpeta *"Api2\ApiFranquicia.Api\\"* del archivo comprimido
3. Restaurar dependencias (desde la raiz del archivo descomprimido)
	>cd Api2
	>dotnet restore
5. Aplicar las migraciones de EntityFramework a la base de datos
	> cd ApiFranquicia.Repository
	> dotnet ef --startup-project ../ApiFranquicia.Api database update
6. Iniciar la aplicación
	> cd ../ApiFranquicia.Api
	> dotnet build
	> dotnet run
7. Restaurar base de datos usando el script *"Query_Insercion_Datos_FranquiciaApi.sql"* en la raíz del archivo comprimido
### React App
#### Requisitos:
 - Node.js
#### Instalación:

1. Restaurar dependecias de la aplicación (desde la raíz del repositorio)
	> cd frontend
	> npm install
2. Iniciar la aplicación
	> npm start
3 Ingresar a la página web en http://localhost:3000
