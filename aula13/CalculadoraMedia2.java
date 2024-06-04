package Aula13;

import java.util.Scanner;

public class CalculadoraMedia2 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        float notaMinima;           // Armazena o valor da nota minima 
        float nota;                 // Armazena o valor da nota 
        String nomeAvaliacao = "";  // Armazena o Nome da Avaliação
        String nome = " ";          // Armazena o Nome do Aluno
        boolean encontrado = false; // Variavel para verificar a entrada do usuario 
        int numAlunos, numNotas;    // Armazena numero de alunos e notas
        
        // Pergunta qual a nota minima e armazena ela 
        System.out.println("Qual a nota mínima?");
        notaMinima = input.nextFloat();
        
        // Pergunta quantos alunos serão avaliados e armazena eles 
        System.out.println("Quantos alunos serão avaliados?");
        numAlunos = input.nextInt();
        
         // Pergunta quantas notas serão avaliadas e armazena elas 
        System.out.println("Quantas notas serão inseridas? ");
        numNotas = input.nextInt();
        
        // Cria a matriz para armazenar as notas de todos os alunos
        float[][] matrizNotas = new float[numAlunos][numNotas]; // Apenas as notas, nomes separados
        
        // Cria o vetor de Pesos
        float[] vetorPesos = new float[numNotas];

        // Cria o vetor de Medias
        float[] vetorMedia = new float[numAlunos];

        // Cria o vetor de Nomes
        String[] vetorNome = new String[numAlunos];        
        
        // Primeiro FOR
        for (int l = 0; l < numNotas; l++) {
            // Pergunta o valor dos Pesos e armazena eles no Vetor
            System.out.printf("Valor Peso %d: ", l + 1);
            vetorPesos[l] = input.nextFloat(); 
         } // Fim Primeiro FOR
        
        input.nextLine(); // Limpar o buffer
        
        //  Inicio Segundo FOR
        for (int j = 0; j < numAlunos; j++) {
            // Pergunta o Nome do aluno e armazena no Vetor
            System.out.printf("Nome do Aluno %d: ", j + 1);
            vetorNome[j] = input.nextLine();
            
            float media = 0; // Limpar a variavel

            // Inicio Terceiro FOR
            for (int i = 0; i < numNotas; i++) {
                // Pergunta o Nome da Avaliação e armazena na variavel
                System.out.printf("Nome da Avaliação %d: ", i + 1);
                nomeAvaliacao = input.nextLine();
                
                // Pergunta a Nota do Aluno e armazena ela na variavel
                System.out.printf("Nota %d: ", i + 1);
                nota = input.nextFloat(); 
                
                // Armazena a nota na matriz de notas
                matrizNotas[j][i] = nota;
                
                // Faz o calculo da media
                media += nota * vetorPesos[i];
                input.nextLine(); // Limpar o buffer
            } // Fim Terceiro FOR 
            
            // Armazena a média no vetor de medias
            vetorMedia[j] = media;
        } 

        // Inicia a Lista de Alunos com os Resultados
        System.out.println("Lista de Alunos:");

        // Inicio Quarto FOR
        for (int u = 0; u < numAlunos; u++) {
            System.out.println(vetorNome[u]);
        } // Fim Quarto FOR

        // Loop para perguntar ao usuário se ele deseja consultar a nota de um aluno em especial
        String opcao;
        do {
            System.out.println("Deseja consultar a nota de um aluno? (S/N)");
            opcao = input.nextLine();

            if (opcao.equalsIgnoreCase("S")) {
                encontrado = false; // Define como falso inicialmente

                // Solicita que o usuário digite o nome do aluno
                System.out.println("Digite o Nome do Aluno:");
                String entradaUsuario = input.nextLine();

                // Percorre o vetor de nomes para verificar se a entrada do usuário corresponde a algum nome
                for (int t = 0; t < numAlunos; t++) {
                    if (entradaUsuario.equalsIgnoreCase(vetorNome[t])) {
                        encontrado = true; // Define como verdadeiro se o nome for encontrado

                        // Exibe o Nome do Aluno(a) e a Média
                        System.out.println("Nome do Aluno(a): " + vetorNome[t]);
                        System.out.println("Média: " + vetorMedia[t]);

                        // Verifica o estado da média
                        if (vetorMedia[t] == notaMinima) {
                            System.out.println(vetorNome[t] + " sua nota está na Média!");
                        } else if (vetorMedia[t] < notaMinima) {
                            System.out.println(vetorNome[t] + " sua nota está abaixo da Média!");
                        } else {
                            System.out.println(vetorNome[t] + " sua nota está acima da Média!");
                        }

                        // Verifica se está aprovado ou não
                        if (vetorMedia[t] <= 2) {
                            System.out.println("Reprovado!");
                        } else if (vetorMedia[t] >= 2.1 && vetorMedia[t] <= 4.9) {
                            System.out.println("Fazer Substituta!");
                        } else {
                            System.out.println("Aprovado!");
                        }

                        // Sai do loop assim que o nome for encontrado
                        break;
                    }
                }

                // Se o nome do aluno não for encontrado, informa ao usuário
                if (!encontrado) {
                    System.out.println("Nome não encontrado, por favor digite corretamente!");
                }
            }
        } while (!opcao.equalsIgnoreCase("N")); // Continua o loop enquanto o usuário não escolher encerrar o programa

        // Fechar o Scanner
        input.close();
    } 
}
