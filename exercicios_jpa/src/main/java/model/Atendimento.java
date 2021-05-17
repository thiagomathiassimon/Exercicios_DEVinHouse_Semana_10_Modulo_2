package model;

import javax.persistence.*;

import java.sql.Time;
import java.sql.Timestamp;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
public class Atendimento {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long codigo;
    @ManyToOne
    @JoinColumn(name = "paciente")
    private Paciente paciente;
    @Column
    private String descricao;
    @ManyToOne
    @JoinColumn(name = "medico")
    private Medico medico;
    @Column
    private String situacao;
    @Column
    private Double valor;
    @Column
    private Timestamp data;

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Timestamp getData() {
        return data;
    }

    public void setData(Timestamp data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Atendimento{" +
                "codigo=" + codigo +
                ", paciente=" + paciente +
                ", descricao='" + descricao + '\'' +
                ", medico=" + medico +
                ", situacao='" + situacao + '\'' +
                ", valor=" + valor +
                ", data=" + data +
                '}';
    }
}
