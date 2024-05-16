package aula12;

import java.util.Scanner;

public class CalculadoraMedia {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String nomeAluno = "", nomeAvaliacao = ""; // Armazena o nome do Aluno e da Avaliação
        int numAlunos = 0, numNotas = 0, numPesos = 0; // Armazena o numero de alunos, notas e pesos a ser inserida
        int resposta = 0; // Armazena a resposta do usuario
        float nota = 0, peso = 0, notaMinima =0;          // Armazena a nota, peso do aluno e qual a nota minima
        float somaNotas = 0; 
        double media = 0.0, somaPesos = 0.0;
        boolean continuar = true; // Opera se irá continuar ou não o while
        boolean cancelarSomaPesos = false; // Opera para cancelar o If SomaPesos
        boolean retornaAoInicio = true;    // Opera para que volte para o inicio 
        
        // Pergunta qual a nota minima
        System.out.println("Qual a nota minima?");
        notaMinima = input.nextFloat();
        
        // Pergunta quantos alunos será verificado e joga dentro do FOR
        System.out.println("Quantos alunos serão avaliados?");
        numAlunos = input.nextInt();

        // Solicita o número de notas a serem verificadas
        System.out.println("Quantas notas serão inseridas? ");
        numNotas = input.nextInt();

        // Solitica o número de pesos a serem armazenado 
        System.out.println("Quntos pesos serão inseridas? ");
        numPesos = input.nextInt();

        // Cria o Vetor de pesos
        float[] vetorPesos = new float[numPesos];

        // Armazena o valor dos pesos dentro do vetor 
        do {
            // Reseta a soma dos pesos
            somaPesos = 0;
            for (int l = 0; l <numPesos; l++) {
                // Pergunta o valor dos pesos e armazena eles dentro do Vetor 
                input.nextLine();
                System.out.printf("Valor Peso %d ", l + 1);
                vetorPesos[l] = input.nextFloat();  

                somaPesos += vetorPesos[l]; 

                if (somaPesos > 1) {
                    System.out.println("A soma dos pesos ultrapassou 1, por favor refaça!");
                } 
                    
            } // Fim primeiro FOR
        }while (somaPesos >1); // Fim do DO
        
        for (int j = 0; j <numAlunos; j++) {
            // Pergunta o nome do aluno avaliado e registra ele
            input.nextLine();
            System.out.println("Nome do Aluno");
            nomeAluno = input.nextLine();

            while (continuar = true) {
                // Reseta os dados dos alunos 
                media = 0;
                peso = 0;
                nota = 0;
                somaPesos = 0;
                somaNotas = 0;
    
                for (int i = 0; i < numNotas; i++) {
                    // Registra o nome da Avaliação
                    input.nextLine();
                    System.out.printf("Nome da Avaliação %d: ", i + 1);
                    nomeAvaliacao = input.nextLine();
                    
                    // Registra a nota
                    input.nextLine();
                    System.out.printf("Nota %d: ", i + 1);
                    nota =input.nextFloat(); 
    
                    somaNotas += nota * vetorPesos[i];
                    
                    // Verifica se as notas digitas foram corretas
                    System.out.println("Tem certeza destas notas?");
                    System.out.println("1 Sim ---- 2 Não");
                    resposta = input.nextInt();
                    input.nextLine();

                    // Cria o Vetor de Media
                    float[] vetorMedia = new float[numAlunos];
                    vetorMedia[i] = somaNotas;
    
                } // Fim terceiro FOR               
                
                //Retorna para o inicio do programa
                if (retornaAoInicio) {
                    break;
                }

            } // Fim do WHILE
        } // Fim segundo FOR

    } 
}
