package programa;

import programa.ListaEquipos;
import programa.ListaPartidos;
import programa.ListaPronosticos;

public class Participante {
    private int idParticipante;
    private String nombre;
    private ListaPronosticos listaPronosticos;
    private int puntaje;

    public Participante(int idParticipante, String nombre, ListaPronosticos listaPronosticos, int puntaje) {
        this.idParticipante = idParticipante;
        this.nombre = nombre;
        this.listaPronosticos = listaPronosticos;
        this.puntaje = puntaje;
    }
    public Participante (int idParticipante,String nombre,ListaPronosticos listaPronosticos){
        this.idParticipante = idParticipante;
        this.nombre = nombre;
        this.listaPronosticos = new ListaPronosticos();
    }
    public Participante(int idParticipante,String nombre){
        this.idParticipante = idParticipante;
        this.nombre = nombre;
    }

    public int getId() {
        return idParticipante;
    }

    public void setId(int id) {
        this.idParticipante = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ListaPronosticos getListaPronosticos() {
        return listaPronosticos;
    }

    public void setListaPronosticos(ListaPronosticos listaPronosticos) {
        this.listaPronosticos = listaPronosticos;
    }



    public void setPuntaje(int puntaje) {
        this.puntaje = puntaje;
    }

public int getPuntaje(){
        puntaje = 0;
    for (Pronostico pro:this.getListaPronosticos().getPronosticos())
    {
        puntaje+=pro.getPuntos();
    }
    return puntaje;
}
    public  void cargarPronosticos(ListaEquipos listaEquipos, ListaPartidos listaPartidos){
        this.listaPronosticos.cargaDeArchivo(this.getId(),listaEquipos,listaPartidos);
    }

    @Override
    public String toString() {
        return "Participante{" +
                "id=" + idParticipante +
                ", nombre='" + nombre + '\'' +
                ", listaPronosticos=" + listaPronosticos +
                ", puntaje=" + puntaje +
                '}';
    }
}
