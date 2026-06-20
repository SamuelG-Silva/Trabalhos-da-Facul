package trabalhoArvoreBinaria;

public class Livro implements Comparable<Livro> {
    private String titulo;
    private String autor;
    private int ano;

    public Livro(String titulo, String autor, int ano) {
        this.titulo = titulo;
        this.autor = autor;
        this.ano = ano;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public int getAno() {
        return ano;
    }

    @Override
    public int compareTo(Livro outro) {
        return this.titulo.compareToIgnoreCase(outro.getTitulo()); // Comparação alfabética ignorando maiúsculas/minúsculas
    }

    @Override
    public String toString() {
        return "Livro: '" + titulo + "' | Autor: " + autor + " | Ano: " + ano;
    }
}