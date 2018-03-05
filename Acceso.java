import java.util.Arrays;

/**
 * Esta clase simula un acceso al servidor.
 *
 * @author (Cristian de la Fuente Garcia)
 * @version (05/03/2018)
 */
public class Acceso
{
    private String[] arrayDatos;

    /**
     * Constructor para objetos de la clase Acceso
     */
    public Acceso(String datos)
    {
        int posicionPrimerCorchete = datos.indexOf("[");
        int posicionSegundoCorchete = datos.indexOf("]");
        int posicionPaginaWeb = datos.indexOf("html");
        String direccionIP = "";
        String paginaWeb = "";
        String codigoHTTP =  "";
        String cadena = datos;
        if (datos.contains("[")){
            direccionIP = datos.substring(0,posicionPrimerCorchete).trim();
            cadena = datos.substring(posicionPrimerCorchete,posicionSegundoCorchete);
            paginaWeb = datos.substring(posicionSegundoCorchete + 1,posicionPaginaWeb + 4).trim();
            codigoHTTP =  datos.substring(datos.length() - 3).trim();
        }
        arrayDatos = new String[8];
        arrayDatos[0] = direccionIP;
        String[] arrayCadena = cadena.split(" ");
        
        for (int i = 1, x = 0; x < arrayCadena.length; i++, x++){
            arrayDatos[i] = arrayCadena[x];
        }
        arrayDatos[6] = paginaWeb;
        arrayDatos[7] = codigoHTTP;
    }
    
    /**
     * Este método devuelve la dirrecion IP del acceso correspondiente.
     * 
     * @param  ninguno
     * @return    String de la direccion IP
     */
    public String getDireccionIP(){
        return arrayDatos[0];
    }

    /**
     * Este método devuelve el año del acceso correspondiente.
     * 
     * @param  ninguno
     * @return    int del año
     */
    public int getAno() 
    {
        return Integer.parseInt(arrayDatos[1]);
    }

    /**
     * Este método devuelve el mes del acceso correspondiente.
     * 
     * @param  ninguno
     * @return    int del mes
     */
    public int getMes()
    {
        return Integer.parseInt(arrayDatos[2]);
    }

    /**
     * Este método devuelve el dia del acceso correspondiente.
     * 
     * @param  ninguno
     * @return    int del dia
     */
    public int getDia()
    {
        return Integer.parseInt(arrayDatos[3]);
    }

    /**
     * Este método devuelve la hora del acceso correspondiente.
     * 
     * @param  ninguno
     * @return    int de la hora
     */
    public int getHora()
    {
        return Integer.parseInt(arrayDatos[4]);
    }

    /**
     * Este método devuelve los minutos del acceso correspondiente.
     * 
     * @param  ninguno
     * @return    int de los minutos
     */
    public int getMinutos()
    {
        return Integer.parseInt(arrayDatos[5]);
    }

    /**
     * Este método devuelve la pagina Web del acceso correspondiente.
     * 
     * @param  ninguno
     * @return    String de la pagina Web
     */
    public String getPaginaWeb(){
        return arrayDatos[6];
    }

    /**
     * Este método devuelve el codigo HTTP del acceso correspondiente.
     * 
     * @param  ninguno
     * @return    int del codigo HTTP
     */
    public int getCodigoHTTP(){
        return Integer.parseInt(arrayDatos[7]);
    }
}