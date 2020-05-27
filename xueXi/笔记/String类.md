## String的原理

![img](/笔记/图片/4E7652C0BBF26479F00C8EDF13B70BE0.jpg)

![img](/笔记/图片/F27ABD442FFEAC000F8B962688C62F99.jpg)

![img](/笔记/图片/C57524AB2E428F7D11DC61C77146EDB5.jpg)

![img](/笔记/图片/7876CB1ECFCFA5DDF975876259DAAF9C.jpg)


## 常用方法



    int length():返回字符串的长度：return value.length
    
    char charAt(int index):返回某索引处的字符 return value[index]
    
    boolean isEmpty():判断是否是空字符串：return value.length == 07
    
    String toLowerCase():使用默认语言环境，将String 中的所有字符转为小写
    
    String toUpperCase():使用默认语言环境，将String 中的所有字符转为大写
    
    String trim():返回字符串的副本，忽略前导空白和尾部空白
    
    boolean equals(Object obj):比较字符串的内容是否相同
    
    boolean equalsIgnoreCase(String str) 功能与equals相似，忽略大小写
    
    String concat(String str):将指定字符串连接到此字符串的结尾，等价于”+“
    
    int compareTo(String str):比较两个字符串的大小
    
    String substring(int beginIndex):返回一个新的字符串，它是此字符串的从beginIndex位置开始截取
    
    String substring(int beginIndex，int endIndex):返回一个新的字符串，它是此字符串的从beginIndex位置开始截取到endIndex位置,
    
    boolean endsWidth(String str):测试此字符串是否以指定的后缀结束
    
    boolean startsWidth(String str):测试此字符串是否以指定的前缀开始
    
    boolean startsWidth(String str, int toffset):测试此字符串是否在指定索引开始的位置以指定的前缀开始  
    
    boolean contains(CharSequence s):当且仅当此字符串包含指定的char值序列时返回true
    
    int indexOf(String str):返回指定子字符串在此字符串中第一次出现的索引
    
    int indexOf(String str，int index):返回指定子字符串在此字符串中第一次出现的索引,从指定索引处开始查找
    
    int lastIndexOf(String str):返回指定子字符串在此字符串中最右边出现的索引
    
    int lastIndexOf(String str):返回指定子字符串在此字符串中最右边出现的索引,从指定索引处开始查找

    String replace(char oldChar,char newChar):返回一个新的字符串，它是通过newChar替换此字符串中出现的所有oldChar得到的
    
    String replace(CharSequence target,CharSequence replacement):使用指定的字面值替换序列替换此字符串所有匹配字面值目标序列的子字符串

    String replaceAll(String regex,String replacement):使用指定的replacement代替正则表达式查询出来的值
    
    String replaceFirst(String regex,String replacement):使用指定的replacement代替正则表达式查询出来的第一个值
    
    boolean matches(String regex):告知此字符串是否匹配给定的正则表达式
    
    String[] split(String regex):根据给定正则表达式的匹配拆分此字符串
    
    String[] split(String regex,int limit):根据匹配的正则表达式来拆分此字符串，最多不超过limit个，如果超过，剩下的全部放到最后一个元素中。

## String 转化

String--> 基本数据类型、包装类：调用包装类的静态方法：parseXxx(str)
基本数据类型、包装类-->String: 调用String 重载的valueOf(xxx)

String--> char[]: 调用String的toCharArray()

char[]--> String: 调用String的构造器

String--> byte[]: 调用String的getBytes() // 获取字符集 


    