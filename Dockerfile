FROM openjdk:17-jdk-alpine

# Instalar pacotes necessários para fontes e biblioteca gráfica
RUN apk update && apk add --no-cache \
    fontconfig \
    ttf-dejavu \
    freetype \
    libx11

# Diretório onde a aplicação será copiada
WORKDIR /app

# Copiar o arquivo .jar para o container
COPY target/gerador-relatorios-0.0.1-SNAPSHOT.jar /app/gerador-relatorios.jar

# Definir a variável de ambiente para o perfil ativo (opcional)
ENV SPRING_PROFILES_ACTIVE=prod

# Comando para rodar a aplicação
ENTRYPOINT ["java", "-jar", "/app/gerador-relatorios.jar"]
