package com.peliculas.servicio;

import com.peliculas.excepciones.AccesoDatosEx;

/**
 *
 * @author Nicolas
 */
public interface ICatalogoPeliculas {
    String NOMBRE_RECURSO = "peliculas.txt";
    
    void agregarPelicula(String NOMBRE_RECURSO)throws AccesoDatosEx;
    
    void listarPeliculas() throws AccesoDatosEx;
    
    void buscarPelicula(String buscar) throws AccesoDatosEx;
    
    void iniciarCatalogoPeliculas() throws AccesoDatosEx;
}
