# 1
[Oracle 19c] 설치 : 이것도 LTS
옵션에서 서버클래스, 기본 설치
시간 오래 걸림

# 2 [sql developer, Windows 64-bit with JDK 17 included] 설치

# 3. SQLPlus
1) cmd
2) sqlplus system/1111 : 관리자 계정
2-1) sqlplus system/1111 as sysdba : 관리자 계정

# 4
같은 cmd에서 alter session set "_ORACLE_SCRIPT"=true;
>세션이 변경되었습니다.

그러고보니 맨 처음 설치할 때 alter session set "_ORACLE_SCRIPT"=true; 라고 하던데 뭐야?

👉 이 명령은 오라클 12c 이후 버전(특히 18c, 19c 등)에서 특정 작업을 하기 위해 임시로 보안 정책을 우회하는 설정입니다.
👉 사용자 계정을 SYS 같은 시스템 권한으로 만들 수 있도록 허용하는 설정이에요.


# 5
@C:\Oracle19c\WINDOWS.X64_193000_db_home\rdbms\admin\scott.sql
show user;
>USER은 "SCOTT"입니다

alter use scott identified by tiger;
>에러

# 5-1 에러메세지 해결

exit 후 다시 sqlplus system/1111 as sysdba
alter user scott identified by tiger;
