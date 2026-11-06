# P2-CRUD — Java + MySQL

Projeto didático com Swing e JDBC, baseado na seção 32 das notas de Desenvolvimento para Servidores I. Adaptado para VS Code; não é reprodução literal dos códigos da apostila.

## Arquivos
- `src/Conexao.java`: conexão JDBC.
- `src/Usuario.java`: modelo e operações CRUD com PreparedStatement.
- `src/TelaLogin.java`: autenticação e acesso ao cadastro.
- `src/TelaCadastro.java`: cadastro e validação.
- `src/TelaInicio.java`: boas-vindas, consulta, alteração e exclusão.
- `src/Main.java`: ponto de entrada.
- `src/TestaConexao.java`: teste de banco.
- `src/TestaTela.java`: teste da interface.
- `sql/bd_login.sql`: script de banco.

## Preparação no Windows / VS Code
1. Extraia o ZIP para a pasta `P2-CRUD`.
2. Copie o arquivo verdadeiro `mysql-connector-j-9.6.0.jar` para `lib/`. **Não copie um `.jar.zip`**. O driver não está incluído neste pacote.
3. Abra a pasta `P2-CRUD` no VS Code com as extensões Java instaladas e JDK 21.
4. No MySQL Workbench, execute `sql/bd_login.sql` se ainda não criou a tabela `Usuario`.
5. No terminal PowerShell do VS Code, defina a senha local do MySQL para a sessão:
   `$env:MYSQL_PASSWORD = "SUA_SENHA_LOCAL"`
   Não coloque essa senha no código ou no GitHub.
6. No mesmo terminal, compile e execute:
   `javac -encoding UTF-8 -cp "lib/*" -d bin src/*.java`
   `java -cp "bin;lib/*" Main`
7. Se preferir usar Run no VS Code, garanta que o processo Java receba a variável de ambiente `MYSQL_PASSWORD`.

## Atenção à tabela existente
O código utiliza a tabela **Usuario** e colunas **Usuario, Nome, Senha**, conforme o script da aula criado anteriormente. Se você criou `tb_login` em vez de `Usuario`, use a tabela `Usuario` do script, ou adapte os comandos Java de forma consistente.

## Funcionalidades
Cadastro, validação de usuário duplicado, login, consulta de usuários, alteração de nome/senha, exclusão com confirmação e retorno ao login.

## Nota sobre senhas
A apostila utiliza MD5 para demonstrar funções SQL. MD5 **não é seguro para armazenar senhas reais**; esta implementação é apenas acadêmica. Em um sistema de produção, utilize Argon2id, bcrypt ou scrypt e políticas de segurança adequadas.
