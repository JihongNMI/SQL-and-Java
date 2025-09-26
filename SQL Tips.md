# 1. [간단]현재 로그인한 계정이 소유한 테이블 : 
✅
SELECT table_name FROM user_tables;
SELECT table_name FROM tabs;

# 2. 현재 사용자 확인
SELECT USER FROM dual;
>다른 사용자가 접속해 있더라도 그 사람의 USER는 보이지 않습니다

SELECT username, status, osuser, machine, program FROM v$session WHERE username IS NOT NULL;
>현재 사용자 전체 확인(권한)

# 3. 조절
COLUMN ENAME FORMAT A11

SET LINESIZE 250

SET PAGESIZE 50

# 4. 현재 스키마 확인

SELECT username FROM all_users ORDER BY username;

>스키마 변경 : ALTER SESSION SET CURRENT_SCHEMA = 스키마명;

>전 테이블 소유자 확인
SELECT owner, table_name FROM all_tables ORDER BY owner, table_name;

>스콧이 가진 테이블
SELECT table_name FROM all_tables WHERE owner = 'SCOTT';

객체 : SELECT object_name FROM user_objects WHERE object_type = 'TABLE';

# 5. 컬럼 데이터 타입 확인 : DESC EMP;

NUMBER(4)	최대 4자리 정수	1234, 42 등

VARCHAR2(n)	최대 n자 가변 길이 문자열	"Hello", "Java" 등
>VARCHAR: 표준 SQL 문자열 타입 (길이 가변), VARCHAR2: Oracle 전용, 거의 같은 기능이지만 Oracle에서는 VARCHAR 타입은 예약어로만 남겨두고, 실제로는 VARCHAR2를 사용해요. 다른 DBMS에서는 그냥 VARCHAR를 씁니다.

NUMBER(7,2)	총 7자리 숫자 중 소수점 아래 2자리 포함

# 0. 기타 팁
echo %path%


모르겠음 : HELP COLUMN








