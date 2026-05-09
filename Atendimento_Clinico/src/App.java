import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.io.FileWriter;
import java.io.File;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import entities.AdminEntity;
import entities.AtendimentoEntity;
import entities.ExameAtendimento;
import entities.ExameEntity;
import entities.FuncionarioEntity;
import entities.MedicoAtendimento;
import entities.MedicoEntity;
import entities.PessoaEntity;
import entities.ProcedimentoAtendimento;
import entities.ProcedimentoEntity;
import entities.StatusEntity;

public class App {
    public static void main(String[] args) {
        StatusEntity status = new StatusEntity(1, "ativo");

        //Criando o paciente
        PessoaEntity paciente1 = new PessoaEntity("1111", "Roberto", "123", status);
        PessoaEntity paciente2 = new PessoaEntity("2222", "Larissa", "321", status);
        PessoaEntity paciente3 = new PessoaEntity("3333", "Carlos", "213", status);

        //Criando o administrador
        AdminEntity admin = new AdminEntity("4444", "Luiz", "123", status, LocalDate.now().plusDays(2));

        //Criando os funcionários
        FuncionarioEntity funcionario1 = new FuncionarioEntity("5555", "José", "345", status, "Bloco - A");
        FuncionarioEntity funcionario2 = new FuncionarioEntity("6666", "Maria", "543", status, "Bloco - B");

        //Criando os médicos
        MedicoEntity medico1 = new MedicoEntity("7777", "Dr. Lucas", "435", status, "1.2.3-11");
        MedicoEntity medico2 = new MedicoEntity("8888", "Dra. Marilene", "453", status, "1.3.2-12");

        //criando os procedimentos
        ProcedimentoEntity procedimento1 = new ProcedimentoEntity(1, "Raio X", "Exame de imagem básico");
        ProcedimentoEntity procedimento2 = new ProcedimentoEntity(2, "Hemograma", "Exame de sangue completo");

        //Criando os exames
        ExameEntity exame1 = new ExameEntity(1, "Raio X do dedo", "Imagem");
        ExameEntity exame2 = new ExameEntity(2, "Hemograma Completo", "Sangue");

        //Criando arrays vazios para serem armazenados no atendimento
        ArrayList<MedicoAtendimento> medicos = new ArrayList<>();
        ArrayList<ProcedimentoAtendimento> procedimentos = new ArrayList<>();
        ArrayList<ExameAtendimento> exames = new ArrayList<>();

        AtendimentoEntity atendimento = new AtendimentoEntity(
            1,
            LocalDate.now().plusDays(2),
            LocalDate.now().plusDays(4),
            "Austa Clinica",
            "Osso do dedo quebrado",
            "Ficar com dedo enfachado por 2 semanas",
            medicos,
            procedimentos,
            exames,
            paciente1,
            funcionario1
        );

        MedicoAtendimento medicoAtendimento = new MedicoAtendimento(atendimento, medico2, LocalDate.now().plusDays(2), "Realizamento sobre fratura de Paciente", "em andamento");

        ProcedimentoAtendimento procedimentoAtendimento = new ProcedimentoAtendimento(atendimento, procedimento1, LocalDate.now().plusDays(2), "Realizado com sucesso");

        ExameAtendimento exameAtendimento = new ExameAtendimento(atendimento, exame1, LocalDate.now().plusDays(2), "Fratura confirmada no dedo indicador", "Paciente encaminhado para imobilização");

        atendimento.adicionarMedico(medicoAtendimento);
        atendimento.adicionarProcedimento(procedimentoAtendimento);
        atendimento.adicionarExame(exameAtendimento);

        //Atendimento 2 - Paciente Larissa
        ArrayList<MedicoAtendimento> medicos2 = new ArrayList<>();
        ArrayList<ProcedimentoAtendimento> procedimentos2 = new ArrayList<>();
        ArrayList<ExameAtendimento> exames2 = new ArrayList<>();

        AtendimentoEntity atendimento2 = new AtendimentoEntity(
            2,
            LocalDate.now().plusDays(1),
            LocalDate.now().plusDays(3),
            "Unimed",
            "Dor abdominal intensa",
            "Repouso e dieta leve por 5 dias",
            medicos2,
            procedimentos2,
            exames2,
            paciente2,
            funcionario2
        );

        MedicoAtendimento medicoAtendimento2 = new MedicoAtendimento(atendimento2, medico1, LocalDate.now().plusDays(1), "Avaliação clínica geral do paciente", "finalizado");

        ProcedimentoAtendimento procedimentoAtendimento2 = new ProcedimentoAtendimento(atendimento2, procedimento2, LocalDate.now().plusDays(1), "Hemograma dentro dos valores normais");

        ExameAtendimento exameAtendimento2 = new ExameAtendimento(atendimento2, exame2, LocalDate.now().plusDays(1), "Resultados sem alterações significativas", "Paciente liberada com orientações");

        atendimento2.adicionarMedico(medicoAtendimento2);
        atendimento2.adicionarProcedimento(procedimentoAtendimento2);
        atendimento2.adicionarExame(exameAtendimento2);

        //Atendimento 3 - Paciente Carlos
        ArrayList<MedicoAtendimento> medicos3 = new ArrayList<>();
        ArrayList<ProcedimentoAtendimento> procedimentos3 = new ArrayList<>();
        ArrayList<ExameAtendimento> exames3 = new ArrayList<>();

        AtendimentoEntity atendimento3 = new AtendimentoEntity(
            3,
            LocalDate.now().plusDays(3),
            LocalDate.now().plusDays(5),
            "SulAmérica",
            "Entorse no tornozelo esquerdo",
            "Uso de muletas por 10 dias",
            medicos3,
            procedimentos3,
            exames3,
            paciente3,
            funcionario1
        );

        MedicoAtendimento medicoAtendimento3 = new MedicoAtendimento(atendimento3, medico1, LocalDate.now().plusDays(3), "Avaliação ortopédica do tornozelo", "em andamento");
        MedicoAtendimento medicoAtendimento4 = new MedicoAtendimento(atendimento3, medico2, LocalDate.now().plusDays(4), "Reavaliação pós imobilização", "finalizado");

        ProcedimentoAtendimento procedimentoAtendimento3 = new ProcedimentoAtendimento(atendimento3, procedimento1, LocalDate.now().plusDays(3), "Raio X sem fratura, apenas entorse");
        ProcedimentoAtendimento procedimentoAtendimento4 = new ProcedimentoAtendimento(atendimento3, procedimento2, LocalDate.now().plusDays(3), "Hemograma de rotina sem alterações");

        ExameAtendimento exameAtendimento3 = new ExameAtendimento(atendimento3, exame1, LocalDate.now().plusDays(3), "Sem fratura identificada", "Entorse grau 2 confirmado");

        atendimento3.adicionarMedico(medicoAtendimento3);
        atendimento3.adicionarMedico(medicoAtendimento4);
        atendimento3.adicionarProcedimento(procedimentoAtendimento3);
        atendimento3.adicionarProcedimento(procedimentoAtendimento4);
        atendimento3.adicionarExame(exameAtendimento3);


        System.out.println("+================================================+");
        System.out.println("|              ADMINISTRADOR                      |");
        System.out.println("+================================================+");
        System.out.println("|   Nome:              " + admin.getNome());
        System.out.println("|   CPF:               " + admin.getCpf());
        System.out.println("|   Data Cadastro:     " + admin.getDataCadastro());
        System.out.println("|   Status:            " + admin.getStatus().getDescricao());
        System.out.println("+================================================+");
        System.out.println();

        System.out.println(atendimento);
        System.out.println(atendimento2);   
        System.out.println(atendimento3);

        // ====== EXPORTAÇÃO JSON PARA O DASHBOARD WEB ======
        try {
            Map<String, Object> dados = new LinkedHashMap<>();

            // Admin
            Map<String, Object> adminMap = new LinkedHashMap<>();
            adminMap.put("nome", admin.getNome());
            adminMap.put("cpf", admin.getCpf());
            adminMap.put("dataCadastro", admin.getDataCadastro().toString());
            adminMap.put("status", admin.getStatus().getDescricao());
            dados.put("admin", adminMap);

            // Atendimentos
            ArrayList<Map<String, Object>> atendimentosList = new ArrayList<>();

            // Helper: converter cada atendimento
            AtendimentoEntity[] todosAtendimentos = { atendimento, atendimento2, atendimento3 };
            for (AtendimentoEntity at : todosAtendimentos) {
                atendimentosList.add(converterAtendimento(at));
            }

            dados.put("atendimentos", atendimentosList);

            // Escrever JSON
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            String json = gson.toJson(dados);

            File webDir = new File("web");
            if (!webDir.exists()) webDir.mkdirs();

            FileWriter writer = new FileWriter("web/dados.json");
            writer.write(json);
            writer.close();

            System.out.println("\n✅ Arquivo web/dados.json gerado com sucesso!");
            System.out.println("   Abra web/index.html no navegador para visualizar o dashboard.");

        } catch (Exception e) {
            System.out.println("\n❌ Erro ao gerar JSON: " + e.getMessage());
        }

    }

    // Método auxiliar para converter AtendimentoEntity em Map
    private static Map<String, Object> converterAtendimento(AtendimentoEntity at) {
        Map<String, Object> map = new LinkedHashMap<>();
        map.put("id", at.getId());
        map.put("dataAbertura", at.getDataAbertura().toString());
        map.put("dataAlta", at.getDataAlta() != null ? at.getDataAlta().toString() : null);
        map.put("convenio", at.getConvenio());
        map.put("observacaoEntrada", at.getObservacaoEntrada());
        map.put("observacaoAlta", at.getObservacaoAlta());

        // Paciente
        Map<String, Object> pacMap = new LinkedHashMap<>();
        pacMap.put("nome", at.getPessoa().getNome());
        pacMap.put("cpf", at.getPessoa().getCpf());
        pacMap.put("status", at.getPessoa().getStatus().getDescricao());
        map.put("paciente", pacMap);

        // Funcionário
        Map<String, Object> funcMap = new LinkedHashMap<>();
        funcMap.put("nome", at.getFuncionario().getNome());
        funcMap.put("cpf", at.getFuncionario().getCpf());
        funcMap.put("setor", at.getFuncionario().getSetor());
        map.put("funcionario", funcMap);

        // Médicos
        ArrayList<Map<String, Object>> medicosList = new ArrayList<>();
        for (MedicoAtendimento ma : at.getMedicos()) {
            Map<String, Object> mMap = new LinkedHashMap<>();
            mMap.put("nomeMedico", ma.getMedico().getNome());
            mMap.put("crm", ma.getMedico().getCrm());
            mMap.put("dataInicio", ma.getDataInico().toString());
            mMap.put("observacoes", ma.getObservacoes());
            mMap.put("status", ma.getStatus());
            medicosList.add(mMap);
        }
        map.put("medicos", medicosList);

        // Procedimentos
        ArrayList<Map<String, Object>> procsList = new ArrayList<>();
        for (ProcedimentoAtendimento pa : at.getProcedimentos()) {
            Map<String, Object> pMap = new LinkedHashMap<>();
            pMap.put("descricao", pa.getProcedimento().getDescricao());
            pMap.put("observacoes", pa.getProcedimento().getObservacoes());
            pMap.put("dataRealizada", pa.getDataHoraRealizada().toString());
            pMap.put("resultado", pa.getResultado());
            procsList.add(pMap);
        }
        map.put("procedimentos", procsList);

        // Exames
        ArrayList<Map<String, Object>> examesList = new ArrayList<>();
        for (ExameAtendimento ea : at.getExames()) {
            Map<String, Object> eMap = new LinkedHashMap<>();
            eMap.put("descricao", ea.getExame().getDescricao());
            eMap.put("tipo", ea.getExame().getTipo());
            eMap.put("dataRealizada", ea.getDataHoraRealizada().toString());
            eMap.put("laudo", ea.getLaudo());
            eMap.put("observacoes", ea.getObservacoes());
            examesList.add(eMap);
        }
        map.put("exames", examesList);

        return map;
    }
}
