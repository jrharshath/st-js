package test;

import static test.Bean1.stat;

@SuppressWarnings("unused")
public class Declaration1 {
	int param = 1;
	int var = 2;
	int type = 3;
	int out = 4;
	int imp = 5;
	int stat2 = 6;

	public void x(int param) {
		int var = 11;
		int exp1 = param + var + type + out + imp + stat + stat2;
		int exp2 = Bean1.stat;
		new Runnable() {
			int type = 1;

			@Override
			public void run() {
				int exp3 = type + 1;
				int exp4 = this.type + 1;
				int exp5 = out + Declaration1.this.type + 1;
			}
		};
	}
}