## assert理解
assert：断言

在Java中，assert关键字是从JAVA SE 1.4 引入的，为了避免和老版本的Java代码中使用了assert关键字导致错误，Java在执行的时候默认是不启动断言检查的（这个时候，所有的断言语句都 将忽略！），如果要开启断言检查，则需要用开关-enableassertions或-ea来开启。

## 用法

- assert [boolean 表达式]
        
        如果[boolean表达式]为true，则程序继续执行。
        如果为false，则程序抛出AssertionError，并终止执行。

- assert[boolean 表达式 : 错误表达式 （日志）]
        
        如果[boolean表达式]为true，则程序继续执行。
        如果为false，则程序抛出java.lang.AssertionError，输出[错误信息]。
        
## 例子
```
      // 设置初始值
　　　　String s = null;
      // 判断s值是否为空，并用assert赋值boolean
      // 结果为true，继续运行
　　　　assert s!=null?true:false;
      // 结果为false，抛出异常
　　　　assert false;
　　　　System.out.println("end");

```