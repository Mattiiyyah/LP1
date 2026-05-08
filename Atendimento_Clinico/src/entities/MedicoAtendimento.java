package entities;

import java.time.LocalDate;

public class MedicoAtendimento {
    private AtendimentoEntity atendimento;
    private MedicoEntity medico;
    private LocalDate dataInico;
    private String observacoes;
    private String status;
    
    public MedicoAtendimento() {
        atendimento = new AtendimentoEntity();
        medico = new MedicoEntity();
        dataInico = LocalDate.now();
        observacoes = new String();
        status = new String();
    }
    
    public MedicoAtendimento(AtendimentoEntity atendimento, MedicoEntity medico, LocalDate dataInico,
            String observacoes, String status) {
        this.atendimento = atendimento;
        this.medico = medico;
        this.dataInico = dataInico;
        this.observacoes = observacoes;
        this.status = status;
    }

    public AtendimentoEntity getAtendimento() {
        return atendimento;
    }

    public void setAtendimento(AtendimentoEntity atendimento) {
        this.atendimento = atendimento;
    }

    public MedicoEntity getMedico() {
        return medico;
    }

    public void setMedico(MedicoEntity medico) {
        this.medico = medico;
    }

    public LocalDate getDataInico() {
        return dataInico;
    }

    public void setDataInico(LocalDate dataInico) {
        this.dataInico = dataInico;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    
    
}
