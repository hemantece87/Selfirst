set projectLocation=D:\Study\ShoppingRepository
cd %projectLocation%
set classpath=%projectLocation%\bin;%projectLocation%\lib\*
java org.testng.TestNG %projectLocation%\testNg.xml
pause