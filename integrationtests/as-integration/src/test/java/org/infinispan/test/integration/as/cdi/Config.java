package org.infinispan.test.integration.as.cdi;

import org.infinispan.cdi.ConfigureCache;
import org.infinispan.configuration.cache.Configuration;
import org.infinispan.configuration.cache.ConfigurationBuilder;
import org.infinispan.eviction.EvictionStrategy;
import org.infinispan.test.TestingUtil;
import org.infinispan.test.fwk.TestCacheManagerFactory;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;

/**
 * This is the configuration class.
 *
 * @author Kevin Pollet <pollet.kevin@gmail.com> (C) 2011
 * @author Galder Zamarreño
 */
public class Config {

   /**
    * <p>This producer defines the greeting cache configuration.</p>
    *
    * <p>This cache will have:
    * <ul>
    *    <li>a maximum of 4 entries</li>
    *    <li>use the strategy LRU for eviction</li>
    * </ul>
    * </p>
    *
    * @return the greeting cache configuration.
    */
   @GreetingCache
   @ConfigureCache("greeting-cache")
   @Produces
   @SuppressWarnings("unused")
   public Configuration greetingCache() {
      return new ConfigurationBuilder()
            .eviction().strategy(EvictionStrategy.LRU).maxEntries(4)
            .build();
   }

   /**
    * <p>This producer overrides the default cache configuration used by the default cache manager.</p>
    *
    * <p>The default cache configuration defines that a cache entry will have a lifespan of 60000 ms.</p>
    */
   @Produces
   @SuppressWarnings("unused")
   public Configuration defaultCacheConfiguration() {
      return new ConfigurationBuilder()
            .expiration().lifespan(60000l)
            .build();
   }

   @Produces
   @ApplicationScoped
   @SuppressWarnings("unused")
   public org.infinispan.manager.EmbeddedCacheManager defaultEmbeddedCacheManager() {
      return TestCacheManagerFactory.createCacheManager();
   }

   @SuppressWarnings("unused")
   public void killCacheManager(@Disposes org.infinispan.manager.EmbeddedCacheManager cacheManager) {
      TestingUtil.killCacheManagers(cacheManager);
   }

}
