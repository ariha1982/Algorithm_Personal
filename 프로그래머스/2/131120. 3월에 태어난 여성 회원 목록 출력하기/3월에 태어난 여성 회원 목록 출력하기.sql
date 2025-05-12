-- 코드를 입력하세요
SELECT
    member_id,
    member_name,
    gender,
    date_format(date_of_birth, '%Y-%m-%d') date_of_birth
from MEMBER_PROFILE
where
    extract(month from date_of_birth) = 3
    and tlno is not null
    and gender = 'W'
order by member_id;