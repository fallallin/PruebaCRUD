# Utiliza una imagen base de OpenJDK 17
FROM bellsoft/liberica-runtime-container:jdk-17-stream-musl as builder

# Establece el directorio de trabajo
WORKDIR /PruebaCRUD-main

# Copia el código fuente del proyecto
COPY . /PruebaCRUD-main

# Compila aplicación
# RUN chmod 700 mvnw && ./mvnw clean install package

# Exponer el puerto en el que se ejecutará la aplicación
EXPOSE 8080

# Comando para ejecutar la aplicación cuando se inicie el contenedor
CMD ["java", "-jar", "target/PruebaCRUD-0.0.1-SNAPSHOT.jar"]
