package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Corretor {

   private  String nome;
   private  String documento;
   private  String codigo;
   private  String dataCriacao;
   private  float taxaComissao;
   private  boolean ativo;

   public Corretor(String code, String name, String createDate, String document) {
      this.codigo = code;
      this.nome = name;
      this.dataCriacao = createDate;
      this.documento = document;
   }
}
