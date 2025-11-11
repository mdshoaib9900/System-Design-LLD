
import java.util.Stack;

class TextEditor{
    private String text;
    public  void setText(String text){
        this.text=text;
    }
    public String getText(){
        return text;
    }
    public Memento save(){
        return new Memento(text);
    }
    public void restore(Memento memento){
        this.text=memento.getText();
    }
}
class Memento{
    private final String text;
    public Memento(String text){
        this.text=text;
    }
    public String getText(){
        return text;
    }
}
class EditorHistory{
    private  Stack<Memento> history=new Stack<>();
    public void push(Memento memento){
        history.add(memento);
    }
    public Memento pop(){
        if(!history.isEmpty()){
            return history.pop();
        }
        return null;
    }
}
public  class MementoPattern{
    public static void main(String[] args) {
         
    }
}