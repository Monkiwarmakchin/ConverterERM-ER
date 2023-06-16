import java.util.ArrayList;
public class Relacion
{
    String Nombre;
    char Card = 'N'; //N: Ninguna, -: (1:1), <: (1:N), >: (N:1), =: (N:M) 
    int Part = 0; //O: Ninguna, 1: Modifica Entidad 1 (Total-Parcial), 2: Modifica Entidad 2 (Parcial-Total), 3: Modifica a la Entidad (Parcial-Parcial, Total-Total)
    ArrayList<Entidad> Entidades = new ArrayList<Entidad>(); //Entidades involucradas en la relacion
    ArrayList<Atributo> Atribs = new ArrayList <Atributo>(); //Atributos de la relacion
    
    //Contructor
    public Relacion(String NewNom, char NewCard, int NewPart, ArrayList<Entidad> NewEnts, ArrayList<Atributo> NewAtri)
    {
        Nombre=NewNom;
        Card=NewCard;
        Part=NewPart;
        Entidades = (ArrayList) NewEnts.clone();
        Atribs = (ArrayList) NewAtri.clone();
    }
}