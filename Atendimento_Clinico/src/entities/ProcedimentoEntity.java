package entities;

public class ProcedimentoEntity {
    private Integer codigo;
    private String descricao;
    private String observacoes;
    
    public ProcedimentoEntity() {
        codigo      =  0;
        descricao   = new String();
        observacoes = new String();
    }

    public ProcedimentoEntity(Integer codigo, String descricao, String observacoes) {
        this.codigo = codigo;
        this.descricao = descricao;
        this.observacoes = observacoes;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }
    
}
