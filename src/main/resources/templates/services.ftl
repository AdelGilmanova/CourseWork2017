<#-- @ftlvariable name="services" type="java.util.List<ru.kpfu.itis.Gilmanova.entity.Service>" -->
<#-- @ftlvariable name="section" type="ru.kpfu.itis.Gilmanova.entity.Section" -->
<#include "temp/mainTemplate.ftl">
<@main_template title="Услуги"/>

<#macro body>
<div class="allContent">
    <div class="card">
        <h2 class="page-header">Наши специалисты и услуги</h2>
        <p>${(section.getName())!}</p>
        <#if services?has_content>
        <table class="table table-bordered">
            <tr>
                <td align="center">Код</td>
                <td align="center">Наименование медицинской услуги</td>
                <td align="center">Цена, руб.</td>
            </tr>
            <#list services as service>
                <tr>
                    <td align="center">${(service.getCode())!}</td>
                    <td>${(service.getName())!}</td>
                    <td align="center">${(service.getPrice())!}</td>
                </tr>
            </#list>
        </table>
        <#else>Данный раздел временно не доступен.
        </#if>
    </div>
</div>
</#macro>