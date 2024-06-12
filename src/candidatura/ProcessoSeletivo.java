package candidatura;
import java.util.concurrent.ThreadLocalRandom;

public class ProcessoSeletivo {
    public static void main(String[] args) {
        System.out.println("Processo Seletivo");
        selecionarCandidatos();
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