package sistemagalenounl;
//@author santy

import java.util.ArrayList;
import java.util.Date;

public class CitaMedica {

    Paciente paciente;
    private ArrayList<Medico> listaMedico;
    private String duracion;
    private double costo;
    private Date fecha;

    public CitaMedica(ArrayList<Medico> listaMedico, Paciente paciente, String duracion) {
        this.listaMedico = listaMedico;
        this.paciente = paciente;
        this.duracion = duracion;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public String getDuracion() {
        return duracion;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    public ArrayList<Medico> getListaMedico() {
        return listaMedico;
    }

    public void setListaMedico(ArrayList<Medico> listaMedico) {
        this.listaMedico = listaMedico;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\nPaciente:");
        sb.append(paciente.getCodigoPaciente()).append(paciente.getNombre());
        sb.append("numero medicos:").append(listaMedico.size());
        sb.append("\nNombre: ");
        sb.append(paciente.getNombre());
        return sb.toString();
    }

    public void cambiarMedicosDeCita(CitaMedica cita, Medico medico) {
        System.out.println("Cambiar los medicos de una cita medica");
        ArrayList<Medico> listaNuevaDeMedicos = new ArrayList<>();
        listaNuevaDeMedicos.add(medico);
        cita.setListaMedico(listaNuevaDeMedicos);
        System.out.println("Presentar los medicos de la lista");
        for (Medico m : listaNuevaDeMedicos) {
            System.out.println("Medico" + m.getNombre() + m.getEspecialidad() + m.getCedula());
        }
    }

    public void agregarMedicoaCitaM(Medico medico) {
        System.out.println("Agregando medicos a la cita medica");
        ArrayList<Medico> listanuevadeMedicos = new ArrayList<>();
        listanuevadeMedicos.add(medico);
        this.listaMedico.add(medico);
        for (Medico m : listanuevadeMedicos) {
            System.out.println("Medico" + m.getNombre() + m.getEspecialidad() + m.getCedula());
        }
    }

    public void Descuento() {

    }

    public void citasEnMismoDia(Medico nuevoMedico) {
        int cont = 0;
        for (Medico medico : listaMedico) {
            System.out.println("Listado de medicos en la cita");
            System.out.println("Medicos --->" + medico.getNombre());
            if (medico.getNombre().equals(nuevoMedico)) {
                System.out.println("Es el mismo medico");
                cont++;
            }
            if (cont > 2) {
                System.out.println("No puedes registrar la cita porque es el mismo medico");
            }
            this.listaMedico.forEach(m -> System.out.println("Medico" + m.getNombre()));
        }

    }
}
