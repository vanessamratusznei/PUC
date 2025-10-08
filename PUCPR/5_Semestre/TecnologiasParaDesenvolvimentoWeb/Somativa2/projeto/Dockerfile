# Etapa 1: build da aplicação
FROM node:18 AS build

# Cria diretório de trabalho
WORKDIR /app

# Copia os arquivos do projeto
COPY package*.json ./
RUN npm install

COPY . .

# Gera o build otimizado
RUN npm run build

# Etapa 2: servidor NGINX para servir os arquivos
FROM nginx:alpine

# Copia o build gerado na etapa anterior para a pasta padrão do nginx
COPY --from=build /app/build /usr/share/nginx/html

# Expondo a porta padrão do nginx
EXPOSE 80

# Comando padrão
CMD ["nginx", "-g", "daemon off;"]
