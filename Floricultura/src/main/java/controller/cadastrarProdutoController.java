package controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
/*import jakarta.servlet.annotation.WebServlet;*/
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Produto;

import java.io.IOException;

public class cadastrarProdutoController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public cadastrarProdutoController() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.getWriter().append("Served at: ").append(request.getContextPath());
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String descricao = request.getParameter("descricao");
        String mensagem;
        
        Produto produto = new Produto();
        
        if (descricao != null && !descricao.isEmpty() 
            && request.getParameter("quantidade") != null && !request.getParameter("quantidade").isEmpty() 
            && request.getParameter("preco") != null && !request.getParameter("preco").isEmpty()) {
            
            int quantidade = Integer.parseInt(request.getParameter("quantidade"));
            double preco = Double.parseDouble(request.getParameter("preco"));
            String imagem = request.getParameter("imagem");
            String detalhes = request.getParameter("detalhes");

            produto.setDescricao(descricao);
            produto.setQuantidade(quantidade);
            produto.setPreco(preco);
            produto.setDetalhe(detalhes);
            produto.setUrl_imagem(imagem);
            
            try {
                produto.salvar();
                mensagem = "Produto cadastrado com sucesso!";
            } catch (Exception e) {
                mensagem = "Erro ao cadastrar produto: " + e.getMessage();
            }
        } else {
            mensagem = "Produto não cadastrado! Preencha todos os campos obrigatórios.";
        }
        
        request.setAttribute("mensagem", mensagem);
        RequestDispatcher dispatcher = request.getRequestDispatcher("cadastrarProduto.jsp");
        dispatcher.forward(request, response);
    }
}