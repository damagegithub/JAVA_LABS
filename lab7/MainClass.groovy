import groovy.time.TimeCategory
import sun.util.calendar.Gregorian

import java.time.*
import java.util.*
import groovy.sql.Sql

//Урок 1
try{
    FirstClass f1 = new FirstClass(x:1,f:1.5,bi:100g);
} catch (Exception e){
    println "Cannot create FirstClass";
}
FirstClass f2 = new FirstClass(1,1.5,100g);
println f2.getInt();//not "return" in getInt()

FirstClass f3 = new FirstClass();
println f3.binding.x;//100
println f3.getInt();//null

println "Integer instanceof String: ${5 instanceof String}";//false
println "String instanceof Integer: ${"qwe" instanceof Integer}";//false




//Урок 2
int returnInt(Integer i){return i;}
Integer returnInteger(Integer i){return i;}

try {
    println returnInt(null);
} catch ( Exception e){
    println "int cannot be null";
}
println returnInteger(null)//null


BigDecimal bigDecimal1 = new BigDecimal(3);
BigDecimal bigDecimal2 = new BigDecimal(3);

println "${System.identityHashCode(bigDecimal1) == System.identityHashCode(bigDecimal2)}";//false
println "bigDecimal1.equals(bigDecimal2) = ${(bigDecimal1.equals(bigDecimal2))}";
println "bigDecimal1 == bigDecimal2 = ${bigDecimal1 == bigDecimal2}";
println "bigDecimal1 <=> bigDecimal2 = ${(bigDecimal1 <=> bigDecimal2)}";

println "bigDecimal1.add(bigDecimal2) = ${bigDecimal1.add(bigDecimal2)}";
println "bigDecimal1 + bigDecimal2 = ${bigDecimal1 + bigDecimal2}";
println "bigDecimal1.divide(bigDecimal2) = ${bigDecimal1.divide(bigDecimal2)}";
println "bigDecimal1 / bigDecimal2 = ${bigDecimal1 / bigDecimal2}";
println "bigDecimal1.multiply(bigDecimal2) = ${(bigDecimal1.multiply(bigDecimal2))}";
println "bigDecimal1 * bigDecimal2 = ${bigDecimal1 * bigDecimal2}";


def variable;
variable=10;
println "type: ${variable.getClass()}";//Integer
variable = 'f';
println "type: ${variable.getClass()}";//String
variable = "First";
println "type: ${variable.getClass()}";//String
variable=10;
println "type: ${variable.getClass()}";//Integer


Date date1 = new GregorianCalendar(2015, Calendar.FEBRUARY, 28).getTime();
Date date2 = new GregorianCalendar(2015, Calendar.JANUARY, 31).getTime();

println date1;
println date2;
println "date1 - date2: "+(date1- date2);
use(TimeCategory) {
    date1 -= 1.month;
    println date1;//Wed Jan 28 00:00:00 MSK 2015
    date1 += (1.month + 1.day);
    println date1//Sun Mar 01 00:00:00 MSK 2015
}


//Урок 3
def division = { a, b -> a / b }
println "10/2 = ${division(10, 2)}"


def sub = { d, c -> d - c }
println "3-1 = ${sub(3, 1)}"

def combined = { a, b, c -> sub(division(a, b), c) }
println "10 / 2 - 1 = ${combined(10, 2, 1)}"


// Урок 4
sql = Sql.newInstance("jdbc:oracle:thin:@localhost:1521:orcl", "hr11", "hr11", "oracle.jdbc.pool.OracleDataSource");

sql.eachRow('SELECT * FROM employees') { row -> println row;}