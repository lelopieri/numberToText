# Number To Text Application
Translate numeric values to text

## Generate .war file

- Clone project from github
```
git clone https://github.com/lelopieri/numberToText.git
``` 

- Generate war using Maven
```
mvn clean install
``` 

The file numbertotext.war will be generated at _target_ folder under project home folder.
 

## TomCat Deploy
There are a lot of ways to deploy in TomCat. But for demonstration use the following steps:

- Open Manager application of Tomcat Ex:
```
http://SERVER_ADDRESS:8080/manager/html
```

- Login using credentials of a user that has the role _manager-gui_
- At session __DEPLOY__ use the option __WAR file to deploy__
- Select the generated file from your local computer and press \<__DEPLOY__\>
