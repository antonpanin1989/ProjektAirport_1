-- Прилет --
-- ALIASES: Departure - dp   Arrival - ar              Company - co
--          Airplanes apl    Route   - ro              Status - st

SELECT
co.Logo as Символ,
co.alias_Name||ro.route_Depart as "Рейс",
ar.time_arr as Время_Прилета,
ar.arr_airport as Откуда,
ro.city as Куда,
co.company_Name as Перевозчик,
apl.airplane_Type as Самолет,
st.status as Статус


from Arrival ar
INNER JOIN Route ro on ar.route_id=ro.id_route
INNER JOIN Company co on ar.company_id= co.id_company
INNER JOIN Airplanes apl on ar.airplane_id = apl.id_depart
INNER JOIN Status st on ar.status_id= st.id_status
