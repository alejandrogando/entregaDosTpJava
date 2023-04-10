import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class ListaParticipantes {
    private ArrayList<Participante> listaDeParticipantes;
    private String nombreArchivo;

    public ListaParticipantes(){
        this.listaDeParticipantes = new ArrayList<>();
        this.nombreArchivo = "";
    }

    public ArrayList<Participante> getListaDeParticipantes() {
        return listaDeParticipantes;
    }

    public void setListaDeParticipantes(ArrayList<Participante> listaDeParticipantes) {
        this.listaDeParticipantes = listaDeParticipantes;
    }

    public String getNombreArchivo() {
        return nombreArchivo;
    }

    public void setNombreArchivo(String nombreArchivo) {
        this.nombreArchivo = nombreArchivo;
    }
    public void addParticipante(Participante participante){
        this.listaDeParticipantes.add(participante);
    }
    public void removeParticipante(Participante participante){
        this.listaDeParticipantes.remove(participante);
    }
    public Participante getParticipante(int idParticipante){
        Participante retorno = null;
        for (Participante par:this.getListaDeParticipantes()) {
            if(par.getId() == idParticipante){
                retorno = par;
                break;
            }
        }
        return retorno;
    }
    public void cargaDeArchivo(){
        String datosParticipante;
        String vectorParticipante[];
        Participante participante;

        int fila =0;
        try {
            Scanner scan = new Scanner(new File(this.getNombreArchivo()));
            scan.useDelimiter("\n");

            while(scan.hasNext()){
                datosParticipante = scan.next();
                fila++;
                if(fila == 1)
                    continue;
                vectorParticipante = datosParticipante.split(",");

                int idPaticipante = Integer.parseInt(vectorParticipante[0]);
                String nombre = vectorParticipante[1];


                participante = new Participante(idPaticipante,nombre);
                this.addParticipante(participante);

            }
        }catch (IOException ex){
            System.out.println("Mensaje"+ ex.getMessage());
        }
    }
    public void calcularPuntaje(){

    }
    @Override
    public String toString() {
        return "ListaParticipantes{" +
                "listaDeParticipantes=" + listaDeParticipantes +
                ", nombreArchivo='" + nombreArchivo + '\'' +
                '}';
    }
}
