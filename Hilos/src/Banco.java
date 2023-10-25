import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Banco {
    private BlockingQueue<String> prioriBanco=new LinkedBlockingQueue<>();
    private BlockingQueue<String> pobresBanco = new LinkedBlockingQueue<>();

    public void agregarClientePriori(String nombre){
        prioriBanco.add(nombre);
    }

    public void agregarClientePobre(String nombre){
        pobresBanco.add(nombre);
    }

    public BlockingQueue<String> getPrioriBanco() {
        return prioriBanco;
    }

    public void setPrioriBanco(BlockingQueue<String> prioriBanco) {
        this.prioriBanco = prioriBanco;
    }

    public BlockingQueue<String> getPobresBanco() {
        return pobresBanco;
    }

    public void setpobresBanco(BlockingQueue<String> PobreBanco) {
        this.pobresBanco = PobreBanco;
    }
}