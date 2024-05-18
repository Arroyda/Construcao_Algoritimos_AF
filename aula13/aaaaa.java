package aula13;

import java.util.Scanner;

public class aaaaa {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Vetor com algumas saudações armazenadas
        String[] saudacoesArmazenadas = {"oi", "olá", "hello", "hi"};

        // Solicita ao usuário que digite algo
        System.out.println("Digite algo:");
        String entradaUsuario = scanner.nextLine().toLowerCase(); // Converte para minúsculas para comparar sem diferenciação de caso
        
        boolean encontrado = false; // Variável para verificar se a entrada do usuário está presente no vetor
        
        // Percorre o vetor de saudações armazenadas
        for (String saudacao : saudacoesArmazenadas) {
            // Verifica se a entrada do usuário é igual a uma saudação armazenada
            if (entradaUsuario.equals(saudacao)) {
                encontrado = true;
                break; // Encerra o loop assim que encontrar uma correspondência
            }
        }

        // Se a entrada do usuário estiver presente no vetor, responde com "Olá"
        if (encontrado) {
            System.out.println("Olá!");
        } else {
            System.out.println("Entrada não reconhecida.");
        }
        
        scanner.close();
    }
}
