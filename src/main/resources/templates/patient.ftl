<#include "temp/mainTemplate.ftl">
<@main_template title="Личный кабинет"/>

<#macro body>
<div class="allContent">

    <div class="patient-inf">
        <span class="photo"><img src="/images/mine/photo.png" width="150" height="150" alt="photo"/></span>
        <h2 class="page-header">Личный кабинет</h2>
        <p>Номер карты: 123456</p>
        <p>Имя: Иванов Иван Иванович</p>
        <p>Пол: мужской</p>
        <p>Дата рождения: 01.01.1990</p>
        <p>Адрес: г. Казань, ул. Сибгата Хакима, 39-122</p>
        <p>Логин: email@mail.ru</p>
        <p>Аллергии: нет</p>
    </div>

<div class="card">
    <h3 class="page-header">История болезней</h3>
    <table class="table table-bordered">
        <tr>
            <td>Дата</td>
            <td>Жалобы</td>
            <td>Диагноз</td>
            <td>Лечение</td>
            <td>Результат</td>
            <td>Лечащий врач</td>
        </tr>
        <tr>
            <td>01.01.2014-02.02.2014</td>
            <td>Боль в животе</td>
            <td>Апендицит</td>
            <td>Операция</td>
            <td>Вылечен</td>
            <td>Петров Петр Петрович</td>
        </tr>
        <tr>
            <td>01.01.2014-02.02.2014</td>
            <td>Боль в животе</td>
            <td>Апендицит</td>
            <td>Операция</td>
            <td>Вылечен</td>
            <td>Петров Петр Петрович</td>
        </tr>
    </table>
</div>
</div>
</#macro>