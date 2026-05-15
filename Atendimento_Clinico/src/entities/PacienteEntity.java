package entities;

public class PacienteEntity extends PessoaEntity {
    private String planoSaude;

    public PacienteEntity() {
        super();
        this.planoSaude = "Não informado";
    }

    public PacienteEntity(String cpf, String nome, String senha, StatusEntity status, String planoSaude) {
        super(cpf, nome, senha, status);
        this.planoSaude = planoSaude;
    }

    public String getPlanoSaude() {
        return planoSaude;
    }

    public void setPlanoSaude(String planoSaude) {
        this.planoSaude = planoSaude;
    }

    @Override
    public String mostrarStatus() {
        return "Paciente: " + getNome() + " | Plano: " + planoSaude + " | Status: " + getStatus().getDescricao();
    }

}
