package random.rotate.word.by.count;

public class Main {
	enum DIRECTION {
		RIGHT, LEFT
	}

	public static void main(String[] args) {
		char[] word = "Hello".toCharArray();
		int count = 2;
		DIRECTION d = DIRECTION.LEFT;
		if (args.length > 0) {
			word = args[0].toCharArray();
			count = Integer.parseInt(args[1]);
			if (args.length > 2 && args[3].equals("left")) {
				d = DIRECTION.LEFT;
			}
		}
		System.out.println("Rotated: " + new String(Main.rotatedWord(word, count, d)));
	}

	public static char[] rotatedWord(char[] word, int count, DIRECTION d) {
		char[] tmp = new char[2 * word.length];
		for (int i = 0; i < tmp.length; i++) {
			tmp[i] = word[i % (word.length)];
		}
		switch (d) {
		case RIGHT:
			System.arraycopy(tmp, count, word, 0, word.length);
			break;
		case LEFT:
			System.arraycopy(tmp, word.length - count, word, 0, word.length);
			break;
		default:
			break;
		}

		
		
		return word;
	}

}
