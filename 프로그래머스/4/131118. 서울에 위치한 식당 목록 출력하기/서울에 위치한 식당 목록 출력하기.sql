-- 코드를 입력하세요
with SCORE_AVG as (
    select REST_ID, round(avg(REVIEW_SCORE), 2) avg_score
    from REST_REVIEW
    group by REST_ID
)

SELECT info.REST_ID, info.REST_NAME, info.FOOD_TYPE, info.FAVORITES, info.ADDRESS, a.avg_score
FROM REST_INFO info
JOIN SCORE_AVG a ON info.REST_ID = a.REST_ID
where info.ADDRESS like '서울%'
order by a.avg_score desc, info.FAVORITES desc;