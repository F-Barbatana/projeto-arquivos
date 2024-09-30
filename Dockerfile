# Usando a imagem oficial do OpenJDK 17
FROM openjdk:17-jdk-slim

# Define o diretório de trabalho no container
WORKDIR /app

# Copia o arquivo JAR gerado para o container
COPY target/files-1.jar files-1.jar

# Expõe a porta da API
EXPOSE 8080

# Comando para rodar o JAR com Java 17
ENTRYPOINT ["java", "-jar", "files-1.jar"]