import java.util.Date;

public class Emprunt {
    private static int counter = 0;
    int code;
    Livre livre;
    Adherent emprunteur;
    Date dateEmprunt;
    Date dateRetourPrevue;
    Date dateRetourEffective;

    public Emprunt(Livre l, Adherent adherent, Date datePrevu){
        this.livre = l;
        this.emprunteur = adherent;
        this.code = ++counter;
        this.dateEmprunt = new Date();
        this.dateRetourPrevue = datePrevu;
        this.livre.nbrExplDisp--;
    }
    public String etatEmprunt(){
        Date currentDate = new Date();
        if (this.dateRetourEffective != null){
            return "rendu";
        }
        if (currentDate.after(this.dateRetourPrevue)){
            return "non rendu";
        }
        return "en cours";
    }
    public boolean retourEmprunt(){
        if (this.dateRetourEffective == null) {
            this.dateRetourEffective = new Date();
            this.livre.retourLivre();
            return true;
        }return false;
    }
}
