package controller;

import dao.ProdutoDAO;
import model.Produto;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/BuscarProdutoController")
public class buscarProdutoController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String descricaoBusca = request.getParameter("descricaoBusca");
        ProdutoDAO produtoDAO = new ProdutoDAO();
        
        List<Produto> listaProdutos = produtoDAO.buscarPorDescricao(descricaoBusca);
        
        request.setAttribute("listaProdutos", listaProdutos);
        request.getRequestDispatcher("buscarProduto.jsp").forward(request, response);
    }
}