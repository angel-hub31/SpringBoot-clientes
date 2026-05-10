package com.krakedev.productos.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.krakedev.productos.entidades.Producto;

@Service
public class ProductoService {

    private ArrayList<Producto> productos;

    public ProductoService() {
        productos = new ArrayList<>();
    }

    public Producto crear(Producto producto) {

        Producto encontrado = buscarPorCodigo(producto.getCodigo());

        if (encontrado != null) {
            return null;
        }

        productos.add(producto);
        return producto;
    }

    public ArrayList<Producto> listar() {
        return productos;
    }

    public Producto buscarPorCodigo(int codigo) {

        for (Producto producto : productos) {

            if (producto.getCodigo() == codigo) {
                return producto;
            }
        }

        return null;
    }

    public Producto actualizar(int codigo, Producto productoActualizado) {

        Producto encontrado = buscarPorCodigo(codigo);

        if (encontrado != null) {

            encontrado.setNombre(productoActualizado.getNombre());
            encontrado.setPrecio(productoActualizado.getPrecio());
            encontrado.setStock(productoActualizado.getStock());

            return encontrado;
        }

        return null;
    }

    public boolean eliminar(int codigo) {

        Producto encontrado = buscarPorCodigo(codigo);

        if (encontrado != null) {
            productos.remove(encontrado);
            return true;
        }

        return false;
    }
}