-- 코드를 입력하세요
with base as (
    SELECT
        *
    from food_order
    where date_format(produce_date, '%Y-%m') = '2022-05'
)

select
    fp.product_id,
    fp.product_name,
    fp.price * sum(base.amount) total_sales
from food_product fp
join base
    on base.product_id = fp.product_id
group by fp.product_id, fp.product_name
order by total_sales desc, fp.product_id