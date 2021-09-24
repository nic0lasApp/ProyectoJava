package com.peliculas.datos;

import com.peliculas.excepciones.*;
import com.peliculas.domain.Pelicula;
import java.util.List;

/**
 *
 * @author Nicolas
 */
public interface IAccesoDatos {
    boolean existe(String nombreRecurso) throws AccesoDatosEx;
    
    List<Pelicula> listar(String nombreRecurso)throws LecturaDatosEx;
    
    void escribir(Pelicula pelicula, String NombreRecurso, boolean anexar) throws EscrituraDatosEx;
    
    String buscar(String nombreRecurso, String buscar) throws LecturaDatosEx;
    
    void crear (String nombreRecurso) throws AccesoDatosEx;
    
    void borrar (String nombreRecurso) throws AccesoDatosEx;
}
