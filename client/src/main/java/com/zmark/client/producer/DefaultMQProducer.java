package com.zmark.client.producer;

import com.zmark.remoting.RPCHook;

/**
 * @author zhengguangchen
 */


public class DefaultMQProducer implements Producer {

    private String groupName;

    protected final transient DefaultMQProducerImpl defaultMQProducerImpl;


    public DefaultMQProducer(final String groupName) {
        this(groupName, null);
    }


    public DefaultMQProducer(String groupName, RPCHook rpcHook) {
        this.groupName = groupName;
        this.defaultMQProducerImpl=new DefaultMQProducerImpl(this,rpcHook);
    }




    public void start() {
        this.defaultMQProducerImpl.start();
    }


    public void shutDown() {

    }
}
