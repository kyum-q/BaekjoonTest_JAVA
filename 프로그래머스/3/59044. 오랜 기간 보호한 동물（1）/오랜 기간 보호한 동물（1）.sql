-- 코드를 입력하세요
SELECT ins.name, ins.datetime
FROM animal_ins ins left join animal_outs outs ON ins.animal_id = outs.animal_id
WHERE outs.animal_id IS NULL 
ORDER BY ins.datetime
LIMIT 3;