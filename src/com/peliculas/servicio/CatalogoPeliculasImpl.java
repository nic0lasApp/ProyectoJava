/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.peliculas.servicio;

import com.peliculas.datos.AccesoDatosImpl;
import com.peliculas.datos.IAccesoDatos;
import com.peliculas.domain.Pelicula;
import com.peliculas.excepciones.*;
import java.util.List;
/**
 *
 * @author Nicolas
 */
public class CatalogoPeliculasImpl implements ICatalogoPeliculas{
    
    private final IAccesoDatos datos;

    public CatalogoPeliculasImpl() {
        this.datos = new AccesoDatosImpl();
    }

    @Override
    public void agregarPelicula(String nombrePelicula) throws AccesoDatosEx {
        Pelicula pelicula = new Pelicula(nombrePelicula);
        boolean anexar = false;
        try {
            anexar = datos.existe(NOMBRE_RECURSO);
            datos.escribir(pelicula, NOMBRE_RECURSO, anexar);
        } catch (AccesoDatosEx ex) {
            ex.printStackTrace();
            throw new EscrituraDatosEx("Error de acceso a datos" + ex.getMessage());
        }
    }

    @Override
    public void listarPeliculas() throws AccesoDatosEx{
        try {
            List<Pelicula> peliculas = this.datos.listar(NOMBRE_RECURSO);
            for (Pelicula pelicula : peliculas) {
                System.out.println("pelicula: " + pelicula);
            }
        } catch (AccesoDatosEx ex) {
            ex.printStackTrace();
            throw new LecturaDatosEx("Error listando datos" + ex.getMessage());
        }
    }

    @Override
    public void buscarPelicula(String buscar) throws AccesoDatosEx {
        String resultado = null;
        try {
            resultado = this.datos.buscar(NOMBRE_RECURSO, buscar);
        } catch (AccesoDatosEx ex) {
            ex.printStackTrace();
            throw new LecturaDatosEx("Error buscando datos" + ex.getMessage());
        }
    }

    @Override
    public void iniciarCatalogoPeliculas() throws AccesoDatosEx {
        try {
            if (this.datos.existe(NOMBRE_RECURSO)) {
                datos.borrar(NOMBRE_RECURSO);
                datos.crear(NOMBRE_RECURSO);
            } else {
                datos.crear(NOMBRE_RECURSO);
            }
        } catch (AccesoDatosEx ex) {
            ex.printStackTrace();
            throw new LecturaDatosEx("Error iniciando catalogo de peliculas" + ex.getMessage());
        }
    }
}
