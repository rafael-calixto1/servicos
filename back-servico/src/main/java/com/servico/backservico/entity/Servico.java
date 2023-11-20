package com.servico.backservico.entity;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;


import javax.persistence.*;

import java.util.Date;

@Entity
@Table(name = "servico")
@Data
public class Servico {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Temporal(TemporalType.DATE)
    private Date dataInicio = new Date();

    @Temporal(TemporalType.DATE)
    private Date dataTermino = new Date();

    @NotBlank(message = "Descrição do serviço é obrigatória")
    private String descricaoServico;

    @NotNull(message = "Valor do serviço é obrigatório")
    @Positive(message = "Valor do serviço deve ser positivo")
    private Double valorServico;

    private Double valorPago;

    @Temporal(TemporalType.DATE)
    private Date dataPagamento;

    private String status;
}