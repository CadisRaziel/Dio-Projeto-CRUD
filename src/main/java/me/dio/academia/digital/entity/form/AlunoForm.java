package me.dio.academia.digital.entity.form;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Singular;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AlunoForm {

  @NotBlank(message = "Preencha o campo corretamente.") //-> se o campo estiver em branco e o usuario tenta salvar vai aparecer essa msg
  //@NotBlank -> só pode ser usada com String
  @Size(min = 3, max = 50, message = "'${validatedValue}' precisa estar entre {min} e {max} caracteres")
  //'${validatedValue}' -> vai representar o valor que o usuario passar, exemplo> 'abc', 'a'
  //@Size -> o campo precisa ter no minimo 3 caractere e no maximo 50 caractere, caso nao tiver vai aparesenta uma msg
  private String nome;

  @NotBlank(message = "Preencha o campo corretamente.") //-> se o campo estiver em branco e o usuario tenta salvar vai aparecer essa msg
  //@NotBlank -> só pode ser usada com String
  @CPF(message = "'${validatedValue}' é invalido") //-> valida o cpf(cpf 111.111.111-11, ele nao vai aceitar)
  private String cpf;

  @NotBlank(message = "Preencha o campo corretamente.") //-> se o campo estiver em branco e o usuario tenta salvar vai aparecer essa msg
  //@NotBlank -> só pode ser usada com String
  @Size(min = 3, max = 50, message = "'${validatedValue}' precisa estar entre {min} e {max} caracteres")
  //@Size -> o campo precisa ter no minimo 3 caractere e no maximo 50 caractere, caso nao tiver vai aparesenta uma msg
  private String bairro;

  @NotBlank(message = "Preencha o campo corretamente.") //-> se o campo estiver em branco e o usuario tenta salvar vai aparecer essa msg
  //@NotBlank -> só pode ser usada com String
  @Past(message = "Data ${validatedValue} é invalido") //-> data de nascimento tem que ser no passado, ou seja nao pode ser 2024, 2023 mes a frente do que estamos
  private LocalDate dataDeNascimento;

}
