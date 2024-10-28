package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Produto;

import java.io.IOException;

import dao.ProdutoDAO;

@WebServlet("/EditarProduto")
public class editarProdutoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idStr = request.getParameter("id");
        if (idStr != null) {
            int id = Integer.parseInt(idStr);
            ProdutoDAO produtoDAO = new ProdutoDAO();
            Produto produto = produtoDAO.buscarPorId(id);
            request.setAttribute("produto", produto);
            request.getRequestDispatcher("editarProduto.jsp").forward(request, response);
        } else {
            response.sendRedirect("cadastrarProduto.jsp");
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idStr = request.getParameter("id");
        if (idStr != null) {
            int id = Integer.parseInt(idStr);
            String descricao = request.getParameter("descricao");
            int quantidade = Integer.parseInt(request.getParameter("quantidade"));
            double preco = Double.parseDouble(request.getParameter("preco"));
            String detalhe = request.getParameter("detalhes");
            String imagem = request.getParameter("imagem");

            Produto produto = new Produto(id, descricao, quantidade, preco, detalhe, imagem);
            ProdutoDAO produtoDAO = new ProdutoDAO();
            produtoDAO.atualizarProduto(produto);
            response.sendRedirect("cadastrarProduto.jsp");
        } else {
            response.sendRedirect("cadastrarProduto.jsp");
        }
    }
}