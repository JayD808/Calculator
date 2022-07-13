import java.util.*;

class Main {

    public static void main(String[] args) 
	{
	    LinkedList<Eingabe> list = new LinkedList<Eingabe>();
	    
	    while(true)
	    {
	        System.out.print("Wert eingeben: ");
	        Scanner scanner = new Scanner(System.in);
	        String line = scanner.nextLine();
	        
	        System.out.println("Eingabe: " + line);
	        
	        if (list.size() == 0 || list.getLast() instanceof Operator)
	        {
	            System.out.println("Insert Nummer");
	            list.addLast(new Nummer(line));
	            continue;
	        }
	        
	        if (line.equals("+") || line.equals("-") || line.equals("*") || line.equals("/")) {
	            System.out.println("Insert Operator");
	            if (list.getLast() instanceof Nummer) {
	                list.addLast(new Operator(line));
	            }
	            
	            continue;
	        }
	        
	        if (line.equals("=")) {
	            System.out.println("Berechnen!");
	            
	            float lastResult = 0.0f;
	            
	            while(!list.isEmpty()) {
	                if (list.get(0) instanceof Nummer) {
	                    lastResult = Float.parseFloat(list.pollFirst().getValue());
	                }
	                
	                if (list.get(0) instanceof Operator) {
	                    Operator op = (Operator)list.pollFirst();
	                    Float nr = Float.parseFloat(list.pollFirst().getValue());
	                    
	                    if (op.getValue().equals("+"))
	                        lastResult = lastResult + nr;
	                        
	                    if (op.getValue().equals("-"))
	                        lastResult = lastResult - nr;
	                        
	                    if (op.getValue().equals("*"))
	                        lastResult = lastResult * nr;
	                        
	                    if (op.getValue().equals("/"))
	                        lastResult = lastResult / nr;
	                }
	                
	                System.out.println("Wert: " + lastResult);
	            }
	        }
	    }
	}
}