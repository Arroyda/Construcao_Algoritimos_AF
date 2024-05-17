package aula12;

import java.util.Scanner;

import javax.sound.midi.Soundbank;

public class CalculadoraMedia {

    /**
     * @param args
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String nomeAluno = "", nomeAvaliacao = ""; // Armazena o nome do Aluno e da Avaliação
        int numAlunos = 0, numNotas = 0, numPesos = 0; // Armazena o numero de alunos, notas e pesos a ser inserida
        int resposta = 0; // Armazena a resposta do usuario
        int indiceAtual = 0;               // Armazena qual parte do for deve ser executado
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
        input.nextLine();
        // Cria o Vetor de pesos
        float[] vetorPesos = new float[numNotas];
        
        // Cria o Vetor de Media
        float[] vetorMedia = new float[numAlunos];

        //Cria o Vetor de Nome
        String[] vetorNome = new String[numAlunos];
     

        // Loop de verificação caso ultrapasse o numero total de pesos 
        do {
            // Reseta a soma dos pesos
            somaPesos = 0;
            for (int l = 0; l <numNotas; l++) {
                // Pergunta o valor dos pesos e armazena eles dentro do Vetor 
                System.out.printf("Valor Peso %d ", l + 1);
                vetorPesos[l] = input.nextFloat(); 
                
                
                // Soma todos os pesos para a verificação
                somaPesos += vetorPesos[l]; 
                // Verificação de pesos
                if (somaPesos > 1) {
                    System.out.println("A soma dos pesos ultrapassou 1, por favor refaça!");
                } 
                    
            } // Fim primeiro FOR

        }while (somaPesos >1); // Fim do DO
        
        for (int j = 0; j <numAlunos; j++) {
            // Pergunta o nome do aluno avaliado e registra ele
            System.out.println("Nome do Aluno");
            vetorNome[j] = input.nextLine();

            do {
                input.nextLine();
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
                    System.out.printf("Nota %d: ", i + 1);
                    nota =input.nextFloat(); 
                    
                    // Faz o calculo da nota com o peso
                    media += nota * vetorPesos[i];
                    
                    vetorMedia[i] += media;

                    // Verifica se as notas digitas foram corretas
                    System.out.println("Tem certeza destas notas?");
                    System.out.println("1 Sim ---- 2 Não");
                    resposta = input.nextInt();

                    System.out.println(vetorMedia[i]);

                } // Fim terceiro FOR    
                
            } while (resposta == 2);
            
        } // Fim segundo FOR
        // Printa a Lista
        System.out.println("Lista de Alunos:");
        for (int u = 0; u <numAlunos; u++) {

            System.out.println("Nome do Aluno(a): " + nomeAluno);
            //System.out.printf("Nome Avaliação %d: ", u + 1 + nomeAvaliacao + "Nota: " + nota);
            //System.out.printf("Média: " + media);
            System.out.println("Situação:");


             // Faz a verificação da Média
             if (media == notaMinima) {
                System.out.println(vetorNome[u] + " sua nota está na Média!");
            }else if (media < notaMinima) {
                System.out.println(vetorNome[u] + " sua nota está abaixo da Média!");
            } else {
                System.out.println(vetorNome[u] + " sua nota está a cima da Média!");
            }
            
            System.out.println(nomeAluno);
            // Faz a validação da média para saber se foi aprovado ou não e comenta o resultado
            if (media <= 2) {
                System.out.println("Reprovado!");
                System.out.printf("Sua média final é: %.2f ", + vetorMedia[u]); 
            } else if (media >= 2.1 && media <= 4.9){
                System.out.println("Fazer Substituta!");
                System.out.printf("Sua média final é: %.2f ", + vetorMedia[u]);
            } else {
                System.out.println("Aprovado!");
                System.out.printf("Sua média final é: %.2f " + vetorMedia[u]);
            }
        }

    } 
}
