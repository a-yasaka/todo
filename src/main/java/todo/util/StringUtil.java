package todo.util;

public class StringUtil {
	public static String changeBr(String str){
		str=str.replaceAll("\r\n|\r|\n", "<br />");
		return str;
	}
}
