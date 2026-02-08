# Проект автоматизации [ReqRes](https://reqres.in/)

> Реальный бэкэнд, который можно вызывать напрямую. Аутентификация, данные и логи — готов для тестов, демонстраций и приложений, управляемых фронтендом. Используйте его из Postman, Playwright или fetch()..

## **Содержание:**
____

* <a href="#tools">Используемые технологии</a>

* <a href="#test-plan">Тест-план</a>

* <a href="#jenkins">Сборка Jenkins</a>

* <a href="#console">Запуск проекта</a>

* <a href="#allure">Allure report</a>

____

<a id="tools"></a>
## <a name="Используемые технологии">**Используемые технологии:**</a>

<p align="center">  
<a href="https://www.jetbrains.com/idea/"><img src="images/logo/Intelij_IDEA.svg" width="50" height="50"  alt="IDEA"/></a>  
<a href="https://www.java.com/"><img src="images/logo/Java.svg" width="50" height="50"  alt="Java"/></a>  
<a href="https://junit.org/junit5/"><img src="images/logo/JUnit5.svg" width="50" height="50"  alt="JUnit 5"/></a>  
<a href="https://gradle.org/"><img src="images/logo/Gradle.svg" width="50" height="50"  alt="Gradle"/></a> 
<a href="https://rest-assured.io/"><img src="images/logo/Rest.png" width="45" height="45"  alt="Rest Assured"/></a>  
<a href="https://allurereport.org/"><img src="images/logo/Allure.svg" width="50" height="50"  alt="Allure"/></a> 
<a href="https://www.jenkins.io/"><img src="images/logo/Jenkins.svg" width="50" height="50"  alt="Jenkins"/></a>

</p>

____
<a id="test-plan"></a>

***Тест-план:***
- *Успешное получение информации по пользователю*
- *Успешное обновление информации по пользователю*
- *Успешное создание пользователя*
- *Успешное удаление пользователя*
- *Удаление пользователя с ошибкой без использования Api Key*

____
<a id="jenkins"></a>
## <img alt="Jenkins" height="25" src="images/logo/Jenkins.svg" width="25"/></a><a name="Build"></a>Сборка в [Jenkins](https://jenkins.autotests.cloud/job/C38-ar_terekhov-lesson13/)</a>
____
<p align="center">  
<a href="https://jenkins.autotests.cloud/job/C38-ar_terekhov-lesson13/"><img src="images/screen/jenkinsProject.png" alt="Jenkins" width="950"/></a>  
</p>

___
<a id="console"></a>

## Команда для запуска через терминал  
***Локальный запуск:***
```bash  
gradle clean api-tests  
```
___
<a id="allure"></a>
## <img alt="Allure" height="25" src="images/logo/Allure.svg" width="25"/></a> <a name="Allure"></a>Allure [report](https://jenkins.autotests.cloud/job/C38-ar_terekhov-lesson13/allure/)</a>

### *Main report page*

<p align="center"> <img title="Allure Overview Dashboard" src="images/screen/allureReport.png" width="850"> </p>

### *Suite*

<p align="center"> <img title="Allure Tests" src="images/screen/allureSuites.png" width="850"> </p>

___
