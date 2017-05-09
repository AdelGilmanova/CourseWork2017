<#-- @ftlvariable name="card" type="ru.kpfu.itis.Gilmanova.entity.SickCard" -->
<#-- @ftlvariable name="patient" type="ru.kpfu.itis.Gilmanova.entity.Patient" -->
<#-- @ftlvariable name="user" type="ru.kpfu.itis.Gilmanova.entity.UserInfo" -->

<#include "temp/mainTemplate.ftl">
<@main_template title="Карта пациента"/>

<script>
    $( function() {
        $( "#datepicker" ).datepicker();
        $( "#datepicker1" ).datepicker();
    } );
</script>

<#macro body>
<div class="allContent">
    <div class="section">
        <h2 class="page-header">Карта пациента</h2>
        <p>Номер карты: ${(patient.getCard_number())!}</p>
        <p>Пациент: ${(patient.getUserInfo().getLastName())!} ${(patient.getUserInfo().getFirstName())!} ${(patient.getUserInfo().getSecondName())!}</p>
        <p>Лечащий врач: ${(user.getLastName())!} ${(user.getFirstName())!} ${(user.getSecondName())!}</p>
        <form method="post" action="/updateNote">
            <div class="columns">
                    <p>Дата начала болезни:</p>
                    <p><input type="text" name="start" id="datepicker" value="${(card.getStart())!}"></p>
                    <p>Дата завершения:</p>
                    <p><input type="text" name="finish" id="datepicker1" value="${(card.getFinish())!}"></p>
                    <p>Жалобы:</p>
                    <p><textarea name="complaint" rows='5' cols='50'>${(card.getComplaints())!}</textarea></p>
                    <p>Диагноз:</p>
                    <p><textarea name="diagnosis" rows='5' cols='50'>${(card.getDiagnosis())!}</textarea></p>
                    <p><br><br><br><button class="btn btn-primary btn-block"
                            type="submit" style="width: 170px; margin: 17px 0 0 200px">Изменить</button></p>
                    <p>Лечение:</p>
                    <p><textarea name=treatment rows='5' cols='50'>${(card.getTreatment())!}</textarea></p>
                    <p>Результат:</p>
                    <p><textarea name=results rows='5' cols='50'>${(card.getResults())!}</textarea></p>
                    <input type="hidden" name="patientId" value="${(patient.getUserInfo().getId())!}">
                    <input type="hidden" name="cardId" value="${(card.getId())!}">
            </div>
        </form>
    </div>

</div>
</#macro>