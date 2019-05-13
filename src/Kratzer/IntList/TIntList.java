package Kratzer.IntList;

import intList.IntList;
import intList.ListException;

public class TIntList {

	public static void main(String[] args) {

		IntList l = new IntList(); 
		boolean terminate = false;

		while (!terminate) {
			// Show the current state of the structure
			if (l.isEmpty()) {
				Terminal.put("The list is empty ...");
			} else {
				Terminal.put("Contents: " + l.toString());
				Terminal.put("Size:     " + l.size());
				Terminal.put("First:    " + l.firstElement());
				Terminal.put("Last:     " + l.lastElement());
			}
			// Enter and execute command
			String command = Terminal.getString("Command (if/il/df/dl/x):");
			switch ("ifildfdlx".indexOf(command)) {
			case 0: //if
				l.insertFirst(Terminal.getInt("New value:"));
				break;
			case 2: //il
				l.insertLast(Terminal.getInt("New value:"));
				break;
			case 4: //df
				try {
					l.deleteFirst();
				} catch (ListException e) {
					Terminal.put("Illegal operation ...");
				}
				break;
			case 6: //dl
				try {
					l.deleteLast();
				} catch (ListException e) {
					Terminal.put("Illegal operation ...");
				}
				break;
			case 8: //x
				terminate = true;
				break;
			default:
				Terminal.put("... no comprendo nada ...");
				break;
			}
		}

		Terminal.put("Ciao!");
	}
}
