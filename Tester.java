import java.util.*;
import java.io.*;
public class Tester {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		int n = 0;
		String []names = new String [11];
		int []ages = new int[11];
		Scanner fs = new Scanner(new File("E:\\AP Comp Sci\\MultiKeySort\\src\\names_ages.txt"));
		while(fs.hasNext()){
			names[n] = fs.next();
			ages[n] = fs.nextInt();
			n++;
		}
		fs.close();
		sort(names, ages);
		for (int i = 0; i < names.length; i++){
			System.out.print(names[i] + ", " + ages[i]);
			System.out.println();
		}
	}
	public static void sort(String []a, int []b){
		int x = 0;
		String s;
		int minIndex, min;
		for (int n = 0; n < a.length; n++){
			min = b[n];
			s = a[n];
			minIndex = n;
			for (int i = n + 1; i < a.length; i++){
				if (a[i].charAt(x) < s.charAt(x)){
					min = b[i];
					s = a[i];
					minIndex = i;
				}
				else {
					while (a[i].charAt(x) == s.charAt(x) && x < a[i].length() - 1 && x < s.length() - 1){
						x++;
						if (a[i].charAt(x) < s.charAt(x)){
							min = b[i];
							s = a[i];
							minIndex = i;
						}
					}
				}
				x = 0;
			}
			a[minIndex] = a[n];
			b[minIndex] = b[n];
			b[n] = min;
			a[n] = s;
		}
		int n = 0;
		while (n < a.length - 1){
			int end = n + 1;
			if (a[n].equals(a[n+1])){
				int i = n + 1;
				while(a[n].equals(a[i])){
					end++;
					i++;
				}
				sortInt(b,n,end);
			}
			n = end;
		}
	}
	public static void sortInt(int []a, int start, int end){
		int min, minIndex;
		for (int i = start; i < end; ++i){
			min = a[i];
			minIndex = i;
			for (int j = i + 1; j < a.length; ++j){
				if (a[j] < min){
					min = a[j];
					minIndex = j;
				}
			}
			a[minIndex] = a[i];
			a[i] = min;
		}
	}

}
