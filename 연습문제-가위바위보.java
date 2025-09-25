/* 
8. 조건문과 반복문을 이용하여 가위바위보 게임을 만들어보세요.
5번을 이겼을 경우 게임이 끝나게 되며 한번 가위바위보를 실행할 때마다 사
람과 컴퓨터의 가위바위보 내용 , , , 승패 승리 횟수 패배 횟수를 출력합니다.
------- ---------- 실행결과
가위 바위 보 중에 (1), (2), (3) 선택해주세요. >> 1
플레이어 가위 vs : 바위 컴퓨터 패배
승리 패배 : 0/5 , : 1
가위 바위 보 , , 중에 선택해주세요 바위 . >>
플레이어 바위 vs : 가위 컴퓨터 승리
승리 패배 : 1/5 , :

---------------

이겼음
가위1-보3 = -2
바위2-가위1 = 1
보3-바위2 = 1

졌음
가위1-바위2 = -1
바위2-보3 = -1
보3-가위1 = 2

*/		

package practice2;

import java.util.Scanner;

public class Q2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		int player_win = 0, player_lose = 0;
		String[] gbb = {"가위", "바위", "보"};

		Scanner sc = new Scanner(System.in);		
		do {
			System.out.println("가위 바위 보 중에 (1), (2), (3) 선택해주세요. >>");
			int player = sc.nextInt();
			int computer = (int)(Math.random()*3+1);
			
			if( (player-computer)==1 || (player-computer)==-2 ) player_win++;
			else if( (player-computer)==-1 || (player-computer)==2 ) player_lose++;
			
			System.out.println(
			player + gbb[player-1] + " "+
			computer + gbb[computer-1]+ " " +
			player_win + "승/" + player_lose + "패");
			
		}while(player_win<2 && player_lose<2);
		
		if(player_win==2) System.out.println("이겼음");
		if(player_lose==2) System.out.println("졌지만 잘");
				
	}
}

/* 감상
처음엔 mod만으로 해결할 수 있다고 생각했는데 잘 안되서
특징 : 승리 = -2, 1 / 패배 = -1, 2 
를 조건으로 처리함

안에서 지정한 변수는 안에서만 : do 블록 안에서 선언된 이 변수들은, 이 영역(스코프) 안에서
반복될 때마다 생성되고, 반복이 끝나면 사라진다
*/		
