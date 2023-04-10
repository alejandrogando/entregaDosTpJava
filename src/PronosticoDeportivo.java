

public class PronosticoDeportivo {
    private ListaParticipantes listaParticipantes;
    private ListaPartidos listaPartidos;
    private ListaEquipos listaEquipos;
    private ListaPronosticos listaPronosticos;

    public PronosticoDeportivo(){
        listaParticipantes = new ListaParticipantes();
        listaPartidos = new ListaPartidos();
        listaEquipos = new ListaEquipos();
        listaPronosticos = new ListaPronosticos();
    }

    public void play(){
        listaEquipos.cargaDeArchivo();
        System.out.println("Los equipos cargados son: " + listaEquipos.listar());
        /*
        listaPartidos.cargaDeArchivo(1,listaEquipos);
        listaParticipantes.cargaDeArchivo();
        Participante participante = new Participante();
        participante.cargarPronosticos(listaEquipos,listaPartidos);

         */
    }
}
