<#-- @ftlvariable name="sections" type="java.util.List<ru.kpfu.itis.Gilmanova.entity.Section>" -->
<#include "temp/mainTemplate.ftl">
<@main_template title="Услуги"/>

<#macro body>
<div class="allContent">
    <div class="section">
        <h2 class="page-header">Наши специалисты и услуги</h2>
        <ul>
            <#if sections?has_content>
                <#list sections as section>
                    <li><a href="/services/${(section.getId())!}">${(section.getName())!}</a></li>
                </#list>
            <#else>Данный раздел временно не доступен.
            </#if>
        </ul>
    </div>

</div>
</#macro>