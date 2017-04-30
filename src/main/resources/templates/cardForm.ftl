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
        <p>Номер карты: 123456</p>
        <p>Пациент: Иванов Иван Иванович</p>
        <p>Лечащий врач: Иванов Иван Иванович</p>
        <form method="post" action="">
            <div class="columns">
                    <p>Дата:</p>
                    <p><input type="text" id="datepicker"></p>
                    <p>Жалобы:</p>
                    <p><textarea name='text' rows='5' cols='50'></textarea></p>
                    <p>Диагноз:</p>
                    <p><textarea name='text' rows='5' cols='50'></textarea></p>
                    <p><br><button class="btn btn-primary btn-block"
                            type="submit" style="width: 170px; margin: 17px 0 0 200px">Записать</button></p>
                    <p>Лечение:</p>
                    <p><textarea name='text' rows='5' cols='50'></textarea></p>
                    <p>Результат:</p>
                    <p><textarea name='text' rows='5' cols='50'></textarea></p>
            </div>
        </form>

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