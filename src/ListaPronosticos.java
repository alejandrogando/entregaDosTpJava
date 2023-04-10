import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class ListaPronosticos {
    private ArrayList<Pronostico> pronosticos;
    private String nombreArchivo;

    public ListaPronosticos(ArrayList<Pronostico> pronosticos, String nombreArchivo) {
        this.pronosticos = pronosticos;
        this.nombreArchivo = nombreArchivo;
    }
    public ListaPronosticos(){
        this.pronosticos = new ArrayList<>();
        this.nombreArchivo = " ";
    }

    public ArrayList<Pronostico> getPronosticos() {
        return pronosticos;
    }

    public Pronostico getPronostico(int idPronostico) {
        Pronostico retorno = null;

        for (Pronostico pro : this.getPronosticos()) {
            if (pro.getId() == idPronostico) {
                retorno = pro;
                break;
            }
        }
        return retorno;
    }

    public void setPronosticos(ArrayList<Pronostico> pronosticos) {
        this.pronosticos = pronosticos;
    }

    public String getNombreArchivo() {
        return nombreArchivo;
    }

    public void setNombreArchivo(String nombreArchivo) {
        this.nombreArchivo = nombreArchivo;
    }

    public void addPronostico(Pronostico pronostico) {
        this.getPronosticos().add(pronostico);
    }

    public void removePronostico(Pronostico pronostico) {
        this.getPronosticos().remove(pronostico);
    }


    public void cargaDeArchivo(int idPart, ListaEquipos listaEquipos, ListaPartidos listaPartidos) {
        String datosPronostico;
        String vectorPronostico[];


        int fila = 0;
        try {
            Scanner scan = new Scanner(new File(this.getNombreArchivo()));
            scan.useDelimiter("\n");

            while (scan.hasNext()) {
                datosPronostico = scan.next();
                fila++;
                if (fila == 1)
                    continue;
                vectorPronostico = datosPronostico.split(",");

                int idPronostico = Integer.parseInt(vectorPronostico[0]);
                int idParticipante = Integer.parseInt(vectorPronostico[1]);
                int idPartido = Integer.parseInt(vectorPronostico[2]);
                int idEquipo = Integer.parseInt(vectorPronostico[3]);
                char resultado = vectorPronostico[1].charAt(0);

                if(idParticipante == idPart){
                    Partido partido = listaPartidos.getPartido(idPartido);
                    Equipo equipo = listaEquipos.getEquipo(idEquipo);
                    Pronostico pronostico = new Pronostico(idPronostico,equipo,partido,resultado);
                    this.addPronostico(pronostico);
                }





            }
        } catch (IOException ex) {
            System.out.println("Mensaje" + ex.getMessage());
        }
    }

}
