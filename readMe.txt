Tecnologias Utilizadas
Backend:

Java 17
Spring Boot
Hibernate
MySQL (ou outra base de dados de sua escolha)
Frontend:

React
Axios (para chamadas API)
CSS (ou outra biblioteca de estilos, se aplicável)
Funcionalidades
Criação de diretórios
Listagem de diretórios e arquivos
Consulta de detalhes de arquivos e diretórios
Exclusão de arquivos e diretórios
Instalação
Pré-requisitos
Antes de começar, você precisará ter o seguinte instalado:

Java JDK 17
Maven (para o backend)
Node.js e npm (para o frontend)
MySQL ou outra base de dados


Clonando o Repositório


git clone https://github.com/seu-usuario/seu-repositorio.git
cd seu-repositorio
Configurando o Backend
Navegue até a pasta do backend.



cd backend
Instale as dependências do Maven.



mvn install
Configure as credenciais do banco de dados no arquivo application.properties.



Execute a aplicação.

mvn spring-boot:run
Configurando o Frontend


Navegue até a pasta do frontend.

cd frontend


Instale as dependências do npm.

npm install


Execute a aplicação.

npm start
Uso
Após iniciar tanto o backend quanto o frontend, você pode acessar a aplicação no navegador em http://localhost:3000.

API
Endpoints Principais
POST /directory: Cria um novo diretório.
GET /directory/{id}: Obtém detalhes de um diretório específico.
GET /directory: Lista todos os diretórios.
DELETE /directory/{id}: Exclui um diretório específico.
Exemplos de Requisições


Criar um Diretório


curl -X POST http://localhost:8080/directory -H "Content-Type: application/json" -d '{"name": "Novo Diretório"}'


Listar Diretórios

curl -X GET http://localhost:8080/directory