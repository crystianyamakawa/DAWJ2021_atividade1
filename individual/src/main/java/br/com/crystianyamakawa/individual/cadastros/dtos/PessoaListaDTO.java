package br.com.crystianyamakawa.individual.cadastros.dtos;

public class PessoaListaDTO {
	
	private Long id;
	private String nome;
	private String telefone;
	private String email;
	
	
	public PessoaListaDTO(Long id, String nome, String telefone, String email) {
		this.id = id;
		this.nome = nome;
		this.telefone = telefone;
		this.email = email; 
	}
}