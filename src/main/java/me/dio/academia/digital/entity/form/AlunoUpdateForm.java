package me.dio.academia.digital.entity.form;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AlunoUpdateForm {

  @NotBlank(message = "Preencha o campo corretamente.") //-> se o campo estiver em branco e o usuario tenta salvar vai aparecer essa msg
  //@NotBlank -> só pode ser usada com String
  @Size(min = 3, max = 50, message = "${validatedValue} precisa estar entre {min} e {max} caracteres")
  private String nome;

  @NotBlank(message = "Preencha o campo corretamente.") //-> se o campo estiver em branco e o usuario tenta salvar vai aparecer essa msg
  //@NotBlank -> só pode ser usada com String
  @Size(min = 3, max = 50, message = "${validatedValue} precisa estar entre {min} e {max} caracteres")
  //@Size -> o campo precisa ter no minimo 3 caractere e no maximo 50 caractere, caso nao tiver vai aparesenta uma msg
  private String bairro;


  @NotBlank(message = "Preencha o campo corretamente.") //-> se o campo estiver em branco e o usuario tenta salvar vai aparecer essa msg
  //@NotBlank -> só pode ser usada com String
  @Past(message = "Data ${validatedValue} é invalido") //-> data de nascimento tem que ser no passado, ou seja nao pode ser 2024, 2023 mes a frente do que estamos
  private LocalDate dataDeNascimento;
}
