package entities;

import java.time.LocalDate;

public class ExameAtendimento {
    
    private AtendimentoEntity atendimento;
    private ExameEntity exame;
    private LocalDate dataHoraRealizada;
    private String laudo;
    private String observacoes;

    public ExameAtendimento() {
        atendimento = new AtendimentoEntity();
        exame = new ExameEntity();
        dataHoraRealizada = LocalDate.now();
        laudo = new String();
    }
    
    public ExameAtendimento(AtendimentoEntity atendimento, ExameEntity exame, LocalDate dataHoraRealizada,
            String laudo, String observacoes) {
        this.atendimento = atendimento;
        this.exame = exame;
        this.dataHoraRealizada = dataHoraRealizada;
        this.laudo = laudo;
        this.observacoes = observacoes;
    }

    public AtendimentoEntity getAtendimento() {
        return atendimento;
    }

    public void setAtendimento(AtendimentoEntity atendimento) {
        this.atendimento = atendimento;
    }

    public ExameEntity getExame() {
        return exame;
    }

    public void setExame(ExameEntity exame) {
        this.exame = exame;
    }

    public LocalDate getDataHoraRealizada() {
        return dataHoraRealizada;
    }

    public void setDataHoraRealizada(LocalDate dataHoraRealizada) {
        this.dataHoraRealizada = dataHoraRealizada;
    }

    public String getLaudo() {
        return laudo;
    }

    public void setLaudo(String laudo) {
        this.laudo = laudo;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }
    
}
