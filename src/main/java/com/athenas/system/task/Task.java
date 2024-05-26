package com.athenas.system.task;

import com.athenas.system.DTO.PessoaDTO;
import com.athenas.system.entity.Pessoa;
import com.athenas.system.repository.PessoaRepository;
import com.athenas.system.service.PessoaService;
import com.fasterxml.jackson.annotation.JsonMerge;
import jakarta.transaction.Transactional;
import java.text.DecimalFormat;
import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.Conditions;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Task implements PessoaService
{
	@Autowired
	private PessoaRepository repository;
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public List<PessoaDTO> obterTodasPessoas()
	{

		return repository.findAll().stream().map(p -> modelMapper.map(p, PessoaDTO.class))
			.collect(Collectors.toList());
	}

	@Override
	public PessoaDTO obterPessoa(Long id)
	{
		return modelMapper.map(repository.findById(id).get(), PessoaDTO.class);
	}

	@Transactional
	@Override
	public PessoaDTO addPessoa(PessoaDTO pessoaDTO)
	{
		Pessoa pessoa = modelMapper.map(pessoaDTO, Pessoa.class);
		repository.save(pessoa);
		return modelMapper.map(pessoa, PessoaDTO.class);
	}

	@Transactional
	@Override
	public PessoaDTO editarPessoa(Long id, @JsonMerge PessoaDTO pessoaDTO)
	{
		Pessoa pessoaBanco = repository.findById(id)
			.orElseThrow(() -> new RuntimeException("Pessoa não encontrada"));
		modelMapper.getConfiguration().setPropertyCondition(Conditions.isNotNull());
		modelMapper.map(pessoaDTO, pessoaBanco);
		pessoaBanco = repository.save(pessoaBanco);
		return modelMapper.map(pessoaBanco, PessoaDTO.class);
	}

	@Transactional
	@Override
	public void deletePessoa(Long id)
	{
		repository.deleteById(id);
	}

	@Override
	public String retornaPesoIdeal(Long id)
	{
		DecimalFormat df = new DecimalFormat("#.###");
		Pessoa pessoa = repository.findById(id)
			.orElseThrow(() -> new RuntimeException("Pessoa não encontrada"));
		if (pessoa.getSexo().equals('M')) {
			double altura = pessoa.getAltura().doubleValue();
			return "O peso ideal para " + pessoa.getNome() + " é de " + df.format((72.7 * altura) - 58) + " Kg";
		} else {
			double altura = pessoa.getAltura().doubleValue();
			return "O peso ideal para " + pessoa.getNome() + " é de " + df.format((62.1 * altura) - 44.7) + " Kg";
		}

	}
}
