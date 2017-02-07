package br.com.devmedia.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.devmedia.dto.ClienteDTO;

public class ClienteDAO {

	private static final String tbl_name = "clientes";
	private static final String SQL_INSERT = "insert into " + tbl_name + " (nome, email, cep, cpf) values (?,?,?,?);";
	private static final String SQL_UPDATE = "update " + tbl_name + " set nome = ?, email = ?, cep = ?, cpf = ? where id = ?;";
	private static final String SQL_DELETE = "delete from " + tbl_name + " where id = ?;";
	private static final String SQL_SELECT = "select * from " + tbl_name;
	private static final String sql_by_id = "select * from " + tbl_name + " where id = ?;";
	private Connection conn = null;

	public ClienteDAO() throws ClassNotFoundException, SQLException {
		DB db = new DB();
		conn = db.getConn();
	}

	public boolean insert(ClienteDTO dto) throws SQLException {

		PreparedStatement pstm = conn.prepareStatement(SQL_INSERT);
		pstm.setString(1, dto.getNome());
		pstm.setString(2, dto.getEmail());
		pstm.setString(3, dto.getCep());
		pstm.setString(4, dto.getCpf());
		return (pstm.executeUpdate() > 0);
	}

	public boolean update(ClienteDTO dto) throws SQLException {
		
		PreparedStatement pstm = conn.prepareStatement(SQL_UPDATE);
		pstm.setInt(1, dto.getId());
		pstm.setString(2, dto.getNome());
		pstm.setString(3, dto.getEmail());
		pstm.setString(4, dto.getCep());
		pstm.setString(5, dto.getCpf());
		return (pstm.executeUpdate() > 0);
	}

	public boolean delete(ClienteDTO dto) throws SQLException {
		
		PreparedStatement pstm = conn.prepareStatement(SQL_DELETE);
		pstm.setInt(1, dto.getId());
		return (pstm.executeUpdate() > 0);
	}

	public List<ClienteDTO> getAll() throws SQLException {
		List<ClienteDTO> lista = new ArrayList<>();
		Statement stm = conn.createStatement();
		ResultSet rs = stm.executeQuery(SQL_SELECT);
		while (rs.next()) {
			ClienteDTO dto = new ClienteDTO(rs.getInt("id"), rs.getString("nome"), rs.getString("email"),
					rs.getString("cep"), rs.getString("cpf"));
			lista.add(dto);
		}
		return lista;
	}

	public ClienteDTO getById(int id) throws SQLException {
		ClienteDTO dto = null;
		PreparedStatement pstm = conn.prepareStatement(sql_by_id);
		pstm.setInt(1, id);
		ResultSet rs = pstm.executeQuery();
		if (rs.first()) {
			dto = new ClienteDTO(rs.getInt("id"), rs.getString("nome"), rs.getString("email"), rs.getString("cep"),
					rs.getString("cpf"));
		}
		return dto;
	}
}
