-- SELECT * from Departure dp where dp.airplan_id=1;
-- ALIASES: Departure dp   Arrival ar            Company co
--          Airplanes apl    Route ro              Status st
            

-- Вылет --
SELECT
co.Logo as "Символ",
co.alias_Name||ro.route_Depart as "Рейс",
dp.time_Dept as "Время Вылета",
dp.dept_aiport as "Откуда",
ro.city as "Куда",
ro.airport as "Аэропорт",
co.company_Name as "Перевозчик",
apl.airplane_Type as "Самолет",

st.status as "Статус"
-- concat (co.alias_Name, '',ro.route_Depart) as Race


from Departure dp
INNER JOIN Route ro on dp.rout_id=ro.id_route
INNER JOIN Company co on dp.compani_id= co.id_company
INNER JOIN Airplanes apl on dp.airplan_id = apl.id_depart
INNER JOIN Status st on dp.stat_id= st.id_status
