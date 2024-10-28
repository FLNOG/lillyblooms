<%@page import="model.Cliente"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Lilly Bloom's ADM - Editar Clientes</title>
    <link rel="stylesheet" href="css/produtos.css">
    <link rel="stylesheet" href="css/tabela.css">
    <link rel="stylesheet" href="css/menu.css">
</head>
<body>
	<jsp:include page="includes/menu-adm.jsp" />
	
    <header>
        <h1>Editar Cliente</h1>
    </header>
    <main>
    	<% 
    		Cliente cliente = (Cliente) request.getAttribute("cliente");
			if (cliente == null) {
    			out.println("Cliente não encontrado.");
    		return;
			}
		%>

		<form action="EditarCliente" method="POST" class="form-prod">
    		<input type="hidden" name="id" value="<%=cliente.getIdCliente()%>">
    	
    		<label><strong>Nome:</strong></label>
    		<input type="text" name="nome" value="<%=cliente.getNome()%>" required>
    	
    		<label><strong>CPF / CPNJ:</strong></label>
    		<input type="text" name="cpf" value="<%=cliente.getCpf()%>" required>
    	
    		<label><strong>Nascimento:</strong></label>
    		<input type="text" name="nascimento" value="<%=cliente.getNascimento()%>" required>
    		
    		<label><strong>Email:</strong></label>
            <input type="text" name="email" value="<%=cliente.getEmail()%>" required>
    	
    		<label><strong>Senha:</strong></label>
    		<input type="text" name="senha" value="<%=cliente.getSenha()%>" required>
    		
    		<label><strong>Contato:</strong></label>
    		<input type="text" name="telefone" value="<%=cliente.getTelefone()%>" required>
    	
    		<input type="submit" value="Salvar">
		</form>
		<form action="cadastrarCliente.jsp" method="GET" class="form-prod">
    		<input type="submit" value="Cancelar">
		</form>
	</main>
</body>
</html>