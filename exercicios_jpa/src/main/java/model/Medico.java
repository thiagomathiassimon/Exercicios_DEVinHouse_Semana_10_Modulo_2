package model;

import javax.persistence.*;

import java.util.List;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
public class Medico {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long codigo;
    @Column
    private String nome;
    @Column
    private String crm;

    @OneToMany(mappedBy = "medico")
    List<Atendimento> atendimentos;

    public Medico(){}

    public Medico(Long codigo, String nome, String crm) {
        this.codigo = codigo;
        this.nome = nome;
        this.crm = crm;
    }

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCrm() {
        return crm;
    }

    public void setCrm(String crm) {
        this.crm = crm;
    }

    @Override
    public String toString() {
        return "Medico{" +
                "codigo=" + codigo +
                ", nome='" + nome + '\'' +
                ", crm='" + crm + '\'' +
                '}';
    }
}
