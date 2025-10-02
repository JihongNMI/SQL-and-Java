# 1. -1 % 2 = -1 ( 1이 아님 )
mod 연산 음수

# 2. 10^k 안됌
(int) Math.pow(10, k)를 써야함

아 그리고 로그 쓰는거 생각 못했네

# 3. if(...) int a = 1; 가 안됨
변수 선언은 괄호가 필요하다고 함

# 3-1. 3항연산자도 안됨 (num1 == num2) ? int a = 1 : int a = -1;
int answer = (조건) ? 1 : -1; ✅ 가능	가장 일반적인 사용 방식

return (조건) ? 1 : -1;	✅ 가능

# 4. 배열 길이 = for(int k=0; k<배열.length; k++)
근데 for-each라는게 있어서 그거랑 같다고 함 for (int k : numbers) {

그건 나중에 배울듯

스트림을 응용하는 것도 나중에 배울 듯

# 5. 코테에서 배열 말인데

처음에 int[] answer = {};라고 되어있는거 그대로 쓰면(빈 배열을 그대로 만들어 둘려면)

Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException: Index 0 out of bounds for length 0

에러가 남

int[] answer = new int[2];

로 하거나 해야 함


# 6. 코테에서 while 말인데

do 안에서 임시로 쓰려고 만든 변수는
```
do{
  int a = 1;
}while(a != 1);
```
while에서 못써서 밖으로 빼야 함
