package com.hydraulic.applyforme.config;

import java.io.IOException;

import java.util.Arrays;
import com.google.code.ssm.providers.xmemcached.MemcacheClientFactoryImpl;
import com.google.code.ssm.providers.xmemcached.XMemcachedConfiguration;
import com.google.code.ssm.spring.ExtendedSSMCacheManager;
import com.google.code.ssm.spring.SSMCache;
import org.springframework.cache.CacheManager;

import com.google.code.ssm.Cache;
import com.google.code.ssm.CacheFactory;
import com.google.code.ssm.config.AbstractSSMConfiguration;
import com.google.code.ssm.config.DefaultAddressProvider;
import net.rubyeye.xmemcached.MemcachedClient;
import net.rubyeye.xmemcached.XMemcachedClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@RefreshScope
@Configuration
@EnableCaching
public class MemcachedConfig extends AbstractSSMConfiguration {


    private String memcachedHost = "localhost";


    private int memecachedPort=11211;

    Logger logger = LoggerFactory.getLogger(MemcachedConfig.class);


    @Bean
    public MemcachedClient memcachedClient() {
        MemcachedClient client= null;
        try {
            client = new XMemcachedClient(memcachedHost,memecachedPort);

        } catch (NumberFormatException | IOException e) {
            e.printStackTrace();
            logger.info("Memcached encountered an error: {}",e.getMessage());
        }

        return client;
    }


    @Bean
    @Override
    public  CacheFactory defaultMemcachedClient() {
        String serverString = memcachedHost + ":" + memecachedPort;
        final XMemcachedConfiguration conf = new XMemcachedConfiguration();
        conf.setUseBinaryProtocol(true);

        final CacheFactory cf = new CacheFactory();
        cf.setCacheClientFactory(new MemcacheClientFactoryImpl());
        cf.setAddressProvider(new DefaultAddressProvider());
        cf.setConfiguration(conf);

        return cf;

    }

    @Bean
    public CacheManager cacheManager() throws Exception{
        // use SSMCacheManager  instead of ExtendedSSMCacheManager if you do not need to set key expiration
        ExtendedSSMCacheManager cacheManager = new ExtendedSSMCacheManager();
        Cache cache = this.defaultMemcachedClient().getObject();

        //SSMCache (cache,0,false) creates a new cache with default key expiration
        // of 0 (no expiration) and flushing disabled (allowClear= false)

        cacheManager.setCaches(Arrays.asList(new SSMCache(cache,0,false)));
        return cacheManager;
    }
}