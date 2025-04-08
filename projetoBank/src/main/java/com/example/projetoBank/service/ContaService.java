package com.example.projetoBank.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.projetoBank.model.Conta;
import com.example.projetoBank.repository.ContaRepository;

@Service
public class ContaService {

    @Autowired
    private ContaRepository contaRepository; // Injeta o repositório

    public Conta cadastrarConta(Conta conta) {
        try {
            // Verifica se a data é válida
            if (conta.getDataAbertura() == null || conta.getDataAbertura().isAfter(LocalDate.now())) {
                throw new IllegalArgumentException("A data de abertura não pode ser no futuro.");
            }
            // Deixa a conta ativa
            conta.setAtiva(true);
            return contaRepository.save(conta); // Salva a conta
        } catch (Exception e) {
            return null;
        }
    }

    public List<Conta> listarContas() {
        return contaRepository.findAll(); // Retorna todas as contas
    }

    public Optional<Conta> buscarPorId(Long id) {
        return contaRepository.findById(id); // Busca por ID
    }

    public Optional<Conta> buscarPorCpf(String cpf) {
        return contaRepository.findByCpfTitular(cpf); // Busca por CPF
    }

    public boolean encerrarConta(Long id) {
        Optional<Conta> conta = contaRepository.findById(id);
        if (conta.isPresent()) {
            Conta c = conta.get();
            if (!c.isAtiva()) {
                return false; // Já está inativa
            }
            c.setAtiva(false);
            contaRepository.save(c);
            return true; // Sucesso
        }
        return false;
    }

    public Conta realizarDeposito(Long id, double valor) {
        Optional<Conta> conta = contaRepository.findById(id);
        if (conta.isPresent()) {
            Conta c = conta.get();
            if (!c.isAtiva()) {
                return null; // Conta inativa
            }
            if (valor > 0) {
                c.setSaldo(c.getSaldo() + valor);
                return contaRepository.save(c); // Depósito realizado
            }
        }
        return null;
    }
}
