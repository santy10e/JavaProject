package Controlador;

 // @author "Santiago Tene"
import Modelo.ModeloPersona;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


public class ControladorPersonas {
    
    private ModeloPersona edad;
    private ModeloPersona lista[];
    

    public ModeloPersona getEdad() {
        if (edad == null) {
            edad = new ModeloPersona();
        }
        return edad;
    }

    public void setEdad(ModeloPersona edad) {
        this.edad = edad;
    }

    public ModeloPersona[] getLista() {
        return lista;
    }

    public void setLista(ModeloPersona[] lista) {
        this.lista = lista;
    }
    
    
    
    public static Integer calcularEdad(String fecha){
   Date fechaNac=null;
       try {
           fechaNac = new SimpleDateFormat("dd-MM-yyyy").parse(fecha);
       } catch (Exception ex) {
           System.out.println("Error:"+ex);
       }
       Calendar fechaNacimiento = Calendar.getInstance();
       Calendar fechaActual = Calendar.getInstance();
       fechaNacimiento.setTime(fechaNac);
       int año = fechaActual.get(Calendar.YEAR)- fechaNacimiento.get(Calendar.YEAR);
       int mes =fechaActual.get(Calendar.MONTH)- fechaNacimiento.get(Calendar.MONTH);
       int dia = fechaActual.get(Calendar.DATE)- fechaNacimiento.get(Calendar.DATE);
       if(mes<0 || (mes==0 && dia<0)){ // se formatea la fecha dependiendo del mes y del dia
           año--;
       }
        System.out.println("fecha" + año);
       return año;
   }
    
    
    
    

}
