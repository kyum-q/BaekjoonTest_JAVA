-- 코드를 입력하세요
SELECT DISTINCT U.USER_ID USER_ID, U.NICKNAME NICKNAME, B.TOTAL_SALES TOTAL_SALES 
FROM USED_GOODS_USER U JOIN (
    SELECT WRITER_ID, SUM(PRICE) TOTAL_SALES
    FROM USED_GOODS_BOARD
    WHERE STATUS = 'DONE'
    GROUP BY WRITER_ID
) B ON B.WRITER_ID = U.USER_ID
WHERE TOTAL_SALES >= 700000
ORDER BY B.TOTAL_SALES;