import java.util.*;

class Main {

    public static void main(String[] args) 
	{
	    LinkedList<Eingabe> list = new LinkedList<Eingabe>();
	    
	    while(true)
	   
	    {
	        System.out.print("Bitte Wert, Operator, Wert, = eingeben.\n(Beispiel: 1.36 'Enter', + 'Enter', 3.14 'Enter', = 'Enter')");
	        Scanner scanner = new Scanner(System.in);
	        String line = scanner.nextLine();
	        
	        if (list.size() == 0 || list.getLast() instanceof Operator)
	        {
	            // System.out.println("Nummer insterted to list");
	            list.addLast(new Nummer(line));
	            continue;
	        }
	        
	        if (line.equals("+") || line.equals("-") || line.equals("*") || line.equals("/")) {
	            
	            // System.out.println("Operator inserted to list");
	            if (list.getLast() instanceof Nummer) {
	                list.addLast(new Operator(line));
	            }
	            continue;
	        }
	        
	        if (line.equals("=")) {
	            
	            //System.out.println("Berechnung...");
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
	                
	                System.out.println("Ergebnis: " + lastResult + "\n");
	            }
	        }
	    }
	}
}
