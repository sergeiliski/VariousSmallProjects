public class Subset {
	public static void main(String[] args) {
		int k = Integer.parseInt(args[0]);
		String[] temp = null;
		RandomizedQueue<String> queue = new RandomizedQueue<>();

		if (StdIn.hasNextLine()) {
			temp = StdIn.readLine().split(" ");
		}

		int count = 0;

		for (int i = 0; i < temp.length; i++) {
			queue.enqueue(temp[count]);
			count++;
		}

		while (k > 0) {
			StdOut.println(queue.dequeue());
			k--;
		}
	}
}
