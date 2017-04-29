<#include "templates/mainTemplate.ftl">
<@main_template title="Добро пожаловать"/>

<#macro body>
<div class="allContent">

    <div id="sidebar1">
        <div class="loginTitle">
            <div class="lT">Вход</div>
        </div>
        <div class="loginBody">
            <br/>
            Логин:<br/>
            <input name="" type="text" size="28"/><br/><br/>
            Пароль:<br/>
            <input name="" type="text" size="28"/><br/><br/>

            <div class="ls">
                <button class="btn btn-primary btn-block" type="submit">Войти</button>
            </div>
        </div>
        <div class="loginFooter"></div>
    </div>

    <div id="mainContent">
        <p class="mainPageInf">Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nulla vitae ligula nunc.</p>

        <p class="mainPageInf2">
            Ut eu finibus felis. Donec eu odio augue. Suspendisse sodales sapien nec sapien sagittis, a gravida
            augue maximus. Etiam quis est semper, convallis tortor quis, sodales odio. In in vulputate eros, lacinia
            pretium erat. Mauris sit amet sapien convallis, facilisis nisl ut, tincidunt nulla. Integer nec felis
            condimentum, ultricies metus eu, aliquet felis. Donec venenatis auctor dolor id scelerisque. Sed id
            pellentesque metus. Suspendisse maximus bibendum mattis. Sed lacinia diam euismod leo tincidunt
            pellentesque. Vivamus sagittis nec mi maximus faucibus. <br/><br/>

            <b>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nulla vitae ligula nunc.</b><br/>
            Praesent quis nibh at tortor mattis fermentum porta viverra tortor. Mauris sed aliquet arcu, non
            vestibulum mauris. Praesent facilisis, felis quis dignissim lobortis, ex sem tincidunt arcu, venenatis
            rhoncus nibh purus in orci. Donec venenatis ultrices neque, quis dictum nibh dapibus ut. Curabitur sit
            amet fringilla leo, sed aliquam odio. Sed vehicula massa ut enim hendrerit, vel pretium leo ultricies.
            Morbi a ipsum sit amet dui lobortis lacinia. Donec lorem justo, gravida nec nulla sit amet, bibendum
            gravida purus.<br/>
        </p>
    </div>
</div>
<br class="clearfloat"/>
</#macro>