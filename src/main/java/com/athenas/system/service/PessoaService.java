package com.athenas.system.service;

import com.athenas.system.DTO.PessoaDTO;
import java.util.List;

public interface PessoaService
{

	List<PessoaDTO> obterTodasPessoas();

	PessoaDTO obterPessoa(Long id);

	PessoaDTO addPessoa(PessoaDTO pessoaDTO);

	PessoaDTO editarPessoa(Long id, PessoaDTO pessoaDTO);

	void deletePessoa(Long id);

	String retornaPesoIdeal(Long id);


}
