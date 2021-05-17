package dto;

public class PacientesPorMesDeNascimentoDTO {

    private int mesDeNascimento;
    private long quantidadeDePacientesPorMesDeNascimento;

    public PacientesPorMesDeNascimentoDTO(int mesDeNascimento, long quantidadeDePacientesPorMesDeNascimento) {
        this.mesDeNascimento = mesDeNascimento;
        this.quantidadeDePacientesPorMesDeNascimento = quantidadeDePacientesPorMesDeNascimento;
    }

    public int getMesDeNascimento() {
        return mesDeNascimento;
    }

    public void setMesDeNascimento(int mesDeNascimento) {
        this.mesDeNascimento = mesDeNascimento;
    }

    public long getQuantidadeDePacientesPorMesDeNascimento() {
        return quantidadeDePacientesPorMesDeNascimento;
    }

    public void setQuantidadeDePacientesPorMesDeNascimento(long quantidadeDePacientesPorMesDeNascimento) {
        this.quantidadeDePacientesPorMesDeNascimento = quantidadeDePacientesPorMesDeNascimento;
    }

    @Override
    public String toString() {
        return "PacientesPorMesDeNascimentoDTO{" +
                "mesDeNascimento=" + mesDeNascimento +
                ", quantidadeDePacientesPorMesDeNascimento=" + quantidadeDePacientesPorMesDeNascimento +
                '}';
    }
}
