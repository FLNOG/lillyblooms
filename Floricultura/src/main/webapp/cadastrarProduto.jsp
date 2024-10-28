<%@page import="dao.ProdutoDAO"%>
<%@page import="java.util.List"%>
<%@page import="model.Produto"%>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Lilly Bloom's ADM - Produtos</title>
	<link rel="stylesheet" href="css/produtos.css">
	<link rel="stylesheet" href="css/tabela.css">
	<link rel="stylesheet" href="css/menu.css">
</head>
<body>
    <jsp:include page="includes/menu-adm.jsp" />

    <header>
        <h1>Produtos</h1>
    </header>

    <% 
      String mensagem = (String) request.getAttribute("mensagem");
      if (mensagem != null) {
          out.print("<div class='alert'>" + mensagem + "</div>"); 
      }
    %>
    
    <main>
        <form action="cadastrarProdutoController" method="POST" class="form-prod">
            <label><strong>Nome:</strong></label>
            <input type="text" name="descricao" required>
            
            <label><strong>Quantidade:</strong></label>
            <input type="number" name="quantidade" required>
            
            <label><strong>Preço:</strong></label>
            <input type="text" step="0.01" name="preco" required>
            
            <label><strong>Detalhes do produto:</strong></label>
            <input type="text" name="detalhes" required>
            
            <label><strong>Url da imagem:</strong></label>
            <input type="text" name="imagem" required>
                
            <input type="submit" name="salvar" value="Cadastrar Produto">
        </form>
        <form action="buscarProduto.jsp" method="GET" class="form-prod">
    		<input type="submit" value="Buscar Produtos">
		</form>
        <table>
            <thead>
                <tr>
                    <th>ID de Produto</th>
                    <th>Nome</th>
                    <th>Preço</th>
                    <th>Estoque</th>
                    <th>Ajustes</th>
                </tr>
            </thead>
        
            <tbody>
                <%
                ProdutoDAO produtoDAO = new ProdutoDAO();
                List<Produto> listaProdutos = produtoDAO.listarProdutos();
                for (Produto produto : listaProdutos) {
                %>
                <tr>
                    <td><%=produto.getIdProduto()%></td>
                    <td><%=produto.getDescricao()%></td>
                    <td><%=produto.getPreco()%></td>
                    <td><%=produto.getQuantidade()%></td>
                    <td>
                        <a class="remover-editar" href="RemoverProduto?id=<%=produto.getIdProduto()%>">
                            <img src="img/trash.png" alt="Remover produto" id="img-trash"></a>
                            
                        <a class="remover-editar" href="EditarProduto?id=<%=produto.getIdProduto()%>">
                            <img src="img/edit.png" alt="Editar produto" id="img-edit"></a>
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