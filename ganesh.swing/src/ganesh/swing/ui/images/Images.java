/* Ganesh Swing Client, developed in 2013 */
package ganesh.swing.ui.images;

import java.net.URL;

import javax.swing.ImageIcon;

public class Images {

	public static ImageIcon getFlag(String flag) {
		URL url = Images.class.getResource("flags/" + flag + ".jpg");

		if (url != null)
			return new ImageIcon(url);

		return null;
	}

	public static ImageIcon get(String image) {
		URL url = Images.class.getResource("general/" + image);

		if (url != null)
			return new ImageIcon(url);

		return null;
	}
}
