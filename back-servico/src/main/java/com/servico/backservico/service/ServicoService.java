package com.servico.backservico.service;

import com.servico.backservico.entity.Servico;
import com.servico.backservico.repository.ServicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicoService {
    @Autowired
    private ServicoRepository servicoRepository;

    public List<Servico> buscarServicosPagamentoPendente(){
        return servicoRepository.buscarServicosPagamentoPendente();
    }
    public List<Servico> buscarServicosCancelados(){
        return servicoRepository.buscarServicosCancelados();
    }
    public List<Servico> buscarTodos(){
        return servicoRepository.findAll();
    }

    public Servico inserir(Servico servico){
        if(servico.getValorPago()==null || servico.getValorPago()==0 || servico.getDataPagamento()==null){
            servico.setStatus("pendente");
        }else {
            Servico servicoBanco = servicoRepository.saveAndFlush(servico);
            return servicoBanco;
        }
        return servicoRepository.saveAndFlush(servico);
        //The code bellow do the same in a different approach
        //Servico servicoBanco = servicoRepository.save(servico);
        //return servicoBanco;
    }

    public Servico alterar(Servico servico){
        if(servico.getValorPago()!=null && servico.getValorPago()>0 && servico.getDataPagamento()!=null){
            servico.setStatus("realizado");
        }
        return servicoRepository.saveAndFlush(servico);
    }

    public void excluir(Long id){
        Servico servico = servicoRepository.findById(id).get();
        servicoRepository.delete(servico);
    }
}
