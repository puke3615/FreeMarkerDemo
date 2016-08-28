<#if packageName != "">package ${packageName};

</#if>
<@import>${rootClass}</@import>

<#list callbacks><#items  as callback>
<@import>${callback}</@import>
</#items>

</#list>
public class ${simpleClassName} implements <#list callbacks as callback><@interface>${callback}</@interface><#sep>, </#list> {

<#list callbacks><#items as callback>
    //=============<@interface>${callback}</@interface>==start=================
<@methods>${callback}</@methods>
    //=============<@interface>${callback}</@interface>===end==================


</#items>
</#list>

}