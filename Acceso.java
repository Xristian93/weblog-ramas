import java.util.Arrays;

public class Acceso
{
    private String[] arrayDatos;
    
    public Acceso(String datos)
    {
        arrayDatos = datos.split(" ");
    }
    
    public int getAno() 
    {
        return Integer.parseInt(arrayDatos[0]);
    }
    
    public int getMes()
    {
        return Integer.parseInt(arrayDatos[1]);
    }
    
    public int getDia()
    {
        return Integer.parseInt(arrayDatos[2]);
    }
    
    public int getHora()
    {
        return Integer.parseInt(arrayDatos[3]);
    }
    
    public int getMinutos()
    {
        return Integer.parseInt(arrayDatos[4]);
    }
}