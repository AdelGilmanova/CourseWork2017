<#-- @ftlvariable name="user" type="ru.kpfu.itis.Gilmanova.entity.UserInfo" -->
<#-- @ftlvariable name="doctor" type="ru.kpfu.itis.Gilmanova.entity.Doctor" -->
<#-- @ftlvariable name="address" type="ru.kpfu.itis.Gilmanova.entity.Address" -->
<#include "temp/mainTemplate.ftl">
<@main_template title="Личный кабинет"/>

<#macro body>
<div class="allContent">

    <div class="patient-inf">
        <span class="photo"><img src="${(doctor.getImage())!}" width="150" height="150" alt="photo"/></span>
        <h2 class="page-header">Личный кабинет</h2>
        <p>Имя: ${(user.getLastName())!} ${(user.getFirstName())!} ${(user.getSecondName())!}</p>
        <p>Пол: ${(doctor.getGender())!}</p>
        <p>Дата рождения: ${(doctor.getBirthday())!}</p>
        <p>Адрес: г. ${(address.getCity())!}, ул. ${(address.getStreet())!}, ${(address.getHouse())!}-${(address.getFlat())!}</p>
        <p>Логин: ${(user.getLogin())!}</p>
        <p>Специализация: ${(doctor.getSpecialization())!}</p>

        <form method="post" action="/">
            Номер карты пациента:<br>
            <input type="text" name="number">
            <input type="button" value="найти">
        </form>
    </div>

</div>
</#macro>