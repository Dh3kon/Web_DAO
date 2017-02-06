package br.com.devmedia;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.Statement;

import br.com.devmedia.dao.DB;
import br.com.devmedia.dto.ClienteDTO;
import br.com.devmedia.dto.OsDTO;

/**
 * Servlet implementation class Clientes
 */
@WebServlet("/Clientes")
public class Clientes extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public Clientes() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		
		/*
		ClienteDTO dto = new ClienteDTO();
		dto.setCep("92500987");
		out.println(dto.getCep());
		*/
		
		
		DB db = new DB();
		try {
			Connection conn =  db.getConn();
			
			String sql = "select * from clientes";
			Statement stm = (Statement) conn.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			
			out.println("<h3>Listagem de Clientes</h3>");
			out.println("<br/>");
			while (rs.next()) {
				out.println("<hr/>");
				out.println("Código: " + rs.getInt("id"));
				out.println("<br/>");
				out.println("Nome: " + rs.getString("nome"));
				out.println("<br/>");
				out.println("Email: " + rs.getString("email"));
				out.println("<br/>");
				out.println("<hr/>");
			}
			
		} catch (ClassNotFoundException e) {
			out.println("Erro driver " + e.getMessage());
		} catch (SQLException e) {
			out.println("Erro SQL " + e.getMessage());
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
