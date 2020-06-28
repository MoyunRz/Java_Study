Executors是一个线程池工厂，提供了很多的工厂方法，我们来看看它大概能创建哪些线程池。
    
        // 创建单一线程的线程池
        public static ExecutorService newSingleThreadExecutor();
        // 创建固定数量的线程池
        public static ExecutorService newFixedThreadPool(int nThreads);
        // 创建带缓存的线程池
        public static ExecutorService newCachedThreadPool();
        // 创建定时调度的线程池
        public static ScheduledExecutorService newScheduledThreadPool(int corePoolSize);
        // 创建流式（fork-join）线程池
        public static ExecutorService newWorkStealingPool();

1. 创建单一线程的线程池

顾名思义，这个线程池只有一个线程。若多个任务被提交到此线程池，那么会被缓存到队列（队列长度为Integer.MAX_VALUE）。当线程空闲的时候，按照FIFO的方式进行处理。

2. 创建固定数量的线程池

和创建单一线程的线程池类似，只是这儿可以并行处理任务的线程数更多一些罢了。若多个任务被提交到此线程池，会有下面的处理过程。

    如果线程的数量未达到指定数量，则创建线程来执行任务
    如果线程池的数量达到了指定数量，并且有线程是空闲的，则取出空闲线程执行任务
    如果没有线程是空闲的，则将任务缓存到队列（队列长度为Integer.MAX_VALUE）。当线程空闲的时候，按照FIFO的方式进行处理

3. 创建带缓存的线程池

这种方式创建的线程池，核心线程池的长度为0，线程池最大长度为Integer.MAX_VALUE。由于本身使用SynchronousQueue作为等待队列的缘故，导致往队列里面每插入一个元素，必须等待另一个线程从这个队列删除一个元素。

4. 创建定时调度的线程池

和上面3个工厂方法返回的线程池类型有所不同，它返回的是ScheduledThreadPoolExecutor类型的线程池。平时我们实现定时调度功能的时候，可能更多的是使用第三方类库，比如：quartz等。但是对于更底层的功能，我们仍然需要了解。


    scheduleAtFixedRate(Runnable command, long initialDelay, long period, TimeUnit unit)，定时调度，每个调度任务会至少等待period的时间，如果任务执行的时间超过period，则等待的时间为任务执行的时间
    
    scheduleWithFixedDelay(Runnable command, long initialDelay, long delay, TimeUnit unit)，定时调度，第二个任务执行的时间 = 第一个任务执行时间 + delay
    
    schedule(Runnable command, long delay, TimeUnit unit)，定时调度，延迟delay后执行，且只执行一次
