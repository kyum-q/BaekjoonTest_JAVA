-- 코드를 입력하세요
SELECT p.PRODUCT_CODE, p.PRICE * sum(o.SALES_AMOUNT) as SALES
FROM product p JOIN offline_sale o on p.product_id = o.product_id
GROUP BY p.PRODUCT_CODE
ORDER BY p.PRICE * sum(o.SALES_AMOUNT) desc, p.PRODUCT_CODE;
