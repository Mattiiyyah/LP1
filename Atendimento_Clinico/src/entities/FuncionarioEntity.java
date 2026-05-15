package entities;

public class FuncionarioEntity extends PessoaEntity {
    
    private String setor;

    public FuncionarioEntity() {
        super();
        setor = new String();
    }

    public FuncionarioEntity(String cpf, String nome, String senha, StatusEntity status, String setor) {
        super(cpf, nome, senha, status);
        this.setor = setor;
    }

    public String getSetor() {
        return setor;
    }

    public void setSetor(String setor) {
        this.setor = setor;
    }

    @Override
    public String mostrarStatus() {
        return "Funcionário: " + getNome() + " | Setor: " + setor + " | Status: " + getStatus().getDescricao();
    }

}
