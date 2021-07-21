package sistemagalenounl;
//@author santy 

import java.util.Date;

public class Empleado extends Persona {

    private double salario;

    public Empleado(double salario) {
        this.salario = salario;
    }

    public Empleado(double salario,String nombre, String fechaNacimiento) {
        this.salario = salario;
        super.setNombre(nombre);
        super.setFechaNacimiento(fechaNacimiento);
    }
    
        public Empleado(String nombre, String fechaNacimiento) {
        super.setNombre(nombre);
        super.setFechaNacimiento(fechaNacimiento);
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }
    
    

}
