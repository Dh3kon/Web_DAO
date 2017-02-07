package br.com.devmedia.dao;

import java.util.List;

import br.com.devmedia.dto.ClienteDTO;

public class ClienteDAO {

	public String insert(ClienteDTO dto) {
		
		return "Nome = " + dto.getNome() + " - " + dto.getEmail();
	}
	
	public boolean update(ClienteDTO dto) {
		return false;
	}
	
	public boolean delete(ClienteDTO dto) {
		return false;
	}
	
	public List<ClienteDTO> get(){
		return null;
	}
}
