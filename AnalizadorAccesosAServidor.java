import java.io.File;
import java.util.Scanner;
import java.util.ArrayList;

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
     * Este método devuelve la hora a la que se producen mas accesos al servidor.
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
        return "";
    }

    public String clienteConMasAccesosExitosos()
    {
        return "";
    }

}
