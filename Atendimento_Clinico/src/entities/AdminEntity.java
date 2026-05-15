package entities;

import java.time.LocalDate;

public class AdminEntity extends PessoaEntity {
    
    private LocalDate dataCadastro;

    public AdminEntity() {
        super(); //faz isso automaticamente
        dataCadastro = LocalDate.now();
    }

    public AdminEntity(String cpf, String nome, String senha, StatusEntity status, LocalDate dataCadastro) {
        super(cpf, nome, senha, status);
        this.dataCadastro = dataCadastro;
    }

    public LocalDate getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(LocalDate dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    @Override
    public String mostrarStatus() {
        return "Administrador: " + getNome() + " | Status: " + getStatus().getDescricao();
    }

}
