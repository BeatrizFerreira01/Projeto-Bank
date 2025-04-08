package com.example.projetoBank.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.example.projetoBank.model.Conta;

// Simula um banco de dados em memória (ArrayList)
@Repository
public class ContaRepository {
    
    private List<Conta> contas = new ArrayList<>(); // Lista que armazena as contas

    // Salva uma nova conta na lista
    public Conta save(Conta conta) {
        if (conta.getId() == null) {
            conta.setId((long) (contas.size() + 1)); // Gera ID automático
        }
        contas.add(conta);
        return conta;
    }

    // Retorna todas as contas
    public List<Conta> findAll() {
        return contas;
    }

    // Busca conta pelo ID
    public Optional<Conta> findById(Long id) {
        return contas.stream()
                     .filter(conta -> conta.getId().equals(id))
                     .findFirst();
    }

    // Busca conta pelo CPF do titular
    public Optional<Conta> findByCpfTitular(String cpf) {
        return contas.stream()
                     .filter(conta -> conta.getCpfTitular().equals(cpf))
                     .findFirst();
    }

    // Deleta uma conta pelo ID
    public boolean delete(Long id) {
        Optional<Conta> contaOptional = findById(id);
        if (contaOptional.isPresent()) {
            contas.removeIf(conta -> conta.getId().equals(id));
            return true;
        }
        return false;
    }
}
