package com.athenas.system.controller;

import com.athenas.system.DTO.PessoaDTO;
import com.athenas.system.service.PessoaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/system")
public class PessoaController {
	@Autowired
	private PessoaService pessoaService;

	@GetMapping(value = "/listar-pessoas")
	public List<PessoaDTO> obterTodasPessoas()
	{
		return pessoaService.obterTodasPessoas();
	}
	@GetMapping(value = "/listar-pessoa/{id}")
	public PessoaDTO obterPessoa(@PathVariable Long id){
		return pessoaService.obterPessoa(id);
	}

	@PostMapping(value = "/adicionar-pessoa")
	public PessoaDTO adicionarPessoa(@RequestBody PessoaDTO pessoaDTO)
	{
		return pessoaService.addPessoa(pessoaDTO);
	}


	@PatchMapping(value = "/atualizar-pessoa/{id}")
	public PessoaDTO editarPessoa(@PathVariable Long id, @RequestBody PessoaDTO pessoaDTO)
	{
		return pessoaService.editarPessoa(id, pessoaDTO);
	}

	@DeleteMapping(value = "/remover-pessoa/{id}")
	public void removerPessoa(@PathVariable Long id)
	{
		pessoaService.deletePessoa(id);
	}

	@GetMapping(value = "/peso-ideal/{id}")
	public String retornaPesoIdeal(@PathVariable Long id)
	{
		return pessoaService.retornaPesoIdeal(id);
	}

}
