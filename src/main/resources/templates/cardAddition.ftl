<#include "temp/mainTemplate.ftl">
<@main_template title="Новый пациент"/>

<#macro body>
<div class="allContent">

    <div class="section">
        <h2 class="page-header">Новая карта пациента</h2>
        <p><a href="/admin">Личный кабинет</a></p>
        <p style="color: green">${(msg)!}</p>
        <form action="/addUser" method="post">
            <div class="form-group">
                <label class="control-label col-sm-2">Имя:</label>
                <div class="col-sm-10">
                    <input type="text" name="firstName" class="form-control" placeholder="Имя" required>
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-sm-2">Фамилия:</label>
                <div class="col-sm-10">
                    <input type="text" name="lastName" class="form-control" placeholder="Фамилия" required>
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-sm-2">Отчество:</label>
                <div class="col-sm-10">
                    <input type="text" name="secondName" class="form-control" placeholder="Отчество" required>
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-sm-2" for="datepicker">День рождения:</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" name="date" id="datepicker" required>
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-sm-2">Пол:</label>
                <div class="col-sm-10">
                    <input type="text" name="gender" class="form-control" placeholder="Пол" required>
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-sm-2">Рост:</label>
                <div class="col-sm-10">
                    <input type="text" name="growth" class="form-control" placeholder="Рост" onblur="validateNumber(this)" required>
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-sm-2">Логин:</label>
                <div class="col-sm-10">
                    <input type="text" name="login" id="login" class="form-control" placeholder="Логин" required oninput="checkLogin(this)">
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-sm-2" for="pass">Пароль:</label>
                <div class="col-sm-10">
                    <input type="password" name="pass" class="form-control" id="pass" placeholder="Пароль" onblur="validatePassword(this)" required>
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-sm-2" for="pass2">Проверочный:</label>
                <div class="col-sm-10">
                    <input type="password" class="form-control" id="pass2" placeholder="Повторный пароль" onblur="validateConfirmPassword(this)" required>
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-sm-2">Номер карты:</label>
                <div class="col-sm-10">
                    <input type="text" name="cardNumber" id="cardNumber" class="form-control" placeholder="Номер карты" onblur="validateNumber(this)" oninput="checkCardNumber(this)" required>
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-sm-2">Аллергии:</label>
                <div class="col-sm-10">
                    <textarea name="allergy" class="form-control" rows='5' cols='50'></textarea>
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-sm-2">Область:</label>
                <div class="col-sm-10">
                    <input type="text" name="area" class="form-control" placeholder="Область" required>
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-sm-2">Город:</label>
                <div class="col-sm-10">
                    <input type="text" name="city" class="form-control" placeholder="Город" required>
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-sm-2">Улица:</label>
                <div class="col-sm-10">
                    <input type="text" name="street" class="form-control" placeholder="Улица" required>
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-sm-2">Дом:</label>
                <div class="col-sm-10">
                    <input type="text" name="house" class="form-control" placeholder="Дом" required>
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-sm-2">Квартира:</label>
                <div class="col-sm-10">
                    <input type="text" name="flat" class="form-control" placeholder="Квартира" onblur="validateNumber(this)" required>
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-sm-2">Индекс:</label>
                <div class="col-sm-10">
                    <input type="text" name="index" class="form-control" placeholder="Индекс" onblur="validateNumber(this)" required>
                </div>
            </div>
            <div class="form-group">
                <div class="col-sm-offset-2 col-sm-10">
                    <button type="submit" class="btn btn-default">Добавить пациента</button>
                </div>
            </div>

        </form>
    </div>

</div>

<script>
    $( function() {
        $( "#datepicker" ).datepicker();
    } );

    function checkCardNumber(input) {
        if ($("#cardNumber").val().length > 0)
            $.ajax({
                type: 'POST',
                url: '/checkingCardNumber',
                data: {cardNumber: $('#cardNumber').val()},
                success: function (data) {
                    if (data == 'ok') {
                        $('#cardNumber').val('');
                        alert("К сожалению, такой номер карты уже существует.");
                    }
                },
                error: function () {
                    alert('Приносим извинения. На сервере произошла ошибка');
                }
            });
    }

    function checkLogin(input) {
        if ($("#login").val().length > 0)
            $.ajax({
                type: 'POST',
                url: 'checkingLogin',
                data: {login: $('#login').val()},
                success: function (data) {
                    if (data == 'ok') {
                        $('#login').val('');
                        alert("К сожалению, такой логин уже существует.");
                    }
                },
                error: function () {
                    alert('Приносим извинения. На сервере произошла ошибка');
                }
            });
    }

    function validatePassword(input) {
        var result = input.value.match(/.{3,8}/);
        if (input.value == result) {
            input.setCustomValidity("");
        }
        else {
            input.setCustomValidity("Пароль должен быть от 3 до 8 символов");
        }
    }
    function validateConfirmPassword(input) {
        var pass = $('#pass').val();
        var pass2 = $('#pass2').val();
        if (pass == pass2) {
            input.setCustomValidity("");
        }
        else {
            input.setCustomValidity("Пароли не совпадают. Повторите попытку");
        }
    }
    function validateNumber(input) {
        var result = input.value.match(/\d+/);
        if (input.value == result) {
            input.setCustomValidity("");
        }
        else {
            input.setCustomValidity("Только числа");
        }
    }

</script>

</#macro>