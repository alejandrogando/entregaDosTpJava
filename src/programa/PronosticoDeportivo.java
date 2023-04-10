package programa;

import programa.ListaEquipos;
import programa.ListaParticipantes;
import programa.ListaPartidos;
import programa.ListaPronosticos;

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

        listaPartidos.cargaDeArchivo(1,listaEquipos);
        System.out.println("El Patido es " + listaPartidos.getPartido(1));
/*
        listaParticipantes.cargaDeArchivo();
        System.out.println("Los participantes cargados son: " + listaParticipantes.listar());



        Participante participante = new Participante();
        participante.cargarPronosticos(listaEquipos,listaPartidos);

        System.out.println("El Pronostico es:"+ listaPronosticos.getPronostico(1));
*/

    }
}
