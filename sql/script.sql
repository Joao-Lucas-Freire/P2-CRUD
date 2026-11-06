#Criando o banco de dados
Create DataBase bd_login;

#Selecionando o banco de dados
Use bd_login;

#Criando a tabela de usuario
Create Table Usuario (
    Usuario VarChar(10) Primary Key,
    Nome VarChar(30) Default '',
    Senha Char(32) Default ''
);
