package sistemagalenounl;

//@author santy
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class SistemaGalenoUNL {

    static Medico medico;

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        int opcion, numMedicos = 0;
        ArrayList<CitaMedica> listaCitasMedicas = new ArrayList<>();
        ArrayList<String> AllCita = new ArrayList<>();

        try {
            do {
                System.out.println("Menu");
                System.out.println("1. Crear una cita medica");
                System.out.println("2. Cambiar un doctor que atiende una cita medica");
                System.out.println("3. Listar las citas medicas con sus respectivos pacientes y doctores");
                System.out.println("4. Eliminar cita medica");
                System.out.println("5. Salir");
                opcion = entrada.nextInt();
                switch (opcion) {
                    case 1:// Crear una cita Medica
                        System.out.println("Agregar el paciente");
                        entrada.nextLine();
                        Paciente paciente = new Paciente(entrada.nextLine());

                        System.out.println("Cuanto medicos quiere ingresar");
                        numMedicos = entrada.nextInt();
                        ArrayList<Medico> listaMedico = new ArrayList<>();
                        for (int i = 0; i <= numMedicos - 1; i++) {
                            System.out.println("Agregar un doctor a la cita medica");
                            entrada.nextLine();

                            listaMedico.add(medico = new Medico(entrada.nextLine(), entrada.nextLine(), entrada.next()));
                        }

                        System.out.println("Agregar duracion de la cita");
                        entrada.nextLine();
                        CitaMedica citaMedica = new CitaMedica(listaMedico, paciente, entrada.nextLine());
                        listaCitasMedicas.add(citaMedica);

                        // REVISAR ->
                        // listaCitasMedicas.get(0).citasEnMismoDia(citaMedica, medico);
                        break;

                    case 2:// Cambiar un doctor que atiende una cita medica
                        System.out.println("Existen creadas " + listaCitasMedicas.size() + " Citas medicas en Memoria");
                        int contador2 = -1;
                        int indice;

                        for (CitaMedica cita : listaCitasMedicas) {
                            contador2++;
                            System.out.println("Nombre Paciente :  " + cita.getPaciente().getNombre() + "   su identificativo es : " + contador2);
                        }

                        System.out.println("Escriba el identificativo");
                        int identificativo = entrada.nextInt();

                        // if 
                        
                        if (identificativo == contador2) {
                            for (CitaMedica cita : listaCitasMedicas) {
                                System.out.println("");
                                for (Medico m : cita.getListaMedico()) {
                                    System.out.println("Nombre del Medico:   " + cita.getPaciente().getNombre()+ "   Su indice es: " + contador2);
                                }

                                System.out.println("==================================================");
                                System.out.println("Ingrese el indice");
                                indice = entrada.nextInt();
                                for (int i = 0; i < 4; i++) {
                                    if (indice == i) {
                                        System.out.println("Ingrese el nuevo Doctor");
                                        entrada.nextLine();
                                        cita.getListaMedico().remove(indice);
                                        cita.getListaMedico().add(indice, medico = new Medico(entrada.nextLine(), entrada.nextLine(), entrada.nextLine()));
                                        //listaMedico.set(indice, medico = new Medico(entrada.nextLine(), entrada.nextLine(), entrada.nextLine()));
                                    }
                                }
                                contador2 = -1;
                            }
                        }
                        break;

                    case 3:// Listar las citas medicas
                        System.out.println("Existen creadas " + listaCitasMedicas.size() + " Citas medicas en Memoria");
                        int contador = 0;
                        System.out.println("  Cita   \tDuracion\t\tPaciente\t\tMedico");
                        System.out.println(
                                "___________________________________________________________________________________________");
                        for (CitaMedica cita : listaCitasMedicas) {
                            contador++;

                            System.out.println(
                                    "|  " + contador + "\t" + cita.getDuracion() + "\t\t" + cita.getPaciente().getNombre());
                            for (Medico m : cita.getListaMedico()) {
                                System.out.println("|" + "\t\t\t\t\t" + m.getNombre());
                            }
                            System.out.println(
                                    "___________________________________________________________________________________________");
                        }

                        break;

                    case 4:// Eliminar una cita medica
                        int indice2;
                        System.out.println("Eliminando cita Medica");
                        System.out.println("Existen creadas " + listaCitasMedicas.size() + " Citas medicas en Memoria");
                        int contador3 = -1;
                        /*
					 * for (CitaMedica citam : listaCitasMedicas) { //contador2++;
					 * citam.getListaMedico().forEach(m -> System.out.println("Nombre del medico:" +
					 * m.getNombre())); }
                         */
                        for (CitaMedica cita : listaCitasMedicas) {
                            System.out.println("");
                            for (Medico m : cita.getListaMedico()) {
                                contador3++;
                                System.out.println("Nombre del Medico:   " + m.getNombre() + "   Su indice es: " + contador3);
                            }
                            System.out.println("==================================================");
                            System.out.println("Ingrese el indice");
                            indice2 = entrada.nextInt();
                            for (int i = 0; i < listaCitasMedicas.size(); i++) {
                                if (indice2 == i) {
                                    listaCitasMedicas.remove(indice2);
                                }
                            }
                        }
                        break;
                    default:
                        System.out.println("Gracias por usar");
                }
            } while (opcion < 5);

        } catch (InputMismatchException e) {
            System.out.println("Error: Ingreso una letra en vez de un numero entero");
        } catch (Exception ex) {
            System.out.println("Error en el programa");
        }

    }

}
/*
 * Empleado empleado = new Empleado(200.50, "Juan Perez", "05-07-2021");
 * System.out.println("El empleado " + empleado.getNombre() + "y su sueldo es: "
 * + empleado.getSalario() + " con fecha: " + empleado.getFechaNacimiento());
 * HistoriaClinica hClinica = new HistoriaClinica(); HistoriaClinica hClinica2 =
 * new HistoriaClinica(); HistoriaClinica hClinica3 = new HistoriaClinica(); //
 * CREACION PACIENTES Paciente pacienteJuan = new Paciente("Juan"); Paciente
 * pacientePablo = new Paciente("Pablo "); Paciente pacienteElena = new
 * Paciente("Elena "); Paciente pacienteAlba = new
 * Paciente("Alba Nieto Fernandez"); Paciente pacienteJavier = newcitaMedica
 * Paciente("JAvier Andes Sarango Sarango");
 * 
 * pacienteJuan.getCodigoPaciente();
 * 
 * System.out.println("Codigo paciente: " + pacienteJuan.getCodigoPaciente());
 * System.out.println("Historia clinica: " + hClinica.getCodigoHistoria());
 * 
 * System.out.println("Codigo paciente: " + pacientePablo.getCodigoPaciente());
 * System.out.println("Historia clinica: " + hClinica2.getCodigoHistoria());
 * 
 * System.out.println("Codigo paciente: " + pacienteElena.getCodigoPaciente());
 * System.out.println("Historia clinica: " + hClinica3.getCodigoHistoria());
 * 
 * System.out.println("========================================================"
 * ); System.out.println("Probando la Creando cita medica"); Medico MedPediatra
 * = new Medico("Medico Juan", "Pediatra", "1100327674"); Medico MedCirujano =
 * new Medico("Medico Ana", "Cirujano", "11021749342");
 * 
 * ArrayList<CitaMedica> listaCitasM = new ArrayList<>();
 * 
 * //LIsta Medico UNO ArrayList<Medico> listadoMedicos = new ArrayList<>();
 * listadoMedicos.add(MedCirujano); listadoMedicos.add(MedPediatra);
 * 
 * //Lista MEDICo DOS ArrayList<Medico> listadoMedicosDos = new ArrayList<>();
 * listadoMedicosDos.add(MedCirujano);
 * 
 * // Lista medico tres ArrayList<Medico> listaMedicoTres = new ArrayList<>();
 * listaMedicoTres.add(new Medico("Dr. Angel", "Oncologia", "1129792372"));
 * listaMedicoTres.add(new Medico("Dra. Rosa", "Ginecologa", "0923938873"));
 * 
 * // Lista Medico Personalizado ArrayList<Medico> listaM = new ArrayList<>();
 * listaM.add(new Medico("Bryan Encalada Mejia", "Odontolo", "1105844995"));
 * 
 * //LIsta Medico JAVIER ArrayList<Medico> listaMedicoCinco = new ArrayList<>();
 * listaMedicoCinco.add(new Medico("Dr. Juan Perez", "Cirujano", "0923294983"));
 * 
 * //nCITAS MEDICAS CitaMedica citaMedicaUno = new CitaMedica(listadoMedicos,
 * pacienteElena, "30 minutos"); CitaMedica citaMedicaDos = new
 * CitaMedica(listadoMedicosDos, pacientePablo, "20 minutos"); CitaMedica
 * citaMedica2A = new CitaMedica(listaM, pacienteAlba, "25 minutos"); CitaMedica
 * citaMedicaCinco = new CitaMedica(listaMedicoCinco, pacienteJavier,
 * "40 minutos");
 * 
 * //AGREAGANDO LISTAS MEDICOS listaCitasM.add(citaMedicaUno);
 * listaCitasM.add(citaMedicaDos); listaCitasM.add(citaMedica2A);
 * listaCitasM.add(citaMedicaCinco);
 * 
 * System.out.println("Existen creadas " + listaCitasM.size() +
 * " Citas medicas en Memoria"); int contador = 1; System.out.println(
 * "____________________________________________________________________________________________________"
 * );
 * System.out.println("|  Cita   |\tDuracion\t|\tPaciente\t \t|\tMedicos \t\t|"
 * ); System.out.println(
 * "____________________________________________________________________________________________________"
 * ); for (CitaMedica citaMedica : listaCitasM) { for (Medico m :
 * citaMedica.getListaMedico()) {
 * System.out.println("|"+"  "+contador+"        |"+"   "+citaMedica.getDuracion
 * ()+"\t|"+"   "+citaMedica.getPaciente().getNombre()+"\t"+
 * citaMedica.getListaMedico().toString()+m.getNombre()); }
 * 
 * } contador++; for (CitaMedica citaMedica : listaCitasM) {
 * 
 * System.out.println("--->Presentando datos de las Citas Medicas " +
 * citaMedica.getDuracion()); System.out.println("Codigo del Paciente: " +
 * citaMedica.getPaciente().getCodigoPaciente());
 * System.out.println("Nombre Paciente: " +
 * citaMedica.getPaciente().getNombre());
 * System.out.println("\tLa cita medica tiene " +
 * listaCitasM.get(contador).getListaMedico().size() +
 * " Médicos que le han atendido:"); contador++;
 * 
 * for (Medico m : citaMedica.getListaMedico()) {
 * System.out.println("\t\tMedico: " + m.getNombre() + " Especialidad: " +
 * m.getEspecialidad() + " Cedula del Medico: " + m.getCedula()); } } {
 * 
 * }
 */
