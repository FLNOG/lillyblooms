package controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
/*import jakarta.servlet.annotation.WebServlet;*/
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Cliente;

import java.io.IOException;

public class cadastrarClienteController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public cadastrarClienteController() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.getWriter().append("Served at: ").append(request.getContextPath());
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nome = request.getParameter("nome");
        String mensagem;
        
        Cliente cliente = new Cliente();
        
        if (nome != null && !nome.isEmpty() ) {
            
        	String email = request.getParameter("email");
        	String telefone = request.getParameter("telefone");

            cliente.setNome(nome);
            cliente.setEmail(email);
            cliente.setTelefone(telefone);
            
            try {
                cliente.salvar();
                mensagem = "Cliente cadastrado com sucesso!";
            } catch (Exception e) {
                mensagem = "Erro ao cadastrar cliente: " + e.getMessage();
            }
        } else {
            mensagem = "Cliente não cadastrado! Preencha todos os campos obrigatórios.";
        }
        
        request.setAttribute("mensagem", mensagem);
        RequestDispatcher dispatcher = request.getRequestDispatcher("cadastrarCliente.jsp");
        dispatcher.forward(request, response);
    }
}