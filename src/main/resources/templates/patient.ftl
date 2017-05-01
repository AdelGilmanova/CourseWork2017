<#-- @ftlvariable name="user" type="ru.kpfu.itis.Gilmanova.entity.UserInfo" -->
<#-- @ftlvariable name="patient" type="ru.kpfu.itis.Gilmanova.entity.Patient" -->
<#-- @ftlvariable name="address" type="ru.kpfu.itis.Gilmanova.entity.Address" -->
<#-- @ftlvariable name="cards" type="java.util.List<ru.kpfu.itis.Gilmanova.entity.SickCard>" -->
<#include "temp/mainTemplate.ftl">
<@main_template title="Личный кабинет"/>

<#macro body>
<div class="allContent">

    <div class="patient-inf">
        <span class="photo"><img src="${(patient.getImage())!}" width="150" height="150" alt="photo"/></span>

        <h2 class="page-header">Личный кабинет</h2>

        <p>Номер карты: ${(patient.getCard_number())!}</p>

        <p>Имя: ${(user.getLastName())!} ${(user.getFirstName())!} ${(user.getSecondName())!}</p>

        <p>Пол: ${(patient.getGender())!}</p>

        <p>Дата рождения: ${(patient.getBirthday())!}</p>

        <p>Адрес: г. ${(address.getCity())!}, ул. ${(address.getStreet())!}, ${(address.getHouse())!}-${(address.getFlat())!}</p>

        <p>Логин: ${(user.getLogin())!}</p>

        <p>Аллергии: ${(patient.getAllergy())!}</p>
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
            <#if cards?has_content>
                <#list cards as card>
                    <tr>
                        <td>${(card.getStart())!}-${(card.getFinish())!}</td>
                        <td>${(card.getComplaints())!}</td>
                        <td>${(card.getDiagnosis())!}</td>
                        <td>${(card.getTreatment())!}</td>
                        <td>${(card.getResults())!}</td>
                        <td>${(card.getDoctor().getUserInfo().getLastName())!}</td>
                    </tr>
                </#list>
            <#else>У вас пока нет записей в карте.
            </#if>
        </table>
    </div>
</div>
</#macro>