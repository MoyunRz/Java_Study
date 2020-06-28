## 简述

作为List接口的主要实现类 jdk1.2，线程不安全，效率高，底层使用Object[] elementData 实现

## 分析

- ArrayList的源码分析：jdk7情况下：

```

// 典型的创建
ArrayList arraylist =new ArrayList(); // 底层创建了长度为10的数组 

arraylist.add(123); // elementData[0] = new Integer(123)
...
arraylist.add(11); // 如果此次的添加导致底层elementData数组容量不够，则扩容。默认扩容为原来的1.5倍，同时将原有数据复制到新数组中。


```
- ArrayList的源码分析：jdk8情况下：

```

// 典型的创建
ArrayList arraylist =new ArrayList(); // 底层Object[] elementData初始化为{}，并没有创建长度为10
// 当我们第一次add()时,底层创建了长度10的数组，并将数据添加到element数组中
arraylist.add(123); // elementData[0] = new Integer(123)
...
arraylist.add(11); // 如果此次的添加导致底层elementData数组容量不够，则扩容。默认扩容为原来的1.5倍，同时将原有数据复制到新数组中。


```      