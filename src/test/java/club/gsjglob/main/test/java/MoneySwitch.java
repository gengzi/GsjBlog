package club.gsjglob.main.test.java;

import org.junit.Test;

/**
 * 测试枚举类型
 * 
 * @author gengzi
 *
 */
public class MoneySwitch {

	@Test
	public void fun01() {
		// 循环打印枚举类型
		MoneyENUM yuan = MoneyENUM.YUAN;
		System.out.println(yuan.toString()); // 重写了 objcet 的toString

		for (MoneyENUM enumstr : MoneyENUM.values()) {
			System.out.println(enumstr + ":出现的顺序" + enumstr.ordinal());
			// enumstr.ordinal() 该enum 在enum 中定义的顺序
		}
	}

	public void panduan(MoneyENUM money) {
		// 循环打印枚举类型
		switch (money) {
		// switch 是在有限的集合内进行选择，与 enum 是绝佳的组合
		case YUAN:
			System.out.println("元");
			break;
		case JIAO:
			System.out.println("角");
			break;
		case FEN:
			System.out.println("分");
			break;
		}
	}

	@Test
	public void fun03() {
		MoneyENUM yuan = MoneyENUM.YUAN;
		panduan(yuan);
	}

}