<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>
	<main>

		<form action="CadastroCliente" method="POST">
			<label for="nome">Nome Completo</label> 
			<input type="text" id="nome" name="nome" placeholder="Digite seu nome completo ..." required>

			<label for="email">Email</label> 
			<input type="email" id="email" name="email" placeholder="Digite seu e-mail ..." required> 
			
			<label for="senha">Senha</label> 
			<input type="password" id="senha" name="senha" placeholder="********" required> 
			
			<label for="telefone">Telefone</label>
			<input type="text" id="telefone" name="telefone" placeholder="(11) xxxxx-xxxx" required>

			<button type="submit">Cadastrar</button>
		</form>

	</main>
</body>
</html>