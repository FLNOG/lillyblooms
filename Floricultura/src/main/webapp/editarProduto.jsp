<%@page import="model.Produto"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Lilly Bloom's ADM - Editar Produtos</title>
    <link rel="stylesheet" href="css/produtos.css">
    <link rel="stylesheet" href="css/tabela.css">
    <link rel="stylesheet" href="css/menu.css">
</head>
<body>
	<jsp:include page="includes/menu-adm.jsp" />
	
    <header>
        <h1>Editar Produto</h1>
    </header>
    <main>
    	<% 
			Produto produto = (Produto) request.getAttribute("produto");
			if (produto == null) {
    			out.println("Produto não encontrado.");
    		return;
			}
		%>

		<form action="EditarProduto" method="POST" class="form-prod">
    		<input type="hidden" name="id" value="<%=produto.getIdProduto()%>">
    	
    		<label><strong>Nome:</strong></label>
    		<input type="text" name="descricao" value="<%=produto.getDescricao()%>" required>
    	
    		<label><strong>Quantidade:</strong></label>
    		<input type="number" name="quantidade" value="<%=produto.getQuantidade()%>" required>
    	
    		<label><strong>Preço:</strong></label>
    		<input type="text" name="preco" value="<%=produto.getPreco()%>" required>
    		
    		<label><strong>Detalhes do produto:</strong></label>
            <input type="text" name="detalhes" value="<%=produto.getDetalhe()%>" required>
    	
    		<label><strong>Imagem:</strong></label>
    		<input type="text" name="imagem" value="<%=produto.getUrl_imagem()%>" required>
    	
    		<input type="submit" value="Salvar">
		</form>

		<form action="cadastrarProduto.jsp" method="GET" class="form-prod">
    		<input type="submit" value="Cancelar">
		</form>
	</main>
</body>
</html>