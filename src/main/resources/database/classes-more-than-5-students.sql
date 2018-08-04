--https://leetcode-cn.com/problems/classes-more-than-5-students/description/
select class from (
    select count(distinct student) as cnt, class from courses group by class
) as tmp where tmp.cnt > 4;
