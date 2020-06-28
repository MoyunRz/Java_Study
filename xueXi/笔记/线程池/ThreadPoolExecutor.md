   
    public ThreadPoolExecutor(int corePoolSize, // 核心线程数
                              int maximumPoolSize,// 最大线程数
                              long keepAliveTime,// 空闲时间，当线程池数量超过核心线程数时，多余的空闲线程存活的时间，即：这些线程多久被销毁
                              TimeUnit unit,// 空闲时间的单位，可以是毫秒、秒、分钟、小时和天，等等
                              BlockingQueue<Runnable> workQueue,// 等待队列，线程池中的线程数超过核心线程数时，任务将放在等待队列，它是一个BlockingQueue类型的对象
                              ThreadFactory threadFactory,// 线程工厂，我们可以使用它来创建一个线程
                              RejectedExecutionHandler handler// 拒绝策略，当线程池和等待队列都满了之后，需要通过该对象的回调函数进行回调处理
                              );
