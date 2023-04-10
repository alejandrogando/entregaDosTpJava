package programa;

import programa.Equipo;
import programa.Partido;

public class Pronostico {
    private int id;
    private Equipo equipo;
    private Partido partido;
    private char resultado;

    public Pronostico(int id, Equipo equipo, Partido partido, char resultado) {
        this.id = id;
        this.equipo = equipo;
        this.partido = partido;
        this.resultado = resultado;
    }
    public Pronostico(int id,char resultado){
        this.id = id;
        this.resultado = resultado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Equipo getEquipo() {
        return equipo;
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }

    public Partido getPartido() {
        return partido;
    }

    public void setPartido(Partido partido) {
        this.partido = partido;
    }

    public char getResultado() {
        return resultado;
    }

    public void setResultado(char resultado) {
        this.resultado = resultado;
    }
    public int getPuntos(){
        int puntos = 0;
        char resultado=' ';
        resultado = this.partido.getResultado(this.getEquipo());
        if(resultado == 'G'){
            puntos = 3;
        } else if (resultado == 'E') {
            puntos = 1;
        }
        return puntos;
    }
    @Override
    public String toString() {
        return "Pronostico{" +
                "id=" + id +
                ", equipo=" + equipo +
                ", partido=" + partido +
                ", resultado=" + resultado +
                '}';
    }
}
