# 1. 스 캔

```Java
import java.util.Scanner;

패턴 1
Scanner sc = new Scanner(System.in);

String str = sc.next();

패턴 2
Scanner sc = new Scanner(System.in);

int[] intArr = new int[5];
System.out.println("배열에 저장할 숫자를 입력해주세요>>");
for(int i=0; i<intArr.length; i++) {
	intArr[i] = sc.nextInt();
}
```

# 2. 메 소 드 

```Java
int[] a = new int[5];
// 1 2 3 4 5

Item item1 = new Item();
// 일반적인 메소드 작성

ArrayList<String> list = new ArrayList<>();
// 김씨 컴공 컴컴 스트링만 가능

ArrayList<Student> list = new ArrayList<>();
// 김씨 컴공 4 1.2 Student 클래스를 만들어서 그 안에 String이나 int나 double이나 다 넣을 수 있음 

/* 넣는 방법
한줄로 넣기 : list.add(new Student("길동", "컴공", 1, 1.1)); 

모아서 넣기 :
String name = sc.next();
String major = sc.next();
int num = sc.nextInt();
double score = sc.nextDouble();

Student s = new Student(name, major, num, score);
list.add(s);
*/

```
