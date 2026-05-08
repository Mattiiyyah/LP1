package entities;

import java.time.LocalDate;

public class ProcedimentoAtendimento {
    private AtendimentoEntity atendimento;
    private ProcedimentoEntity procedimento;
    private LocalDate dataHoraRealizada;
    private String resultado;
    
    public ProcedimentoAtendimento() {
        atendimento = new AtendimentoEntity();
        procedimento = new ProcedimentoEntity();
        dataHoraRealizada = null;
        resultado = new String();
    }
    
    public ProcedimentoAtendimento(AtendimentoEntity atendimento, ProcedimentoEntity procedimento,
        LocalDate dataHoraRealizada, String resultado) {
        this.atendimento = atendimento;
        this.procedimento = procedimento;
        this.dataHoraRealizada = dataHoraRealizada;
        this.resultado = resultado;
    }

    public AtendimentoEntity getAtendimento() {
        return atendimento;
    }

    public void setAtendimento(AtendimentoEntity atendimento) {
        this.atendimento = atendimento;
    }

    public ProcedimentoEntity getProcedimento() {
        return procedimento;
    }

    public void setProcedimento(ProcedimentoEntity procedimento) {
        this.procedimento = procedimento;
    }

    public LocalDate getDataHoraRealizada() {
        return dataHoraRealizada;
    }

    public void setDataHoraRealizada(LocalDate dataHoraRealizada) {
        this.dataHoraRealizada = dataHoraRealizada;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }
    
    
}
