// Vamos realizar a inscrição de equipes para os campeonatos da escola, desta forma, solicitamos que os alunos informem a modalidade esportiva que deseja participar e o turno que os jogos devem acontecer.

// Para resolver isso, solicite primeiramente 3 modalidades esportivas e os 3 turnos desejados, 
// crie um laço de repetição que mostre as 3 modalidades, 
// o usuário escolha uma e posteriormente o usuário poderá escolher o turno que deseja participar desta modalidade.

// Ao final mostre a modalidade mais votada no respectivo turno.

// desafio não utilizar array fazer todo processo sem a utilização

package application;

import java.util.Scanner;

public class CampeonatoEscola {
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);

        char continuar = 's';
        String primeiraModalidade = "", segundaModalidade = "", terceiraModalidade = "";
        String escolhaModalidade = "", escolhaTurno = "";
        String primeiroTurno = "", segundoTurno = "", terceiroTurno = "";
        int cont1 = 0, cont2 = 0, cont3 = 0, cont4 = 0, cont5 = 0, cont6 = 0, cont7 = 0, cont8 = 0, cont9 = 0;

        for (int i = 1; i <= 3; i++) {
            if (i == 1) {
                do {
                    try {
                        System.out.print("\nInforme a primeira modalidade: ");
                        primeiraModalidade = leitor.next();

                        if (primeiraModalidade.equals("") || !primeiraModalidade.matches("[a-zA-Z]+")) {
                            throw new Exception("Informe a modalidade corretamente!");
                        }
                    } catch (Exception erro) {
                        System.out.println("\n########################################");
                        System.out.println("\nErro: " + erro.getMessage());
                        System.out.println("Tente novamente.");
                        System.out.println("\n########################################");
                        leitor.next();
                    }

                } while (primeiraModalidade.equals("") || !primeiraModalidade.matches("[a-zA-Z]+"));
            } else if (i == 2) {
                do {
                    try {
                        System.out.print("\nInforme a segunda modalidade: ");
                        segundaModalidade = leitor.next();

                        if (segundaModalidade.equals("") || !segundaModalidade.matches("[a-zA-Z]+")) {
                            throw new Exception("Informe a modalidade corretamente!");
                        }
                    } catch (Exception erro) {
                        System.out.println("\n########################################");
                        System.out.println("\nErro: " + erro.getMessage());
                        System.out.println("Tente novamente.");
                        System.out.println("\n########################################");
                        leitor.next();
                    }

                } while (segundaModalidade.equals("") || !segundaModalidade.matches("[a-zA-Z]+"));
            } else {
                do {
                    try {
                        System.out.print("\nInforme a terceira modalidade: ");
                        terceiraModalidade = leitor.next();

                        if (terceiraModalidade.equals("") || !terceiraModalidade.matches("[a-zA-Z]+")) {
                            throw new Exception("Informe a modalidade corretamente!");
                        }
                    } catch (Exception erro) {
                        System.out.println("\n########################################");
                        System.out.println("\nErro: " + erro.getMessage());
                        System.out.println("Tente novamente.");
                        System.out.println("\n########################################");
                        leitor.next();
                    }

                } while (terceiraModalidade.equals("") || !terceiraModalidade.matches("[a-zA-Z]+"));
            }
        }

        for (int i = 1; i <= 3; i++) {

            if (i == 1) {
                do {
                    try {
                        System.out.print("\nInforme o primeiro turno: ");
                        primeiroTurno = leitor.next();

                        if (primeiroTurno.equals("") || !primeiroTurno.matches("[a-zA-Z]+")) {
                            throw new Exception("Informe o turno corretamente!");
                        }
                    } catch (Exception erro) {
                        System.out.println("\n########################################");
                        System.out.println("\nErro: " + erro.getMessage());
                        System.out.println("Tente novamente.");
                        System.out.println("\n########################################");
                        leitor.next();
                    }

                } while (primeiroTurno.equals("") || !primeiroTurno.matches("[a-zA-Z]+"));

            } else if (i == 2) {

                do {
                    try {
                        System.out.print("\nInforme o segundo turno: ");
                        segundoTurno = leitor.next();

                        if (segundoTurno.equals("") || !segundoTurno.matches("[a-zA-Z]+")) {
                            throw new Exception("Informe o turno corretamente!");
                        }
                    } catch (Exception erro) {
                        System.out.println("\n########################################");
                        System.out.println("\nErro: " + erro.getMessage());
                        System.out.println("Tente novamente.");
                        System.out.println("\n########################################");
                        leitor.next();
                    }

                } while (segundoTurno.equals("") || !segundoTurno.matches("[a-zA-Z]+"));

            } else {

                do {
                    try {
                        System.out.print("\nInforme o terceiro turno: ");
                        terceiroTurno = leitor.next();

                        if (terceiroTurno.equals("") || !terceiroTurno.matches("[a-zA-Z]+")) {
                            throw new Exception("Informe o turno corretamente!");
                        }
                    } catch (Exception erro) {
                        System.out.println("\n########################################");
                        System.out.println("\nErro: " + erro.getMessage());
                        System.out.println("Tente novamente.");
                        System.out.println("\n########################################");
                        leitor.next();
                    }

                } while (terceiroTurno.equals("") || !terceiroTurno.matches("[a-zA-Z]+"));
            }
        }

        do {

            // exibindo as três modalidades
            System.out.println("\n ---------------------------");
            System.out.println("\nModalidades: ");
            for (int i = 1; i <= 3; i++) {
                if (i == 1) {
                    System.out.println("\n" + primeiraModalidade);
                } else if (i == 2) {
                    System.out.println(segundaModalidade);
                } else {
                    System.out.println(terceiraModalidade);
                }
            }
            System.out.println("\n ---------------------------");

            // exibição dos turnos
            System.out.println("\n ---------------------------");
            System.out.println("\nTurnos: ");
            for (int i = 1; i <= 3; i++) {
                if (i == 1) {
                    System.out.println("\n" + primeiroTurno);
                } else if (i == 2) {
                    System.out.println(segundoTurno);
                } else {
                    System.out.println(terceiroTurno);
                }
            }
            System.out.println("\n ---------------------------");

            // validacação para escolha de modalidade
            do {
                try {
                    System.out.print("\nEscolha a modalidade: ");
                    escolhaModalidade = leitor.next();

                    if (!escolhaModalidade.equals(primeiraModalidade) && !escolhaModalidade.equals(segundaModalidade)
                            && !escolhaModalidade.equals(terceiraModalidade)) {
                        throw new Exception("Escreva a modalidade corretamente!");
                    }
                } catch (Exception erro) {
                    System.out.println("\n########################################");
                    System.out.println("\nErro: " + erro.getMessage());
                    System.out.println("Tente novamente.");
                    System.out.println("\n########################################");
                    leitor.next();
                }
            } while (!escolhaModalidade.equals(primeiraModalidade) && !escolhaModalidade.equals(segundaModalidade)
                    && !escolhaModalidade.equals(terceiraModalidade));

            do {
                try {
                    System.out.println("\nEscolha o periodo: ");
                    escolhaTurno = leitor.next();

                    if (!escolhaTurno.equals(primeiroTurno) && !escolhaTurno.equals(segundoTurno)
                            && !escolhaTurno.equals(terceiroTurno)) {
                        throw new Exception("Escreva o periodo corretamente!");
                    }
                } catch (Exception erro) {
                    System.out.println("\n########################################");
                    System.out.println("\nErro: " + erro.getMessage());
                    System.out.println("Tente novamente.");
                    System.out.println("\n########################################");
                    leitor.next();
                }
            } while (!escolhaTurno.equals(primeiroTurno) && !escolhaTurno.equals(segundoTurno)
                    && !escolhaTurno.equals(terceiroTurno));

            if (escolhaModalidade.equals(primeiraModalidade) && escolhaTurno.equals(primeiroTurno))
                cont1++;

            if (escolhaModalidade.equals(segundaModalidade) && escolhaTurno.equals(segundoTurno))
                cont2++;

            if (escolhaModalidade.equals(terceiraModalidade) && escolhaTurno.equals(terceiroTurno))
                cont3++;

            if (escolhaModalidade.equals(primeiraModalidade) && escolhaTurno.equals(segundoTurno))
                cont4++;

            if (escolhaModalidade.equals(primeiraModalidade) && escolhaTurno.equals(terceiroTurno))
                cont5++;

            if (escolhaModalidade.equals(segundaModalidade) && escolhaTurno.equals(primeiroTurno))
                cont6++;

            if (escolhaModalidade.equals(segundaModalidade) && escolhaTurno.equals(terceiroTurno))
                cont7++;

            if (escolhaModalidade.equals(terceiraModalidade) && escolhaTurno.equals(primeiroTurno))
                cont8++;

            if (escolhaModalidade.equals(terceiraModalidade) && escolhaTurno.equals(segundoTurno))
                cont9++;

            System.out.println("\nDeseja continuar? (s/n)");
            continuar = leitor.next().charAt(0);

        } while (continuar == 's');

        System.out.println("\n--- RESULTADO FINAL ---");

        // Encontrar a combinação com mais votos
        int maxVotos = cont1;
        String modalidadeVencedora = primeiraModalidade;
        String turnoVencedor = primeiroTurno;

        if (cont2 > maxVotos) {
            maxVotos = cont2;
            modalidadeVencedora = segundaModalidade;
            turnoVencedor = segundoTurno;
        }
        if (cont3 > maxVotos) {
            maxVotos = cont3;
            modalidadeVencedora = terceiraModalidade;
            turnoVencedor = terceiroTurno;
        }
        if (cont4 > maxVotos) {
            maxVotos = cont4;
            modalidadeVencedora = primeiraModalidade;
            turnoVencedor = segundoTurno;
        }
        if (cont5 > maxVotos) {
            maxVotos = cont5;
            modalidadeVencedora = primeiraModalidade;
            turnoVencedor = terceiroTurno;
        }
        if (cont6 > maxVotos) {
            maxVotos = cont6;
            modalidadeVencedora = segundaModalidade;
            turnoVencedor = primeiroTurno;
        }
        if (cont7 > maxVotos) {
            maxVotos = cont7;
            modalidadeVencedora = segundaModalidade;
            turnoVencedor = terceiroTurno;
        }
        if (cont8 > maxVotos) {
            maxVotos = cont8;
            modalidadeVencedora = terceiraModalidade;
            turnoVencedor = primeiroTurno;
        }
        if (cont9 > maxVotos) {
            maxVotos = cont9;
            modalidadeVencedora = terceiraModalidade;
            turnoVencedor = segundoTurno;
        }

        if (maxVotos > 0) {
            System.out.println("A modalidade mais votada foi a(o) " + modalidadeVencedora + " no turno " + turnoVencedor
                    + " com " + maxVotos + " votos.");
        } else {
            System.out.println("Nenhum voto foi registrado.");
        }

        System.out.println("");
        leitor.close();
    }
}