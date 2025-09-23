# 1. reg(정규) 안에 보기 쉽게 하려고 공백을 쓰면 안돼

select '20250923',
        regexp_replace('20250923', '([0-9]{4}) ([0-9]{2}) ([0-9]{2})',
                    '\1-\2-\3') as "date format"
                    from dual;
ChatGPT의 말:

당신이 작성한 SQL 문은 Oracle SQL에서 날짜 문자열을 YYYY-MM-DD 형식으로 바꾸려고 하는 시도입니다.

하지만 현재 SQL에는 중요한 문제가 있습니다:

✅ 수정된 올바른 쿼리 (Oracle SQL 기준):
SELECT 
    '20250923' AS "original",
    REGEXP_REPLACE('20250923', '([0-9]{4})([0-9]{2})([0-9]{2})', '\1-\2-\3') AS "date format"
FROM dual;
