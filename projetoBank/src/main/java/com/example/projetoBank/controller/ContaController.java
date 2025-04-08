package com.example.projetoBank.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.projetoBank.model.Conta;
import com.example.projetoBank.service.ContaService;

@RestController
@RequestMapping("/contas") // Define a rota principal da API
public class ContaController {

    @Autowired
    private ContaService contaService; // Injeta a classe de serviço

    @GetMapping("/")
    public String infoProjeto() {
        return "Projeto Bank - Criado por Beatriz Ferreira Cruz";
    }

    @PostMapping
    public ResponseEntity<?> criarConta(@RequestBody @Valid Conta conta) {
        try {
            // Cadastra nova conta
            Conta novaConta = contaService.cadastrarConta(conta);

            if (novaConta != null) {
                return ResponseEntity.ok(novaConta); // Sucesso
            } else {
                return ResponseEntity.status(400).body("Erro: Não foi possível criar a conta. Verifique os dados fornecidos.");
            }
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(400).body(e.getMessage()); // Dados inválidos
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Erro inesperado ao criar conta."); // Erro interno
        }
    }

    @GetMapping
    public ResponseEntity<List<Conta>> listarContas() {
        // Lista todas as contas
        List<Conta> contas = contaService.listarContas();
        return ResponseEntity.ok(contas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscarContaPorId(@PathVariable Long id) {
        try {
            // Busca conta pelo ID
            Optional<Conta> conta = contaService.buscarPorId(id);
            if (conta.isPresent()) {
                Conta c = conta.get();
                if (!c.isAtiva()) {
                    return ResponseEntity.status(400).body("Erro: A conta está inativa.");
                }
                return ResponseEntity.ok(c);
            } else {
                return ResponseEntity.status(404).body("Erro: Conta não encontrada.");
            }
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Erro interno ao buscar conta.");
        }
    }

    @GetMapping("/cpf/{cpf}")
    public ResponseEntity<?> buscarContaPorCpf(@PathVariable String cpf) {
        // Busca conta pelo CPF
        Optional<Conta> conta = contaService.buscarPorCpf(cpf);
    
        if (conta.isPresent()) {
            return ResponseEntity.ok(conta.get());
        } else {
            return ResponseEntity.status(404).body("Conta com CPF " + cpf + " não encontrada.");
        }
    }

    @PostMapping("/{id}/deposito")
    public ResponseEntity<?> realizarDeposito(@PathVariable Long id, @RequestParam double valor) {
        try {
            // Realiza um depósito
            Conta conta = contaService.realizarDeposito(id, valor);
            if (conta != null) {
                return ResponseEntity.ok(conta);
            } else {
                return ResponseEntity.status(400).body("Depósito inválido ou conta não encontrada.");
            }
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Erro interno ao realizar depósito.");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> encerrarConta(@PathVariable Long id) {
        try {
            // Encerra uma conta
            boolean encerrada = contaService.encerrarConta(id);
            if (encerrada) {
                return ResponseEntity.ok("Conta com ID " + id + " foi encerrada com sucesso.");
            } else {
                return ResponseEntity.status(400).body("Erro: Conta com ID " + id + " já está inativa ou não existe.");
            }
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Erro interno ao encerrar conta.");
        }
    }
}
