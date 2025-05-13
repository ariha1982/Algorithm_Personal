-- 코드를 입력하세요
with base as (
    SELECT
        car_id
    from CAR_RENTAL_COMPANY_RENTAL_HISTORY
    where start_date between date('2022-08-01') and date('2022-10-31')
    group by car_id
    having count(*) >= 5
)

select
    month(rh.start_date) 'MONTH',
    rh.car_id,
    count(*) RECORDS
from CAR_RENTAL_COMPANY_RENTAL_HISTORY rh
join base on rh.car_id = base.car_id
where start_date between date('2022-08-01') and date('2022-10-31')
group by rh.car_id, month
order by month, rh.car_id desc