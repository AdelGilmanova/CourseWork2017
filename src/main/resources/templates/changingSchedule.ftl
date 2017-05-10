<#-- @ftlvariable name="schedule" type="java.util.List<ru.kpfu.itis.Gilmanova.entity.Schedule>" -->
<#-- @ftlvariable name="doctors" type="java.util.List<ru.kpfu.itis.Gilmanova.entity.Doctor>" -->

<#include "temp/mainTemplate.ftl">
<@main_template title="Расписания"/>

<#macro body>
<div class="allContent">
    <div class="card">
        <h3 class="page-header">Расписание</h3>

        <form action="/addSchedule" method="post">
            <input type="text" name="date" id="datepicker" required placeholder="Дата">
            Начало:<input type="time" name="start" value="10:00" min="10:00" max="19:59">
            Конец:<input type="time" name="finish" value="10:00" min="10:00" max="19:59">
            <input type="text" name="room" placeholder="Кабинет" required>
            <select name="doctorId">
                <#if doctors?has_content>
                    <#list doctors as doctor>
                        <option value="${(doctor.getId())!}">${(doctor.getUserInfo().getLastName())!}</option>
                    </#list>
                </#if>
            </select>
            <input type="submit" value="Добавить">
        </form>
        <br>
        <p style="color: green">${(msg)!}</p>
        <#if schedule?has_content>
            <table class="table table-bordered patient-card">
                <tr>
                    <td>Дата</td>
                    <td>Время</td>
                    <td>Кабинет</td>
                    <td>Врач</td>
                    <td>Статус</td>
                    <td></td>
                </tr>
                <#list schedule as sch>
                    <tr>
                        <td>${(sch.getDay())!}</td>
                        <td>${(sch.getStart())!}-${(sch.getFinish())!}</td>
                        <td>${(sch.getRoom())!}</td>
                        <td>${(sch.getDoctor().getUserInfo().getLastName())!}</td>
                        <td><#if sch.getStatus()>свободно
                        <#else>назначено
                        </#if></td>
                        <td>
                            <form action="/deleteSchedule" method="post">
                                <button type="submit" class="btn btn-default">Удалить</button>
                                <input type="hidden" name="schId" value="${(sch.getId())!}">
                            </form></td>
                    </tr>
                </#list>
            </table>
        <#else>Данный раздел временно не доступен.
        </#if>
    </div>
</div>

<script>
    $(function () {
        $("#datepicker").datepicker();
    });
</script>
</#macro>