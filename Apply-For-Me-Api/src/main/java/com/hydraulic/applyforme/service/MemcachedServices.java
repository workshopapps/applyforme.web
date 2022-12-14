package com.hydraulic.applyforme.service;

import lombok.RequiredArgsConstructor;
import net.rubyeye.xmemcached.MemcachedClient;
import net.rubyeye.xmemcached.exception.MemcachedException;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeoutException;

@Service
@RequiredArgsConstructor
public class MemcachedServices {
    private  final MemcachedClient memcachedClient;


    public  void save (String key, String value){
        try{
            memcachedClient.set(key,10000,value);

        } catch (TimeoutException | InterruptedException | MemcachedException e) {
            e.printStackTrace();
        }

    }

    public String getValueByKey(String key){
        try{
            return  memcachedClient.get(key);
        }
        catch (Exception e){
            return null;

        }
    }

    public  void  clear(String key){

        try{
            memcachedClient.delete(key);

        }
        catch (TimeoutException | InterruptedException | MemcachedException e){
            e.printStackTrace();
        }
    }

}
