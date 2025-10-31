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

/*
복사해서 새로 실행할 때 주의할 점들 간단히 정리해드릴게요!

1. package 선언 문제

원본 코드에 package practice2;가 있으면
해당 코드는 프로젝트 폴더 내 practice2 폴더(패키지)에 위치해야 합니다.

만약 프로젝트 구조가 다르거나 패키지를 안 쓰고 싶으면
package practice2; 라인을 삭제하세요.

2. 클래스 이름과 파일 이름 일치 여부

자바는 public 클래스 이름과 파일 이름이 같아야 합니다.
예를 들어 public class Q2면 파일명은 Q2.java여야 해요.

복사 붙여넣기해서 파일 이름을 바꾸면 클래스 이름도 같이 바꾸는 걸 추천합니다.

3. import 구문 확인

import java.util.Scanner;는 꼭 있어야 하고,
누락하면 Scanner를 못 씁니다.

보통 자동완성되지만, 혹시 복사할 때 빠지지 않았는지 확인하세요.

4. public 접근제어자

보통 한 파일에 public 클래스는 하나만 있어야 합니다.

새 파일에 붙여넣을 때 public이 중복되지 않는지 확인하세요.

5. main 메서드와 실행 환경

public static void main(String[] args) 메서드가 있어야 자바 애플리케이션으로 실행 가능.

복사한 코드에 main 메서드가 없으면 실행 안 됩니다.

*/
