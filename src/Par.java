public class Par <P,S> {
    public Par(P p, S s) {
        this.segundo = s;
        this.primeiro = p;
    }

    public P primeiro;
    public S segundo;
@Override
public String toString(){
    return "Primeiro : "+primeiro+" segundo : "+segundo;
}
}
