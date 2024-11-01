<%@page import="dao.ClienteDAO"%>
<%@page import="java.util.List"%>
<%@page import="model.Cliente"%>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Lilly Bloom's ADM - Clientes</title>
	<link rel="stylesheet" href="css/produtos.css">
	<link rel="stylesheet" href="css/tabela.css">
	<link rel="stylesheet" href="css/menu.css">
</head>
<body>
    <jsp:include page="includes/menu-adm.jsp" />
	<header>
    	<h1>Cadastrar Cliente</h1>
    </header>

    	<% String mensagem = (String) request.getAttribute("mensagem"); %>
    	<% if (mensagem != null) { %>
        	<p><%= mensagem %></p>
    	<% } %>

	<main>
    	<form action="cadastrarClienteController" method="POST" class="form-prod">
        	<label><strong>Nome:</strong></label>
        	<input type="text" name="nome" required><br>

        	<label><strong>Email:</strong></label>
        	<input type="email" name="email" required><br>

        	<label><strong>Telefone:</strong></label>
        	<input type="text" name="telefone" required><br>
        	
        	<label><strong>Data de Nascimento:</strong></label>
        	<input type="date" name="nascimento" required><br>

        	<input type="submit" name="salvar" value="Cadastrar Cliente">
    	</form>
    	<form action="buscarCliente.jsp" method="GET" class="form-prod">
    		<input type="submit" value="Buscar Clientes">
		</form>
        <table>
            <thead>
                <tr>
                    <th>ID de Cliente</th>
                    <th>Nome</th>
                    <th>E-mail</th>
                    <th>Contato</th>
                    <th>Ajustes</th>
                </tr>
            </thead>
        
            <tbody>
                <%
                ClienteDAO clienteDAO = new ClienteDAO();
                List<Cliente> listaClientes = clienteDAO.listarClientes();
                for (Cliente cliente : listaClientes) {
                %>
                <tr>
                    <td><%=cliente.getIdCliente()%></td>
                    <td><%=cliente.getNome()%></td>
                    <td><%=cliente.getEmail()%></td>
                    <td><%=cliente.getTelefone()%></td>
                    <td>
                    	<a class="remover-editar" href="Endereco?id=<%=cliente.getIdCliente()%>">
                            <img src="img/address.png" alt="Endereços" id="img-trash"></a>
                    
                        <a class="remover-editar" href="RemoverCliente?id=<%=cliente.getIdCliente()%>">
                            <img src="img/trash.png" alt="Remover Cliente" id="img-trash"></a>
                            
                        <a class="remover-editar" href="EditarCliente?id=<%=cliente.getIdCliente()%>">
                            <img src="img/edit.png" alt="Editar Cliente" id="img-edit"></a>
                    </td>
                </tr>
                <%
                }
                %>
            </tbody>
        </table>
    </main>
</body>
</html>