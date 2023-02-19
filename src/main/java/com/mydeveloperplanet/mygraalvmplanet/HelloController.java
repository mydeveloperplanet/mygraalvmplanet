package com.mydeveloperplanet.mygraalvmplanet;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @RequestMapping("/hello")
    public String hello() {
        // return "Hello GraalVM!"
        String helloMessage = "Default message";
        try {
            Class<?> helloClass = Class.forName("com.mydeveloperplanet.mygraalvmplanet.Hello");
            Method helloSetMessageMethod = helloClass.getMethod("setMessage", String.class);
            Method helloGetMessageMethod = helloClass.getMethod("getMessage");
            Object helloInstance = helloClass.getConstructor().newInstance();
            helloSetMessageMethod.invoke(helloInstance, "Hello GraalVM!");
            helloMessage = (String) helloGetMessageMethod.invoke(helloInstance);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
        return helloMessage;
    }
}
