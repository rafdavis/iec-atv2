package br.com.atv2IEC.model;

public class Disciplina {
    private Integer id;
    private String nome;
    private String professor;

    public Disciplina() {}
    public Disciplina(Integer id, String nome, String professor) {
        this.id = id;
        this.nome = nome;
        this.professor = professor;
    }

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getProfessor() { return professor; }
    public void setProfessor(String professor) { this.professor = professor; }
}
