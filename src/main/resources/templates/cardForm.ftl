<#-- @ftlvariable name="cards" type="java.util.List<ru.kpfu.itis.Gilmanova.entity.SickCard>" -->
<#-- @ftlvariable name="patient" type="ru.kpfu.itis.Gilmanova.entity.Patient" -->
<#-- @ftlvariable name="user" type="ru.kpfu.itis.Gilmanova.entity.UserInfo" -->

<#include "temp/mainTemplate.ftl">
<@main_template title="Карта пациента"/>

<script>
    $( function() {
        $( "#datepicker" ).datepicker();
    } );
</script>

<#macro body>
<div class="allContent">
    <div class="section">
        <h2 class="page-header">Карта пациента</h2>
        <p>Номер карты: ${(patient.getCard_number())!}</p>
        <p>Пациент: ${(patient.getUserInfo().getLastName())!} ${(patient.getUserInfo().getFirstName())!} ${(patient.getUserInfo().getSecondName())!}</p>
        <p>Лечащий врач: ${(user.getLastName())!} ${(user.getFirstName())!} ${(user.getSecondName())!}</p>
        <p style="color:green">${(msg)!}</p>
        <form method="post" action="/addNote">
            <div class="columns">
                    <p>Дата:</p>
                    <p><input type="text" name="date" id="datepicker" ></p>
                    <p>Жалобы:</p>
                    <p><textarea name="complaint" rows='5' cols='50'></textarea></p>
                    <p>Диагноз:</p>
                    <p><textarea name="diagnosis" rows='5' cols='50'></textarea></p>
                    <p><br><button class="btn btn-primary btn-block"
                            type="submit" style="width: 170px; margin: 17px 0 0 200px">Записать</button></p>
                    <p>Лечение:</p>
                    <p><textarea name=treatment rows='5' cols='50'></textarea></p>
                    <p>Результат:</p>
                    <p><textarea name=results rows='5' cols='50'></textarea></p>
                    <input type="hidden" name="patientId" value="${(patient.getUserInfo().getId())!}">
            </div>
        </form>

        <h3 class="page-header">История болезней</h3>
        <#if cards?has_content>
            <table class="table table-bordered">
                <tr>
                    <td>Дата</td>
                    <td>Жалобы</td>
                    <td>Диагноз</td>
                    <td>Лечение</td>
                    <td>Результат</td>
                    <td></td>
                </tr>
                <#list cards as card>
                    <tr>
                        <td>${(card.getStart())!}-${(card.getFinish())!}</td>
                        <td>${(card.getComplaints())!}</td>
                        <td>${(card.getDiagnosis())!}</td>
                        <td>${(card.getTreatment())!}</td>
                        <td>${(card.getResults())!}</td>
                        <td><a href="/updateCard/${(card.getId())!}">Изменить</a></td>
                    </tr>
                </#list>
            </table>
        <#else>Карта пуста.
        </#if>

    </div>

</div>
</#macro>