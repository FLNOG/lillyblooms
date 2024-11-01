<%@page import="dao.ProdutoDAO"%>
<%@page import="java.util.List"%>
<%@page import="model.Produto"%>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
    <title>Lilly Bloom's - Floricultura Online</title>
    <link rel="stylesheet" href="css/loja.css">
</head>
<body>
    
	<!-- INCLUIR MENU DE NAVEGAÇÃOO -->

    <header>
        <h1>Loja</h1>
    </header>

    <main>
        <div class="produtos-container">
            <%
            ProdutoDAO produtoDAO = new ProdutoDAO();
            List<Produto> listaProdutos = produtoDAO.listarProdutos();

            for (Produto produto : listaProdutos) {
            %>
            <div class="produto-item">
                <img src="<%=produto.getUrl_imagem()%>" alt="<%=produto.getDescricao()%>" class="produto-imagem">
                <h2><%=produto.getDescricao()%></h2>
                <p class="produto-preco">R$ <%=produto.getPreco()%></p>
                
                <form action="AdicionarAoCarrinhoController" method="POST" class="form-carrinho">
                    <input type="hidden" name="idProduto" value="<%=produto.getIdProduto()%>">
                    <input type="submit" value="Adicionar ao Carrinho" class="botao-carrinho">
                </form>

                <form action="ComprarAgoraController" method="POST" class="form-comprar">
                    <input type="hidden" name="idProduto" value="<%=produto.getIdProduto()%>">
                    <input type="submit" value="Comprar Agora" class="botao-comprar">
                </form>
            </div>
            <%
            }
            %>
        </div>
    </main>
</body>
</html>