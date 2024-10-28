package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Cliente;

import java.io.IOException;

import dao.ClienteDAO;

@WebServlet("/EditarCliente")
public class editarClienteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idStr = request.getParameter("id");
        if (idStr != null) {
            int id = Integer.parseInt(idStr);
            ClienteDAO clienteDAO = new ClienteDAO();
            Cliente cliente = clienteDAO.buscarPorId(id);
            request.setAttribute("cliente", cliente);
            request.getRequestDispatcher("editarCliente.jsp").forward(request, response);
        } else {
            response.sendRedirect("cadastrarCliente.jsp");
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idStr = request.getParameter("id");
        if (idStr != null) {
            int id = Integer.parseInt(idStr);
            String nome = request.getParameter("nome");
            String cpf = request.getParameter("cpf");
            String nascimento = request.getParameter("nascimento");
            String email = request.getParameter("email");
            String telefone = request.getParameter("telefone");
            String senha = request.getParameter("senha");
            
            Cliente cliente = new Cliente(id, nome, cpf, nascimento, email, telefone, senha);
            ClienteDAO clienteDAO = new ClienteDAO();
            clienteDAO.atualizarCliente(cliente);
            response.sendRedirect("cadastrarCliente.jsp");
        } else {
            response.sendRedirect("cadastrarCliente.jsp");
        }
    }
}