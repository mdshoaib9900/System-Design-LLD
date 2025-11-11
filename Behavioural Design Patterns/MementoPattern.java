
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
         TextEditor textEditor=new TextEditor();
         EditorHistory editorHistory=new EditorHistory();
         textEditor.setText("Hello shoaib how");
         System.out.println("current text "+textEditor.getText());
         editorHistory.push(textEditor.save());

         textEditor.setText("How are uh doing!!!");
         System.out.println("current text "+textEditor.getText());
         editorHistory.push(textEditor.save());

         textEditor.setText("How are uh doing!!! my boy");
         System.out.println("current text "+textEditor.getText());
         
         Memento prevState=editorHistory.pop();
         textEditor.restore(prevState);
         System.out.println("After text Undo "+textEditor.getText());

         prevState = editorHistory.pop();
         textEditor.restore(prevState);
    }
}