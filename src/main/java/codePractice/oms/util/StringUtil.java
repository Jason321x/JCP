package main.java.codePractice.oms.util;


import java.lang.reflect.UndeclaredThrowableException;
import java.math.BigDecimal;
import java.nio.charset.Charset;
import java.util.BitSet;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

/**
 * @author guanyun.yue
 */
public class StringUtil {

	public static final Charset UTF_8 = Charset.forName("UTF-8");
	private static final BitSet URLEncodeSafe = new BitSet();

	public static final String TRUE = "1";
	public static final String FALSE = "0";
	public static final String ERROR = "-1";
	public static final String SEPARATOR = "_";
	public static final String SEPARATOR_1 = ";";

	public static String uuid() {
		return UUID.randomUUID().toString().replaceAll("-", "");
	}

	public static String trimChar(String str) {
		if (str == null) {
			return null;
		}
		return str.replaceAll("[\n\r\t]", " ")
				.trim();
	}
}

