package com.lhj.omnipotent;

import java.util.HashMap;

/**
 *    万能接口：接口管理库
 *        作用：减少重复冗余代码、解耦类之间交互的耦合(例如：fragment与Activity交互、线程与Activity交互)
 *        特点：使用简单、可链式调用。
 *    Created by LinHaoJian on 2018/10/19.
 */
public class OmnipotentManager {
    private static OmnipotentManager omnipotentManager;
    public static OmnipotentManager getInstance(){
        if(omnipotentManager ==null){
            synchronized (OmnipotentManager.class){
                if(omnipotentManager ==null){
                    omnipotentManager = new OmnipotentManager();
                }
            }
        }
        return omnipotentManager;
    }
    private HashMap<String,OmnipotentInterface> hashMap = new HashMap<>();

    /**
     *  将接口添加到容器中，然后可以通过invokeInterface查找对应接口，并触发其里面的函数
     * @param interfaceKey  接口的唯一标识
     * @param wifiInterface  接口
     * @return 返回OmnipotentManager实例（作用：方便链式调用）
     */
    public OmnipotentManager addInterface(String interfaceKey, OmnipotentInterface wifiInterface){
        hashMap.put(interfaceKey,wifiInterface);
        return omnipotentManager;
    }

    /**
     * 根据唯一标识去除对应的接口
     * @param interfaceKey
     */
    public void removeInterface(String interfaceKey){
        hashMap.remove(interfaceKey);
    }

    /**
     *  通过唯一标识获取对应的无参无返回的接口，并触发其里面的函数，实现回调的功能
     * @param interfaceKey 接口的唯一标识
     */
    public void invokeInterface(String interfaceKey){
        invokeInterface(interfaceKey,null);
    }

    /**
     *  通过唯一标识获取对应的无参有返回的接口，并触发其里面的函数，实现回调的功能
     * @param interfaceKey 接口的唯一标识
     */
    public <Result> Result invokeInterface(String interfaceKey, Class<Result> resultClass){
        return invokeInterface(interfaceKey,null,resultClass);
    }

    /**
     *  通过唯一标识获取对应的有参无返回的接口，并触发其里面的函数，实现回调的功能
     * @param interfaceKey 接口的唯一标识
     */
    public <T> void invokeInterface(String interfaceKey, T t){
        invokeInterface(interfaceKey,t,null);
    }

    /**
     *  通过唯一标识获取对应的有参有返回的接口，并触发其里面的函数，实现回调的功能
     * @param interfaceKey 接口的唯一标识
     */
    public <T,Result> Result invokeInterface(String interfaceKey,T t,Class<Result> resultClass){
        OmnipotentInterface wifiInterface = hashMap.get(interfaceKey);
        if(wifiInterface==null){
            throw new NullPointerException("wifiInterface is null for interfaceKey.");
        }else{
            //判断接口对象属于那种类型
            if(wifiInterface instanceof OmnipotentInterfaceNoParamNoResult){
                ((OmnipotentInterfaceNoParamNoResult) wifiInterface).function();
            }else if(wifiInterface instanceof OmnipotentInterfaceNoParamHasResult){
                if(resultClass!=null){
                    //转换类型
                    return resultClass.cast(((OmnipotentInterfaceNoParamHasResult) wifiInterface).function());
                }else{
                    return (Result) ((OmnipotentInterfaceNoParamHasResult) wifiInterface).function();
                }
            }else if(wifiInterface instanceof OmnipotentInterfaceHasParamNoResult){
                ((OmnipotentInterfaceHasParamNoResult) wifiInterface).function(t);
            }else if(wifiInterface instanceof OmnipotentInterfaceHasParamHasResult){
                if(resultClass!=null){
                    return resultClass.cast(((OmnipotentInterfaceHasParamHasResult) wifiInterface).function(t));
                }else{
                    return (Result) ((OmnipotentInterfaceHasParamHasResult) wifiInterface).function(t);
                }
            }
        }
        return null;
    }



}
