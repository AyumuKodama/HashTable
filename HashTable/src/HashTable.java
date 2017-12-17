
public class HashTable {

	private Node[] map;
	private int tableSize;
	
	public HashTable(int tableSize) {
		map = new Node[tableSize];
		this.tableSize = tableSize;
	}
	
	/*
	 * This is the hash function.
	 * For this hash function, return 0 if key is the empty string.
	 * Otherwise, calculate the sum of the ASCII values of the characters in key
	 * and find the remainder when divided by 8 (remember mod divisision %).
	 * Check the java API for String methods that may be helpful.
	 */
	private int hash(String key) {
		if (key == null) {
			return 0;
		} else {
			int hash = 0;
			for (int i = 0; i < key.length(); i++) {
				hash += (int)key.charAt(i);
			}
			return hash % 8;
		}
	}
	
	public void insert(String key) {
		Node node = new Node(key);
		if (map[hash(key)] == null) {
			map[hash(key)] = node;	
		} else {
			node.next = map[hash(key)];
			map[hash(key)] = node;
		}
	}
	
	public boolean search(String key) {
		Node pointer = map[hash(key)];
		boolean exists = false;
		while (!exists && pointer != null) {
			if (pointer.record == key) {
				exists = true;
			} else {
				pointer = pointer.next;
			}	
		}
		if (exists) {
			return true;
		} else {
			return false;
		}
	}
	
	public void printTable() {
		for (int i = 0; i < tableSize; i++) {
			System.out.print(i + ": ");
			Node pointer = map[i];
			while (pointer != null) {
				System.out.print(pointer.record + " ");
				pointer = pointer.next;
			}
			System.out.println();
		}
	}
	
	/*
	 * This method should delete ALL nodes matching the search key.
	 */
	public void delete(String key) {
		Node pointer = map[hash(key)];
		if (map[hash(key)].record.equals(key)) {
			map[hash(key)] = map[hash(key)].next;
		} else {
			while (pointer != null) {
				if (pointer.record.equals(key)) {
					pointer.record = null;
				}
				pointer = pointer.next;
			}
		}
		
		
	}
}