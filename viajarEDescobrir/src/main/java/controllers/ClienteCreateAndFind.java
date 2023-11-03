package controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import clienteDAO.ClienteDao;
import modelo.Cliente;

@WebServlet("/CreateAndFind")
public class ClienteCreateAndFind extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public ClienteCreateAndFind() {
        super();
      
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pesquisa = request.getParameter("pesquisa");
		
		if(pesquisa == null) {
		   pesquisa="";
		}
		
		List<Cliente> clientes = ClienteDao.find(pesquisa); 
		
		request.setAttribute("clientes", clientes);
		RequestDispatcher requesDispatcher = request.getRequestDispatcher("lista.jsp");
		requesDispatcher.forward(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Cliente cliente = new Cliente();
		
		cliente.setNome(request.getParameter("nome"));
		cliente.setCpf(request.getParameter("cpf"));
		cliente.setEndereco(request.getParameter("endereco"));
		cliente.setTelefone(request.getParameter("telefone"));
		cliente.setEmail(request.getParameter("email"));
		
		ClienteDao.create(cliente);
		
		doGet(request, response);
	}

}
