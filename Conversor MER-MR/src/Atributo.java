import java.util.ArrayList;
public class Atributo
{
    String Nombre;
    boolean Pri=false; //Inidica si este atributo es una llave primaria
    boolean For=false; //Inidica si este atributo es una llave foranea
    
    //Constructor
    public Atributo(String NewNom, boolean NewPri, boolean NewFor)
    {
        Nombre=NewNom;
        Pri=NewPri;
        For=NewFor;
    }
}