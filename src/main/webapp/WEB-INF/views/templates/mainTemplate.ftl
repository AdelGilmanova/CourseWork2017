<#macro main_template styles=[] scripts=[] title="Система учета пациентов">
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>${title}</title>
    <link href="/resources/css/styles.css" rel="stylesheet" type="text/css"/>
    <link href="/resources/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
    <#list styles as css>
        <link rel="stylesheet" href="/resources/css/${css}" type="text/css" />
    </#list>

    <script type="text/javascript" src="/resources/js/jquery-2.1.4.min.js"></script>
    <script type="text/javascript" src="/resources/js/bootstrap.min.js"></script>
    <#list scripts as js>
        <script src="/resources/js/mine/${js}" type="text/javascript" defer></script>
    </#list>
</head>


<body>
<div id="container">
    <#include "header.ftl" />
    <@body />
    <#include "footer.ftl" />
</div>

</body>
</html>
</#macro>