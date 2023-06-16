import java.util.ArrayList;
public class Entidad
{
    String Nombre;
    char Tipo = 'N'; //N: ninguna, F: fuerte, D: debil, H: hija 
    char Esp = 'N'; //N: ninguna, D: disyuncion, T: traslape
    Entidad Padre; //Entidad padre de la entidad
    boolean Relacion=false; //Indica si la entidad representa una relacion
    ArrayList<Atributo> Atribs = new ArrayList <Atributo>(); //Atributos de la entidad
    
    //Constructor
    public Entidad(String NewNom, char NewTip, char NewEsp, Entidad NewPad, boolean NewRel, ArrayList<Atributo> NewAtri)
    {
        Nombre = NewNom;
        Tipo = NewTip;
        Esp = NewEsp;
        Padre = NewPad;
        Relacion = NewRel;
        Atribs = (ArrayList) NewAtri.clone();
    }
}
