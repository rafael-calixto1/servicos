package com.servico.backservico.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

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
    private String descricaoServico;
    private Double valorServico;

    private Double valorPago;
    @Temporal(TemporalType.DATE)
    private Date dataPagamento;
    private String status;
}
