package com.zmark.client.producer;

import com.zmark.remoting.RPCHook;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author zhengguangchen
 */


public class DefaultMQProducerImpl  {


    private final DefaultMQProducer defaultMQProducer;
    private final RPCHook rpcHook;
    private final Integer coreSize=Runtime.getRuntime().availableProcessors();

    private  BlockingQueue<Runnable> asyncSenderThreadPoolQueue;
    private  ExecutorService defaultAsyncSenderExecutor;
    private ExecutorService asyncSenderExecutor;

    public DefaultMQProducerImpl(DefaultMQProducer defaultMQProducer) {
        this(defaultMQProducer,null);
    }


    public DefaultMQProducerImpl(DefaultMQProducer defaultMQProducer, RPCHook rpcHook) {
        this.defaultMQProducer=defaultMQProducer;
        this.rpcHook=rpcHook;
        initDefaultMQProducerImpl();
    }


    /**
     * 初始化生产者的默认实现
     */
    private void initDefaultMQProducerImpl() {
        this.asyncSenderThreadPoolQueue=new LinkedBlockingDeque<Runnable>(10000);
        this.asyncSenderExecutor=new ThreadPoolExecutor(coreSize, coreSize, 1000 * 60,
                TimeUnit.MILLISECONDS, this.asyncSenderThreadPoolQueue,
                new ThreadFactory() {
                    AtomicInteger atomicInteger=new AtomicInteger(0);
                    public Thread newThread(Runnable r) {
                        return new Thread("mark-asyncSenderExecutor-thread"+atomicInteger.addAndGet(1));
                    }
                }
        );





    }


    /**
     * 启动生产者
     */
    public void start() {
        this.start(true);
    }


    private void start(boolean startFactory) {
        //查看当前服务器的状态

    }




}
