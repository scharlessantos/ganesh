/* Ganesh Swing Client, developed in 2013 */
package ganesh.swing.ui.images;

import java.net.URL;

import javax.swing.ImageIcon;

public class Images {

	/**
	 * <img src='./general/ganesh3.png'/>
	 */
	public static final String GANESH3 = "ganesh3";

	/**
	 * <img src='./general/ganesh2.png'/>
	 */
	public static final String GANESH2 = "ganesh2";

	/**
	 * <img src='./general/ganesh.png'/>
	 */
	public static final String GANESH = "ganesh";

	public static ImageIcon get(String image) {
		URL url = Images.class.getResource("general/" + image + ".png");

		if (url != null)
			return new ImageIcon(url);
		return null;
	}

	//============================
	// Bandeiras
	//============================

	public static class Flags {

		/**
		 * <img src='./flags/en_us_2.png'/>
		 */
		public static final String EN_US_2 = "en_us_2";

		/**
		 * <img src='./flags/pt_br.png'/>
		 */
		public static final String PT_BR = "pt_br";

		/**
		 * <img src='./flags/en_us.png'/>
		 */
		public static final String EN_US = "en_us";

		/**
		 * <img src='./flags/pt_br_2.png'/>
		 */
		public static final String PT_BR_2 = "pt_br_2";

		public static ImageIcon get(String image) {
			URL url = Images.class.getResource("flags/" + image + ".png");

			if (url != null)
				return new ImageIcon(url);
			return null;
		}

	}

	//============================
	// Icones
	//============================

	public static class Icons {

		/**
		 * <img src='./icons/user_phone.png'/>
		 */
		public static final String USER_PHONE = "user_phone";

		/**
		 * <img src='./icons/user_mature.png'/>
		 */
		public static final String USER_MATURE = "user_mature";

		/**
		 * <img src='./icons/group_add.png'/>
		 */
		public static final String GROUP_ADD = "group_add";

		/**
		 * <img src='./icons/door_in.png'/>
		 */
		public static final String DOOR_IN = "door_in";

		/**
		 * <img src='./icons/application_form.png'/>
		 */
		public static final String APPLICATION_FORM = "application_form";

		/**
		 * <img src='./icons/user.png'/>
		 */
		public static final String USER = "user";

		/**
		 * <img src='./icons/user_help.png'/>
		 */
		public static final String USER_HELP = "user_help";

		/**
		 * <img src='./icons/user_gray_phone.png'/>
		 */
		public static final String USER_GRAY_PHONE = "user_gray_phone";

		/**
		 * <img src='./icons/user_connect.png'/>
		 */
		public static final String USER_CONNECT = "user_connect";

		/**
		 * <img src='./icons/user_gray_plus.png'/>
		 */
		public static final String USER_GRAY_PLUS = "user_gray_plus";

		/**
		 * <img src='./icons/door_out.png'/>
		 */
		public static final String DOOR_OUT = "door_out";

		/**
		 * <img src='./icons/flag_green.png'/>
		 */
		public static final String FLAG_GREEN = "flag_green";

		/**
		 * <img src='./icons/group_edit.png'/>
		 */
		public static final String GROUP_EDIT = "group_edit";

		/**
		 * <img src='./icons/user_red.png'/>
		 */
		public static final String USER_RED = "user_red";

		/**
		 * <img src='./icons/user_gray_tick.png'/>
		 */
		public static final String USER_GRAY_TICK = "user_gray_tick";

		/**
		 * <img src='./icons/user_start.png'/>
		 */
		public static final String USER_START = "user_start";

		/**
		 * <img src='./icons/group.png'/>
		 */
		public static final String GROUP = "group";

		/**
		 * <img src='./icons/user_go.png'/>
		 */
		public static final String USER_GO = "user_go";

		/**
		 * <img src='./icons/user_gray_edit.png'/>
		 */
		public static final String USER_GRAY_EDIT = "user_gray_edit";

		/**
		 * <img src='./icons/user_stop.png'/>
		 */
		public static final String USER_STOP = "user_stop";

		/**
		 * <img src='./icons/user_cross.png'/>
		 */
		public static final String USER_CROSS = "user_cross";

		/**
		 * <img src='./icons/decline.png'/>
		 */
		public static final String DECLINE = "decline";

		/**
		 * <img src='./icons/user_plus.png'/>
		 */
		public static final String USER_PLUS = "user_plus";

		/**
		 * <img src='./icons/user_alert.png'/>
		 */
		public static final String USER_ALERT = "user_alert";

		/**
		 * <img src='./icons/group_key.png'/>
		 */
		public static final String GROUP_KEY = "group_key";

		/**
		 * <img src='./icons/folder_user.png'/>
		 */
		public static final String FOLDER_USER = "folder_user";

		/**
		 * <img src='./icons/user_comment.png'/>
		 */
		public static final String USER_COMMENT = "user_comment";

		/**
		 * <img src='./icons/user_brown.png'/>
		 */
		public static final String USER_BROWN = "user_brown";

		/**
		 * <img src='./icons/user_suit.png'/>
		 */
		public static final String USER_SUIT = "user_suit";

		/**
		 * <img src='./icons/user_gray_magnify.png'/>
		 */
		public static final String USER_GRAY_MAGNIFY = "user_gray_magnify";

		/**
		 * <img src='./icons/user_tick.png'/>
		 */
		public static final String USER_TICK = "user_tick";

		/**
		 * <img src='./icons/user_gray_add.png'/>
		 */
		public static final String USER_GRAY_ADD = "user_gray_add";

		/**
		 * <img src='./icons/user_disk.png'/>
		 */
		public static final String USER_DISK = "user_disk";

		/**
		 * <img src='./icons/report_user.png'/>
		 */
		public static final String REPORT_USER = "report_user";

		/**
		 * <img src='./icons/user_error.png'/>
		 */
		public static final String USER_ERROR = "user_error";

		/**
		 * <img src='./icons/user_gray.png'/>
		 */
		public static final String USER_GRAY = "user_gray";

		/**
		 * <img src='./icons/user_minus.png'/>
		 */
		public static final String USER_MINUS = "user_minus";

		/**
		 * <img src='./icons/user_gray_start.png'/>
		 */
		public static final String USER_GRAY_START = "user_gray_start";

		/**
		 * <img src='./icons/user_gray_cool.png'/>
		 */
		public static final String USER_GRAY_COOL = "user_gray_cool";

		/**
		 * <img src='./icons/group_delete.png'/>
		 */
		public static final String GROUP_DELETE = "group_delete";

		/**
		 * <img src='./icons/user_gray_delete.png'/>
		 */
		public static final String USER_GRAY_DELETE = "user_gray_delete";

		/**
		 * <img src='./icons/cog.png'/>
		 */
		public static final String COG = "cog";

		/**
		 * <img src='./icons/user_stop_alt.png'/>
		 */
		public static final String USER_STOP_ALT = "user_stop_alt";

		/**
		 * <img src='./icons/user_suit_black.png'/>
		 */
		public static final String USER_SUIT_BLACK = "user_suit_black";

		/**
		 * <img src='./icons/user_gray_stop_alt.png'/>
		 */
		public static final String USER_GRAY_STOP_ALT = "user_gray_stop_alt";

		/**
		 * <img src='./icons/user_gray_stop.png'/>
		 */
		public static final String USER_GRAY_STOP = "user_gray_stop";

		/**
		 * <img src='./icons/user_star.png'/>
		 */
		public static final String USER_STAR = "user_star";

		/**
		 * <img src='./icons/user_home.png'/>
		 */
		public static final String USER_HOME = "user_home";

		/**
		 * <img src='./icons/user_gray_key.png'/>
		 */
		public static final String USER_GRAY_KEY = "user_gray_key";

		/**
		 * <img src='./icons/user_b.png'/>
		 */
		public static final String USER_B = "user_b";

		/**
		 * <img src='./icons/user_information.png'/>
		 */
		public static final String USER_INFORMATION = "user_information";

		/**
		 * <img src='./icons/drive_user.png'/>
		 */
		public static final String DRIVE_USER = "drive_user";

		/**
		 * <img src='./icons/user_edit.png'/>
		 */
		public static final String USER_EDIT = "user_edit";

		/**
		 * <img src='./icons/user_magnify.png'/>
		 */
		public static final String USER_MAGNIFY = "user_magnify";

		/**
		 * <img src='./icons/user_orange.png'/>
		 */
		public static final String USER_ORANGE = "user_orange";

		/**
		 * <img src='./icons/user_female.png'/>
		 */
		public static final String USER_FEMALE = "user_female";

		/**
		 * <img src='./icons/user_delete.png'/>
		 */
		public static final String USER_DELETE = "user_delete";

		/**
		 * <img src='./icons/user_green.png'/>
		 */
		public static final String USER_GREEN = "user_green";

		/**
		 * <img src='./icons/user_key.png'/>
		 */
		public static final String USER_KEY = "user_key";

		/**
		 * <img src='./icons/user_earth.png'/>
		 */
		public static final String USER_EARTH = "user_earth";

		/**
		 * <img src='./icons/user_exclamation.png'/>
		 */
		public static final String USER_EXCLAMATION = "user_exclamation";

		/**
		 * <img src='./icons/user_add.png'/>
		 */
		public static final String USER_ADD = "user_add";

		/**
		 * <img src='./icons/user_gray_error.png'/>
		 */
		public static final String USER_GRAY_ERROR = "user_gray_error";

		public static ImageIcon get(String image) {
			URL url = Images.class.getResource("icons/" + image + ".png");

			if (url != null)
				return new ImageIcon(url);
			return null;
		}

	}

}
