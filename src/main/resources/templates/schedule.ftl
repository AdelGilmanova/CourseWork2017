<#include "temp/mainTemplate.ftl">
<@main_template title="Расписание"/>

<#macro body>
<div class="allContent">
    <div class="card">
        <h3 class="page-header">Расписание</h3>
        <table class="table table-bordered patient-card">
            <tr>
                <td>Дата</td>
                <td>Время</td>
                <td>Кабинет</td>
                <td>Врач</td>
                <td>Статус</td>
            </tr>
            <tr>
                <td>01.01</td>
                <td>12:00-12:30</td>
                <td>120</td>
                <td>Иванов Иван Иванович</td>
                <td>Назначено</td>
            </tr>
            <tr>
                <td>01.01</td>
                <td>12:30-13:00</td>
                <td>120</td>
                <td>Иванов Иван Иванович</td>
                <td>Назначено</td>
            </tr>
        </table>
    </div>
</div>
</#macro>