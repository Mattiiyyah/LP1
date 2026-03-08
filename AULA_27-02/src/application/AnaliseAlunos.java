// Faça um programa que receba uma quantidade indeterminada
// de notas de alunos, calcule e mostre:
// - a maior notas (FEITO)
// - a menor nota (FEITO)
// - a média geral das notas (FEITO)
// - o nome do aluno que tirou a maior nota
// - o nome do aluno que tirou a menor nota
// - quantos alunos estão abaixo de 6
// - todos os nomes de alunos aprovados com a respectiva nota

package application;

import java.util.Scanner;
import java.util.Locale;

public class AnaliseAlunos {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner leitor = new Scanner(System.in);

        String nome;
        String nomeMaiorNota = "", nomeMenorNota = "", alunosAprovados = "", alunosMesmaNota = "";
        float nota, somaNota = 0, menorNota = 0, maiorNota = 0, mediaGeral;
        int contNota = 0, qdtAluno = 0;
        int codigo = 1;

        do {
            try {
                // verifica nota
                do {
                    System.out.print("\nDigite a nota do aluno entre 0 a 10: ");
                    nota = leitor.nextFloat();

                    if (nota < 0 || nota > 10) {
                        throw new Exception("Nota deve estar entre 0 a 10");
                    }
                    System.out.println("\nTeste aqui...........");

                } while (nota < 0 || nota > 10);

                // verifica o nome
                do {
                    System.out.print("\nDigite o nome do aluno: ");
                    nome = leitor.next();

                    if (nome == null || !nome.matches("[a-zA-Z]+")) {
                       throw new Exception("Nome deve conter apenas caracter");
                    }
                    System.out.println("\nTeste aqui...........");

                } while (nome == null || !nome.matches("[a-zA-Z]+"));

                if (nota < 6) {
                    qdtAluno++;
                }

                if (nota >= 6) {
                    alunosAprovados = alunosAprovados + " " + nome + " = " + nota;
                }

                somaNota += nota;

                contNota++;

                if (contNota == 1) {
                    maiorNota = nota;
                    menorNota = nota;
                    nomeMaiorNota = nome;
                    nomeMenorNota = nome;
                }

                else {

                    if (nota > maiorNota) {
                        maiorNota = nota;
                        nomeMaiorNota = nome;
                        alunosMesmaNota = "";
                    }

                    else {
                        if (nota == maiorNota) {
                            alunosMesmaNota = alunosMesmaNota + " " + nome + " = " + nota;
                        }
                    }

                    if (nota < menorNota) {
                        menorNota = nota;
                        nomeMenorNota = nome;
                    }
                }

                System.out.println("\nDigite: ");
                System.out.println("\n1- Para continuar ");
                System.out.println("Outro número para sair");
                System.out.print("\nDigite aqui: ");
                codigo = leitor.nextInt();

            } catch (Exception erro) {
                System.out.println("\n##############################");
                System.out.println("Erro: " + erro.getMessage());
                System.out.println("##############################");
                leitor.nextLine();
                nota = -1;
            }

        } while (codigo == 1);

        mediaGeral = somaNota / contNota;
        
        System.out.println("-----------  RESULTADOS ---------------------------------------");

        System.out.println("\nA maior nota é: " + maiorNota);
        System.out.println("A menor nota é: " + menorNota);
        System.out.printf("A média Geral é: %.2f\n", mediaGeral);
        System.out.println("A quantidade de alunos com NOTA abaixo de 6 é: " + qdtAluno);
        System.out.println("Nome do aluno com maior nota: " + nomeMaiorNota);
        System.out.println("Nomes de alunos com maior nota SENDO a mesma: " + alunosMesmaNota);
        System.out.println("Nome do aluno com menor nota: " + nomeMenorNota);
        System.out.println("Alunos aprovados com suas respectivas notas: " + alunosAprovados);
        
        System.out.println();

        leitor.close();
    }
}
