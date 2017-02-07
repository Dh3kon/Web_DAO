<%@page import="br.com.devmedia.dto.ClienteDTO"%>
<%@page import="java.util.List"%>
<%@page import="br.com.devmedia.dao.ClienteDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Listagem</title>
</head>
<body>

	<table width="100%" style="border-width: 2px; border-bottom-style: solid;">
		<tr style="font-weight: bold; background-color: silver;">
		<td>ID</td>
		<td>Nome</td>
		<td>Email</td>
		<td>CEP</td>
		<td>CPF</td>
		<td>Ações</td>
		</tr>
		<%
			ClienteDAO dao = new ClienteDAO();
			List<ClienteDTO> lista = dao.getAll();
			for (int i = 0; i < lista.size(); i++){
				ClienteDTO cliente = lista.get(i);
		%>
		<tr>
		<td><%=cliente.getId() %></td>
		<td><%=cliente.getNome() %></td>
		<td><%=cliente.getEmail() %></td>
		<td><%=cliente.getCep() %></td>
		<td><%=cliente.getCpf() %></td>
		<td><a href="editar.jsp?id=<%=cliente.getId()%>">[Editar]</a>&nbsp;<a href="apagar.jsp?id=<%=cliente.getId()%>">[Apagar]</a></td>
		</tr>
		<%
			}
		%>
	</table>
</body>
</html>