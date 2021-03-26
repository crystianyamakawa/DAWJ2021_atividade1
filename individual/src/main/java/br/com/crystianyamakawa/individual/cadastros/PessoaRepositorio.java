package br.com.crystianyamakawa.individual.cadastros;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.crystianyamakawa.individual.cadastros.dtos.PessoaListaDTO;



@Repository
public interface PessoaRepositorio extends JpaRepository<Pessoa, Long>{
//	@Query("select new br.com.crystianyamakawa.individual.cadastros.dtos.PessoaListaDTO(p.id, p.nome, p.telefone, p.email)"
//			+ " from Pessoa ")
//	List<PessoaListaDTO> findAllPessoaLista();

//	@Query("select p from Pessoa where p.id = :id")
//	Optional<Pessoa> findCompletoById(@Param("id") Long id);	

}
