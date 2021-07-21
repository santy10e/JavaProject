package sistemagalenounl;
//@author santy 

import java.util.ArrayList;

public class HistoriaClinica {

    private String codigoHistoria;
    private static int codigoHistoriaClinica = 55;
    private ArrayList <CitaMedica> listadoCitaMedica;


    public HistoriaClinica() {
        
        this.codigoHistoria = Integer.toString(codigoHistoriaClinica);
        //System.out.println("Generacion codigo HC: " + this.codigoHistoria);
        codigoHistoriaClinica++;
    }
    
    public HistoriaClinica(ArrayList<CitaMedica> listaCitasMedicas) {

        this.codigoHistoria = Integer.toString(codigoHistoriaClinica);
        //System.out.println("Generacion codigo HC: " + this.codigoHistoria);
        codigoHistoriaClinica++;
    }

    public ArrayList<CitaMedica> getCitaMedica() {
        return listadoCitaMedica;
    }

    public void setCitaMedica(ArrayList<CitaMedica> citaMedica) {
        this.listadoCitaMedica = citaMedica;
    }

    public String getCodigoHistoria() {
        return codigoHistoria;
    }

    public void setCodigoHistoria(String codigoHistoria) {
        this.codigoHistoria = codigoHistoria;
    }
   public void setListadoCitasMedica(ArrayList <CitaMedica> listadoCitasMedica) {
   }
}
