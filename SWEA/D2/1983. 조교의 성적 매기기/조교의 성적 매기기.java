import java.util.*;
import java.util.stream.Stream;
import java.io.*;

class Solution
{
	public static void main(String args[]) throws Exception
	{

		//System.setIn(new FileInputStream("res/input.txt"));


		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
			int N = sc.nextInt();
			int K = sc.nextInt();
			
			double [] results = new double[N];			
			for(int i=0;i<N;i++) {
				int midExam = sc.nextInt();
				int finalExam = sc.nextInt();
				int report = sc.nextInt();
				
				results[i] = (midExam * 0.35) + (finalExam * 0.45) + (report * 0.2);
			}
			
			double wantStudentResult = results[K-1];
			
			Arrays.sort(results);
			
			int resultRanking = 0;
			for(int i=0;i<N;i++) {
				if(wantStudentResult == results[i]) {
					resultRanking = i / (N/10);
					break;
				}
			}
			
			System.out.printf("#%d %s\n", test_case, Grade.getGrade(resultRanking));
		}
	}
	public static enum Grade {
		D("D0"),
		C_MINUS("C-"),
		C("C0"),
		C_PLUS("C+"),
		B_MINUS("B-"),
		B("B0"),
		B_PLUS("B+"),
		A_MINUS("A-"),
		A("A0"),
		A_PLUS("A+");
		
		private final String grade;
		private Grade(String grade) {
			this.grade = grade;
		}
		
		static public String getGrade(int index) {
			Grade [] grades = values();
			for(Grade grade : grades) {
				if(grade.ordinal() == index)
					return grade.grade;
			}
			return "";
		}
	}
}