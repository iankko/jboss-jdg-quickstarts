package org.infinispan.demo.online;

import java.time.Instant;
import java.util.concurrent.TimeUnit;

import org.infinispan.client.hotrod.RemoteCache;
import org.infinispan.client.hotrod.RemoteCacheManager;
import org.infinispan.client.hotrod.configuration.Configuration;
import org.infinispan.client.hotrod.configuration.ConfigurationBuilder;

public class Main {

   public static void main(String... args) throws InterruptedException {
      String hotRodServiceName = "infinispan-app-hotrod";

      Configuration c = new ConfigurationBuilder()
            .addServers(hotRodServiceName + ":11222")
            .build();

      RemoteCacheManager remoteCacheManager = new RemoteCacheManager(c);
      RemoteCache<String, String> cache = remoteCacheManager.getCache();

      while (true) {
         cache.put("test", Instant.now().toString());
         System.out.println("Value from Cache: " + cache.get("test"));
         TimeUnit.SECONDS.sleep(10);
      }
   }
}
