-- 코드를 입력하세요
select o.FLAVOR
from FIRST_HALF o
join ICECREAM_INFO i on o.FLAVOR = i.FLAVOR
where o.TOTAL_ORDER > 3000 and i.INGREDIENT_TYPE = 'fruit_based'
order by o.TOTAL_ORDER desc
;