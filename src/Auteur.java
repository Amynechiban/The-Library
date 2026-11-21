public class Auteur extends Personne{
    private int code_auth;

    public Auteur(String nom, String prenom, int code_auth){
        super(nom,prenom);
        this.code_auth = code_auth;
    }

    public int getCode_auth(){
        return this.code_auth;
    }

    public void setCode_auth(int code_auth) {
        this.code_auth = code_auth;
    }
    @Override
    public String toString(){
        String s = super.toString()+" "+this.code_auth;
        return s;
    }
}
