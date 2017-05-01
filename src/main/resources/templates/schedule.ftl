<#-- @ftlvariable name="schedule" type="java.util.List<ru.kpfu.itis.Gilmanova.entity.Schedule>" -->

<#include "temp/mainTemplate.ftl">
<@main_template title="Расписание"/>

<#macro body>
<div class="allContent">
    <div class="card">
        <h3 class="page-header">Расписание</h3>
        <#if schedule?has_content>
        <table class="table table-bordered patient-card">
            <tr>
                <td>Дата</td>
                <td>Время</td>
                <td>Кабинет</td>
                <td>Врач</td>
                <td>Статус</td>
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
                </tr>
            </#list>
        </table>
        <#else>Данный раздел временно не доступен.
        </#if>
    </div>
</div>
</#macro>