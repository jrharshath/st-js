package test;

public class Declaration2 {
	int x = 0;

	B instanceB = null;
	{
		instanceB.y = 2;
	}

	class B {

		int y;

		void m() {
			x = y + x + Declaration2.this.z();
			x = this.z() + w();
		}

		int z() {
			return 3;
		}
	}

	int z() {
		return 2;
	}

	static int w() {
		return 5;
	}
}