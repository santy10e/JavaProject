package sistemagalenounl;
//@author santy 

public class Paciente extends Persona {

    private int codigoPaciente;
    private static int pacienteIncremento = 1;

    public Paciente(String nombrePaciente) {
        this.codigoPaciente = (codigoPaciente + pacienteIncremento);
        //System.out.println("Paciente  " + nombrePaciente + " tiene el código aleatorio: " + codigoPaciente);
        pacienteIncremento++;
        this.setNombre(nombrePaciente);
    }

    public int getCodigoPaciente() {
        return codigoPaciente;
    }

    public void setCodigoPaciente(int codigoPaciente) {
        this.codigoPaciente = codigoPaciente;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\nCodigoPaciente: ");
        sb.append(codigoPaciente);
        sb.append("\nNombre: ");
        sb.append(this.getNombre());
        return sb.toString();
    }

}
