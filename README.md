# Number To Text Application
Translate numeric values to text

## Generate .war file

- Clone project from github
```
git clone https://github.com/lelopieri/numberToText.git
cd numberToText
``` 

- Generate war using Maven
```
mvn clean install
``` 

The file numbertotext.war will be generated at _target_ folder under project home folder.

## 3 Different ways to deploy
 
### Local
```
java -jar target/numbertotext.war
``` 
Now you can access the endpoint through the URL <a href="http://localhost:3000/numbertotext/42" target="_blank">http://localhost:3000/numbertotext/42</a>

[Using NumberToText](#using-numbertotext)

### Docker 

#### Build Docker Image
```
docker build -t desafio/numbertotext .
``` 

#### Run Docker Image
```
docker run -p 3000:3000 desafio/numbertotext
``` 
Now you can access the endpoint through the URL <a href="http://localhost:3000/numbertotext/42" target="_blank">http://localhost:3000/numbertotext/42</a>

[Using NumberToText](#using-numbertotext)

### TomCat
There are a lot of ways to deploy in TomCat. But for demonstration use the following steps:

- Open Manager application of Tomcat e.g.:
```
http://SERVER_ADDRESS:8080/manager/html
```

- Login using credentials of a user that has the role _manager-gui_
- At session __DEPLOY__ use the option __WAR file to deploy__
- Select the generated file from your local computer and press \<__DEPLOY__\>

Now you can access the endpoint through the URL <a href="http://localhost:8080/numbertotext/42" target="_blank">http://localhost:8080/numbertotext/42</a>

[Using NumberToText](#using-numbertotext)

## Using NumberToText
- Through a Internet Browser (or another tool like Postman)  access the same server address pointing to _/numbertotext/_ informing a integer number at the end of URL to be 'translated' to text e.g.:
```
http://SERVER_ADDRESS:8080/numbertotext/42
```


