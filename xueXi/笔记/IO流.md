## IO

- I 是 input 输入
- O 是 output 输出


## 常用实例
```java

/**
     * 1.如何创建File实例:
     * File(String filePath)
     * File(String pathname,String child)
     * File(File parentFile,String childPath)
     *
     * 2.
     * 相对路径：相对于某国的路径下
     * 绝对路径：包含盘符在内的文件或者文件目录的路径
     *
     */

```

## 常用方法
```java

/**
     * public  String getAbsolutePath(): 获取绝对路径
     * public  String getPath(): 获取路径
     * public  String getName(): 获取名称
     * public  String getParent(): 获取上层文件目录路径。若无，返回null
     * public  Long length(): 获取文件长度（即字节数）。不能获取目录长度。
     * public  Long lastModified(): 获取最后一次的修改时间，毫秒值
     * public  String[] list(): 获取指定目录下的所有文件或者文件目录的名称数组,适用于找目录
     * public  File[] listFiles(): 获取指定目录下的所有文件或者文件目录下的File数组，适用于遍历创建File实例
     * public boolean renameTo(File dest): 把文件重新命名为指定的文件路径，简单点就是移动文件
     */

```

## 判断方法
```java
/**
     * public boolean isDirectory(): 判断是否是文件目录
     * public boolean isFile(): 判断是否是文件
     * public boolean exists(): 判断是否存在
     * public boolean canRead(): 判断是否可读
     * public boolean canWrite(): 判断是否能写
     * public boolean isHidden(): 判断是否是隐藏文件
     * 
     */

```

## 创建/删除文件

```java

/**
     * 创建硬盘中对应的文件或者文件目录
     * public boolean createNewFile(): 创建文件。若文件存在，则不创建，返回false
     * public boolean mkdir(): 创建文件目录。如果此文件目录存在，就不创建了。如果此文件目录的上层目录不存在，也不创建
     * public boolean mkdirs(): 创建文件目录。如果上层文件不存在就一并创建
     * public boolean delete(): 删除文件或者文件夹（ps:java的删除不走回收站）
     */

```

## 流的分类

- 操作数据单位：字节流、字符流
- 数据的流向：输入流、输出流
- 流的角色：节点流、处理流

## 流的体系结构
    
    抽象基类         节点流（或文件流）            缓冲流（处理流的一种）
    
    InputStream     FileInputStream           BufferedInputStream
    OutputStream    FileOutputStream          BufferedOutputStream 
    Reader          FileReader                BufferedReader
    Writer          FileWriter                BufferedWriter