call java -Dphantomjs.binary.path="src\main\resources\phantomjs\bin\phantomjs.exe" -jar src\main\resources\selenium-server-standalone.jar -role webdriver -hub http://localhost:4444/grid/register -port 5599