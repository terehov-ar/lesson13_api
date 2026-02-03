# Проект автоматизации [проекта ReqRes](https://reqres.in/)

> A real backend you can call directly.
Auth, data, and logs - ready for tests, demos, and frontend-led apps. Use it from Postman, Playwright, or fetch()..

## **Содержание:**
____

* <a href="#tools">Используемые технологии</a>

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
<a href="https://allurereport.org/"><img src="images/logo/Allure.svg" width="50" height="50"  alt="Allure"/></a> 
<a href="https://www.jenkins.io/"><img src="images/logo/Jenkins.svg" width="50" height="50"  alt="Jenkins"/></a>

</p>

____
<a id="jenkins"></a>
## <img alt="Jenkins" height="25" src="images/logo/Jenkins.svg" width="25"/></a><a name="Build"></a>Сборка в [Jenkins](https://jenkins.autotests.cloud/job/C38-ar_terekhov-lesson13/)</a>
____
<p align="center">  
<a href="https://jenkins.autotests.cloud/job/C38-ar_terekhov-bft_company/"><img src="images/screen/jenkinsProject.png" alt="Jenkins" width="950"/></a>  
</p>


### **Параметры сборки в Jenkins:**

- *browser (browser, default chrome)*
- *browserVersion (browser version, default 208.0)*
- *browserSize (browser window size, default 1920x1080)*
___
<a id="console"></a>
## Команды для запуска через терминал  
***Локальный запуск:***
```bash  
gradle clean api-tests
```
___
<a id="allure"></a>
## <img alt="Allure" height="25" src="images/logo/Allure.svg" width="25"/></a> <a name="Allure"></a>Allure [report](https://jenkins.autotests.cloud/job/C38-ar_terekhov-bft_company/6/allure/)</a>
___

### *Main report page*

<p align="center"> <img title="Allure Overview Dashboard" src="images/screen/allureReport.png" width="850"> </p>

### *Suite*

<p align="center"> <img title="Allure Tests" src="images/screen/allureSuites.png" width="850"> </p>

___
