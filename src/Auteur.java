public class Auteur extends Personne{
    private String code_auth;

    public Auteur(String nom, String prenom, String code_auth) {
        super(nom,prenom);
        setCode_auth(code_auth);
    }
    private boolean isInt(String s){
        if(s == null || s.isEmpty()) return false;
        try {
            Integer.parseInt(s);
            return true;
        }catch (NumberFormatException e){
            return false;
        }
    }

    public String getCode_auth(){
        return this.code_auth;
    }

    public void setCode_auth(String code_auth) throws CodeAutException {
        if(code_auth.length() != 4 || !isInt(code_auth)) throw  new CodeAutException();
        this.code_auth = code_auth;
    }
    @Override
    public String toString(){
        String s = super.toString()+" "+this.code_auth;
        return s;
    }
}

