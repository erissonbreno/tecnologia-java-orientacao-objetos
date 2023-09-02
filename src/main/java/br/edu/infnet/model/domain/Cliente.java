package br.edu.infnet.model.domain;

import br.edu.infnet.model.exceptions.DadosPessoaisNulosException;

public class Cliente {
    private final String nome;
    private final String email;
    private final String cpf;

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

    public String getEmail() {
        return email;
    }

    public String getCpf() {
        return cpf;
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
