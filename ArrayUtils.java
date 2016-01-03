// Jessica Yang
// APCS1 pd9
// HW27 -- Objectify Your Array Tools
// 2015-11-09

public class ArrayUtils {

	// populates an existing array with randomly generated ints within a certain range
	public static Object[] populate(Object[] array, int lower, int upper) {
		for (int x = 0; x < array.length; x++) {
			array[x] = (int)(lower + Math.random() * (upper - lower));
		}
		return array;
	}

	// returns a String version of an array of ints
	public static String arrayToStr(Object[] array) {
		String strArray = "";
		for (int x = 0; x < array.length; x++) {
			strArray += array[x] + ", ";
		}
		return strArray.substring(0, strArray.length() - 2);
	}

	// helper fxn for recursion to make new array with all elements but the first
	public static Object[] cdr(Object[] a) {
		Object[] newA = new Object[a.length - 1];
		for (int x = 0; x < newA.length; x++) {
			newA[x] = a[x + 1];
		}
		return newA;
	}

	// a linear search function that will return the index of the first occurrence of a target in an existing array, or -1 if not found (iterative)
	public static int linSearch(Object[] a, Object target) {
		for (int x = 0; x < a.length; x++) {
			if (a[x] == target) {
				return x;
			}
		}
		return -1;
	}

	// a linear search function that will return the index of the first occurrence of a target in an existing array, or -1 if not found (recursive)
	public static int linSearchR(Object[] a, Object target) {
		if (freq(a, target) == 0) {
			return -1;
		}
		if (a[0] == target) {
			return 0;
		}
		return 1 + linSearchR(cdr(a), target);
	}

	// a frequency function that will return the number of occurrences of a target in an existing array (iterative)
	public static int freq(Object[] a, Object target) {
		int occ = 0;
		if (linSearch(a, target) == -1) {
			return occ;
		}
		for (int x = 0; x < a.length; x++) {
			if (a[x] == target) {
				occ += 1;
			}
		}
		return occ;
	}

	// a frequency function that will return the number of occurrences of a target in an existing array (recursive)
	public static int freqRec(Object[] a, Object target) {
		int occ = 0;
		if (linSearch(a, target) == -1) {
			return occ;
		} else {
			if (a[0] == target) {
				occ += 1;
			}
			return freqRec(cdr(a), target) + occ;
		}
	}

	// main method for testing
	public static void main(String[] args) {
	    Object[] intArr = new Integer[5];
	    intArr = populate(intArr, 0, 100);
		System.out.println("\n======INT ARRAY=====");
		for (int i = 0; i < intArr.length; i++) {
			System.out.println("intArr[" + i + "] = " + intArr[i]);
		}
		System.out.println("arrayToStr(intArr):\t" + arrayToStr(intArr) +
			"\nlinSearch(intArr,6):\t" + linSearch(intArr, 6) +
			"\nfreq(intArr, 7):\t" + freq(intArr, 7) + "\n");
			
		Object[] strArr = {"1", "23", "45", "6", "789"};
		System.out.println("=====STR ARRAY=====");
		for (int i = 0; i < strArr.length; i++) {
			System.out.println("strArr[" + i + "] = " + strArr[i]);
		}
		System.out.println("arrayToStr(strArr):\t" + arrayToStr(strArr) +
			"\nlinSearch(strArr, \"6\"):\t" + linSearch(strArr, "6") +
			"\nfreq(strArr, \"7\"):\t" + freq(strArr, "7") + "\n");
	}

}