-- 코드를 작성해주세요
SELECT G.SCORE SCORE, E.EMP_NO EMP_NO, E.EMP_NAME EMP_NAME, E.POSITION POSITION, E.EMAIL EMAIL
FROM HR_EMPLOYEES E
    JOIN (
        SELECT EMP_NO, SUM(SCORE) SCORE
        FROM HR_GRADE
        WHERE YEAR = '2022'    
        GROUP BY EMP_NO
    ) G ON E.EMP_NO = G.EMP_NO
ORDER BY G.SCORE DESC
LIMIT 1;