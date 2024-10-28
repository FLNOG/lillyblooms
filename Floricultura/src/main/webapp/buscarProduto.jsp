<%@page import="dao.ProdutoDAO"%>
<%@page import="java.util.List"%>
<%@page import="model.Produto"%>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<title>Lilly Bloom's ADM - Buscar Produto</title>
	<link rel="stylesheet" href="css/produtos.css">
	<link rel="stylesheet" href="css/tabela.css">
	<link rel="stylesheet" href="css/menu.css">
</head>
<body>
    <jsp:include page="includes/menu-adm.jsp" />

    <header>
        <h1>Buscar Produto</h1>
    </header>

    <main>
        <form action="BuscarProdutoController" method="GET" class="form-prod">
            <label><strong>Buscar Produto:</strong></label>
            <input type="text" name="descricaoBusca" placeholder="Descrição do produto" required>
            <input type="submit" value="Buscar">
        </form>
        
        <table>
            <thead>
                <tr>
                    <th>ID de Produto</th>
                    <th>Descrição</th>
                    <th>Preço</th>
                    <th>Estoque</th>
                    <th>Ajustes</th>
                </tr>
            </thead>
            <tbody>
            
				<%
				@SuppressWarnings("unchecked")
				List<Produto> listaProdutos = (List<Produto>) request.getAttribute("listaProdutos");
					if (listaProdutos != null && !listaProdutos.isEmpty()) {
						for (Produto produto : listaProdutos) {
				%>
				<tr>
					<td><%=produto.getIdProduto()%></td>
					<td><%=produto.getDescricao()%></td>
					<td>R$ <%=produto.getPreco()%></td>
					<td><%=produto.getQuantidade()%> und</td>
					<td><a class="remover-editar"
						href="RemoverProduto?id=<%=produto.getIdProduto()%>"> <img src="img/trash.png" alt="Remover produto" id="img-trash"></a> 
						<a class="remover-editar" href="EditarProduto?id=<%=produto.getIdProduto()%>"> <img src="img/edit.png" alt="Editar produto" id="img-edit"></a></td>
				</tr>
				<%
					}
				} else {
				out.print("<tr><td colspan='5'>Nenhum produto encontrado.</td></tr>");
				}
				%>
			</tbody>
        </table>
    </main>
</body>
</html>
