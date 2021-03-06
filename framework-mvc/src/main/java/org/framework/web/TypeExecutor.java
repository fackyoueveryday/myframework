package org.framework.web;


import org.framework.web.typeconvert.TypeConvert;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ServiceLoader;

/**
 * 类型处理器
 */
public class TypeExecutor {

    private Iterator<TypeConvert> it;
    private List<TypeConvert> list=new ArrayList<>();


    private static ServiceLoader serviceLoader;


    public TypeExecutor(){
        serviceLoader = ServiceLoader.load(TypeConvert.class);
        it= serviceLoader.iterator();
        list.add(it.next());
    }

    public Object execute(Parameter parameter) throws InstantiationException, IllegalAccessException, InvocationTargetException {
        Object object=null;
        while(it.hasNext()){
            object=it.next().convert(parameter,this);
            if(object!=null){
                return object;
            }
        }
        return object;
    }

    public static void main(String[] args) {
        new TypeExecutor();
    }

}
