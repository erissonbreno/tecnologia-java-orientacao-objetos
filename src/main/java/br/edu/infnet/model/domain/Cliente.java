package br.edu.infnet.model.domain;

import br.edu.infnet.model.exceptions.DadosPessoaisNulosException;

public class Cliente {
    private String nome;
    private String email;
    private String cpf;

    public Cliente(String nome, String email, String cpf) throws DadosPessoaisNulosException {
        if(nome.isEmpty()) {
            throw new DadosPessoaisNulosException("Deve conter um nome.");
        }

        if(email.isEmpty()) {
            throw new DadosPessoaisNulosException("Deve conter um email.");
        }

        if(cpf.isEmpty()) {
            throw new DadosPessoaisNulosException("Deve conter um CPF.");
        }
        this.nome = nome;
        this.email = email;
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    @Override
    public String toString() {
        return "Solicitante{" +
                "nome='" + nome + '\'' +
                ", cpf='" + cpf + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
