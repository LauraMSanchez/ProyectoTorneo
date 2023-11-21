/**
 * Clase que agrupa los datos de un Jugador
 * @author Área de programación UQ
 * @since 2023-09
 * 
 * Licencia GNU/GPL V3.0 (https://raw.githubusercontent.com/grid-uq/poo/main/LICENSE) 
 */
package co.edu.uniquindio.poo.torneodeportivo;

import java.time.LocalDate;
import java.time.Period;
import java.util.Optional;

import static co.edu.uniquindio.poo.util.AssertionUtil.ASSERTION;

public class Jugador extends Persona implements Participante {
    private final LocalDate fechaNacimiento;
    private final RegistroEstadistica registroEstadistica;
    
    public Jugador(String nombre, String apellido, String email, String celular, LocalDate fechaNacimiento, Genero Genero) {
        super(nombre, apellido, email, celular);
        ASSERTION.assertion( fechaNacimiento != null , "La fecha de nacimiento es requerida");
        ASSERTION.assertion(Genero != null, "El género es requerido");
        this.fechaNacimiento = fechaNacimiento;
        registroEstadistica = new RegistroEstadisticaImpl();
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }
    
    /**
     * Permite calcula la edad que tiene un jugador en una fecha dada.
     * @param fecha Fecha contra la cual se desea calcular la edad del jugador.
     * @return La edad que tiene en años en la fecha dada.
     */
    public byte calcularEdad(LocalDate fecha){
        return (byte) Period.between(fechaNacimiento, fecha).getYears();
    }

    @Override
    public String getNombreCompleto() {
        return getNombre()+ " "+getApellido();
    }

    @Override
    public RegistroEstadistica getEstadisticaRegister() {
        return registroEstadistica;
    }

    public static Optional<Jugador> stream() {
        return null;
    }


    public static void add(Jugador jugador) {
    }
}
