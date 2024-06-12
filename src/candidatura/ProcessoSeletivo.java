package candidatura;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class ProcessoSeletivo {
    public static void main(String[] args) {
        String [] candidatos = {"FELIPE", "MARCIA", "PAULO", "AUGUSTO", "MONICA"};
        for (String candidato: candidatos){
            entrarEmContato(candidato);
        }
    }
    static void entrarEmContato(String candidato){
        int tentativasRealizadas = 1;
        boolean continuarTentativa = true;
        boolean atendeuContato = false;

        do {
            atendeuContato = atender();
            continuarTentativa = !atendeuContato;
            if (continuarTentativa){
                tentativasRealizadas++;
            } else {
                System.out.println("CONTATO REALIZADO COM SUCESSO!");
            }
        }while (continuarTentativa && tentativasRealizadas < 3);

        if(atendeuContato){
        System.out.println("CONTATO REALIZADO COM SUCESSO COM "+ candidato + " NA TENTATIVA " + tentativasRealizadas);
        } else {
        System.out.println("NÃO CONSEGUIMOS CONTATO COM " + candidato + " NÚMERO MÁXIMO DE TENTATIVAS.");
        }
    }
    static boolean atender(){
        return new Random().nextInt(3)==1;
    }
    static void imprimirSelecionados(){
        String [] candidatos = {"FELIPE", "MARCIA", "PAULO", "AUGUSTO", "MONICA"};
        System.out.println("Imprimindo a lista de candidatos informando o índice do elemento: ");
        for (int i = 0; i < candidatos.length; i++) {
            System.out.println("O candidato de número " + (i+1) + " é " + candidatos[i]);
        }
        for (String candidato: candidatos){
            System.out.println("O candidato selecionado foi " + candidato);
        }
    }

    static void selecionarCandidatos(){
        String [] candidatos = {"FELIPE", "MARCIA", "PAULO", "AUGUSTO", "MONICA", "FABRICIO", "MIRELA", "DANIELA", "JOREL", "MARCELA"};
        int candidatosSelecionados = 0;
        int candidatoAtual = 0;
        double salarioBase = 2000;

        while (candidatosSelecionados < 5 && candidatoAtual < candidatos.length){
            String candidato = candidatos[candidatoAtual];
            double salarioPretendido = valorPretendido();
            System.out.println("O candidato " + candidato + " solicitou o salário de R$" + salarioPretendido);
            if (salarioBase >= salarioPretendido){
                candidatosSelecionados++;
                System.out.println("O candidato " + candidato + " foi selecionado para a vaga!");
            }
            candidatoAtual++;
        }
    }
    static double valorPretendido(){
        return ThreadLocalRandom.current().nextDouble(1000,2200);
    }
    static void analisarCandidato(double salarioPretendido){
        double salarioBase = 2000;
        if (salarioBase > salarioPretendido){
            System.out.println("LIGAR PARA O CANDIDATO");
        } else if (salarioBase == salarioPretendido) {
            System.out.println("LIGAR PARA O CANDIDATO COM CONTRA PROPOSTA");
        } else {
            System.out.println("AGUARDANDO DEMAIS CANDIDATOS");
        }
    }
}