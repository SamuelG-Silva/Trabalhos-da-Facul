package trabalhoArvoreBinaria;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArvoreLivros catalogo = new ArvoreLivros();
        Scanner scanner = new Scanner(System.in);

        catalogo.inserir(new Livro("Dom Casmurro", "Machado de Assis", 1899));
        catalogo.inserir(new Livro("O Alquimista", "Paulo Coelho", 1988));
        catalogo.inserir(new Livro("Harry Potter e a Pedra Filosofal", "J.K. Rowling", 1997));
        catalogo.inserir(new Livro("O Senhor dos Anéis", "J.R.R. Tolkien", 1954));
        catalogo.inserir(new Livro("O Cortiço", "Aluísio Azevedo", 1890));
        catalogo.inserir(new Livro("O Pequeno Príncipe", "Antoine de Saint-Exupéry", 1943));
        catalogo.inserir(new Livro("A Hora da Estrela", "Clarice Lispector", 1977));
        catalogo.inserir(new Livro("Grande Sertão: Veredas", "João Guimarães Rosa", 1956));

        int opcao = -1;

        while (opcao != 0) {
            System.out.println("\n=== CATALOGO DE LIVROS ===");
            System.out.println("1. Inserir Livro");
            System.out.println("2. Buscar por Título");
            System.out.println("3. Remover Livro");
            System.out.println("4. Exibir Em-Ordem (Alfabética)");
            System.out.println("5. Exibir Pré-Ordem");
            System.out.println("6. Exibir Pós-Ordem");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");

            try {
                opcao = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Opção inválida! Digite um número.");
                continue;
            }

            switch (opcao) {
                case 1:
                    System.out.print("Digite o título do livro: ");
                    String titulo = scanner.nextLine();
                    System.out.print("Digite o autor: ");
                    String autor = scanner.nextLine();
                    System.out.print("Digite o ano de publicação: ");
                    int ano;
                    try {
                        ano = Integer.parseInt(scanner.nextLine());
                    } catch (NumberFormatException e) {
                        System.out.println("Ano inválido. Operação cancelada.");
                        break;
                    }
                    catalogo.inserir(new Livro(titulo, autor, ano));
                    System.out.println("Livro inserido com sucesso!");
                    break;
                    

                case 2:
                    System.out.print("Digite o título para buscar: ");
                    String buscaTitulo = scanner.nextLine();
                    Livro livroEncontrado = catalogo.buscar(buscaTitulo);
                    if (livroEncontrado != null) {
                        System.out.println("\nLivro Encontrado:");
                        System.out.println(livroEncontrado);
                    } else {
                        System.out.println("Livro não encontrado no catálogo.");
                    }
                    break;
                    

                case 3:
                    System.out.print("Digite o título do livro a ser removido: ");
                    String removerTitulo = scanner.nextLine();
                    
                    if (catalogo.buscar(removerTitulo) != null) {
                        catalogo.remover(removerTitulo);
                        System.out.println("Livro removido com sucesso!");
                    } else {
                        System.out.println("Livro não encontrado para remoção.");
                    }
                    break;
                    

                case 4:
                    System.out.println("\n--- Exibição Em-Ordem ---");
                    catalogo.exibirEmOrdem();
                    break;
                    

                case 5:
                    System.out.println("\n--- Exibição Pré-Ordem ---");
                    catalogo.exibirPreOrdem();
                    break;

    
                case 6:
                    System.out.println("\n--- Exibição Pós-Ordem ---");
                    catalogo.exibirPosOrdem();
                    break;
                    

                case 0:
                    System.out.println("Saindo do sistema... Até logo!");
                    break;
                    

                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        }
        scanner.close();
    }
}
