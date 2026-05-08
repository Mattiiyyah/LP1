package entities;

import java.time.LocalDate;
import java.util.ArrayList;


public class AtendimentoEntity {
    private Integer id;
    private LocalDate dataAbertura;
    private LocalDate dataAlta;
    private String convenio;
    private String observacaoEntrada;
    private String observacaoAlta;

    private ArrayList<MedicoAtendimento> medicos;
    private ArrayList<ProcedimentoAtendimento> procedimentos;
    private ArrayList<ExameAtendimento> exames;
    
    private PessoaEntity pessoa;
    private FuncionarioEntity funcionario;


    public AtendimentoEntity() {
        id = 0;
        dataAbertura = LocalDate.now();
        dataAlta = null;
        convenio = new String();
        observacaoEntrada = new String();
        observacaoAlta = new String();
        medicos = new ArrayList<>();
        procedimentos = new ArrayList<>();
        exames = new ArrayList<>();
        pessoa = new PessoaEntity();
        funcionario = new FuncionarioEntity();
    }

    public AtendimentoEntity(Integer id, LocalDate dataAbertura, LocalDate dataAlta, String convenio,
            String observacaoEntrada, String observacaoAlta, ArrayList<MedicoAtendimento> atendimentosMedico,
            ArrayList<ProcedimentoAtendimento> atendimentosProcedimento, ArrayList<ExameAtendimento> atendimentosExame,
            PessoaEntity pessoa, FuncionarioEntity funcionario) {
        this.id = id;
        this.dataAbertura = dataAbertura;
        this.dataAlta = dataAlta;
        this.convenio = convenio;
        this.observacaoEntrada = observacaoEntrada;
        this.observacaoAlta = observacaoAlta;
        this.medicos = atendimentosMedico;
        this.procedimentos = atendimentosProcedimento;
        this.exames = atendimentosExame;
        this.pessoa = pessoa;
        this.funcionario = funcionario;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getDataAbertura() {
        return dataAbertura;
    }

    public void setDataAbertura(LocalDate dataAbertura) {
        this.dataAbertura = dataAbertura;
    }

    public LocalDate getDataAlta() {
        return dataAlta;
    }

    public void setDataAlta(LocalDate dataAlta) {
        this.dataAlta = dataAlta;
    }

    public String getConvenio() {
        return convenio;
    }

    public void setConvenio(String convenio) {
        this.convenio = convenio;
    }

    public String getObservacaoEntrada() {
        return observacaoEntrada;
    }

    public void setObservacaoEntrada(String observacaoEntrada) {
        this.observacaoEntrada = observacaoEntrada;
    }

    public String getObservacaoAlta() {
        return observacaoAlta;
    }

    public void setObservacaoAlta(String observacaoAlta) {
        this.observacaoAlta = observacaoAlta;
    }

    public PessoaEntity getPessoa() {
        return pessoa;
    }

    public void setPessoa(PessoaEntity pessoa) {
        this.pessoa = pessoa;
    }

    public FuncionarioEntity getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(FuncionarioEntity funcionario) {
        this.funcionario = funcionario;
    }

    public void adicionarExame(ExameAtendimento exame) {
        exames.add(exame);
    }

    public void removerExame(ExameAtendimento exame) {
        exames.remove(exame);
    }

    public void adicionarMedico(MedicoAtendimento medico) {
        medicos.add(medico);
    }

    public void removerMedico(MedicoAtendimento medico) {
        medicos.remove(medico);
    }

    public void adicionarProcedimento(ProcedimentoAtendimento procedimento) {
        procedimentos.add(procedimento);
    }

    public void removerProcedimento(ProcedimentoAtendimento procedimento) {
        procedimentos.remove(procedimento);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("+================================================+\n");
        sb.append("|            ATENDIMENTO #").append(id).append("                        |\n");
        sb.append("+================================================+\n");
        sb.append("| Data Abertura:       ").append(dataAbertura).append("\n");
        sb.append("| Data Alta:           ").append(dataAlta).append("\n");
        sb.append("| Convenio:            ").append(convenio).append("\n");
        sb.append("| Obs. Entrada:        ").append(observacaoEntrada).append("\n");
        sb.append("| Obs. Alta:           ").append(observacaoAlta).append("\n");
        sb.append("+------------------------------------------------+\n");

        sb.append("| PACIENTE\n");
        sb.append("|   Nome:              ").append(pessoa.getNome()).append("\n");
        sb.append("|   CPF:               ").append(pessoa.getCpf()).append("\n");
        sb.append("|   Status:            ").append(pessoa.getStatus().getDescricao()).append("\n");
        sb.append("+------------------------------------------------+\n");

        sb.append("| FUNCIONARIO RESPONSAVEL\n");
        sb.append("|   Nome:              ").append(funcionario.getNome()).append("\n");
        sb.append("|   CPF:               ").append(funcionario.getCpf()).append("\n");
        sb.append("|   Setor:             ").append(funcionario.getSetor()).append("\n");
        sb.append("+------------------------------------------------+\n");

        sb.append("| MEDICOS (").append(medicos.size()).append(")\n");
        for (int i = 0; i < medicos.size(); i++) {
            MedicoAtendimento ma = medicos.get(i);
            sb.append("|   [").append(i + 1).append("] ").append(ma.getMedico().getNome()).append("\n");
            sb.append("|       CRM:           ").append(ma.getMedico().getCrm()).append("\n");
            sb.append("|       Data Inicio:   ").append(ma.getDataInico()).append("\n");
            sb.append("|       Observacoes:   ").append(ma.getObservacoes()).append("\n");
            sb.append("|       Status:        ").append(ma.getStatus()).append("\n");
            if (i < medicos.size() - 1) sb.append("|\n");
        }
        sb.append("+------------------------------------------------+\n");

        sb.append("| PROCEDIMENTOS (").append(procedimentos.size()).append(")\n");
        for (int i = 0; i < procedimentos.size(); i++) {
            ProcedimentoAtendimento pa = procedimentos.get(i);
            sb.append("|   [").append(i + 1).append("] ").append(pa.getProcedimento().getDescricao()).append("\n");
            sb.append("|       Data:          ").append(pa.getDataHoraRealizada()).append("\n");
            sb.append("|       Resultado:     ").append(pa.getResultado()).append("\n");
            if (i < procedimentos.size() - 1) sb.append("|\n");
        }
        sb.append("+------------------------------------------------+\n");

        sb.append("| EXAMES (").append(exames.size()).append(")\n");
        for (int i = 0; i < exames.size(); i++) {
            ExameAtendimento ea = exames.get(i);
            sb.append("|   [").append(i + 1).append("] ").append(ea.getExame().getDescricao()).append(" (").append(ea.getExame().getTipo()).append(")\n");
            sb.append("|       Data:          ").append(ea.getDataHoraRealizada()).append("\n");
            sb.append("|       Laudo:         ").append(ea.getLaudo()).append("\n");
            sb.append("|       Observacoes:   ").append(ea.getObservacoes()).append("\n");
            if (i < exames.size() - 1) sb.append("|\n");
        }
        sb.append("+================================================+\n");

        return sb.toString();
    }

}
