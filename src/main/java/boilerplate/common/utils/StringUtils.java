/**
 * This class was created by BrassGoggledCoders modding team.
 * This class is available as part of the BoilerCraft Mod for Minecraft.
 *
 * BoilerCraft is open-source and is distributed under the MMPL v1.0 License.
 * (http://www.mod-buildcraft.com/MMPL-1.0.txt)
 *
 */
package boilerplate.common.utils;

import java.util.Enumeration;
import java.util.Vector;

import net.minecraft.util.StatCollector;

/**
 * @author warlordjones
 * 
 */
public final class StringUtils
{
	public static String camelCase(final String input)
	{
		return input.substring(0, 1).toLowerCase() + input.substring(1);
	}

	public static String titleCase(final String input)
	{
		return input.substring(0, 1).toUpperCase() + input.substring(1);
	}

	public static String localize(final String key)
	{
		return StatCollector.translateToLocal(key);
	}

	@SuppressWarnings("all")
	public static String[] wrap(String input, int len)
	{
		// return empty array for null text
		if (input == null)
			return new String[] {};

		// return text if len is zero or less
		if (len <= 0)
			return new String[] { input };

		// return text if less than length
		if (input.length() <= len)
			return new String[] { input };

		char[] chars = input.toCharArray();
		Vector lines = new Vector();
		StringBuffer line = new StringBuffer();
		StringBuffer word = new StringBuffer();

		for (char c : chars)
		{
			word.append(c);

			if (c == ' ')
			{
				if ((line.length() + word.length()) > len)
				{
					lines.add(line.toString());
					line.delete(0, line.length());
				}

				line.append(word);
				word.delete(0, word.length());
			}
		}

		// handle any extra chars in current word
		if (word.length() > 0)
		{
			if ((line.length() + word.length()) > len)
			{
				lines.add(line.toString());
				line.delete(0, line.length());
			}
			line.append(word);
		}

		// handle extra line
		if (line.length() > 0)
		{
			lines.add(line.toString());
		}

		String[] ret = new String[lines.size()];
		int c = 0; // counter
		for (Enumeration e = lines.elements(); e.hasMoreElements(); c++)
		{
			ret[c] = (String) e.nextElement();
		}

		return ret;
	}

	/**
	 * This method merges any number of arrays of any count.
	 * 
	 * @param arrays
	 * @return merged array
	 */
	@Deprecated
	public static String[] merge(String[]... arrays)
	{
		return Utils.merge(arrays);
	}
}