/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.peliculas.peliculas.datos;

import com.peliculas.excepciones.AccesoDatosEx;

/**
 *
 * @author Nicolas
 */
public interface AccesoDatos {
    boolean existe(String nombreArchivo) throws AccesoDatosEx;
}
