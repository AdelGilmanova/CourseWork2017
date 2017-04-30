<#include "temp/mainTemplate.ftl">
<@main_template title="Личный кабинет"/>

<#macro body>
<div class="allContent">

    <div class="patient-inf">
        <span class="photo"><img src="/images/mine/photo.png" width="150" height="150" alt="photo"/></span>
        <h2 class="page-header">Личный кабинет</h2>
        <p>Имя: Иванов Иван Иванович</p>
        <p>Пол: мужской</p>
        <p>Дата рождения: 01.01.1990</p>
        <p>Адрес: г. Казань, ул. Сибгата Хакима, 39-122</p>
        <p>Логин: email@mail.ru</p>
        <p>Специализация: врач-терапевт</p>

        <form method="post" action="/">
            Номер карты пациента:<br>
            <input type="text" name="number">
            <input type="button" value="найти">
        </form>
    </div>


</div>
</#macro>