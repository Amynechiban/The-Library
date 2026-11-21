import java.util.*;

public class Biliotheque {
    private List<Livre> livres = new ArrayList<Livre>();
    private List<Adherent> adherents = new ArrayList<Adherent>();
    private List<Emprunt> emprunts = new ArrayList<Emprunt>();


    public Biliotheque(List<Livre> l, List<Adherent> a, List<Emprunt> e){
        this.livres = l;
        this.adherents = a;
        this.emprunts = e;
    }

    public List<Adherent> getAdherents() {
        return adherents;
    }

    public List<Emprunt> getEmprunts() {
        return emprunts;
    }

    public List<Livre> getLivres() {
        return livres;
    }

    public void setAdherents(List<Adherent> adherents) {
        this.adherents = adherents;
    }

    public void setEmprunts(List<Emprunt> emprunts) {
        this.emprunts = emprunts;
    }

    public void setLivres(List<Livre> livres) {
        this.livres = livres;
    }


    public Adherent rechercherAdherent(int code){
        for (Adherent adherent: this.adherents){
            if (adherent.getCodeAdherent() == code){
                return adherent;
            }
        }return null;
    }
    public Livre rechercherLivre(int code){
        for (Livre livre: this.livres){
            if (livre.getCode() == code){
                return livre;
            }
        }return null;
    }
    public void ajouterLivre(Livre livre){
        this.livres.add(livre);
    }

    public void ajouterAdherent(Adherent adherent) {
        this.adherents.add(adherent);
    }
    public boolean ajouterEmprunt(int codeAdherent, int codeLivre){
        Adherent adherent = rechercherAdherent(codeAdherent);
        Livre livre = rechercherLivre(codeLivre);
        if (adherent != null && livre != null && livre.livreDispo()) {
            long threeDaysInMs = 3L * 24 * 60 * 60 * 1000;
            Date current = new Date();
            Emprunt emprunt = new Emprunt(livre, adherent, new Date(current.getTime() + threeDaysInMs));
            emprunts.add(emprunt);
            return true;
        }else return false;
    }
    public void retourLivre(int codeEmprunt){
        for (Emprunt emprunt: this.emprunts){
            if (emprunt.code == codeEmprunt){
                emprunt.retourEmprunt();
                break;
            }
        }
    }
    public Set<Adherent> emprunteurs(){
        Set<Adherent> s = new HashSet<Adherent>();
        for(Emprunt emprunt:this.emprunts){
            String etat = emprunt.etatEmprunt();
            if (etat.equals("non rendu") || etat.equals("en cours")){
                s.add(emprunt.emprunteur);
            }
        }
        return s;
    }
    /*
    public List<Livre> livresTriesParExemplairesDispo(){
        List<Livre> l = new ArrayList<Livre>(livres);
        for (int i = 0; i<l.size() -1; i++){
            boolean swapped = false;
            for (int j = 0; j < l.size()-i-1; j++){
                int nbri = l.get(i).nbrExplDisp;
                int nbrj = l.get(j).nbrExplDisp;
                if (nbri > nbrj){
                    int temp = nbri;
                    nbri = nbrj;
                    nbrj = nbri;
                    swapped = true;
                }
            }
            if (!swapped) break;
        }
        return l;

    }*/
    public List<Livre> livresTriesParExemplairesDispo(){
        List<Livre> l = new ArrayList<>(livres);
        //Collections.sort(l, Comparator.comparingInt(Livre::getNbrExplDisp));
        Collections.sort(l);
        return l;
    }

    public Livre topEmprunt(){
        Map<Livre, Integer> m = new HashMap<>();
        for(Emprunt emprunt: emprunts){
            if (!m.containsKey(emprunt.livre)){
                m.put(emprunt.livre,1);
            }else{
                int oldValue = m.get(emprunt.livre);
                m.replace(emprunt.livre, oldValue+1);
            }
        }
        List<Map.Entry<Livre, Integer>> l = new ArrayList<>(m.entrySet());
        //Collections.sort(l, Map.Entry.comparingByValue());
        //int n = l.size();
        //return l.get(n-1).getKey();

        CompareByValue cm = new CompareByValue();
        Collections.sort(l,cm);
        return l.get(0).getKey();

    }

}
