package com.example.projetoBank.model;

import java.time.LocalDate;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

// Modelo que representa uma conta bancária
public class Conta {
    
    private Long id; // ID único da conta

    @NotNull(message = "Número da conta é obrigatório")
    private String numero; // Número da conta

    @NotNull(message = "Agência é obrigatória")
    private String agencia; // Agência da conta

    @NotNull(message = "Nome do titular é obrigatório")
    private String nomeTitular; // Nome do titular da conta

    @NotNull(message = "CPF do titular é obrigatório")
    private String cpfTitular; // CPF do titular da conta

    @NotNull(message = "Data de abertura não pode ser no futuro")
    private LocalDate dataAbertura; // Data de abertura da conta

    @Positive(message = "Saldo inicial não pode ser negativo")
    private double saldo; // Saldo da conta

    private boolean ativa; // Estado da conta (ativa ou não)

    @NotNull(message = "Tipo da conta é obrigatório")
    private String tipo; // Tipo da conta (corrente, poupança, salário)

    // Construtor padrão
    public Conta() {}

    // Construtor completo
    public Conta(Long id, String numero, String agencia, String nomeTitular, String cpfTitular,
                 LocalDate dataAbertura, double saldo, boolean ativa, String tipo) {
        this.id = id;
        this.numero = numero;
        this.agencia = agencia;
        this.nomeTitular = nomeTitular;
        this.cpfTitular = cpfTitular;
        this.dataAbertura = dataAbertura;
        this.saldo = saldo;
        this.ativa = ativa;
        this.tipo = tipo;
    }

    // Getters e Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNumero() { return numero; }
    public void setNumero(String numero) { this.numero = numero; }
    public String getAgencia() { return agencia; }
    public void setAgencia(String agencia) { this.agencia = agencia; }
    public String getNomeTitular() { return nomeTitular; }
    public void setNomeTitular(String nomeTitular) { this.nomeTitular = nomeTitular; }
    public String getCpfTitular() { return cpfTitular; }
    public void setCpfTitular(String cpfTitular) { this.cpfTitular = cpfTitular; }
    public LocalDate getDataAbertura() { return dataAbertura; }
    public void setDataAbertura(LocalDate dataAbertura) { this.dataAbertura = dataAbertura; }
    public double getSaldo() { return saldo; }
    public void setSaldo(double saldo) { this.saldo = saldo; }
    public boolean isAtiva() { return ativa; }
    public void setAtiva(boolean ativa) { this.ativa = ativa; }
    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }

    // Facilita exibir os dados como JSON
    @Override
    public String toString() {
        return "{" +
                "\"id\": " + id +
                ", \"numero\": \"" + numero + "\"" +
                ", \"agencia\": \"" + agencia + "\"" +
                ", \"nomeTitular\": \"" + nomeTitular + "\"" +
                ", \"cpfTitular\": \"" + cpfTitular + "\"" +
                ", \"dataAbertura\": \"" + dataAbertura + "\"" +
                ", \"saldo\": " + saldo +
                ", \"ativa\": " + ativa +
                ", \"tipo\": \"" + tipo + "\"" +
                "}";
    }
}
