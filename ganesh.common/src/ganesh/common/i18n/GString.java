/* Ganesh Commons, developed in 2013 */
package ganesh.common.i18n;

import java.util.Arrays;

public final class GString {

	private final String format;
	private final Object[] args;

	public GString(String str) {
		format = str;
		args = null;
	}

	public GString(String format, Object... args) {
		String.format(format, args);
		this.format = format;
		this.args = args;
	}

	@Override
	public int hashCode() {
		if (args == null)
			return format.hashCode();
		else
			return 31 * format.hashCode() + Arrays.hashCode(args);
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof GString) {
			GString o = (GString)obj;
			if (args == null)
				return o.args == null && format.equals(o.format);
			else
				return format.equals(o.format) && Arrays.equals(args, o.args);
		} else
			return false;
	}

	@Override
	public String toString() {
		return GaneshI18n.translate(format, args);
	}

}
