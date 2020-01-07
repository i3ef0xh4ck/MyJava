package Java基础.JDK工具类;

import java.util.Calendar;
import java.util.Date;
import java.util.Formattable;
import java.util.Formatter;
import java.util.Locale;

public class Formatter_test implements  Formattable{
	
	
	/*
	 * 参考 : https://www.cnblogs.com/travellife/p/Java-zi-fu-chuan-ge-shi-hua-xiang-jie.html
	 * 
	 * 参数format的语法: (普通格式)
	 * 
	 *     %[argument_index$][flags][width][.precision]conversion

			argument_index: 可选，是一个十进制整数，用于表明参数在参数列表中的位置。第一个参数由 "1$" 引用，第二个参数由 "2$" 引用，依此类推。
			
			flags: 可选，用来控制输出格式
			
			width: 可选，是一个正整数，表示输出的最小长度
			
			precision:可选，用来限定输出的精度
			
			conversion:必须，用来表示如何格式化参数的字符
	 * 
	 * */
	public static void main(String[] args) {
		
		System.out.println("===================conversion=====================");
		/**
		 * conversion :  conversion 是用来表示如何格式化参数的字符。
		 * 
		 * %s 是一个占位符，s 是一个转换符，指明将参数格式化为字符串。值得注意的是，
		 * 占位符代表的格式化类型必须与参数的类型相兼容，否则运行时会抛出异常
		 * 
		 */
		System.out.println(String.format("'b':将参数格式化为boolean类型输出，'B'的效果相同,但结果中字母为大写。%b", false));
		System.out.println(String.format("'h':将参数格式化为散列输出，原理：Integer.toHexString(arg.hashCode())，'H'的效果相同,但结果中字母为大写。%h", "ABC"));
		System.out.println(String.format("'s':将参数格式化为字符串输出，如果参数实现了 Formattable接口，则调用 formatTo方法。'S'的效果相同。%s", 16));
		System.out.println(String.format("FormatImpl类实现了Formattable接口：%s", new Formatter_test()));
		System.out.println(String.format("'c':将参数格式化为Unicode字符，'C'的效果相同。%c", 'A'));
		System.out.println(String.format("'d':将参数格式化为十进制整数。%d", 11));
		System.out.println(String.format("'o':将参数格式化为八进制整数。%o", 9));
		System.out.println(String.format("'x':将参数格式化为十六进制整数。%x", 17));
		System.out.println(String.format("'e':将参数格式化为科学计数法的浮点数，'E'的效果相同。%E", 10.1));
		System.out.println(String.format("'f':将参数格式化为十进制浮点数。%f", 1.010000E+01));
		System.out.println(String.format("'g':根据具体情况，自动选择用普通表示方式还是科学计数法方式，'G'效果相同。10.01=%g", 10.01));
		System.out.println(String.format("'g':根据具体情况，自动选择用普通表示方式还是科学计数法方式，'G'效果相同。10.00000000005=%g", 10.00000000005));
		System.out.println(String.format("'a':结果被格式化为带有效位数和指数的十六进制浮点数，'A'效果相同,但结果中字母为大写。%a", 10.1));
		System.out.println(String.format("'t':时间日期格式化前缀，会在后面讲述"));
		System.out.println(String.format("'%%':输出%%。%%"));
		System.out.println(String.format("'n'平台独立的行分隔符。System.getProperty(\"line.separator\")可以取得平台独立的行分隔符，但是用在format中间未免显得过于烦琐了%n已经换行"));
		
		System.out.println("==================argument_index=====================");
		/**
		 * 恩，这样做输出的确没错，但是我们却重复输入参数“小明”。这里，就要用到 argument_index 这个参数。
		 * 使用 argument_index 可以指定使用第几个参数来替换占位符，一旦使用 argument_index 用于指出
		 * 参数在参数列表中位置，则所有占位符都要加上
		 */
		System.out.println(String.format("大家好，我叫：%s，今年：%d岁。%s是%s的爸爸。", "小明", 25, "小明", "小小明"));
		
		/*argument_index的妙用,数字+美元符 ==> 放到%号后面,表示要用第几个参数*/
		System.out.println(String.format("大家好，我叫：%1$s，今年：%2$d岁。%1$s是%3$s的爸爸。", "小明", 25, "小小明"));
		
		
		/**
		 * flags
		 * 
		 *  	flags是可选参数，用于控制输出的格式，比如左对齐、金额用逗号隔开。
		 *   
		 *     '-' 在最小宽度内左对齐，不可以与“用0填充”同时使用
         *
		 *	   '+' 结果总是包括一个符号
			
		 *	   ' ' 正值前加空格，负值前加负号
			
		 *	   '0' 结果将用零来填充
			
		 *    ',' 每3位数字之间用“，”分隔(只适用于fgG的转换)
			
		 *	  '(' 若参数是负数，则结果中不添加负号而是用圆括号把数字括起来(只适用于eEfgG的转换)
		 * 
		 */
		   System.out.println();
		   System.out.println("===============flags : ====================");
		   System.out.println("'-':在最小宽度内左对齐，不可与\"用0填充\"同时使用。");
		   System.out.println(String.format("设置最小宽度为8为，左对齐。%-8d:%-8d:%-8d%n", 1, 22, 99999999));
		   System.out.println(String.format("'0':结果将用零来填充。设置最小宽度为8，%08d:%08d:%08d", 1, -22, 99999990));
		   System.out.println(String.format("'+':结果总是包括一个符号。%+d:%+d:%+d", 1, -2, 0));
		   System.out.println(String.format("' ':正值前加空格，负值前加负号。% d:% d:% d", 1, -2, 0));
		   System.out.println(String.format("',':每3位数字之间用“，”分隔(只适用于fgG的转换)。%,d:%,d:%,d", 1, 100, 1000));
		   System.out.println(String.format("'(':若参数是负数，则结果中不添加负号而是用圆括号把数字括起来(只适用于eEfgG的转换)。%(d:%(d", 1, -1));
		   
		   /**
		    * width是可选参数，用于控制输出的宽度。示例如下：
		    * 但是 width 的值不能为 0 ，否则会抛出 . 
		    */
		   System.out.println();
		   System.out.println("===============width : ====================");
		   System.out.println(String.format("设置最小宽度为8，不满8位用0填充：%08d:%08d", 1, -10000000));
		   
		   /**
		    * precision
				precision是可选参数，用来限定输出的精度，用于浮点数,四舍五入
				语法  :  . + 位数
		    */
		   System.out.println(String.format("设置精度为2位：%.2f", 3.26544));
		   
		   
		   /*
		    * 日期格式化format语法:
		    *  
		    *   %[argument_index$][flags][width]conversion
		    * 
		    *   相对于普通的格式，时间日期格式化少了 precision ，而 conversion 是由两个字符组成，且第一个字符固定为 t 或 T 。
		    * */
		   System.out.println("===============时分秒格式化 : ====================");
		   Calendar calendar = Calendar.getInstance();
		   System.out.println(String.format("'H':2位数24小时制，不足两位前面补0：%tH（范围：00-23）", calendar));
		   System.out.println(String.format("'I':2位数12小时制，不足两位前面补0：%tI（范围：01-12）", calendar));
		   System.out.println(String.format("'k':24小时制，不足两位不补0：%tk（范围：0-23）", calendar));
		   System.out.println(String.format("'l':12小时制，不足两位不补0：%tl（范围：1-12）", calendar));
		   System.out.println(String.format("'M':2位数的分钟，不足两位前面补0：%tM（范围：00-59）", calendar));
		   System.out.println(String.format("'S':分钟中的秒，2位数，不足两位前面补0，60是支持闰秒的一个特殊值：%tS（范围：00-60）", calendar));
		   System.out.println(String.format("'L':3位数的毫秒，不足三位前面补0：%tL（范围：000-999）", calendar));
		   System.out.println(String.format("'N':9位数的微秒，不足九位前面补0：%tN（范围：000000000-999999999）", calendar));

		   System.out.println(String.format("'p':输出本地化的上午下午，例如，Locale.US为am或pm，Locale.CHINA为上午或下午", calendar));
		   System.out.println(String.format(Locale.US, "Local.US=%tp", calendar));
		   System.out.println(String.format(Locale.CHINA, "Local.CHINA=%tp", calendar));
		   System.out.println();

		   System.out.println(String.format("'z':时区：%tz", calendar));
		   System.out.println(String.format("'Z':时区缩写字符串：%tZ", calendar));
		   System.out.println(String.format("'s':从1970-1-1 00:00到现在所经历的秒数：%ts", calendar));
		   System.out.println(String.format("'Q':从1970-1-1 00:00到现在所经历的豪秒数：%tQ", calendar));
		   
		   System.out.println("===============日期格式化 : ====================");
		   //%tH:%tM的缩写
		    System.out.println(String.format("'R':将时间格式化为：HH:MM（24小时制）。输出：%tR", calendar));
		    //%tH:%tM:%tS的缩写
		    System.out.println(String.format("'T':将时间格式化为：HH:MM:SS（24小时制）。输出：%tT", calendar));
		    //%tI:%tM:%tS %Tp的缩写，输出形如：
		    System.out.println(String.format("'r':将时间格式化为：09:23:15 下午，跟设置的语言地区有关。输出：%tr", calendar));
		    //%tm/%td/%ty的缩写，输出形如
		    System.out.println(String.format("'D':将时间格式化为：10/19/16。输出：%tD", calendar));
		    //%tY-%tm-%td，输出形如：
		    System.out.println(String.format("'F':将时间格式化为：2016-10-19。输出：%tF", calendar));
		    //%ta %tb %td %tT %tZ %tY，输出形如：Sun Jul 20 16:17:00 EDT 1969
		    System.out.println(String.format("'c':将时间格式化为\"Sun Jul 20 16:17:00 EDT 1969\"。输出：%tc", calendar));
		    
		    System.out.println("===============格式化时间练习 : ====================");
		    
		    Date now = new Date();
		    System.out.println(String.format("%1$tF %1$tT", calendar , calendar));
		    System.out.println(String.format("%1$tF %1$tT", now));
		    System.out.println(String.format("%1$tF 23:59:59", now));
	}

	@Override
	public void formatTo(Formatter formatter, int flags, int width, int precision) {
		System.out.println("草泥马");
	}
	
	
}
