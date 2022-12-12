package com.hydraulic.applyforme.config;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
//import org.medium.examples.memcached.cache.Memcached;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurer;

import org.springframework.cache.interceptor.CacheErrorHandler;
import org.springframework.cache.interceptor.CacheResolver;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.cache.interceptor.SimpleCacheErrorHandler;
import org.springframework.cache.interceptor.SimpleKeyGenerator;



import com.google.code.ssm.CacheFactory;
import com.google.code.ssm.config.AbstractSSMConfiguration;
import com.google.code.ssm.config.DefaultAddressProvider;
import com.google.code.ssm.providers.xmemcached.MemcacheClientFactoryImpl;
import com.google.code.ssm.providers.xmemcached.XMemcachedConfiguration;
import com.google.code.ssm.spring.ExtendedSSMCacheManager;
import com.google.code.ssm.spring.SSMCache;
import net.rubyeye.xmemcached.MemcachedClient;
import net.rubyeye.xmemcached.XMemcachedClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@RefreshScope
@Configuration
@EnableCaching
public class MemcachedConfiguration extends AbstractSSMConfiguration {


    private String memcachedHost = "localhost";


    private int memecachedPort=11211;

    Logger logger = LoggerFactory.getLogger(MemcacheConfig.class)

    @Override
    @Bean
    public CacheManager cacheManager() {
        SimpleCacheManager cacheManager = new SimpleCacheManager();
        try {
            cacheManager.setCaches(internalCaches());
            return cacheManager;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private Collection<Memcached> internalCaches() throws IOException {
        final Collection<Memcached> caches = new ArrayList<>();
        caches.add(new Memcached("personCache", memcachedAddresses, expirationSec));
        return caches;
    }

    @Override
    public KeyGenerator keyGenerator() {
        return new SimpleKeyGenerator();
    }

    @Override
    public CacheErrorHandler errorHandler() {
        return new SimpleCacheErrorHandler();
    }

    @Override
    public CacheResolver cacheResolver() {
        return null;
    }
}