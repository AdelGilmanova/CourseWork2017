<#include "templates/mainTemplate.ftl">
<@main_template title="Добро пожаловать"/>

<#macro body>
<div class="allContent">
    <h2 class="services-header">Наши специалисты и услуги</h2>
    <table class="table table-bordered">
        <tr>
            <td align="center">Код</td>
            <td align="center">Наименование медицинской услуги</td>
            <td align="center">Цена, руб.</td>
        </tr>
        <tr>
            <td align="center">1411</td>
            <td>Прием (осмотр, консультация) врача-аллерголога-иммунолога, первичный</td>
            <td align="center">1 150</td>
        </tr>
    </table>
</div>
</#macro>