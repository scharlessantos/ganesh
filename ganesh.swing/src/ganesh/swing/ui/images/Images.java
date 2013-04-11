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

	public static class Flags {

	}

	public static class Icons {

		public static final String COG = "cog.png";
		public static final String DECLINE = "decline.png";
		public static final String DOOR_IN = "door_in.png";
		public static final String DOOR_OUT = "door_out.png";
		public static final String GROUP = "group.png";
		public static final String GROUP_ADD = "group_add.png";
		public static final String GROUP_DELETE = "group_delete.png";
		public static final String GROUP_EDIT = "group_edit.png";

		public static ImageIcon get(String image) {
			URL url = Images.class.getResource("icons/" + image);

			if (url != null)
				return new ImageIcon(url);

			return null;
		}
	}
}
