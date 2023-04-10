package programa;

import programa.Equipo;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ListaEquipos {
    private List<Equipo> listaDeEquipos;
    private String nombreArchivo;



    public ListaEquipos(){
        this.listaDeEquipos = new ArrayList<>();
        this.nombreArchivo= "./src//archivos//equipos.csv";
    }

    public ArrayList<Equipo> getListaDeEquipos() {
        return (ArrayList<Equipo>) listaDeEquipos;
    }

    public void setListaDeEquipos(ArrayList<Equipo> listaDeEquipos) {
        this.listaDeEquipos = listaDeEquipos;
    }

    public String getNombreArchivo() {
        return nombreArchivo;
    }

    public void setNombreArchivo(String nombreArchivo) {
        this.nombreArchivo = nombreArchivo;
    }
    public void agregarEquipo(Equipo equipo){
        this.listaDeEquipos.add(equipo);
    }
    public void borrarEquipo(Equipo equipo){
        this.listaDeEquipos.remove(equipo);
    }
    public Equipo getEquipo(int idEquipo){
        Equipo retorno = null;

        for (Equipo eq: this.getListaDeEquipos()) {
        if(eq.getIdEquipo() == idEquipo){
            retorno = eq;
            break;
        }
        }
return retorno;
    }

public void cargaDeArchivo(){
        String datosEquipo;
        String vectorEquipo[];
        Equipo equipo;

        int fila =0;
        try {
            Scanner scan = new Scanner(new File(this.getNombreArchivo()));
            scan.useDelimiter("\n");

            while(scan.hasNext()){
                datosEquipo = scan.next();
                fila++;
                if(fila == 1)
                    continue;
                vectorEquipo = datosEquipo.split(",");

                int idEquipo = Integer.parseInt(vectorEquipo[0]);
                String nombre = vectorEquipo[1];
                String descripcion = vectorEquipo[2];

                equipo = new Equipo(idEquipo,nombre,descripcion);
                this.agregarEquipo(equipo);

            }
        }catch (IOException ex){
            System.out.println("Mensaje"+ ex.getMessage());
        }
}
    public String listar() {
        String lista = "";
        for (Equipo equipo: this.listaDeEquipos) {
            lista += "\n" + equipo;
        }
        return lista;
    }
}
