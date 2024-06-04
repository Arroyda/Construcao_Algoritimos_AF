package Aula12;

import java.util.Scanner;

public class CalculadoraMedia1 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        float notaMinima; // Armazena o valor da nota minima 
        float nota; // Armazena o valor da nota 
        String nomeAvaliacao = ""; // Armazena o Nome da Avaliação
        int numAlunos, numNotas; // Armazena numero de alunos e notas
        
        // Pergunta qual a nota minima e armazena ela 
        System.out.println("Qual a nota mínima?");
        notaMinima = input.nextFloat();
        
        // Pergunta quantos alunos serão avaliados e armazena eles 
        System.out.println("Quantos alunos serão avaliados?");
        numAlunos = input.nextInt();
        
         // Pergunta quantas notas serão avaliados e armazena elas 
        System.out.println("Quantas notas serão inseridas? ");
        numNotas = input.nextInt();
        
        // Cria o vetor de Pesos
        float[] vetorPesos = new float[numNotas];

        // Cria o vetor de Medias
        float[] vetorMedia = new float[numAlunos];

        // Cria o vetor de Nomes
        String[] vetorNome = new String[numAlunos];        
        
        // Primeiro FOR
        for (int l = 0; l < numNotas; l++) {
            // Pergunta o valor dos Pesos e armazena eles no Vetor
            System.out.printf("Valor Peso %d ", l + 1);
            vetorPesos[l] = input.nextFloat(); 
         } // Fim Primeiro FOR
        
        input.nextLine(); // Limpar o buffer
        
        //  Inicio Segundo FOR
        for (int j = 0; j < numAlunos; j++) {
            input.nextLine(); // Limpar o buffer

            // Pergunta o Nome do aluno e armazena no Vetor
            System.out.println("Nome do Aluno");
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
                
                // Faz o calculo da media
                media += nota * vetorPesos[i];
            } // Fim Terceiro FOR 
            
            // Registra a Media dentro do Vetor
            vetorMedia[j] = media;
        } 

        input.nextLine(); // Limpar o buffer

        // Inicia a Lista de Alunos com os Resultados
        System.out.println("Lista de Alunos:");

        // Inicio Quarto FOR
        for (int u = 0; u < numAlunos; u++) {
            // Exibe o Nome do Aluno e a Media 
            System.out.println("Nome do Aluno(a): " + vetorNome[u]);
            System.out.println("Média: " + vetorMedia[u]);
            
            // Verificação do estado da Media 
            if (vetorMedia[u] == notaMinima) {
                System.out.println(vetorNome[u] + " sua nota está na Média!");
            } else if (vetorMedia[u] < notaMinima) {
                System.out.println(vetorNome[u] + " sua nota está abaixo da Média!");
            } else {
                System.out.println(vetorNome[u] + " sua nota está acima da Média!");
            }
            
            // Verifica se está aprovado ou não
            if (vetorMedia[u] <= 2) {
                System.out.println("Reprovado!");
            } else if (vetorMedia[u] >= 2.1 && vetorMedia[u] <= 4.9) {
                System.out.println("Fazer Substituta!");
            } else {
                System.out.println("Aprovado!");
            }
        } // Fim Quarto FOR
    } 
}
