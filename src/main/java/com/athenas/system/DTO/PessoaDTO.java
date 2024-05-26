package com.athenas.system.DTO;

import java.math.BigDecimal;
import java.time.LocalDate;
import lombok.Data;

@Data
public class PessoaDTO {
	private Long id;
	private String nome;
	private Character sexo;
	private BigDecimal altura;
	private BigDecimal peso;
	private LocalDate dataNascimento;

}