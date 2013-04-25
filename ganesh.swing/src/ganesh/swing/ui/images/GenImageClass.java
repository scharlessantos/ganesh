/* Ganesh Swing Client, developed in 2013 */
package ganesh.swing.ui.images;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

class GenImageClass {

	//Geração automática desta classe
	public static void main(String[] args) {

		try {
			FileWriter fw = new FileWriter(new File("src/ganesh/swing/ui/images/Images.java"));

			fw.append("/* Ganesh Swing Client, developed in 2013 */\n");
			fw.append("package ganesh.swing.ui.images;\n");
			fw.append("\n");
			fw.append("import java.net.URL;\n");
			fw.append("import javax.swing.ImageIcon;\n");
			fw.append("\n");
			fw.append("\npublic class Images {\n");
			fw.append("\n");

			//Geral
			File files = new File("src/ganesh/swing/ui/images/general");

			writeContants(fw, files);

			//flags
			fw.append("\n\n\n//============================\n// Bandeiras\n//============================\n\n");
			files = new File("src/ganesh/swing/ui/images/flags");

			fw.append("\n\n");
			fw.append("public static class Flags {");

			writeContants(fw, files);

			fw.append("\n}\n");

			//icones
			files = new File("src/ganesh/swing/ui/images/icons");

			fw.append("\n\n\n//============================\n// Icones\n//============================\n\n");
			fw.append("public static class Icons {");

			writeContants(fw, files);

			fw.append("\n}\n");

			//fecha a classe
			fw.append("\n}\n");
			fw.flush();
			fw.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private static void writeContants(FileWriter wr, File folder) throws IOException {
		for (File f: folder.listFiles()) {
			String name = f.getName().replace(".png", "");
			wr.append("\n");
			wr.append("/**\n");
			wr.append("<img src='./" + folder.getName() + "/" + f.getName() + "'/> \n");
			wr.append("*/\n");
			wr.append("public static final String " + name.toUpperCase() + " = \"" + name + "\";\n\n");
		}

		wr.append(getImageGetter(folder.getName()));
		wr.append("\n");
	}

	private static String getImageGetter(String folder) {
		StringBuilder sb = new StringBuilder();
		sb.append("public static ImageIcon get(String image) {\n");
		sb.append("URL url = Images.class.getResource(\"" + folder + "/\" + image + \".png\");\n");
		sb.append("\n");
		sb.append("if (url != null)\n");
		sb.append("return new ImageIcon(url);");
		sb.append("\n");
		sb.append("return null;\n");
		sb.append("}\n");
		sb.append("\n");

		return sb.toString();
	}
}
