package programa;

import programa.Equipo;
import programa.ListaEquipos;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class ListaPartidos {
    private ArrayList<Partido> listaDePartidos;
    private String nombreArchivo;

    public ListaPartidos(){
        this.listaDePartidos = new ArrayList<>();
        this.nombreArchivo = "./src//archivos//partidos.csv";
    }

    public ArrayList<Partido> getListaDePartidos() {
        return listaDePartidos;
    }
    public Partido getPartido(int idPartido){
        Partido retorno = null;

        for (Partido partido: this.getListaDePartidos()) {
            if(partido.getIdPartido() == idPartido){
                retorno = partido;
                break;
            }
        }
        return retorno;
    }

    public void setListaDePartidos(ArrayList<Partido> listaDePartidos) {
        this.listaDePartidos = listaDePartidos;
    }

    public String getNombreArchivo() {
        return nombreArchivo;
    }

    public void setNombreArchivo(String nombreArchivo) {
        this.nombreArchivo = nombreArchivo;
    }
    public void addPartido(Partido partido){
        this.getListaDePartidos().add(partido);
    }
    public void removePartido(Partido partido){
        this.getListaDePartidos().remove(partido);
    }
    public void cargaDeArchivo(int idPart, ListaEquipos listaEquipos){
        String datosPartido;
        String vectorPartido[];


        int fila =0;
        try {
            Scanner scan = new Scanner(new File(this.getNombreArchivo()));
            scan.useDelimiter("\n");

            while(scan.hasNext()) {
                datosPartido = scan.next();
                fila++;
                if (fila == 1)
                    continue;
                vectorPartido = datosPartido.split(",");

                int idPartido = Integer.parseInt(vectorPartido[0]);
                int idEquipo1 = Integer.parseInt(vectorPartido[1]);
                int idEquipo2 = Integer.parseInt(vectorPartido[2]);
                int golesEquipo1 = Integer.parseInt(vectorPartido[3]);
                int golesEquipo2 = Integer.parseInt(vectorPartido[4]);


                if (idPartido == idPart) {
                Equipo equipo1 = listaEquipos.getEquipo(idEquipo1);
                Equipo equipo2 = listaEquipos.getEquipo(idEquipo2);
                Partido partido = new Partido(idPartido,equipo1,equipo2,golesEquipo1,golesEquipo2);
                this.addPartido(partido);
                }


            }
        }catch (IOException ex){
            System.out.println("Mensaje"+ ex.getMessage());
        }
    }
    @Override
    public String toString() {
        return "ListaPartidos{" +
                "listaDePartidos=" + listaDePartidos +
                ", nombreArchivo='" + nombreArchivo + '\'' +
                '}';
    }
}
