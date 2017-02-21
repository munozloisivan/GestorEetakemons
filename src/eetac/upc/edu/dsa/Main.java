package eetac.upc.edu.dsa;

/* EJERCICIO
* 1 - Añadir Eetakemon
* 2 - Borrar Eetakemon
* 3 - Listar todos los eetakemons
* 4 - Buscar por nombre
*
* El id tiene que ser generado
*
* minimo 3 clases --> VISTA, MODELO, CONTROLADOR
* */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        // write your code here

        ListaEtakemon milista = new ListaEtakemon();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int idgenerado = 0;
        int i = 88;
        while (i != 0) {

            System.out.println("** Bienvenido a la Eetakedex ** \n");
            System.out.println("Seleccione una opcion:");
            System.out.println("1: añadir eetakemon");
            System.out.println("2: borrar eetakemon por id");
            System.out.println("3: Listar todos los eetakemons");
            System.out.println("4: Buscar eetakemon por nombre");
            System.out.println("0: Salir");

            try {
                i = Integer.parseInt(br.readLine());
            } catch (IOException e) {
                e.getMessage();
            }

            switch (i) {
                case 1: //añadir eetakemon
                    try {
                        System.out.println("Introduce Nombre:");
                        String nombreAdd = br.readLine();
                        //System.out.println("Introduce id:");
                        int idAdd = idgenerado++;
                        System.out.println("Introduce nivel:");
                        int nivelAdd = Integer.parseInt(br.readLine());

                        Eetakemon eetakemonAdd = new Eetakemon(nombreAdd, idAdd, nivelAdd);

                        milista.añadirEetakemon(eetakemonAdd);
                    } catch (IOException e) {
                        e.getMessage();
                    }
                    break;
                case 2: //borrar eetakemon por id
                    try {
                        System.out.println("Introduce id a borrar");
                        int idDel = Integer.parseInt(br.readLine());
                        milista.delEetakemon(idDel);
                    }
                    catch (IOException e){
                        e.getMessage();
                    }
                    break;
                case 3: //listar todos los eetakemons
                        List<Eetakemon> mostrar = milista.mostrarLista();
                        if (mostrar.size() == 0) {
                            System.out.println("La lista esta vacia");
                        } else {
                            for (int x = 0; x < mostrar.size(); x++) {
                                System.out.println("Nombre: " + mostrar.get(x).getNombre() + "  ID: " + mostrar.get(x).getId() + "  Nivel: " + mostrar.get(x).getNivel());
                            }
                        }
                    break;
                case 4: //buscar por nombre
                    System.out.println("¿Cual quieres buscar?");
                    String nombreSearch = br.readLine();
                    System.out.println("Nombre: " + milista.searchByName(nombreSearch).getNombre()  + "  ID: " + milista.searchByName(nombreSearch).getId() + "  Nivel: " +milista.searchByName(nombreSearch).getNivel());
                    break;
                case 0:
                    System.out.println("Adiós");
                    break;
            }

        }
    }
}