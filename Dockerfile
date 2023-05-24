FROM maven:3.8.5-openjdk-17-slim

WORKDIR /app

# Copiar el archivo pom.xml primero para descargar las dependencias
COPY pom.xml .

# Descargar las dependencias del proyecto
RUN mvn dependency:go-offline -B

# Copiar el código fuente y los recursos de la aplicación
COPY src ./src

# Compilar la aplicación
RUN mvn package -DskipTests

# Exponer el puerto en el que se ejecuta la aplicación Spring Boot
EXPOSE 3001

# Comando para ejecutar la aplicación cuando se inicie el contenedor
CMD ["java", "-jar", "Netblend/demo.jar"]