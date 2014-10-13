package org.infinispan.ensemble.cache;

import org.infinispan.client.hotrod.*;
import org.infinispan.client.hotrod.impl.RemoteCacheImpl;
import org.infinispan.commons.util.concurrent.NotifyingFuture;
import org.infinispan.ensemble.Site;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 *
 * A RemoteCache object wrapper.
 *
 * @author Pierre Sutra
 * @since 7.0
 */
public class SiteEnsembleCache<K,V> extends EnsembleCache<K,V> implements RemoteCache<K,V>{

    private Site site;
    private RemoteCacheImpl<K,V> delegate;

    public SiteEnsembleCache(Site site, RemoteCache delegate) {
        super(delegate.getName(), Collections.EMPTY_LIST);
        this.delegate = (RemoteCacheImpl<K, V>) delegate;
        this.site = site;
    }

    public RemoteCacheImpl<K,V> getDelegeate(){
        return delegate;
    }

    @Override
    public Set<Site> sites(){
        return Collections.singleton(site);
    }

    @Override
    public boolean isLocal(){
        return site.isLocal();
    }

    @Override
    public NotifyingFuture<V> putAsync(K key, V value) {
        return delegate.putAsync(key, value);
    }

    @Override
    public NotifyingFuture<V> putAsync(K key, V value, long lifespan, TimeUnit unit) {
        return delegate.putAsync(key, value, lifespan, unit);
    }

    @Override
    public NotifyingFuture<V> putAsync(K key, V value, long lifespan, TimeUnit lifespanUnit, long maxIdle, TimeUnit maxIdleUnit) {
        return delegate.putAsync(key, value, lifespan, lifespanUnit, maxIdle, maxIdleUnit);
    }

    @Override
    public NotifyingFuture<Void> putAllAsync(Map<? extends K, ? extends V> data) {
        return delegate.putAllAsync(data);
    }

    @Override
    public NotifyingFuture<Void> putAllAsync(Map<? extends K, ? extends V> data, long lifespan, TimeUnit unit) {
        return delegate.putAllAsync(data, lifespan, unit);
    }

    @Override
    public NotifyingFuture<Void> putAllAsync(Map<? extends K, ? extends V> data, long lifespan, TimeUnit lifespanUnit, long maxIdle, TimeUnit maxIdleUnit) {
        return delegate.putAllAsync(data, lifespan, lifespanUnit, maxIdle, maxIdleUnit);
    }

    @Override
    public NotifyingFuture<Void> clearAsync() {
        return delegate.clearAsync();
    }

    @Override
    public NotifyingFuture<V> putIfAbsentAsync(K key, V value) {
        return delegate.putIfAbsentAsync(key, value);
    }

    @Override
    public NotifyingFuture<V> putIfAbsentAsync(K key, V value, long lifespan, TimeUnit unit) {
        return null;  // TODO: Customise this generated block
    }

    @Override
    public NotifyingFuture<V> putIfAbsentAsync(K key, V value, long lifespan, TimeUnit lifespanUnit, long maxIdle, TimeUnit maxIdleUnit) {
        return null;  // TODO: Customise this generated block
    }

    @Override
    public NotifyingFuture<V> removeAsync(Object key) {
        return null;  // TODO: Customise this generated block
    }

    @Override
    public NotifyingFuture<Boolean> removeAsync(Object key, Object value) {
        return null;  // TODO: Customise this generated block
    }

    @Override
    public NotifyingFuture<V> replaceAsync(K key, V value) {
        return null;  // TODO: Customise this generated block
    }

    @Override
    public NotifyingFuture<V> replaceAsync(K key, V value, long lifespan, TimeUnit unit) {
        return null;  // TODO: Customise this generated block
    }

    @Override
    public NotifyingFuture<V> replaceAsync(K key, V value, long lifespan, TimeUnit lifespanUnit, long maxIdle, TimeUnit maxIdleUnit) {
        return null;  // TODO: Customise this generated block
    }

    @Override
    public NotifyingFuture<Boolean> replaceAsync(K key, V oldValue, V newValue) {
        return null;  // TODO: Customise this generated block
    }

    @Override
    public NotifyingFuture<Boolean> replaceAsync(K key, V oldValue, V newValue, long lifespan, TimeUnit unit) {
        return null;  // TODO: Customise this generated block
    }

    @Override
    public NotifyingFuture<Boolean> replaceAsync(K key, V oldValue, V newValue, long lifespan, TimeUnit lifespanUnit, long maxIdle, TimeUnit maxIdleUnit) {
        return null;  // TODO: Customise this generated block
    }

    @Override
    public NotifyingFuture<V> getAsync(K key) {
        return null;  // TODO: Customise this generated block
    }

    @Override
    public boolean containsKey(Object k) {
        return delegate.containsKey(k);
    }

    @Override
    public boolean containsValue(Object o) {
        return false;  // TODO: Customise this generated block
    }


    @Override
    public boolean removeWithVersion(K key, long version) {
        return delegate.removeWithVersion(key, version);
    }

    @Override
    public NotifyingFuture<Boolean> removeWithVersionAsync(K key, long version) {
        return delegate.removeWithVersionAsync(key, version);
    }

    @Override
    public boolean replaceWithVersion(K key, V newValue, long version) {
        return delegate.replaceWithVersion(key, newValue, version);
    }

    @Override
    public boolean replaceWithVersion(K key, V newValue, long version, int lifespanSeconds) {
        return delegate.replaceWithVersion(key, newValue, version, lifespanSeconds);
    }

    @Override
    public boolean replaceWithVersion(K key, V newValue, long version, int lifespanSeconds, int maxIdleTimeSeconds) {
        return delegate.replaceWithVersion(key, newValue, version, lifespanSeconds, maxIdleTimeSeconds);
    }

    @Override
    public NotifyingFuture<Boolean> replaceWithVersionAsync(K key, V newValue, long version) {
        return delegate.replaceWithVersionAsync(key, newValue, version);
    }

    @Override
    public NotifyingFuture<Boolean> replaceWithVersionAsync(K key, V newValue, long version, int lifespanSeconds) {
        return delegate.replaceWithVersionAsync(key, newValue, version, lifespanSeconds);
    }

    @Override
    public NotifyingFuture<Boolean> replaceWithVersionAsync(K key, V newValue, long version, int lifespanSeconds, int maxIdleSeconds) {
        return delegate.replaceWithVersionAsync(key, newValue, version, lifespanSeconds, maxIdleSeconds);
    }

    @Override
    public VersionedValue<V> getVersioned(K key) {
        return delegate.getVersioned(key);
    }

    @Override
    public NotifyingFuture<VersionedValue<V>> getVersionedAsync(K key) {
        return delegate.getVersionedAsync(key);
    }

    @Override
    public MetadataValue<V> getWithMetadata(K key) {
        return delegate.getWithMetadata(key);
    }

    @Override
    public int size() {
        return delegate.size();
    }

    @Override
    public boolean isEmpty() {
        return delegate.isEmpty();
    }

    @Override
    public ServerStatistics stats() {
        return null;  // TODO: Customise this generated block
    }

    @Override
    public RemoteCache<K, V> withFlags(Flag... flags) {
        return null;  // TODO: Customise this generated block
    }

    @Override
    public RemoteCacheManager getRemoteCacheManager() {
        return null;  // TODO: Customise this generated block
    }

    @Override
    public Map<K, V> getBulk() {
        return null;  // TODO: Customise this generated block
    }

    @Override
    public Map<K, V> getBulk(int size) {
        return null;  // TODO: Customise this generated block
    }

    @Override
    public String getProtocolVersion() {
        return null;  // TODO: Customise this generated block
    }

    @Override
    public void addClientListener(Object listener) {
        // TODO: Customise this generated block
    }

    @Override
    public void addClientListener(Object listener, Object[] filterFactoryParams, Object[] converterFactoryParams) {
        // TODO: Customise this generated block
    }

    @Override
    public void removeClientListener(Object listener) {
        // TODO: Customise this generated block
    }

    @Override
    public Set<Object> getListeners() {
        return null;  // TODO: Customise this generated block
    }

    @Override
    public V get(Object o) {
        return delegate.get(o);
    }

    @Override
    public String getVersion() {
        return null;  // TODO: Customise this generated block
    }

    @Override
    public V put(K key, V value) {
        return delegate.put(key,value);
    }

    @Override
    public V put(K key, V value, long lifespan, TimeUnit unit) {
        return null;  // TODO: Customise this generated block
    }

    @Override
    public V putIfAbsent(K key, V value, long lifespan, TimeUnit unit) {
        return null;  // TODO: Customise this generated block
    }

    @Override
    public void putAll(Map<? extends K, ? extends V> map, long lifespan, TimeUnit unit) {
        // TODO: Customise this generated block
    }

    @Override
    public V replace(K key, V value, long lifespan, TimeUnit unit) {
        return null;  // TODO: Customise this generated block
    }

    @Override
    public boolean replace(K key, V oldValue, V value, long lifespan, TimeUnit unit) {
        return false;  // TODO: Customise this generated block
    }

    @Override
    public V put(K key, V value, long lifespan, TimeUnit lifespanUnit, long maxIdleTime, TimeUnit maxIdleTimeUnit) {
        return null;  // TODO: Customise this generated block
    }

    @Override
    public V putIfAbsent(K key, V value, long lifespan, TimeUnit lifespanUnit, long maxIdleTime, TimeUnit maxIdleTimeUnit) {
        return null;  // TODO: Customise this generated block
    }

    @Override
    public void putAll(Map<? extends K, ? extends V> map, long lifespan, TimeUnit lifespanUnit, long maxIdleTime, TimeUnit maxIdleTimeUnit) {
        // TODO: Customise this generated block
    }

    @Override
    public V replace(K key, V value, long lifespan, TimeUnit lifespanUnit, long maxIdleTime, TimeUnit maxIdleTimeUnit) {
        return null;  // TODO: Customise this generated block
    }

    @Override
    public boolean replace(K key, V oldValue, V value, long lifespan, TimeUnit lifespanUnit, long maxIdleTime, TimeUnit maxIdleTimeUnit) {
        return false;  // TODO: Customise this generated block
    }

    @Override
    public V remove(Object key) {
        return null;  // TODO: Customise this generated block
    }

    @Override
    public void putAll(Map<? extends K, ? extends V> map) {
        // TODO: Customise this generated block
    }

    @Override
    public void clear() {
        delegate.clear();
    }

    @Override
    public Set<K> keySet() {
        return delegate.keySet();
    }

    @Override
    public Collection<V> values() {
        return null;  // TODO: Customise this generated block
    }

    @Override
    public Set<Entry<K, V>> entrySet() {
        return null;  // TODO: Customise this generated block
    }

    @Override
    public V putIfAbsent(K k, V v) {
        return null;  // TODO: Customise this generated block
    }

    @Override
    public boolean remove(Object o, Object o2) {
        return false;  // TODO: Customise this generated block
    }

    @Override
    public boolean replace(K k, V v, V v2) {
        return false;  // TODO: Customise this generated block
    }

    @Override
    public V replace(K k, V v) {
        return null;  // TODO: Customise this generated block
    }

    @Override
    public void start() {
        delegate.start();
    }

    @Override
    public void stop() {
        delegate.stop();
    }

    @Override
    public String toString(){
        return site.toString();
    }
}
