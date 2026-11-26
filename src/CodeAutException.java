public class CodeAutException extends RuntimeException{

    public CodeAutException(){
        super("Code Format Should be: XXXX where X is a digit");
    }

}
