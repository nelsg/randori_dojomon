package dojomon;

public class MonstreHelper {
	public int genValue(int start, int end) {
		return start + (int) (Math.random() * (end - start)) ;
	}
}