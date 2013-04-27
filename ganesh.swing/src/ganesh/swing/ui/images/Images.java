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
		 * <img src='./icons/table_row_delete_faded.png'/>
		 */
		public static final String TABLE_ROW_DELETE_FADED = "table_row_delete_faded";

		/**
		 * <img src='./icons/weather_lightning.png'/>
		 */
		public static final String WEATHER_LIGHTNING = "weather_lightning";

		/**
		 * <img src='./icons/page_add.png'/>
		 */
		public static final String PAGE_ADD = "page_add";

		/**
		 * <img src='./icons/book_addresses_faded.png'/>
		 */
		public static final String BOOK_ADDRESSES_FADED = "book_addresses_faded";

		/**
		 * <img src='./icons/heart_faded.png'/>
		 */
		public static final String HEART_FADED = "heart_faded";

		/**
		 * <img src='./icons/weather_cloudy_lorry.png'/>
		 */
		public static final String WEATHER_CLOUDY_LORRY = "weather_cloudy_lorry";

		/**
		 * <img src='./icons/report_magnify.png'/>
		 */
		public static final String REPORT_MAGNIFY = "report_magnify";

		/**
		 * <img src='./icons/add.png'/>
		 */
		public static final String ADD = "add";

		/**
		 * <img src='./icons/control_fastforward.png'/>
		 */
		public static final String CONTROL_FASTFORWARD = "control_fastforward";

		/**
		 * <img src='./icons/medal_silver_1_faded.png'/>
		 */
		public static final String MEDAL_SILVER_1_FADED = "medal_silver_1_faded";

		/**
		 * <img src='./icons/script_code_faded.png'/>
		 */
		public static final String SCRIPT_CODE_FADED = "script_code_faded";

		/**
		 * <img src='./icons/user_phone.png'/>
		 */
		public static final String USER_PHONE = "user_phone";

		/**
		 * <img src='./icons/user_mature.png'/>
		 */
		public static final String USER_MATURE = "user_mature";

		/**
		 * <img src='./icons/browser_camino.png'/>
		 */
		public static final String BROWSER_CAMINO = "browser_camino";

		/**
		 * <img src='./icons/cup_edit_faded.png'/>
		 */
		public static final String CUP_EDIT_FADED = "cup_edit_faded";

		/**
		 * <img src='./icons/page_white_cplusplus.png'/>
		 */
		public static final String PAGE_WHITE_CPLUSPLUS = "page_white_cplusplus";

		/**
		 * <img src='./icons/picture_error.png'/>
		 */
		public static final String PICTURE_ERROR = "picture_error";

		/**
		 * <img src='./icons/font_faded.png'/>
		 */
		public static final String FONT_FADED = "font_faded";

		/**
		 * <img src='./icons/newspaper_add.png'/>
		 */
		public static final String NEWSPAPER_ADD = "newspaper_add";

		/**
		 * <img src='./icons/group_error.png'/>
		 */
		public static final String GROUP_ERROR = "group_error";

		/**
		 * <img src='./icons/phone_delete_faded.png'/>
		 */
		public static final String PHONE_DELETE_FADED = "phone_delete_faded";

		/**
		 * <img src='./icons/table_save_faded.png'/>
		 */
		public static final String TABLE_SAVE_FADED = "table_save_faded";

		/**
		 * <img src='./icons/medal_gold_1_faded.png'/>
		 */
		public static final String MEDAL_GOLD_1_FADED = "medal_gold_1_faded";

		/**
		 * <img src='./icons/user_red_faded.png'/>
		 */
		public static final String USER_RED_FADED = "user_red_faded";

		/**
		 * <img src='./icons/lightbulb_off.png'/>
		 */
		public static final String LIGHTBULB_OFF = "lightbulb_off";

		/**
		 * <img src='./icons/xhtml_add.png'/>
		 */
		public static final String XHTML_ADD = "xhtml_add";

		/**
		 * <img src='./icons/feed_magnify_faded.png'/>
		 */
		public static final String FEED_MAGNIFY_FADED = "feed_magnify_faded";

		/**
		 * <img src='./icons/page_error.png'/>
		 */
		public static final String PAGE_ERROR = "page_error";

		/**
		 * <img src='./icons/layers_faded.png'/>
		 */
		public static final String LAYERS_FADED = "layers_faded";

		/**
		 * <img src='./icons/bullet_orange.png'/>
		 */
		public static final String BULLET_ORANGE = "bullet_orange";

		/**
		 * <img src='./icons/arrow_right_faded.png'/>
		 */
		public static final String ARROW_RIGHT_FADED = "arrow_right_faded";

		/**
		 * <img src='./icons/vcard_faded.png'/>
		 */
		public static final String VCARD_FADED = "vcard_faded";

		/**
		 * <img src='./icons/date_magnify_faded.png'/>
		 */
		public static final String DATE_MAGNIFY_FADED = "date_magnify_faded";

		/**
		 * <img src='./icons/rss_go.png'/>
		 */
		public static final String RSS_GO = "rss_go";

		/**
		 * <img src='./icons/weather_cloudy_user_female.png'/>
		 */
		public static final String WEATHER_CLOUDY_USER_FEMALE = "weather_cloudy_user_female";

		/**
		 * <img src='./icons/calculator_edit.png'/>
		 */
		public static final String CALCULATOR_EDIT = "calculator_edit";

		/**
		 * <img src='./icons/map_go.png'/>
		 */
		public static final String MAP_GO = "map_go";

		/**
		 * <img src='./icons/group_add.png'/>
		 */
		public static final String GROUP_ADD = "group_add";

		/**
		 * <img src='./icons/folder_brick.png'/>
		 */
		public static final String FOLDER_BRICK = "folder_brick";

		/**
		 * <img src='./icons/map_go_faded.png'/>
		 */
		public static final String MAP_GO_FADED = "map_go_faded";

		/**
		 * <img src='./icons/new_faded.png'/>
		 */
		public static final String NEW_FADED = "new_faded";

		/**
		 * <img src='./icons/report_go_faded.png'/>
		 */
		public static final String REPORT_GO_FADED = "report_go_faded";

		/**
		 * <img src='./icons/male_faded.png'/>
		 */
		public static final String MALE_FADED = "male_faded";

		/**
		 * <img src='./icons/application_double.png'/>
		 */
		public static final String APPLICATION_DOUBLE = "application_double";

		/**
		 * <img src='./icons/asterisk_yellow.png'/>
		 */
		public static final String ASTERISK_YELLOW = "asterisk_yellow";

		/**
		 * <img src='./icons/user_female_add_faded.png'/>
		 */
		public static final String USER_FEMALE_ADD_FADED = "user_female_add_faded";

		/**
		 * <img src='./icons/textfield_add_faded.png'/>
		 */
		public static final String TEXTFIELD_ADD_FADED = "textfield_add_faded";

		/**
		 * <img src='./icons/page_attach.png'/>
		 */
		public static final String PAGE_ATTACH = "page_attach";

		/**
		 * <img src='./icons/webcam_delete_faded.png'/>
		 */
		public static final String WEBCAM_DELETE_FADED = "webcam_delete_faded";

		/**
		 * <img src='./icons/comment_add_faded.png'/>
		 */
		public static final String COMMENT_ADD_FADED = "comment_add_faded";

		/**
		 * <img src='./icons/server_uncompressed.png'/>
		 */
		public static final String SERVER_UNCOMPRESSED = "server_uncompressed";

		/**
		 * <img src='./icons/medal_bronze_1.png'/>
		 */
		public static final String MEDAL_BRONZE_1 = "medal_bronze_1";

		/**
		 * <img src='./icons/shape_square_link_faded.png'/>
		 */
		public static final String SHAPE_SQUARE_LINK_FADED = "shape_square_link_faded";

		/**
		 * <img src='./icons/control_back_faded.png'/>
		 */
		public static final String CONTROL_BACK_FADED = "control_back_faded";

		/**
		 * <img src='./icons/sport_basketball_faded.png'/>
		 */
		public static final String SPORT_BASKETBALL_FADED = "sport_basketball_faded";

		/**
		 * <img src='./icons/bin_empty_faded.png'/>
		 */
		public static final String BIN_EMPTY_FADED = "bin_empty_faded";

		/**
		 * <img src='./icons/telephone_key.png'/>
		 */
		public static final String TELEPHONE_KEY = "telephone_key";

		/**
		 * <img src='./icons/arrow_divide_down_red.png'/>
		 */
		public static final String ARROW_DIVIDE_DOWN_RED = "arrow_divide_down_red";

		/**
		 * <img src='./icons/award_star_bronze_1_faded.png'/>
		 */
		public static final String AWARD_STAR_BRONZE_1_FADED = "award_star_bronze_1_faded";

		/**
		 * <img src='./icons/paste_word.png'/>
		 */
		public static final String PASTE_WORD = "paste_word";

		/**
		 * <img src='./icons/script_link_faded.png'/>
		 */
		public static final String SCRIPT_LINK_FADED = "script_link_faded";

		/**
		 * <img src='./icons/weather_rain_faded.png'/>
		 */
		public static final String WEATHER_RAIN_FADED = "weather_rain_faded";

		/**
		 * <img src='./icons/sound_faded.png'/>
		 */
		public static final String SOUND_FADED = "sound_faded";

		/**
		 * <img src='./icons/newspaper_faded.png'/>
		 */
		public static final String NEWSPAPER_FADED = "newspaper_faded";

		/**
		 * <img src='./icons/telephone_go_faded.png'/>
		 */
		public static final String TELEPHONE_GO_FADED = "telephone_go_faded";

		/**
		 * <img src='./icons/tab_delete.png'/>
		 */
		public static final String TAB_DELETE = "tab_delete";

		/**
		 * <img src='./icons/emoticon_grin_faded.png'/>
		 */
		public static final String EMOTICON_GRIN_FADED = "emoticon_grin_faded";

		/**
		 * <img src='./icons/door_open_faded.png'/>
		 */
		public static final String DOOR_OPEN_FADED = "door_open_faded";

		/**
		 * <img src='./icons/printer_add.png'/>
		 */
		public static final String PRINTER_ADD = "printer_add";

		/**
		 * <img src='./icons/drive_edit.png'/>
		 */
		public static final String DRIVE_EDIT = "drive_edit";

		/**
		 * <img src='./icons/style_go.png'/>
		 */
		public static final String STYLE_GO = "style_go";

		/**
		 * <img src='./icons/page_white_find_faded.png'/>
		 */
		public static final String PAGE_WHITE_FIND_FADED = "page_white_find_faded";

		/**
		 * <img src='./icons/feed_add_faded.png'/>
		 */
		public static final String FEED_ADD_FADED = "feed_add_faded";

		/**
		 * <img src='./icons/door_in.png'/>
		 */
		public static final String DOOR_IN = "door_in";

		/**
		 * <img src='./icons/transmit_edit.png'/>
		 */
		public static final String TRANSMIT_EDIT = "transmit_edit";

		/**
		 * <img src='./icons/text_replace.png'/>
		 */
		public static final String TEXT_REPLACE = "text_replace";

		/**
		 * <img src='./icons/bullet_feed.png'/>
		 */
		public static final String BULLET_FEED = "bullet_feed";

		/**
		 * <img src='./icons/award_star_silver_1_faded.png'/>
		 */
		public static final String AWARD_STAR_SILVER_1_FADED = "award_star_silver_1_faded";

		/**
		 * <img src='./icons/css_go.png'/>
		 */
		public static final String CSS_GO = "css_go";

		/**
		 * <img src='./icons/drive_burn.png'/>
		 */
		public static final String DRIVE_BURN = "drive_burn";

		/**
		 * <img src='./icons/printer_empty.png'/>
		 */
		public static final String PRINTER_EMPTY = "printer_empty";

		/**
		 * <img src='./icons/calculator.png'/>
		 */
		public static final String CALCULATOR = "calculator";

		/**
		 * <img src='./icons/image_faded.png'/>
		 */
		public static final String IMAGE_FADED = "image_faded";

		/**
		 * <img src='./icons/database_refresh_faded.png'/>
		 */
		public static final String DATABASE_REFRESH_FADED = "database_refresh_faded";

		/**
		 * <img src='./icons/tag_green.png'/>
		 */
		public static final String TAG_GREEN = "tag_green";

		/**
		 * <img src='./icons/application_cascade_delete_faded.png'/>
		 */
		public static final String APPLICATION_CASCADE_DELETE_FADED = "application_cascade_delete_faded";

		/**
		 * <img src='./icons/tag.png'/>
		 */
		public static final String TAG = "tag";

		/**
		 * <img src='./icons/contrast_increase.png'/>
		 */
		public static final String CONTRAST_INCREASE = "contrast_increase";

		/**
		 * <img src='./icons/arrow_refresh_small_red_faded.png'/>
		 */
		public static final String ARROW_REFRESH_SMALL_RED_FADED = "arrow_refresh_small_red_faded";

		/**
		 * <img src='./icons/browser_mozilla_faded.png'/>
		 */
		public static final String BROWSER_MOZILLA_FADED = "browser_mozilla_faded";

		/**
		 * <img src='./icons/table_lightning.png'/>
		 */
		public static final String TABLE_LIGHTNING = "table_lightning";

		/**
		 * <img src='./icons/contrast_faded.png'/>
		 */
		public static final String CONTRAST_FADED = "contrast_faded";

		/**
		 * <img src='./icons/drive_link_faded.png'/>
		 */
		public static final String DRIVE_LINK_FADED = "drive_link_faded";

		/**
		 * <img src='./icons/page_white_swoosh_faded.png'/>
		 */
		public static final String PAGE_WHITE_SWOOSH_FADED = "page_white_swoosh_faded";

		/**
		 * <img src='./icons/tab_go.png'/>
		 */
		public static final String TAB_GO = "tab_go";

		/**
		 * <img src='./icons/pictures.png'/>
		 */
		public static final String PICTURES = "pictures";

		/**
		 * <img src='./icons/tag_blue_add_faded.png'/>
		 */
		public static final String TAG_BLUE_ADD_FADED = "tag_blue_add_faded";

		/**
		 * <img src='./icons/weather_sun_lorry.png'/>
		 */
		public static final String WEATHER_SUN_LORRY = "weather_sun_lorry";

		/**
		 * <img src='./icons/user_edit_faded.png'/>
		 */
		public static final String USER_EDIT_FADED = "user_edit_faded";

		/**
		 * <img src='./icons/browser_galeon.png'/>
		 */
		public static final String BROWSER_GALEON = "browser_galeon";

		/**
		 * <img src='./icons/text_underline.png'/>
		 */
		public static final String TEXT_UNDERLINE = "text_underline";

		/**
		 * <img src='./icons/date_add_faded.png'/>
		 */
		public static final String DATE_ADD_FADED = "date_add_faded";

		/**
		 * <img src='./icons/bullet_toggle_minus.png'/>
		 */
		public static final String BULLET_TOGGLE_MINUS = "bullet_toggle_minus";

		/**
		 * <img src='./icons/resultset_last.png'/>
		 */
		public static final String RESULTSET_LAST = "resultset_last";

		/**
		 * <img src='./icons/table_edit_faded.png'/>
		 */
		public static final String TABLE_EDIT_FADED = "table_edit_faded";

		/**
		 * <img src='./icons/page_gear_faded.png'/>
		 */
		public static final String PAGE_GEAR_FADED = "page_gear_faded";

		/**
		 * <img src='./icons/browser_galeon_faded.png'/>
		 */
		public static final String BROWSER_GALEON_FADED = "browser_galeon_faded";

		/**
		 * <img src='./icons/folder_wrench.png'/>
		 */
		public static final String FOLDER_WRENCH = "folder_wrench";

		/**
		 * <img src='./icons/script_save_faded.png'/>
		 */
		public static final String SCRIPT_SAVE_FADED = "script_save_faded";

		/**
		 * <img src='./icons/key.png'/>
		 */
		public static final String KEY = "key";

		/**
		 * <img src='./icons/chart_line_error.png'/>
		 */
		public static final String CHART_LINE_ERROR = "chart_line_error";

		/**
		 * <img src='./icons/cd_edit.png'/>
		 */
		public static final String CD_EDIT = "cd_edit";

		/**
		 * <img src='./icons/bell_add_faded.png'/>
		 */
		public static final String BELL_ADD_FADED = "bell_add_faded";

		/**
		 * <img src='./icons/drive_disk_faded.png'/>
		 */
		public static final String DRIVE_DISK_FADED = "drive_disk_faded";

		/**
		 * <img src='./icons/chart_curve_faded.png'/>
		 */
		public static final String CHART_CURVE_FADED = "chart_curve_faded";

		/**
		 * <img src='./icons/bell_delete.png'/>
		 */
		public static final String BELL_DELETE = "bell_delete";

		/**
		 * <img src='./icons/table_multiple_faded.png'/>
		 */
		public static final String TABLE_MULTIPLE_FADED = "table_multiple_faded";

		/**
		 * <img src='./icons/control_fastforward_blue.png'/>
		 */
		public static final String CONTROL_FASTFORWARD_BLUE = "control_fastforward_blue";

		/**
		 * <img src='./icons/user_orange_faded.png'/>
		 */
		public static final String USER_ORANGE_FADED = "user_orange_faded";

		/**
		 * <img src='./icons/calculator_error.png'/>
		 */
		public static final String CALCULATOR_ERROR = "calculator_error";

		/**
		 * <img src='./icons/transmit_faded.png'/>
		 */
		public static final String TRANSMIT_FADED = "transmit_faded";

		/**
		 * <img src='./icons/sport_shuttlecock.png'/>
		 */
		public static final String SPORT_SHUTTLECOCK = "sport_shuttlecock";

		/**
		 * <img src='./icons/shape_align_middle_faded.png'/>
		 */
		public static final String SHAPE_ALIGN_MIDDLE_FADED = "shape_align_middle_faded";

		/**
		 * <img src='./icons/camera_error.png'/>
		 */
		public static final String CAMERA_ERROR = "camera_error";

		/**
		 * <img src='./icons/music_save_faded.png'/>
		 */
		public static final String MUSIC_SAVE_FADED = "music_save_faded";

		/**
		 * <img src='./icons/ruby_add.png'/>
		 */
		public static final String RUBY_ADD = "ruby_add";

		/**
		 * <img src='./icons/page_code.png'/>
		 */
		public static final String PAGE_CODE = "page_code";

		/**
		 * <img src='./icons/folder_edit_faded.png'/>
		 */
		public static final String FOLDER_EDIT_FADED = "folder_edit_faded";

		/**
		 * <img src='./icons/time.png'/>
		 */
		public static final String TIME = "time";

		/**
		 * <img src='./icons/key_delete_faded.png'/>
		 */
		public static final String KEY_DELETE_FADED = "key_delete_faded";

		/**
		 * <img src='./icons/male_time.png'/>
		 */
		public static final String MALE_TIME = "male_time";

		/**
		 * <img src='./icons/browser_seamonkey_faded.png'/>
		 */
		public static final String BROWSER_SEAMONKEY_FADED = "browser_seamonkey_faded";

		/**
		 * <img src='./icons/bullet_orange_faded.png'/>
		 */
		public static final String BULLET_ORANGE_FADED = "bullet_orange_faded";

		/**
		 * <img src='./icons/arrow_left.png'/>
		 */
		public static final String ARROW_LEFT = "arrow_left";

		/**
		 * <img src='./icons/award_star_silver_2_faded.png'/>
		 */
		public static final String AWARD_STAR_SILVER_2_FADED = "award_star_silver_2_faded";

		/**
		 * <img src='./icons/shield_go_faded.png'/>
		 */
		public static final String SHIELD_GO_FADED = "shield_go_faded";

		/**
		 * <img src='./icons/key_add.png'/>
		 */
		public static final String KEY_ADD = "key_add";

		/**
		 * <img src='./icons/sound.png'/>
		 */
		public static final String SOUND = "sound";

		/**
		 * <img src='./icons/vcard_add.png'/>
		 */
		public static final String VCARD_ADD = "vcard_add";

		/**
		 * <img src='./icons/table_add.png'/>
		 */
		public static final String TABLE_ADD = "table_add";

		/**
		 * <img src='./icons/book_delete_faded.png'/>
		 */
		public static final String BOOK_DELETE_FADED = "book_delete_faded";

		/**
		 * <img src='./icons/folder_page.png'/>
		 */
		public static final String FOLDER_PAGE = "folder_page";

		/**
		 * <img src='./icons/text_padding_top_faded.png'/>
		 */
		public static final String TEXT_PADDING_TOP_FADED = "text_padding_top_faded";

		/**
		 * <img src='./icons/link_add_faded.png'/>
		 */
		public static final String LINK_ADD_FADED = "link_add_faded";

		/**
		 * <img src='./icons/contrast_low.png'/>
		 */
		public static final String CONTRAST_LOW = "contrast_low";

		/**
		 * <img src='./icons/chart_bar_faded.png'/>
		 */
		public static final String CHART_BAR_FADED = "chart_bar_faded";

		/**
		 * <img src='./icons/email_link.png'/>
		 */
		public static final String EMAIL_LINK = "email_link";

		/**
		 * <img src='./icons/tag_blue_faded.png'/>
		 */
		public static final String TAG_BLUE_FADED = "tag_blue_faded";

		/**
		 * <img src='./icons/money_dollar_faded.png'/>
		 */
		public static final String MONEY_DOLLAR_FADED = "money_dollar_faded";

		/**
		 * <img src='./icons/application_side_list_faded.png'/>
		 */
		public static final String APPLICATION_SIDE_LIST_FADED = "application_side_list_faded";

		/**
		 * <img src='./icons/cd_edit_faded.png'/>
		 */
		public static final String CD_EDIT_FADED = "cd_edit_faded";

		/**
		 * <img src='./icons/map_magnify_faded.png'/>
		 */
		public static final String MAP_MAGNIFY_FADED = "map_magnify_faded";

		/**
		 * <img src='./icons/clock_pause_faded.png'/>
		 */
		public static final String CLOCK_PAUSE_FADED = "clock_pause_faded";

		/**
		 * <img src='./icons/page_world_faded.png'/>
		 */
		public static final String PAGE_WORLD_FADED = "page_world_faded";

		/**
		 * <img src='./icons/page_white_text_width_faded.png'/>
		 */
		public static final String PAGE_WHITE_TEXT_WIDTH_FADED = "page_white_text_width_faded";

		/**
		 * <img src='./icons/browser_mozilla.png'/>
		 */
		public static final String BROWSER_MOZILLA = "browser_mozilla";

		/**
		 * <img src='./icons/chart_organisation_delete_faded.png'/>
		 */
		public static final String CHART_ORGANISATION_DELETE_FADED = "chart_organisation_delete_faded";

		/**
		 * <img src='./icons/cog_go.png'/>
		 */
		public static final String COG_GO = "cog_go";

		/**
		 * <img src='./icons/award_star_silver_1.png'/>
		 */
		public static final String AWARD_STAR_SILVER_1 = "award_star_silver_1";

		/**
		 * <img src='./icons/chart_organisation.png'/>
		 */
		public static final String CHART_ORGANISATION = "chart_organisation";

		/**
		 * <img src='./icons/chart_curve_delete.png'/>
		 */
		public static final String CHART_CURVE_DELETE = "chart_curve_delete";

		/**
		 * <img src='./icons/computer_faded.png'/>
		 */
		public static final String COMPUTER_FADED = "computer_faded";

		/**
		 * <img src='./icons/computer_edit_faded.png'/>
		 */
		public static final String COMPUTER_EDIT_FADED = "computer_edit_faded";

		/**
		 * <img src='./icons/calendar_view_day_faded.png'/>
		 */
		public static final String CALENDAR_VIEW_DAY_FADED = "calendar_view_day_faded";

		/**
		 * <img src='./icons/page_attach_faded.png'/>
		 */
		public static final String PAGE_ATTACH_FADED = "page_attach_faded";

		/**
		 * <img src='./icons/chart_line_delete.png'/>
		 */
		public static final String CHART_LINE_DELETE = "chart_line_delete";

		/**
		 * <img src='./icons/shape_align_right.png'/>
		 */
		public static final String SHAPE_ALIGN_RIGHT = "shape_align_right";

		/**
		 * <img src='./icons/images.png'/>
		 */
		public static final String IMAGES = "images";

		/**
		 * <img src='./icons/page_white_php_faded.png'/>
		 */
		public static final String PAGE_WHITE_PHP_FADED = "page_white_php_faded";

		/**
		 * <img src='./icons/controller_delete.png'/>
		 */
		public static final String CONTROLLER_DELETE = "controller_delete";

		/**
		 * <img src='./icons/music.png'/>
		 */
		public static final String MUSIC = "music";

		/**
		 * <img src='./icons/arrow_join_red_faded.png'/>
		 */
		public static final String ARROW_JOIN_RED_FADED = "arrow_join_red_faded";

		/**
		 * <img src='./icons/joystick_faded.png'/>
		 */
		public static final String JOYSTICK_FADED = "joystick_faded";

		/**
		 * <img src='./icons/note_error_faded.png'/>
		 */
		public static final String NOTE_ERROR_FADED = "note_error_faded";

		/**
		 * <img src='./icons/book_previous_faded.png'/>
		 */
		public static final String BOOK_PREVIOUS_FADED = "book_previous_faded";

		/**
		 * <img src='./icons/film_key.png'/>
		 */
		public static final String FILM_KEY = "film_key";

		/**
		 * <img src='./icons/eye.png'/>
		 */
		public static final String EYE = "eye";

		/**
		 * <img src='./icons/chart_organisation_add_faded.png'/>
		 */
		public static final String CHART_ORGANISATION_ADD_FADED = "chart_organisation_add_faded";

		/**
		 * <img src='./icons/television_delete_faded.png'/>
		 */
		public static final String TELEVISION_DELETE_FADED = "television_delete_faded";

		/**
		 * <img src='./icons/arrow_up.png'/>
		 */
		public static final String ARROW_UP = "arrow_up";

		/**
		 * <img src='./icons/bullet_arrow_bottom_faded.png'/>
		 */
		public static final String BULLET_ARROW_BOTTOM_FADED = "bullet_arrow_bottom_faded";

		/**
		 * <img src='./icons/car_delete.png'/>
		 */
		public static final String CAR_DELETE = "car_delete";

		/**
		 * <img src='./icons/award_star_silver_3.png'/>
		 */
		public static final String AWARD_STAR_SILVER_3 = "award_star_silver_3";

		/**
		 * <img src='./icons/application_osx_faded.png'/>
		 */
		public static final String APPLICATION_OSX_FADED = "application_osx_faded";

		/**
		 * <img src='./icons/compress_faded.png'/>
		 */
		public static final String COMPRESS_FADED = "compress_faded";

		/**
		 * <img src='./icons/page_save.png'/>
		 */
		public static final String PAGE_SAVE = "page_save";

		/**
		 * <img src='./icons/page_white_csharp.png'/>
		 */
		public static final String PAGE_WHITE_CSHARP = "page_white_csharp";

		/**
		 * <img src='./icons/lock_faded.png'/>
		 */
		public static final String LOCK_FADED = "lock_faded";

		/**
		 * <img src='./icons/tag_red_faded.png'/>
		 */
		public static final String TAG_RED_FADED = "tag_red_faded";

		/**
		 * <img src='./icons/control_eject.png'/>
		 */
		public static final String CONTROL_EJECT = "control_eject";

		/**
		 * <img src='./icons/clock_error_faded.png'/>
		 */
		public static final String CLOCK_ERROR_FADED = "clock_error_faded";

		/**
		 * <img src='./icons/money_delete.png'/>
		 */
		public static final String MONEY_DELETE = "money_delete";

		/**
		 * <img src='./icons/key_add_faded.png'/>
		 */
		public static final String KEY_ADD_FADED = "key_add_faded";

		/**
		 * <img src='./icons/application_form.png'/>
		 */
		public static final String APPLICATION_FORM = "application_form";

		/**
		 * <img src='./icons/shape_handles.png'/>
		 */
		public static final String SHAPE_HANDLES = "shape_handles";

		/**
		 * <img src='./icons/creditcards.png'/>
		 */
		public static final String CREDITCARDS = "creditcards";

		/**
		 * <img src='./icons/disconnect.png'/>
		 */
		public static final String DISCONNECT = "disconnect";

		/**
		 * <img src='./icons/package_delete_faded.png'/>
		 */
		public static final String PACKAGE_DELETE_FADED = "package_delete_faded";

		/**
		 * <img src='./icons/control_play_down.png'/>
		 */
		public static final String CONTROL_PLAY_DOWN = "control_play_down";

		/**
		 * <img src='./icons/application_form_faded.png'/>
		 */
		public static final String APPLICATION_FORM_FADED = "application_form_faded";

		/**
		 * <img src='./icons/page_white_faded.png'/>
		 */
		public static final String PAGE_WHITE_FADED = "page_white_faded";

		/**
		 * <img src='./icons/page_white_delete_faded.png'/>
		 */
		public static final String PAGE_WHITE_DELETE_FADED = "page_white_delete_faded";

		/**
		 * <img src='./icons/bug_go.png'/>
		 */
		public static final String BUG_GO = "bug_go";

		/**
		 * <img src='./icons/bug_faded.png'/>
		 */
		public static final String BUG_FADED = "bug_faded";

		/**
		 * <img src='./icons/book_go_faded.png'/>
		 */
		public static final String BOOK_GO_FADED = "book_go_faded";

		/**
		 * <img src='./icons/medal_bronze_add.png'/>
		 */
		public static final String MEDAL_BRONZE_ADD = "medal_bronze_add";

		/**
		 * <img src='./icons/pill_go.png'/>
		 */
		public static final String PILL_GO = "pill_go";

		/**
		 * <img src='./icons/cart_edit_faded.png'/>
		 */
		public static final String CART_EDIT_FADED = "cart_edit_faded";

		/**
		 * <img src='./icons/bell.png'/>
		 */
		public static final String BELL = "bell";

		/**
		 * <img src='./icons/cd_delete.png'/>
		 */
		public static final String CD_DELETE = "cd_delete";

		/**
		 * <img src='./icons/award_star_gold_2.png'/>
		 */
		public static final String AWARD_STAR_GOLD_2 = "award_star_gold_2";

		/**
		 * <img src='./icons/keyboard.png'/>
		 */
		public static final String KEYBOARD = "keyboard";

		/**
		 * <img src='./icons/lorry_weather_cloudy_faded.png'/>
		 */
		public static final String LORRY_WEATHER_CLOUDY_FADED = "lorry_weather_cloudy_faded";

		/**
		 * <img src='./icons/page_white_get_faded.png'/>
		 */
		public static final String PAGE_WHITE_GET_FADED = "page_white_get_faded";

		/**
		 * <img src='./icons/error_go.png'/>
		 */
		public static final String ERROR_GO = "error_go";

		/**
		 * <img src='./icons/user.png'/>
		 */
		public static final String USER = "user";

		/**
		 * <img src='./icons/door_in_faded.png'/>
		 */
		public static final String DOOR_IN_FADED = "door_in_faded";

		/**
		 * <img src='./icons/arrow_refresh_small_faded.png'/>
		 */
		public static final String ARROW_REFRESH_SMALL_FADED = "arrow_refresh_small_faded";

		/**
		 * <img src='./icons/arrow_up_red_faded.png'/>
		 */
		public static final String ARROW_UP_RED_FADED = "arrow_up_red_faded";

		/**
		 * <img src='./icons/page_white_cup_faded.png'/>
		 */
		public static final String PAGE_WHITE_CUP_FADED = "page_white_cup_faded";

		/**
		 * <img src='./icons/lorry_group_faded.png'/>
		 */
		public static final String LORRY_GROUP_FADED = "lorry_group_faded";

		/**
		 * <img src='./icons/calculator_add_faded.png'/>
		 */
		public static final String CALCULATOR_ADD_FADED = "calculator_add_faded";

		/**
		 * <img src='./icons/folder_key_faded.png'/>
		 */
		public static final String FOLDER_KEY_FADED = "folder_key_faded";

		/**
		 * <img src='./icons/cup_faded.png'/>
		 */
		public static final String CUP_FADED = "cup_faded";

		/**
		 * <img src='./icons/table_faded.png'/>
		 */
		public static final String TABLE_FADED = "table_faded";

		/**
		 * <img src='./icons/telephone_link.png'/>
		 */
		public static final String TELEPHONE_LINK = "telephone_link";

		/**
		 * <img src='./icons/tab_go_faded.png'/>
		 */
		public static final String TAB_GO_FADED = "tab_go_faded";

		/**
		 * <img src='./icons/vector_faded.png'/>
		 */
		public static final String VECTOR_FADED = "vector_faded";

		/**
		 * <img src='./icons/cross_faded.png'/>
		 */
		public static final String CROSS_FADED = "cross_faded";

		/**
		 * <img src='./icons/chart_bar_error_faded.png'/>
		 */
		public static final String CHART_BAR_ERROR_FADED = "chart_bar_error_faded";

		/**
		 * <img src='./icons/calendar_link_faded.png'/>
		 */
		public static final String CALENDAR_LINK_FADED = "calendar_link_faded";

		/**
		 * <img src='./icons/shape_square_edit_faded.png'/>
		 */
		public static final String SHAPE_SQUARE_EDIT_FADED = "shape_square_edit_faded";

		/**
		 * <img src='./icons/bullet_arrow_down.png'/>
		 */
		public static final String BULLET_ARROW_DOWN = "bullet_arrow_down";

		/**
		 * <img src='./icons/note_delete.png'/>
		 */
		public static final String NOTE_DELETE = "note_delete";

		/**
		 * <img src='./icons/user_help.png'/>
		 */
		public static final String USER_HELP = "user_help";

		/**
		 * <img src='./icons/script_date_faded.png'/>
		 */
		public static final String SCRIPT_DATE_FADED = "script_date_faded";

		/**
		 * <img src='./icons/page_white_paintbrush_faded.png'/>
		 */
		public static final String PAGE_WHITE_PAINTBRUSH_FADED = "page_white_paintbrush_faded";

		/**
		 * <img src='./icons/clock_stop.png'/>
		 */
		public static final String CLOCK_STOP = "clock_stop";

		/**
		 * <img src='./icons/award_star_gold_3.png'/>
		 */
		public static final String AWARD_STAR_GOLD_3 = "award_star_gold_3";

		/**
		 * <img src='./icons/page_copy_faded.png'/>
		 */
		public static final String PAGE_COPY_FADED = "page_copy_faded";

		/**
		 * <img src='./icons/camera_delete.png'/>
		 */
		public static final String CAMERA_DELETE = "camera_delete";

		/**
		 * <img src='./icons/basket_add.png'/>
		 */
		public static final String BASKET_ADD = "basket_add";

		/**
		 * <img src='./icons/folder_page_white_faded.png'/>
		 */
		public static final String FOLDER_PAGE_WHITE_FADED = "folder_page_white_faded";

		/**
		 * <img src='./icons/font_add.png'/>
		 */
		public static final String FONT_ADD = "font_add";

		/**
		 * <img src='./icons/shield.png'/>
		 */
		public static final String SHIELD = "shield";

		/**
		 * <img src='./icons/page_red.png'/>
		 */
		public static final String PAGE_RED = "page_red";

		/**
		 * <img src='./icons/magifier_zoom_out.png'/>
		 */
		public static final String MAGIFIER_ZOOM_OUT = "magifier_zoom_out";

		/**
		 * <img src='./icons/page_word.png'/>
		 */
		public static final String PAGE_WORD = "page_word";

		/**
		 * <img src='./icons/image_link_faded.png'/>
		 */
		public static final String IMAGE_LINK_FADED = "image_link_faded";

		/**
		 * <img src='./icons/book_open.png'/>
		 */
		public static final String BOOK_OPEN = "book_open";

		/**
		 * <img src='./icons/server_add.png'/>
		 */
		public static final String SERVER_ADD = "server_add";

		/**
		 * <img src='./icons/email_delete.png'/>
		 */
		public static final String EMAIL_DELETE = "email_delete";

		/**
		 * <img src='./icons/folder_bell_faded.png'/>
		 */
		public static final String FOLDER_BELL_FADED = "folder_bell_faded";

		/**
		 * <img src='./icons/phone.png'/>
		 */
		public static final String PHONE = "phone";

		/**
		 * <img src='./icons/camera_faded.png'/>
		 */
		public static final String CAMERA_FADED = "camera_faded";

		/**
		 * <img src='./icons/folder_add.png'/>
		 */
		public static final String FOLDER_ADD = "folder_add";

		/**
		 * <img src='./icons/picture.png'/>
		 */
		public static final String PICTURE = "picture";

		/**
		 * <img src='./icons/pilcrow.png'/>
		 */
		public static final String PILCROW = "pilcrow";

		/**
		 * <img src='./icons/bullet_arrow_top_faded.png'/>
		 */
		public static final String BULLET_ARROW_TOP_FADED = "bullet_arrow_top_faded";

		/**
		 * <img src='./icons/arrow_out.png'/>
		 */
		public static final String ARROW_OUT = "arrow_out";

		/**
		 * <img src='./icons/plugin_faded.png'/>
		 */
		public static final String PLUGIN_FADED = "plugin_faded";

		/**
		 * <img src='./icons/application_view_list_faded.png'/>
		 */
		public static final String APPLICATION_VIEW_LIST_FADED = "application_view_list_faded";

		/**
		 * <img src='./icons/keyboard_add.png'/>
		 */
		public static final String KEYBOARD_ADD = "keyboard_add";

		/**
		 * <img src='./icons/control_equalizer_blue_faded.png'/>
		 */
		public static final String CONTROL_EQUALIZER_BLUE_FADED = "control_equalizer_blue_faded";

		/**
		 * <img src='./icons/transmit_delete_faded.png'/>
		 */
		public static final String TRANSMIT_DELETE_FADED = "transmit_delete_faded";

		/**
		 * <img src='./icons/layout_header.png'/>
		 */
		public static final String LAYOUT_HEADER = "layout_header";

		/**
		 * <img src='./icons/award_star_add.png'/>
		 */
		public static final String AWARD_STAR_ADD = "award_star_add";

		/**
		 * <img src='./icons/bullet_add.png'/>
		 */
		public static final String BULLET_ADD = "bullet_add";

		/**
		 * <img src='./icons/chart_curve_add_faded.png'/>
		 */
		public static final String CHART_CURVE_ADD_FADED = "chart_curve_add_faded";

		/**
		 * <img src='./icons/dvd_link_faded.png'/>
		 */
		public static final String DVD_LINK_FADED = "dvd_link_faded";

		/**
		 * <img src='./icons/email_error_faded.png'/>
		 */
		public static final String EMAIL_ERROR_FADED = "email_error_faded";

		/**
		 * <img src='./icons/monitor_go.png'/>
		 */
		public static final String MONITOR_GO = "monitor_go";

		/**
		 * <img src='./icons/database_lightning_faded.png'/>
		 */
		public static final String DATABASE_LIGHTNING_FADED = "database_lightning_faded";

		/**
		 * <img src='./icons/server_error_faded.png'/>
		 */
		public static final String SERVER_ERROR_FADED = "server_error_faded";

		/**
		 * <img src='./icons/style_delete_faded.png'/>
		 */
		public static final String STYLE_DELETE_FADED = "style_delete_faded";

		/**
		 * <img src='./icons/computer_go_faded.png'/>
		 */
		public static final String COMPUTER_GO_FADED = "computer_go_faded";

		/**
		 * <img src='./icons/bullet_red_faded.png'/>
		 */
		public static final String BULLET_RED_FADED = "bullet_red_faded";

		/**
		 * <img src='./icons/group_add_faded.png'/>
		 */
		public static final String GROUP_ADD_FADED = "group_add_faded";

		/**
		 * <img src='./icons/weather_cloudy_add_faded.png'/>
		 */
		public static final String WEATHER_CLOUDY_ADD_FADED = "weather_cloudy_add_faded";

		/**
		 * <img src='./icons/shading_faded.png'/>
		 */
		public static final String SHADING_FADED = "shading_faded";

		/**
		 * <img src='./icons/car_delete_faded.png'/>
		 */
		public static final String CAR_DELETE_FADED = "car_delete_faded";

		/**
		 * <img src='./icons/emoticon_grin.png'/>
		 */
		public static final String EMOTICON_GRIN = "emoticon_grin";

		/**
		 * <img src='./icons/font_go.png'/>
		 */
		public static final String FONT_GO = "font_go";

		/**
		 * <img src='./icons/sound_delete_faded.png'/>
		 */
		public static final String SOUND_DELETE_FADED = "sound_delete_faded";

		/**
		 * <img src='./icons/date_go_faded.png'/>
		 */
		public static final String DATE_GO_FADED = "date_go_faded";

		/**
		 * <img src='./icons/plugin.png'/>
		 */
		public static final String PLUGIN = "plugin";

		/**
		 * <img src='./icons/error_delete_faded.png'/>
		 */
		public static final String ERROR_DELETE_FADED = "error_delete_faded";

		/**
		 * <img src='./icons/style_add.png'/>
		 */
		public static final String STYLE_ADD = "style_add";

		/**
		 * <img src='./icons/lock_break_faded.png'/>
		 */
		public static final String LOCK_BREAK_FADED = "lock_break_faded";

		/**
		 * <img src='./icons/script_money_faded.png'/>
		 */
		public static final String SCRIPT_MONEY_FADED = "script_money_faded";

		/**
		 * <img src='./icons/browser_konqueror.png'/>
		 */
		public static final String BROWSER_KONQUEROR = "browser_konqueror";

		/**
		 * <img src='./icons/text_allcaps_faded.png'/>
		 */
		public static final String TEXT_ALLCAPS_FADED = "text_allcaps_faded";

		/**
		 * <img src='./icons/page_white_star_faded.png'/>
		 */
		public static final String PAGE_WHITE_STAR_FADED = "page_white_star_faded";

		/**
		 * <img src='./icons/medal_gold_2.png'/>
		 */
		public static final String MEDAL_GOLD_2 = "medal_gold_2";

		/**
		 * <img src='./icons/table_gear_faded.png'/>
		 */
		public static final String TABLE_GEAR_FADED = "table_gear_faded";

		/**
		 * <img src='./icons/database_connect_faded.png'/>
		 */
		public static final String DATABASE_CONNECT_FADED = "database_connect_faded";

		/**
		 * <img src='./icons/page_paste.png'/>
		 */
		public static final String PAGE_PASTE = "page_paste";

		/**
		 * <img src='./icons/feed_error.png'/>
		 */
		public static final String FEED_ERROR = "feed_error";

		/**
		 * <img src='./icons/telephone_add_faded.png'/>
		 */
		public static final String TELEPHONE_ADD_FADED = "telephone_add_faded";

		/**
		 * <img src='./icons/arrow_rotate_clockwise_red_faded.png'/>
		 */
		public static final String ARROW_ROTATE_CLOCKWISE_RED_FADED = "arrow_rotate_clockwise_red_faded";

		/**
		 * <img src='./icons/money_add.png'/>
		 */
		public static final String MONEY_ADD = "money_add";

		/**
		 * <img src='./icons/computer_link.png'/>
		 */
		public static final String COMPUTER_LINK = "computer_link";

		/**
		 * <img src='./icons/page_white_gear_faded.png'/>
		 */
		public static final String PAGE_WHITE_GEAR_FADED = "page_white_gear_faded";

		/**
		 * <img src='./icons/application_put_faded.png'/>
		 */
		public static final String APPLICATION_PUT_FADED = "application_put_faded";

		/**
		 * <img src='./icons/pill_delete.png'/>
		 */
		public static final String PILL_DELETE = "pill_delete";

		/**
		 * <img src='./icons/picture_edit.png'/>
		 */
		public static final String PICTURE_EDIT = "picture_edit";

		/**
		 * <img src='./icons/house_link.png'/>
		 */
		public static final String HOUSE_LINK = "house_link";

		/**
		 * <img src='./icons/page_white_camera.png'/>
		 */
		public static final String PAGE_WHITE_CAMERA = "page_white_camera";

		/**
		 * <img src='./icons/coins_delete_faded.png'/>
		 */
		public static final String COINS_DELETE_FADED = "coins_delete_faded";

		/**
		 * <img src='./icons/lock_edit_faded.png'/>
		 */
		public static final String LOCK_EDIT_FADED = "lock_edit_faded";

		/**
		 * <img src='./icons/weather_clouds.png'/>
		 */
		public static final String WEATHER_CLOUDS = "weather_clouds";

		/**
		 * <img src='./icons/cup_key_faded.png'/>
		 */
		public static final String CUP_KEY_FADED = "cup_key_faded";

		/**
		 * <img src='./icons/text_smallcaps_faded.png'/>
		 */
		public static final String TEXT_SMALLCAPS_FADED = "text_smallcaps_faded";

		/**
		 * <img src='./icons/printer_delete.png'/>
		 */
		public static final String PRINTER_DELETE = "printer_delete";

		/**
		 * <img src='./icons/text_padding_left.png'/>
		 */
		public static final String TEXT_PADDING_LEFT = "text_padding_left";

		/**
		 * <img src='./icons/world_add_faded.png'/>
		 */
		public static final String WORLD_ADD_FADED = "world_add_faded";

		/**
		 * <img src='./icons/control_rewind.png'/>
		 */
		public static final String CONTROL_REWIND = "control_rewind";

		/**
		 * <img src='./icons/anchor.png'/>
		 */
		public static final String ANCHOR = "anchor";

		/**
		 * <img src='./icons/hourglass_faded.png'/>
		 */
		public static final String HOURGLASS_FADED = "hourglass_faded";

		/**
		 * <img src='./icons/sound_add_faded.png'/>
		 */
		public static final String SOUND_ADD_FADED = "sound_add_faded";

		/**
		 * <img src='./icons/film_go.png'/>
		 */
		public static final String FILM_GO = "film_go";

		/**
		 * <img src='./icons/bin_closed_faded.png'/>
		 */
		public static final String BIN_CLOSED_FADED = "bin_closed_faded";

		/**
		 * <img src='./icons/keyboard_magnify.png'/>
		 */
		public static final String KEYBOARD_MAGNIFY = "keyboard_magnify";

		/**
		 * <img src='./icons/table_delete_faded.png'/>
		 */
		public static final String TABLE_DELETE_FADED = "table_delete_faded";

		/**
		 * <img src='./icons/page_white_magnify.png'/>
		 */
		public static final String PAGE_WHITE_MAGNIFY = "page_white_magnify";

		/**
		 * <img src='./icons/link_break_faded.png'/>
		 */
		public static final String LINK_BREAK_FADED = "link_break_faded";

		/**
		 * <img src='./icons/date_lorry_faded.png'/>
		 */
		public static final String DATE_LORRY_FADED = "date_lorry_faded";

		/**
		 * <img src='./icons/page_white_lightning_faded.png'/>
		 */
		public static final String PAGE_WHITE_LIGHTNING_FADED = "page_white_lightning_faded";

		/**
		 * <img src='./icons/page_white_camera_faded.png'/>
		 */
		public static final String PAGE_WHITE_CAMERA_FADED = "page_white_camera_faded";

		/**
		 * <img src='./icons/script_gear_faded.png'/>
		 */
		public static final String SCRIPT_GEAR_FADED = "script_gear_faded";

		/**
		 * <img src='./icons/film_key_faded.png'/>
		 */
		public static final String FILM_KEY_FADED = "film_key_faded";

		/**
		 * <img src='./icons/shape_square_add.png'/>
		 */
		public static final String SHAPE_SQUARE_ADD = "shape_square_add";

		/**
		 * <img src='./icons/bullet_arrow_down_faded.png'/>
		 */
		public static final String BULLET_ARROW_DOWN_FADED = "bullet_arrow_down_faded";

		/**
		 * <img src='./icons/joystick_delete.png'/>
		 */
		public static final String JOYSTICK_DELETE = "joystick_delete";

		/**
		 * <img src='./icons/transmit_delete.png'/>
		 */
		public static final String TRANSMIT_DELETE = "transmit_delete";

		/**
		 * <img src='./icons/arrow_down_red_faded.png'/>
		 */
		public static final String ARROW_DOWN_RED_FADED = "arrow_down_red_faded";

		/**
		 * <img src='./icons/html_valid.png'/>
		 */
		public static final String HTML_VALID = "html_valid";

		/**
		 * <img src='./icons/bullet_error_faded.png'/>
		 */
		public static final String BULLET_ERROR_FADED = "bullet_error_faded";

		/**
		 * <img src='./icons/cart_remove.png'/>
		 */
		public static final String CART_REMOVE = "cart_remove";

		/**
		 * <img src='./icons/heart_delete_faded.png'/>
		 */
		public static final String HEART_DELETE_FADED = "heart_delete_faded";

		/**
		 * <img src='./icons/shape_align_top_faded.png'/>
		 */
		public static final String SHAPE_ALIGN_TOP_FADED = "shape_align_top_faded";

		/**
		 * <img src='./icons/page_copy.png'/>
		 */
		public static final String PAGE_COPY = "page_copy";

		/**
		 * <img src='./icons/color_swatch_faded.png'/>
		 */
		public static final String COLOR_SWATCH_FADED = "color_swatch_faded";

		/**
		 * <img src='./icons/calendar_view_month.png'/>
		 */
		public static final String CALENDAR_VIEW_MONTH = "calendar_view_month";

		/**
		 * <img src='./icons/ruby_key_faded.png'/>
		 */
		public static final String RUBY_KEY_FADED = "ruby_key_faded";

		/**
		 * <img src='./icons/hourglass_link.png'/>
		 */
		public static final String HOURGLASS_LINK = "hourglass_link";

		/**
		 * <img src='./icons/user_gray_phone.png'/>
		 */
		public static final String USER_GRAY_PHONE = "user_gray_phone";

		/**
		 * <img src='./icons/application_form_delete_faded.png'/>
		 */
		public static final String APPLICATION_FORM_DELETE_FADED = "application_form_delete_faded";

		/**
		 * <img src='./icons/chart_pie_error.png'/>
		 */
		public static final String CHART_PIE_ERROR = "chart_pie_error";

		/**
		 * <img src='./icons/browser_safari_faded.png'/>
		 */
		public static final String BROWSER_SAFARI_FADED = "browser_safari_faded";

		/**
		 * <img src='./icons/building.png'/>
		 */
		public static final String BUILDING = "building";

		/**
		 * <img src='./icons/page_faded.png'/>
		 */
		public static final String PAGE_FADED = "page_faded";

		/**
		 * <img src='./icons/photo_add_faded.png'/>
		 */
		public static final String PHOTO_ADD_FADED = "photo_add_faded";

		/**
		 * <img src='./icons/page_link.png'/>
		 */
		public static final String PAGE_LINK = "page_link";

		/**
		 * <img src='./icons/error_add.png'/>
		 */
		public static final String ERROR_ADD = "error_add";

		/**
		 * <img src='./icons/page_white_flash.png'/>
		 */
		public static final String PAGE_WHITE_FLASH = "page_white_flash";

		/**
		 * <img src='./icons/user_connect.png'/>
		 */
		public static final String USER_CONNECT = "user_connect";

		/**
		 * <img src='./icons/folder_error.png'/>
		 */
		public static final String FOLDER_ERROR = "folder_error";

		/**
		 * <img src='./icons/telephone_edit.png'/>
		 */
		public static final String TELEPHONE_EDIT = "telephone_edit";

		/**
		 * <img src='./icons/weather_clouds_faded.png'/>
		 */
		public static final String WEATHER_CLOUDS_FADED = "weather_clouds_faded";

		/**
		 * <img src='./icons/lorry_go.png'/>
		 */
		public static final String LORRY_GO = "lorry_go";

		/**
		 * <img src='./icons/arrow_turn_left.png'/>
		 */
		public static final String ARROW_TURN_LEFT = "arrow_turn_left";

		/**
		 * <img src='./icons/disk.png'/>
		 */
		public static final String DISK = "disk";

		/**
		 * <img src='./icons/link_delete.png'/>
		 */
		public static final String LINK_DELETE = "link_delete";

		/**
		 * <img src='./icons/thumb_down_faded.png'/>
		 */
		public static final String THUMB_DOWN_FADED = "thumb_down_faded";

		/**
		 * <img src='./icons/folder_feed.png'/>
		 */
		public static final String FOLDER_FEED = "folder_feed";

		/**
		 * <img src='./icons/chart_curve_edit_faded.png'/>
		 */
		public static final String CHART_CURVE_EDIT_FADED = "chart_curve_edit_faded";

		/**
		 * <img src='./icons/page_delete.png'/>
		 */
		public static final String PAGE_DELETE = "page_delete";

		/**
		 * <img src='./icons/chart_curve_add.png'/>
		 */
		public static final String CHART_CURVE_ADD = "chart_curve_add";

		/**
		 * <img src='./icons/server_go.png'/>
		 */
		public static final String SERVER_GO = "server_go";

		/**
		 * <img src='./icons/control_end.png'/>
		 */
		public static final String CONTROL_END = "control_end";

		/**
		 * <img src='./icons/arrow_rotate_clockwise_faded.png'/>
		 */
		public static final String ARROW_ROTATE_CLOCKWISE_FADED = "arrow_rotate_clockwise_faded";

		/**
		 * <img src='./icons/user_comment_faded.png'/>
		 */
		public static final String USER_COMMENT_FADED = "user_comment_faded";

		/**
		 * <img src='./icons/text_padding_bottom.png'/>
		 */
		public static final String TEXT_PADDING_BOTTOM = "text_padding_bottom";

		/**
		 * <img src='./icons/lock_add.png'/>
		 */
		public static final String LOCK_ADD = "lock_add";

		/**
		 * <img src='./icons/control_play_faded.png'/>
		 */
		public static final String CONTROL_PLAY_FADED = "control_play_faded";

		/**
		 * <img src='./icons/sound_none_faded.png'/>
		 */
		public static final String SOUND_NONE_FADED = "sound_none_faded";

		/**
		 * <img src='./icons/textfield_delete_faded.png'/>
		 */
		public static final String TEXTFIELD_DELETE_FADED = "textfield_delete_faded";

		/**
		 * <img src='./icons/find.png'/>
		 */
		public static final String FIND = "find";

		/**
		 * <img src='./icons/page_white_text.png'/>
		 */
		public static final String PAGE_WHITE_TEXT = "page_white_text";

		/**
		 * <img src='./icons/control_play_blue_faded.png'/>
		 */
		public static final String CONTROL_PLAY_BLUE_FADED = "control_play_blue_faded";

		/**
		 * <img src='./icons/cd_eject_faded.png'/>
		 */
		public static final String CD_EJECT_FADED = "cd_eject_faded";

		/**
		 * <img src='./icons/photo_delete_faded.png'/>
		 */
		public static final String PHOTO_DELETE_FADED = "photo_delete_faded";

		/**
		 * <img src='./icons/arrow_divide_faded.png'/>
		 */
		public static final String ARROW_DIVIDE_FADED = "arrow_divide_faded";

		/**
		 * <img src='./icons/tick.png'/>
		 */
		public static final String TICK = "tick";

		/**
		 * <img src='./icons/book_open_faded.png'/>
		 */
		public static final String BOOK_OPEN_FADED = "book_open_faded";

		/**
		 * <img src='./icons/images_faded.png'/>
		 */
		public static final String IMAGES_FADED = "images_faded";

		/**
		 * <img src='./icons/lightning_add_faded.png'/>
		 */
		public static final String LIGHTNING_ADD_FADED = "lightning_add_faded";

		/**
		 * <img src='./icons/folder_link.png'/>
		 */
		public static final String FOLDER_LINK = "folder_link";

		/**
		 * <img src='./icons/camera_error_faded.png'/>
		 */
		public static final String CAMERA_ERROR_FADED = "camera_error_faded";

		/**
		 * <img src='./icons/browser_omniweb_faded.png'/>
		 */
		public static final String BROWSER_OMNIWEB_FADED = "browser_omniweb_faded";

		/**
		 * <img src='./icons/vcard_delete_faded.png'/>
		 */
		public static final String VCARD_DELETE_FADED = "vcard_delete_faded";

		/**
		 * <img src='./icons/hourglass_add.png'/>
		 */
		public static final String HOURGLASS_ADD = "hourglass_add";

		/**
		 * <img src='./icons/user_suit_faded.png'/>
		 */
		public static final String USER_SUIT_FADED = "user_suit_faded";

		/**
		 * <img src='./icons/time_delete_faded.png'/>
		 */
		public static final String TIME_DELETE_FADED = "time_delete_faded";

		/**
		 * <img src='./icons/table_edit.png'/>
		 */
		public static final String TABLE_EDIT = "table_edit";

		/**
		 * <img src='./icons/cart_go_faded.png'/>
		 */
		public static final String CART_GO_FADED = "cart_go_faded";

		/**
		 * <img src='./icons/bell_link_faded.png'/>
		 */
		public static final String BELL_LINK_FADED = "bell_link_faded";

		/**
		 * <img src='./icons/telephone_edit_faded.png'/>
		 */
		public static final String TELEPHONE_EDIT_FADED = "telephone_edit_faded";

		/**
		 * <img src='./icons/sport_soccer.png'/>
		 */
		public static final String SPORT_SOCCER = "sport_soccer";

		/**
		 * <img src='./icons/page_white_coldfusion_faded.png'/>
		 */
		public static final String PAGE_WHITE_COLDFUSION_FADED = "page_white_coldfusion_faded";

		/**
		 * <img src='./icons/arrow_turn_left_red.png'/>
		 */
		public static final String ARROW_TURN_LEFT_RED = "arrow_turn_left_red";

		/**
		 * <img src='./icons/award_star_gold_3_faded.png'/>
		 */
		public static final String AWARD_STAR_GOLD_3_FADED = "award_star_gold_3_faded";

		/**
		 * <img src='./icons/table_refresh.png'/>
		 */
		public static final String TABLE_REFRESH = "table_refresh";

		/**
		 * <img src='./icons/folder_explore.png'/>
		 */
		public static final String FOLDER_EXPLORE = "folder_explore";

		/**
		 * <img src='./icons/pencil.png'/>
		 */
		public static final String PENCIL = "pencil";

		/**
		 * <img src='./icons/text_align_right.png'/>
		 */
		public static final String TEXT_ALIGN_RIGHT = "text_align_right";

		/**
		 * <img src='./icons/user_female_contrast_faded.png'/>
		 */
		public static final String USER_FEMALE_CONTRAST_FADED = "user_female_contrast_faded";

		/**
		 * <img src='./icons/house_link_faded.png'/>
		 */
		public static final String HOUSE_LINK_FADED = "house_link_faded";

		/**
		 * <img src='./icons/bullet_go.png'/>
		 */
		public static final String BULLET_GO = "bullet_go";

		/**
		 * <img src='./icons/basket_edit.png'/>
		 */
		public static final String BASKET_EDIT = "basket_edit";

		/**
		 * <img src='./icons/paintcan.png'/>
		 */
		public static final String PAINTCAN = "paintcan";

		/**
		 * <img src='./icons/report_magnify_faded.png'/>
		 */
		public static final String REPORT_MAGNIFY_FADED = "report_magnify_faded";

		/**
		 * <img src='./icons/mouse.png'/>
		 */
		public static final String MOUSE = "mouse";

		/**
		 * <img src='./icons/computer_error.png'/>
		 */
		public static final String COMPUTER_ERROR = "computer_error";

		/**
		 * <img src='./icons/script_calendar_faded.png'/>
		 */
		public static final String SCRIPT_CALENDAR_FADED = "script_calendar_faded";

		/**
		 * <img src='./icons/blank.png'/>
		 */
		public static final String BLANK = "blank";

		/**
		 * <img src='./icons/feed_magnify.png'/>
		 */
		public static final String FEED_MAGNIFY = "feed_magnify";

		/**
		 * <img src='./icons/page_white_text_width.png'/>
		 */
		public static final String PAGE_WHITE_TEXT_WIDTH = "page_white_text_width";

		/**
		 * <img src='./icons/photo.png'/>
		 */
		public static final String PHOTO = "photo";

		/**
		 * <img src='./icons/report_disk_faded.png'/>
		 */
		public static final String REPORT_DISK_FADED = "report_disk_faded";

		/**
		 * <img src='./icons/folder_lightbulb_faded.png'/>
		 */
		public static final String FOLDER_LIGHTBULB_FADED = "folder_lightbulb_faded";

		/**
		 * <img src='./icons/shape_align_bottom_faded.png'/>
		 */
		public static final String SHAPE_ALIGN_BOTTOM_FADED = "shape_align_bottom_faded";

		/**
		 * <img src='./icons/drive_faded.png'/>
		 */
		public static final String DRIVE_FADED = "drive_faded";

		/**
		 * <img src='./icons/page_white_h_faded.png'/>
		 */
		public static final String PAGE_WHITE_H_FADED = "page_white_h_faded";

		/**
		 * <img src='./icons/lightbulb_delete_faded.png'/>
		 */
		public static final String LIGHTBULB_DELETE_FADED = "lightbulb_delete_faded";

		/**
		 * <img src='./icons/briefcase_faded.png'/>
		 */
		public static final String BRIEFCASE_FADED = "briefcase_faded";

		/**
		 * <img src='./icons/application_side_contract.png'/>
		 */
		public static final String APPLICATION_SIDE_CONTRACT = "application_side_contract";

		/**
		 * <img src='./icons/cart_delete_faded.png'/>
		 */
		public static final String CART_DELETE_FADED = "cart_delete_faded";

		/**
		 * <img src='./icons/script_add_faded.png'/>
		 */
		public static final String SCRIPT_ADD_FADED = "script_add_faded";

		/**
		 * <img src='./icons/brick_add.png'/>
		 */
		public static final String BRICK_ADD = "brick_add";

		/**
		 * <img src='./icons/group_error_faded.png'/>
		 */
		public static final String GROUP_ERROR_FADED = "group_error_faded";

		/**
		 * <img src='./icons/note_edit.png'/>
		 */
		public static final String NOTE_EDIT = "note_edit";

		/**
		 * <img src='./icons/package_faded.png'/>
		 */
		public static final String PACKAGE_FADED = "package_faded";

		/**
		 * <img src='./icons/note_delete_faded.png'/>
		 */
		public static final String NOTE_DELETE_FADED = "note_delete_faded";

		/**
		 * <img src='./icons/folder.png'/>
		 */
		public static final String FOLDER = "folder";

		/**
		 * <img src='./icons/paintcan_faded.png'/>
		 */
		public static final String PAINTCAN_FADED = "paintcan_faded";

		/**
		 * <img src='./icons/database_error_faded.png'/>
		 */
		public static final String DATABASE_ERROR_FADED = "database_error_faded";

		/**
		 * <img src='./icons/door.png'/>
		 */
		public static final String DOOR = "door";

		/**
		 * <img src='./icons/telephone_add.png'/>
		 */
		public static final String TELEPHONE_ADD = "telephone_add";

		/**
		 * <img src='./icons/ruby_key.png'/>
		 */
		public static final String RUBY_KEY = "ruby_key";

		/**
		 * <img src='./icons/feed_disk.png'/>
		 */
		public static final String FEED_DISK = "feed_disk";

		/**
		 * <img src='./icons/calendar_edit.png'/>
		 */
		public static final String CALENDAR_EDIT = "calendar_edit";

		/**
		 * <img src='./icons/application_view_detail.png'/>
		 */
		public static final String APPLICATION_VIEW_DETAIL = "application_view_detail";

		/**
		 * <img src='./icons/table_status_offline_faded.png'/>
		 */
		public static final String TABLE_STATUS_OFFLINE_FADED = "table_status_offline_faded";

		/**
		 * <img src='./icons/folder_key.png'/>
		 */
		public static final String FOLDER_KEY = "folder_key";

		/**
		 * <img src='./icons/folder_palette.png'/>
		 */
		public static final String FOLDER_PALETTE = "folder_palette";

		/**
		 * <img src='./icons/medal_silver_2.png'/>
		 */
		public static final String MEDAL_SILVER_2 = "medal_silver_2";

		/**
		 * <img src='./icons/folder_add_faded.png'/>
		 */
		public static final String FOLDER_ADD_FADED = "folder_add_faded";

		/**
		 * <img src='./icons/user_gray_plus.png'/>
		 */
		public static final String USER_GRAY_PLUS = "user_gray_plus";

		/**
		 * <img src='./icons/door_out.png'/>
		 */
		public static final String DOOR_OUT = "door_out";

		/**
		 * <img src='./icons/text_align_justify_faded.png'/>
		 */
		public static final String TEXT_ALIGN_JUSTIFY_FADED = "text_align_justify_faded";

		/**
		 * <img src='./icons/cup_error_faded.png'/>
		 */
		public static final String CUP_ERROR_FADED = "cup_error_faded";

		/**
		 * <img src='./icons/flag_green.png'/>
		 */
		public static final String FLAG_GREEN = "flag_green";

		/**
		 * <img src='./icons/image_edit_faded.png'/>
		 */
		public static final String IMAGE_EDIT_FADED = "image_edit_faded";

		/**
		 * <img src='./icons/heart_add.png'/>
		 */
		public static final String HEART_ADD = "heart_add";

		/**
		 * <img src='./icons/browser_sunrise_faded.png'/>
		 */
		public static final String BROWSER_SUNRISE_FADED = "browser_sunrise_faded";

		/**
		 * <img src='./icons/shield_delete_faded.png'/>
		 */
		public static final String SHIELD_DELETE_FADED = "shield_delete_faded";

		/**
		 * <img src='./icons/group_edit.png'/>
		 */
		public static final String GROUP_EDIT = "group_edit";

		/**
		 * <img src='./icons/server_compressed_faded.png'/>
		 */
		public static final String SERVER_COMPRESSED_FADED = "server_compressed_faded";

		/**
		 * <img src='./icons/comments.png'/>
		 */
		public static final String COMMENTS = "comments";

		/**
		 * <img src='./icons/bullet_arrow_bottom.png'/>
		 */
		public static final String BULLET_ARROW_BOTTOM = "bullet_arrow_bottom";

		/**
		 * <img src='./icons/email_go.png'/>
		 */
		public static final String EMAIL_GO = "email_go";

		/**
		 * <img src='./icons/script_weather_cloudy_faded.png'/>
		 */
		public static final String SCRIPT_WEATHER_CLOUDY_FADED = "script_weather_cloudy_faded";

		/**
		 * <img src='./icons/application_xp_terminal.png'/>
		 */
		public static final String APPLICATION_XP_TERMINAL = "application_xp_terminal";

		/**
		 * <img src='./icons/browser_msnexplorer.png'/>
		 */
		public static final String BROWSER_MSNEXPLORER = "browser_msnexplorer";

		/**
		 * <img src='./icons/application_side_tree.png'/>
		 */
		public static final String APPLICATION_SIDE_TREE = "application_side_tree";

		/**
		 * <img src='./icons/compress.png'/>
		 */
		public static final String COMPRESS = "compress";

		/**
		 * <img src='./icons/email_open.png'/>
		 */
		public static final String EMAIL_OPEN = "email_open";

		/**
		 * <img src='./icons/application_xp_faded.png'/>
		 */
		public static final String APPLICATION_XP_FADED = "application_xp_faded";

		/**
		 * <img src='./icons/ipod_cast_delete_faded.png'/>
		 */
		public static final String IPOD_CAST_DELETE_FADED = "ipod_cast_delete_faded";

		/**
		 * <img src='./icons/drive_web.png'/>
		 */
		public static final String DRIVE_WEB = "drive_web";

		/**
		 * <img src='./icons/page_error_faded.png'/>
		 */
		public static final String PAGE_ERROR_FADED = "page_error_faded";

		/**
		 * <img src='./icons/calendar_view_month_faded.png'/>
		 */
		public static final String CALENDAR_VIEW_MONTH_FADED = "calendar_view_month_faded";

		/**
		 * <img src='./icons/chart_pie_error_faded.png'/>
		 */
		public static final String CHART_PIE_ERROR_FADED = "chart_pie_error_faded";

		/**
		 * <img src='./icons/male_time_faded.png'/>
		 */
		public static final String MALE_TIME_FADED = "male_time_faded";

		/**
		 * <img src='./icons/application_add_faded.png'/>
		 */
		public static final String APPLICATION_ADD_FADED = "application_add_faded";

		/**
		 * <img src='./icons/page_white.png'/>
		 */
		public static final String PAGE_WHITE = "page_white";

		/**
		 * <img src='./icons/rss_valid_faded.png'/>
		 */
		public static final String RSS_VALID_FADED = "rss_valid_faded";

		/**
		 * <img src='./icons/database_go_faded.png'/>
		 */
		public static final String DATABASE_GO_FADED = "database_go_faded";

		/**
		 * <img src='./icons/user_red.png'/>
		 */
		public static final String USER_RED = "user_red";

		/**
		 * <img src='./icons/package.png'/>
		 */
		public static final String PACKAGE = "package";

		/**
		 * <img src='./icons/script_key_faded.png'/>
		 */
		public static final String SCRIPT_KEY_FADED = "script_key_faded";

		/**
		 * <img src='./icons/medal_gold_3.png'/>
		 */
		public static final String MEDAL_GOLD_3 = "medal_gold_3";

		/**
		 * <img src='./icons/database_add.png'/>
		 */
		public static final String DATABASE_ADD = "database_add";

		/**
		 * <img src='./icons/basket_faded.png'/>
		 */
		public static final String BASKET_FADED = "basket_faded";

		/**
		 * <img src='./icons/server_faded.png'/>
		 */
		public static final String SERVER_FADED = "server_faded";

		/**
		 * <img src='./icons/transmit_blue.png'/>
		 */
		public static final String TRANSMIT_BLUE = "transmit_blue";

		/**
		 * <img src='./icons/script_delete.png'/>
		 */
		public static final String SCRIPT_DELETE = "script_delete";

		/**
		 * <img src='./icons/calendar_faded.png'/>
		 */
		public static final String CALENDAR_FADED = "calendar_faded";

		/**
		 * <img src='./icons/arrow_turn_left_faded.png'/>
		 */
		public static final String ARROW_TURN_LEFT_FADED = "arrow_turn_left_faded";

		/**
		 * <img src='./icons/text_align_left.png'/>
		 */
		public static final String TEXT_ALIGN_LEFT = "text_align_left";

		/**
		 * <img src='./icons/comments_add_faded.png'/>
		 */
		public static final String COMMENTS_ADD_FADED = "comments_add_faded";

		/**
		 * <img src='./icons/rss_delete.png'/>
		 */
		public static final String RSS_DELETE = "rss_delete";

		/**
		 * <img src='./icons/text_lowercase.png'/>
		 */
		public static final String TEXT_LOWERCASE = "text_lowercase";

		/**
		 * <img src='./icons/folder_bug.png'/>
		 */
		public static final String FOLDER_BUG = "folder_bug";

		/**
		 * <img src='./icons/folder_picture.png'/>
		 */
		public static final String FOLDER_PICTURE = "folder_picture";

		/**
		 * <img src='./icons/pencil_faded.png'/>
		 */
		public static final String PENCIL_FADED = "pencil_faded";

		/**
		 * <img src='./icons/clock_pause.png'/>
		 */
		public static final String CLOCK_PAUSE = "clock_pause";

		/**
		 * <img src='./icons/tag_yellow.png'/>
		 */
		public static final String TAG_YELLOW = "tag_yellow";

		/**
		 * <img src='./icons/dvd_error.png'/>
		 */
		public static final String DVD_ERROR = "dvd_error";

		/**
		 * <img src='./icons/comments_delete.png'/>
		 */
		public static final String COMMENTS_DELETE = "comments_delete";

		/**
		 * <img src='./icons/cup_link_faded.png'/>
		 */
		public static final String CUP_LINK_FADED = "cup_link_faded";

		/**
		 * <img src='./icons/telephone_delete.png'/>
		 */
		public static final String TELEPHONE_DELETE = "telephone_delete";

		/**
		 * <img src='./icons/contrast_high.png'/>
		 */
		public static final String CONTRAST_HIGH = "contrast_high";

		/**
		 * <img src='./icons/transmit_add.png'/>
		 */
		public static final String TRANSMIT_ADD = "transmit_add";

		/**
		 * <img src='./icons/text_list_numbers_disk.png'/>
		 */
		public static final String TEXT_LIST_NUMBERS_DISK = "text_list_numbers_disk";

		/**
		 * <img src='./icons/weather_snow_faded.png'/>
		 */
		public static final String WEATHER_SNOW_FADED = "weather_snow_faded";

		/**
		 * <img src='./icons/world_edit.png'/>
		 */
		public static final String WORLD_EDIT = "world_edit";

		/**
		 * <img src='./icons/user_female_delete.png'/>
		 */
		public static final String USER_FEMALE_DELETE = "user_female_delete";

		/**
		 * <img src='./icons/wrench_orange_faded.png'/>
		 */
		public static final String WRENCH_ORANGE_FADED = "wrench_orange_faded";

		/**
		 * <img src='./icons/cd_add_faded.png'/>
		 */
		public static final String CD_ADD_FADED = "cd_add_faded";

		/**
		 * <img src='./icons/text_align_right_faded.png'/>
		 */
		public static final String TEXT_ALIGN_RIGHT_FADED = "text_align_right_faded";

		/**
		 * <img src='./icons/chart_curve_link_faded.png'/>
		 */
		public static final String CHART_CURVE_LINK_FADED = "chart_curve_link_faded";

		/**
		 * <img src='./icons/chart_line_link.png'/>
		 */
		public static final String CHART_LINE_LINK = "chart_line_link";

		/**
		 * <img src='./icons/picture_link_faded.png'/>
		 */
		public static final String PICTURE_LINK_FADED = "picture_link_faded";

		/**
		 * <img src='./icons/user_female_faded.png'/>
		 */
		public static final String USER_FEMALE_FADED = "user_female_faded";

		/**
		 * <img src='./icons/feed_key_faded.png'/>
		 */
		public static final String FEED_KEY_FADED = "feed_key_faded";

		/**
		 * <img src='./icons/script_add.png'/>
		 */
		public static final String SCRIPT_ADD = "script_add";

		/**
		 * <img src='./icons/award_star_delete.png'/>
		 */
		public static final String AWARD_STAR_DELETE = "award_star_delete";

		/**
		 * <img src='./icons/brick_add_faded.png'/>
		 */
		public static final String BRICK_ADD_FADED = "brick_add_faded";

		/**
		 * <img src='./icons/arrow_merge.png'/>
		 */
		public static final String ARROW_MERGE = "arrow_merge";

		/**
		 * <img src='./icons/magnifier.png'/>
		 */
		public static final String MAGNIFIER = "magnifier";

		/**
		 * <img src='./icons/cd_go.png'/>
		 */
		public static final String CD_GO = "cd_go";

		/**
		 * <img src='./icons/picture_add_faded.png'/>
		 */
		public static final String PICTURE_ADD_FADED = "picture_add_faded";

		/**
		 * <img src='./icons/arrow_left_red_faded.png'/>
		 */
		public static final String ARROW_LEFT_RED_FADED = "arrow_left_red_faded";

		/**
		 * <img src='./icons/coins_faded.png'/>
		 */
		public static final String COINS_FADED = "coins_faded";

		/**
		 * <img src='./icons/folder_explore_faded.png'/>
		 */
		public static final String FOLDER_EXPLORE_FADED = "folder_explore_faded";

		/**
		 * <img src='./icons/monitor_link_faded.png'/>
		 */
		public static final String MONITOR_LINK_FADED = "monitor_link_faded";

		/**
		 * <img src='./icons/user_gray_tick.png'/>
		 */
		public static final String USER_GRAY_TICK = "user_gray_tick";

		/**
		 * <img src='./icons/bullet_arrow_up.png'/>
		 */
		public static final String BULLET_ARROW_UP = "bullet_arrow_up";

		/**
		 * <img src='./icons/medal_gold_delete_faded.png'/>
		 */
		public static final String MEDAL_GOLD_DELETE_FADED = "medal_gold_delete_faded";

		/**
		 * <img src='./icons/page_white_compressed.png'/>
		 */
		public static final String PAGE_WHITE_COMPRESSED = "page_white_compressed";

		/**
		 * <img src='./icons/sql_faded.png'/>
		 */
		public static final String SQL_FADED = "sql_faded";

		/**
		 * <img src='./icons/application_edit.png'/>
		 */
		public static final String APPLICATION_EDIT = "application_edit";

		/**
		 * <img src='./icons/feed_delete_faded.png'/>
		 */
		public static final String FEED_DELETE_FADED = "feed_delete_faded";

		/**
		 * <img src='./icons/monitor_lightning_faded.png'/>
		 */
		public static final String MONITOR_LIGHTNING_FADED = "monitor_lightning_faded";

		/**
		 * <img src='./icons/wand_faded.png'/>
		 */
		public static final String WAND_FADED = "wand_faded";

		/**
		 * <img src='./icons/application_side_list.png'/>
		 */
		public static final String APPLICATION_SIDE_LIST = "application_side_list";

		/**
		 * <img src='./icons/book_faded.png'/>
		 */
		public static final String BOOK_FADED = "book_faded";

		/**
		 * <img src='./icons/clock_stop_faded.png'/>
		 */
		public static final String CLOCK_STOP_FADED = "clock_stop_faded";

		/**
		 * <img src='./icons/cd_eject.png'/>
		 */
		public static final String CD_EJECT = "cd_eject";

		/**
		 * <img src='./icons/book_next.png'/>
		 */
		public static final String BOOK_NEXT = "book_next";

		/**
		 * <img src='./icons/application_get_faded.png'/>
		 */
		public static final String APPLICATION_GET_FADED = "application_get_faded";

		/**
		 * <img src='./icons/basket_put_faded.png'/>
		 */
		public static final String BASKET_PUT_FADED = "basket_put_faded";

		/**
		 * <img src='./icons/book_add.png'/>
		 */
		public static final String BOOK_ADD = "book_add";

		/**
		 * <img src='./icons/photos_faded.png'/>
		 */
		public static final String PHOTOS_FADED = "photos_faded";

		/**
		 * <img src='./icons/page_white_picture.png'/>
		 */
		public static final String PAGE_WHITE_PICTURE = "page_white_picture";

		/**
		 * <img src='./icons/box_faded.png'/>
		 */
		public static final String BOX_FADED = "box_faded";

		/**
		 * <img src='./icons/email_open_faded.png'/>
		 */
		public static final String EMAIL_OPEN_FADED = "email_open_faded";

		/**
		 * <img src='./icons/script_sum.png'/>
		 */
		public static final String SCRIPT_SUM = "script_sum";

		/**
		 * <img src='./icons/controller_add_faded.png'/>
		 */
		public static final String CONTROLLER_ADD_FADED = "controller_add_faded";

		/**
		 * <img src='./icons/car.png'/>
		 */
		public static final String CAR = "car";

		/**
		 * <img src='./icons/chart_pie_link.png'/>
		 */
		public static final String CHART_PIE_LINK = "chart_pie_link";

		/**
		 * <img src='./icons/arrow_redo.png'/>
		 */
		public static final String ARROW_REDO = "arrow_redo";

		/**
		 * <img src='./icons/bug_add.png'/>
		 */
		public static final String BUG_ADD = "bug_add";

		/**
		 * <img src='./icons/bug_link.png'/>
		 */
		public static final String BUG_LINK = "bug_link";

		/**
		 * <img src='./icons/brick_link.png'/>
		 */
		public static final String BRICK_LINK = "brick_link";

		/**
		 * <img src='./icons/sport_8ball_faded.png'/>
		 */
		public static final String SPORT_8BALL_FADED = "sport_8ball_faded";

		/**
		 * <img src='./icons/text_letter_omega.png'/>
		 */
		public static final String TEXT_LETTER_OMEGA = "text_letter_omega";

		/**
		 * <img src='./icons/controller_error.png'/>
		 */
		public static final String CONTROLLER_ERROR = "controller_error";

		/**
		 * <img src='./icons/camera_add_faded.png'/>
		 */
		public static final String CAMERA_ADD_FADED = "camera_add_faded";

		/**
		 * <img src='./icons/table_row_faded.png'/>
		 */
		public static final String TABLE_ROW_FADED = "table_row_faded";

		/**
		 * <img src='./icons/sql_go.png'/>
		 */
		public static final String SQL_GO = "sql_go";

		/**
		 * <img src='./icons/calendar_edit_faded.png'/>
		 */
		public static final String CALENDAR_EDIT_FADED = "calendar_edit_faded";

		/**
		 * <img src='./icons/page_refresh.png'/>
		 */
		public static final String PAGE_REFRESH = "page_refresh";

		/**
		 * <img src='./icons/user_start.png'/>
		 */
		public static final String USER_START = "user_start";

		/**
		 * <img src='./icons/chart_pie_add.png'/>
		 */
		public static final String CHART_PIE_ADD = "chart_pie_add";

		/**
		 * <img src='./icons/application_error.png'/>
		 */
		public static final String APPLICATION_ERROR = "application_error";

		/**
		 * <img src='./icons/image_link.png'/>
		 */
		public static final String IMAGE_LINK = "image_link";

		/**
		 * <img src='./icons/world_delete.png'/>
		 */
		public static final String WORLD_DELETE = "world_delete";

		/**
		 * <img src='./icons/webcam_add.png'/>
		 */
		public static final String WEBCAM_ADD = "webcam_add";

		/**
		 * <img src='./icons/control_repeat_blue.png'/>
		 */
		public static final String CONTROL_REPEAT_BLUE = "control_repeat_blue";

		/**
		 * <img src='./icons/database_link.png'/>
		 */
		public static final String DATABASE_LINK = "database_link";

		/**
		 * <img src='./icons/text_list_numbers.png'/>
		 */
		public static final String TEXT_LIST_NUMBERS = "text_list_numbers";

		/**
		 * <img src='./icons/picture_save.png'/>
		 */
		public static final String PICTURE_SAVE = "picture_save";

		/**
		 * <img src='./icons/bullet_toggle_minus_faded.png'/>
		 */
		public static final String BULLET_TOGGLE_MINUS_FADED = "bullet_toggle_minus_faded";

		/**
		 * <img src='./icons/table_row_insert_faded.png'/>
		 */
		public static final String TABLE_ROW_INSERT_FADED = "table_row_insert_faded";

		/**
		 * <img src='./icons/book_go.png'/>
		 */
		public static final String BOOK_GO = "book_go";

		/**
		 * <img src='./icons/plugin_link.png'/>
		 */
		public static final String PLUGIN_LINK = "plugin_link";

		/**
		 * <img src='./icons/table_row_delete.png'/>
		 */
		public static final String TABLE_ROW_DELETE = "table_row_delete";

		/**
		 * <img src='./icons/comments_delete_faded.png'/>
		 */
		public static final String COMMENTS_DELETE_FADED = "comments_delete_faded";

		/**
		 * <img src='./icons/rss_faded.png'/>
		 */
		public static final String RSS_FADED = "rss_faded";

		/**
		 * <img src='./icons/server_compressed.png'/>
		 */
		public static final String SERVER_COMPRESSED = "server_compressed";

		/**
		 * <img src='./icons/folder_delete.png'/>
		 */
		public static final String FOLDER_DELETE = "folder_delete";

		/**
		 * <img src='./icons/weather_sun.png'/>
		 */
		public static final String WEATHER_SUN = "weather_sun";

		/**
		 * <img src='./icons/group.png'/>
		 */
		public static final String GROUP = "group";

		/**
		 * <img src='./icons/browser_safari.png'/>
		 */
		public static final String BROWSER_SAFARI = "browser_safari";

		/**
		 * <img src='./icons/book_error.png'/>
		 */
		public static final String BOOK_ERROR = "book_error";

		/**
		 * <img src='./icons/world.png'/>
		 */
		public static final String WORLD = "world";

		/**
		 * <img src='./icons/control_eject_blue.png'/>
		 */
		public static final String CONTROL_EJECT_BLUE = "control_eject_blue";

		/**
		 * <img src='./icons/sql_valid_faded.png'/>
		 */
		public static final String SQL_VALID_FADED = "sql_valid_faded";

		/**
		 * <img src='./icons/email_add_faded.png'/>
		 */
		public static final String EMAIL_ADD_FADED = "email_add_faded";

		/**
		 * <img src='./icons/sql_go_faded.png'/>
		 */
		public static final String SQL_GO_FADED = "sql_go_faded";

		/**
		 * <img src='./icons/arrow_up_faded.png'/>
		 */
		public static final String ARROW_UP_FADED = "arrow_up_faded";

		/**
		 * <img src='./icons/database_gear_faded.png'/>
		 */
		public static final String DATABASE_GEAR_FADED = "database_gear_faded";

		/**
		 * <img src='./icons/page_white_compressed_faded.png'/>
		 */
		public static final String PAGE_WHITE_COMPRESSED_FADED = "page_white_compressed_faded";

		/**
		 * <img src='./icons/palette.png'/>
		 */
		public static final String PALETTE = "palette";

		/**
		 * <img src='./icons/script_magnifier.png'/>
		 */
		public static final String SCRIPT_MAGNIFIER = "script_magnifier";

		/**
		 * <img src='./icons/cart_remove_faded.png'/>
		 */
		public static final String CART_REMOVE_FADED = "cart_remove_faded";

		/**
		 * <img src='./icons/picture_faded.png'/>
		 */
		public static final String PICTURE_FADED = "picture_faded";

		/**
		 * <img src='./icons/joystick_error.png'/>
		 */
		public static final String JOYSTICK_ERROR = "joystick_error";

		/**
		 * <img src='./icons/text_heading_4.png'/>
		 */
		public static final String TEXT_HEADING_4 = "text_heading_4";

		/**
		 * <img src='./icons/bricks_faded.png'/>
		 */
		public static final String BRICKS_FADED = "bricks_faded";

		/**
		 * <img src='./icons/female_time.png'/>
		 */
		public static final String FEMALE_TIME = "female_time";

		/**
		 * <img src='./icons/application_link_faded.png'/>
		 */
		public static final String APPLICATION_LINK_FADED = "application_link_faded";

		/**
		 * <img src='./icons/building_add_faded.png'/>
		 */
		public static final String BUILDING_ADD_FADED = "building_add_faded";

		/**
		 * <img src='./icons/application_tile_vertical_faded.png'/>
		 */
		public static final String APPLICATION_TILE_VERTICAL_FADED = "application_tile_vertical_faded";

		/**
		 * <img src='./icons/script_link.png'/>
		 */
		public static final String SCRIPT_LINK = "script_link";

		/**
		 * <img src='./icons/user_go.png'/>
		 */
		public static final String USER_GO = "user_go";

		/**
		 * <img src='./icons/book_key.png'/>
		 */
		public static final String BOOK_KEY = "book_key";

		/**
		 * <img src='./icons/lock_delete_faded.png'/>
		 */
		public static final String LOCK_DELETE_FADED = "lock_delete_faded";

		/**
		 * <img src='./icons/report_add_faded.png'/>
		 */
		public static final String REPORT_ADD_FADED = "report_add_faded";

		/**
		 * <img src='./icons/ruby_delete_faded.png'/>
		 */
		public static final String RUBY_DELETE_FADED = "ruby_delete_faded";

		/**
		 * <img src='./icons/user_gray_edit.png'/>
		 */
		public static final String USER_GRAY_EDIT = "user_gray_edit";

		/**
		 * <img src='./icons/email_link_faded.png'/>
		 */
		public static final String EMAIL_LINK_FADED = "email_link_faded";

		/**
		 * <img src='./icons/application_cascade_add.png'/>
		 */
		public static final String APPLICATION_CASCADE_ADD = "application_cascade_add";

		/**
		 * <img src='./icons/keyboard_delete.png'/>
		 */
		public static final String KEYBOARD_DELETE = "keyboard_delete";

		/**
		 * <img src='./icons/folder_image.png'/>
		 */
		public static final String FOLDER_IMAGE = "folder_image";

		/**
		 * <img src='./icons/ipod.png'/>
		 */
		public static final String IPOD = "ipod";

		/**
		 * <img src='./icons/user_stop.png'/>
		 */
		public static final String USER_STOP = "user_stop";

		/**
		 * <img src='./icons/control_start_faded.png'/>
		 */
		public static final String CONTROL_START_FADED = "control_start_faded";

		/**
		 * <img src='./icons/application_tile_horizontal.png'/>
		 */
		public static final String APPLICATION_TILE_HORIZONTAL = "application_tile_horizontal";

		/**
		 * <img src='./icons/clock_go.png'/>
		 */
		public static final String CLOCK_GO = "clock_go";

		/**
		 * <img src='./icons/package_delete.png'/>
		 */
		public static final String PACKAGE_DELETE = "package_delete";

		/**
		 * <img src='./icons/cog_edit_faded.png'/>
		 */
		public static final String COG_EDIT_FADED = "cog_edit_faded";

		/**
		 * <img src='./icons/sound_low.png'/>
		 */
		public static final String SOUND_LOW = "sound_low";

		/**
		 * <img src='./icons/link_add.png'/>
		 */
		public static final String LINK_ADD = "link_add";

		/**
		 * <img src='./icons/report_faded.png'/>
		 */
		public static final String REPORT_FADED = "report_faded";

		/**
		 * <img src='./icons/cup_delete.png'/>
		 */
		public static final String CUP_DELETE = "cup_delete";

		/**
		 * <img src='./icons/feed_delete.png'/>
		 */
		public static final String FEED_DELETE = "feed_delete";

		/**
		 * <img src='./icons/server_edit_faded.png'/>
		 */
		public static final String SERVER_EDIT_FADED = "server_edit_faded";

		/**
		 * <img src='./icons/arrow_branch.png'/>
		 */
		public static final String ARROW_BRANCH = "arrow_branch";

		/**
		 * <img src='./icons/control_fastforward_faded.png'/>
		 */
		public static final String CONTROL_FASTFORWARD_FADED = "control_fastforward_faded";

		/**
		 * <img src='./icons/emoticon_unhappy.png'/>
		 */
		public static final String EMOTICON_UNHAPPY = "emoticon_unhappy";

		/**
		 * <img src='./icons/chart_organisation_faded.png'/>
		 */
		public static final String CHART_ORGANISATION_FADED = "chart_organisation_faded";

		/**
		 * <img src='./icons/car_add.png'/>
		 */
		public static final String CAR_ADD = "car_add";

		/**
		 * <img src='./icons/clock_delete.png'/>
		 */
		public static final String CLOCK_DELETE = "clock_delete";

		/**
		 * <img src='./icons/page_white_width.png'/>
		 */
		public static final String PAGE_WHITE_WIDTH = "page_white_width";

		/**
		 * <img src='./icons/database_faded.png'/>
		 */
		public static final String DATABASE_FADED = "database_faded";

		/**
		 * <img src='./icons/text_heading_2_faded.png'/>
		 */
		public static final String TEXT_HEADING_2_FADED = "text_heading_2_faded";

		/**
		 * <img src='./icons/tux_faded.png'/>
		 */
		public static final String TUX_FADED = "tux_faded";

		/**
		 * <img src='./icons/tag_red.png'/>
		 */
		public static final String TAG_RED = "tag_red";

		/**
		 * <img src='./icons/attach.png'/>
		 */
		public static final String ATTACH = "attach";

		/**
		 * <img src='./icons/style.png'/>
		 */
		public static final String STYLE = "style";

		/**
		 * <img src='./icons/shield_go.png'/>
		 */
		public static final String SHIELD_GO = "shield_go";

		/**
		 * <img src='./icons/user_cross.png'/>
		 */
		public static final String USER_CROSS = "user_cross";

		/**
		 * <img src='./icons/cd_burn_faded.png'/>
		 */
		public static final String CD_BURN_FADED = "cd_burn_faded";

		/**
		 * <img src='./icons/shape_flip_horizontal_faded.png'/>
		 */
		public static final String SHAPE_FLIP_HORIZONTAL_FADED = "shape_flip_horizontal_faded";

		/**
		 * <img src='./icons/folder_picture_faded.png'/>
		 */
		public static final String FOLDER_PICTURE_FADED = "folder_picture_faded";

		/**
		 * <img src='./icons/control_play.png'/>
		 */
		public static final String CONTROL_PLAY = "control_play";

		/**
		 * <img src='./icons/chart_line.png'/>
		 */
		public static final String CHART_LINE = "chart_line";

		/**
		 * <img src='./icons/application_view_columns_faded.png'/>
		 */
		public static final String APPLICATION_VIEW_COLUMNS_FADED = "application_view_columns_faded";

		/**
		 * <img src='./icons/table_link.png'/>
		 */
		public static final String TABLE_LINK = "table_link";

		/**
		 * <img src='./icons/transmit_error.png'/>
		 */
		public static final String TRANSMIT_ERROR = "transmit_error";

		/**
		 * <img src='./icons/award_star_gold_2_faded.png'/>
		 */
		public static final String AWARD_STAR_GOLD_2_FADED = "award_star_gold_2_faded";

		/**
		 * <img src='./icons/telephone_error.png'/>
		 */
		public static final String TELEPHONE_ERROR = "telephone_error";

		/**
		 * <img src='./icons/telephone_go.png'/>
		 */
		public static final String TELEPHONE_GO = "telephone_go";

		/**
		 * <img src='./icons/chart_line_edit.png'/>
		 */
		public static final String CHART_LINE_EDIT = "chart_line_edit";

		/**
		 * <img src='./icons/lorry_group.png'/>
		 */
		public static final String LORRY_GROUP = "lorry_group";

		/**
		 * <img src='./icons/world_go_faded.png'/>
		 */
		public static final String WORLD_GO_FADED = "world_go_faded";

		/**
		 * <img src='./icons/text_superscript_faded.png'/>
		 */
		public static final String TEXT_SUPERSCRIPT_FADED = "text_superscript_faded";

		/**
		 * <img src='./icons/brick_go.png'/>
		 */
		public static final String BRICK_GO = "brick_go";

		/**
		 * <img src='./icons/browser_opera.png'/>
		 */
		public static final String BROWSER_OPERA = "browser_opera";

		/**
		 * <img src='./icons/server_database_faded.png'/>
		 */
		public static final String SERVER_DATABASE_FADED = "server_database_faded";

		/**
		 * <img src='./icons/drive_add.png'/>
		 */
		public static final String DRIVE_ADD = "drive_add";

		/**
		 * <img src='./icons/error_delete.png'/>
		 */
		public static final String ERROR_DELETE = "error_delete";

		/**
		 * <img src='./icons/pill_go_faded.png'/>
		 */
		public static final String PILL_GO_FADED = "pill_go_faded";

		/**
		 * <img src='./icons/cut_faded.png'/>
		 */
		public static final String CUT_FADED = "cut_faded";

		/**
		 * <img src='./icons/script_code.png'/>
		 */
		public static final String SCRIPT_CODE = "script_code";

		/**
		 * <img src='./icons/chart_bar_edit_faded.png'/>
		 */
		public static final String CHART_BAR_EDIT_FADED = "chart_bar_edit_faded";

		/**
		 * <img src='./icons/tab_faded.png'/>
		 */
		public static final String TAB_FADED = "tab_faded";

		/**
		 * <img src='./icons/ruby_faded.png'/>
		 */
		public static final String RUBY_FADED = "ruby_faded";

		/**
		 * <img src='./icons/chart_organisation_add.png'/>
		 */
		public static final String CHART_ORGANISATION_ADD = "chart_organisation_add";

		/**
		 * <img src='./icons/database_edit_faded.png'/>
		 */
		public static final String DATABASE_EDIT_FADED = "database_edit_faded";

		/**
		 * <img src='./icons/control_pause_blue.png'/>
		 */
		public static final String CONTROL_PAUSE_BLUE = "control_pause_blue";

		/**
		 * <img src='./icons/application_put.png'/>
		 */
		public static final String APPLICATION_PUT = "application_put";

		/**
		 * <img src='./icons/sitemap_color.png'/>
		 */
		public static final String SITEMAP_COLOR = "sitemap_color";

		/**
		 * <img src='./icons/camera_link_faded.png'/>
		 */
		public static final String CAMERA_LINK_FADED = "camera_link_faded";

		/**
		 * <img src='./icons/control_back.png'/>
		 */
		public static final String CONTROL_BACK = "control_back";

		/**
		 * <img src='./icons/application_osx_terminal.png'/>
		 */
		public static final String APPLICATION_OSX_TERMINAL = "application_osx_terminal";

		/**
		 * <img src='./icons/lock_open.png'/>
		 */
		public static final String LOCK_OPEN = "lock_open";

		/**
		 * <img src='./icons/table_sort_faded.png'/>
		 */
		public static final String TABLE_SORT_FADED = "table_sort_faded";

		/**
		 * <img src='./icons/building_delete.png'/>
		 */
		public static final String BUILDING_DELETE = "building_delete";

		/**
		 * <img src='./icons/folder_bug_faded.png'/>
		 */
		public static final String FOLDER_BUG_FADED = "folder_bug_faded";

		/**
		 * <img src='./icons/folder_database_faded.png'/>
		 */
		public static final String FOLDER_DATABASE_FADED = "folder_database_faded";

		/**
		 * <img src='./icons/application_side_expand.png'/>
		 */
		public static final String APPLICATION_SIDE_EXPAND = "application_side_expand";

		/**
		 * <img src='./icons/drive_go.png'/>
		 */
		public static final String DRIVE_GO = "drive_go";

		/**
		 * <img src='./icons/basket_add_faded.png'/>
		 */
		public static final String BASKET_ADD_FADED = "basket_add_faded";

		/**
		 * <img src='./icons/weather_sun_lorry_faded.png'/>
		 */
		public static final String WEATHER_SUN_LORRY_FADED = "weather_sun_lorry_faded";

		/**
		 * <img src='./icons/monitor_lightning.png'/>
		 */
		public static final String MONITOR_LIGHTNING = "monitor_lightning";

		/**
		 * <img src='./icons/script_edit_faded.png'/>
		 */
		public static final String SCRIPT_EDIT_FADED = "script_edit_faded";

		/**
		 * <img src='./icons/world_delete_faded.png'/>
		 */
		public static final String WORLD_DELETE_FADED = "world_delete_faded";

		/**
		 * <img src='./icons/thumb_up.png'/>
		 */
		public static final String THUMB_UP = "thumb_up";

		/**
		 * <img src='./icons/drive_key_faded.png'/>
		 */
		public static final String DRIVE_KEY_FADED = "drive_key_faded";

		/**
		 * <img src='./icons/arrow_turn_right_faded.png'/>
		 */
		public static final String ARROW_TURN_RIGHT_FADED = "arrow_turn_right_faded";

		/**
		 * <img src='./icons/bullet_add_faded.png'/>
		 */
		public static final String BULLET_ADD_FADED = "bullet_add_faded";

		/**
		 * <img src='./icons/arrow_redo_red.png'/>
		 */
		public static final String ARROW_REDO_RED = "arrow_redo_red";

		/**
		 * <img src='./icons/email_attach.png'/>
		 */
		public static final String EMAIL_ATTACH = "email_attach";

		/**
		 * <img src='./icons/chart_line_delete_faded.png'/>
		 */
		public static final String CHART_LINE_DELETE_FADED = "chart_line_delete_faded";

		/**
		 * <img src='./icons/arrow_inout_red.png'/>
		 */
		public static final String ARROW_INOUT_RED = "arrow_inout_red";

		/**
		 * <img src='./icons/database_link_faded.png'/>
		 */
		public static final String DATABASE_LINK_FADED = "database_link_faded";

		/**
		 * <img src='./icons/decline.png'/>
		 */
		public static final String DECLINE = "decline";

		/**
		 * <img src='./icons/drive_key.png'/>
		 */
		public static final String DRIVE_KEY = "drive_key";

		/**
		 * <img src='./icons/wrench_orange.png'/>
		 */
		public static final String WRENCH_ORANGE = "wrench_orange";

		/**
		 * <img src='./icons/cog_delete_faded.png'/>
		 */
		public static final String COG_DELETE_FADED = "cog_delete_faded";

		/**
		 * <img src='./icons/lorry_add.png'/>
		 */
		public static final String LORRY_ADD = "lorry_add";

		/**
		 * <img src='./icons/hourglass_go.png'/>
		 */
		public static final String HOURGLASS_GO = "hourglass_go";

		/**
		 * <img src='./icons/package_green.png'/>
		 */
		public static final String PACKAGE_GREEN = "package_green";

		/**
		 * <img src='./icons/page_add_faded.png'/>
		 */
		public static final String PAGE_ADD_FADED = "page_add_faded";

		/**
		 * <img src='./icons/arrow_inout_faded.png'/>
		 */
		public static final String ARROW_INOUT_FADED = "arrow_inout_faded";

		/**
		 * <img src='./icons/chart_curve_error_faded.png'/>
		 */
		public static final String CHART_CURVE_ERROR_FADED = "chart_curve_error_faded";

		/**
		 * <img src='./icons/arrow_join.png'/>
		 */
		public static final String ARROW_JOIN = "arrow_join";

		/**
		 * <img src='./icons/text_list_numbers_gear.png'/>
		 */
		public static final String TEXT_LIST_NUMBERS_GEAR = "text_list_numbers_gear";

		/**
		 * <img src='./icons/report_user_faded.png'/>
		 */
		public static final String REPORT_USER_FADED = "report_user_faded";

		/**
		 * <img src='./icons/shape_flip_vertical_faded.png'/>
		 */
		public static final String SHAPE_FLIP_VERTICAL_FADED = "shape_flip_vertical_faded";

		/**
		 * <img src='./icons/status_offline_faded.png'/>
		 */
		public static final String STATUS_OFFLINE_FADED = "status_offline_faded";

		/**
		 * <img src='./icons/feed_go_faded.png'/>
		 */
		public static final String FEED_GO_FADED = "feed_go_faded";

		/**
		 * <img src='./icons/lock_go_faded.png'/>
		 */
		public static final String LOCK_GO_FADED = "lock_go_faded";

		/**
		 * <img src='./icons/shape_rotate_clockwise.png'/>
		 */
		public static final String SHAPE_ROTATE_CLOCKWISE = "shape_rotate_clockwise";

		/**
		 * <img src='./icons/basket_delete.png'/>
		 */
		public static final String BASKET_DELETE = "basket_delete";

		/**
		 * <img src='./icons/html_delete.png'/>
		 */
		public static final String HTML_DELETE = "html_delete";

		/**
		 * <img src='./icons/application_delete_faded.png'/>
		 */
		public static final String APPLICATION_DELETE_FADED = "application_delete_faded";

		/**
		 * <img src='./icons/tag_purple.png'/>
		 */
		public static final String TAG_PURPLE = "tag_purple";

		/**
		 * <img src='./icons/user_female_delete_faded.png'/>
		 */
		public static final String USER_FEMALE_DELETE_FADED = "user_female_delete_faded";

		/**
		 * <img src='./icons/shape_align_left.png'/>
		 */
		public static final String SHAPE_ALIGN_LEFT = "shape_align_left";

		/**
		 * <img src='./icons/image_add_faded.png'/>
		 */
		public static final String IMAGE_ADD_FADED = "image_add_faded";

		/**
		 * <img src='./icons/ruby_add_faded.png'/>
		 */
		public static final String RUBY_ADD_FADED = "ruby_add_faded";

		/**
		 * <img src='./icons/stop_faded.png'/>
		 */
		public static final String STOP_FADED = "stop_faded";

		/**
		 * <img src='./icons/television_add_faded.png'/>
		 */
		public static final String TELEVISION_ADD_FADED = "television_add_faded";

		/**
		 * <img src='./icons/ruby_link_faded.png'/>
		 */
		public static final String RUBY_LINK_FADED = "ruby_link_faded";

		/**
		 * <img src='./icons/page_paintbrush_faded.png'/>
		 */
		public static final String PAGE_PAINTBRUSH_FADED = "page_paintbrush_faded";

		/**
		 * <img src='./icons/report_picture_faded.png'/>
		 */
		public static final String REPORT_PICTURE_FADED = "report_picture_faded";

		/**
		 * <img src='./icons/photo_faded.png'/>
		 */
		public static final String PHOTO_FADED = "photo_faded";

		/**
		 * <img src='./icons/wrench_faded.png'/>
		 */
		public static final String WRENCH_FADED = "wrench_faded";

		/**
		 * <img src='./icons/page_white_magnify_faded.png'/>
		 */
		public static final String PAGE_WHITE_MAGNIFY_FADED = "page_white_magnify_faded";

		/**
		 * <img src='./icons/arrow_redo_red_faded.png'/>
		 */
		public static final String ARROW_REDO_RED_FADED = "arrow_redo_red_faded";

		/**
		 * <img src='./icons/asterisk_yellow_faded.png'/>
		 */
		public static final String ASTERISK_YELLOW_FADED = "asterisk_yellow_faded";

		/**
		 * <img src='./icons/text_italic_faded.png'/>
		 */
		public static final String TEXT_ITALIC_FADED = "text_italic_faded";

		/**
		 * <img src='./icons/html_go_faded.png'/>
		 */
		public static final String HTML_GO_FADED = "html_go_faded";

		/**
		 * <img src='./icons/database.png'/>
		 */
		public static final String DATABASE = "database";

		/**
		 * <img src='./icons/text_smallcaps.png'/>
		 */
		public static final String TEXT_SMALLCAPS = "text_smallcaps";

		/**
		 * <img src='./icons/text_list_numbers_gear_faded.png'/>
		 */
		public static final String TEXT_LIST_NUMBERS_GEAR_FADED = "text_list_numbers_gear_faded";

		/**
		 * <img src='./icons/date_faded.png'/>
		 */
		public static final String DATE_FADED = "date_faded";

		/**
		 * <img src='./icons/dvd_edit_faded.png'/>
		 */
		public static final String DVD_EDIT_FADED = "dvd_edit_faded";

		/**
		 * <img src='./icons/html_delete_faded.png'/>
		 */
		public static final String HTML_DELETE_FADED = "html_delete_faded";

		/**
		 * <img src='./icons/page_white_error.png'/>
		 */
		public static final String PAGE_WHITE_ERROR = "page_white_error";

		/**
		 * <img src='./icons/table_add_faded.png'/>
		 */
		public static final String TABLE_ADD_FADED = "table_add_faded";

		/**
		 * <img src='./icons/database_gear.png'/>
		 */
		public static final String DATABASE_GEAR = "database_gear";

		/**
		 * <img src='./icons/clock_add_faded.png'/>
		 */
		public static final String CLOCK_ADD_FADED = "clock_add_faded";

		/**
		 * <img src='./icons/user_plus.png'/>
		 */
		public static final String USER_PLUS = "user_plus";

		/**
		 * <img src='./icons/application_view_tile_faded.png'/>
		 */
		public static final String APPLICATION_VIEW_TILE_FADED = "application_view_tile_faded";

		/**
		 * <img src='./icons/transmit_add_faded.png'/>
		 */
		public static final String TRANSMIT_ADD_FADED = "transmit_add_faded";

		/**
		 * <img src='./icons/css_valid.png'/>
		 */
		public static final String CSS_VALID = "css_valid";

		/**
		 * <img src='./icons/page_go.png'/>
		 */
		public static final String PAGE_GO = "page_go";

		/**
		 * <img src='./icons/medal_bronze_1_faded.png'/>
		 */
		public static final String MEDAL_BRONZE_1_FADED = "medal_bronze_1_faded";

		/**
		 * <img src='./icons/medal_bronze_3_faded.png'/>
		 */
		public static final String MEDAL_BRONZE_3_FADED = "medal_bronze_3_faded";

		/**
		 * <img src='./icons/dvd_add.png'/>
		 */
		public static final String DVD_ADD = "dvd_add";

		/**
		 * <img src='./icons/font_delete.png'/>
		 */
		public static final String FONT_DELETE = "font_delete";

		/**
		 * <img src='./icons/comment.png'/>
		 */
		public static final String COMMENT = "comment";

		/**
		 * <img src='./icons/page_white_wrench.png'/>
		 */
		public static final String PAGE_WHITE_WRENCH = "page_white_wrench";

		/**
		 * <img src='./icons/hourglass_delete.png'/>
		 */
		public static final String HOURGLASS_DELETE = "hourglass_delete";

		/**
		 * <img src='./icons/bug_edit.png'/>
		 */
		public static final String BUG_EDIT = "bug_edit";

		/**
		 * <img src='./icons/arrow_rotate_clockwise_red.png'/>
		 */
		public static final String ARROW_ROTATE_CLOCKWISE_RED = "arrow_rotate_clockwise_red";

		/**
		 * <img src='./icons/text_align_center_faded.png'/>
		 */
		public static final String TEXT_ALIGN_CENTER_FADED = "text_align_center_faded";

		/**
		 * <img src='./icons/tag_blue_add.png'/>
		 */
		public static final String TAG_BLUE_ADD = "tag_blue_add";

		/**
		 * <img src='./icons/newspaper_go.png'/>
		 */
		public static final String NEWSPAPER_GO = "newspaper_go";

		/**
		 * <img src='./icons/image_delete.png'/>
		 */
		public static final String IMAGE_DELETE = "image_delete";

		/**
		 * <img src='./icons/ruby_put_faded.png'/>
		 */
		public static final String RUBY_PUT_FADED = "ruby_put_faded";

		/**
		 * <img src='./icons/controller.png'/>
		 */
		public static final String CONTROLLER = "controller";

		/**
		 * <img src='./icons/cup_add_faded.png'/>
		 */
		public static final String CUP_ADD_FADED = "cup_add_faded";

		/**
		 * <img src='./icons/map_magnify.png'/>
		 */
		public static final String MAP_MAGNIFY = "map_magnify";

		/**
		 * <img src='./icons/control_play_blue_down.png'/>
		 */
		public static final String CONTROL_PLAY_BLUE_DOWN = "control_play_blue_down";

		/**
		 * <img src='./icons/lock_go.png'/>
		 */
		public static final String LOCK_GO = "lock_go";

		/**
		 * <img src='./icons/textfield_key_faded.png'/>
		 */
		public static final String TEXTFIELD_KEY_FADED = "textfield_key_faded";

		/**
		 * <img src='./icons/database_save.png'/>
		 */
		public static final String DATABASE_SAVE = "database_save";

		/**
		 * <img src='./icons/browser_seamonkey.png'/>
		 */
		public static final String BROWSER_SEAMONKEY = "browser_seamonkey";

		/**
		 * <img src='./icons/control_stop_blue.png'/>
		 */
		public static final String CONTROL_STOP_BLUE = "control_stop_blue";

		/**
		 * <img src='./icons/phone_delete.png'/>
		 */
		public static final String PHONE_DELETE = "phone_delete";

		/**
		 * <img src='./icons/browser_netscape.png'/>
		 */
		public static final String BROWSER_NETSCAPE = "browser_netscape";

		/**
		 * <img src='./icons/server_database.png'/>
		 */
		public static final String SERVER_DATABASE = "server_database";

		/**
		 * <img src='./icons/application_key.png'/>
		 */
		public static final String APPLICATION_KEY = "application_key";

		/**
		 * <img src='./icons/timeline_marker_faded.png'/>
		 */
		public static final String TIMELINE_MARKER_FADED = "timeline_marker_faded";

		/**
		 * <img src='./icons/page_white_visualstudio_faded.png'/>
		 */
		public static final String PAGE_WHITE_VISUALSTUDIO_FADED = "page_white_visualstudio_faded";

		/**
		 * <img src='./icons/text_align_justify.png'/>
		 */
		public static final String TEXT_ALIGN_JUSTIFY = "text_align_justify";

		/**
		 * <img src='./icons/text_list_numbers_disk_faded.png'/>
		 */
		public static final String TEXT_LIST_NUMBERS_DISK_FADED = "text_list_numbers_disk_faded";

		/**
		 * <img src='./icons/medal_bronze_2.png'/>
		 */
		public static final String MEDAL_BRONZE_2 = "medal_bronze_2";

		/**
		 * <img src='./icons/email_open_image.png'/>
		 */
		public static final String EMAIL_OPEN_IMAGE = "email_open_image";

		/**
		 * <img src='./icons/text_letter_omega_faded.png'/>
		 */
		public static final String TEXT_LETTER_OMEGA_FADED = "text_letter_omega_faded";

		/**
		 * <img src='./icons/arrow_undo_red_faded.png'/>
		 */
		public static final String ARROW_UNDO_RED_FADED = "arrow_undo_red_faded";

		/**
		 * <img src='./icons/chart_line_add_faded.png'/>
		 */
		public static final String CHART_LINE_ADD_FADED = "chart_line_add_faded";

		/**
		 * <img src='./icons/page_white_code.png'/>
		 */
		public static final String PAGE_WHITE_CODE = "page_white_code";

		/**
		 * <img src='./icons/text_heading_5_faded.png'/>
		 */
		public static final String TEXT_HEADING_5_FADED = "text_heading_5_faded";

		/**
		 * <img src='./icons/connect.png'/>
		 */
		public static final String CONNECT = "connect";

		/**
		 * <img src='./icons/flag_red.png'/>
		 */
		public static final String FLAG_RED = "flag_red";

		/**
		 * <img src='./icons/script_weather_cloudy.png'/>
		 */
		public static final String SCRIPT_WEATHER_CLOUDY = "script_weather_cloudy";

		/**
		 * <img src='./icons/application_side_boxes_faded.png'/>
		 */
		public static final String APPLICATION_SIDE_BOXES_FADED = "application_side_boxes_faded";

		/**
		 * <img src='./icons/arrow_divide_down_faded.png'/>
		 */
		public static final String ARROW_DIVIDE_DOWN_FADED = "arrow_divide_down_faded";

		/**
		 * <img src='./icons/plugin_disabled.png'/>
		 */
		public static final String PLUGIN_DISABLED = "plugin_disabled";

		/**
		 * <img src='./icons/lightning_add.png'/>
		 */
		public static final String LIGHTNING_ADD = "lightning_add";

		/**
		 * <img src='./icons/text_heading_1_faded.png'/>
		 */
		public static final String TEXT_HEADING_1_FADED = "text_heading_1_faded";

		/**
		 * <img src='./icons/monitor_error.png'/>
		 */
		public static final String MONITOR_ERROR = "monitor_error";

		/**
		 * <img src='./icons/font_delete_faded.png'/>
		 */
		public static final String FONT_DELETE_FADED = "font_delete_faded";

		/**
		 * <img src='./icons/shape_rotate_anticlockwise_faded.png'/>
		 */
		public static final String SHAPE_ROTATE_ANTICLOCKWISE_FADED = "shape_rotate_anticlockwise_faded";

		/**
		 * <img src='./icons/plugin_delete.png'/>
		 */
		public static final String PLUGIN_DELETE = "plugin_delete";

		/**
		 * <img src='./icons/application_form_add_faded.png'/>
		 */
		public static final String APPLICATION_FORM_ADD_FADED = "application_form_add_faded";

		/**
		 * <img src='./icons/building_link_faded.png'/>
		 */
		public static final String BUILDING_LINK_FADED = "building_link_faded";

		/**
		 * <img src='./icons/user_alert.png'/>
		 */
		public static final String USER_ALERT = "user_alert";

		/**
		 * <img src='./icons/page_tick_faded.png'/>
		 */
		public static final String PAGE_TICK_FADED = "page_tick_faded";

		/**
		 * <img src='./icons/ruby_go.png'/>
		 */
		public static final String RUBY_GO = "ruby_go";

		/**
		 * <img src='./icons/text_subscript_faded.png'/>
		 */
		public static final String TEXT_SUBSCRIPT_FADED = "text_subscript_faded";

		/**
		 * <img src='./icons/computer_delete_faded.png'/>
		 */
		public static final String COMPUTER_DELETE_FADED = "computer_delete_faded";

		/**
		 * <img src='./icons/application_view_icons_faded.png'/>
		 */
		public static final String APPLICATION_VIEW_ICONS_FADED = "application_view_icons_faded";

		/**
		 * <img src='./icons/shape_align_left_faded.png'/>
		 */
		public static final String SHAPE_ALIGN_LEFT_FADED = "shape_align_left_faded";

		/**
		 * <img src='./icons/layout_sidebar_faded.png'/>
		 */
		public static final String LAYOUT_SIDEBAR_FADED = "layout_sidebar_faded";

		/**
		 * <img src='./icons/text_subscript.png'/>
		 */
		public static final String TEXT_SUBSCRIPT = "text_subscript";

		/**
		 * <img src='./icons/group_key.png'/>
		 */
		public static final String GROUP_KEY = "group_key";

		/**
		 * <img src='./icons/note_edit_faded.png'/>
		 */
		public static final String NOTE_EDIT_FADED = "note_edit_faded";

		/**
		 * <img src='./icons/music_save.png'/>
		 */
		public static final String MUSIC_SAVE = "music_save";

		/**
		 * <img src='./icons/vcard.png'/>
		 */
		public static final String VCARD = "vcard";

		/**
		 * <img src='./icons/shape_move_forwards.png'/>
		 */
		public static final String SHAPE_MOVE_FORWARDS = "shape_move_forwards";

		/**
		 * <img src='./icons/camera.png'/>
		 */
		public static final String CAMERA = "camera";

		/**
		 * <img src='./icons/page_white_coldfusion.png'/>
		 */
		public static final String PAGE_WHITE_COLDFUSION = "page_white_coldfusion";

		/**
		 * <img src='./icons/lightning.png'/>
		 */
		public static final String LIGHTNING = "lightning";

		/**
		 * <img src='./icons/font.png'/>
		 */
		public static final String FONT = "font";

		/**
		 * <img src='./icons/cog_go_faded.png'/>
		 */
		public static final String COG_GO_FADED = "cog_go_faded";

		/**
		 * <img src='./icons/weather_sun_faded.png'/>
		 */
		public static final String WEATHER_SUN_FADED = "weather_sun_faded";

		/**
		 * <img src='./icons/coins_add.png'/>
		 */
		public static final String COINS_ADD = "coins_add";

		/**
		 * <img src='./icons/ipod_cast_faded.png'/>
		 */
		public static final String IPOD_CAST_FADED = "ipod_cast_faded";

		/**
		 * <img src='./icons/zoom_in.png'/>
		 */
		public static final String ZOOM_IN = "zoom_in";

		/**
		 * <img src='./icons/rosette_faded.png'/>
		 */
		public static final String ROSETTE_FADED = "rosette_faded";

		/**
		 * <img src='./icons/page_white_excel.png'/>
		 */
		public static final String PAGE_WHITE_EXCEL = "page_white_excel";

		/**
		 * <img src='./icons/text_indent_remove.png'/>
		 */
		public static final String TEXT_INDENT_REMOVE = "text_indent_remove";

		/**
		 * <img src='./icons/bullet_red.png'/>
		 */
		public static final String BULLET_RED = "bullet_red";

		/**
		 * <img src='./icons/html_faded.png'/>
		 */
		public static final String HTML_FADED = "html_faded";

		/**
		 * <img src='./icons/chart_pie_faded.png'/>
		 */
		public static final String CHART_PIE_FADED = "chart_pie_faded";

		/**
		 * <img src='./icons/server.png'/>
		 */
		public static final String SERVER = "server";

		/**
		 * <img src='./icons/bullet_wrench_faded.png'/>
		 */
		public static final String BULLET_WRENCH_FADED = "bullet_wrench_faded";

		/**
		 * <img src='./icons/emoticon_unhappy_faded.png'/>
		 */
		public static final String EMOTICON_UNHAPPY_FADED = "emoticon_unhappy_faded";

		/**
		 * <img src='./icons/tag_green_faded.png'/>
		 */
		public static final String TAG_GREEN_FADED = "tag_green_faded";

		/**
		 * <img src='./icons/monitor_link.png'/>
		 */
		public static final String MONITOR_LINK = "monitor_link";

		/**
		 * <img src='./icons/email_add.png'/>
		 */
		public static final String EMAIL_ADD = "email_add";

		/**
		 * <img src='./icons/page_white_tux_faded.png'/>
		 */
		public static final String PAGE_WHITE_TUX_FADED = "page_white_tux_faded";

		/**
		 * <img src='./icons/tag_blue_edit_faded.png'/>
		 */
		public static final String TAG_BLUE_EDIT_FADED = "tag_blue_edit_faded";

		/**
		 * <img src='./icons/lorry_flatbed_faded.png'/>
		 */
		public static final String LORRY_FLATBED_FADED = "lorry_flatbed_faded";

		/**
		 * <img src='./icons/lightbulb_faded.png'/>
		 */
		public static final String LIGHTBULB_FADED = "lightbulb_faded";

		/**
		 * <img src='./icons/package_link.png'/>
		 */
		public static final String PACKAGE_LINK = "package_link";

		/**
		 * <img src='./icons/email_edit_faded.png'/>
		 */
		public static final String EMAIL_EDIT_FADED = "email_edit_faded";

		/**
		 * <img src='./icons/cup_error.png'/>
		 */
		public static final String CUP_ERROR = "cup_error";

		/**
		 * <img src='./icons/delete.png'/>
		 */
		public static final String DELETE = "delete";

		/**
		 * <img src='./icons/application_split_faded.png'/>
		 */
		public static final String APPLICATION_SPLIT_FADED = "application_split_faded";

		/**
		 * <img src='./icons/page_white_paint_faded.png'/>
		 */
		public static final String PAGE_WHITE_PAINT_FADED = "page_white_paint_faded";

		/**
		 * <img src='./icons/ruby.png'/>
		 */
		public static final String RUBY = "ruby";

		/**
		 * <img src='./icons/award_star_bronze_2_faded.png'/>
		 */
		public static final String AWARD_STAR_BRONZE_2_FADED = "award_star_bronze_2_faded";

		/**
		 * <img src='./icons/clock_edit_faded.png'/>
		 */
		public static final String CLOCK_EDIT_FADED = "clock_edit_faded";

		/**
		 * <img src='./icons/rainbow.png'/>
		 */
		public static final String RAINBOW = "rainbow";

		/**
		 * <img src='./icons/browser_konqueror_faded.png'/>
		 */
		public static final String BROWSER_KONQUEROR_FADED = "browser_konqueror_faded";

		/**
		 * <img src='./icons/vcard_add_faded.png'/>
		 */
		public static final String VCARD_ADD_FADED = "vcard_add_faded";

		/**
		 * <img src='./icons/page_white_paste_faded.png'/>
		 */
		public static final String PAGE_WHITE_PASTE_FADED = "page_white_paste_faded";

		/**
		 * <img src='./icons/application_view_list.png'/>
		 */
		public static final String APPLICATION_VIEW_LIST = "application_view_list";

		/**
		 * <img src='./icons/html_valid_faded.png'/>
		 */
		public static final String HTML_VALID_FADED = "html_valid_faded";

		/**
		 * <img src='./icons/application_view_tile.png'/>
		 */
		public static final String APPLICATION_VIEW_TILE = "application_view_tile";

		/**
		 * <img src='./icons/page_tick.png'/>
		 */
		public static final String PAGE_TICK = "page_tick";

		/**
		 * <img src='./icons/medal_silver_delete.png'/>
		 */
		public static final String MEDAL_SILVER_DELETE = "medal_silver_delete";

		/**
		 * <img src='./icons/contrast_high_faded.png'/>
		 */
		public static final String CONTRAST_HIGH_FADED = "contrast_high_faded";

		/**
		 * <img src='./icons/flag_green_faded.png'/>
		 */
		public static final String FLAG_GREEN_FADED = "flag_green_faded";

		/**
		 * <img src='./icons/table_go_faded.png'/>
		 */
		public static final String TABLE_GO_FADED = "table_go_faded";

		/**
		 * <img src='./icons/brick_error_faded.png'/>
		 */
		public static final String BRICK_ERROR_FADED = "brick_error_faded";

		/**
		 * <img src='./icons/folder_camera_faded.png'/>
		 */
		public static final String FOLDER_CAMERA_FADED = "folder_camera_faded";

		/**
		 * <img src='./icons/color_wheel_faded.png'/>
		 */
		public static final String COLOR_WHEEL_FADED = "color_wheel_faded";

		/**
		 * <img src='./icons/ruby_put.png'/>
		 */
		public static final String RUBY_PUT = "ruby_put";

		/**
		 * <img src='./icons/group_go_faded.png'/>
		 */
		public static final String GROUP_GO_FADED = "group_go_faded";

		/**
		 * <img src='./icons/application_lightning.png'/>
		 */
		public static final String APPLICATION_LIGHTNING = "application_lightning";

		/**
		 * <img src='./icons/lorry_go_faded.png'/>
		 */
		public static final String LORRY_GO_FADED = "lorry_go_faded";

		/**
		 * <img src='./icons/page_link_faded.png'/>
		 */
		public static final String PAGE_LINK_FADED = "page_link_faded";

		/**
		 * <img src='./icons/exclamation_faded.png'/>
		 */
		public static final String EXCLAMATION_FADED = "exclamation_faded";

		/**
		 * <img src='./icons/layout_content_faded.png'/>
		 */
		public static final String LAYOUT_CONTENT_FADED = "layout_content_faded";

		/**
		 * <img src='./icons/xhtml_go_faded.png'/>
		 */
		public static final String XHTML_GO_FADED = "xhtml_go_faded";

		/**
		 * <img src='./icons/chart_curve_go.png'/>
		 */
		public static final String CHART_CURVE_GO = "chart_curve_go";

		/**
		 * <img src='./icons/textfield_delete.png'/>
		 */
		public static final String TEXTFIELD_DELETE = "textfield_delete";

		/**
		 * <img src='./icons/chart_pie_edit_faded.png'/>
		 */
		public static final String CHART_PIE_EDIT_FADED = "chart_pie_edit_faded";

		/**
		 * <img src='./icons/female.png'/>
		 */
		public static final String FEMALE = "female";

		/**
		 * <img src='./icons/money_pound_faded.png'/>
		 */
		public static final String MONEY_POUND_FADED = "money_pound_faded";

		/**
		 * <img src='./icons/arrow_branch_red_faded.png'/>
		 */
		public static final String ARROW_BRANCH_RED_FADED = "arrow_branch_red_faded";

		/**
		 * <img src='./icons/user_gray_faded.png'/>
		 */
		public static final String USER_GRAY_FADED = "user_gray_faded";

		/**
		 * <img src='./icons/pill_add.png'/>
		 */
		public static final String PILL_ADD = "pill_add";

		/**
		 * <img src='./icons/clock_play.png'/>
		 */
		public static final String CLOCK_PLAY = "clock_play";

		/**
		 * <img src='./icons/transmit_go_faded.png'/>
		 */
		public static final String TRANSMIT_GO_FADED = "transmit_go_faded";

		/**
		 * <img src='./icons/cross.png'/>
		 */
		public static final String CROSS = "cross";

		/**
		 * <img src='./icons/award_star_bronze_3.png'/>
		 */
		public static final String AWARD_STAR_BRONZE_3 = "award_star_bronze_3";

		/**
		 * <img src='./icons/clock_edit.png'/>
		 */
		public static final String CLOCK_EDIT = "clock_edit";

		/**
		 * <img src='./icons/arrow_down_faded.png'/>
		 */
		public static final String ARROW_DOWN_FADED = "arrow_down_faded";

		/**
		 * <img src='./icons/book_link_faded.png'/>
		 */
		public static final String BOOK_LINK_FADED = "book_link_faded";

		/**
		 * <img src='./icons/shield_delete.png'/>
		 */
		public static final String SHIELD_DELETE = "shield_delete";

		/**
		 * <img src='./icons/link_edit.png'/>
		 */
		public static final String LINK_EDIT = "link_edit";

		/**
		 * <img src='./icons/resultset_first.png'/>
		 */
		public static final String RESULTSET_FIRST = "resultset_first";

		/**
		 * <img src='./icons/lightning_delete.png'/>
		 */
		public static final String LIGHTNING_DELETE = "lightning_delete";

		/**
		 * <img src='./icons/map_edit.png'/>
		 */
		public static final String MAP_EDIT = "map_edit";

		/**
		 * <img src='./icons/textfield_key.png'/>
		 */
		public static final String TEXTFIELD_KEY = "textfield_key";

		/**
		 * <img src='./icons/shape_square_delete.png'/>
		 */
		public static final String SHAPE_SQUARE_DELETE = "shape_square_delete";

		/**
		 * <img src='./icons/note_error.png'/>
		 */
		public static final String NOTE_ERROR = "note_error";

		/**
		 * <img src='./icons/lorry.png'/>
		 */
		public static final String LORRY = "lorry";

		/**
		 * <img src='./icons/page_white_powerpoint.png'/>
		 */
		public static final String PAGE_WHITE_POWERPOINT = "page_white_powerpoint";

		/**
		 * <img src='./icons/printer_empty_faded.png'/>
		 */
		public static final String PRINTER_EMPTY_FADED = "printer_empty_faded";

		/**
		 * <img src='./icons/page_white_freehand.png'/>
		 */
		public static final String PAGE_WHITE_FREEHAND = "page_white_freehand";

		/**
		 * <img src='./icons/camera_small.png'/>
		 */
		public static final String CAMERA_SMALL = "camera_small";

		/**
		 * <img src='./icons/bin.png'/>
		 */
		public static final String BIN = "bin";

		/**
		 * <img src='./icons/spellcheck.png'/>
		 */
		public static final String SPELLCHECK = "spellcheck";

		/**
		 * <img src='./icons/magnifier_zoom_in_faded.png'/>
		 */
		public static final String MAGNIFIER_ZOOM_IN_FADED = "magnifier_zoom_in_faded";

		/**
		 * <img src='./icons/text_padding_right.png'/>
		 */
		public static final String TEXT_PADDING_RIGHT = "text_padding_right";

		/**
		 * <img src='./icons/drive_web_faded.png'/>
		 */
		public static final String DRIVE_WEB_FADED = "drive_web_faded";

		/**
		 * <img src='./icons/shape_move_backwards_faded.png'/>
		 */
		public static final String SHAPE_MOVE_BACKWARDS_FADED = "shape_move_backwards_faded";

		/**
		 * <img src='./icons/flag_orange.png'/>
		 */
		public static final String FLAG_ORANGE = "flag_orange";

		/**
		 * <img src='./icons/link_faded.png'/>
		 */
		public static final String LINK_FADED = "link_faded";

		/**
		 * <img src='./icons/page_white_code_red.png'/>
		 */
		public static final String PAGE_WHITE_CODE_RED = "page_white_code_red";

		/**
		 * <img src='./icons/page_white_edit_faded.png'/>
		 */
		public static final String PAGE_WHITE_EDIT_FADED = "page_white_edit_faded";

		/**
		 * <img src='./icons/calendar_delete_faded.png'/>
		 */
		public static final String CALENDAR_DELETE_FADED = "calendar_delete_faded";

		/**
		 * <img src='./icons/control_pause_faded.png'/>
		 */
		public static final String CONTROL_PAUSE_FADED = "control_pause_faded";

		/**
		 * <img src='./icons/bullet_green.png'/>
		 */
		public static final String BULLET_GREEN = "bullet_green";

		/**
		 * <img src='./icons/group_link_faded.png'/>
		 */
		public static final String GROUP_LINK_FADED = "group_link_faded";

		/**
		 * <img src='./icons/emoticon_surprised.png'/>
		 */
		public static final String EMOTICON_SURPRISED = "emoticon_surprised";

		/**
		 * <img src='./icons/browser_shiira.png'/>
		 */
		public static final String BROWSER_SHIIRA = "browser_shiira";

		/**
		 * <img src='./icons/group_key_faded.png'/>
		 */
		public static final String GROUP_KEY_FADED = "group_key_faded";

		/**
		 * <img src='./icons/note_faded.png'/>
		 */
		public static final String NOTE_FADED = "note_faded";

		/**
		 * <img src='./icons/pilcrow_faded.png'/>
		 */
		public static final String PILCROW_FADED = "pilcrow_faded";

		/**
		 * <img src='./icons/computer_go.png'/>
		 */
		public static final String COMPUTER_GO = "computer_go";

		/**
		 * <img src='./icons/printer_faded.png'/>
		 */
		public static final String PRINTER_FADED = "printer_faded";

		/**
		 * <img src='./icons/arrow_turn_right_red_faded.png'/>
		 */
		public static final String ARROW_TURN_RIGHT_RED_FADED = "arrow_turn_right_red_faded";

		/**
		 * <img src='./icons/shape_square_error.png'/>
		 */
		public static final String SHAPE_SQUARE_ERROR = "shape_square_error";

		/**
		 * <img src='./icons/folder_user.png'/>
		 */
		public static final String FOLDER_USER = "folder_user";

		/**
		 * <img src='./icons/map_faded.png'/>
		 */
		public static final String MAP_FADED = "map_faded";

		/**
		 * <img src='./icons/shape_square_key.png'/>
		 */
		public static final String SHAPE_SQUARE_KEY = "shape_square_key";

		/**
		 * <img src='./icons/server_go_faded.png'/>
		 */
		public static final String SERVER_GO_FADED = "server_go_faded";

		/**
		 * <img src='./icons/building_link.png'/>
		 */
		public static final String BUILDING_LINK = "building_link";

		/**
		 * <img src='./icons/page_save_faded.png'/>
		 */
		public static final String PAGE_SAVE_FADED = "page_save_faded";

		/**
		 * <img src='./icons/control_eject_faded.png'/>
		 */
		public static final String CONTROL_EJECT_FADED = "control_eject_faded";

		/**
		 * <img src='./icons/user_comment.png'/>
		 */
		public static final String USER_COMMENT = "user_comment";

		/**
		 * <img src='./icons/webcam_faded.png'/>
		 */
		public static final String WEBCAM_FADED = "webcam_faded";

		/**
		 * <img src='./icons/server_link.png'/>
		 */
		public static final String SERVER_LINK = "server_link";

		/**
		 * <img src='./icons/user_brown.png'/>
		 */
		public static final String USER_BROWN = "user_brown";

		/**
		 * <img src='./icons/image.png'/>
		 */
		public static final String IMAGE = "image";

		/**
		 * <img src='./icons/zoom_out.png'/>
		 */
		public static final String ZOOM_OUT = "zoom_out";

		/**
		 * <img src='./icons/date_error_faded.png'/>
		 */
		public static final String DATE_ERROR_FADED = "date_error_faded";

		/**
		 * <img src='./icons/text_heading_4_faded.png'/>
		 */
		public static final String TEXT_HEADING_4_FADED = "text_heading_4_faded";

		/**
		 * <img src='./icons/user_suit.png'/>
		 */
		public static final String USER_SUIT = "user_suit";

		/**
		 * <img src='./icons/tux.png'/>
		 */
		public static final String TUX = "tux";

		/**
		 * <img src='./icons/table_go.png'/>
		 */
		public static final String TABLE_GO = "table_go";

		/**
		 * <img src='./icons/vcard_edit.png'/>
		 */
		public static final String VCARD_EDIT = "vcard_edit";

		/**
		 * <img src='./icons/chart_bar_delete_faded.png'/>
		 */
		public static final String CHART_BAR_DELETE_FADED = "chart_bar_delete_faded";

		/**
		 * <img src='./icons/page_white_code_red_faded.png'/>
		 */
		public static final String PAGE_WHITE_CODE_RED_FADED = "page_white_code_red_faded";

		/**
		 * <img src='./icons/rss_valid.png'/>
		 */
		public static final String RSS_VALID = "rss_valid";

		/**
		 * <img src='./icons/chart_line_link_faded.png'/>
		 */
		public static final String CHART_LINE_LINK_FADED = "chart_line_link_faded";

		/**
		 * <img src='./icons/folder_heart_faded.png'/>
		 */
		public static final String FOLDER_HEART_FADED = "folder_heart_faded";

		/**
		 * <img src='./icons/bullet_star_faded.png'/>
		 */
		public static final String BULLET_STAR_FADED = "bullet_star_faded";

		/**
		 * <img src='./icons/text_letterspacing.png'/>
		 */
		public static final String TEXT_LETTERSPACING = "text_letterspacing";

		/**
		 * <img src='./icons/money_add_faded.png'/>
		 */
		public static final String MONEY_ADD_FADED = "money_add_faded";

		/**
		 * <img src='./icons/time_add.png'/>
		 */
		public static final String TIME_ADD = "time_add";

		/**
		 * <img src='./icons/bug_error_faded.png'/>
		 */
		public static final String BUG_ERROR_FADED = "bug_error_faded";

		/**
		 * <img src='./icons/shape_move_forwards_faded.png'/>
		 */
		public static final String SHAPE_MOVE_FORWARDS_FADED = "shape_move_forwards_faded";

		/**
		 * <img src='./icons/time_faded.png'/>
		 */
		public static final String TIME_FADED = "time_faded";

		/**
		 * <img src='./icons/control_start_blue_faded.png'/>
		 */
		public static final String CONTROL_START_BLUE_FADED = "control_start_blue_faded";

		/**
		 * <img src='./icons/arrow_redo_faded.png'/>
		 */
		public static final String ARROW_REDO_FADED = "arrow_redo_faded";

		/**
		 * <img src='./icons/user_gray_magnify.png'/>
		 */
		public static final String USER_GRAY_MAGNIFY = "user_gray_magnify";

		/**
		 * <img src='./icons/rosette.png'/>
		 */
		public static final String ROSETTE = "rosette";

		/**
		 * <img src='./icons/pill_add_faded.png'/>
		 */
		public static final String PILL_ADD_FADED = "pill_add_faded";

		/**
		 * <img src='./icons/page_go_faded.png'/>
		 */
		public static final String PAGE_GO_FADED = "page_go_faded";

		/**
		 * <img src='./icons/page_white_medal_faded.png'/>
		 */
		public static final String PAGE_WHITE_MEDAL_FADED = "page_white_medal_faded";

		/**
		 * <img src='./icons/cursor.png'/>
		 */
		public static final String CURSOR = "cursor";

		/**
		 * <img src='./icons/application_form_edit.png'/>
		 */
		public static final String APPLICATION_FORM_EDIT = "application_form_edit";

		/**
		 * <img src='./icons/database_connect.png'/>
		 */
		public static final String DATABASE_CONNECT = "database_connect";

		/**
		 * <img src='./icons/lock.png'/>
		 */
		public static final String LOCK = "lock";

		/**
		 * <img src='./icons/user_tick.png'/>
		 */
		public static final String USER_TICK = "user_tick";

		/**
		 * <img src='./icons/medal_silver_add_faded.png'/>
		 */
		public static final String MEDAL_SILVER_ADD_FADED = "medal_silver_add_faded";

		/**
		 * <img src='./icons/lightbulb_off_faded.png'/>
		 */
		public static final String LIGHTBULB_OFF_FADED = "lightbulb_off_faded";

		/**
		 * <img src='./icons/emoticon_waii_faded.png'/>
		 */
		public static final String EMOTICON_WAII_FADED = "emoticon_waii_faded";

		/**
		 * <img src='./icons/script_error.png'/>
		 */
		public static final String SCRIPT_ERROR = "script_error";

		/**
		 * <img src='./icons/css_delete.png'/>
		 */
		public static final String CSS_DELETE = "css_delete";

		/**
		 * <img src='./icons/sport_8ball.png'/>
		 */
		public static final String SPORT_8BALL = "sport_8ball";

		/**
		 * <img src='./icons/folder_heart.png'/>
		 */
		public static final String FOLDER_HEART = "folder_heart";

		/**
		 * <img src='./icons/monitor_add_faded.png'/>
		 */
		public static final String MONITOR_ADD_FADED = "monitor_add_faded";

		/**
		 * <img src='./icons/server_add_faded.png'/>
		 */
		public static final String SERVER_ADD_FADED = "server_add_faded";

		/**
		 * <img src='./icons/time_go.png'/>
		 */
		public static final String TIME_GO = "time_go";

		/**
		 * <img src='./icons/tag_faded.png'/>
		 */
		public static final String TAG_FADED = "tag_faded";

		/**
		 * <img src='./icons/page_white_medal.png'/>
		 */
		public static final String PAGE_WHITE_MEDAL = "page_white_medal";

		/**
		 * <img src='./icons/page_green.png'/>
		 */
		public static final String PAGE_GREEN = "page_green";

		/**
		 * <img src='./icons/script_go.png'/>
		 */
		public static final String SCRIPT_GO = "script_go";

		/**
		 * <img src='./icons/arrow_down.png'/>
		 */
		public static final String ARROW_DOWN = "arrow_down";

		/**
		 * <img src='./icons/rss_add_faded.png'/>
		 */
		public static final String RSS_ADD_FADED = "rss_add_faded";

		/**
		 * <img src='./icons/report_word_faded.png'/>
		 */
		public static final String REPORT_WORD_FADED = "report_word_faded";

		/**
		 * <img src='./icons/transmit_edit_faded.png'/>
		 */
		public static final String TRANSMIT_EDIT_FADED = "transmit_edit_faded";

		/**
		 * <img src='./icons/user_gray_add.png'/>
		 */
		public static final String USER_GRAY_ADD = "user_gray_add";

		/**
		 * <img src='./icons/clock_error.png'/>
		 */
		public static final String CLOCK_ERROR = "clock_error";

		/**
		 * <img src='./icons/star.png'/>
		 */
		public static final String STAR = "star";

		/**
		 * <img src='./icons/link.png'/>
		 */
		public static final String LINK = "link";

		/**
		 * <img src='./icons/page_white_acrobat.png'/>
		 */
		public static final String PAGE_WHITE_ACROBAT = "page_white_acrobat";

		/**
		 * <img src='./icons/phone_sound.png'/>
		 */
		public static final String PHONE_SOUND = "phone_sound";

		/**
		 * <img src='./icons/house.png'/>
		 */
		public static final String HOUSE = "house";

		/**
		 * <img src='./icons/door_faded.png'/>
		 */
		public static final String DOOR_FADED = "door_faded";

		/**
		 * <img src='./icons/film_faded.png'/>
		 */
		public static final String FILM_FADED = "film_faded";

		/**
		 * <img src='./icons/cd_faded.png'/>
		 */
		public static final String CD_FADED = "cd_faded";

		/**
		 * <img src='./icons/folder_brick_faded.png'/>
		 */
		public static final String FOLDER_BRICK_FADED = "folder_brick_faded";

		/**
		 * <img src='./icons/email_attach_faded.png'/>
		 */
		public static final String EMAIL_ATTACH_FADED = "email_attach_faded";

		/**
		 * <img src='./icons/money_euro.png'/>
		 */
		public static final String MONEY_EURO = "money_euro";

		/**
		 * <img src='./icons/zoom_faded.png'/>
		 */
		public static final String ZOOM_FADED = "zoom_faded";

		/**
		 * <img src='./icons/clock_red_faded.png'/>
		 */
		public static final String CLOCK_RED_FADED = "clock_red_faded";

		/**
		 * <img src='./icons/layout_delete.png'/>
		 */
		public static final String LAYOUT_DELETE = "layout_delete";

		/**
		 * <img src='./icons/lorry_error.png'/>
		 */
		public static final String LORRY_ERROR = "lorry_error";

		/**
		 * <img src='./icons/shield_faded.png'/>
		 */
		public static final String SHIELD_FADED = "shield_faded";

		/**
		 * <img src='./icons/text_columns.png'/>
		 */
		public static final String TEXT_COLUMNS = "text_columns";

		/**
		 * <img src='./icons/folder_magnify_faded.png'/>
		 */
		public static final String FOLDER_MAGNIFY_FADED = "folder_magnify_faded";

		/**
		 * <img src='./icons/page_key_faded.png'/>
		 */
		public static final String PAGE_KEY_FADED = "page_key_faded";

		/**
		 * <img src='./icons/folder_find_faded.png'/>
		 */
		public static final String FOLDER_FIND_FADED = "folder_find_faded";

		/**
		 * <img src='./icons/date_error.png'/>
		 */
		public static final String DATE_ERROR = "date_error";

		/**
		 * <img src='./icons/time_delete.png'/>
		 */
		public static final String TIME_DELETE = "time_delete";

		/**
		 * <img src='./icons/control_equalizer.png'/>
		 */
		public static final String CONTROL_EQUALIZER = "control_equalizer";

		/**
		 * <img src='./icons/cog_faded.png'/>
		 */
		public static final String COG_FADED = "cog_faded";

		/**
		 * <img src='./icons/drive_cd.png'/>
		 */
		public static final String DRIVE_CD = "drive_cd";

		/**
		 * <img src='./icons/cart_put.png'/>
		 */
		public static final String CART_PUT = "cart_put";

		/**
		 * <img src='./icons/report_key.png'/>
		 */
		public static final String REPORT_KEY = "report_key";

		/**
		 * <img src='./icons/page_white_flash_faded.png'/>
		 */
		public static final String PAGE_WHITE_FLASH_FADED = "page_white_flash_faded";

		/**
		 * <img src='./icons/medal_gold_3_faded.png'/>
		 */
		public static final String MEDAL_GOLD_3_FADED = "medal_gold_3_faded";

		/**
		 * <img src='./icons/money_yen.png'/>
		 */
		public static final String MONEY_YEN = "money_yen";

		/**
		 * <img src='./icons/lorry_link_faded.png'/>
		 */
		public static final String LORRY_LINK_FADED = "lorry_link_faded";

		/**
		 * <img src='./icons/delete_faded.png'/>
		 */
		public static final String DELETE_FADED = "delete_faded";

		/**
		 * <img src='./icons/flag_purple_faded.png'/>
		 */
		public static final String FLAG_PURPLE_FADED = "flag_purple_faded";

		/**
		 * <img src='./icons/pencil_go_faded.png'/>
		 */
		public static final String PENCIL_GO_FADED = "pencil_go_faded";

		/**
		 * <img src='./icons/dvd_error_faded.png'/>
		 */
		public static final String DVD_ERROR_FADED = "dvd_error_faded";

		/**
		 * <img src='./icons/page_white_ruby.png'/>
		 */
		public static final String PAGE_WHITE_RUBY = "page_white_ruby";

		/**
		 * <img src='./icons/calculator_add.png'/>
		 */
		public static final String CALCULATOR_ADD = "calculator_add";

		/**
		 * <img src='./icons/application_view_columns.png'/>
		 */
		public static final String APPLICATION_VIEW_COLUMNS = "application_view_columns";

		/**
		 * <img src='./icons/picture_save_faded.png'/>
		 */
		public static final String PICTURE_SAVE_FADED = "picture_save_faded";

		/**
		 * <img src='./icons/script_money.png'/>
		 */
		public static final String SCRIPT_MONEY = "script_money";

		/**
		 * <img src='./icons/bomb.png'/>
		 */
		public static final String BOMB = "bomb";

		/**
		 * <img src='./icons/arrow_right_red.png'/>
		 */
		public static final String ARROW_RIGHT_RED = "arrow_right_red";

		/**
		 * <img src='./icons/server_edit.png'/>
		 */
		public static final String SERVER_EDIT = "server_edit";

		/**
		 * <img src='./icons/bell_error.png'/>
		 */
		public static final String BELL_ERROR = "bell_error";

		/**
		 * <img src='./icons/building_key_faded.png'/>
		 */
		public static final String BUILDING_KEY_FADED = "building_key_faded";

		/**
		 * <img src='./icons/script_zoom.png'/>
		 */
		public static final String SCRIPT_ZOOM = "script_zoom";

		/**
		 * <img src='./icons/ipod_cast_add_faded.png'/>
		 */
		public static final String IPOD_CAST_ADD_FADED = "ipod_cast_add_faded";

		/**
		 * <img src='./icons/sport_tennis.png'/>
		 */
		public static final String SPORT_TENNIS = "sport_tennis";

		/**
		 * <img src='./icons/telephone_error_faded.png'/>
		 */
		public static final String TELEPHONE_ERROR_FADED = "telephone_error_faded";

		/**
		 * <img src='./icons/building_error.png'/>
		 */
		public static final String BUILDING_ERROR = "building_error";

		/**
		 * <img src='./icons/newspaper_link.png'/>
		 */
		public static final String NEWSPAPER_LINK = "newspaper_link";

		/**
		 * <img src='./icons/photo_delete.png'/>
		 */
		public static final String PHOTO_DELETE = "photo_delete";

		/**
		 * <img src='./icons/lightning_delete_faded.png'/>
		 */
		public static final String LIGHTNING_DELETE_FADED = "lightning_delete_faded";

		/**
		 * <img src='./icons/shape_handles_faded.png'/>
		 */
		public static final String SHAPE_HANDLES_FADED = "shape_handles_faded";

		/**
		 * <img src='./icons/attach_faded.png'/>
		 */
		public static final String ATTACH_FADED = "attach_faded";

		/**
		 * <img src='./icons/package_go.png'/>
		 */
		public static final String PACKAGE_GO = "package_go";

		/**
		 * <img src='./icons/page_white_cd_faded.png'/>
		 */
		public static final String PAGE_WHITE_CD_FADED = "page_white_cd_faded";

		/**
		 * <img src='./icons/note_add.png'/>
		 */
		public static final String NOTE_ADD = "note_add";

		/**
		 * <img src='./icons/browser_netscape_faded.png'/>
		 */
		public static final String BROWSER_NETSCAPE_FADED = "browser_netscape_faded";

		/**
		 * <img src='./icons/application_faded.png'/>
		 */
		public static final String APPLICATION_FADED = "application_faded";

		/**
		 * <img src='./icons/bullet_pink_faded.png'/>
		 */
		public static final String BULLET_PINK_FADED = "bullet_pink_faded";

		/**
		 * <img src='./icons/cd_burn.png'/>
		 */
		public static final String CD_BURN = "cd_burn";

		/**
		 * <img src='./icons/folder_edit.png'/>
		 */
		public static final String FOLDER_EDIT = "folder_edit";

		/**
		 * <img src='./icons/newspaper_add_faded.png'/>
		 */
		public static final String NEWSPAPER_ADD_FADED = "newspaper_add_faded";

		/**
		 * <img src='./icons/server_uncompressed_faded.png'/>
		 */
		public static final String SERVER_UNCOMPRESSED_FADED = "server_uncompressed_faded";

		/**
		 * <img src='./icons/table_multiple.png'/>
		 */
		public static final String TABLE_MULTIPLE = "table_multiple";

		/**
		 * <img src='./icons/arrow_inout_red_faded.png'/>
		 */
		public static final String ARROW_INOUT_RED_FADED = "arrow_inout_red_faded";

		/**
		 * <img src='./icons/hourglass_link_faded.png'/>
		 */
		public static final String HOURGLASS_LINK_FADED = "hourglass_link_faded";

		/**
		 * <img src='./icons/lightning_faded.png'/>
		 */
		public static final String LIGHTNING_FADED = "lightning_faded";

		/**
		 * <img src='./icons/folder_go_faded.png'/>
		 */
		public static final String FOLDER_GO_FADED = "folder_go_faded";

		/**
		 * <img src='./icons/telephone_link_faded.png'/>
		 */
		public static final String TELEPHONE_LINK_FADED = "telephone_link_faded";

		/**
		 * <img src='./icons/arrow_in.png'/>
		 */
		public static final String ARROW_IN = "arrow_in";

		/**
		 * <img src='./icons/page_white_text_faded.png'/>
		 */
		public static final String PAGE_WHITE_TEXT_FADED = "page_white_text_faded";

		/**
		 * <img src='./icons/paste_plain_faded.png'/>
		 */
		public static final String PASTE_PLAIN_FADED = "paste_plain_faded";

		/**
		 * <img src='./icons/music_faded.png'/>
		 */
		public static final String MUSIC_FADED = "music_faded";

		/**
		 * <img src='./icons/sport_football.png'/>
		 */
		public static final String SPORT_FOOTBALL = "sport_football";

		/**
		 * <img src='./icons/table.png'/>
		 */
		public static final String TABLE = "table";

		/**
		 * <img src='./icons/cart_add.png'/>
		 */
		public static final String CART_ADD = "cart_add";

		/**
		 * <img src='./icons/rss_delete_faded.png'/>
		 */
		public static final String RSS_DELETE_FADED = "rss_delete_faded";

		/**
		 * <img src='./icons/tab_edit.png'/>
		 */
		public static final String TAB_EDIT = "tab_edit";

		/**
		 * <img src='./icons/xhtml_delete.png'/>
		 */
		public static final String XHTML_DELETE = "xhtml_delete";

		/**
		 * <img src='./icons/page_excel_faded.png'/>
		 */
		public static final String PAGE_EXCEL_FADED = "page_excel_faded";

		/**
		 * <img src='./icons/page_find_faded.png'/>
		 */
		public static final String PAGE_FIND_FADED = "page_find_faded";

		/**
		 * <img src='./icons/bug_edit_faded.png'/>
		 */
		public static final String BUG_EDIT_FADED = "bug_edit_faded";

		/**
		 * <img src='./icons/package_add.png'/>
		 */
		public static final String PACKAGE_ADD = "package_add";

		/**
		 * <img src='./icons/page_white_link_faded.png'/>
		 */
		public static final String PAGE_WHITE_LINK_FADED = "page_white_link_faded";

		/**
		 * <img src='./icons/html_add_faded.png'/>
		 */
		public static final String HTML_ADD_FADED = "html_add_faded";

		/**
		 * <img src='./icons/link_break.png'/>
		 */
		public static final String LINK_BREAK = "link_break";

		/**
		 * <img src='./icons/lorry_user_female_faded.png'/>
		 */
		public static final String LORRY_USER_FEMALE_FADED = "lorry_user_female_faded";

		/**
		 * <img src='./icons/lorry_error_faded.png'/>
		 */
		public static final String LORRY_ERROR_FADED = "lorry_error_faded";

		/**
		 * <img src='./icons/arrow_refresh_small.png'/>
		 */
		public static final String ARROW_REFRESH_SMALL = "arrow_refresh_small";

		/**
		 * <img src='./icons/comment_faded.png'/>
		 */
		public static final String COMMENT_FADED = "comment_faded";

		/**
		 * <img src='./icons/script_date.png'/>
		 */
		public static final String SCRIPT_DATE = "script_date";

		/**
		 * <img src='./icons/arrow_rotate_anticlockwise_red_faded.png'/>
		 */
		public static final String ARROW_ROTATE_ANTICLOCKWISE_RED_FADED = "arrow_rotate_anticlockwise_red_faded";

		/**
		 * <img src='./icons/newspaper.png'/>
		 */
		public static final String NEWSPAPER = "newspaper";

		/**
		 * <img src='./icons/shape_group.png'/>
		 */
		public static final String SHAPE_GROUP = "shape_group";

		/**
		 * <img src='./icons/report_add.png'/>
		 */
		public static final String REPORT_ADD = "report_add";

		/**
		 * <img src='./icons/user_disk.png'/>
		 */
		public static final String USER_DISK = "user_disk";

		/**
		 * <img src='./icons/chart_bar.png'/>
		 */
		public static final String CHART_BAR = "chart_bar";

		/**
		 * <img src='./icons/flag_blue.png'/>
		 */
		public static final String FLAG_BLUE = "flag_blue";

		/**
		 * <img src='./icons/drive_magnify_faded.png'/>
		 */
		public static final String DRIVE_MAGNIFY_FADED = "drive_magnify_faded";

		/**
		 * <img src='./icons/door_open.png'/>
		 */
		public static final String DOOR_OPEN = "door_open";

		/**
		 * <img src='./icons/page_white_swoosh.png'/>
		 */
		public static final String PAGE_WHITE_SWOOSH = "page_white_swoosh";

		/**
		 * <img src='./icons/basket_go.png'/>
		 */
		public static final String BASKET_GO = "basket_go";

		/**
		 * <img src='./icons/application_cascade_faded.png'/>
		 */
		public static final String APPLICATION_CASCADE_FADED = "application_cascade_faded";

		/**
		 * <img src='./icons/house_faded.png'/>
		 */
		public static final String HOUSE_FADED = "house_faded";

		/**
		 * <img src='./icons/tag_orange.png'/>
		 */
		public static final String TAG_ORANGE = "tag_orange";

		/**
		 * <img src='./icons/television_delete.png'/>
		 */
		public static final String TELEVISION_DELETE = "television_delete";

		/**
		 * <img src='./icons/comments_add.png'/>
		 */
		public static final String COMMENTS_ADD = "comments_add";

		/**
		 * <img src='./icons/newspaper_delete_faded.png'/>
		 */
		public static final String NEWSPAPER_DELETE_FADED = "newspaper_delete_faded";

		/**
		 * <img src='./icons/shape_ungroup_faded.png'/>
		 */
		public static final String SHAPE_UNGROUP_FADED = "shape_ungroup_faded";

		/**
		 * <img src='./icons/email_edit.png'/>
		 */
		public static final String EMAIL_EDIT = "email_edit";

		/**
		 * <img src='./icons/css_add_faded.png'/>
		 */
		public static final String CSS_ADD_FADED = "css_add_faded";

		/**
		 * <img src='./icons/application_form_edit_faded.png'/>
		 */
		public static final String APPLICATION_FORM_EDIT_FADED = "application_form_edit_faded";

		/**
		 * <img src='./icons/server_delete_faded.png'/>
		 */
		public static final String SERVER_DELETE_FADED = "server_delete_faded";

		/**
		 * <img src='./icons/folder_user_faded.png'/>
		 */
		public static final String FOLDER_USER_FADED = "folder_user_faded";

		/**
		 * <img src='./icons/page_white_error_faded.png'/>
		 */
		public static final String PAGE_WHITE_ERROR_FADED = "page_white_error_faded";

		/**
		 * <img src='./icons/page_white_stack.png'/>
		 */
		public static final String PAGE_WHITE_STACK = "page_white_stack";

		/**
		 * <img src='./icons/control_start.png'/>
		 */
		public static final String CONTROL_START = "control_start";

		/**
		 * <img src='./icons/folder_magnify.png'/>
		 */
		public static final String FOLDER_MAGNIFY = "folder_magnify";

		/**
		 * <img src='./icons/drive_cd_empty_faded.png'/>
		 */
		public static final String DRIVE_CD_EMPTY_FADED = "drive_cd_empty_faded";

		/**
		 * <img src='./icons/arrow_down_red.png'/>
		 */
		public static final String ARROW_DOWN_RED = "arrow_down_red";

		/**
		 * <img src='./icons/control_repeat_faded.png'/>
		 */
		public static final String CONTROL_REPEAT_FADED = "control_repeat_faded";

		/**
		 * <img src='./icons/tick_faded.png'/>
		 */
		public static final String TICK_FADED = "tick_faded";

		/**
		 * <img src='./icons/pencil_add.png'/>
		 */
		public static final String PENCIL_ADD = "pencil_add";

		/**
		 * <img src='./icons/bullet_purple.png'/>
		 */
		public static final String BULLET_PURPLE = "bullet_purple";

		/**
		 * <img src='./icons/bell_go_faded.png'/>
		 */
		public static final String BELL_GO_FADED = "bell_go_faded";

		/**
		 * <img src='./icons/drink_faded.png'/>
		 */
		public static final String DRINK_FADED = "drink_faded";

		/**
		 * <img src='./icons/control_stop.png'/>
		 */
		public static final String CONTROL_STOP = "control_stop";

		/**
		 * <img src='./icons/sport_shuttlecock_faded.png'/>
		 */
		public static final String SPORT_SHUTTLECOCK_FADED = "sport_shuttlecock_faded";

		/**
		 * <img src='./icons/shape_move_front.png'/>
		 */
		public static final String SHAPE_MOVE_FRONT = "shape_move_front";

		/**
		 * <img src='./icons/brick_delete_faded.png'/>
		 */
		public static final String BRICK_DELETE_FADED = "brick_delete_faded";

		/**
		 * <img src='./icons/package_add_faded.png'/>
		 */
		public static final String PACKAGE_ADD_FADED = "package_add_faded";

		/**
		 * <img src='./icons/controller_error_faded.png'/>
		 */
		public static final String CONTROLLER_ERROR_FADED = "controller_error_faded";

		/**
		 * <img src='./icons/report_edit.png'/>
		 */
		public static final String REPORT_EDIT = "report_edit";

		/**
		 * <img src='./icons/text_indent.png'/>
		 */
		public static final String TEXT_INDENT = "text_indent";

		/**
		 * <img src='./icons/text_linespacing_faded.png'/>
		 */
		public static final String TEXT_LINESPACING_FADED = "text_linespacing_faded";

		/**
		 * <img src='./icons/drive_cd_empty.png'/>
		 */
		public static final String DRIVE_CD_EMPTY = "drive_cd_empty";

		/**
		 * <img src='./icons/table_gear.png'/>
		 */
		public static final String TABLE_GEAR = "table_gear";

		/**
		 * <img src='./icons/chart_line_error_faded.png'/>
		 */
		public static final String CHART_LINE_ERROR_FADED = "chart_line_error_faded";

		/**
		 * <img src='./icons/hourglass_delete_faded.png'/>
		 */
		public static final String HOURGLASS_DELETE_FADED = "hourglass_delete_faded";

		/**
		 * <img src='./icons/control_pause.png'/>
		 */
		public static final String CONTROL_PAUSE = "control_pause";

		/**
		 * <img src='./icons/application_home_faded.png'/>
		 */
		public static final String APPLICATION_HOME_FADED = "application_home_faded";

		/**
		 * <img src='./icons/bullet_white_faded.png'/>
		 */
		public static final String BULLET_WHITE_FADED = "bullet_white_faded";

		/**
		 * <img src='./icons/television_faded.png'/>
		 */
		public static final String TELEVISION_FADED = "television_faded";

		/**
		 * <img src='./icons/application_cascade.png'/>
		 */
		public static final String APPLICATION_CASCADE = "application_cascade";

		/**
		 * <img src='./icons/bomb_faded.png'/>
		 */
		public static final String BOMB_FADED = "bomb_faded";

		/**
		 * <img src='./icons/world_go.png'/>
		 */
		public static final String WORLD_GO = "world_go";

		/**
		 * <img src='./icons/pencil_delete.png'/>
		 */
		public static final String PENCIL_DELETE = "pencil_delete";

		/**
		 * <img src='./icons/chart_line_faded.png'/>
		 */
		public static final String CHART_LINE_FADED = "chart_line_faded";

		/**
		 * <img src='./icons/application_error_faded.png'/>
		 */
		public static final String APPLICATION_ERROR_FADED = "application_error_faded";

		/**
		 * <img src='./icons/report_user.png'/>
		 */
		public static final String REPORT_USER = "report_user";

		/**
		 * <img src='./icons/film_add.png'/>
		 */
		public static final String FILM_ADD = "film_add";

		/**
		 * <img src='./icons/bullet_key_faded.png'/>
		 */
		public static final String BULLET_KEY_FADED = "bullet_key_faded";

		/**
		 * <img src='./icons/plugin_go.png'/>
		 */
		public static final String PLUGIN_GO = "plugin_go";

		/**
		 * <img src='./icons/image_edit.png'/>
		 */
		public static final String IMAGE_EDIT = "image_edit";

		/**
		 * <img src='./icons/text_padding_bottom_faded.png'/>
		 */
		public static final String TEXT_PADDING_BOTTOM_FADED = "text_padding_bottom_faded";

		/**
		 * <img src='./icons/arrow_out_faded.png'/>
		 */
		public static final String ARROW_OUT_FADED = "arrow_out_faded";

		/**
		 * <img src='./icons/chart_bar_edit.png'/>
		 */
		public static final String CHART_BAR_EDIT = "chart_bar_edit";

		/**
		 * <img src='./icons/text_list_numbers_faded.png'/>
		 */
		public static final String TEXT_LIST_NUMBERS_FADED = "text_list_numbers_faded";

		/**
		 * <img src='./icons/bin_closed.png'/>
		 */
		public static final String BIN_CLOSED = "bin_closed";

		/**
		 * <img src='./icons/plugin_error_faded.png'/>
		 */
		public static final String PLUGIN_ERROR_FADED = "plugin_error_faded";

		/**
		 * <img src='./icons/car_add_faded.png'/>
		 */
		public static final String CAR_ADD_FADED = "car_add_faded";

		/**
		 * <img src='./icons/timeline_marker.png'/>
		 */
		public static final String TIMELINE_MARKER = "timeline_marker";

		/**
		 * <img src='./icons/page_word_faded.png'/>
		 */
		public static final String PAGE_WORD_FADED = "page_word_faded";

		/**
		 * <img src='./icons/application.png'/>
		 */
		public static final String APPLICATION = "application";

		/**
		 * <img src='./icons/printer_add_faded.png'/>
		 */
		public static final String PRINTER_ADD_FADED = "printer_add_faded";

		/**
		 * <img src='./icons/layers.png'/>
		 */
		public static final String LAYERS = "layers";

		/**
		 * <img src='./icons/contrast.png'/>
		 */
		public static final String CONTRAST = "contrast";

		/**
		 * <img src='./icons/calendar_view_day.png'/>
		 */
		public static final String CALENDAR_VIEW_DAY = "calendar_view_day";

		/**
		 * <img src='./icons/shape_square.png'/>
		 */
		public static final String SHAPE_SQUARE = "shape_square";

		/**
		 * <img src='./icons/page_white_dvd_faded.png'/>
		 */
		public static final String PAGE_WHITE_DVD_FADED = "page_white_dvd_faded";

		/**
		 * <img src='./icons/page_edit_faded.png'/>
		 */
		public static final String PAGE_EDIT_FADED = "page_edit_faded";

		/**
		 * <img src='./icons/report_edit_faded.png'/>
		 */
		public static final String REPORT_EDIT_FADED = "report_edit_faded";

		/**
		 * <img src='./icons/application_side_tree_faded.png'/>
		 */
		public static final String APPLICATION_SIDE_TREE_FADED = "application_side_tree_faded";

		/**
		 * <img src='./icons/textfield_rename.png'/>
		 */
		public static final String TEXTFIELD_RENAME = "textfield_rename";

		/**
		 * <img src='./icons/money_pound.png'/>
		 */
		public static final String MONEY_POUND = "money_pound";

		/**
		 * <img src='./icons/paintbrush_faded.png'/>
		 */
		public static final String PAINTBRUSH_FADED = "paintbrush_faded";

		/**
		 * <img src='./icons/book.png'/>
		 */
		public static final String BOOK = "book";

		/**
		 * <img src='./icons/newspaper_go_faded.png'/>
		 */
		public static final String NEWSPAPER_GO_FADED = "newspaper_go_faded";

		/**
		 * <img src='./icons/application_form_add.png'/>
		 */
		public static final String APPLICATION_FORM_ADD = "application_form_add";

		/**
		 * <img src='./icons/user_error.png'/>
		 */
		public static final String USER_ERROR = "user_error";

		/**
		 * <img src='./icons/flag_yellow.png'/>
		 */
		public static final String FLAG_YELLOW = "flag_yellow";

		/**
		 * <img src='./icons/tab_edit_faded.png'/>
		 */
		public static final String TAB_EDIT_FADED = "tab_edit_faded";

		/**
		 * <img src='./icons/link_go.png'/>
		 */
		public static final String LINK_GO = "link_go";

		/**
		 * <img src='./icons/drive.png'/>
		 */
		public static final String DRIVE = "drive";

		/**
		 * <img src='./icons/layout_header_faded.png'/>
		 */
		public static final String LAYOUT_HEADER_FADED = "layout_header_faded";

		/**
		 * <img src='./icons/chart_pie_delete_faded.png'/>
		 */
		public static final String CHART_PIE_DELETE_FADED = "chart_pie_delete_faded";

		/**
		 * <img src='./icons/page_lightning.png'/>
		 */
		public static final String PAGE_LIGHTNING = "page_lightning";

		/**
		 * <img src='./icons/database_add_faded.png'/>
		 */
		public static final String DATABASE_ADD_FADED = "database_add_faded";

		/**
		 * <img src='./icons/magnifier_faded.png'/>
		 */
		public static final String MAGNIFIER_FADED = "magnifier_faded";

		/**
		 * <img src='./icons/picture_edit_faded.png'/>
		 */
		public static final String PICTURE_EDIT_FADED = "picture_edit_faded";

		/**
		 * <img src='./icons/layout_content.png'/>
		 */
		public static final String LAYOUT_CONTENT = "layout_content";

		/**
		 * <img src='./icons/application_form_delete.png'/>
		 */
		public static final String APPLICATION_FORM_DELETE = "application_form_delete";

		/**
		 * <img src='./icons/shape_align_middle.png'/>
		 */
		public static final String SHAPE_ALIGN_MIDDLE = "shape_align_middle";

		/**
		 * <img src='./icons/overlays.png'/>
		 */
		public static final String OVERLAYS = "overlays";

		/**
		 * <img src='./icons/sport_soccer_faded.png'/>
		 */
		public static final String SPORT_SOCCER_FADED = "sport_soccer_faded";

		/**
		 * <img src='./icons/page_white_php.png'/>
		 */
		public static final String PAGE_WHITE_PHP = "page_white_php";

		/**
		 * <img src='./icons/bug_go_faded.png'/>
		 */
		public static final String BUG_GO_FADED = "bug_go_faded";

		/**
		 * <img src='./icons/calculator_edit_faded.png'/>
		 */
		public static final String CALCULATOR_EDIT_FADED = "calculator_edit_faded";

		/**
		 * <img src='./icons/vcard_delete.png'/>
		 */
		public static final String VCARD_DELETE = "vcard_delete";

		/**
		 * <img src='./icons/arrow_in_red_faded.png'/>
		 */
		public static final String ARROW_IN_RED_FADED = "arrow_in_red_faded";

		/**
		 * <img src='./icons/flag_yellow_faded.png'/>
		 */
		public static final String FLAG_YELLOW_FADED = "flag_yellow_faded";

		/**
		 * <img src='./icons/information_faded.png'/>
		 */
		public static final String INFORMATION_FADED = "information_faded";

		/**
		 * <img src='./icons/drive_magnify.png'/>
		 */
		public static final String DRIVE_MAGNIFY = "drive_magnify";

		/**
		 * <img src='./icons/script_save.png'/>
		 */
		public static final String SCRIPT_SAVE = "script_save";

		/**
		 * <img src='./icons/transmit_blue_faded.png'/>
		 */
		public static final String TRANSMIT_BLUE_FADED = "transmit_blue_faded";

		/**
		 * <img src='./icons/page_white_actionscript.png'/>
		 */
		public static final String PAGE_WHITE_ACTIONSCRIPT = "page_white_actionscript";

		/**
		 * <img src='./icons/date_edit.png'/>
		 */
		public static final String DATE_EDIT = "date_edit";

		/**
		 * <img src='./icons/user_gray.png'/>
		 */
		public static final String USER_GRAY = "user_gray";

		/**
		 * <img src='./icons/cd_delete_faded.png'/>
		 */
		public static final String CD_DELETE_FADED = "cd_delete_faded";

		/**
		 * <img src='./icons/rss_go_faded.png'/>
		 */
		public static final String RSS_GO_FADED = "rss_go_faded";

		/**
		 * <img src='./icons/sound_none.png'/>
		 */
		public static final String SOUND_NONE = "sound_none";

		/**
		 * <img src='./icons/chart_bar_link_faded.png'/>
		 */
		public static final String CHART_BAR_LINK_FADED = "chart_bar_link_faded";

		/**
		 * <img src='./icons/lock_break.png'/>
		 */
		public static final String LOCK_BREAK = "lock_break";

		/**
		 * <img src='./icons/text_allcaps.png'/>
		 */
		public static final String TEXT_ALLCAPS = "text_allcaps";

		/**
		 * <img src='./icons/link_error_faded.png'/>
		 */
		public static final String LINK_ERROR_FADED = "link_error_faded";

		/**
		 * <img src='./icons/tag_blue_delete.png'/>
		 */
		public static final String TAG_BLUE_DELETE = "tag_blue_delete";

		/**
		 * <img src='./icons/page_white_add_faded.png'/>
		 */
		public static final String PAGE_WHITE_ADD_FADED = "page_white_add_faded";

		/**
		 * <img src='./icons/building_go.png'/>
		 */
		public static final String BUILDING_GO = "building_go";

		/**
		 * <img src='./icons/user_add_faded.png'/>
		 */
		public static final String USER_ADD_FADED = "user_add_faded";

		/**
		 * <img src='./icons/user_female_contrast.png'/>
		 */
		public static final String USER_FEMALE_CONTRAST = "user_female_contrast";

		/**
		 * <img src='./icons/accept.png'/>
		 */
		public static final String ACCEPT = "accept";

		/**
		 * <img src='./icons/rss.png'/>
		 */
		public static final String RSS = "rss";

		/**
		 * <img src='./icons/phone_faded.png'/>
		 */
		public static final String PHONE_FADED = "phone_faded";

		/**
		 * <img src='./icons/map_add.png'/>
		 */
		public static final String MAP_ADD = "map_add";

		/**
		 * <img src='./icons/user_minus.png'/>
		 */
		public static final String USER_MINUS = "user_minus";

		/**
		 * <img src='./icons/arrow_switch.png'/>
		 */
		public static final String ARROW_SWITCH = "arrow_switch";

		/**
		 * <img src='./icons/folder_camera.png'/>
		 */
		public static final String FOLDER_CAMERA = "folder_camera";

		/**
		 * <img src='./icons/cancel_faded.png'/>
		 */
		public static final String CANCEL_FADED = "cancel_faded";

		/**
		 * <img src='./icons/status_busy.png'/>
		 */
		public static final String STATUS_BUSY = "status_busy";

		/**
		 * <img src='./icons/page_white_zip.png'/>
		 */
		public static final String PAGE_WHITE_ZIP = "page_white_zip";

		/**
		 * <img src='./icons/sound_add.png'/>
		 */
		public static final String SOUND_ADD = "sound_add";

		/**
		 * <img src='./icons/cart_delete.png'/>
		 */
		public static final String CART_DELETE = "cart_delete";

		/**
		 * <img src='./icons/money.png'/>
		 */
		public static final String MONEY = "money";

		/**
		 * <img src='./icons/anchor_faded.png'/>
		 */
		public static final String ANCHOR_FADED = "anchor_faded";

		/**
		 * <img src='./icons/user_gray_start.png'/>
		 */
		public static final String USER_GRAY_START = "user_gray_start";

		/**
		 * <img src='./icons/server_lightning_faded.png'/>
		 */
		public static final String SERVER_LIGHTNING_FADED = "server_lightning_faded";

		/**
		 * <img src='./icons/package_green_faded.png'/>
		 */
		public static final String PACKAGE_GREEN_FADED = "package_green_faded";

		/**
		 * <img src='./icons/group_delete_faded.png'/>
		 */
		public static final String GROUP_DELETE_FADED = "group_delete_faded";

		/**
		 * <img src='./icons/clock.png'/>
		 */
		public static final String CLOCK = "clock";

		/**
		 * <img src='./icons/html.png'/>
		 */
		public static final String HTML = "html";

		/**
		 * <img src='./icons/drive_edit_faded.png'/>
		 */
		public static final String DRIVE_EDIT_FADED = "drive_edit_faded";

		/**
		 * <img src='./icons/sound_delete.png'/>
		 */
		public static final String SOUND_DELETE = "sound_delete";

		/**
		 * <img src='./icons/page_white_zip_faded.png'/>
		 */
		public static final String PAGE_WHITE_ZIP_FADED = "page_white_zip_faded";

		/**
		 * <img src='./icons/user_gray_cool.png'/>
		 */
		public static final String USER_GRAY_COOL = "user_gray_cool";

		/**
		 * <img src='./icons/database_save_faded.png'/>
		 */
		public static final String DATABASE_SAVE_FADED = "database_save_faded";

		/**
		 * <img src='./icons/style_faded.png'/>
		 */
		public static final String STYLE_FADED = "style_faded";

		/**
		 * <img src='./icons/feed_link_faded.png'/>
		 */
		public static final String FEED_LINK_FADED = "feed_link_faded";

		/**
		 * <img src='./icons/cart_add_faded.png'/>
		 */
		public static final String CART_ADD_FADED = "cart_add_faded";

		/**
		 * <img src='./icons/xhtml_delete_faded.png'/>
		 */
		public static final String XHTML_DELETE_FADED = "xhtml_delete_faded";

		/**
		 * <img src='./icons/control_end_faded.png'/>
		 */
		public static final String CONTROL_END_FADED = "control_end_faded";

		/**
		 * <img src='./icons/key_faded.png'/>
		 */
		public static final String KEY_FADED = "key_faded";

		/**
		 * <img src='./icons/bullet_black_faded.png'/>
		 */
		public static final String BULLET_BLACK_FADED = "bullet_black_faded";

		/**
		 * <img src='./icons/bullet_arrow_top.png'/>
		 */
		public static final String BULLET_ARROW_TOP = "bullet_arrow_top";

		/**
		 * <img src='./icons/page_white_stack_faded.png'/>
		 */
		public static final String PAGE_WHITE_STACK_FADED = "page_white_stack_faded";

		/**
		 * <img src='./icons/application_add.png'/>
		 */
		public static final String APPLICATION_ADD = "application_add";

		/**
		 * <img src='./icons/resultset_first_faded.png'/>
		 */
		public static final String RESULTSET_FIRST_FADED = "resultset_first_faded";

		/**
		 * <img src='./icons/female_time_faded.png'/>
		 */
		public static final String FEMALE_TIME_FADED = "female_time_faded";

		/**
		 * <img src='./icons/basket_remove_faded.png'/>
		 */
		public static final String BASKET_REMOVE_FADED = "basket_remove_faded";

		/**
		 * <img src='./icons/disk_multiple.png'/>
		 */
		public static final String DISK_MULTIPLE = "disk_multiple";

		/**
		 * <img src='./icons/folder_error_faded.png'/>
		 */
		public static final String FOLDER_ERROR_FADED = "folder_error_faded";

		/**
		 * <img src='./icons/calculator_link_faded.png'/>
		 */
		public static final String CALCULATOR_LINK_FADED = "calculator_link_faded";

		/**
		 * <img src='./icons/shape_align_center.png'/>
		 */
		public static final String SHAPE_ALIGN_CENTER = "shape_align_center";

		/**
		 * <img src='./icons/comments_faded.png'/>
		 */
		public static final String COMMENTS_FADED = "comments_faded";

		/**
		 * <img src='./icons/calendar_add.png'/>
		 */
		public static final String CALENDAR_ADD = "calendar_add";

		/**
		 * <img src='./icons/application_cascade_go_faded.png'/>
		 */
		public static final String APPLICATION_CASCADE_GO_FADED = "application_cascade_go_faded";

		/**
		 * <img src='./icons/cut.png'/>
		 */
		public static final String CUT = "cut";

		/**
		 * <img src='./icons/sound_mute.png'/>
		 */
		public static final String SOUND_MUTE = "sound_mute";

		/**
		 * <img src='./icons/page_green_faded.png'/>
		 */
		public static final String PAGE_GREEN_FADED = "page_green_faded";

		/**
		 * <img src='./icons/text_padding_top.png'/>
		 */
		public static final String TEXT_PADDING_TOP = "text_padding_top";

		/**
		 * <img src='./icons/browser_msnexplorer_faded.png'/>
		 */
		public static final String BROWSER_MSNEXPLORER_FADED = "browser_msnexplorer_faded";

		/**
		 * <img src='./icons/brick_delete.png'/>
		 */
		public static final String BRICK_DELETE = "brick_delete";

		/**
		 * <img src='./icons/status_online_faded.png'/>
		 */
		public static final String STATUS_ONLINE_FADED = "status_online_faded";

		/**
		 * <img src='./icons/help.png'/>
		 */
		public static final String HELP = "help";

		/**
		 * <img src='./icons/picture_empty_faded.png'/>
		 */
		public static final String PICTURE_EMPTY_FADED = "picture_empty_faded";

		/**
		 * <img src='./icons/database_table_faded.png'/>
		 */
		public static final String DATABASE_TABLE_FADED = "database_table_faded";

		/**
		 * <img src='./icons/group_delete.png'/>
		 */
		public static final String GROUP_DELETE = "group_delete";

		/**
		 * <img src='./icons/sql_add_faded.png'/>
		 */
		public static final String SQL_ADD_FADED = "sql_add_faded";

		/**
		 * <img src='./icons/layout_delete_faded.png'/>
		 */
		public static final String LAYOUT_DELETE_FADED = "layout_delete_faded";

		/**
		 * <img src='./icons/ipod_faded.png'/>
		 */
		public static final String IPOD_FADED = "ipod_faded";

		/**
		 * <img src='./icons/drive_add_faded.png'/>
		 */
		public static final String DRIVE_ADD_FADED = "drive_add_faded";

		/**
		 * <img src='./icons/monitor.png'/>
		 */
		public static final String MONITOR = "monitor";

		/**
		 * <img src='./icons/page_white_horizontal.png'/>
		 */
		public static final String PAGE_WHITE_HORIZONTAL = "page_white_horizontal";

		/**
		 * <img src='./icons/award_star_bronze_3_faded.png'/>
		 */
		public static final String AWARD_STAR_BRONZE_3_FADED = "award_star_bronze_3_faded";

		/**
		 * <img src='./icons/tag_pink.png'/>
		 */
		public static final String TAG_PINK = "tag_pink";

		/**
		 * <img src='./icons/sound_mute_faded.png'/>
		 */
		public static final String SOUND_MUTE_FADED = "sound_mute_faded";

		/**
		 * <img src='./icons/shape_move_back.png'/>
		 */
		public static final String SHAPE_MOVE_BACK = "shape_move_back";

		/**
		 * <img src='./icons/lightbulb_delete.png'/>
		 */
		public static final String LIGHTBULB_DELETE = "lightbulb_delete";

		/**
		 * <img src='./icons/money_dollar.png'/>
		 */
		public static final String MONEY_DOLLAR = "money_dollar";

		/**
		 * <img src='./icons/database_key.png'/>
		 */
		public static final String DATABASE_KEY = "database_key";

		/**
		 * <img src='./icons/color_wheel.png'/>
		 */
		public static final String COLOR_WHEEL = "color_wheel";

		/**
		 * <img src='./icons/arrow_refresh_red.png'/>
		 */
		public static final String ARROW_REFRESH_RED = "arrow_refresh_red";

		/**
		 * <img src='./icons/emoticon_happy.png'/>
		 */
		public static final String EMOTICON_HAPPY = "emoticon_happy";

		/**
		 * <img src='./icons/world_add.png'/>
		 */
		public static final String WORLD_ADD = "world_add";

		/**
		 * <img src='./icons/application_double_faded.png'/>
		 */
		public static final String APPLICATION_DOUBLE_FADED = "application_double_faded";

		/**
		 * <img src='./icons/chart_curve_error.png'/>
		 */
		public static final String CHART_CURVE_ERROR = "chart_curve_error";

		/**
		 * <img src='./icons/comment_add.png'/>
		 */
		public static final String COMMENT_ADD = "comment_add";

		/**
		 * <img src='./icons/layout_error_faded.png'/>
		 */
		public static final String LAYOUT_ERROR_FADED = "layout_error_faded";

		/**
		 * <img src='./icons/page_excel.png'/>
		 */
		public static final String PAGE_EXCEL = "page_excel";

		/**
		 * <img src='./icons/plugin_edit_faded.png'/>
		 */
		public static final String PLUGIN_EDIT_FADED = "plugin_edit_faded";

		/**
		 * <img src='./icons/shield_add.png'/>
		 */
		public static final String SHIELD_ADD = "shield_add";

		/**
		 * <img src='./icons/date_lorry.png'/>
		 */
		public static final String DATE_LORRY = "date_lorry";

		/**
		 * <img src='./icons/sport_baseball.png'/>
		 */
		public static final String SPORT_BASEBALL = "sport_baseball";

		/**
		 * <img src='./icons/pill_delete_faded.png'/>
		 */
		public static final String PILL_DELETE_FADED = "pill_delete_faded";

		/**
		 * <img src='./icons/control_play_blue.png'/>
		 */
		public static final String CONTROL_PLAY_BLUE = "control_play_blue";

		/**
		 * <img src='./icons/report.png'/>
		 */
		public static final String REPORT = "report";

		/**
		 * <img src='./icons/folder_page_white.png'/>
		 */
		public static final String FOLDER_PAGE_WHITE = "folder_page_white";

		/**
		 * <img src='./icons/bug_delete_faded.png'/>
		 */
		public static final String BUG_DELETE_FADED = "bug_delete_faded";

		/**
		 * <img src='./icons/building_delete_faded.png'/>
		 */
		public static final String BUILDING_DELETE_FADED = "building_delete_faded";

		/**
		 * <img src='./icons/user_gray_delete.png'/>
		 */
		public static final String USER_GRAY_DELETE = "user_gray_delete";

		/**
		 * <img src='./icons/bricks.png'/>
		 */
		public static final String BRICKS = "bricks";

		/**
		 * <img src='./icons/cog.png'/>
		 */
		public static final String COG = "cog";

		/**
		 * <img src='./icons/palette_faded.png'/>
		 */
		public static final String PALETTE_FADED = "palette_faded";

		/**
		 * <img src='./icons/color_swatch.png'/>
		 */
		public static final String COLOR_SWATCH = "color_swatch";

		/**
		 * <img src='./icons/film_delete.png'/>
		 */
		public static final String FILM_DELETE = "film_delete";

		/**
		 * <img src='./icons/table_key.png'/>
		 */
		public static final String TABLE_KEY = "table_key";

		/**
		 * <img src='./icons/cart_error.png'/>
		 */
		public static final String CART_ERROR = "cart_error";

		/**
		 * <img src='./icons/sitemap_faded.png'/>
		 */
		public static final String SITEMAP_FADED = "sitemap_faded";

		/**
		 * <img src='./icons/application_view_detail_faded.png'/>
		 */
		public static final String APPLICATION_VIEW_DETAIL_FADED = "application_view_detail_faded";

		/**
		 * <img src='./icons/email.png'/>
		 */
		public static final String EMAIL = "email";

		/**
		 * <img src='./icons/male.png'/>
		 */
		public static final String MALE = "male";

		/**
		 * <img src='./icons/chart_curve_go_faded.png'/>
		 */
		public static final String CHART_CURVE_GO_FADED = "chart_curve_go_faded";

		/**
		 * <img src='./icons/arrow_undo.png'/>
		 */
		public static final String ARROW_UNDO = "arrow_undo";

		/**
		 * <img src='./icons/chart_pie_delete.png'/>
		 */
		public static final String CHART_PIE_DELETE = "chart_pie_delete";

		/**
		 * <img src='./icons/medal_bronze_3.png'/>
		 */
		public static final String MEDAL_BRONZE_3 = "medal_bronze_3";

		/**
		 * <img src='./icons/bell_add.png'/>
		 */
		public static final String BELL_ADD = "bell_add";

		/**
		 * <img src='./icons/database_lightning.png'/>
		 */
		public static final String DATABASE_LIGHTNING = "database_lightning";

		/**
		 * <img src='./icons/lorry_flatbed.png'/>
		 */
		public static final String LORRY_FLATBED = "lorry_flatbed";

		/**
		 * <img src='./icons/medal_gold_add_faded.png'/>
		 */
		public static final String MEDAL_GOLD_ADD_FADED = "medal_gold_add_faded";

		/**
		 * <img src='./icons/building_add.png'/>
		 */
		public static final String BUILDING_ADD = "building_add";

		/**
		 * <img src='./icons/table_save.png'/>
		 */
		public static final String TABLE_SAVE = "table_save";

		/**
		 * <img src='./icons/script_code_red_faded.png'/>
		 */
		public static final String SCRIPT_CODE_RED_FADED = "script_code_red_faded";

		/**
		 * <img src='./icons/page_white_paint.png'/>
		 */
		public static final String PAGE_WHITE_PAINT = "page_white_paint";

		/**
		 * <img src='./icons/calculator_faded.png'/>
		 */
		public static final String CALCULATOR_FADED = "calculator_faded";

		/**
		 * <img src='./icons/tag_yellow_faded.png'/>
		 */
		public static final String TAG_YELLOW_FADED = "tag_yellow_faded";

		/**
		 * <img src='./icons/feed_go.png'/>
		 */
		public static final String FEED_GO = "feed_go";

		/**
		 * <img src='./icons/chart_curve.png'/>
		 */
		public static final String CHART_CURVE = "chart_curve";

		/**
		 * <img src='./icons/date_previous_faded.png'/>
		 */
		public static final String DATE_PREVIOUS_FADED = "date_previous_faded";

		/**
		 * <img src='./icons/folder_faded.png'/>
		 */
		public static final String FOLDER_FADED = "folder_faded";

		/**
		 * <img src='./icons/drive_rename_faded.png'/>
		 */
		public static final String DRIVE_RENAME_FADED = "drive_rename_faded";

		/**
		 * <img src='./icons/world_link.png'/>
		 */
		public static final String WORLD_LINK = "world_link";

		/**
		 * <img src='./icons/text_bold.png'/>
		 */
		public static final String TEXT_BOLD = "text_bold";

		/**
		 * <img src='./icons/page_white_cup.png'/>
		 */
		public static final String PAGE_WHITE_CUP = "page_white_cup";

		/**
		 * <img src='./icons/shading.png'/>
		 */
		public static final String SHADING = "shading";

		/**
		 * <img src='./icons/text_uppercase_faded.png'/>
		 */
		public static final String TEXT_UPPERCASE_FADED = "text_uppercase_faded";

		/**
		 * <img src='./icons/medal_gold_1.png'/>
		 */
		public static final String MEDAL_GOLD_1 = "medal_gold_1";

		/**
		 * <img src='./icons/group_go.png'/>
		 */
		public static final String GROUP_GO = "group_go";

		/**
		 * <img src='./icons/page_white_world_faded.png'/>
		 */
		public static final String PAGE_WHITE_WORLD_FADED = "page_white_world_faded";

		/**
		 * <img src='./icons/drive_error_faded.png'/>
		 */
		public static final String DRIVE_ERROR_FADED = "drive_error_faded";

		/**
		 * <img src='./icons/calculator_link.png'/>
		 */
		public static final String CALCULATOR_LINK = "calculator_link";

		/**
		 * <img src='./icons/bullet_pink.png'/>
		 */
		public static final String BULLET_PINK = "bullet_pink";

		/**
		 * <img src='./icons/cog_error.png'/>
		 */
		public static final String COG_ERROR = "cog_error";

		/**
		 * <img src='./icons/flag_blue_faded.png'/>
		 */
		public static final String FLAG_BLUE_FADED = "flag_blue_faded";

		/**
		 * <img src='./icons/page_white_word.png'/>
		 */
		public static final String PAGE_WHITE_WORD = "page_white_word";

		/**
		 * <img src='./icons/bullet_error.png'/>
		 */
		public static final String BULLET_ERROR = "bullet_error";

		/**
		 * <img src='./icons/dvd_delete.png'/>
		 */
		public static final String DVD_DELETE = "dvd_delete";

		/**
		 * <img src='./icons/vector_delete.png'/>
		 */
		public static final String VECTOR_DELETE = "vector_delete";

		/**
		 * <img src='./icons/error.png'/>
		 */
		public static final String ERROR = "error";

		/**
		 * <img src='./icons/film.png'/>
		 */
		public static final String FILM = "film";

		/**
		 * <img src='./icons/television.png'/>
		 */
		public static final String TELEVISION = "television";

		/**
		 * <img src='./icons/text_linespacing.png'/>
		 */
		public static final String TEXT_LINESPACING = "text_linespacing";

		/**
		 * <img src='./icons/spellcheck_faded.png'/>
		 */
		public static final String SPELLCHECK_FADED = "spellcheck_faded";

		/**
		 * <img src='./icons/server_chart.png'/>
		 */
		public static final String SERVER_CHART = "server_chart";

		/**
		 * <img src='./icons/pencil_go.png'/>
		 */
		public static final String PENCIL_GO = "pencil_go";

		/**
		 * <img src='./icons/font_go_faded.png'/>
		 */
		public static final String FONT_GO_FADED = "font_go_faded";

		/**
		 * <img src='./icons/application_view_gallery.png'/>
		 */
		public static final String APPLICATION_VIEW_GALLERY = "application_view_gallery";

		/**
		 * <img src='./icons/chart_pie_edit.png'/>
		 */
		public static final String CHART_PIE_EDIT = "chart_pie_edit";

		/**
		 * <img src='./icons/error_add_faded.png'/>
		 */
		public static final String ERROR_ADD_FADED = "error_add_faded";

		/**
		 * <img src='./icons/telephone_key_faded.png'/>
		 */
		public static final String TELEPHONE_KEY_FADED = "telephone_key_faded";

		/**
		 * <img src='./icons/telephone.png'/>
		 */
		public static final String TELEPHONE = "telephone";

		/**
		 * <img src='./icons/picture_go_faded.png'/>
		 */
		public static final String PICTURE_GO_FADED = "picture_go_faded";

		/**
		 * <img src='./icons/page_white_wrench_faded.png'/>
		 */
		public static final String PAGE_WHITE_WRENCH_FADED = "page_white_wrench_faded";

		/**
		 * <img src='./icons/application_cascade_add_faded.png'/>
		 */
		public static final String APPLICATION_CASCADE_ADD_FADED = "application_cascade_add_faded";

		/**
		 * <img src='./icons/bullet_arrow_up_faded.png'/>
		 */
		public static final String BULLET_ARROW_UP_FADED = "bullet_arrow_up_faded";

		/**
		 * <img src='./icons/zoom_in_faded.png'/>
		 */
		public static final String ZOOM_IN_FADED = "zoom_in_faded";

		/**
		 * <img src='./icons/tag_orange_faded.png'/>
		 */
		public static final String TAG_ORANGE_FADED = "tag_orange_faded";

		/**
		 * <img src='./icons/browser_aol.png'/>
		 */
		public static final String BROWSER_AOL = "browser_aol";

		/**
		 * <img src='./icons/plugin_add.png'/>
		 */
		public static final String PLUGIN_ADD = "plugin_add";

		/**
		 * <img src='./icons/style_go_faded.png'/>
		 */
		public static final String STYLE_GO_FADED = "style_go_faded";

		/**
		 * <img src='./icons/text_indent_remove_faded.png'/>
		 */
		public static final String TEXT_INDENT_REMOVE_FADED = "text_indent_remove_faded";

		/**
		 * <img src='./icons/phone_add.png'/>
		 */
		public static final String PHONE_ADD = "phone_add";

		/**
		 * <img src='./icons/arrow_refresh_red_faded.png'/>
		 */
		public static final String ARROW_REFRESH_RED_FADED = "arrow_refresh_red_faded";

		/**
		 * <img src='./icons/feed_edit.png'/>
		 */
		public static final String FEED_EDIT = "feed_edit";

		/**
		 * <img src='./icons/picture_delete.png'/>
		 */
		public static final String PICTURE_DELETE = "picture_delete";

		/**
		 * <img src='./icons/drive_link.png'/>
		 */
		public static final String DRIVE_LINK = "drive_link";

		/**
		 * <img src='./icons/link_delete_faded.png'/>
		 */
		public static final String LINK_DELETE_FADED = "link_delete_faded";

		/**
		 * <img src='./icons/shape_flip_vertical.png'/>
		 */
		public static final String SHAPE_FLIP_VERTICAL = "shape_flip_vertical";

		/**
		 * <img src='./icons/picture_key_faded.png'/>
		 */
		public static final String PICTURE_KEY_FADED = "picture_key_faded";

		/**
		 * <img src='./icons/browser_firefox_faded.png'/>
		 */
		public static final String BROWSER_FIREFOX_FADED = "browser_firefox_faded";

		/**
		 * <img src='./icons/drive_go_faded.png'/>
		 */
		public static final String DRIVE_GO_FADED = "drive_go_faded";

		/**
		 * <img src='./icons/page_white_star.png'/>
		 */
		public static final String PAGE_WHITE_STAR = "page_white_star";

		/**
		 * <img src='./icons/application_key_faded.png'/>
		 */
		public static final String APPLICATION_KEY_FADED = "application_key_faded";

		/**
		 * <img src='./icons/computer_delete.png'/>
		 */
		public static final String COMPUTER_DELETE = "computer_delete";

		/**
		 * <img src='./icons/application_view_icons.png'/>
		 */
		public static final String APPLICATION_VIEW_ICONS = "application_view_icons";

		/**
		 * <img src='./icons/application_lightning_faded.png'/>
		 */
		public static final String APPLICATION_LIGHTNING_FADED = "application_lightning_faded";

		/**
		 * <img src='./icons/package_link_faded.png'/>
		 */
		public static final String PACKAGE_LINK_FADED = "package_link_faded";

		/**
		 * <img src='./icons/weather_rain.png'/>
		 */
		public static final String WEATHER_RAIN = "weather_rain";

		/**
		 * <img src='./icons/feed_key.png'/>
		 */
		public static final String FEED_KEY = "feed_key";

		/**
		 * <img src='./icons/mouse_error_faded.png'/>
		 */
		public static final String MOUSE_ERROR_FADED = "mouse_error_faded";

		/**
		 * <img src='./icons/telephone_delete_faded.png'/>
		 */
		public static final String TELEPHONE_DELETE_FADED = "telephone_delete_faded";

		/**
		 * <img src='./icons/note_go.png'/>
		 */
		public static final String NOTE_GO = "note_go";

		/**
		 * <img src='./icons/drive_network_faded.png'/>
		 */
		public static final String DRIVE_NETWORK_FADED = "drive_network_faded";

		/**
		 * <img src='./icons/monitor_edit.png'/>
		 */
		public static final String MONITOR_EDIT = "monitor_edit";

		/**
		 * <img src='./icons/text_heading_1.png'/>
		 */
		public static final String TEXT_HEADING_1 = "text_heading_1";

		/**
		 * <img src='./icons/award_star_delete_faded.png'/>
		 */
		public static final String AWARD_STAR_DELETE_FADED = "award_star_delete_faded";

		/**
		 * <img src='./icons/computer_key_faded.png'/>
		 */
		public static final String COMPUTER_KEY_FADED = "computer_key_faded";

		/**
		 * <img src='./icons/wand.png'/>
		 */
		public static final String WAND = "wand";

		/**
		 * <img src='./icons/bullet_blue.png'/>
		 */
		public static final String BULLET_BLUE = "bullet_blue";

		/**
		 * <img src='./icons/flag_red_faded.png'/>
		 */
		public static final String FLAG_RED_FADED = "flag_red_faded";

		/**
		 * <img src='./icons/ipod_sound.png'/>
		 */
		public static final String IPOD_SOUND = "ipod_sound";

		/**
		 * <img src='./icons/ruby_gear_faded.png'/>
		 */
		public static final String RUBY_GEAR_FADED = "ruby_gear_faded";

		/**
		 * <img src='./icons/arrow_turn_right.png'/>
		 */
		public static final String ARROW_TURN_RIGHT = "arrow_turn_right";

		/**
		 * <img src='./icons/script_code_red.png'/>
		 */
		public static final String SCRIPT_CODE_RED = "script_code_red";

		/**
		 * <img src='./icons/table_key_faded.png'/>
		 */
		public static final String TABLE_KEY_FADED = "table_key_faded";

		/**
		 * <img src='./icons/control_start_blue.png'/>
		 */
		public static final String CONTROL_START_BLUE = "control_start_blue";

		/**
		 * <img src='./icons/bullet_star.png'/>
		 */
		public static final String BULLET_STAR = "bullet_star";

		/**
		 * <img src='./icons/script_lightning.png'/>
		 */
		public static final String SCRIPT_LIGHTNING = "script_lightning";

		/**
		 * <img src='./icons/arrow_refresh.png'/>
		 */
		public static final String ARROW_REFRESH = "arrow_refresh";

		/**
		 * <img src='./icons/lorry_weather_cloudy.png'/>
		 */
		public static final String LORRY_WEATHER_CLOUDY = "lorry_weather_cloudy";

		/**
		 * <img src='./icons/user_stop_alt.png'/>
		 */
		public static final String USER_STOP_ALT = "user_stop_alt";

		/**
		 * <img src='./icons/building_key.png'/>
		 */
		public static final String BUILDING_KEY = "building_key";

		/**
		 * <img src='./icons/clock_link.png'/>
		 */
		public static final String CLOCK_LINK = "clock_link";

		/**
		 * <img src='./icons/shape_ungroup.png'/>
		 */
		public static final String SHAPE_UNGROUP = "shape_ungroup";

		/**
		 * <img src='./icons/page_white_tux.png'/>
		 */
		public static final String PAGE_WHITE_TUX = "page_white_tux";

		/**
		 * <img src='./icons/shape_group_faded.png'/>
		 */
		public static final String SHAPE_GROUP_FADED = "shape_group_faded";

		/**
		 * <img src='./icons/information.png'/>
		 */
		public static final String INFORMATION = "information";

		/**
		 * <img src='./icons/money_faded.png'/>
		 */
		public static final String MONEY_FADED = "money_faded";

		/**
		 * <img src='./icons/picture_delete_faded.png'/>
		 */
		public static final String PICTURE_DELETE_FADED = "picture_delete_faded";

		/**
		 * <img src='./icons/control_repeat.png'/>
		 */
		public static final String CONTROL_REPEAT = "control_repeat";

		/**
		 * <img src='./icons/bell_faded.png'/>
		 */
		public static final String BELL_FADED = "bell_faded";

		/**
		 * <img src='./icons/drink.png'/>
		 */
		public static final String DRINK = "drink";

		/**
		 * <img src='./icons/text_strikethrough_faded.png'/>
		 */
		public static final String TEXT_STRIKETHROUGH_FADED = "text_strikethrough_faded";

		/**
		 * <img src='./icons/transmit_error_faded.png'/>
		 */
		public static final String TRANSMIT_ERROR_FADED = "transmit_error_faded";

		/**
		 * <img src='./icons/new.png'/>
		 */
		public static final String NEW = "new";

		/**
		 * <img src='./icons/arrow_divide_down.png'/>
		 */
		public static final String ARROW_DIVIDE_DOWN = "arrow_divide_down";

		/**
		 * <img src='./icons/arrow_divide_down_red_faded.png'/>
		 */
		public static final String ARROW_DIVIDE_DOWN_RED_FADED = "arrow_divide_down_red_faded";

		/**
		 * <img src='./icons/database_key_faded.png'/>
		 */
		public static final String DATABASE_KEY_FADED = "database_key_faded";

		/**
		 * <img src='./icons/controller_delete_faded.png'/>
		 */
		public static final String CONTROLLER_DELETE_FADED = "controller_delete_faded";

		/**
		 * <img src='./icons/date_previous.png'/>
		 */
		public static final String DATE_PREVIOUS = "date_previous";

		/**
		 * <img src='./icons/sport_golf.png'/>
		 */
		public static final String SPORT_GOLF = "sport_golf";

		/**
		 * <img src='./icons/database_refresh.png'/>
		 */
		public static final String DATABASE_REFRESH = "database_refresh";

		/**
		 * <img src='./icons/table_error_faded.png'/>
		 */
		public static final String TABLE_ERROR_FADED = "table_error_faded";

		/**
		 * <img src='./icons/mouse_delete_faded.png'/>
		 */
		public static final String MOUSE_DELETE_FADED = "mouse_delete_faded";

		/**
		 * <img src='./icons/resultset_previous_faded.png'/>
		 */
		public static final String RESULTSET_PREVIOUS_FADED = "resultset_previous_faded";

		/**
		 * <img src='./icons/date_delete_faded.png'/>
		 */
		public static final String DATE_DELETE_FADED = "date_delete_faded";

		/**
		 * <img src='./icons/newspaper_delete.png'/>
		 */
		public static final String NEWSPAPER_DELETE = "newspaper_delete";

		/**
		 * <img src='./icons/calculator_delete_faded.png'/>
		 */
		public static final String CALCULATOR_DELETE_FADED = "calculator_delete_faded";

		/**
		 * <img src='./icons/email_error.png'/>
		 */
		public static final String EMAIL_ERROR = "email_error";

		/**
		 * <img src='./icons/book_previous.png'/>
		 */
		public static final String BOOK_PREVIOUS = "book_previous";

		/**
		 * <img src='./icons/image_delete_faded.png'/>
		 */
		public static final String IMAGE_DELETE_FADED = "image_delete_faded";

		/**
		 * <img src='./icons/asterisk_orange_faded.png'/>
		 */
		public static final String ASTERISK_ORANGE_FADED = "asterisk_orange_faded";

		/**
		 * <img src='./icons/textfield.png'/>
		 */
		public static final String TEXTFIELD = "textfield";

		/**
		 * <img src='./icons/report_disk.png'/>
		 */
		public static final String REPORT_DISK = "report_disk";

		/**
		 * <img src='./icons/text_horizontalrule_faded.png'/>
		 */
		public static final String TEXT_HORIZONTALRULE_FADED = "text_horizontalrule_faded";

		/**
		 * <img src='./icons/text_heading_6.png'/>
		 */
		public static final String TEXT_HEADING_6 = "text_heading_6";

		/**
		 * <img src='./icons/coins_add_faded.png'/>
		 */
		public static final String COINS_ADD_FADED = "coins_add_faded";

		/**
		 * <img src='./icons/basket_edit_faded.png'/>
		 */
		public static final String BASKET_EDIT_FADED = "basket_edit_faded";

		/**
		 * <img src='./icons/page_world.png'/>
		 */
		public static final String PAGE_WORLD = "page_world";

		/**
		 * <img src='./icons/page_white_key_faded.png'/>
		 */
		public static final String PAGE_WHITE_KEY_FADED = "page_white_key_faded";

		/**
		 * <img src='./icons/cart.png'/>
		 */
		public static final String CART = "cart";

		/**
		 * <img src='./icons/text_superscript.png'/>
		 */
		public static final String TEXT_SUPERSCRIPT = "text_superscript";

		/**
		 * <img src='./icons/flag_pink_faded.png'/>
		 */
		public static final String FLAG_PINK_FADED = "flag_pink_faded";

		/**
		 * <img src='./icons/photo_link_faded.png'/>
		 */
		public static final String PHOTO_LINK_FADED = "photo_link_faded";

		/**
		 * <img src='./icons/cake.png'/>
		 */
		public static final String CAKE = "cake";

		/**
		 * <img src='./icons/coins_delete.png'/>
		 */
		public static final String COINS_DELETE = "coins_delete";

		/**
		 * <img src='./icons/feed_edit_faded.png'/>
		 */
		public static final String FEED_EDIT_FADED = "feed_edit_faded";

		/**
		 * <img src='./icons/table_row.png'/>
		 */
		public static final String TABLE_ROW = "table_row";

		/**
		 * <img src='./icons/chart_bar_link.png'/>
		 */
		public static final String CHART_BAR_LINK = "chart_bar_link";

		/**
		 * <img src='./icons/script_go_faded.png'/>
		 */
		public static final String SCRIPT_GO_FADED = "script_go_faded";

		/**
		 * <img src='./icons/picture_empty.png'/>
		 */
		public static final String PICTURE_EMPTY = "picture_empty";

		/**
		 * <img src='./icons/camera_delete_faded.png'/>
		 */
		public static final String CAMERA_DELETE_FADED = "camera_delete_faded";

		/**
		 * <img src='./icons/phone_sound_faded.png'/>
		 */
		public static final String PHONE_SOUND_FADED = "phone_sound_faded";

		/**
		 * <img src='./icons/bullet_toggle_plus.png'/>
		 */
		public static final String BULLET_TOGGLE_PLUS = "bullet_toggle_plus";

		/**
		 * <img src='./icons/page_white_csharp_faded.png'/>
		 */
		public static final String PAGE_WHITE_CSHARP_FADED = "page_white_csharp_faded";

		/**
		 * <img src='./icons/text_replace_faded.png'/>
		 */
		public static final String TEXT_REPLACE_FADED = "text_replace_faded";

		/**
		 * <img src='./icons/briefcase.png'/>
		 */
		public static final String BRIEFCASE = "briefcase";

		/**
		 * <img src='./icons/arrow_out_red_faded.png'/>
		 */
		public static final String ARROW_OUT_RED_FADED = "arrow_out_red_faded";

		/**
		 * <img src='./icons/server_connect_faded.png'/>
		 */
		public static final String SERVER_CONNECT_FADED = "server_connect_faded";

		/**
		 * <img src='./icons/folder_star_faded.png'/>
		 */
		public static final String FOLDER_STAR_FADED = "folder_star_faded";

		/**
		 * <img src='./icons/weather_cloudy_lorry_faded.png'/>
		 */
		public static final String WEATHER_CLOUDY_LORRY_FADED = "weather_cloudy_lorry_faded";

		/**
		 * <img src='./icons/database_delete.png'/>
		 */
		public static final String DATABASE_DELETE = "database_delete";

		/**
		 * <img src='./icons/disk_faded.png'/>
		 */
		public static final String DISK_FADED = "disk_faded";

		/**
		 * <img src='./icons/page_code_faded.png'/>
		 */
		public static final String PAGE_CODE_FADED = "page_code_faded";

		/**
		 * <img src='./icons/clock_play_faded.png'/>
		 */
		public static final String CLOCK_PLAY_FADED = "clock_play_faded";

		/**
		 * <img src='./icons/lock_add_faded.png'/>
		 */
		public static final String LOCK_ADD_FADED = "lock_add_faded";

		/**
		 * <img src='./icons/user_green_faded.png'/>
		 */
		public static final String USER_GREEN_FADED = "user_green_faded";

		/**
		 * <img src='./icons/medal_silver_2_faded.png'/>
		 */
		public static final String MEDAL_SILVER_2_FADED = "medal_silver_2_faded";

		/**
		 * <img src='./icons/text_heading_3.png'/>
		 */
		public static final String TEXT_HEADING_3 = "text_heading_3";

		/**
		 * <img src='./icons/status_online.png'/>
		 */
		public static final String STATUS_ONLINE = "status_online";

		/**
		 * <img src='./icons/report_go.png'/>
		 */
		public static final String REPORT_GO = "report_go";

		/**
		 * <img src='./icons/application_view_gallery_faded.png'/>
		 */
		public static final String APPLICATION_VIEW_GALLERY_FADED = "application_view_gallery_faded";

		/**
		 * <img src='./icons/user_suit_black.png'/>
		 */
		public static final String USER_SUIT_BLACK = "user_suit_black";

		/**
		 * <img src='./icons/page_white_link.png'/>
		 */
		public static final String PAGE_WHITE_LINK = "page_white_link";

		/**
		 * <img src='./icons/layout_link.png'/>
		 */
		public static final String LAYOUT_LINK = "layout_link";

		/**
		 * <img src='./icons/date_magnify.png'/>
		 */
		public static final String DATE_MAGNIFY = "date_magnify";

		/**
		 * <img src='./icons/arrow_divide.png'/>
		 */
		public static final String ARROW_DIVIDE = "arrow_divide";

		/**
		 * <img src='./icons/page_white_cplusplus_faded.png'/>
		 */
		public static final String PAGE_WHITE_CPLUSPLUS_FADED = "page_white_cplusplus_faded";

		/**
		 * <img src='./icons/user_gray_stop_alt.png'/>
		 */
		public static final String USER_GRAY_STOP_ALT = "user_gray_stop_alt";

		/**
		 * <img src='./icons/css_faded.png'/>
		 */
		public static final String CSS_FADED = "css_faded";

		/**
		 * <img src='./icons/arrow_branch_faded.png'/>
		 */
		public static final String ARROW_BRANCH_FADED = "arrow_branch_faded";

		/**
		 * <img src='./icons/bullet_yellow_faded.png'/>
		 */
		public static final String BULLET_YELLOW_FADED = "bullet_yellow_faded";

		/**
		 * <img src='./icons/folder_find.png'/>
		 */
		public static final String FOLDER_FIND = "folder_find";

		/**
		 * <img src='./icons/browser_sunrise.png'/>
		 */
		public static final String BROWSER_SUNRISE = "browser_sunrise";

		/**
		 * <img src='./icons/page_white_delete.png'/>
		 */
		public static final String PAGE_WHITE_DELETE = "page_white_delete";

		/**
		 * <img src='./icons/building_error_faded.png'/>
		 */
		public static final String BUILDING_ERROR_FADED = "building_error_faded";

		/**
		 * <img src='./icons/server_error.png'/>
		 */
		public static final String SERVER_ERROR = "server_error";

		/**
		 * <img src='./icons/computer_add_faded.png'/>
		 */
		public static final String COMPUTER_ADD_FADED = "computer_add_faded";

		/**
		 * <img src='./icons/dvd.png'/>
		 */
		public static final String DVD = "dvd";

		/**
		 * <img src='./icons/text_kerning.png'/>
		 */
		public static final String TEXT_KERNING = "text_kerning";

		/**
		 * <img src='./icons/emoticon_wink_faded.png'/>
		 */
		public static final String EMOTICON_WINK_FADED = "emoticon_wink_faded";

		/**
		 * <img src='./icons/user_gray_stop.png'/>
		 */
		public static final String USER_GRAY_STOP = "user_gray_stop";

		/**
		 * <img src='./icons/user_star.png'/>
		 */
		public static final String USER_STAR = "user_star";

		/**
		 * <img src='./icons/transmit_go.png'/>
		 */
		public static final String TRANSMIT_GO = "transmit_go";

		/**
		 * <img src='./icons/zoom.png'/>
		 */
		public static final String ZOOM = "zoom";

		/**
		 * <img src='./icons/ipod_cast.png'/>
		 */
		public static final String IPOD_CAST = "ipod_cast";

		/**
		 * <img src='./icons/time_add_faded.png'/>
		 */
		public static final String TIME_ADD_FADED = "time_add_faded";

		/**
		 * <img src='./icons/package_go_faded.png'/>
		 */
		public static final String PACKAGE_GO_FADED = "package_go_faded";

		/**
		 * <img src='./icons/arrow_turn_left_red_faded.png'/>
		 */
		public static final String ARROW_TURN_LEFT_RED_FADED = "arrow_turn_left_red_faded";

		/**
		 * <img src='./icons/creditcards_faded.png'/>
		 */
		public static final String CREDITCARDS_FADED = "creditcards_faded";

		/**
		 * <img src='./icons/group_gear.png'/>
		 */
		public static final String GROUP_GEAR = "group_gear";

		/**
		 * <img src='./icons/server_key.png'/>
		 */
		public static final String SERVER_KEY = "server_key";

		/**
		 * <img src='./icons/table_delete.png'/>
		 */
		public static final String TABLE_DELETE = "table_delete";

		/**
		 * <img src='./icons/database_go.png'/>
		 */
		public static final String DATABASE_GO = "database_go";

		/**
		 * <img src='./icons/report_delete.png'/>
		 */
		public static final String REPORT_DELETE = "report_delete";

		/**
		 * <img src='./icons/arrow_rotate_anticlockwise.png'/>
		 */
		public static final String ARROW_ROTATE_ANTICLOCKWISE = "arrow_rotate_anticlockwise";

		/**
		 * <img src='./icons/arrow_in_faded.png'/>
		 */
		public static final String ARROW_IN_FADED = "arrow_in_faded";

		/**
		 * <img src='./icons/paste_word_faded.png'/>
		 */
		public static final String PASTE_WORD_FADED = "paste_word_faded";

		/**
		 * <img src='./icons/film_edit.png'/>
		 */
		public static final String FILM_EDIT = "film_edit";

		/**
		 * <img src='./icons/table_error.png'/>
		 */
		public static final String TABLE_ERROR = "table_error";

		/**
		 * <img src='./icons/page_white_copy.png'/>
		 */
		public static final String PAGE_WHITE_COPY = "page_white_copy";

		/**
		 * <img src='./icons/control_rewind_blue.png'/>
		 */
		public static final String CONTROL_REWIND_BLUE = "control_rewind_blue";

		/**
		 * <img src='./icons/arrow_switch_red_faded.png'/>
		 */
		public static final String ARROW_SWITCH_RED_FADED = "arrow_switch_red_faded";

		/**
		 * <img src='./icons/drive_disk.png'/>
		 */
		public static final String DRIVE_DISK = "drive_disk";

		/**
		 * <img src='./icons/pencil_delete_faded.png'/>
		 */
		public static final String PENCIL_DELETE_FADED = "pencil_delete_faded";

		/**
		 * <img src='./icons/flag_orange_faded.png'/>
		 */
		public static final String FLAG_ORANGE_FADED = "flag_orange_faded";

		/**
		 * <img src='./icons/award_star_bronze_1.png'/>
		 */
		public static final String AWARD_STAR_BRONZE_1 = "award_star_bronze_1";

		/**
		 * <img src='./icons/money_euro_faded.png'/>
		 */
		public static final String MONEY_EURO_FADED = "money_euro_faded";

		/**
		 * <img src='./icons/table_status_offline.png'/>
		 */
		public static final String TABLE_STATUS_OFFLINE = "table_status_offline";

		/**
		 * <img src='./icons/text_signature.png'/>
		 */
		public static final String TEXT_SIGNATURE = "text_signature";

		/**
		 * <img src='./icons/page_white_database_faded.png'/>
		 */
		public static final String PAGE_WHITE_DATABASE_FADED = "page_white_database_faded";

		/**
		 * <img src='./icons/drive_delete.png'/>
		 */
		public static final String DRIVE_DELETE = "drive_delete";

		/**
		 * <img src='./icons/arrow_refresh_faded.png'/>
		 */
		public static final String ARROW_REFRESH_FADED = "arrow_refresh_faded";

		/**
		 * <img src='./icons/sport_golf_faded.png'/>
		 */
		public static final String SPORT_GOLF_FADED = "sport_golf_faded";

		/**
		 * <img src='./icons/folder_table_faded.png'/>
		 */
		public static final String FOLDER_TABLE_FADED = "folder_table_faded";

		/**
		 * <img src='./icons/chart_curve_link.png'/>
		 */
		public static final String CHART_CURVE_LINK = "chart_curve_link";

		/**
		 * <img src='./icons/dvd_edit.png'/>
		 */
		public static final String DVD_EDIT = "dvd_edit";

		/**
		 * <img src='./icons/medal_silver_3_faded.png'/>
		 */
		public static final String MEDAL_SILVER_3_FADED = "medal_silver_3_faded";

		/**
		 * <img src='./icons/text_heading_3_faded.png'/>
		 */
		public static final String TEXT_HEADING_3_FADED = "text_heading_3_faded";

		/**
		 * <img src='./icons/bug.png'/>
		 */
		public static final String BUG = "bug";

		/**
		 * <img src='./icons/arrow_undo_red.png'/>
		 */
		public static final String ARROW_UNDO_RED = "arrow_undo_red";

		/**
		 * <img src='./icons/arrow_right.png'/>
		 */
		public static final String ARROW_RIGHT = "arrow_right";

		/**
		 * <img src='./icons/xhtml_go.png'/>
		 */
		public static final String XHTML_GO = "xhtml_go";

		/**
		 * <img src='./icons/drive_cd_faded.png'/>
		 */
		public static final String DRIVE_CD_FADED = "drive_cd_faded";

		/**
		 * <img src='./icons/page_white_cd.png'/>
		 */
		public static final String PAGE_WHITE_CD = "page_white_cd";

		/**
		 * <img src='./icons/camera_go.png'/>
		 */
		public static final String CAMERA_GO = "camera_go";

		/**
		 * <img src='./icons/lorry_delete.png'/>
		 */
		public static final String LORRY_DELETE = "lorry_delete";

		/**
		 * <img src='./icons/page_red_faded.png'/>
		 */
		public static final String PAGE_RED_FADED = "page_red_faded";

		/**
		 * <img src='./icons/report_link.png'/>
		 */
		public static final String REPORT_LINK = "report_link";

		/**
		 * <img src='./icons/contrast_increase_faded.png'/>
		 */
		public static final String CONTRAST_INCREASE_FADED = "contrast_increase_faded";

		/**
		 * <img src='./icons/stop.png'/>
		 */
		public static final String STOP = "stop";

		/**
		 * <img src='./icons/world_faded.png'/>
		 */
		public static final String WORLD_FADED = "world_faded";

		/**
		 * <img src='./icons/script_edit.png'/>
		 */
		public static final String SCRIPT_EDIT = "script_edit";

		/**
		 * <img src='./icons/user_home.png'/>
		 */
		public static final String USER_HOME = "user_home";

		/**
		 * <img src='./icons/building_go_faded.png'/>
		 */
		public static final String BUILDING_GO_FADED = "building_go_faded";

		/**
		 * <img src='./icons/note.png'/>
		 */
		public static final String NOTE = "note";

		/**
		 * <img src='./icons/application_link.png'/>
		 */
		public static final String APPLICATION_LINK = "application_link";

		/**
		 * <img src='./icons/page_white_ruby_faded.png'/>
		 */
		public static final String PAGE_WHITE_RUBY_FADED = "page_white_ruby_faded";

		/**
		 * <img src='./icons/application_xp_terminal_faded.png'/>
		 */
		public static final String APPLICATION_XP_TERMINAL_FADED = "application_xp_terminal_faded";

		/**
		 * <img src='./icons/page_magnifier.png'/>
		 */
		public static final String PAGE_MAGNIFIER = "page_magnifier";

		/**
		 * <img src='./icons/sport_tennis_faded.png'/>
		 */
		public static final String SPORT_TENNIS_FADED = "sport_tennis_faded";

		/**
		 * <img src='./icons/cog_error_faded.png'/>
		 */
		public static final String COG_ERROR_FADED = "cog_error_faded";

		/**
		 * <img src='./icons/key_go.png'/>
		 */
		public static final String KEY_GO = "key_go";

		/**
		 * <img src='./icons/control_end_blue_faded.png'/>
		 */
		public static final String CONTROL_END_BLUE_FADED = "control_end_blue_faded";

		/**
		 * <img src='./icons/tab_delete_faded.png'/>
		 */
		public static final String TAB_DELETE_FADED = "tab_delete_faded";

		/**
		 * <img src='./icons/cart_faded.png'/>
		 */
		public static final String CART_FADED = "cart_faded";

		/**
		 * <img src='./icons/calculator_delete.png'/>
		 */
		public static final String CALCULATOR_DELETE = "calculator_delete";

		/**
		 * <img src='./icons/joystick_add_faded.png'/>
		 */
		public static final String JOYSTICK_ADD_FADED = "joystick_add_faded";

		/**
		 * <img src='./icons/book_next_faded.png'/>
		 */
		public static final String BOOK_NEXT_FADED = "book_next_faded";

		/**
		 * <img src='./icons/error_faded.png'/>
		 */
		public static final String ERROR_FADED = "error_faded";

		/**
		 * <img src='./icons/shape_move_back_faded.png'/>
		 */
		public static final String SHAPE_MOVE_BACK_FADED = "shape_move_back_faded";

		/**
		 * <img src='./icons/film_go_faded.png'/>
		 */
		public static final String FILM_GO_FADED = "film_go_faded";

		/**
		 * <img src='./icons/medal_bronze_delete.png'/>
		 */
		public static final String MEDAL_BRONZE_DELETE = "medal_bronze_delete";

		/**
		 * <img src='./icons/ruby_link.png'/>
		 */
		public static final String RUBY_LINK = "ruby_link";

		/**
		 * <img src='./icons/calendar.png'/>
		 */
		public static final String CALENDAR = "calendar";

		/**
		 * <img src='./icons/arrow_rotate_anticlockwise_faded.png'/>
		 */
		public static final String ARROW_ROTATE_ANTICLOCKWISE_FADED = "arrow_rotate_anticlockwise_faded";

		/**
		 * <img src='./icons/lightbulb_add_faded.png'/>
		 */
		public static final String LIGHTBULB_ADD_FADED = "lightbulb_add_faded";

		/**
		 * <img src='./icons/arrow_branch_red.png'/>
		 */
		public static final String ARROW_BRANCH_RED = "arrow_branch_red";

		/**
		 * <img src='./icons/film_add_faded.png'/>
		 */
		public static final String FILM_ADD_FADED = "film_add_faded";

		/**
		 * <img src='./icons/group_link.png'/>
		 */
		public static final String GROUP_LINK = "group_link";

		/**
		 * <img src='./icons/arrow_merge_red_faded.png'/>
		 */
		public static final String ARROW_MERGE_RED_FADED = "arrow_merge_red_faded";

		/**
		 * <img src='./icons/user_gray_key.png'/>
		 */
		public static final String USER_GRAY_KEY = "user_gray_key";

		/**
		 * <img src='./icons/sport_football_faded.png'/>
		 */
		public static final String SPORT_FOOTBALL_FADED = "sport_football_faded";

		/**
		 * <img src='./icons/page_white_horizontal_faded.png'/>
		 */
		public static final String PAGE_WHITE_HORIZONTAL_FADED = "page_white_horizontal_faded";

		/**
		 * <img src='./icons/script_palette.png'/>
		 */
		public static final String SCRIPT_PALETTE = "script_palette";

		/**
		 * <img src='./icons/building_edit.png'/>
		 */
		public static final String BUILDING_EDIT = "building_edit";

		/**
		 * <img src='./icons/map_delete.png'/>
		 */
		public static final String MAP_DELETE = "map_delete";

		/**
		 * <img src='./icons/image_add.png'/>
		 */
		public static final String IMAGE_ADD = "image_add";

		/**
		 * <img src='./icons/heart.png'/>
		 */
		public static final String HEART = "heart";

		/**
		 * <img src='./icons/page_white_go_faded.png'/>
		 */
		public static final String PAGE_WHITE_GO_FADED = "page_white_go_faded";

		/**
		 * <img src='./icons/emoticon_tongue_faded.png'/>
		 */
		public static final String EMOTICON_TONGUE_FADED = "emoticon_tongue_faded";

		/**
		 * <img src='./icons/browser_chrome.png'/>
		 */
		public static final String BROWSER_CHROME = "browser_chrome";

		/**
		 * <img src='./icons/house_go.png'/>
		 */
		public static final String HOUSE_GO = "house_go";

		/**
		 * <img src='./icons/folder_feed_faded.png'/>
		 */
		public static final String FOLDER_FEED_FADED = "folder_feed_faded";

		/**
		 * <img src='./icons/lorry_faded.png'/>
		 */
		public static final String LORRY_FADED = "lorry_faded";

		/**
		 * <img src='./icons/drink_empty.png'/>
		 */
		public static final String DRINK_EMPTY = "drink_empty";

		/**
		 * <img src='./icons/style_edit_faded.png'/>
		 */
		public static final String STYLE_EDIT_FADED = "style_edit_faded";

		/**
		 * <img src='./icons/user_faded.png'/>
		 */
		public static final String USER_FADED = "user_faded";

		/**
		 * <img src='./icons/webcam_error_faded.png'/>
		 */
		public static final String WEBCAM_ERROR_FADED = "webcam_error_faded";

		/**
		 * <img src='./icons/text_indent_faded.png'/>
		 */
		public static final String TEXT_INDENT_FADED = "text_indent_faded";

		/**
		 * <img src='./icons/text_dropcaps_faded.png'/>
		 */
		public static final String TEXT_DROPCAPS_FADED = "text_dropcaps_faded";

		/**
		 * <img src='./icons/shape_square_delete_faded.png'/>
		 */
		public static final String SHAPE_SQUARE_DELETE_FADED = "shape_square_delete_faded";

		/**
		 * <img src='./icons/bullet_feed_faded.png'/>
		 */
		public static final String BULLET_FEED_FADED = "bullet_feed_faded";

		/**
		 * <img src='./icons/application_split.png'/>
		 */
		public static final String APPLICATION_SPLIT = "application_split";

		/**
		 * <img src='./icons/email_delete_faded.png'/>
		 */
		public static final String EMAIL_DELETE_FADED = "email_delete_faded";

		/**
		 * <img src='./icons/drive_network.png'/>
		 */
		public static final String DRIVE_NETWORK = "drive_network";

		/**
		 * <img src='./icons/pill.png'/>
		 */
		public static final String PILL = "pill";

		/**
		 * <img src='./icons/arrow_turn_right_red.png'/>
		 */
		public static final String ARROW_TURN_RIGHT_RED = "arrow_turn_right_red";

		/**
		 * <img src='./icons/bell_go.png'/>
		 */
		public static final String BELL_GO = "bell_go";

		/**
		 * <img src='./icons/server_chart_faded.png'/>
		 */
		public static final String SERVER_CHART_FADED = "server_chart_faded";

		/**
		 * <img src='./icons/page_edit.png'/>
		 */
		public static final String PAGE_EDIT = "page_edit";

		/**
		 * <img src='./icons/page_white_go.png'/>
		 */
		public static final String PAGE_WHITE_GO = "page_white_go";

		/**
		 * <img src='./icons/accept_faded.png'/>
		 */
		public static final String ACCEPT_FADED = "accept_faded";

		/**
		 * <img src='./icons/weather_lightning_faded.png'/>
		 */
		public static final String WEATHER_LIGHTNING_FADED = "weather_lightning_faded";

		/**
		 * <img src='./icons/cup_link.png'/>
		 */
		public static final String CUP_LINK = "cup_link";

		/**
		 * <img src='./icons/arrow_up_red.png'/>
		 */
		public static final String ARROW_UP_RED = "arrow_up_red";

		/**
		 * <img src='./icons/map_edit_faded.png'/>
		 */
		public static final String MAP_EDIT_FADED = "map_edit_faded";

		/**
		 * <img src='./icons/page_white_paintbrush.png'/>
		 */
		public static final String PAGE_WHITE_PAINTBRUSH = "page_white_paintbrush";

		/**
		 * <img src='./icons/award_star_bronze_2.png'/>
		 */
		public static final String AWARD_STAR_BRONZE_2 = "award_star_bronze_2";

		/**
		 * <img src='./icons/award_star_gold_1.png'/>
		 */
		public static final String AWARD_STAR_GOLD_1 = "award_star_gold_1";

		/**
		 * <img src='./icons/page_white_code_faded.png'/>
		 */
		public static final String PAGE_WHITE_CODE_FADED = "page_white_code_faded";

		/**
		 * <img src='./icons/webcam_delete.png'/>
		 */
		public static final String WEBCAM_DELETE = "webcam_delete";

		/**
		 * <img src='./icons/female_faded.png'/>
		 */
		public static final String FEMALE_FADED = "female_faded";

		/**
		 * <img src='./icons/brick.png'/>
		 */
		public static final String BRICK = "brick";

		/**
		 * <img src='./icons/bullet_yellow.png'/>
		 */
		public static final String BULLET_YELLOW = "bullet_yellow";

		/**
		 * <img src='./icons/style_delete.png'/>
		 */
		public static final String STYLE_DELETE = "style_delete";

		/**
		 * <img src='./icons/flag_pink.png'/>
		 */
		public static final String FLAG_PINK = "flag_pink";

		/**
		 * <img src='./icons/script_faded.png'/>
		 */
		public static final String SCRIPT_FADED = "script_faded";

		/**
		 * <img src='./icons/computer_link_faded.png'/>
		 */
		public static final String COMPUTER_LINK_FADED = "computer_link_faded";

		/**
		 * <img src='./icons/server_link_faded.png'/>
		 */
		public static final String SERVER_LINK_FADED = "server_link_faded";

		/**
		 * <img src='./icons/tab.png'/>
		 */
		public static final String TAB = "tab";

		/**
		 * <img src='./icons/basket_error.png'/>
		 */
		public static final String BASKET_ERROR = "basket_error";

		/**
		 * <img src='./icons/sum_faded.png'/>
		 */
		public static final String SUM_FADED = "sum_faded";

		/**
		 * <img src='./icons/emoticon_surprised_faded.png'/>
		 */
		public static final String EMOTICON_SURPRISED_FADED = "emoticon_surprised_faded";

		/**
		 * <img src='./icons/page_white_acrobat_faded.png'/>
		 */
		public static final String PAGE_WHITE_ACROBAT_FADED = "page_white_acrobat_faded";

		/**
		 * <img src='./icons/arrow_rotate_anticlockwise_red.png'/>
		 */
		public static final String ARROW_ROTATE_ANTICLOCKWISE_RED = "arrow_rotate_anticlockwise_red";

		/**
		 * <img src='./icons/book_edit.png'/>
		 */
		public static final String BOOK_EDIT = "book_edit";

		/**
		 * <img src='./icons/application_form_magnify_faded.png'/>
		 */
		public static final String APPLICATION_FORM_MAGNIFY_FADED = "application_form_magnify_faded";

		/**
		 * <img src='./icons/cart_go.png'/>
		 */
		public static final String CART_GO = "cart_go";

		/**
		 * <img src='./icons/style_edit.png'/>
		 */
		public static final String STYLE_EDIT = "style_edit";

		/**
		 * <img src='./icons/monitor_delete_faded.png'/>
		 */
		public static final String MONITOR_DELETE_FADED = "monitor_delete_faded";

		/**
		 * <img src='./icons/keyboard_magnify_faded.png'/>
		 */
		public static final String KEYBOARD_MAGNIFY_FADED = "keyboard_magnify_faded";

		/**
		 * <img src='./icons/tag_blue_delete_faded.png'/>
		 */
		public static final String TAG_BLUE_DELETE_FADED = "tag_blue_delete_faded";

		/**
		 * <img src='./icons/magnifier_zoom_in.png'/>
		 */
		public static final String MAGNIFIER_ZOOM_IN = "magnifier_zoom_in";

		/**
		 * <img src='./icons/drink_empty_faded.png'/>
		 */
		public static final String DRINK_EMPTY_FADED = "drink_empty_faded";

		/**
		 * <img src='./icons/calendar_link.png'/>
		 */
		public static final String CALENDAR_LINK = "calendar_link";

		/**
		 * <img src='./icons/folder_star.png'/>
		 */
		public static final String FOLDER_STAR = "folder_star";

		/**
		 * <img src='./icons/user_b.png'/>
		 */
		public static final String USER_B = "user_b";

		/**
		 * <img src='./icons/calendar_view_week.png'/>
		 */
		public static final String CALENDAR_VIEW_WEEK = "calendar_view_week";

		/**
		 * <img src='./icons/computer_edit.png'/>
		 */
		public static final String COMPUTER_EDIT = "computer_edit";

		/**
		 * <img src='./icons/css_go_faded.png'/>
		 */
		public static final String CSS_GO_FADED = "css_go_faded";

		/**
		 * <img src='./icons/pictures_faded.png'/>
		 */
		public static final String PICTURES_FADED = "pictures_faded";

		/**
		 * <img src='./icons/page_gear.png'/>
		 */
		public static final String PAGE_GEAR = "page_gear";

		/**
		 * <img src='./icons/sitemap_color_faded.png'/>
		 */
		public static final String SITEMAP_COLOR_FADED = "sitemap_color_faded";

		/**
		 * <img src='./icons/shape_flip_horizontal.png'/>
		 */
		public static final String SHAPE_FLIP_HORIZONTAL = "shape_flip_horizontal";

		/**
		 * <img src='./icons/user_information.png'/>
		 */
		public static final String USER_INFORMATION = "user_information";

		/**
		 * <img src='./icons/layout_error.png'/>
		 */
		public static final String LAYOUT_ERROR = "layout_error";

		/**
		 * <img src='./icons/text_strikethrough.png'/>
		 */
		public static final String TEXT_STRIKETHROUGH = "text_strikethrough";

		/**
		 * <img src='./icons/money_yen_faded.png'/>
		 */
		public static final String MONEY_YEN_FADED = "money_yen_faded";

		/**
		 * <img src='./icons/basket_put.png'/>
		 */
		public static final String BASKET_PUT = "basket_put";

		/**
		 * <img src='./icons/group_faded.png'/>
		 */
		public static final String GROUP_FADED = "group_faded";

		/**
		 * <img src='./icons/lock_open_faded.png'/>
		 */
		public static final String LOCK_OPEN_FADED = "lock_open_faded";

		/**
		 * <img src='./icons/thumb_down.png'/>
		 */
		public static final String THUMB_DOWN = "thumb_down";

		/**
		 * <img src='./icons/cake_faded.png'/>
		 */
		public static final String CAKE_FADED = "cake_faded";

		/**
		 * <img src='./icons/thumb_up_faded.png'/>
		 */
		public static final String THUMB_UP_FADED = "thumb_up_faded";

		/**
		 * <img src='./icons/find_faded.png'/>
		 */
		public static final String FIND_FADED = "find_faded";

		/**
		 * <img src='./icons/emoticon_smile.png'/>
		 */
		public static final String EMOTICON_SMILE = "emoticon_smile";

		/**
		 * <img src='./icons/drive_user.png'/>
		 */
		public static final String DRIVE_USER = "drive_user";

		/**
		 * <img src='./icons/weather_snow.png'/>
		 */
		public static final String WEATHER_SNOW = "weather_snow";

		/**
		 * <img src='./icons/help_faded.png'/>
		 */
		public static final String HELP_FADED = "help_faded";

		/**
		 * <img src='./icons/shape_move_front_faded.png'/>
		 */
		public static final String SHAPE_MOVE_FRONT_FADED = "shape_move_front_faded";

		/**
		 * <img src='./icons/page_white_copy_faded.png'/>
		 */
		public static final String PAGE_WHITE_COPY_FADED = "page_white_copy_faded";

		/**
		 * <img src='./icons/layout_add_faded.png'/>
		 */
		public static final String LAYOUT_ADD_FADED = "layout_add_faded";

		/**
		 * <img src='./icons/comment_delete_faded.png'/>
		 */
		public static final String COMMENT_DELETE_FADED = "comment_delete_faded";

		/**
		 * <img src='./icons/photo_link.png'/>
		 */
		public static final String PHOTO_LINK = "photo_link";

		/**
		 * <img src='./icons/xhtml_valid.png'/>
		 */
		public static final String XHTML_VALID = "xhtml_valid";

		/**
		 * <img src='./icons/chart_bar_error.png'/>
		 */
		public static final String CHART_BAR_ERROR = "chart_bar_error";

		/**
		 * <img src='./icons/monitor_error_faded.png'/>
		 */
		public static final String MONITOR_ERROR_FADED = "monitor_error_faded";

		/**
		 * <img src='./icons/html_add.png'/>
		 */
		public static final String HTML_ADD = "html_add";

		/**
		 * <img src='./icons/page_white_vector.png'/>
		 */
		public static final String PAGE_WHITE_VECTOR = "page_white_vector";

		/**
		 * <img src='./icons/shape_align_bottom.png'/>
		 */
		public static final String SHAPE_ALIGN_BOTTOM = "shape_align_bottom";

		/**
		 * <img src='./icons/lorry_delete_faded.png'/>
		 */
		public static final String LORRY_DELETE_FADED = "lorry_delete_faded";

		/**
		 * <img src='./icons/telephone_faded.png'/>
		 */
		public static final String TELEPHONE_FADED = "telephone_faded";

		/**
		 * <img src='./icons/map.png'/>
		 */
		public static final String MAP = "map";

		/**
		 * <img src='./icons/script_key.png'/>
		 */
		public static final String SCRIPT_KEY = "script_key";

		/**
		 * <img src='./icons/application_get.png'/>
		 */
		public static final String APPLICATION_GET = "application_get";

		/**
		 * <img src='./icons/text_kerning_faded.png'/>
		 */
		public static final String TEXT_KERNING_FADED = "text_kerning_faded";

		/**
		 * <img src='./icons/page_white_get.png'/>
		 */
		public static final String PAGE_WHITE_GET = "page_white_get";

		/**
		 * <img src='./icons/house_go_faded.png'/>
		 */
		public static final String HOUSE_GO_FADED = "house_go_faded";

		/**
		 * <img src='./icons/bullet_white.png'/>
		 */
		public static final String BULLET_WHITE = "bullet_white";

		/**
		 * <img src='./icons/table_relationship_faded.png'/>
		 */
		public static final String TABLE_RELATIONSHIP_FADED = "table_relationship_faded";

		/**
		 * <img src='./icons/application_tile_horizontal_faded.png'/>
		 */
		public static final String APPLICATION_TILE_HORIZONTAL_FADED = "application_tile_horizontal_faded";

		/**
		 * <img src='./icons/user_edit.png'/>
		 */
		public static final String USER_EDIT = "user_edit";

		/**
		 * <img src='./icons/page_white_put.png'/>
		 */
		public static final String PAGE_WHITE_PUT = "page_white_put";

		/**
		 * <img src='./icons/user_magnify.png'/>
		 */
		public static final String USER_MAGNIFY = "user_magnify";

		/**
		 * <img src='./icons/page_white_word_faded.png'/>
		 */
		public static final String PAGE_WHITE_WORD_FADED = "page_white_word_faded";

		/**
		 * <img src='./icons/user_orange.png'/>
		 */
		public static final String USER_ORANGE = "user_orange";

		/**
		 * <img src='./icons/bug_error.png'/>
		 */
		public static final String BUG_ERROR = "bug_error";

		/**
		 * <img src='./icons/user_female.png'/>
		 */
		public static final String USER_FEMALE = "user_female";

		/**
		 * <img src='./icons/comment_edit_faded.png'/>
		 */
		public static final String COMMENT_EDIT_FADED = "comment_edit_faded";

		/**
		 * <img src='./icons/email_open_image_faded.png'/>
		 */
		public static final String EMAIL_OPEN_IMAGE_FADED = "email_open_image_faded";

		/**
		 * <img src='./icons/medal_silver_1.png'/>
		 */
		public static final String MEDAL_SILVER_1 = "medal_silver_1";

		/**
		 * <img src='./icons/bullet_delete.png'/>
		 */
		public static final String BULLET_DELETE = "bullet_delete";

		/**
		 * <img src='./icons/zoom_out_faded.png'/>
		 */
		public static final String ZOOM_OUT_FADED = "zoom_out_faded";

		/**
		 * <img src='./icons/picture_go.png'/>
		 */
		public static final String PICTURE_GO = "picture_go";

		/**
		 * <img src='./icons/paste_plain.png'/>
		 */
		public static final String PASTE_PLAIN = "paste_plain";

		/**
		 * <img src='./icons/folder_palette_faded.png'/>
		 */
		public static final String FOLDER_PALETTE_FADED = "folder_palette_faded";

		/**
		 * <img src='./icons/tag_blue.png'/>
		 */
		public static final String TAG_BLUE = "tag_blue";

		/**
		 * <img src='./icons/feed_add.png'/>
		 */
		public static final String FEED_ADD = "feed_add";

		/**
		 * <img src='./icons/weather_sun_user_female.png'/>
		 */
		public static final String WEATHER_SUN_USER_FEMALE = "weather_sun_user_female";

		/**
		 * <img src='./icons/ruby_go_faded.png'/>
		 */
		public static final String RUBY_GO_FADED = "ruby_go_faded";

		/**
		 * <img src='./icons/database_table.png'/>
		 */
		public static final String DATABASE_TABLE = "database_table";

		/**
		 * <img src='./icons/script.png'/>
		 */
		public static final String SCRIPT = "script";

		/**
		 * <img src='./icons/book_edit_faded.png'/>
		 */
		public static final String BOOK_EDIT_FADED = "book_edit_faded";

		/**
		 * <img src='./icons/bell_error_faded.png'/>
		 */
		public static final String BELL_ERROR_FADED = "bell_error_faded";

		/**
		 * <img src='./icons/page_white_powerpoint_faded.png'/>
		 */
		public static final String PAGE_WHITE_POWERPOINT_FADED = "page_white_powerpoint_faded";

		/**
		 * <img src='./icons/cog_edit.png'/>
		 */
		public static final String COG_EDIT = "cog_edit";

		/**
		 * <img src='./icons/bin_faded.png'/>
		 */
		public static final String BIN_FADED = "bin_faded";

		/**
		 * <img src='./icons/coins.png'/>
		 */
		public static final String COINS = "coins";

		/**
		 * <img src='./icons/application_delete.png'/>
		 */
		public static final String APPLICATION_DELETE = "application_delete";

		/**
		 * <img src='./icons/key_delete.png'/>
		 */
		public static final String KEY_DELETE = "key_delete";

		/**
		 * <img src='./icons/emoticon_tongue.png'/>
		 */
		public static final String EMOTICON_TONGUE = "emoticon_tongue";

		/**
		 * <img src='./icons/bug_delete.png'/>
		 */
		public static final String BUG_DELETE = "bug_delete";

		/**
		 * <img src='./icons/hourglass_go_faded.png'/>
		 */
		public static final String HOURGLASS_GO_FADED = "hourglass_go_faded";

		/**
		 * <img src='./icons/film_save.png'/>
		 */
		public static final String FILM_SAVE = "film_save";

		/**
		 * <img src='./icons/text_italic.png'/>
		 */
		public static final String TEXT_ITALIC = "text_italic";

		/**
		 * <img src='./icons/award_star_silver_2.png'/>
		 */
		public static final String AWARD_STAR_SILVER_2 = "award_star_silver_2";

		/**
		 * <img src='./icons/link_go_faded.png'/>
		 */
		public static final String LINK_GO_FADED = "link_go_faded";

		/**
		 * <img src='./icons/transmit.png'/>
		 */
		public static final String TRANSMIT = "transmit";

		/**
		 * <img src='./icons/report_word.png'/>
		 */
		public static final String REPORT_WORD = "report_word";

		/**
		 * <img src='./icons/control_rewind_faded.png'/>
		 */
		public static final String CONTROL_REWIND_FADED = "control_rewind_faded";

		/**
		 * <img src='./icons/film_link.png'/>
		 */
		public static final String FILM_LINK = "film_link";

		/**
		 * <img src='./icons/shape_align_center_faded.png'/>
		 */
		public static final String SHAPE_ALIGN_CENTER_FADED = "shape_align_center_faded";

		/**
		 * <img src='./icons/joystick_error_faded.png'/>
		 */
		public static final String JOYSTICK_ERROR_FADED = "joystick_error_faded";

		/**
		 * <img src='./icons/css_add.png'/>
		 */
		public static final String CSS_ADD = "css_add";

		/**
		 * <img src='./icons/chart_pie.png'/>
		 */
		public static final String CHART_PIE = "chart_pie";

		/**
		 * <img src='./icons/table_refresh_faded.png'/>
		 */
		public static final String TABLE_REFRESH_FADED = "table_refresh_faded";

		/**
		 * <img src='./icons/resultset_last_faded.png'/>
		 */
		public static final String RESULTSET_LAST_FADED = "resultset_last_faded";

		/**
		 * <img src='./icons/folder_page_faded.png'/>
		 */
		public static final String FOLDER_PAGE_FADED = "folder_page_faded";

		/**
		 * <img src='./icons/text_align_center.png'/>
		 */
		public static final String TEXT_ALIGN_CENTER = "text_align_center";

		/**
		 * <img src='./icons/chart_bar_delete.png'/>
		 */
		public static final String CHART_BAR_DELETE = "chart_bar_delete";

		/**
		 * <img src='./icons/browser_icab.png'/>
		 */
		public static final String BROWSER_ICAB = "browser_icab";

		/**
		 * <img src='./icons/brick_link_faded.png'/>
		 */
		public static final String BRICK_LINK_FADED = "brick_link_faded";

		/**
		 * <img src='./icons/vector_add.png'/>
		 */
		public static final String VECTOR_ADD = "vector_add";

		/**
		 * <img src='./icons/folder_delete_faded.png'/>
		 */
		public static final String FOLDER_DELETE_FADED = "folder_delete_faded";

		/**
		 * <img src='./icons/chart_line_add.png'/>
		 */
		public static final String CHART_LINE_ADD = "chart_line_add";

		/**
		 * <img src='./icons/page_white_vector_faded.png'/>
		 */
		public static final String PAGE_WHITE_VECTOR_FADED = "page_white_vector_faded";

		/**
		 * <img src='./icons/dvd_key_faded.png'/>
		 */
		public static final String DVD_KEY_FADED = "dvd_key_faded";

		/**
		 * <img src='./icons/page_white_picture_faded.png'/>
		 */
		public static final String PAGE_WHITE_PICTURE_FADED = "page_white_picture_faded";

		/**
		 * <img src='./icons/basket_error_faded.png'/>
		 */
		public static final String BASKET_ERROR_FADED = "basket_error_faded";

		/**
		 * <img src='./icons/server_connect.png'/>
		 */
		public static final String SERVER_CONNECT = "server_connect";

		/**
		 * <img src='./icons/server_delete.png'/>
		 */
		public static final String SERVER_DELETE = "server_delete";

		/**
		 * <img src='./icons/arrow_refresh_small_red.png'/>
		 */
		public static final String ARROW_REFRESH_SMALL_RED = "arrow_refresh_small_red";

		/**
		 * <img src='./icons/sum.png'/>
		 */
		public static final String SUM = "sum";

		/**
		 * <img src='./icons/weather_sun_user_female_faded.png'/>
		 */
		public static final String WEATHER_SUN_USER_FEMALE_FADED = "weather_sun_user_female_faded";

		/**
		 * <img src='./icons/script_gear.png'/>
		 */
		public static final String SCRIPT_GEAR = "script_gear";

		/**
		 * <img src='./icons/ruby_delete.png'/>
		 */
		public static final String RUBY_DELETE = "ruby_delete";

		/**
		 * <img src='./icons/medal_bronze_delete_faded.png'/>
		 */
		public static final String MEDAL_BRONZE_DELETE_FADED = "medal_bronze_delete_faded";

		/**
		 * <img src='./icons/arrow_inout.png'/>
		 */
		public static final String ARROW_INOUT = "arrow_inout";

		/**
		 * <img src='./icons/vcard_edit_faded.png'/>
		 */
		public static final String VCARD_EDIT_FADED = "vcard_edit_faded";

		/**
		 * <img src='./icons/application_side_boxes.png'/>
		 */
		public static final String APPLICATION_SIDE_BOXES = "application_side_boxes";

		/**
		 * <img src='./icons/application_xp.png'/>
		 */
		public static final String APPLICATION_XP = "application_xp";

		/**
		 * <img src='./icons/medal_bronze_add_faded.png'/>
		 */
		public static final String MEDAL_BRONZE_ADD_FADED = "medal_bronze_add_faded";

		/**
		 * <img src='./icons/cog_delete.png'/>
		 */
		public static final String COG_DELETE = "cog_delete";

		/**
		 * <img src='./icons/clock_faded.png'/>
		 */
		public static final String CLOCK_FADED = "clock_faded";

		/**
		 * <img src='./icons/award_star_gold_1_faded.png'/>
		 */
		public static final String AWARD_STAR_GOLD_1_FADED = "award_star_gold_1_faded";

		/**
		 * <img src='./icons/control_equalizer_faded.png'/>
		 */
		public static final String CONTROL_EQUALIZER_FADED = "control_equalizer_faded";

		/**
		 * <img src='./icons/car_faded.png'/>
		 */
		public static final String CAR_FADED = "car_faded";

		/**
		 * <img src='./icons/text_list_bullets.png'/>
		 */
		public static final String TEXT_LIST_BULLETS = "text_list_bullets";

		/**
		 * <img src='./icons/sql_add.png'/>
		 */
		public static final String SQL_ADD = "sql_add";

		/**
		 * <img src='./icons/drive_error.png'/>
		 */
		public static final String DRIVE_ERROR = "drive_error";

		/**
		 * <img src='./icons/webcam.png'/>
		 */
		public static final String WEBCAM = "webcam";

		/**
		 * <img src='./icons/bullet_key.png'/>
		 */
		public static final String BULLET_KEY = "bullet_key";

		/**
		 * <img src='./icons/bullet_toggle_plus_faded.png'/>
		 */
		public static final String BULLET_TOGGLE_PLUS_FADED = "bullet_toggle_plus_faded";

		/**
		 * <img src='./icons/cup_add.png'/>
		 */
		public static final String CUP_ADD = "cup_add";

		/**
		 * <img src='./icons/feed_link.png'/>
		 */
		public static final String FEED_LINK = "feed_link";

		/**
		 * <img src='./icons/xhtml_valid_faded.png'/>
		 */
		public static final String XHTML_VALID_FADED = "xhtml_valid_faded";

		/**
		 * <img src='./icons/disconnect_faded.png'/>
		 */
		public static final String DISCONNECT_FADED = "disconnect_faded";

		/**
		 * <img src='./icons/cut_red.png'/>
		 */
		public static final String CUT_RED = "cut_red";

		/**
		 * <img src='./icons/layout.png'/>
		 */
		public static final String LAYOUT = "layout";

		/**
		 * <img src='./icons/joystick_delete_faded.png'/>
		 */
		public static final String JOYSTICK_DELETE_FADED = "joystick_delete_faded";

		/**
		 * <img src='./icons/page_white_edit.png'/>
		 */
		public static final String PAGE_WHITE_EDIT = "page_white_edit";

		/**
		 * <img src='./icons/sport_basketball.png'/>
		 */
		public static final String SPORT_BASKETBALL = "sport_basketball";

		/**
		 * <img src='./icons/script_error_faded.png'/>
		 */
		public static final String SCRIPT_ERROR_FADED = "script_error_faded";

		/**
		 * <img src='./icons/map_add_faded.png'/>
		 */
		public static final String MAP_ADD_FADED = "map_add_faded";

		/**
		 * <img src='./icons/text_padding_left_faded.png'/>
		 */
		public static final String TEXT_PADDING_LEFT_FADED = "text_padding_left_faded";

		/**
		 * <img src='./icons/joystick_add.png'/>
		 */
		public static final String JOYSTICK_ADD = "joystick_add";

		/**
		 * <img src='./icons/keyboard_add_faded.png'/>
		 */
		public static final String KEYBOARD_ADD_FADED = "keyboard_add_faded";

		/**
		 * <img src='./icons/calendar_add_faded.png'/>
		 */
		public static final String CALENDAR_ADD_FADED = "calendar_add_faded";

		/**
		 * <img src='./icons/chart_pie_add_faded.png'/>
		 */
		public static final String CHART_PIE_ADD_FADED = "chart_pie_add_faded";

		/**
		 * <img src='./icons/comment_delete.png'/>
		 */
		public static final String COMMENT_DELETE = "comment_delete";

		/**
		 * <img src='./icons/script_palette_faded.png'/>
		 */
		public static final String SCRIPT_PALETTE_FADED = "script_palette_faded";

		/**
		 * <img src='./icons/report_link_faded.png'/>
		 */
		public static final String REPORT_LINK_FADED = "report_link_faded";

		/**
		 * <img src='./icons/basket_go_faded.png'/>
		 */
		public static final String BASKET_GO_FADED = "basket_go_faded";

		/**
		 * <img src='./icons/basket_delete_faded.png'/>
		 */
		public static final String BASKET_DELETE_FADED = "basket_delete_faded";

		/**
		 * <img src='./icons/control_rewind_blue_faded.png'/>
		 */
		public static final String CONTROL_REWIND_BLUE_FADED = "control_rewind_blue_faded";

		/**
		 * <img src='./icons/text_heading_2.png'/>
		 */
		public static final String TEXT_HEADING_2 = "text_heading_2";

		/**
		 * <img src='./icons/font_add_faded.png'/>
		 */
		public static final String FONT_ADD_FADED = "font_add_faded";

		/**
		 * <img src='./icons/css_delete_faded.png'/>
		 */
		public static final String CSS_DELETE_FADED = "css_delete_faded";

		/**
		 * <img src='./icons/application_cascade_go.png'/>
		 */
		public static final String APPLICATION_CASCADE_GO = "application_cascade_go";

		/**
		 * <img src='./icons/bullet_picture_faded.png'/>
		 */
		public static final String BULLET_PICTURE_FADED = "bullet_picture_faded";

		/**
		 * <img src='./icons/status_away_faded.png'/>
		 */
		public static final String STATUS_AWAY_FADED = "status_away_faded";

		/**
		 * <img src='./icons/weather_cloudy_user_female_faded.png'/>
		 */
		public static final String WEATHER_CLOUDY_USER_FEMALE_FADED = "weather_cloudy_user_female_faded";

		/**
		 * <img src='./icons/application_side_expand_faded.png'/>
		 */
		public static final String APPLICATION_SIDE_EXPAND_FADED = "application_side_expand_faded";

		/**
		 * <img src='./icons/camera_edit.png'/>
		 */
		public static final String CAMERA_EDIT = "camera_edit";

		/**
		 * <img src='./icons/layout_link_faded.png'/>
		 */
		public static final String LAYOUT_LINK_FADED = "layout_link_faded";

		/**
		 * <img src='./icons/asterisk_orange.png'/>
		 */
		public static final String ASTERISK_ORANGE = "asterisk_orange";

		/**
		 * <img src='./icons/plugin_disabled_faded.png'/>
		 */
		public static final String PLUGIN_DISABLED_FADED = "plugin_disabled_faded";

		/**
		 * <img src='./icons/controller_add.png'/>
		 */
		public static final String CONTROLLER_ADD = "controller_add";

		/**
		 * <img src='./icons/xhtml.png'/>
		 */
		public static final String XHTML = "xhtml";

		/**
		 * <img src='./icons/cut_red_faded.png'/>
		 */
		public static final String CUT_RED_FADED = "cut_red_faded";

		/**
		 * <img src='./icons/ipod_cast_delete.png'/>
		 */
		public static final String IPOD_CAST_DELETE = "ipod_cast_delete";

		/**
		 * <img src='./icons/cup_go.png'/>
		 */
		public static final String CUP_GO = "cup_go";

		/**
		 * <img src='./icons/award_star_add_faded.png'/>
		 */
		public static final String AWARD_STAR_ADD_FADED = "award_star_add_faded";

		/**
		 * <img src='./icons/picture_add.png'/>
		 */
		public static final String PICTURE_ADD = "picture_add";

		/**
		 * <img src='./icons/database_edit.png'/>
		 */
		public static final String DATABASE_EDIT = "database_edit";

		/**
		 * <img src='./icons/emoticon_smile_faded.png'/>
		 */
		public static final String EMOTICON_SMILE_FADED = "emoticon_smile_faded";

		/**
		 * <img src='./icons/sql_valid.png'/>
		 */
		public static final String SQL_VALID = "sql_valid";

		/**
		 * <img src='./icons/book_add_faded.png'/>
		 */
		public static final String BOOK_ADD_FADED = "book_add_faded";

		/**
		 * <img src='./icons/medal_bronze_2_faded.png'/>
		 */
		public static final String MEDAL_BRONZE_2_FADED = "medal_bronze_2_faded";

		/**
		 * <img src='./icons/arrow_left_red.png'/>
		 */
		public static final String ARROW_LEFT_RED = "arrow_left_red";

		/**
		 * <img src='./icons/chart_line_edit_faded.png'/>
		 */
		public static final String CHART_LINE_EDIT_FADED = "chart_line_edit_faded";

		/**
		 * <img src='./icons/html_go.png'/>
		 */
		public static final String HTML_GO = "html_go";

		/**
		 * <img src='./icons/sql_delete_faded.png'/>
		 */
		public static final String SQL_DELETE_FADED = "sql_delete_faded";

		/**
		 * <img src='./icons/shape_align_top.png'/>
		 */
		public static final String SHAPE_ALIGN_TOP = "shape_align_top";

		/**
		 * <img src='./icons/emoticon_wink.png'/>
		 */
		public static final String EMOTICON_WINK = "emoticon_wink";

		/**
		 * <img src='./icons/page_white_c.png'/>
		 */
		public static final String PAGE_WHITE_C = "page_white_c";

		/**
		 * <img src='./icons/page_white_actionscript_faded.png'/>
		 */
		public static final String PAGE_WHITE_ACTIONSCRIPT_FADED = "page_white_actionscript_faded";

		/**
		 * <img src='./icons/vector_delete_faded.png'/>
		 */
		public static final String VECTOR_DELETE_FADED = "vector_delete_faded";

		/**
		 * <img src='./icons/user_female_add.png'/>
		 */
		public static final String USER_FEMALE_ADD = "user_female_add";

		/**
		 * <img src='./icons/dvd_link.png'/>
		 */
		public static final String DVD_LINK = "dvd_link";

		/**
		 * <img src='./icons/cd_go_faded.png'/>
		 */
		public static final String CD_GO_FADED = "cd_go_faded";

		/**
		 * <img src='./icons/folder_lightbulb.png'/>
		 */
		public static final String FOLDER_LIGHTBULB = "folder_lightbulb";

		/**
		 * <img src='./icons/control_equalizer_blue.png'/>
		 */
		public static final String CONTROL_EQUALIZER_BLUE = "control_equalizer_blue";

		/**
		 * <img src='./icons/user_go_faded.png'/>
		 */
		public static final String USER_GO_FADED = "user_go_faded";

		/**
		 * <img src='./icons/brick_edit_faded.png'/>
		 */
		public static final String BRICK_EDIT_FADED = "brick_edit_faded";

		/**
		 * <img src='./icons/folder_wrench_faded.png'/>
		 */
		public static final String FOLDER_WRENCH_FADED = "folder_wrench_faded";

		/**
		 * <img src='./icons/weather_cloudy_add.png'/>
		 */
		public static final String WEATHER_CLOUDY_ADD = "weather_cloudy_add";

		/**
		 * <img src='./icons/browser_shiira_faded.png'/>
		 */
		public static final String BROWSER_SHIIRA_FADED = "browser_shiira_faded";

		/**
		 * <img src='./icons/date_edit_faded.png'/>
		 */
		public static final String DATE_EDIT_FADED = "date_edit_faded";

		/**
		 * <img src='./icons/folder_link_faded.png'/>
		 */
		public static final String FOLDER_LINK_FADED = "folder_link_faded";

		/**
		 * <img src='./icons/style_add_faded.png'/>
		 */
		public static final String STYLE_ADD_FADED = "style_add_faded";

		/**
		 * <img src='./icons/cart_error_faded.png'/>
		 */
		public static final String CART_ERROR_FADED = "cart_error_faded";

		/**
		 * <img src='./icons/shape_rotate_anticlockwise.png'/>
		 */
		public static final String SHAPE_ROTATE_ANTICLOCKWISE = "shape_rotate_anticlockwise";

		/**
		 * <img src='./icons/vector_add_faded.png'/>
		 */
		public static final String VECTOR_ADD_FADED = "vector_add_faded";

		/**
		 * <img src='./icons/exclamation.png'/>
		 */
		public static final String EXCLAMATION = "exclamation";

		/**
		 * <img src='./icons/film_error.png'/>
		 */
		public static final String FILM_ERROR = "film_error";

		/**
		 * <img src='./icons/emoticon_happy_faded.png'/>
		 */
		public static final String EMOTICON_HAPPY_FADED = "emoticon_happy_faded";

		/**
		 * <img src='./icons/book_addresses.png'/>
		 */
		public static final String BOOK_ADDRESSES = "book_addresses";

		/**
		 * <img src='./icons/plugin_error.png'/>
		 */
		public static final String PLUGIN_ERROR = "plugin_error";

		/**
		 * <img src='./icons/lightbulb.png'/>
		 */
		public static final String LIGHTBULB = "lightbulb";

		/**
		 * <img src='./icons/arrow_switch_faded.png'/>
		 */
		public static final String ARROW_SWITCH_FADED = "arrow_switch_faded";

		/**
		 * <img src='./icons/lock_edit.png'/>
		 */
		public static final String LOCK_EDIT = "lock_edit";

		/**
		 * <img src='./icons/table_relationship.png'/>
		 */
		public static final String TABLE_RELATIONSHIP = "table_relationship";

		/**
		 * <img src='./icons/contrast_decrease_faded.png'/>
		 */
		public static final String CONTRAST_DECREASE_FADED = "contrast_decrease_faded";

		/**
		 * <img src='./icons/page_white_add.png'/>
		 */
		public static final String PAGE_WHITE_ADD = "page_white_add";

		/**
		 * <img src='./icons/tag_pink_faded.png'/>
		 */
		public static final String TAG_PINK_FADED = "tag_pink_faded";

		/**
		 * <img src='./icons/medal_silver_delete_faded.png'/>
		 */
		public static final String MEDAL_SILVER_DELETE_FADED = "medal_silver_delete_faded";

		/**
		 * <img src='./icons/page_white_lightning.png'/>
		 */
		public static final String PAGE_WHITE_LIGHTNING = "page_white_lightning";

		/**
		 * <img src='./icons/shape_square_key_faded.png'/>
		 */
		public static final String SHAPE_SQUARE_KEY_FADED = "shape_square_key_faded";

		/**
		 * <img src='./icons/photos.png'/>
		 */
		public static final String PHOTOS = "photos";

		/**
		 * <img src='./icons/phone_add_faded.png'/>
		 */
		public static final String PHONE_ADD_FADED = "phone_add_faded";

		/**
		 * <img src='./icons/clock_red.png'/>
		 */
		public static final String CLOCK_RED = "clock_red";

		/**
		 * <img src='./icons/book_key_faded.png'/>
		 */
		public static final String BOOK_KEY_FADED = "book_key_faded";

		/**
		 * <img src='./icons/brick_error.png'/>
		 */
		public static final String BRICK_ERROR = "brick_error";

		/**
		 * <img src='./icons/css.png'/>
		 */
		public static final String CSS = "css";

		/**
		 * <img src='./icons/medal_silver_add.png'/>
		 */
		public static final String MEDAL_SILVER_ADD = "medal_silver_add";

		/**
		 * <img src='./icons/tag_purple_faded.png'/>
		 */
		public static final String TAG_PURPLE_FADED = "tag_purple_faded";

		/**
		 * <img src='./icons/cup.png'/>
		 */
		public static final String CUP = "cup";

		/**
		 * <img src='./icons/contrast_decrease.png'/>
		 */
		public static final String CONTRAST_DECREASE = "contrast_decrease";

		/**
		 * <img src='./icons/shape_rotate_clockwise_faded.png'/>
		 */
		public static final String SHAPE_ROTATE_CLOCKWISE_FADED = "shape_rotate_clockwise_faded";

		/**
		 * <img src='./icons/film_edit_faded.png'/>
		 */
		public static final String FILM_EDIT_FADED = "film_edit_faded";

		/**
		 * <img src='./icons/application_cascade_delete.png'/>
		 */
		public static final String APPLICATION_CASCADE_DELETE = "application_cascade_delete";

		/**
		 * <img src='./icons/box.png'/>
		 */
		public static final String BOX = "box";

		/**
		 * <img src='./icons/user_delete.png'/>
		 */
		public static final String USER_DELETE = "user_delete";

		/**
		 * <img src='./icons/control_repeat_blue_faded.png'/>
		 */
		public static final String CONTROL_REPEAT_BLUE_FADED = "control_repeat_blue_faded";

		/**
		 * <img src='./icons/status_away.png'/>
		 */
		public static final String STATUS_AWAY = "status_away";

		/**
		 * <img src='./icons/arrow_out_red.png'/>
		 */
		public static final String ARROW_OUT_RED = "arrow_out_red";

		/**
		 * <img src='./icons/folder_database.png'/>
		 */
		public static final String FOLDER_DATABASE = "folder_database";

		/**
		 * <img src='./icons/bullet_blue_faded.png'/>
		 */
		public static final String BULLET_BLUE_FADED = "bullet_blue_faded";

		/**
		 * <img src='./icons/star_faded.png'/>
		 */
		public static final String STAR_FADED = "star_faded";

		/**
		 * <img src='./icons/layout_edit_faded.png'/>
		 */
		public static final String LAYOUT_EDIT_FADED = "layout_edit_faded";

		/**
		 * <img src='./icons/money_delete_faded.png'/>
		 */
		public static final String MONEY_DELETE_FADED = "money_delete_faded";

		/**
		 * <img src='./icons/application_osx.png'/>
		 */
		public static final String APPLICATION_OSX = "application_osx";

		/**
		 * <img src='./icons/layout_faded.png'/>
		 */
		public static final String LAYOUT_FADED = "layout_faded";

		/**
		 * <img src='./icons/folder_go.png'/>
		 */
		public static final String FOLDER_GO = "folder_go";

		/**
		 * <img src='./icons/text_heading_6_faded.png'/>
		 */
		public static final String TEXT_HEADING_6_FADED = "text_heading_6_faded";

		/**
		 * <img src='./icons/arrow_merge_red.png'/>
		 */
		public static final String ARROW_MERGE_RED = "arrow_merge_red";

		/**
		 * <img src='./icons/bullet_black.png'/>
		 */
		public static final String BULLET_BLACK = "bullet_black";

		/**
		 * <img src='./icons/emoticon_evilgrin.png'/>
		 */
		public static final String EMOTICON_EVILGRIN = "emoticon_evilgrin";

		/**
		 * <img src='./icons/feed.png'/>
		 */
		public static final String FEED = "feed";

		/**
		 * <img src='./icons/page_key.png'/>
		 */
		public static final String PAGE_KEY = "page_key";

		/**
		 * <img src='./icons/printer.png'/>
		 */
		public static final String PRINTER = "printer";

		/**
		 * <img src='./icons/overlays_faded.png'/>
		 */
		public static final String OVERLAYS_FADED = "overlays_faded";

		/**
		 * <img src='./icons/date_link_faded.png'/>
		 */
		public static final String DATE_LINK_FADED = "date_link_faded";

		/**
		 * <img src='./icons/browser_icab_faded.png'/>
		 */
		public static final String BROWSER_ICAB_FADED = "browser_icab_faded";

		/**
		 * <img src='./icons/note_add_faded.png'/>
		 */
		public static final String NOTE_ADD_FADED = "note_add_faded";

		/**
		 * <img src='./icons/page_find.png'/>
		 */
		public static final String PAGE_FIND = "page_find";

		/**
		 * <img src='./icons/rss_add.png'/>
		 */
		public static final String RSS_ADD = "rss_add";

		/**
		 * <img src='./icons/cog_add.png'/>
		 */
		public static final String COG_ADD = "cog_add";

		/**
		 * <img src='./icons/user_green.png'/>
		 */
		public static final String USER_GREEN = "user_green";

		/**
		 * <img src='./icons/mouse_add.png'/>
		 */
		public static final String MOUSE_ADD = "mouse_add";

		/**
		 * <img src='./icons/bullet_disk.png'/>
		 */
		public static final String BULLET_DISK = "bullet_disk";

		/**
		 * <img src='./icons/world_link_faded.png'/>
		 */
		public static final String WORLD_LINK_FADED = "world_link_faded";

		/**
		 * <img src='./icons/controller_faded.png'/>
		 */
		public static final String CONTROLLER_FADED = "controller_faded";

		/**
		 * <img src='./icons/computer_key.png'/>
		 */
		public static final String COMPUTER_KEY = "computer_key";

		/**
		 * <img src='./icons/text_underline_faded.png'/>
		 */
		public static final String TEXT_UNDERLINE_FADED = "text_underline_faded";

		/**
		 * <img src='./icons/bullet_delete_faded.png'/>
		 */
		public static final String BULLET_DELETE_FADED = "bullet_delete_faded";

		/**
		 * <img src='./icons/tab_add.png'/>
		 */
		public static final String TAB_ADD = "tab_add";

		/**
		 * <img src='./icons/monitor_delete.png'/>
		 */
		public static final String MONITOR_DELETE = "monitor_delete";

		/**
		 * <img src='./icons/medal_gold_add.png'/>
		 */
		public static final String MEDAL_GOLD_ADD = "medal_gold_add";

		/**
		 * <img src='./icons/page_white_freehand_faded.png'/>
		 */
		public static final String PAGE_WHITE_FREEHAND_FADED = "page_white_freehand_faded";

		/**
		 * <img src='./icons/drive_user_faded.png'/>
		 */
		public static final String DRIVE_USER_FADED = "drive_user_faded";

		/**
		 * <img src='./icons/browser_firefox.png'/>
		 */
		public static final String BROWSER_FIREFOX = "browser_firefox";

		/**
		 * <img src='./icons/plugin_edit.png'/>
		 */
		public static final String PLUGIN_EDIT = "plugin_edit";

		/**
		 * <img src='./icons/text_padding_right_faded.png'/>
		 */
		public static final String TEXT_PADDING_RIGHT_FADED = "text_padding_right_faded";

		/**
		 * <img src='./icons/control_end_blue.png'/>
		 */
		public static final String CONTROL_END_BLUE = "control_end_blue";

		/**
		 * <img src='./icons/shape_square_faded.png'/>
		 */
		public static final String SHAPE_SQUARE_FADED = "shape_square_faded";

		/**
		 * <img src='./icons/cog_add_faded.png'/>
		 */
		public static final String COG_ADD_FADED = "cog_add_faded";

		/**
		 * <img src='./icons/text_uppercase.png'/>
		 */
		public static final String TEXT_UPPERCASE = "text_uppercase";

		/**
		 * <img src='./icons/cup_edit.png'/>
		 */
		public static final String CUP_EDIT = "cup_edit";

		/**
		 * <img src='./icons/weather_cloudy_faded.png'/>
		 */
		public static final String WEATHER_CLOUDY_FADED = "weather_cloudy_faded";

		/**
		 * <img src='./icons/page_white_excel_faded.png'/>
		 */
		public static final String PAGE_WHITE_EXCEL_FADED = "page_white_excel_faded";

		/**
		 * <img src='./icons/xhtml_add_faded.png'/>
		 */
		public static final String XHTML_ADD_FADED = "xhtml_add_faded";

		/**
		 * <img src='./icons/shape_square_edit.png'/>
		 */
		public static final String SHAPE_SQUARE_EDIT = "shape_square_edit";

		/**
		 * <img src='./icons/ruby_gear.png'/>
		 */
		public static final String RUBY_GEAR = "ruby_gear";

		/**
		 * <img src='./icons/shape_align_right_faded.png'/>
		 */
		public static final String SHAPE_ALIGN_RIGHT_FADED = "shape_align_right_faded";

		/**
		 * <img src='./icons/folder_bell.png'/>
		 */
		public static final String FOLDER_BELL = "folder_bell";

		/**
		 * <img src='./icons/user_key.png'/>
		 */
		public static final String USER_KEY = "user_key";

		/**
		 * <img src='./icons/page_magnifier_faded.png'/>
		 */
		public static final String PAGE_MAGNIFIER_FADED = "page_magnifier_faded";

		/**
		 * <img src='./icons/error_go_faded.png'/>
		 */
		public static final String ERROR_GO_FADED = "error_go_faded";

		/**
		 * <img src='./icons/xhtml_faded.png'/>
		 */
		public static final String XHTML_FADED = "xhtml_faded";

		/**
		 * <img src='./icons/chart_curve_edit.png'/>
		 */
		public static final String CHART_CURVE_EDIT = "chart_curve_edit";

		/**
		 * <img src='./icons/film_link_faded.png'/>
		 */
		public static final String FILM_LINK_FADED = "film_link_faded";

		/**
		 * <img src='./icons/lightbulb_add.png'/>
		 */
		public static final String LIGHTBULB_ADD = "lightbulb_add";

		/**
		 * <img src='./icons/date_link.png'/>
		 */
		public static final String DATE_LINK = "date_link";

		/**
		 * <img src='./icons/bullet_green_faded.png'/>
		 */
		public static final String BULLET_GREEN_FADED = "bullet_green_faded";

		/**
		 * <img src='./icons/arrow_divide_red_faded.png'/>
		 */
		public static final String ARROW_DIVIDE_RED_FADED = "arrow_divide_red_faded";

		/**
		 * <img src='./icons/dvd_add_faded.png'/>
		 */
		public static final String DVD_ADD_FADED = "dvd_add_faded";

		/**
		 * <img src='./icons/medal_gold_2_faded.png'/>
		 */
		public static final String MEDAL_GOLD_2_FADED = "medal_gold_2_faded";

		/**
		 * <img src='./icons/cup_go_faded.png'/>
		 */
		public static final String CUP_GO_FADED = "cup_go_faded";

		/**
		 * <img src='./icons/shape_move_backwards.png'/>
		 */
		public static final String SHAPE_MOVE_BACKWARDS = "shape_move_backwards";

		/**
		 * <img src='./icons/dvd_key.png'/>
		 */
		public static final String DVD_KEY = "dvd_key";

		/**
		 * <img src='./icons/text_horizontalrule.png'/>
		 */
		public static final String TEXT_HORIZONTALRULE = "text_horizontalrule";

		/**
		 * <img src='./icons/emoticon_evilgrin_faded.png'/>
		 */
		public static final String EMOTICON_EVILGRIN_FADED = "emoticon_evilgrin_faded";

		/**
		 * <img src='./icons/drive_delete_faded.png'/>
		 */
		public static final String DRIVE_DELETE_FADED = "drive_delete_faded";

		/**
		 * <img src='./icons/sql.png'/>
		 */
		public static final String SQL = "sql";

		/**
		 * <img src='./icons/status_offline.png'/>
		 */
		public static final String STATUS_OFFLINE = "status_offline";

		/**
		 * <img src='./icons/lorry_add_faded.png'/>
		 */
		public static final String LORRY_ADD_FADED = "lorry_add_faded";

		/**
		 * <img src='./icons/magifier_zoom_out_faded.png'/>
		 */
		public static final String MAGIFIER_ZOOM_OUT_FADED = "magifier_zoom_out_faded";

		/**
		 * <img src='./icons/shape_square_error_faded.png'/>
		 */
		public static final String SHAPE_SQUARE_ERROR_FADED = "shape_square_error_faded";

		/**
		 * <img src='./icons/report_picture.png'/>
		 */
		public static final String REPORT_PICTURE = "report_picture";

		/**
		 * <img src='./icons/page_white_find.png'/>
		 */
		public static final String PAGE_WHITE_FIND = "page_white_find";

		/**
		 * <img src='./icons/text_align_left_faded.png'/>
		 */
		public static final String TEXT_ALIGN_LEFT_FADED = "text_align_left_faded";

		/**
		 * <img src='./icons/paintbrush.png'/>
		 */
		public static final String PAINTBRUSH = "paintbrush";

		/**
		 * <img src='./icons/layout_add.png'/>
		 */
		public static final String LAYOUT_ADD = "layout_add";

		/**
		 * <img src='./icons/report_delete_faded.png'/>
		 */
		public static final String REPORT_DELETE_FADED = "report_delete_faded";

		/**
		 * <img src='./icons/text_lowercase_faded.png'/>
		 */
		public static final String TEXT_LOWERCASE_FADED = "text_lowercase_faded";

		/**
		 * <img src='./icons/arrow_undo_faded.png'/>
		 */
		public static final String ARROW_UNDO_FADED = "arrow_undo_faded";

		/**
		 * <img src='./icons/computer.png'/>
		 */
		public static final String COMPUTER = "computer";

		/**
		 * <img src='./icons/link_error.png'/>
		 */
		public static final String LINK_ERROR = "link_error";

		/**
		 * <img src='./icons/cd_add.png'/>
		 */
		public static final String CD_ADD = "cd_add";

		/**
		 * <img src='./icons/building_edit_faded.png'/>
		 */
		public static final String BUILDING_EDIT_FADED = "building_edit_faded";

		/**
		 * <img src='./icons/report_key_faded.png'/>
		 */
		public static final String REPORT_KEY_FADED = "report_key_faded";

		/**
		 * <img src='./icons/key_go_faded.png'/>
		 */
		public static final String KEY_GO_FADED = "key_go_faded";

		/**
		 * <img src='./icons/computer_error_faded.png'/>
		 */
		public static final String COMPUTER_ERROR_FADED = "computer_error_faded";

		/**
		 * <img src='./icons/lorry_user_female.png'/>
		 */
		public static final String LORRY_USER_FEMALE = "lorry_user_female";

		/**
		 * <img src='./icons/resultset_previous.png'/>
		 */
		public static final String RESULTSET_PREVIOUS = "resultset_previous";

		/**
		 * <img src='./icons/resultset_next.png'/>
		 */
		public static final String RESULTSET_NEXT = "resultset_next";

		/**
		 * <img src='./icons/emoticon_waii.png'/>
		 */
		public static final String EMOTICON_WAII = "emoticon_waii";

		/**
		 * <img src='./icons/blank_faded.png'/>
		 */
		public static final String BLANK_FADED = "blank_faded";

		/**
		 * <img src='./icons/control_pause_blue_faded.png'/>
		 */
		public static final String CONTROL_PAUSE_BLUE_FADED = "control_pause_blue_faded";

		/**
		 * <img src='./icons/arrow_switch_red.png'/>
		 */
		public static final String ARROW_SWITCH_RED = "arrow_switch_red";

		/**
		 * <img src='./icons/page_white_database.png'/>
		 */
		public static final String PAGE_WHITE_DATABASE = "page_white_database";

		/**
		 * <img src='./icons/film_save_faded.png'/>
		 */
		public static final String FILM_SAVE_FADED = "film_save_faded";

		/**
		 * <img src='./icons/book_error_faded.png'/>
		 */
		public static final String BOOK_ERROR_FADED = "book_error_faded";

		/**
		 * <img src='./icons/browser_omniweb.png'/>
		 */
		public static final String BROWSER_OMNIWEB = "browser_omniweb";

		/**
		 * <img src='./icons/application_osx_terminal_faded.png'/>
		 */
		public static final String APPLICATION_OSX_TERMINAL_FADED = "application_osx_terminal_faded";

		/**
		 * <img src='./icons/page_white_office_faded.png'/>
		 */
		public static final String PAGE_WHITE_OFFICE_FADED = "page_white_office_faded";

		/**
		 * <img src='./icons/page_white_paste.png'/>
		 */
		public static final String PAGE_WHITE_PASTE = "page_white_paste";

		/**
		 * <img src='./icons/folder_table.png'/>
		 */
		public static final String FOLDER_TABLE = "folder_table";

		/**
		 * <img src='./icons/group_gear_faded.png'/>
		 */
		public static final String GROUP_GEAR_FADED = "group_gear_faded";

		/**
		 * <img src='./icons/date.png'/>
		 */
		public static final String DATE = "date";

		/**
		 * <img src='./icons/note_go_faded.png'/>
		 */
		public static final String NOTE_GO_FADED = "note_go_faded";

		/**
		 * <img src='./icons/page_white_width_faded.png'/>
		 */
		public static final String PAGE_WHITE_WIDTH_FADED = "page_white_width_faded";

		/**
		 * <img src='./icons/film_delete_faded.png'/>
		 */
		public static final String FILM_DELETE_FADED = "film_delete_faded";

		/**
		 * <img src='./icons/plugin_add_faded.png'/>
		 */
		public static final String PLUGIN_ADD_FADED = "plugin_add_faded";

		/**
		 * <img src='./icons/date_go.png'/>
		 */
		public static final String DATE_GO = "date_go";

		/**
		 * <img src='./icons/sport_volleyball.png'/>
		 */
		public static final String SPORT_VOLLEYBALL = "sport_volleyball";

		/**
		 * <img src='./icons/page_paste_faded.png'/>
		 */
		public static final String PAGE_PASTE_FADED = "page_paste_faded";

		/**
		 * <img src='./icons/sql_delete.png'/>
		 */
		public static final String SQL_DELETE = "sql_delete";

		/**
		 * <img src='./icons/layout_sidebar.png'/>
		 */
		public static final String LAYOUT_SIDEBAR = "layout_sidebar";

		/**
		 * <img src='./icons/webcam_add_faded.png'/>
		 */
		public static final String WEBCAM_ADD_FADED = "webcam_add_faded";

		/**
		 * <img src='./icons/computer_add.png'/>
		 */
		public static final String COMPUTER_ADD = "computer_add";

		/**
		 * <img src='./icons/date_next.png'/>
		 */
		public static final String DATE_NEXT = "date_next";

		/**
		 * <img src='./icons/camera_edit_faded.png'/>
		 */
		public static final String CAMERA_EDIT_FADED = "camera_edit_faded";

		/**
		 * <img src='./icons/wrench.png'/>
		 */
		public static final String WRENCH = "wrench";

		/**
		 * <img src='./icons/user_earth.png'/>
		 */
		public static final String USER_EARTH = "user_earth";

		/**
		 * <img src='./icons/page_refresh_faded.png'/>
		 */
		public static final String PAGE_REFRESH_FADED = "page_refresh_faded";

		/**
		 * <img src='./icons/user_exclamation.png'/>
		 */
		public static final String USER_EXCLAMATION = "user_exclamation";

		/**
		 * <img src='./icons/pencil_add_faded.png'/>
		 */
		public static final String PENCIL_ADD_FADED = "pencil_add_faded";

		/**
		 * <img src='./icons/keyboard_delete_faded.png'/>
		 */
		public static final String KEYBOARD_DELETE_FADED = "keyboard_delete_faded";

		/**
		 * <img src='./icons/bin_empty.png'/>
		 */
		public static final String BIN_EMPTY = "bin_empty";

		/**
		 * <img src='./icons/page_white_office.png'/>
		 */
		public static final String PAGE_WHITE_OFFICE = "page_white_office";

		/**
		 * <img src='./icons/dvd_go_faded.png'/>
		 */
		public static final String DVD_GO_FADED = "dvd_go_faded";

		/**
		 * <img src='./icons/browser_aol_faded.png'/>
		 */
		public static final String BROWSER_AOL_FADED = "browser_aol_faded";

		/**
		 * <img src='./icons/book_link.png'/>
		 */
		public static final String BOOK_LINK = "book_link";

		/**
		 * <img src='./icons/bell_delete_faded.png'/>
		 */
		public static final String BELL_DELETE_FADED = "bell_delete_faded";

		/**
		 * <img src='./icons/clock_delete_faded.png'/>
		 */
		public static final String CLOCK_DELETE_FADED = "clock_delete_faded";

		/**
		 * <img src='./icons/application_tile_vertical.png'/>
		 */
		public static final String APPLICATION_TILE_VERTICAL = "application_tile_vertical";

		/**
		 * <img src='./icons/text_dropcaps.png'/>
		 */
		public static final String TEXT_DROPCAPS = "text_dropcaps";

		/**
		 * <img src='./icons/arrow_merge_faded.png'/>
		 */
		public static final String ARROW_MERGE_FADED = "arrow_merge_faded";

		/**
		 * <img src='./icons/script_lightning_faded.png'/>
		 */
		public static final String SCRIPT_LIGHTNING_FADED = "script_lightning_faded";

		/**
		 * <img src='./icons/disk_multiple_faded.png'/>
		 */
		public static final String DISK_MULTIPLE_FADED = "disk_multiple_faded";

		/**
		 * <img src='./icons/user_delete_faded.png'/>
		 */
		public static final String USER_DELETE_FADED = "user_delete_faded";

		/**
		 * <img src='./icons/rainbow_faded.png'/>
		 */
		public static final String RAINBOW_FADED = "rainbow_faded";

		/**
		 * <img src='./icons/application_side_contract_faded.png'/>
		 */
		public static final String APPLICATION_SIDE_CONTRACT_FADED = "application_side_contract_faded";

		/**
		 * <img src='./icons/printer_delete_faded.png'/>
		 */
		public static final String PRINTER_DELETE_FADED = "printer_delete_faded";

		/**
		 * <img src='./icons/bullet_purple_faded.png'/>
		 */
		public static final String BULLET_PURPLE_FADED = "bullet_purple_faded";

		/**
		 * <img src='./icons/add_faded.png'/>
		 */
		public static final String ADD_FADED = "add_faded";

		/**
		 * <img src='./icons/textfield_add.png'/>
		 */
		public static final String TEXTFIELD_ADD = "textfield_add";

		/**
		 * <img src='./icons/shape_square_add_faded.png'/>
		 */
		public static final String SHAPE_SQUARE_ADD_FADED = "shape_square_add_faded";

		/**
		 * <img src='./icons/bullet_go_faded.png'/>
		 */
		public static final String BULLET_GO_FADED = "bullet_go_faded";

		/**
		 * <img src='./icons/arrow_join_faded.png'/>
		 */
		public static final String ARROW_JOIN_FADED = "arrow_join_faded";

		/**
		 * <img src='./icons/lorry_link.png'/>
		 */
		public static final String LORRY_LINK = "lorry_link";

		/**
		 * <img src='./icons/pill_faded.png'/>
		 */
		public static final String PILL_FADED = "pill_faded";

		/**
		 * <img src='./icons/cancel.png'/>
		 */
		public static final String CANCEL = "cancel";

		/**
		 * <img src='./icons/printer_error.png'/>
		 */
		public static final String PRINTER_ERROR = "printer_error";

		/**
		 * <img src='./icons/basket_remove.png'/>
		 */
		public static final String BASKET_REMOVE = "basket_remove";

		/**
		 * <img src='./icons/brick_faded.png'/>
		 */
		public static final String BRICK_FADED = "brick_faded";

		/**
		 * <img src='./icons/printer_error_faded.png'/>
		 */
		public static final String PRINTER_ERROR_FADED = "printer_error_faded";

		/**
		 * <img src='./icons/arrow_divide_red.png'/>
		 */
		public static final String ARROW_DIVIDE_RED = "arrow_divide_red";

		/**
		 * <img src='./icons/page_lightning_faded.png'/>
		 */
		public static final String PAGE_LIGHTNING_FADED = "page_lightning_faded";

		/**
		 * <img src='./icons/resultset_next_faded.png'/>
		 */
		public static final String RESULTSET_NEXT_FADED = "resultset_next_faded";

		/**
		 * <img src='./icons/text_bold_faded.png'/>
		 */
		public static final String TEXT_BOLD_FADED = "text_bold_faded";

		/**
		 * <img src='./icons/table_lightning_faded.png'/>
		 */
		public static final String TABLE_LIGHTNING_FADED = "table_lightning_faded";

		/**
		 * <img src='./icons/calendar_delete.png'/>
		 */
		public static final String CALENDAR_DELETE = "calendar_delete";

		/**
		 * <img src='./icons/page_white_h.png'/>
		 */
		public static final String PAGE_WHITE_H = "page_white_h";

		/**
		 * <img src='./icons/text_signature_faded.png'/>
		 */
		public static final String TEXT_SIGNATURE_FADED = "text_signature_faded";

		/**
		 * <img src='./icons/bell_link.png'/>
		 */
		public static final String BELL_LINK = "bell_link";

		/**
		 * <img src='./icons/feed_faded.png'/>
		 */
		public static final String FEED_FADED = "feed_faded";

		/**
		 * <img src='./icons/application_go_faded.png'/>
		 */
		public static final String APPLICATION_GO_FADED = "application_go_faded";

		/**
		 * <img src='./icons/mouse_delete.png'/>
		 */
		public static final String MOUSE_DELETE = "mouse_delete";

		/**
		 * <img src='./icons/status_busy_faded.png'/>
		 */
		public static final String STATUS_BUSY_FADED = "status_busy_faded";

		/**
		 * <img src='./icons/page_paintbrush.png'/>
		 */
		public static final String PAGE_PAINTBRUSH = "page_paintbrush";

		/**
		 * <img src='./icons/lightning_go_faded.png'/>
		 */
		public static final String LIGHTNING_GO_FADED = "lightning_go_faded";

		/**
		 * <img src='./icons/folder_image_faded.png'/>
		 */
		public static final String FOLDER_IMAGE_FADED = "folder_image_faded";

		/**
		 * <img src='./icons/contrast_low_faded.png'/>
		 */
		public static final String CONTRAST_LOW_FADED = "contrast_low_faded";

		/**
		 * <img src='./icons/shape_square_link.png'/>
		 */
		public static final String SHAPE_SQUARE_LINK = "shape_square_link";

		/**
		 * <img src='./icons/database_delete_faded.png'/>
		 */
		public static final String DATABASE_DELETE_FADED = "database_delete_faded";

		/**
		 * <img src='./icons/heart_add_faded.png'/>
		 */
		public static final String HEART_ADD_FADED = "heart_add_faded";

		/**
		 * <img src='./icons/page_white_key.png'/>
		 */
		public static final String PAGE_WHITE_KEY = "page_white_key";

		/**
		 * <img src='./icons/page_white_world.png'/>
		 */
		public static final String PAGE_WHITE_WORLD = "page_white_world";

		/**
		 * <img src='./icons/arrow_rotate_clockwise.png'/>
		 */
		public static final String ARROW_ROTATE_CLOCKWISE = "arrow_rotate_clockwise";

		/**
		 * <img src='./icons/flag_purple.png'/>
		 */
		public static final String FLAG_PURPLE = "flag_purple";

		/**
		 * <img src='./icons/bullet_picture.png'/>
		 */
		public static final String BULLET_PICTURE = "bullet_picture";

		/**
		 * <img src='./icons/script_delete_faded.png'/>
		 */
		public static final String SCRIPT_DELETE_FADED = "script_delete_faded";

		/**
		 * <img src='./icons/browser_internetexplorer_faded.png'/>
		 */
		public static final String BROWSER_INTERNETEXPLORER_FADED = "browser_internetexplorer_faded";

		/**
		 * <img src='./icons/building_faded.png'/>
		 */
		public static final String BUILDING_FADED = "building_faded";

		/**
		 * <img src='./icons/keyboard_faded.png'/>
		 */
		public static final String KEYBOARD_FADED = "keyboard_faded";

		/**
		 * <img src='./icons/page_white_put_faded.png'/>
		 */
		public static final String PAGE_WHITE_PUT_FADED = "page_white_put_faded";

		/**
		 * <img src='./icons/date_next_faded.png'/>
		 */
		public static final String DATE_NEXT_FADED = "date_next_faded";

		/**
		 * <img src='./icons/bullet_disk_faded.png'/>
		 */
		public static final String BULLET_DISK_FADED = "bullet_disk_faded";

		/**
		 * <img src='./icons/textfield_rename_faded.png'/>
		 */
		public static final String TEXTFIELD_RENAME_FADED = "textfield_rename_faded";

		/**
		 * <img src='./icons/date_add.png'/>
		 */
		public static final String DATE_ADD = "date_add";

		/**
		 * <img src='./icons/browser_opera_faded.png'/>
		 */
		public static final String BROWSER_OPERA_FADED = "browser_opera_faded";

		/**
		 * <img src='./icons/television_add.png'/>
		 */
		public static final String TELEVISION_ADD = "television_add";

		/**
		 * <img src='./icons/textfield_faded.png'/>
		 */
		public static final String TEXTFIELD_FADED = "textfield_faded";

		/**
		 * <img src='./icons/page_white_c_faded.png'/>
		 */
		public static final String PAGE_WHITE_C_FADED = "page_white_c_faded";

		/**
		 * <img src='./icons/chart_bar_add_faded.png'/>
		 */
		public static final String CHART_BAR_ADD_FADED = "chart_bar_add_faded";

		/**
		 * <img src='./icons/picture_link.png'/>
		 */
		public static final String PICTURE_LINK = "picture_link";

		/**
		 * <img src='./icons/calculator_error_faded.png'/>
		 */
		public static final String CALCULATOR_ERROR_FADED = "calculator_error_faded";

		/**
		 * <img src='./icons/plugin_link_faded.png'/>
		 */
		public static final String PLUGIN_LINK_FADED = "plugin_link_faded";

		/**
		 * <img src='./icons/browser_internetexplorer.png'/>
		 */
		public static final String BROWSER_INTERNETEXPLORER = "browser_internetexplorer";

		/**
		 * <img src='./icons/hourglass_add_faded.png'/>
		 */
		public static final String HOURGLASS_ADD_FADED = "hourglass_add_faded";

		/**
		 * <img src='./icons/plugin_go_faded.png'/>
		 */
		public static final String PLUGIN_GO_FADED = "plugin_go_faded";

		/**
		 * <img src='./icons/clock_go_faded.png'/>
		 */
		public static final String CLOCK_GO_FADED = "clock_go_faded";

		/**
		 * <img src='./icons/plugin_delete_faded.png'/>
		 */
		public static final String PLUGIN_DELETE_FADED = "plugin_delete_faded";

		/**
		 * <img src='./icons/text_columns_faded.png'/>
		 */
		public static final String TEXT_COLUMNS_FADED = "text_columns_faded";

		/**
		 * <img src='./icons/text_list_bullets_faded.png'/>
		 */
		public static final String TEXT_LIST_BULLETS_FADED = "text_list_bullets_faded";

		/**
		 * <img src='./icons/cart_put_faded.png'/>
		 */
		public static final String CART_PUT_FADED = "cart_put_faded";

		/**
		 * <img src='./icons/page.png'/>
		 */
		public static final String PAGE = "page";

		/**
		 * <img src='./icons/camera_go_faded.png'/>
		 */
		public static final String CAMERA_GO_FADED = "camera_go_faded";

		/**
		 * <img src='./icons/page_white_dvd.png'/>
		 */
		public static final String PAGE_WHITE_DVD = "page_white_dvd";

		/**
		 * <img src='./icons/picture_error_faded.png'/>
		 */
		public static final String PICTURE_ERROR_FADED = "picture_error_faded";

		/**
		 * <img src='./icons/camera_small_faded.png'/>
		 */
		public static final String CAMERA_SMALL_FADED = "camera_small_faded";

		/**
		 * <img src='./icons/arrow_right_red_faded.png'/>
		 */
		public static final String ARROW_RIGHT_RED_FADED = "arrow_right_red_faded";

		/**
		 * <img src='./icons/feed_disk_faded.png'/>
		 */
		public static final String FEED_DISK_FADED = "feed_disk_faded";

		/**
		 * <img src='./icons/ruby_get_faded.png'/>
		 */
		public static final String RUBY_GET_FADED = "ruby_get_faded";

		/**
		 * <img src='./icons/application_edit_faded.png'/>
		 */
		public static final String APPLICATION_EDIT_FADED = "application_edit_faded";

		/**
		 * <img src='./icons/control_stop_faded.png'/>
		 */
		public static final String CONTROL_STOP_FADED = "control_stop_faded";

		/**
		 * <img src='./icons/bug_link_faded.png'/>
		 */
		public static final String BUG_LINK_FADED = "bug_link_faded";

		/**
		 * <img src='./icons/application_go.png'/>
		 */
		public static final String APPLICATION_GO = "application_go";

		/**
		 * <img src='./icons/table_sort.png'/>
		 */
		public static final String TABLE_SORT = "table_sort";

		/**
		 * <img src='./icons/medal_gold_delete.png'/>
		 */
		public static final String MEDAL_GOLD_DELETE = "medal_gold_delete";

		/**
		 * <img src='./icons/cart_edit.png'/>
		 */
		public static final String CART_EDIT = "cart_edit";

		/**
		 * <img src='./icons/arrow_left_faded.png'/>
		 */
		public static final String ARROW_LEFT_FADED = "arrow_left_faded";

		/**
		 * <img src='./icons/chart_organisation_delete.png'/>
		 */
		public static final String CHART_ORGANISATION_DELETE = "chart_organisation_delete";

		/**
		 * <img src='./icons/control_eject_blue_faded.png'/>
		 */
		public static final String CONTROL_EJECT_BLUE_FADED = "control_eject_blue_faded";

		/**
		 * <img src='./icons/arrow_in_red.png'/>
		 */
		public static final String ARROW_IN_RED = "arrow_in_red";

		/**
		 * <img src='./icons/sound_low_faded.png'/>
		 */
		public static final String SOUND_LOW_FADED = "sound_low_faded";

		/**
		 * <img src='./icons/tab_add_faded.png'/>
		 */
		public static final String TAB_ADD_FADED = "tab_add_faded";

		/**
		 * <img src='./icons/css_valid_faded.png'/>
		 */
		public static final String CSS_VALID_FADED = "css_valid_faded";

		/**
		 * <img src='./icons/date_delete.png'/>
		 */
		public static final String DATE_DELETE = "date_delete";

		/**
		 * <img src='./icons/clock_link_faded.png'/>
		 */
		public static final String CLOCK_LINK_FADED = "clock_link_faded";

		/**
		 * <img src='./icons/picture_key.png'/>
		 */
		public static final String PICTURE_KEY = "picture_key";

		/**
		 * <img src='./icons/lock_delete.png'/>
		 */
		public static final String LOCK_DELETE = "lock_delete";

		/**
		 * <img src='./icons/application_home.png'/>
		 */
		public static final String APPLICATION_HOME = "application_home";

		/**
		 * <img src='./icons/lightning_go.png'/>
		 */
		public static final String LIGHTNING_GO = "lightning_go";

		/**
		 * <img src='./icons/bug_add_faded.png'/>
		 */
		public static final String BUG_ADD_FADED = "bug_add_faded";

		/**
		 * <img src='./icons/script_calendar.png'/>
		 */
		public static final String SCRIPT_CALENDAR = "script_calendar";

		/**
		 * <img src='./icons/map_delete_faded.png'/>
		 */
		public static final String MAP_DELETE_FADED = "map_delete_faded";

		/**
		 * <img src='./icons/sitemap.png'/>
		 */
		public static final String SITEMAP = "sitemap";

		/**
		 * <img src='./icons/drive_burn_faded.png'/>
		 */
		public static final String DRIVE_BURN_FADED = "drive_burn_faded";

		/**
		 * <img src='./icons/sport_raquet.png'/>
		 */
		public static final String SPORT_RAQUET = "sport_raquet";

		/**
		 * <img src='./icons/shape_square_go.png'/>
		 */
		public static final String SHAPE_SQUARE_GO = "shape_square_go";

		/**
		 * <img src='./icons/clock_add.png'/>
		 */
		public static final String CLOCK_ADD = "clock_add";

		/**
		 * <img src='./icons/monitor_add.png'/>
		 */
		public static final String MONITOR_ADD = "monitor_add";

		/**
		 * <img src='./icons/ipod_sound_faded.png'/>
		 */
		public static final String IPOD_SOUND_FADED = "ipod_sound_faded";

		/**
		 * <img src='./icons/webcam_error.png'/>
		 */
		public static final String WEBCAM_ERROR = "webcam_error";

		/**
		 * <img src='./icons/control_fastforward_blue_faded.png'/>
		 */
		public static final String CONTROL_FASTFORWARD_BLUE_FADED = "control_fastforward_blue_faded";

		/**
		 * <img src='./icons/chart_bar_add.png'/>
		 */
		public static final String CHART_BAR_ADD = "chart_bar_add";

		/**
		 * <img src='./icons/camera_link.png'/>
		 */
		public static final String CAMERA_LINK = "camera_link";

		/**
		 * <img src='./icons/time_go_faded.png'/>
		 */
		public static final String TIME_GO_FADED = "time_go_faded";

		/**
		 * <img src='./icons/drive_rename.png'/>
		 */
		public static final String DRIVE_RENAME = "drive_rename";

		/**
		 * <img src='./icons/server_lightning.png'/>
		 */
		public static final String SERVER_LIGHTNING = "server_lightning";

		/**
		 * <img src='./icons/joystick.png'/>
		 */
		public static final String JOYSTICK = "joystick";

		/**
		 * <img src='./icons/shield_add_faded.png'/>
		 */
		public static final String SHIELD_ADD_FADED = "shield_add_faded";

		/**
		 * <img src='./icons/dvd_delete_faded.png'/>
		 */
		public static final String DVD_DELETE_FADED = "dvd_delete_faded";

		/**
		 * <img src='./icons/dvd_go.png'/>
		 */
		public static final String DVD_GO = "dvd_go";

		/**
		 * <img src='./icons/server_key_faded.png'/>
		 */
		public static final String SERVER_KEY_FADED = "server_key_faded";

		/**
		 * <img src='./icons/cup_delete_faded.png'/>
		 */
		public static final String CUP_DELETE_FADED = "cup_delete_faded";

		/**
		 * <img src='./icons/control_stop_blue_faded.png'/>
		 */
		public static final String CONTROL_STOP_BLUE_FADED = "control_stop_blue_faded";

		/**
		 * <img src='./icons/book_delete.png'/>
		 */
		public static final String BOOK_DELETE = "book_delete";

		/**
		 * <img src='./icons/cup_key.png'/>
		 */
		public static final String CUP_KEY = "cup_key";

		/**
		 * <img src='./icons/connect_faded.png'/>
		 */
		public static final String CONNECT_FADED = "connect_faded";

		/**
		 * <img src='./icons/heart_delete.png'/>
		 */
		public static final String HEART_DELETE = "heart_delete";

		/**
		 * <img src='./icons/email_go_faded.png'/>
		 */
		public static final String EMAIL_GO_FADED = "email_go_faded";

		/**
		 * <img src='./icons/table_link_faded.png'/>
		 */
		public static final String TABLE_LINK_FADED = "table_link_faded";

		/**
		 * <img src='./icons/feed_error_faded.png'/>
		 */
		public static final String FEED_ERROR_FADED = "feed_error_faded";

		/**
		 * <img src='./icons/ipod_cast_add.png'/>
		 */
		public static final String IPOD_CAST_ADD = "ipod_cast_add";

		/**
		 * <img src='./icons/text_heading_5.png'/>
		 */
		public static final String TEXT_HEADING_5 = "text_heading_5";

		/**
		 * <img src='./icons/dvd_faded.png'/>
		 */
		public static final String DVD_FADED = "dvd_faded";

		/**
		 * <img src='./icons/bullet_wrench.png'/>
		 */
		public static final String BULLET_WRENCH = "bullet_wrench";

		/**
		 * <img src='./icons/page_delete_faded.png'/>
		 */
		public static final String PAGE_DELETE_FADED = "page_delete_faded";

		/**
		 * <img src='./icons/world_edit_faded.png'/>
		 */
		public static final String WORLD_EDIT_FADED = "world_edit_faded";

		/**
		 * <img src='./icons/shape_square_go_faded.png'/>
		 */
		public static final String SHAPE_SQUARE_GO_FADED = "shape_square_go_faded";

		/**
		 * <img src='./icons/calendar_view_week_faded.png'/>
		 */
		public static final String CALENDAR_VIEW_WEEK_FADED = "calendar_view_week_faded";

		/**
		 * <img src='./icons/link_edit_faded.png'/>
		 */
		public static final String LINK_EDIT_FADED = "link_edit_faded";

		/**
		 * <img src='./icons/photo_add.png'/>
		 */
		public static final String PHOTO_ADD = "photo_add";

		/**
		 * <img src='./icons/page_white_visualstudio.png'/>
		 */
		public static final String PAGE_WHITE_VISUALSTUDIO = "page_white_visualstudio";

		/**
		 * <img src='./icons/chart_pie_link_faded.png'/>
		 */
		public static final String CHART_PIE_LINK_FADED = "chart_pie_link_faded";

		/**
		 * <img src='./icons/comment_edit.png'/>
		 */
		public static final String COMMENT_EDIT = "comment_edit";

		/**
		 * <img src='./icons/vector.png'/>
		 */
		public static final String VECTOR = "vector";

		/**
		 * <img src='./icons/basket.png'/>
		 */
		public static final String BASKET = "basket";

		/**
		 * <img src='./icons/chart_curve_delete_faded.png'/>
		 */
		public static final String CHART_CURVE_DELETE_FADED = "chart_curve_delete_faded";

		/**
		 * <img src='./icons/monitor_go_faded.png'/>
		 */
		public static final String MONITOR_GO_FADED = "monitor_go_faded";

		/**
		 * <img src='./icons/brick_edit.png'/>
		 */
		public static final String BRICK_EDIT = "brick_edit";

		/**
		 * <img src='./icons/table_row_insert.png'/>
		 */
		public static final String TABLE_ROW_INSERT = "table_row_insert";

		/**
		 * <img src='./icons/cd.png'/>
		 */
		public static final String CD = "cd";

		/**
		 * <img src='./icons/medal_silver_3.png'/>
		 */
		public static final String MEDAL_SILVER_3 = "medal_silver_3";

		/**
		 * <img src='./icons/eye_faded.png'/>
		 */
		public static final String EYE_FADED = "eye_faded";

		/**
		 * <img src='./icons/cursor_faded.png'/>
		 */
		public static final String CURSOR_FADED = "cursor_faded";

		/**
		 * <img src='./icons/camera_add.png'/>
		 */
		public static final String CAMERA_ADD = "camera_add";

		/**
		 * <img src='./icons/database_error.png'/>
		 */
		public static final String DATABASE_ERROR = "database_error";

		/**
		 * <img src='./icons/newspaper_link_faded.png'/>
		 */
		public static final String NEWSPAPER_LINK_FADED = "newspaper_link_faded";

		/**
		 * <img src='./icons/hourglass.png'/>
		 */
		public static final String HOURGLASS = "hourglass";

		/**
		 * <img src='./icons/email_faded.png'/>
		 */
		public static final String EMAIL_FADED = "email_faded";

		/**
		 * <img src='./icons/monitor_edit_faded.png'/>
		 */
		public static final String MONITOR_EDIT_FADED = "monitor_edit_faded";

		/**
		 * <img src='./icons/text_letterspacing_faded.png'/>
		 */
		public static final String TEXT_LETTERSPACING_FADED = "text_letterspacing_faded";

		/**
		 * <img src='./icons/mouse_faded.png'/>
		 */
		public static final String MOUSE_FADED = "mouse_faded";

		/**
		 * <img src='./icons/arrow_join_red.png'/>
		 */
		public static final String ARROW_JOIN_RED = "arrow_join_red";

		/**
		 * <img src='./icons/application_form_magnify.png'/>
		 */
		public static final String APPLICATION_FORM_MAGNIFY = "application_form_magnify";

		/**
		 * <img src='./icons/layout_edit.png'/>
		 */
		public static final String LAYOUT_EDIT = "layout_edit";

		/**
		 * <img src='./icons/user_add.png'/>
		 */
		public static final String USER_ADD = "user_add";

		/**
		 * <img src='./icons/user_gray_error.png'/>
		 */
		public static final String USER_GRAY_ERROR = "user_gray_error";

		/**
		 * <img src='./icons/tag_blue_edit.png'/>
		 */
		public static final String TAG_BLUE_EDIT = "tag_blue_edit";

		/**
		 * <img src='./icons/award_star_silver_3_faded.png'/>
		 */
		public static final String AWARD_STAR_SILVER_3_FADED = "award_star_silver_3_faded";

		/**
		 * <img src='./icons/group_edit_faded.png'/>
		 */
		public static final String GROUP_EDIT_FADED = "group_edit_faded";

		/**
		 * <img src='./icons/mouse_add_faded.png'/>
		 */
		public static final String MOUSE_ADD_FADED = "mouse_add_faded";

		/**
		 * <img src='./icons/door_out_faded.png'/>
		 */
		public static final String DOOR_OUT_FADED = "door_out_faded";

		/**
		 * <img src='./icons/page_white_gear.png'/>
		 */
		public static final String PAGE_WHITE_GEAR = "page_white_gear";

		/**
		 * <img src='./icons/film_error_faded.png'/>
		 */
		public static final String FILM_ERROR_FADED = "film_error_faded";

		/**
		 * <img src='./icons/brick_go_faded.png'/>
		 */
		public static final String BRICK_GO_FADED = "brick_go_faded";

		/**
		 * <img src='./icons/browser_camino_faded.png'/>
		 */
		public static final String BROWSER_CAMINO_FADED = "browser_camino_faded";

		/**
		 * <img src='./icons/monitor_faded.png'/>
		 */
		public static final String MONITOR_FADED = "monitor_faded";

		/**
		 * <img src='./icons/ruby_get.png'/>
		 */
		public static final String RUBY_GET = "ruby_get";

		/**
		 * <img src='./icons/sport_raquet_faded.png'/>
		 */
		public static final String SPORT_RAQUET_FADED = "sport_raquet_faded";

		/**
		 * <img src='./icons/mouse_error.png'/>
		 */
		public static final String MOUSE_ERROR = "mouse_error";

		/**
		 * <img src='./icons/weather_cloudy.png'/>
		 */
		public static final String WEATHER_CLOUDY = "weather_cloudy";

		public static ImageIcon get(String image) {
			URL url = Images.class.getResource("icons/" + image + ".png");

			if (url != null)
				return new ImageIcon(url);
			return null;
		}

	}

}
