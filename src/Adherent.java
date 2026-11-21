import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

public class Adherent extends Personne{
    private static int counter = 0;

    private int codeAdherent;
    private Date date;

    public Adherent(Date date){
        super();
        this.codeAdherent = ++counter;
        this.date = date;
    }

    public Adherent(String nom, String prenom){
        this(new Date());
        setNom(nom);
        setPrenom(prenom);
    }

    public int getCodeAdherent() {
        return codeAdherent;
    }

    public void setCodeAdherent(int codeAdherent) {
        this.codeAdherent = codeAdherent;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString(){
        SimpleDateFormat f = new SimpleDateFormat("dd MM yyyy");
        return super.toString() + "_" + codeAdherent + "_" + f.format(date);

    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        Adherent adh = (Adherent) o;
        return this.codeAdherent == adh.getCodeAdherent();
    }

}
