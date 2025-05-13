-- 코드를 작성해주세요
-- 사번, 성명, 평가 등급(grade), 성과금(bonus)
with EMP_GRADE as (
    select
        EMP_NO,
        case
            when avg(score) >= 96 then 'S'
            when avg(score) between 90 and 96 then 'A'
            when avg(score) between 80 and 90 then 'B'
            else 'C'
        end as GRADE
    from hr_grade
    group by emp_no, year
)

select
    emp.EMP_NO,
    emp.EMP_NAME,
    gr.GRADE,
    case
        when gr.grade = 'S' then emp.sal * 0.2
        when gr.grade = 'A' then emp.sal * 0.15
        when gr.grade = 'B' then emp.sal * 0.1
        else 0
    end as BONUS
from hr_employees emp
join EMP_GRADE gr
    on emp.emp_no = gr.emp_no
order by emp_no;