package ds.datastructures;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Hapheej
 *
 */
public class ArrayListTest<T> {

	private List<T> players;
	
	public static void main(String[] args) {

		ArrayListTest test = new ArrayListTest<>();
		test.runScenarios();

	}
	
	private void runScenarios() {
		
		players = new ArrayList<T>();
	}
	
	public List<T> getPlayers() {
		return players;
	}

	public void setPlayers(List<T> players) {
		this.players = players;
	}
}
