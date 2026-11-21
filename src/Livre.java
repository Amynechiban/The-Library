public class Livre implements Comparable{
    private int code;
    String titre;
    Auteur auteur;
    int nbrExpl;
    int nbrExplDisp;

    public int getNbrExpl() {
        return nbrExpl;
    }

    public int getNbrExplDisp() {
        return nbrExplDisp;
    }

    public Livre(Auteur auth, String titre, int code, int nbrExpl, int nbrExplDisp){
        this.auteur = auth;
        this.code = code;
        this.nbrExpl = nbrExpl;
        this.nbrExplDisp = nbrExplDisp;
        this.titre = titre;
    }

    public int getCode() {
        return code;
    }

    public boolean livreDispo(){
        if (this.nbrExplDisp > 0){
            return true;
        }
        return false;
    }

    public void retourLivre(){
        this.nbrExplDisp++;
    }

    @Override
    public int compareTo(Object o){
        Livre livre = (Livre) o;
        return Integer.compare(this.nbrExplDisp,livre.getNbrExplDisp());
    }


}
