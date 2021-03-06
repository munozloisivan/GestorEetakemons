package eetac.upc.edu.dsa;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ivanm on 21/02/2017.
 */
public class Controlador {

    public List<Eetakemon> lista = new ArrayList<Eetakemon>();
    int id = 0;
    public Eetakemon resultado;
    public Eetakemon resultado2;

    public void añadirEetakemon(Eetakemon e) {
        e.setId(id);
        lista.add(e);
        id++;
    }

    //Borrar eetakemon por indice
    public void delEetakemon(int i) {
        lista.remove(i);
    }

    //Listar Eetakemons
    public List<Eetakemon> mostrarLista() {
        return lista;
    }

    //Buscar eetakemon por nombre
    public Eetakemon searchByName(String nombre) {
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).getNombre().equals(nombre)) {
                resultado = lista.get(i);
            }
        }
        return resultado;
    }

    //BOLA EXTRA
    //Implementar una búsqueda adicional que no busque por nombre exacto sino por aproximado
    public List<Eetakemon> searchApproach(String aprox) {

        List<Eetakemon> encontrado = new ArrayList<Eetakemon>();
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).getNombre().contains(aprox)) {
                encontrado.add(lista.get(i));
            }
        }
        return encontrado;
    }

}

