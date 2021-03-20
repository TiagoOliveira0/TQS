import javax.naming.LimitExceededException;
import java.util.LinkedList;
import java.util.NoSuchElementException;

public class TqsStack<T>
{
    LinkedList<T> ll = null;
    private int limit = 0;

    public TqsStack(){
        ll = new LinkedList<>();
    }

    public TqsStack(int lim){
        ll = new LinkedList<>();
        this.limit=lim;
    }

    public int getLimit(){
        return this.limit;
    }

    public void setLimit(int i){
        this.limit=i;
    }

    public boolean isEmpty() {
        if (ll.size() == 0) {
            return true;
        }
        return false;
    }

    public void push(T e){
        if (this.limit==0 || this.size()<this.limit) {
            ll.addFirst(e);
        }
        else {
            throw new IllegalStateException();
        }
    }

    public T pop() {
        if (ll.size() == 0) {
            throw new NoSuchElementException();
        }
        T ret = ll.get(0);
        ll.remove(0);
        return ret;
    }

    public T peek() {
        if (ll.size() == 0) {
            throw new NoSuchElementException();
        }
        return ll.get(0);
    }

    public int size() {
        return ll.size();
    }



}
