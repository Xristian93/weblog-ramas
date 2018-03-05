import java.io.File;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.HashMap;

/**
 * Esta clase sirve para Analizar accesos al servidor de datos.
 *
 * @author (Cristian de la Fuente Garcia)
 * @version (23/02/2018)
 */
public class AnalizadorAccesosAServidor
{
    private ArrayList<Acceso> accesos;

    /**
     * Constructor para objetos de la clase AnalizadorAccesosAServidor
     */
    public AnalizadorAccesosAServidor() 
    {
        accesos = new ArrayList<>();
    }

    /**
     * Este metodo analiza un archivo (tipo String) que le pasamos como parametro
     * 
     * @param  String archivo
     * @return    nada
     */
    public void analizarArchivoDeLog(String archivo)
    {
        accesos.clear();
        File archivoALeer = new File(archivo);
        try {
            Scanner sc = new Scanner(archivoALeer);
            while (sc.hasNextLine()) {
                String lineaLeida = sc.nextLine();    
                Acceso accesoActual = new Acceso(lineaLeida);               
                accesos.add(accesoActual);
            }
            sc.close();
        }      catch (Exception e) {
            System.out.println("Ocurrio algun error al leer el archivo.");
        }
    }

    /**
     * Este m�todo devuelve la hora a la que se producen mas accesos al servidor.
     * 
     * @param  ninguno
     * @return    int de la hora a la que se producen mas accesos
     */
    public int obtenerHoraMasAccesos() 
    {
        int valorADevolver = -1;

        if (!accesos.isEmpty()) {
            int[] accesosPorHora = new int[24];

            for (Acceso accesoActual : accesos) {
                int horaAccesoActual = accesoActual.getHora();
                accesosPorHora[horaAccesoActual] = accesosPorHora[horaAccesoActual] + 1;
            }

            int numeroDeAccesosMasAlto = accesosPorHora[0];
            int horaDeAccesosMasAlto = 0;
            for (int i = 0; i < accesosPorHora.length; i++) {
                if (accesosPorHora[i] >= numeroDeAccesosMasAlto) {
                    numeroDeAccesosMasAlto = accesosPorHora[i];
                    horaDeAccesosMasAlto = i;
                }
            }

            valorADevolver = horaDeAccesosMasAlto;                      
        }

        return valorADevolver;
    }

    public String paginaWebMasSolicitada() 
    {
        String paginaWebMasAccesos = null;
        int totalAccesos = 0;
        HashSet<String> coleccionPaginasWeb = new HashSet<>();
        HashMap<String, ArrayList<Acceso>> coleccionMap = new HashMap<>();

        if (accesos.size() > 0){
            for (Acceso accesoActual : accesos){
                coleccionPaginasWeb.add(accesoActual.getPaginaWeb());
            }
            for (String paginaActual : coleccionPaginasWeb){
                ArrayList<Acceso> arrayMap = new ArrayList<>();
                for (int i = 0; i < accesos.size(); i++){
                    if(paginaActual.equals(accesos.get(i).getPaginaWeb())){
                        arrayMap.add(accesos.get(i));
                    }
                }
                coleccionMap.put(paginaActual, arrayMap);
            }
            for (ArrayList<Acceso> accesoActual : coleccionMap.values()){
                if (accesoActual.size() >= totalAccesos){
                    paginaWebMasAccesos = accesoActual.get(0).getPaginaWeb();
                    totalAccesos = accesoActual.size();
                }
            }
        }
        return paginaWebMasAccesos;
    }

    public String clienteConMasAccesosExitosos()
    {
        return "";
    }

}
