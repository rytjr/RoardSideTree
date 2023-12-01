package RoadSideTreeAdd;

import java.util.*;

/*문제
직선으로 되어있는 도로의 한 편에 가로수가 임의의 간격으로 심어져있다. 
KOI 시에서는 가로수들이 모두 같은 간격이 되도록 가로수를 추가로 심는 사업을 추진하고 있다.
 KOI 시에서는 예산문제로 가능한 한 가장 적은 수의 나무를 심고 싶다.

편의상 가로수의 위치는 기준점으로 부터 떨어져 있는 거리로 표현되며, 가로수의 위치는 모두 양의 정수이다.

예를 들어, 가로수가 (1, 3, 7, 13)의 위치에 있다면 (5, 9, 11)의 위치에 가로수를 더 심으면 모든 가로수들의 간격이 같게 된다. 
또한, 가로수가 (2, 6, 12, 18)에 있다면 (4, 8, 10, 14, 16)에 가로수를 더 심어야 한다.

심어져 있는 가로수의 위치가 주어질 때, 모든 가로수가 같은 간격이 되도록 새로 심어야 하는 가로수의 최소수를 구하는 프로그램을 작성하라. 
단, 추가되는 나무는 기존의 나무들 사이에만 심을 수 있다.

입력
첫째 줄에는 이미 심어져 있는 가로수의 수를 나타내는 하나의 정수 N이 주어진다(3 ≤ N ≤ 100,000). 
둘째 줄부터 N개의 줄에는 각 줄마다 심어져 있는 가로수의 위치가 양의 정수로 주어지며, 
가로수의 위치를 나타내는 정수는 1,000,000,000 이하이다. 가로수의 위치를 나타내는 정수는 모두 다르고, 
N개의 가로수는 기준점으로부터 떨어진 거리가 가까운 순서대로 주어진다.

출력
모든 가로수가 같은 간격이 되도록 새로 심어야 하는 가로수의 최소수를 첫 번째 줄에 출력한다.*/

//이 문제는 가로수 사이의 간격이 일정하면서 최소한으로 가로수를 세우는 문제로 최소 공약수를 이용해 풀수 있었다.


public class RoadSideTreeAdd {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int Num = sc.nextInt();
		
		int[] arr = new int[Num];
		int[] arr2 = new int[Num - 1];
		
		for(int i = 0; i < Num; i++) {
			arr[i] = sc.nextInt();
		}
		
		for(int i = 0; i < Num - 1; i++) {
			arr2[i] = arr[i + 1] - arr[i];
		}
		
		//최소 공약수를 구하기 위한 식
		int min = arr2[0];
		for(int i = 0; i < Num - 1; i++) {
			if(min > arr2[i]) {
				min = GCD(arr2[i], min);
			}
			else {
				min = GCD(min, arr2[i]);
			}
		}
		
		System.out.print((arr[Num - 1] - arr[0]) / min - Num + 1);
	}
	
	//최소 공약수를 구하는 공식인 유클리드 호제법을 사용
	public static int GCD(int min, int max) {
		if(min == 0) 
			return max;
		else {
			return GCD(max % min, min);
		}
	}
	

}
