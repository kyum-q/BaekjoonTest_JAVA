-- 코드를 입력하세요
SELECT ins.animal_id, ins.name
FROM ANIMAL_INS ins JOIN ANIMAL_OUTS outs
    ON ins.animal_id = outs.animal_id
WHERE ins.DATETIME > outs.DATETIME
ORDER BY ins.DATETIME;