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




# 3. >현재 스키마 확인

SELECT username FROM all_users ORDER BY username;

>스키마 변경 : ALTER SESSION SET CURRENT_SCHEMA = 스키마명;

>전 테이블 소유자 확인
SELECT owner, table_name FROM all_tables ORDER BY owner, table_name;

>스콧이 가진 테이블
SELECT table_name FROM all_tables WHERE owner = 'SCOTT';

객체 : SELECT object_name FROM user_objects WHERE object_type = 'TABLE';

# 0. 기타 팁
echo %path%


모르겠음 : HELP COLUMN








