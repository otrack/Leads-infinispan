package org.infinispan.versioning.impl;

import org.infinispan.Cache;
import org.infinispan.atomic.AtomicObjectFactory;
import org.infinispan.versioning.utils.version.Version;
import org.infinispan.versioning.utils.version.VersionGenerator;
import org.jboss.logging.Logger;

import java.util.*;

/**
 * // TODO: Document this
 *
 * @author Pierre Sutra
 * @since 6.0
 */
public class VersionedCacheTreeMapImpl<K,V> extends VersionedCacheAbstractImpl<K,V> {

    AtomicObjectFactory factory;
    Logger logger;
    public VersionedCacheTreeMapImpl(Cache delegate, VersionGenerator generator, String name) {
        super(delegate,generator,name);
        factory = new AtomicObjectFactory((Cache<Object, Object>) delegate);
        this.logger  = Logger.getLogger(this.getClass());

    }

    @Override
    protected SortedMap<Version, V> versionMapGet(K key) {
        TreeMap<Version,V> treeMap = factory.getInstanceOf(TreeMap.class,key,true,null,false);
        factory.disposeInstanceOf(TreeMap.class,key,true);
        return treeMap;
    }

    @Override
    protected void versionMapPut(K key, V value, Version version) {
        TreeMap<Version,V> treeMap = factory.getInstanceOf(TreeMap.class, key, true, null, false);
        treeMap.put(version, value);
        factory.disposeInstanceOf(TreeMap.class,key,true);
    }

    @Override
    public boolean isEmpty() {
        return delegate.isEmpty();
    }

    @Override
    public boolean containsKey(Object o) {
        return delegate.containsKey(o);
    }

    @Override
    public boolean containsValue(Object o) {
        for(Object k: delegate.keySet()){
            if(factory.getInstanceOf(TreeMap.class,k,true,null,false).containsValue(o))
                return true;
        }
        return false;
    }

    @Override
    public Set<K> keySet() {
        return delegate.keySet();
    }

    @Override
    public Collection<Version> get(K key, Version first, Version last) {
        TreeMap<Version,V> treeMap = factory.getInstanceOf(TreeMap.class, key, true, null, false);
        Set<Version> result = (Set<Version>) treeMap.subMap(first, last).keySet();
        factory.disposeInstanceOf(TreeMap.class,key,true);
        return result;
    }

    @Override
    public void putAll(K key, Map<Version,V> map){
        TreeMap<Version,V> treeMap  = factory.getInstanceOf(TreeMap.class, key, true, null, false);
        treeMap.putAll(map);
        factory.disposeInstanceOf(TreeMap.class,key,true);
    }

}
