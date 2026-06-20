package trabalhoArvoreBinaria;

public class ArvoreLivros {
    private No raiz;

    public ArvoreLivros() {
        this.raiz = null;
    }

    // --- INSERÇÃO ---
    public void inserir(Livro livro) {
        raiz = inserirRecursivo(raiz, livro);
    }

    private No inserirRecursivo(No atual, Livro livro) {
        if (atual == null) {
            return new No(livro);
        }

        if (livro.compareTo(atual.livro) < 0) {
            atual.esquerda = inserirRecursivo(atual.esquerda, livro);
        } else if (livro.compareTo(atual.livro) > 0) {
            atual.direita = inserirRecursivo(atual.direita, livro);
        }
        return atual;
    } 

    // --- BUSCA ---
    public Livro buscar(String titulo) {
        No resultado = buscarRecursivo(raiz, titulo);
        return (resultado != null) ? resultado.livro : null;
    }

    private No buscarRecursivo(No atual, String titulo) {
        if (atual == null || atual.livro.getTitulo().equalsIgnoreCase(titulo)) {
            return atual;
        }

        if (titulo.compareToIgnoreCase(atual.livro.getTitulo()) < 0) {
            return buscarRecursivo(atual.esquerda, titulo);
        }

        return buscarRecursivo(atual.direita, titulo);
    }

    // --- REMOÇÃO ---
    public void remover(String titulo) {
        raiz = removerRecursivo(raiz, titulo);
    }

    private No removerRecursivo(No atual, String titulo) {
        if (atual == null) {
            return null;
        }

        if (titulo.compareToIgnoreCase(atual.livro.getTitulo()) < 0) {
            atual.esquerda = removerRecursivo(atual.esquerda, titulo);
        } else if (titulo.compareToIgnoreCase(atual.livro.getTitulo()) > 0) {
            atual.direita = removerRecursivo(atual.direita, titulo);
        } else {
            // Encontrou o nó a ser removido!

            // Caso 1: nó folha
            if (atual.esquerda == null && atual.direita == null) {
                return null;
            }

            // Caso 2: nó com um filho
            if (atual.esquerda == null) {
                return atual.direita;
            } else if (atual.direita == null) {
                return atual.esquerda;
            }

            // Caso 3: Nó com dois filhos
            
            // Encontra o sucessor em-ordem (menor nó da subárvore direita)
            No sucessor = encontrarMinimo(atual.direita);
            // Substitui o dado do nó atual pelo dado do sucessor
            atual.livro = sucessor.livro;
            // Remove o sucessor da subárvore direita
            atual.direita = removerRecursivo(atual.direita, sucessor.livro.getTitulo());
        }
        return atual;
    }

    private No encontrarMinimo(No atual) {
        while (atual.esquerda != null) {
        	atual = atual.esquerda;
        }
        return atual;
    }

    // --- PERCURSOS ---
    
    // Em-ordem
    public void exibirEmOrdem() {
        if (raiz == null) System.out.println("Árvore vazia.");
        exibirEmOrdemRecursivo(raiz);
        System.out.println();
    }

    private void exibirEmOrdemRecursivo(No atual) {
        if (atual != null) {
            exibirEmOrdemRecursivo(atual.esquerda);
            System.out.println(atual.livro);
            exibirEmOrdemRecursivo(atual.direita);
        }
    }

    // Pré-ordem
    public void exibirPreOrdem() {
        if (raiz == null) System.out.println("Árvore vazia.");
        exibirPreOrdemRecursivo(raiz);
        System.out.println();
    }

    private void exibirPreOrdemRecursivo(No atual) {
        if (atual != null) {
            System.out.println(atual.livro.getTitulo() + " ");
            exibirPreOrdemRecursivo(atual.esquerda);
            exibirPreOrdemRecursivo(atual.direita);
        }
    }

    // Pós-ordem
    public void exibirPosOrdem() {
        if (raiz == null) System.out.println("Árvore vazia.");
        exibirPosOrdemRecursivo(raiz);
        System.out.println();
    }

    private void exibirPosOrdemRecursivo(No atual) {
        if (atual != null) {
            exibirPosOrdemRecursivo(atual.esquerda);
            exibirPosOrdemRecursivo(atual.direita);
            System.out.println(atual.livro.getTitulo() + " ");
        }
    }
}
