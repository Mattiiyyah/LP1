package entities;

public abstract class PessoaEntity {
    
    private String cpf;
    private String nome;
    private String senha;
    private StatusEntity status;

    public PessoaEntity() {
        cpf    =     new String();
        nome   =     new String();
        senha  =     new String();
        status =     new StatusEntity();
    }

    public PessoaEntity(String cpf, String nome, String senha, StatusEntity status) {
        this.cpf    = cpf;
        this.nome   = nome;
        this.senha  = senha;
        this.status = status;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public StatusEntity getStatus() {
        return status;
    }

    public void setStatus(StatusEntity status) {
        this.status = status;
    }

    public abstract String mostrarStatus();

}
