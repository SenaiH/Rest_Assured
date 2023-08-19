package com.cydeo.HomeWorks;

public class HomeWork4 {

}
/*
FormulaAPI INFO --> http://ergast.com/mrd/methods/drivers/
- It's for historical formula one race information
- In this particular api , it decided to give you ml by default for response
type and In this particular api , it decided to give you json if you add .json
at the end of url
FOR EXAMPLE
- http://ergast.com/api/f1/drivers.json ---> return JSON
BASE URL —> http://ergast.com/api/f1/
TASK 1 : Solve same task with 4 different way
- Given accept type is json
- And path param driverId is alonso
- When user send request /drivers/{driverId}.json
- Then verify status code is 200
- And content type is application/json; charset=utf-8
- And total is 1
- And givenName is Fernando
- And familyName is Alonso
- And nationality is Spanish
- Use JSONPATH
int total = jsonpath.getInt(“pathOfField”)
- Use HAMCREST MATCHERS
then().body(..........)
Print givenName of Driver by using extract method after HamCrest
- Convert Driver information to Java Structure
Map<String,Object> driverMap=jsonpath.getMap(“pathOfDriver”)
- Convert Driver information POJO Class
Driver driver=getObject(“pathOfDriver”,Driver.class)

TASK 2 : Solve same task with 4 different way
- Use JSONPATH
int total = jsonpath.getInt(“pathOfField”)
- Use HAMCREST MATCHERS
then().body(..........)
Print all names of constructor by using extract method after HamCrest
- Convert Constructor information to Java Structure
List<Map<String,Object>> constructorMap=jsonpath.getList(“pathOfConsts”);
- Convert Constructor information POJO Class
List<ConstructorPOJO>
constr=getObject(“pathOfConstr”,ConstructorPOJO.class)
NOTE
—> There is a class in JAVA That’s why give your class name
ConstrutorPOJO to separate from existing one. Wrong imports may cause
issue
- Given accept type is json
- When user send request /constructorStandings/1/constructors.json
- Then verify status code is 200
- And content type is application/json; charset=utf-8
- And total is 17
- And limit is 30
- And each constructor has constructorId
- And constructor has name
- And size of constructor is 17
- And constructor IDs has “benetton”, “mercedes”,”team_lotus”
 */