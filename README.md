#### Домашнее задание по теме: «Основы работы с сетью. Модель OSI»
##### Задача: Клиент-серверное приложение (включая задание со *)

###### server
~~~ java
"C:\Program Files\Java\jdk-14.0.2\bin\java.exe" "-javaagent:C:\Program Files\JetBrains\IntelliJ IDEA 2019.2\lib\idea_rt.jar=51331:C:\Program Files\JetBrains\IntelliJ IDEA 2019.2\bin" -Dfile.encoding=UTF-8 -classpath C:\Users\User\IdeaProjects\ClientServer\Server\target\classes;C:\Users\User\.m2\repository\org\hamcrest\hamcrest-all\1.3\hamcrest-all-1.3.jar ru.idcore.Server
server is started. new connection accepted
new user: User{name='Alex', adult=true, ipAddress='/127.0.0.1:51349', port=51349} is registered
client answer: thanks
server is stopped

Process finished with exit code 0
~~~

###### client
~~~ java
"C:\Program Files\Java\jdk-14.0.2\bin\java.exe" "-javaagent:C:\Program Files\JetBrains\IntelliJ IDEA 2019.2\lib\idea_rt.jar=51347:C:\Program Files\JetBrains\IntelliJ IDEA 2019.2\bin" -Dfile.encoding=UTF-8 -classpath C:\Users\User\IdeaProjects\ClientServer\Client\target\classes;C:\Users\User\.m2\repository\org\hamcrest\hamcrest-all\1.3\hamcrest-all-1.3.jar ru.idcore.Client
hi client!
what is your name?
Alex
are you child?(yes/no)
no
Welcome to the adult area, Alex! Let's play! 
let's test connection! input your message or end to exit
test
server answer: your message is: test
hello
server answer: your message is: hello
end
connection is closed

Process finished with exit code 0
~~~
 