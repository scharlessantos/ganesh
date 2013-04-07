/* Ganesh Server, developed in 2013*/
package ganesh.db.utils;

import java.util.Random;

public class ObjectId {

	private int id;

	public ObjectId() {
		// TODO Gerar um objectId decente
		id = new Random().nextInt();
	}

	public int get() {
		return id;
	}
}
