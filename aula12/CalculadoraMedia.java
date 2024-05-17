package aula12;


import java.util.Scanner;

public class CalculadoraMedia {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        float notaMinima;
        int numAlunos, numNotas;
        
        System.out.println("Qual a nota mínima?");
        notaMinima = input.nextFloat();
        
        System.out.println("Quantos alunos serão avaliados?");
        numAlunos = input.nextInt();
        
        System.out.println("Quantas notas serão inseridas? ");
        numNotas = input.nextInt();
        
        float[] vetorPesos = new float[numNotas];
        float[] vetorMedia = new float[numAlunos];
        String[] vetorNome = new String[numAlunos];        
        
        for (int l = 0; l < numNotas; l++) {
            System.out.printf("Valor Peso %d ", l + 1);
            vetorPesos[l] = input.nextFloat(); 
        } 
        
        input.nextLine(); // Limpar o buffer
        
        for (int j = 0; j < numAlunos; j++) {
            input.nextLine();
            System.out.println("Nome do Aluno");
            vetorNome[j] = input.nextLine();
            
            float media = 0;
            for (int i = 0; i < numNotas; i++) {
                System.out.printf("Nome da Avaliação %d: ", i + 1);
                String nomeAvaliacao = input.nextLine();
                
                System.out.printf("Nota %d: ", i + 1);
                float nota = input.nextFloat(); 
                
                media += nota * vetorPesos[i];
            } 
            
            vetorMedia[j] = media;
        } 
        input.nextLine();
        System.out.println("Lista de Alunos:");
        for (int u = 0; u < numAlunos; u++) {
            System.out.println("Nome do Aluno(a): " + vetorNome[u]);
            System.out.println("Média: " + vetorMedia[u]);
            
            if (vetorMedia[u] == notaMinima) {
                System.out.println(vetorNome[u] + " sua nota está na Média!");
            } else if (vetorMedia[u] < notaMinima) {
                System.out.println(vetorNome[u] + " sua nota está abaixo da Média!");
            } else {
                System.out.println(vetorNome[u] + " sua nota está acima da Média!");
            }
            
            if (vetorMedia[u] <= 2) {
                System.out.println("Reprovado!");
            } else if (vetorMedia[u] >= 2.1 && vetorMedia[u] <= 4.9) {
                System.out.println("Fazer Substituta!");
            } else {
                System.out.println("Aprovado!");
            }
        }
    } 
}
